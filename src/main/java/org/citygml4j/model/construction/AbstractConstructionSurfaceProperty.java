package org.citygml4j.model.construction;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class AbstractConstructionSurfaceProperty extends FeatureProperty<AbstractConstructionSurface> implements CityGMLObject {

    public AbstractConstructionSurfaceProperty() {
    }

    public AbstractConstructionSurfaceProperty(AbstractConstructionSurface object) {
        super(object);
    }

    public AbstractConstructionSurfaceProperty(String href) {
        super(href);
    }

    @Override
    public Class<AbstractConstructionSurface> getTargetType() {
        return AbstractConstructionSurface.class;
    }
}
