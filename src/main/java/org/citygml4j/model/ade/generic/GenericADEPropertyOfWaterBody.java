package org.citygml4j.model.ade.generic;

import org.citygml4j.model.waterbody.ADEOfWaterBody;
import org.w3c.dom.Element;

public class GenericADEPropertyOfWaterBody extends ADEOfWaterBody<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfWaterBody(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfWaterBody of(Element value) {
        return new GenericADEPropertyOfWaterBody(value);
    }
}
