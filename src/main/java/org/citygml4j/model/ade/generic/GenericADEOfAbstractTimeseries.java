package org.citygml4j.model.ade.generic;

import org.citygml4j.model.dynamizer.ADEOfAbstractTimeseries;
import org.w3c.dom.Element;

public class GenericADEOfAbstractTimeseries extends ADEOfAbstractTimeseries implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfAbstractTimeseries() {
    }

    public GenericADEOfAbstractTimeseries(Element value) {
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
