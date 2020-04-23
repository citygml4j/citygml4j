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
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ADERegistry {
    private static ADERegistry instance;
    private final Map<String, ADEContext> contexts = new ConcurrentHashMap<>();
    private final Map<CityGMLVersion, Map<String, ADEModule>> modules = new ConcurrentHashMap<>();
    private final Map<CityGMLContext, Boolean> listeners = Collections.synchronizedMap(new WeakHashMap<>());

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

    public Set<String> getADENamespaces() {
        return modules.values().stream()
                .map(Map::keySet)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }

    public void loadADEContext(ADEContext context) throws ADEException {
        List<ADEModule> modules = context.getADEModules();
        if (modules == null || modules.isEmpty())
            throw new ADEException("No ADE module defined for the ADE context " + context.getClass().getName() + ".");

        for (ADEModule module : modules) {
            if (module.getNamespaceURI() == null || module.getNamespaceURI().isEmpty())
                throw new ADEException("The ADE context " + context.getClass().getName() + " defines an ADE module without a namespace URI.");

            if (module.getCityGMLVersion() == null)
                throw new ADEException("The ADE context " + context.getClass().getName() + " defines an ADE module without a CityGML version.");

            if (this.modules.getOrDefault(module.getCityGMLVersion(), Collections.emptyMap()).get(module.getNamespaceURI()) != null) {
                throw new ADEException("An ADE module has already been registered for the namespace '" + module.getNamespaceURI() +
                        "' and the CityGML version " + module.getCityGMLVersion() + ".");
            }

            this.modules.computeIfAbsent(module.getCityGMLVersion(), v -> new ConcurrentHashMap<>()).put(module.getNamespaceURI(), module);
        }

        for (CityGMLContext listener : listeners.keySet())
            listener.loadADEContext(context);

        contexts.put(context.getClass().getName(), context);
    }

    public void loadADEContext(Class<? extends ADEContext> type) throws ADEException {
        ADEContext context;
        try {
            context = type.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new ADEException("The ADE context " + type.getName() + " lacks a default constructor.", e);
        }

        loadADEContext(context);
    }

    public void loadADEContexts(ClassLoader classLoader) throws ADEException {
        for (Class<? extends ADEContext> type : ClassFilter.only()
                .withoutModifiers(Modifier.ABSTRACT)
                .from(ClassIndex.getSubclasses(ADEContext.class, classLoader))) {
            loadADEContext(type);
        }
    }

    public void unloadADEContext(Class<? extends ADEContext> type) {
        ADEContext context = contexts.remove(type.getName());
        if (context != null) {
            for (ADEModule module : context.getADEModules())
                modules.getOrDefault(module.getCityGMLVersion(), Collections.emptyMap()).remove(module.getNamespaceURI());

            listeners.keySet().forEach(v -> v.unloadADEContext(context));
        }
    }

    public void unloadADEContext(ADEContext context) {
        unloadADEContext(context.getClass());
    }

    public void unloadADEContexts(ClassLoader classLoader) {
        for (Class<? extends ADEContext> type : ClassFilter.only()
                .withoutModifiers(Modifier.ABSTRACT)
                .from(ClassIndex.getSubclasses(ADEContext.class, classLoader))) {
            unloadADEContext(type);
        }
    }

    void addListener(CityGMLContext context) {
        listeners.put(context, Boolean.TRUE);
    }
}
