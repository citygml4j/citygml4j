/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.dynamizer.ADEOfTabulatedFileTimeseries;
import org.w3c.dom.Element;

public class GenericADEOfTabulatedFileTimeseries extends ADEOfTabulatedFileTimeseries implements ADEGenericProperty {
    private Element value;

    private GenericADEOfTabulatedFileTimeseries(Element value) {
        this.value = value;
    }

    public static GenericADEOfTabulatedFileTimeseries of(Element value) {
        return new GenericADEOfTabulatedFileTimeseries(value);
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
