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

package org.citygml4j.xml.module;

import java.util.Objects;

public abstract class Module {
    private final String namespaceURI;
    private final String namespacePrefix;
    private final String schemaLocation;

    public Module(String namespaceURI, String namespacePrefix, String schemaLocation) {
        this.namespaceURI = Objects.requireNonNull(namespaceURI, "The namespace URI must not be null.");
        this.namespacePrefix = Objects.requireNonNull(namespacePrefix, "The namespace prefix must not be null.");
        this.schemaLocation = schemaLocation;
    }

    public Module(String namespaceURI, String namespacePrefix) {
        this(namespaceURI, namespacePrefix, null);
    }

    public final String getNamespaceURI() {
        return namespaceURI;
    }

    public final String getNamespacePrefix() {
        return namespacePrefix;
    }

    public final boolean isSetSchemaLocation() {
        return schemaLocation != null && !schemaLocation.isEmpty();
    }

    public final String getSchemaLocation() {
        return schemaLocation;
    }
}
