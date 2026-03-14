/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade;

import org.citygml4j.core.model.common.GeometryInfo;
import org.citygml4j.core.model.core.AbstractFeature;
import org.xmlobjects.gml.model.GMLObject;

public abstract class ADEProperty extends GMLObject implements ADEObject {
    public abstract Class<? extends AbstractFeature> getTargetType();

    public void updateGeometryInfo(GeometryInfo geometryInfo) {
    }
}
