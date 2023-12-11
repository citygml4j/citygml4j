/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2023 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.citygml4j.core.ade;

import org.atteo.classindex.ClassIndex;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ADERegistry {
    private static ADERegistry instance;
    private final Map<String, ADE> ades = new ConcurrentHashMap<>();
    private final Map<Class<ADE>, ADELoader<ADE>> loaders = new ConcurrentHashMap<>();

    private ADERegistry() {
    }

    public static synchronized ADERegistry getInstance() {
        if (instance == null) {
            instance = new ADERegistry();

            try {
                instance.loadADELoaders(ADERegistry.class.getClassLoader(), true);
            } catch (ADEException e) {
                throw new RuntimeException("Failed to load ADE loaders.", e);
            }
        }

        return instance;
    }

    public boolean hasADEs() {
        return !ades.isEmpty();
    }

    public boolean hasADEs(Class<? extends ADE> type) {
        return ades.values().stream().anyMatch(type::isInstance);
    }

    public List<ADE> getADEs() {
        return new ArrayList<>(ades.values());
    }

    public <T extends ADE> List<T> getADEs(Class<T> type) {
        return ades.values().stream()
                .filter(type::isInstance)
                .map(type::cast)
                .collect(Collectors.toList());
    }

    public void loadADE(ADE ade) throws ADEException {
        Class<? extends ADE> type = ade.getClass();
        ADE current = ades.put(type.getName(), ade);
        if (current != null) {
            throw new ADEException("An ADE of type " + type.getName() + " is already loaded.");
        }

        ADELoader<ADE> loader = getADELoaderFor(type);
        if (loader != null) {
            loader.loadADE(ade);
        }
    }

    public void loadADE(Class<? extends ADE> type) throws ADEException {
        try {
            loadADE(type.getDeclaredConstructor().newInstance());
        } catch (Exception e) {
            throw new ADEException("The ADE " + type.getName() + " lacks a default constructor.", e);
        }
    }

    public void loadADEs(ClassLoader classLoader) throws ADEException {
        for (Class<? extends ADE> type : ClassIndex.getSubclasses(ADE.class, classLoader).stream()
                .filter(c -> !Modifier.isAbstract(c.getModifiers()))
                .toList()) {
            loadADE(type);
        }
    }

    public void loadADEs() throws ADEException {
        loadADEs(ADERegistry.class.getClassLoader());
    }

    public void unloadADE(Class<? extends ADE> type) throws ADEException {
        ADE ade = ades.remove(type.getName());
        if (ade != null) {
            ADELoader<ADE> loader = getADELoaderFor(type);
            if (loader != null) {
                loader.unloadADE(ade);
            }
        }
    }

    public void unloadADE(ADE ade) throws ADEException {
        unloadADE(ade.getClass());
    }

    public void unloadADEs(ClassLoader classLoader) throws ADEException {
        for (Class<? extends ADE> type : ClassIndex.getSubclasses(ADE.class, classLoader).stream()
                .filter(c -> !Modifier.isAbstract(c.getModifiers()))
                .toList()) {
            unloadADE(type);
        }
    }

    public <T extends ADELoader<?>> T getADELoader(Class<T> type) {
        for (ADELoader<?> loader : loaders.values()) {
            if (type.isInstance(loader)) {
                return type.cast(loader);
            }
        }

        return null;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public void loadADELoaders(ClassLoader classLoader, boolean failOnDuplicates) throws ADEException {
        for (Class<? extends ADELoader> type : ClassIndex.getSubclasses(ADELoader.class, classLoader).stream()
                .filter(c -> !Modifier.isAbstract(c.getModifiers()))
                .toList()) {
            ADELoader<ADE> loader;
            try {
                loader = type.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                throw new ADEException("The ADE loader " + type.getName() + " lacks a default constructor.", e);
            }

            registerADELoader(loader, findADEType(loader), failOnDuplicates);
        }
    }

    @SuppressWarnings("unchecked")
    public <T extends ADE> void registerADELoader(ADELoader<T> loader, Class<T> type, boolean failOnDuplicates) throws ADEException {
        ADELoader<ADE> current = getADELoaderFor(type);
        if (current == null || !failOnDuplicates) {
            loaders.put((Class<ADE>) type, (ADELoader<ADE>) loader);
            for (T ade : getADEs(type)) {
                loader.loadADE(ade);
            }
        } else {
            throw new ADEException("A loader for the ADE type " + type.getName() + " has already been registered.");
        }
    }

    private ADELoader<ADE> getADELoaderFor(Class<? extends ADE> type) {
        for (Map.Entry<Class<ADE>, ADELoader<ADE>> entry : loaders.entrySet()) {
            if (entry.getKey().isAssignableFrom(type)) {
                return entry.getValue();
            }
        }

        return null;
    }

    @SuppressWarnings("unchecked")
    private Class<ADE> findADEType(ADELoader<?> loader) throws ADEException {
        Class<?> clazz = loader.getClass();
        Class<ADE> adeType = null;

        for (Method method : clazz.getDeclaredMethods()) {
            if (!method.isSynthetic() && Modifier.isProtected(method.getModifiers())) {
                Class<ADE> candidateType = null;
                Type[] parameters;

                switch (method.getName()) {
                    case "loadADE":
                    case "unloadADE":
                        parameters = method.getGenericParameterTypes();
                        if (parameters.length == 1
                                && parameters[0] instanceof Class<?> type
                                && ADE.class.isAssignableFrom(type)) {
                            candidateType = (Class<ADE>) parameters[0];
                        }
                        break;
                }

                if (candidateType != null) {
                    if (adeType != null && candidateType != adeType) {
                        throw new ADEException("The ADE loader " + clazz.getName() +
                                " uses different ADE types: " +
                                adeType.getName() + " and " + candidateType.getName() + ".");
                    }

                    adeType = candidateType;
                }
            }
        }

        if (adeType == null) {
            throw new ADEException("The ADE loader " + clazz.getName() + " must implement " +
                    "the methods loadADE and unloadADE.");
        }

        return adeType;
    }
}
