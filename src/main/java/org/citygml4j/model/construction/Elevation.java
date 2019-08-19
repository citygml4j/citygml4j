package org.citygml4j.model.construction;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.geometry.DirectPosition;

public class Elevation extends GMLObject implements CityGMLObject {
    private ElevationReferenceValue elevationReference;
    private DirectPosition elevationValue;

    public Elevation() {
    }

    public Elevation(ElevationReferenceValue elevationReference, DirectPosition elevationValue) {
        this.elevationReference = elevationReference;
        setElevationValue(elevationValue);
    }

    public ElevationReferenceValue getElevationReference() {
        return elevationReference;
    }

    public void setElevationReference(ElevationReferenceValue elevationReference) {
        this.elevationReference = elevationReference;
    }

    public DirectPosition getElevationValue() {
        return elevationValue;
    }

    public void setElevationValue(DirectPosition elevationValue) {
        this.elevationValue = asChild(elevationValue);
    }
}
