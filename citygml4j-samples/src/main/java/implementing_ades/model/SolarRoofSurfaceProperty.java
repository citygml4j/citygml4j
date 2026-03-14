/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package implementing_ades.model;

import org.citygml4j.core.model.ade.ADEObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class SolarRoofSurfaceProperty extends FeatureProperty<SolarRoofSurface> implements ADEObject {

    public SolarRoofSurfaceProperty() {
    }

    public SolarRoofSurfaceProperty(SolarRoofSurface object) {
        super(object);
    }

    public SolarRoofSurfaceProperty(String href) {
        super(href);
    }

    @Override
    public Class<SolarRoofSurface> getTargetType() {
        return SolarRoofSurface.class;
    }
}
