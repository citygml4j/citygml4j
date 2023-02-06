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

package org.citygml4j.xml;

import org.citygml4j.core.ade.ADEException;
import org.citygml4j.core.ade.ADERegistry;
import org.citygml4j.core.model.CityGMLVersion;
import org.citygml4j.xml.ade.CityGMLADE;
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
        } catch (XMLObjectsException e) {
            throw new CityGMLContextException("Failed to instantiate XML objects.", e);
        }

        try {
            ADERegistry registry = ADERegistry.getInstance();

            // load ADE objects registered with the ADE registry
            for (CityGMLADE ade : registry.getADEs(CityGMLADE.class)) {
                if (ade.getClass().getClassLoader() != classLoader) {
                    loadADE(ade);
                }
            }

            // unload ADE objects available from the class loader
            // but not registered with the ADE registry
            removeUnregisteredADEObjects();

            registry.getADELoader(CityGMLADELoader.class).addListener(this);
        } catch (ADEException e) {
            throw new CityGMLContextException("Failed to load CityGML ADEs.", e);
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

    public CityGMLOutputFactory createCityGMLOutputFactory() {
        return new CityGMLOutputFactory(CityGMLVersion.v3_0, this);
    }

    public CityGMLSchemaHandler getDefaultSchemaHandler() throws SchemaHandlerException {
        if (schemaHandler == null) {
            schemaHandler = CityGMLSchemaHandler.newInstance();
        }

        return schemaHandler;
    }

    void loadADE(CityGMLADE ade) throws ADEException {
        try {
            loadADEObjects(ade.getClass().getClassLoader());
        } catch (XMLObjectsException e) {
            throw new ADEException("Failed to load ADE.", e);
        }
    }

    void unloadADE(CityGMLADE ade) {
        for (ADEModule module : ade.getADEModules()) {
            unloadADEObjects(module.getNamespaceURI());
        }
    }

    private void loadADEObjects(ClassLoader classLoader) throws XMLObjectsException {
        xmlObjects.loadBuilders(classLoader, false);
        xmlObjects.loadSerializers(classLoader, false);
        removeUnregisteredADEObjects();
    }

    private void unloadADEObjects(String namespaceURI) {
        xmlObjects.unloadBuilders(namespaceURI);
        xmlObjects.unloadSerializers(namespaceURI);
    }

    private void removeUnregisteredADEObjects() {
        CityGMLADELoader loader = ADERegistry.getInstance().getADELoader(CityGMLADELoader.class);
        Set<String> adeNamespaces = loader.getADENamespaces();
        for (String namespaceURI : xmlObjects.getSerializableNamespaces()) {
            if (!CityGMLModules.isCityGMLNamespace(namespaceURI)
                    && !CityGMLModules.isGMLNamespace(namespaceURI)
                    && !CityGMLModules.isXALNamespace(namespaceURI)
                    && !adeNamespaces.contains(namespaceURI)) {
                unloadADEObjects(namespaceURI);
            }
        }
    }
}
