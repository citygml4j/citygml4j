package org.citygml4j;

import org.atteo.classindex.ClassFilter;
import org.atteo.classindex.ClassIndex;
import org.citygml4j.model.CityGMLVersion;
import org.citygml4j.xml.ade.ADEContext;
import org.citygml4j.xml.ade.ADEException;
import org.citygml4j.xml.module.ade.ADEModule;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ADERegistry {
    private static ADERegistry instance;
    private final Map<String, ADEContext> contexts;
    private final Map<CityGMLVersion, Map<String, ADEModule>> modules;

    private ADERegistry() {
        contexts = new ConcurrentHashMap<>();
        modules = new ConcurrentHashMap<>();
    }

    public static synchronized ADERegistry getInstance() {
        if (instance == null)
            instance = new ADERegistry();

        return instance;
    }

    public boolean hasADEContexts() {
        return !contexts.isEmpty();
    }

    public List<ADEContext> getADEContexts() {
        return new ArrayList<>(contexts.values());
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

    void loadADEContexts(ClassLoader classLoader) throws ADEException {
        for (Class<? extends ADEContext> type : ClassFilter.only()
                .withoutModifiers(Modifier.ABSTRACT)
                .from(ClassIndex.getSubclasses(ADEContext.class, classLoader))) {
            if (contexts.containsKey(type.getName()))
                continue;

            ADEContext adeContext;
            try {
                adeContext = type.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                throw new ADEException("The ADE context " + type.getName() + " lacks a default constructor.", e);
            }

            List<ADEModule> modules = adeContext.getADEModules();
            if (modules == null || modules.isEmpty())
                throw new ADEException("No ADE module defined for the ADE context " + type.getName() + ".");

            for (ADEModule module : modules) {
                if (module.getNamespaceURI() == null || module.getNamespaceURI().isEmpty())
                    throw new ADEException("The ADE context " + type.getName() + " defines an ADE module without a namespace URI.");

                if (module.getCityGMLVersion() == null)
                    throw new ADEException("The ADE context " + type.getName() + " defines an ADE module without a CityGML version.");

                if (this.modules.getOrDefault(module.getCityGMLVersion(), Collections.emptyMap()).get(module.getNamespaceURI()) != null) {
                    throw new ADEException("An ADE module has already been registered for the namespace '" + module.getNamespaceURI() +
                            "' and the CityGML version " + module.getCityGMLVersion() + ".");
                }

                this.modules.computeIfAbsent(module.getCityGMLVersion(), v -> new ConcurrentHashMap<>()).put(module.getNamespaceURI(), module);
            }

            contexts.put(adeContext.getClass().getName(), adeContext);
        }
    }
}
