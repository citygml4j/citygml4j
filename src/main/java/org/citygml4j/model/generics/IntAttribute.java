package org.citygml4j.model.generics;

import org.citygml4j.model.core.AbstractGenericAttribute;

public class IntAttribute extends AbstractGenericAttribute<Integer> {

    public IntAttribute() {
    }

    public IntAttribute(String name, Integer value) {
        super(name, value);
    }
}
