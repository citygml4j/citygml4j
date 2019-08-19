package org.citygml4j.model.core;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class AddressProperty extends FeatureProperty<Address> implements CityGMLObject {

    public AddressProperty() {
    }

    public AddressProperty(Address object) {
        super(object);
    }

    public AddressProperty(String href) {
        super(href);
    }

    @Override
    public Class<Address> getTargetType() {
        return Address.class;
    }
}
