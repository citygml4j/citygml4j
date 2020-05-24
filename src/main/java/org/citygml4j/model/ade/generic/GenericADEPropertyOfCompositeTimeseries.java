package org.citygml4j.model.ade.generic;

import org.citygml4j.model.dynamizer.ADEOfCompositeTimeseries;
import org.w3c.dom.Element;

public class GenericADEPropertyOfCompositeTimeseries extends ADEOfCompositeTimeseries<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfCompositeTimeseries(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfCompositeTimeseries of(Element value) {
        return new GenericADEPropertyOfCompositeTimeseries(value);
    }
}
