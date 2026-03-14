/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.tunnel;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class HollowSpaceProperty extends FeatureProperty<HollowSpace> implements CityGMLObject {

    public HollowSpaceProperty() {
    }

    public HollowSpaceProperty(HollowSpace object) {
        super(object);
    }

    public HollowSpaceProperty(String href) {
        super(href);
    }

    @Override
    public Class<HollowSpace> getTargetType() {
        return HollowSpace.class;
    }
}
