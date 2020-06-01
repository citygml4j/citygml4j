package org.citygml4j.model.ade.generic;

import org.citygml4j.model.dynamizer.ADEOfStandardFileTimeseries;
import org.w3c.dom.Element;

public class GenericADEOfStandardFileTimeseries extends ADEOfStandardFileTimeseries implements ADEGenericPropertyContainer {
    private Element value;

    private GenericADEOfStandardFileTimeseries(Element value) {
        this.value = value;
    }

    public static GenericADEOfStandardFileTimeseries of(Element value) {
        return new GenericADEOfStandardFileTimeseries(value);
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
