package org.citygml4j.model.ade.generic;

import org.citygml4j.model.core.ADEPropertyOfAbstractFeatureWithLifespan;
import org.w3c.dom.Element;

public class GenericADEPropertyOfAbstractFeatureWithLifespan extends ADEPropertyOfAbstractFeatureWithLifespan<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfAbstractFeatureWithLifespan(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfAbstractFeatureWithLifespan of(Element value) {
        return new GenericADEPropertyOfAbstractFeatureWithLifespan(value);
    }
}
