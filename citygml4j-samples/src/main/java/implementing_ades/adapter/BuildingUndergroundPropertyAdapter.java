/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package implementing_ades.adapter;

import implementing_ades.model.BuildingUndergroundProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class BuildingUndergroundPropertyAdapter extends AbstractFeaturePropertyAdapter<BuildingUndergroundProperty> {

    @Override
    public BuildingUndergroundProperty createObject(QName name, Object parent) throws ObjectBuildException {
        return new BuildingUndergroundProperty();
    }
}
