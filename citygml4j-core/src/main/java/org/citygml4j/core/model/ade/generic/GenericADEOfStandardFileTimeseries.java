/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.dynamizer.ADEOfStandardFileTimeseries;
import org.w3c.dom.Element;

public class GenericADEOfStandardFileTimeseries extends ADEOfStandardFileTimeseries implements ADEGenericProperty {
    private Element value;

    private GenericADEOfStandardFileTimeseries(Element value) {
        this.value = value;
    }

    public static GenericADEOfStandardFileTimeseries of(Element value) {
        return new GenericADEOfStandardFileTimeseries(value);
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
