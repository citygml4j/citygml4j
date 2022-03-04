/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2022 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.ade;

import org.atteo.classindex.ClassFilter;
import org.atteo.classindex.ClassIndex;

import java.lang.reflect.Modifier;
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
        }

        return instance;
    }

    public boolean hasADEs() {
        return !ades.isEmpty();
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
        ADE current = ades.put(ade.getClass().getName(), ade);
        if (current != null) {
            throw new ADEException("An ADE of type " + ade.getClass().getName() + " is already loaded.");
        }

        for (ADELoader<ADE> loader : getADELoaders(ade.getClass())) {
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
        for (Class<? extends ADE> type : ClassFilter.only()
                .withoutModifiers(Modifier.ABSTRACT)
                .from(ClassIndex.getSubclasses(ADE.class, classLoader))) {
            loadADE(type);
        }
    }

    public void unloadADE(Class<? extends ADE> type) throws ADEException {
        ADE ade = ades.remove(type.getName());
        if (ade != null) {
            for (ADELoader<ADE> loader : getADELoaders(type)) {
                loader.unloadADE(ade);
            }
        }
    }

    public void unloadADE(ADE ade) throws ADEException {
        unloadADE(ade.getClass());
    }

    public void unloadADEs(ClassLoader classLoader) throws ADEException {
        for (Class<? extends ADE> type : ClassFilter.only()
                .withoutModifiers(Modifier.ABSTRACT)
                .from(ClassIndex.getSubclasses(ADE.class, classLoader))) {
            unloadADE(type);
        }
    }

    @SuppressWarnings("unchecked")
    public <T extends ADE> void registerADELoader(ADELoader<T> loader, Class<T> type) throws ADEException {
        ADELoader<ADE> current = loaders.get(type);
        if (current == null) {
            loaders.put((Class<ADE>) type, (ADELoader<ADE>) loader);
            for (T ade : getADEs(type)) {
                loader.loadADE(ade);
            }
        } else if (current != loader) {
            throw new ADEException("A loader of type " + loader.getClass().getName() + " has already been registered.");
        }
    }

    private List<ADELoader<ADE>> getADELoaders(Class<? extends ADE> type) {
        return loaders.entrySet().stream()
                .filter(e -> e.getKey().isAssignableFrom(type))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
}
