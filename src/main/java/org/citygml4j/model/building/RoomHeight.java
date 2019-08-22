package org.citygml4j.model.building;

import org.citygml4j.model.CityGMLObject;
import org.citygml4j.model.construction.HeightStatusValue;
import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.measures.Length;

public class RoomHeight extends GMLObject implements CityGMLObject {
    private RoomElevationReferenceValue highReference;
    private RoomElevationReferenceValue lowReference;
    private HeightStatusValue status;
    private Length value;

    public RoomHeight() {
    }

    public RoomHeight(RoomElevationReferenceValue highReference, RoomElevationReferenceValue lowReference, HeightStatusValue status, Length value) {
        this.highReference = highReference;
        this.lowReference = lowReference;
        this.status = status;
        setValue(value);
    }

    public RoomElevationReferenceValue getHighReference() {
        return highReference;
    }

    public void setHighReference(RoomElevationReferenceValue highReference) {
        this.highReference = highReference;
    }

    public RoomElevationReferenceValue getLowReference() {
        return lowReference;
    }

    public void setLowReference(RoomElevationReferenceValue lowReference) {
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
