/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2021 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j;

import org.atteo.classindex.ClassFilter;
import org.atteo.classindex.ClassIndex;
import org.citygml4j.ade.ADE;
import org.citygml4j.ade.ADEException;
import org.citygml4j.model.CityGMLVersion;
import org.citygml4j.xml.module.ade.ADEModule;

import java.lang.reflect.Modifier;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ADERegistry {
    private static ADERegistry instance;
    private final Map<String, ADE> ades = new ConcurrentHashMap<>();
    private final Map<CityGMLVersion, Map<String, ADEModule>> modules = new ConcurrentHashMap<>();
    private final Map<CityGMLContext, Boolean> listeners = Collections.synchronizedMap(new WeakHashMap<>());

    private ADERegistry() {
    }

    public static synchronized ADERegistry getInstance() {
        if (instance == null)
            instance = new ADERegistry();

        return instance;
    }

    public boolean hasADEs() {
        return !ades.isEmpty();
    }

    public List<ADE> getADEs() {
        return new ArrayList<>(ades.values());
    }

    public List<ADEModule> getADEModules() {
        return modules.values().stream()
                .map(Map::values)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public List<ADEModule> getADEModules(CityGMLVersion version) {
        return new ArrayList<>(modules.getOrDefault(version, Collections.emptyMap()).values());
    }

    public ADEModule getADEModule(String namespaceURI) {
        for (Map<String, ADEModule> value : modules.values()) {
            ADEModule module = value.get(namespaceURI);
            if (module != null)
                return module;
        }

        return null;
    }

    public ADEModule getADEModule(String namespaceURI, CityGMLVersion version) {
        return modules.getOrDefault(version, Collections.emptyMap()).get(namespaceURI);
    }

    public Set<String> getADENamespaces() {
        return modules.values().stream()
                .map(Map::keySet)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }

    public void loadADE(ADE ade) throws ADEException {
        List<ADEModule> modules = ade.getADEModules();
        if (modules == null || modules.isEmpty())
            throw new ADEException("No ADE module defined for the ADE " + ade.getClass().getName() + ".");

        for (ADEModule module : modules) {
            if (module.getNamespaceURI() == null || module.getNamespaceURI().isEmpty())
                throw new ADEException("The ADE " + ade.getClass().getName() + " defines an ADE module without a namespace URI.");

            if (module.getCityGMLVersion() == null)
                throw new ADEException("The ADE " + ade.getClass().getName() + " defines an ADE module without a CityGML version.");

            if (this.modules.getOrDefault(module.getCityGMLVersion(), Collections.emptyMap()).get(module.getNamespaceURI()) != null) {
                throw new ADEException("An ADE module has already been registered for the namespace '" + module.getNamespaceURI() +
                        "' and the CityGML version " + module.getCityGMLVersion() + ".");
            }

            this.modules.computeIfAbsent(module.getCityGMLVersion(), v -> new ConcurrentHashMap<>()).put(module.getNamespaceURI(), module);
        }

        for (CityGMLContext listener : listeners.keySet())
            listener.loadADE(ade);

        ades.put(ade.getClass().getName(), ade);
    }

    public void loadADE(Class<? extends ADE> type) throws ADEException {
        ADE ade;
        try {
            ade = type.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new ADEException("The ADE " + type.getName() + " lacks a default constructor.", e);
        }

        loadADE(ade);
    }

    public void loadADEs(ClassLoader classLoader) throws ADEException {
        for (Class<? extends ADE> type : ClassFilter.only()
                .withoutModifiers(Modifier.ABSTRACT)
                .from(ClassIndex.getSubclasses(ADE.class, classLoader))) {
            loadADE(type);
        }
    }

    public void unloadADE(Class<? extends ADE> type) {
        ADE ade = ades.remove(type.getName());
        if (ade != null) {
            for (ADEModule module : ade.getADEModules())
                modules.getOrDefault(module.getCityGMLVersion(), Collections.emptyMap()).remove(module.getNamespaceURI());

            listeners.keySet().forEach(v -> v.unloadADE(ade));
        }
    }

    public void unloadADE(ADE ade) {
        unloadADE(ade.getClass());
    }

    public void unloadADEs(ClassLoader classLoader) {
        for (Class<? extends ADE> type : ClassFilter.only()
                .withoutModifiers(Modifier.ABSTRACT)
                .from(ClassIndex.getSubclasses(ADE.class, classLoader))) {
            unloadADE(type);
        }
    }

    void addListener(CityGMLContext context) {
        listeners.put(context, Boolean.TRUE);
    }
}
