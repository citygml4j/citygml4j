package org.citygml4j.model.tunnel;

import org.citygml4j.model.CityGMLObject;
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
