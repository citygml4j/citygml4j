/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.schema;

import org.citygml4j.core.ade.ADERegistry;
import org.citygml4j.xml.CityGMLADELoader;
import org.citygml4j.xml.CityGMLContext;
import org.citygml4j.xml.module.ade.ADEModule;
import org.xmlobjects.schema.SchemaHandler;
import org.xmlobjects.schema.SchemaHandlerException;
import org.xmlobjects.util.xml.SecureXMLProcessors;

import javax.xml.parsers.SAXParserFactory;
import java.net.URL;

public class CityGMLSchemaHandler extends SchemaHandler {
    private static CityGMLSchemaHandler instance;

    private CityGMLSchemaHandler(SAXParserFactory factory) {
        super(factory);
    }

    public static synchronized CityGMLSchemaHandler newInstance(SAXParserFactory factory) throws SchemaHandlerException {
        if (instance == null) {
            instance = new CityGMLSchemaHandler(factory);
            URL schemaResource = CityGMLContext.class.getResource("/org/citygml4j/schemas/citygml4j.xsd");
            if (schemaResource == null) {
                throw new SchemaHandlerException("Failed to find resource citygml4j.xsd.");
            }

            instance.parseSchema(schemaResource);
        }

        CityGMLSchemaHandler schemaHandler = new CityGMLSchemaHandler(factory);
        schemaHandler.schemas.putAll(instance.schemas);
        schemaHandler.visitedSchemaLocations.putAll(instance.visitedSchemaLocations);

        CityGMLADELoader loader = ADERegistry.getInstance().getADELoader(CityGMLADELoader.class);
        for (ADEModule module : loader.getADEModules()) {
            URL schemaResource = module.getSchemaResource();
            if (schemaResource != null) {
                schemaHandler.parseSchema(schemaResource);
            }
        }

        return schemaHandler;
    }

    public static synchronized CityGMLSchemaHandler newInstance() throws SchemaHandlerException {
        try {
            return newInstance(SecureXMLProcessors.newSAXParserFactory());
        } catch (Exception e) {
            throw new SchemaHandlerException("Caused by:", e);
        }
    }
}
