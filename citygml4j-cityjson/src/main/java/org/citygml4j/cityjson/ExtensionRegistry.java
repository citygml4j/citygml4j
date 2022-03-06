/*
 * citygml4j-cityjson - CityJSON module for citygml4j
 * https://github.com/citygml4j/citygml4j-cityjson
 *
 * citygml4j-cityjson is part of the citygml4j project
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

package org.citygml4j.cityjson;

import org.atteo.classindex.ClassFilter;
import org.atteo.classindex.ClassIndex;
import org.citygml4j.cityjson.extension.Extension;
import org.citygml4j.cityjson.extension.ExtensionException;
import org.citygml4j.cityjson.model.CityJSONVersion;

import java.lang.reflect.Modifier;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ExtensionRegistry {
    private static ExtensionRegistry instance;
    private final Map<String, Extension> extensions = new ConcurrentHashMap<>();
    private final Map<CityJSONContext, Boolean> listeners = Collections.synchronizedMap(new WeakHashMap<>());

    private ExtensionRegistry() {
    }

    public static synchronized ExtensionRegistry getInstance() {
        if (instance == null) {
            instance = new ExtensionRegistry();
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

    public void loadExtension(Extension extension) throws ExtensionException {
        if (extension.getName() == null) {
            throw new ExtensionException("The name of extension " + extension.getClass().getName() + " must not be null.");
        }

        if (extension.getCityJSONVersion() == null) {
            throw new ExtensionException("The CityJSON version of extension " + extension.getClass().getName() + " must not be null.");
        }

        Extension current = extensions.get(extension.getName());
        if (current != null && current.getCityJSONVersion() == extension.getCityJSONVersion()) {
            throw new ExtensionException("An extension has already been registered for the name '" + extension.getName() +
                    "' and the CityJSON version " + extension.getCityJSONVersion() + ".");
        }

        extensions.put(extension.getName(), extension);

        for (CityJSONContext listener : listeners.keySet()) {
            listener.loadExtension(extension);
        }
    }

    public void loadExtension(Class<? extends Extension> type) throws ExtensionException {
        loadExtension(newInstance(type));
    }

    public void loadExtensions(ClassLoader classLoader) throws ExtensionException {
        for (Class<? extends Extension> type : ClassFilter.only()
                .withoutModifiers(Modifier.ABSTRACT)
                .from(ClassIndex.getSubclasses(Extension.class, classLoader))) {
            loadExtension(type);
        }
    }

    public void unloadExtension(String name) {
        if (extensions.remove(name) != null) {
            listeners.keySet().forEach(v -> v.unloadExtension(name));
        }
    }

    public void unloadExtension(Extension extension) {
        if (extension.getName() != null) {
            unloadExtension(extension.getName());
        }
    }

    public void unloadExtension(Class<? extends Extension> type) throws ExtensionException {
        unloadExtension(newInstance(type));
    }

    public void unloadExtensions(ClassLoader classLoader) throws ExtensionException {
        for (Class<? extends Extension> type : ClassFilter.only()
                .withoutModifiers(Modifier.ABSTRACT)
                .from(ClassIndex.getSubclasses(Extension.class, classLoader))) {
            unloadExtension(type);
        }
    }

    private Extension newInstance(Class<? extends Extension> type) throws ExtensionException {
        try {
            return type.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new ExtensionException("The extension " + type.getName() + " lacks a default constructor.", e);
        }
    }

    void addListener(CityJSONContext context) {
        listeners.put(context, Boolean.TRUE);
    }
}
