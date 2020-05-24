package org.citygml4j.model.ade.generic;

import org.citygml4j.model.relief.ADEOfAbstractReliefComponent;
import org.w3c.dom.Element;

public class GenericADEPropertyOfAbstractReliefComponent extends ADEOfAbstractReliefComponent<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfAbstractReliefComponent(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfAbstractReliefComponent of(Element value) {
        return new GenericADEPropertyOfAbstractReliefComponent(value);
    }
}
