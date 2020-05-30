package org.citygml4j.model.ade.generic;

import org.citygml4j.model.dynamizer.ADEOfCompositeTimeseries;
import org.w3c.dom.Element;

public class GenericADEOfCompositeTimeseries extends ADEOfCompositeTimeseries implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfCompositeTimeseries() {
    }

    public GenericADEOfCompositeTimeseries(Element value) {
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
