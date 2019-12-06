package org.citygml4j;

import org.citygml4j.xml.ade.ADEContext;
import org.citygml4j.xml.ade.ADEException;
import org.citygml4j.xml.module.ade.ADEModule;
import org.citygml4j.xml.reader.CityGMLInputFactory;
import org.citygml4j.xml.writer.CityGMLOutputFactory;
import org.xmlobjects.XMLObjects;
import org.xmlobjects.XMLObjectsException;
import org.xmlobjects.schema.SchemaHandler;
import org.xmlobjects.schema.SchemaHandlerException;

import java.net.URL;

public class CityGMLContext {
    private final XMLObjects xmlObjects;
    private SchemaHandler schemaHandler;

    private CityGMLContext(ClassLoader classLoader) throws CityGMLContextException {
        try {
            xmlObjects = XMLObjects.newInstance(classLoader);
            ADERegistry.getInstance().loadADEContexts(classLoader);
        } catch (XMLObjectsException e) {
            throw new CityGMLContextException("Failed to instantiate XML objects.", e);
        } catch (ADEException e) {
            throw new CityGMLContextException("Failed to initialize ADE contexts.", e);
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

    public CityGMLInputFactory createCityGMLInputFactory() {
        return new CityGMLInputFactory(this);
    }

    public CityGMLOutputFactory createCityGMLOutputFactory() {
        return new CityGMLOutputFactory(this);
    }

    public SchemaHandler getDefaultSchemaHandler() throws SchemaHandlerException {
        if (schemaHandler == null) {
            schemaHandler = new SchemaHandler();
            schemaHandler.parseSchema(CityGMLContext.class.getResource("/org/citygml4j/schemas/citygml4j.xsd"));

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
        }

        return schemaHandler;
    }
}
