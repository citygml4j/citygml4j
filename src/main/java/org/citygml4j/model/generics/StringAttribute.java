package org.citygml4j.model.generics;

import org.citygml4j.model.core.AbstractGenericAttribute;

public class StringAttribute extends AbstractGenericAttribute<String> {

    public StringAttribute() {
    }

    public StringAttribute(String name, String value) {
        super(name, value);
    }
}
