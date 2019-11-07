package org.citygml4j.model.ade.generic;

import org.citygml4j.model.dynamizer.ADEPropertyOfGenericTimeseries;
import org.w3c.dom.Element;

public class GenericADEPropertyOfGenericTimeseries extends ADEPropertyOfGenericTimeseries<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfGenericTimeseries(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfGenericTimeseries of(Element value) {
        return new GenericADEPropertyOfGenericTimeseries(value);
    }
}
