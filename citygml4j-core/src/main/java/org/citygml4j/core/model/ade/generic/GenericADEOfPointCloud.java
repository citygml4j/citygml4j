/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.pointcloud.ADEOfPointCloud;
import org.w3c.dom.Element;

public class GenericADEOfPointCloud extends ADEOfPointCloud implements ADEGenericProperty {
    private Element value;

    private GenericADEOfPointCloud(Element value) {
        this.value = value;
    }

    public static GenericADEOfPointCloud of(Element value) {
        return new GenericADEOfPointCloud(value);
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
