/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package implementing_ades.model;

import org.citygml4j.core.model.ade.ADEObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class BuildingUndergroundPartProperty extends FeatureProperty<BuildingUndergroundPart> implements ADEObject {

    public BuildingUndergroundPartProperty() {
    }

    public BuildingUndergroundPartProperty(BuildingUndergroundPart object) {
        super(object);
    }

    public BuildingUndergroundPartProperty(String href) {
        super(href);
    }

    @Override
    public Class<BuildingUndergroundPart> getTargetType() {
        return BuildingUndergroundPart.class;
    }
}
