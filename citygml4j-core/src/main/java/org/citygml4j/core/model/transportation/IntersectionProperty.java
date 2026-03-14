/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.transportation;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class IntersectionProperty extends FeatureProperty<Intersection> implements CityGMLObject {

    public IntersectionProperty() {
    }

    public IntersectionProperty(Intersection object) {
        super(object);
    }

    public IntersectionProperty(String href) {
        super(href);
    }

    @Override
    public Class<Intersection> getTargetType() {
        return Intersection.class;
    }
}
