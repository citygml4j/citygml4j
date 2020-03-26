package org.citygml4j.model.core;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.common.GenericElement;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class AbstractFeatureProperty extends FeatureProperty<AbstractFeature> implements CityGMLObject {

    public AbstractFeatureProperty() {
    }

    public AbstractFeatureProperty(AbstractFeature object) {
        super(object);
    }

    public AbstractFeatureProperty(String href) {
        super(href);
    }

    public AbstractFeatureProperty(GenericElement element) {
        super(element);
    }

    @Override
    public Class<AbstractFeature> getTargetType() {
        return AbstractFeature.class;
    }
}
