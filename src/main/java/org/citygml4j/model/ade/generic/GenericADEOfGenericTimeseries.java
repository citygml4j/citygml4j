package org.citygml4j.model.ade.generic;

import org.citygml4j.model.dynamizer.ADEOfGenericTimeseries;
import org.w3c.dom.Element;

public class GenericADEOfGenericTimeseries extends ADEOfGenericTimeseries implements ADEGenericContainer {
    private Element value;

    private GenericADEOfGenericTimeseries(Element value) {
        this.value = value;
    }

    public static GenericADEOfGenericTimeseries of(Element value) {
        return new GenericADEOfGenericTimeseries(value);
    }

    @Override
    public Element getValue() {
        return value;
    }

    @Override
    public void setValue(Element value) {
        this.value = value;
    }
}
