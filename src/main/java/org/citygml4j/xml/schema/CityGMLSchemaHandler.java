package org.citygml4j.xml.schema;

import org.citygml4j.ADERegistry;
import org.citygml4j.CityGMLContext;
import org.citygml4j.xml.ade.ADEContext;
import org.citygml4j.xml.module.ade.ADEModule;
import org.xmlobjects.schema.SchemaHandler;
import org.xmlobjects.schema.SchemaHandlerException;

import java.net.URL;

public class CityGMLSchemaHandler extends SchemaHandler {
    private static CityGMLSchemaHandler instance;

    private CityGMLSchemaHandler() {
    }

    public static synchronized CityGMLSchemaHandler newInstance() throws SchemaHandlerException {
        if (instance == null) {
            instance = new CityGMLSchemaHandler();
            instance.parseSchema(CityGMLContext.class.getResource("/org/citygml4j/schemas/citygml4j.xsd"));
        }

        CityGMLSchemaHandler schemaHandler = new CityGMLSchemaHandler();
        schemaHandler.schemas.putAll(instance.schemas);
        schemaHandler.visitedSchemaLocations.putAll(instance.visitedSchemaLocations);

        ADERegistry registry = ADERegistry.getInstance();
        if (registry.hasADEContexts()) {
            for (ADEContext context : registry.getADEContexts()) {
                for (ADEModule module : context.getADEModules()) {
                    URL schemaResource = module.getSchemaResource();
                    if (schemaResource != null)
                        schemaHandler.parseSchema(schemaResource);
                }
            }
        }

        return schemaHandler;
    }
}
