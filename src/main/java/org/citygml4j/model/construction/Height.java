package org.citygml4j.model.construction;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.measures.Length;

public class Height extends GMLObject implements CityGMLObject {
    private Code highReference;
    private Code lowReference;
    private HeightStatusValue status;
    private Length value;

    public Height() {
    }

    public Height(Code highReference, Code lowReference, HeightStatusValue status, Length value) {
        setHighReference(highReference);
        setLowReference(lowReference);
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
