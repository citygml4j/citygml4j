package org.citygml4j.model.generics;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.GMLObject;

public abstract class AbstractGenericAttribute<T> extends GMLObject implements CityGMLObject {
    private String name;
    private T value;

    public AbstractGenericAttribute() {
    }

    public AbstractGenericAttribute(String name, T value) {
        this.name = name;
        setValue(value);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
