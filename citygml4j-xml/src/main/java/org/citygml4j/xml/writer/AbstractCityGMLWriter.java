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

package org.citygml4j.xml.writer;

import org.citygml4j.core.model.CityGMLVersion;
import org.citygml4j.xml.module.Module;
import org.citygml4j.xml.module.ade.ADEModule;
import org.citygml4j.xml.module.citygml.CityGMLModule;
import org.citygml4j.xml.module.citygml.CityGMLModules;
import org.citygml4j.xml.module.citygml.CoreModule;
import org.citygml4j.xml.module.gml.GMLCompactEncodingModule;
import org.citygml4j.xml.module.gml.GMLExtendedBaseTypesModule;
import org.citygml4j.xml.transform.TransformerPipeline;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.stream.XMLWriterFactory;
import org.xmlobjects.xml.Namespaces;

public abstract class AbstractCityGMLWriter<T extends AbstractCityGMLWriter<?>> implements AutoCloseable {
    final XMLWriter writer;
    final CityGMLVersion version;
    final XMLWriterFactory factory;
    final Namespaces namespaces;

    TransformerPipeline transformer;

    AbstractCityGMLWriter(XMLWriter writer, CityGMLVersion version, XMLWriterFactory factory) {
        this.writer = writer;
        this.version = version;
        this.factory = factory;

        namespaces = Namespaces.newInstance();
        for (Module module : CityGMLModules.of(version).getModules())
            namespaces.add(module.getNamespaceURI());

        if (version == CityGMLVersion.v3_0) {
            namespaces.add(GMLCompactEncodingModule.v3_3.getNamespaceURI())
                    .add(GMLExtendedBaseTypesModule.v3_3.getNamespaceURI());
        }
    }

    public String getPrefix(String namespaceURI) {
        return writer.getPrefix(namespaceURI);
    }

    @SuppressWarnings("unchecked")
    public T withPrefix(String prefix, String namespaceURI) {
        writer.withPrefix(prefix,namespaceURI);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public T withDefaultPrefixes() {
        for (Module module : CityGMLModules.of(version).getModules())
            withPrefix(module.getNamespacePrefix(), module.getNamespaceURI());

        return (T) this;
    }

    public String getNamespaceURI(String prefix) {
        return writer.getNamespaceURI(prefix);
    }

    @SuppressWarnings("unchecked")
    public T withDefaultNamespace(String namespaceURI) {
        writer.withDefaultNamespace(namespaceURI);
        return (T) this;
    }

    public String getIndent() {
        return writer.getIndent();
    }

    @SuppressWarnings("unchecked")
    public T withIndent(String indent) {
        writer.withIndent(indent);
        return (T) this;
    }

    public boolean isWriteXMLDeclaration() {
        return writer.isWriteXMLDeclaration();
    }

    @SuppressWarnings("unchecked")
    public T writeXMLDeclaration(boolean writeXMLDeclaration) {
        writer.writeXMLDeclaration(writeXMLDeclaration);
        return (T) this;
    }

    public String[] getHeaderComment() {
        return writer.getHeaderComment();
    }

    @SuppressWarnings("unchecked")
    public T withHeaderComment(String... headerComment) {
        writer.withHeaderComment(headerComment);
        return (T) this;
    }

    public String getSchemaLocation(String namespaceURI) {
        return writer.getSchemaLocation(namespaceURI);
    }

    @SuppressWarnings("unchecked")
    public T withSchemaLocation(String namespaceURI, String schemaLocation) {
        writer.withSchemaLocation(namespaceURI, schemaLocation);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public T withDefaultSchemaLocations() {
        for (Module module : CityGMLModules.of(version).getModules()) {
            if (module.isSetSchemaLocation()
                    && ((module instanceof CityGMLModule && !(module instanceof CoreModule))
                    || module instanceof ADEModule))
                writer.withSchemaLocation(module.getNamespaceURI(), module.getSchemaLocation());
        }

        return (T) this;
    }

    public void flush() throws CityGMLWriteException {
        try {
            writer.flush();
        } catch (XMLWriteException e) {
            throw new CityGMLWriteException("Caused by:", e);
        }
    }

    @Override
    public void close() throws CityGMLWriteException {
        try {
            writer.close();
        } catch (XMLWriteException e) {
            throw new CityGMLWriteException("Caused by:", e);
        }
    }
}
