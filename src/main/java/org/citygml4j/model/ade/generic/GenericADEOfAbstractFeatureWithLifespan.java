package org.citygml4j.model.ade.generic;

import org.citygml4j.model.core.ADEOfAbstractFeatureWithLifespan;
import org.w3c.dom.Element;

public class GenericADEOfAbstractFeatureWithLifespan extends ADEOfAbstractFeatureWithLifespan implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfAbstractFeatureWithLifespan() {
    }

    public GenericADEOfAbstractFeatureWithLifespan(Element value) {
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
