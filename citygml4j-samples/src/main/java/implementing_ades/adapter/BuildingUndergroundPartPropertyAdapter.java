/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package implementing_ades.adapter;

import implementing_ades.model.BuildingUndergroundPartProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class BuildingUndergroundPartPropertyAdapter extends AbstractFeaturePropertyAdapter<BuildingUndergroundPartProperty> {

    @Override
    public BuildingUndergroundPartProperty createObject(QName name, Object parent) throws ObjectBuildException {
        return new BuildingUndergroundPartProperty();
    }
}
