/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.transportation;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class AuxiliaryTrafficSpaceProperty extends FeatureProperty<AuxiliaryTrafficSpace> implements CityGMLObject {

    public AuxiliaryTrafficSpaceProperty() {
    }

    public AuxiliaryTrafficSpaceProperty(AuxiliaryTrafficSpace object) {
        super(object);
    }

    public AuxiliaryTrafficSpaceProperty(String href) {
        super(href);
    }

    @Override
    public Class<AuxiliaryTrafficSpace> getTargetType() {
        return AuxiliaryTrafficSpace.class;
    }
}
