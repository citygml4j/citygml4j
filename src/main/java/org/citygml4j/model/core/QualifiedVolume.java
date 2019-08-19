package org.citygml4j.model.core;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.base.AbstractGML;
import org.xmlobjects.gml.model.base.Reference;
import org.xmlobjects.gml.model.measures.Volume;

public class QualifiedVolume extends AbstractGML implements CityGMLObject {
    private Volume volume;
    private Reference typeOfVolume;

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

    public Reference getTypeOfVolume() {
        return typeOfVolume;
    }

    public void setTypeOfVolume(Reference typeOfVolume) {
        this.typeOfVolume = asChild(typeOfVolume);
    }
}
