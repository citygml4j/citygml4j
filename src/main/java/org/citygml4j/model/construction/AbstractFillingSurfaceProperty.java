package org.citygml4j.model.construction;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class AbstractFillingSurfaceProperty extends FeatureProperty<AbstractFillingSurface> implements CityGMLObject {

    public AbstractFillingSurfaceProperty() {
    }

    public AbstractFillingSurfaceProperty(AbstractFillingSurface object) {
        super(object);
    }

    public AbstractFillingSurfaceProperty(String href) {
        super(href);
    }

    @Override
    public Class<AbstractFillingSurface> getTargetType() {
        return AbstractFillingSurface.class;
    }
}
