/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.building;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class BuildingInstallationProperty extends FeatureProperty<BuildingInstallation> implements CityGMLObject {

    public BuildingInstallationProperty() {
    }

    public BuildingInstallationProperty(BuildingInstallation object) {
        super(object);
    }

    public BuildingInstallationProperty(String href) {
        super(href);
    }

    @Override
    public Class<BuildingInstallation> getTargetType() {
        return BuildingInstallation.class;
    }
}
