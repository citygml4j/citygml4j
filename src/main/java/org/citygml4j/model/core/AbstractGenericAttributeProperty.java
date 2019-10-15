package org.citygml4j.model.core;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.base.AbstractInlineProperty;

public class AbstractGenericAttributeProperty extends AbstractInlineProperty<AbstractGenericAttribute> implements CityGMLObject {

    public AbstractGenericAttributeProperty() {
    }

    public AbstractGenericAttributeProperty(AbstractGenericAttribute object) {
        super(object);
    }

    @Override
    public Class<AbstractGenericAttribute> getTargetType() {
        return AbstractGenericAttribute.class;
    }
}
