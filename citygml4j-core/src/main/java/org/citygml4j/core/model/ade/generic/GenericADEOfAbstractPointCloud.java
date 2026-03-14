/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.core.ADEOfAbstractPointCloud;
import org.w3c.dom.Element;

public class GenericADEOfAbstractPointCloud extends ADEOfAbstractPointCloud implements ADEGenericProperty {
    private Element value;

    private GenericADEOfAbstractPointCloud(Element value) {
        this.value = value;
    }

    public static GenericADEOfAbstractPointCloud of(Element value) {
        return new GenericADEOfAbstractPointCloud(value);
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
