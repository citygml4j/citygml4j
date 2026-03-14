/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.adapter.building;

import org.citygml4j.core.model.building.BuildingUnitProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class BuildingUnitPropertyAdapter extends AbstractFeaturePropertyAdapter<BuildingUnitProperty> {

    @Override
    public BuildingUnitProperty createObject(QName name, Object parent) throws ObjectBuildException {
        return new BuildingUnitProperty();
    }
}
