/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package implementing_ades.adapter;

import implementing_ades.model.SolarRoofSurfaceProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class SolarRoofSurfacePropertyAdapter extends AbstractFeaturePropertyAdapter<SolarRoofSurfaceProperty> {

    @Override
    public SolarRoofSurfaceProperty createObject(QName name, Object parent) throws ObjectBuildException {
        return new SolarRoofSurfaceProperty();
    }
}
