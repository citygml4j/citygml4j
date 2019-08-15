package org.citygml4j.model.deprecated;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.GMLObject;

public class ExternalObject extends GMLObject implements CityGMLObject {
    private String name;
    private String uri;

    public ExternalObject() {
    }

    public static ExternalObject ofName(String name) {
        ExternalObject externalObject = new ExternalObject();
        externalObject.setName(name);
        return externalObject;
    }

    public static ExternalObject ofURI(String uri) {
        ExternalObject externalObject = new ExternalObject();
        externalObject.setURI(uri);
        return externalObject;
    }

    public String getName() {
        return name;
    }

    public boolean isSetName() {
        return name != null;
    }

    public void setName(String name) {
        this.name = name;
        uri = null;
    }

    public String getURI() {
        return uri;
    }

    public boolean isSetURI() {
        return uri != null;
    }

    public void setURI(String uri) {
        this.uri = uri;
        name = null;
    }
}
