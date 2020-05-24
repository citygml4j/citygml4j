package org.citygml4j.model.ade.generic;

import org.citygml4j.model.core.ADEOfAbstractFeatureWithLifespan;
import org.w3c.dom.Element;

public class GenericADEPropertyOfAbstractFeatureWithLifespan extends ADEOfAbstractFeatureWithLifespan<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfAbstractFeatureWithLifespan(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfAbstractFeatureWithLifespan of(Element value) {
        return new GenericADEPropertyOfAbstractFeatureWithLifespan(value);
    }
}
