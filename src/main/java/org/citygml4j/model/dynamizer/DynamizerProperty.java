package org.citygml4j.model.dynamizer;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.base.AbstractProperty;

public class DynamizerProperty extends AbstractProperty<Dynamizer> implements CityGMLObject {

    public DynamizerProperty() {
    }

    public DynamizerProperty(Dynamizer object) {
        super(object);
    }

    @Override
    public Class<Dynamizer> getTargetType() {
        return Dynamizer.class;
    }
}
