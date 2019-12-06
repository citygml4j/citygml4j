package org.citygml4j;

import org.citygml4j.xml.ade.ADEException;
import org.citygml4j.xml.reader.CityGMLInputFactory;
import org.citygml4j.xml.writer.CityGMLOutputFactory;
import org.xmlobjects.XMLObjects;
import org.xmlobjects.XMLObjectsException;

public class CityGMLContext {
    private final XMLObjects xmlObjects;

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
}
