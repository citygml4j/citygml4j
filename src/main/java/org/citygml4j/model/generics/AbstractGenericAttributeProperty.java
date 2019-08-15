package org.citygml4j.model.generics;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.base.AbstractInlineAssociation;

public class AbstractGenericAttributeProperty extends AbstractInlineAssociation<AbstractGenericAttribute> implements CityGMLObject {

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
