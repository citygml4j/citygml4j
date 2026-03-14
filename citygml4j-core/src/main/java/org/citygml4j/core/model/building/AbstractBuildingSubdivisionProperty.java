/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.building;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class AbstractBuildingSubdivisionProperty extends FeatureProperty<AbstractBuildingSubdivision> implements CityGMLObject {

    public AbstractBuildingSubdivisionProperty() {
    }

    public AbstractBuildingSubdivisionProperty(AbstractBuildingSubdivision object) {
        super(object);
    }

    public AbstractBuildingSubdivisionProperty(String href) {
        super(href);
    }

    @Override
    public Class<AbstractBuildingSubdivision> getTargetType() {
        return AbstractBuildingSubdivision.class;
    }
}
