/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.generics;

import org.citygml4j.core.model.core.AbstractGenericAttribute;
import org.citygml4j.core.model.core.AbstractGenericAttributeProperty;
import org.xmlobjects.model.ChildList;

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
    public boolean isSetValue() {
        return super.isSetValue() && !super.getValue().isEmpty();
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
