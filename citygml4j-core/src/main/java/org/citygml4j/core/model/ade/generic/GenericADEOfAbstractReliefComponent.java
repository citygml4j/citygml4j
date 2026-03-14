/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.relief.ADEOfAbstractReliefComponent;
import org.w3c.dom.Element;

public class GenericADEOfAbstractReliefComponent extends ADEOfAbstractReliefComponent implements ADEGenericProperty {
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
