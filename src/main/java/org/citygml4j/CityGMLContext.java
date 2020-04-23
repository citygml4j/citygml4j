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
