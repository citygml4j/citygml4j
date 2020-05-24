package org.citygml4j.model.ade.generic;

import org.citygml4j.model.dynamizer.ADEOfTabulatedFileTimeseries;
import org.w3c.dom.Element;

public class GenericADEPropertyOfTabulatedFileTimeseries extends ADEOfTabulatedFileTimeseries<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfTabulatedFileTimeseries(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfTabulatedFileTimeseries of(Element value) {
        return new GenericADEPropertyOfTabulatedFileTimeseries(value);
    }
}
