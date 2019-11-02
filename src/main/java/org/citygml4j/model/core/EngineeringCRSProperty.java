package org.citygml4j.model.core;

import org.xmlobjects.gml.model.base.AbstractMetadataProperty;
import org.xmlobjects.gml.model.common.GenericElement;

public class EngineeringCRSProperty extends AbstractMetadataProperty<GenericElement> {

    @Override
    public GenericElement getGenericElement() {
        return super.getObject();
    }

    @Override
    public boolean isSetGenericElement() {
        return super.isSetObject();
    }

    @Override
    public void setGenericElement(GenericElement genericElement) {
        super.setObject(genericElement);
    }

    @Override
    public Class<GenericElement> getTargetType() {
        return GenericElement.class;
    }
}
