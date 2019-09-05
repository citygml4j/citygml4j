package org.citygml4j.model.core;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.base.Reference;
import org.xmlobjects.gml.model.measures.Area;

public class QualifiedArea extends GMLObject implements CityGMLObject {
    private Area area;
    private Reference typeOfArea;

    public QualifiedArea() {
    }

    public QualifiedArea(Area area) {
        setArea(area);
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = asChild(area);
    }

    public Reference getTypeOfArea() {
        return typeOfArea;
    }

    public void setTypeOfArea(Reference typeOfArea) {
        this.typeOfArea = asChild(typeOfArea);
    }
}
