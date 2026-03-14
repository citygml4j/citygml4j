/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.transportation;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class TrafficSpaceProperty extends FeatureProperty<TrafficSpace> implements CityGMLObject {

    public TrafficSpaceProperty() {
    }

    public TrafficSpaceProperty(TrafficSpace object) {
        super(object);
    }

    public TrafficSpaceProperty(String href) {
        super(href);
    }

    @Override
    public Class<TrafficSpace> getTargetType() {
        return TrafficSpace.class;
    }
}
