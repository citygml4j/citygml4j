package org.citygml4j.model.ade.generic;

import org.citygml4j.model.dynamizer.ADEOfGenericTimeseries;
import org.w3c.dom.Element;

public class GenericADEOfGenericTimeseries extends ADEOfGenericTimeseries implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfGenericTimeseries() {
    }

    public GenericADEOfGenericTimeseries(Element value) {
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
