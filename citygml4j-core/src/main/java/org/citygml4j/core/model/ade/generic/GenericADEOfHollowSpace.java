/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.tunnel.ADEOfHollowSpace;
import org.w3c.dom.Element;

public class GenericADEOfHollowSpace extends ADEOfHollowSpace implements ADEGenericProperty {
    private Element value;

    public GenericADEOfHollowSpace(Element value) {
        this.value = value;
    }

    public static GenericADEOfHollowSpace of(Element value) {
        return new GenericADEOfHollowSpace(value);
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
