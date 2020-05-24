package org.citygml4j.model.ade.generic;

import org.citygml4j.model.dynamizer.ADEOfAbstractTimeseries;
import org.w3c.dom.Element;

public class GenericADEPropertyOfAbstractTimeseries extends ADEOfAbstractTimeseries<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfAbstractTimeseries(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfAbstractTimeseries of(Element value) {
        return new GenericADEPropertyOfAbstractTimeseries(value);
    }
}
