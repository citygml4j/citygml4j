package org.citygml4j.model.core;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.measures.Volume;

public class QualifiedVolume extends GMLObject implements CityGMLObject {
    private Volume volume;
    private Code typeOfVolume;

    public QualifiedVolume() {
    }

    public QualifiedVolume(Volume volume) {
        setVolume(volume);
    }

    public Volume getVolume() {
        return volume;
    }

    public void setVolume(Volume volume) {
        this.volume = asChild(volume);
    }

    public Code getTypeOfVolume() {
        return typeOfVolume;
    }

    public void setTypeOfVolume(Code typeOfVolume) {
        this.typeOfVolume = asChild(typeOfVolume);
    }
}
