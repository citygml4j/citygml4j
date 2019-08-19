package org.citygml4j.model.core;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.common.ChildList;
import org.xmlobjects.gml.model.feature.AbstractFeature;
import org.xmlobjects.gml.model.geometry.aggregates.MultiPointProperty;

import java.util.List;

public class Address extends AbstractFeature implements CityGMLObject {
    private MultiPointProperty multiPoint;
    private List<ADEPropertyOfAddress> adeProperties;

    public MultiPointProperty getMultiPoint() {
        return multiPoint;
    }

    public void setMultiPoint(MultiPointProperty multiPoint) {
        this.multiPoint = asChild(multiPoint);
    }

    public List<ADEPropertyOfAddress> getADEPropertyOfAddress() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertyOfAddress(List<ADEPropertyOfAddress> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
