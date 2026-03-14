/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.building;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class BuildingPartProperty extends FeatureProperty<BuildingPart> implements CityGMLObject {

    public BuildingPartProperty() {
    }

    public BuildingPartProperty(BuildingPart object) {
        super(object);
    }

    public BuildingPartProperty(String href) {
        super(href);
    }

    @Override
    public Class<BuildingPart> getTargetType() {
        return BuildingPart.class;
    }
}
