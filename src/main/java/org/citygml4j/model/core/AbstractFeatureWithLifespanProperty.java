package org.citygml4j.model.core;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class AbstractFeatureWithLifespanProperty extends FeatureProperty<AbstractFeatureWithLifespan> implements CityGMLObject {

    public AbstractFeatureWithLifespanProperty() {
    }

    public AbstractFeatureWithLifespanProperty(AbstractFeatureWithLifespan object) {
        super(object);
    }

    public AbstractFeatureWithLifespanProperty(String href) {
        super(href);
    }

    @Override
    public Class<AbstractFeatureWithLifespan> getTargetType() {
        return AbstractFeatureWithLifespan.class;
    }
}
