package org.citygml4j.model.ade.generic;

import org.citygml4j.model.dynamizer.ADEOfTabulatedFileTimeseries;
import org.w3c.dom.Element;

public class GenericADEOfTabulatedFileTimeseries extends ADEOfTabulatedFileTimeseries implements ADEGenericContainer {
    private Element value;

    private GenericADEOfTabulatedFileTimeseries(Element value) {
        this.value = value;
    }

    public static GenericADEOfTabulatedFileTimeseries of(Element value) {
        return new GenericADEOfTabulatedFileTimeseries(value);
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
