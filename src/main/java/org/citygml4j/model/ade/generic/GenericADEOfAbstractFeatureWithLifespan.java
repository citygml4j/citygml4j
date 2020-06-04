package org.citygml4j.model.ade.generic;

import org.citygml4j.model.core.ADEOfAbstractFeatureWithLifespan;
import org.w3c.dom.Element;

public class GenericADEOfAbstractFeatureWithLifespan extends ADEOfAbstractFeatureWithLifespan implements ADEGenericContainer {
    private Element value;

    private GenericADEOfAbstractFeatureWithLifespan(Element value) {
        this.value = value;
    }

    public static GenericADEOfAbstractFeatureWithLifespan of(Element value) {
        return new GenericADEOfAbstractFeatureWithLifespan(value);
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
