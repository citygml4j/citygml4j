/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.dynamizer.ADEOfCompositeTimeseries;
import org.w3c.dom.Element;

public class GenericADEOfCompositeTimeseries extends ADEOfCompositeTimeseries implements ADEGenericProperty {
    private Element value;

    private GenericADEOfCompositeTimeseries(Element value) {
        this.value = value;
    }

    public static GenericADEOfCompositeTimeseries of(Element value) {
        return new GenericADEOfCompositeTimeseries(value);
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
