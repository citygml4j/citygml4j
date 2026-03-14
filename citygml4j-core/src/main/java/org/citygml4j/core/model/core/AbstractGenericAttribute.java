/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.core;

import org.citygml4j.core.model.CityGMLObject;
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

    public boolean isSetValue() {
        return value != null;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
