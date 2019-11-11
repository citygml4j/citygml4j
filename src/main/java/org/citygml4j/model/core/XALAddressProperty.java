package org.citygml4j.model.core;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.base.AbstractInlineProperty;
import org.xmlobjects.xal.model.AddressDetails;

public class XALAddressProperty extends AbstractInlineProperty<AddressDetails> implements CityGMLObject {

    public XALAddressProperty() {
    }

    public XALAddressProperty(AddressDetails object) {
        super(object);
    }

    @Override
    public Class<AddressDetails> getTargetType() {
        return AddressDetails.class;
    }
}
