package org.citygml4j.model.appearance;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class AbstractSurfaceDataProperty extends FeatureProperty<AbstractSurfaceData> implements CityGMLObject {

    public AbstractSurfaceDataProperty() {
    }

    public AbstractSurfaceDataProperty(AbstractSurfaceData object) {
        super(object);
    }

    public AbstractSurfaceDataProperty(String href) {
        super(href);
    }

    @Override
    public Class<AbstractSurfaceData> getTargetType() {
        return AbstractSurfaceData.class;
    }
}
