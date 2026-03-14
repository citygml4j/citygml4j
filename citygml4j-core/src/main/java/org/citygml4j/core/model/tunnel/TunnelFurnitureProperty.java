/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.tunnel;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class TunnelFurnitureProperty extends FeatureProperty<TunnelFurniture> implements CityGMLObject {

    public TunnelFurnitureProperty() {
    }

    public TunnelFurnitureProperty(TunnelFurniture object) {
        super(object);
    }

    public TunnelFurnitureProperty(String href) {
        super(href);
    }

    @Override
    public Class<TunnelFurniture> getTargetType() {
        return TunnelFurniture.class;
    }
}
