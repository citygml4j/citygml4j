package org.citygml4j.cityjson;

import org.citygml4j.cityjson.extension.Extension;
import org.citygml4j.cityjson.model.CityJSONVersion;
import org.citygml4j.core.ade.ADEException;
import org.citygml4j.core.ade.ADELoader;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ExtensionLoader extends ADELoader<Extension> {
    private static ExtensionLoader instance;
    private final Map<String, Extension> extensions = new ConcurrentHashMap<>();
    private final Map<CityJSONContext, Boolean> listeners = Collections.synchronizedMap(new WeakHashMap<>());

    public static ExtensionLoader getInstance() {
        if (instance == null) {
            instance = new ExtensionLoader();
        }

        return instance;
    }

    public boolean hasExtensions() {
        return !extensions.isEmpty();
    }

    public List<Extension> getExtensions() {
        return new ArrayList<>(extensions.values());
    }

    public List<Extension> getExtensions(CityJSONVersion version) {
        return extensions.values().stream()
                .filter(v -> v.getCityJSONVersion() == version)
                .collect(Collectors.toList());
    }

    public Extension getExtension(String name) {
        return extensions.get(name);
    }

    public Extension getExtension(String name, CityJSONVersion version) {
        Extension extension = extensions.get(name);
        return extension.getCityJSONVersion() == version ? extension : null;
    }

    public Set<String> getExtensionNames() {
        return new HashSet<>(extensions.keySet());
    }

    @Override
    protected void loadADE(Extension extension) throws ADEException {
        if (extension.getName() == null) {
            throw new ADEException("The name of extension " + extension.getClass().getName() + " must not be null.");
        }

        if (extension.getCityJSONVersion() == null) {
            throw new ADEException("The CityJSON version of extension " + extension.getClass().getName() + " must not be null.");
        }

        Extension current = extensions.get(extension.getName());
        if (current != null && current.getCityJSONVersion() == extension.getCityJSONVersion()) {
            throw new ADEException("An extension has already been registered for the name '" + extension.getName() +
                    "' and the CityJSON version " + extension.getCityJSONVersion() + ".");
        }

        extensions.put(extension.getName(), extension);

        for (CityJSONContext listener : listeners.keySet()) {
            listener.loadExtension(extension);
        }
    }

    @Override
    protected void unloadADE(Extension extension) throws ADEException {
        if (extensions.remove(extension.getName()) != null) {
            listeners.keySet().forEach(v -> v.unloadExtension(extension));
        }
    }

    void addListener(CityJSONContext context) {
        listeners.put(context, Boolean.TRUE);
    }
}