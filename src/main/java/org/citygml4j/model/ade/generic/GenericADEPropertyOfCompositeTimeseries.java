package org.citygml4j.model.ade.generic;

import org.citygml4j.model.dynamizer.ADEPropertyOfCompositeTimeseries;
import org.w3c.dom.Element;

public class GenericADEPropertyOfCompositeTimeseries extends ADEPropertyOfCompositeTimeseries<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfCompositeTimeseries(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfCompositeTimeseries of(Element value) {
        return new GenericADEPropertyOfCompositeTimeseries(value);
    }
}
