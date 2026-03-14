/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml;

import org.citygml4j.core.ade.ADEException;
import org.citygml4j.core.ade.ADELoader;
import org.citygml4j.core.model.CityGMLVersion;
import org.citygml4j.xml.ade.CityGMLADE;
import org.citygml4j.xml.module.ade.ADEModule;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class CityGMLADELoader extends ADELoader<CityGMLADE> {
    private final Map<CityGMLVersion, Map<String, ADEModule>> modules = new ConcurrentHashMap<>();
    private final Map<CityGMLContext, Boolean> listeners = Collections.synchronizedMap(new WeakHashMap<>());

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
            if (module != null) {
                return module;
            }
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

    @Override
    protected void loadADE(CityGMLADE ade) throws ADEException {
        List<ADEModule> modules = ade.getADEModules();
        if (modules == null || modules.isEmpty()) {
            throw new ADEException("No ADE modules defined for the ADE " + ade.getClass().getName() + ".");
        }

        for (ADEModule module : modules) {
            if (module.getNamespaceURI() == null || module.getNamespaceURI().isEmpty()) {
                throw new ADEException("The ADE " + ade.getClass().getName() + " defines an ADE module without a namespace URI.");
            }

            if (module.getCityGMLVersion() == null) {
                throw new ADEException("The ADE " + ade.getClass().getName() + " defines an ADE module without a CityGML version.");
            }

            if (this.modules.getOrDefault(module.getCityGMLVersion(), Collections.emptyMap()).get(module.getNamespaceURI()) != null) {
                throw new ADEException("An ADE module has already been registered for the namespace '" + module.getNamespaceURI() +
                        "' and the CityGML version " + module.getCityGMLVersion() + ".");
            }

            this.modules.computeIfAbsent(module.getCityGMLVersion(), v -> new ConcurrentHashMap<>()).put(module.getNamespaceURI(), module);
        }

        for (CityGMLContext listener : listeners.keySet()) {
            listener.loadADE(ade);
        }
    }

    @Override
    protected void unloadADE(CityGMLADE ade) throws ADEException {
        for (ADEModule module : ade.getADEModules()) {
            modules.getOrDefault(module.getCityGMLVersion(), Collections.emptyMap()).remove(module.getNamespaceURI());
        }

        listeners.keySet().forEach(v -> v.unloadADE(ade));
    }

    void addListener(CityGMLContext context) {
        listeners.put(context, Boolean.TRUE);
    }
}
