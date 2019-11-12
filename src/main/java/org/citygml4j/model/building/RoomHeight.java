package org.citygml4j.model.building;

import org.citygml4j.model.CityGMLObject;
import org.citygml4j.model.construction.HeightStatusValue;
import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.measures.Length;

public class RoomHeight extends GMLObject implements CityGMLObject {
    private Code highReference;
    private Code lowReference;
    private HeightStatusValue status;
    private Length value;

    public RoomHeight() {
    }

    public RoomHeight(Code highReference, Code lowReference, HeightStatusValue status, Length value) {
        this.highReference = highReference;
        this.lowReference = lowReference;
        this.status = status;
        setValue(value);
    }

    public Code getHighReference() {
        return highReference;
    }

    public void setHighReference(Code highReference) {
        this.highReference = asChild(highReference);
    }

    public Code getLowReference() {
        return lowReference;
    }

    public void setLowReference(Code lowReference) {
        this.lowReference = asChild(lowReference);
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
