package org.citygml4j.model.core;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.AbstractFeature;
import org.xmlobjects.gml.model.geometry.aggregates.MultiPointProperty;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class Address extends AbstractFeature implements CityGMLObject {
    private XALAddressProperty xalAddress;
    private MultiPointProperty multiPoint;
    private List<ADEPropertyOfAddress<?>> adeProperties;

    public Address() {
    }

    public Address(XALAddressProperty xalAddress) {
        setXALAddress(xalAddress);
    }

    public XALAddressProperty getXALAddress() {
        return xalAddress;
    }

    public void setXALAddress(XALAddressProperty xalAddress) {
        this.xalAddress = asChild(xalAddress);
    }

    public MultiPointProperty getMultiPoint() {
        return multiPoint;
    }

    public void setMultiPoint(MultiPointProperty multiPoint) {
        this.multiPoint = asChild(multiPoint);
    }

    public List<ADEPropertyOfAddress<?>> getADEPropertiesOfAddress() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfAddress(List<ADEPropertyOfAddress<?>> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
