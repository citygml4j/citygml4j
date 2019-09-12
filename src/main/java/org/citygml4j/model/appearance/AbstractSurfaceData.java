package org.citygml4j.model.appearance;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.common.ChildList;
import org.xmlobjects.gml.model.feature.AbstractFeature;

import java.util.List;

public abstract class AbstractSurfaceData extends AbstractFeature implements CityGMLObject {
    private Boolean isFront;
    private List<ADEPropertyOfAbstractSurfaceData> adeProperties;

    public Boolean getFront() {
        return isFront != null ? isFront : true;
    }

    public void setFront(Boolean front) {
        isFront = front;
    }

    public List<ADEPropertyOfAbstractSurfaceData> getADEPropertiesOfAbstractSurfaceData() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfAbstractSurfaceData(List<ADEPropertyOfAbstractSurfaceData> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
