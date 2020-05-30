package org.citygml4j.model.ade.generic;

import org.citygml4j.model.dynamizer.ADEOfTabulatedFileTimeseries;
import org.w3c.dom.Element;

public class GenericADEOfTabulatedFileTimeseries extends ADEOfTabulatedFileTimeseries implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfTabulatedFileTimeseries() {
    }

    public GenericADEOfTabulatedFileTimeseries(Element value) {
        this.value = value;
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
