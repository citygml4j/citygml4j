package org.citygml4j.model.ade.generic;

import org.citygml4j.model.relief.ADEPropertyOfAbstractReliefComponent;
import org.w3c.dom.Element;

public class GenericADEPropertyOfAbstractReliefComponent extends ADEPropertyOfAbstractReliefComponent<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfAbstractReliefComponent(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfAbstractReliefComponent of(Element value) {
        return new GenericADEPropertyOfAbstractReliefComponent(value);
    }
}
