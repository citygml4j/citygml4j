/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.waterbody.ADEOfWaterBody;
import org.w3c.dom.Element;

public class GenericADEOfWaterBody extends ADEOfWaterBody implements ADEGenericProperty {
    private Element value;

    private GenericADEOfWaterBody(Element value) {
        this.value = value;
    }

    public static GenericADEOfWaterBody of(Element value) {
        return new GenericADEOfWaterBody(value);
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
