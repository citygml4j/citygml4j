/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.transportation;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class ClearanceSpaceProperty extends FeatureProperty<ClearanceSpace> implements CityGMLObject {

    public ClearanceSpaceProperty() {
    }

    public ClearanceSpaceProperty(ClearanceSpace object) {
        super(object);
    }

    public ClearanceSpaceProperty(String href) {
        super(href);
    }

    @Override
    public Class<ClearanceSpace> getTargetType() {
        return ClearanceSpace.class;
    }
}
