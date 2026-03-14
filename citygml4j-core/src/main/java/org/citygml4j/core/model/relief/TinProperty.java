/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.relief;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.geometry.GeometryProperty;
import org.xmlobjects.gml.model.geometry.primitives.TriangulatedSurface;

public class TinProperty extends GeometryProperty<TriangulatedSurface> implements CityGMLObject {

    public TinProperty() {
    }

    public TinProperty(TriangulatedSurface object) {
        super(object);
    }

    public TinProperty(String href) {
        super(href);
    }

    @Override
    public Class<TriangulatedSurface> getTargetType() {
        return TriangulatedSurface.class;
    }
}
