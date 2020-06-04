package org.citygml4j.model.ade.generic;

import org.citygml4j.model.relief.ADEOfAbstractReliefComponent;
import org.w3c.dom.Element;

public class GenericADEOfAbstractReliefComponent extends ADEOfAbstractReliefComponent implements ADEGenericContainer {
    private Element value;

    private GenericADEOfAbstractReliefComponent(Element value) {
        this.value = value;
    }

    public static GenericADEOfAbstractReliefComponent of(Element value) {
        return new GenericADEOfAbstractReliefComponent(value);
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
