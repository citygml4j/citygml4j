package org.citygml4j.model.generics;

import org.xmlobjects.gml.model.common.ChildList;

import java.util.List;

public class GenericAttributeSet extends AbstractGenericAttribute<List<AbstractGenericAttributeProperty>> {
    private String codeSpace;

    public GenericAttributeSet() {
    }

    public GenericAttributeSet(String name, List<AbstractGenericAttributeProperty> value) {
        super(name, value);
    }

    @Override
    public List<AbstractGenericAttributeProperty> getValue() {
        if (super.getValue() == null)
            setValue(new ChildList<>(this));

        return super.getValue();
    }

    @Override
    public void setValue(List<AbstractGenericAttributeProperty> value) {
        super.setValue(asChild(value));
    }

    public String getCodeSpace() {
        return codeSpace;
    }

    public void setCodeSpace(String codeSpace) {
        this.codeSpace = codeSpace;
    }
}
