/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.dynamizer.ADEOfAbstractTimeseries;
import org.w3c.dom.Element;

public class GenericADEOfAbstractTimeseries extends ADEOfAbstractTimeseries implements ADEGenericProperty {
    private Element value;

    private GenericADEOfAbstractTimeseries(Element value) {
        this.value = value;
    }

    public static GenericADEOfAbstractTimeseries of(Element value) {
        return new GenericADEOfAbstractTimeseries(value);
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
