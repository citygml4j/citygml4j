package org.citygml4j.model.construction;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.measures.Length;

public class Height extends GMLObject implements CityGMLObject {
    private ElevationReferenceValue highReference;
    private ElevationReferenceValue lowReference;
    private HeightStatusValue status;
    private Length value;

    public Height() {
    }

    public Height(ElevationReferenceValue highReference, ElevationReferenceValue lowReference, HeightStatusValue status, Length value) {
        this.highReference = highReference;
        this.lowReference = lowReference;
        this.status = status;
        setValue(value);
    }

    public ElevationReferenceValue getHighReference() {
        return highReference;
    }

    public void setHighReference(ElevationReferenceValue highReference) {
        this.highReference = highReference;
    }

    public ElevationReferenceValue getLowReference() {
        return lowReference;
    }

    public void setLowReference(ElevationReferenceValue lowReference) {
        this.lowReference = lowReference;
    }

    public HeightStatusValue getStatus() {
        return status;
    }

    public void setStatus(HeightStatusValue status) {
        this.status = status;
    }

    public Length getValue() {
        return value;
    }

    public void setValue(Length value) {
        this.value = asChild(value);
    }
}
