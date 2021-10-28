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

import org.citygml4j.model.CityGMLVersion;
import org.citygml4j.xml.ade.ADEContext;
import org.citygml4j.xml.ade.ADEException;
import org.citygml4j.xml.module.ade.ADEModule;
import org.citygml4j.xml.module.citygml.CityGMLModules;
import org.citygml4j.xml.reader.CityGMLInputFactory;
import org.citygml4j.xml.reader.CityGMLReadException;
import org.citygml4j.xml.schema.CityGMLSchemaHandler;
import org.citygml4j.xml.writer.CityGMLOutputFactory;
import org.xmlobjects.XMLObjects;
import org.xmlobjects.XMLObjectsException;
import org.xmlobjects.schema.SchemaHandlerException;

import java.util.Set;

public class CityGMLContext {
    private final XMLObjects xmlObjects;
    private CityGMLSchemaHandler schemaHandler;

    private CityGMLContext(ClassLoader classLoader) throws CityGMLContextException {
        try {
            xmlObjects = XMLObjects.newInstance(classLoader);

            // load ADE objects registered with the ADE registry
            ADERegistry registry = ADERegistry.getInstance();
            for (ADEContext context : registry.getADEContexts()) {
                if (context.getClass().getClassLoader() != classLoader)
                    loadADEContext(context);
            }

            // unload ADE objects available from the class loader
            // but not registered with the ADE registry
            Set<String> adeNamespaces = registry.getADENamespaces();
            for (String namespaceURI : xmlObjects.getSerializableNamespaces()) {
                if (!CityGMLModules.isCityGMLNamespace(namespaceURI)
                        && !CityGMLModules.isGMLNamespace(namespaceURI)
                        && !CityGMLModules.isXALNamespace(namespaceURI)
                        && !adeNamespaces.contains(namespaceURI)) {
                    unloadADEObjects(namespaceURI);
                }
            }

            registry.addListener(this);
        } catch (XMLObjectsException | ADEException e) {
            throw new CityGMLContextException("Failed to instantiate XML objects.", e);
        }
    }

    public static CityGMLContext newInstance(ClassLoader classLoader) throws CityGMLContextException {
        return new CityGMLContext(classLoader);
    }

    public static CityGMLContext newInstance() throws CityGMLContextException {
        return newInstance(Thread.currentThread().getContextClassLoader());
    }

    public XMLObjects getXMLObjects() {
        return xmlObjects;
    }

    public CityGMLInputFactory createCityGMLInputFactory() throws CityGMLReadException {
        return new CityGMLInputFactory(this);
    }

    public CityGMLOutputFactory createCityGMLOutputFactory(CityGMLVersion version) {
        return new CityGMLOutputFactory(version, this);
    }

    public CityGMLSchemaHandler getDefaultSchemaHandler() throws SchemaHandlerException {
        if (schemaHandler == null)
            schemaHandler = CityGMLSchemaHandler.newInstance();

        return schemaHandler;
    }

    void loadADEContext(ADEContext context) throws ADEException {
        try {
            loadADEObjects(context.getClass().getClassLoader());
        } catch (XMLObjectsException e) {
            throw new ADEException("Failed to load ADE context.", e);
        }
    }

    void unloadADEContext(ADEContext context) {
        for (ADEModule module : context.getADEModules())
            unloadADEObjects(module.getNamespaceURI());
    }

    private void loadADEObjects(ClassLoader classLoader) throws XMLObjectsException {
        xmlObjects.loadBuilders(classLoader, false);
        xmlObjects.loadSerializers(classLoader, false);
    }

    private void unloadADEObjects(String namespaceURI) {
        xmlObjects.unloadBuilders(namespaceURI);
        xmlObjects.unloadSerializers(namespaceURI);
    }
}
