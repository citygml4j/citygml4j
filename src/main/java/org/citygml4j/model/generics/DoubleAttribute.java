package org.citygml4j.model.generics;

import org.citygml4j.model.core.AbstractGenericAttribute;

public class DoubleAttribute extends AbstractGenericAttribute<Double> {

    public DoubleAttribute() {
    }

    public DoubleAttribute(String name, Double value) {
        super(name, value);
    }
}
