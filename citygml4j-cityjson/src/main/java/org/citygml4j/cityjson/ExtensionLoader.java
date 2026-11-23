/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson;

import org.citygml4j.cityjson.extension.Extension;
import org.citygml4j.cityjson.model.CityJSONVersion;
import org.citygml4j.core.ade.ADEException;
import org.citygml4j.core.ade.ADELoader;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ExtensionLoader extends ADELoader<Extension> {
    private final Map<Key, Extension> extensions = new ConcurrentHashMap<>();
    private final Map<CityJSONContext, Boolean> listeners = Collections.synchronizedMap(new WeakHashMap<>());

    private record Key(String name, CityJSONVersion version) {
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
        // prefer the most recent CityJSON version if the extension is registered for several versions
        for (CityJSONVersion version : CityJSONVersion.values()) {
            Extension extension = extensions.get(new Key(name, version));
            if (extension != null) {
                return extension;
            }
        }

        return null;
    }

    public Extension getExtension(String name, CityJSONVersion version) {
        return extensions.get(new Key(name, version));
    }

    public Set<String> getExtensionNames() {
        return extensions.keySet().stream()
                .map(Key::name)
                .collect(Collectors.toSet());
    }

    boolean hasExtension(String name, CityJSONVersion version) {
        return extensions.containsKey(new Key(name, version));
    }

    @Override
    protected void loadADE(Extension extension) throws ADEException {
        if (extension.getName() == null) {
            throw new ADEException("The name of extension " + extension.getClass().getName() + " must not be null.");
        }

        if (extension.getCityJSONVersion() == null) {
            throw new ADEException("The CityJSON version of extension " + extension.getClass().getName() + " must not be null.");
        }

        if (extensions.putIfAbsent(new Key(extension.getName(), extension.getCityJSONVersion()), extension) != null) {
            throw new ADEException("An extension has already been registered for the name '" + extension.getName() +
                    "' and the CityJSON version " + extension.getCityJSONVersion() + ".");
        }

        try {
            for (CityJSONContext listener : getListeners()) {
                listener.loadExtension(extension);
            }
        } catch (ADEException | RuntimeException e) {
            unloadADE(extension);
            throw e;
        }
    }

    @Override
    protected void unloadADE(Extension extension) throws ADEException {
        if (extensions.remove(new Key(extension.getName(), extension.getCityJSONVersion()), extension)) {
            getListeners().forEach(v -> v.unloadExtension(extension));
        }
    }

    void addListener(CityJSONContext context) {
        listeners.put(context, Boolean.TRUE);
    }

    private List<CityJSONContext> getListeners() {
        synchronized (listeners) {
            return new ArrayList<>(listeners.keySet());
        }
    }
}
