/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.building;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class BuildingConstructiveElementProperty extends FeatureProperty<BuildingConstructiveElement> implements CityGMLObject {

    public BuildingConstructiveElementProperty() {
    }

    public BuildingConstructiveElementProperty(BuildingConstructiveElement object) {
        super(object);
    }

    public BuildingConstructiveElementProperty(String href) {
        super(href);
    }

    @Override
    public Class<BuildingConstructiveElement> getTargetType() {
        return BuildingConstructiveElement.class;
    }
}
