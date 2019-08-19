package org.citygml4j.model.construction;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class AbstractConstructiveElementProperty extends FeatureProperty<AbstractConstructiveElement> implements CityGMLObject {

    public AbstractConstructiveElementProperty() {
    }

    public AbstractConstructiveElementProperty(AbstractConstructiveElement object) {
        super(object);
    }

    public AbstractConstructiveElementProperty(String href) {
        super(href);
    }

    @Override
    public Class<AbstractConstructiveElement> getTargetType() {
        return AbstractConstructiveElement.class;
    }
}
