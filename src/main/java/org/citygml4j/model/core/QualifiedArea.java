package org.citygml4j.model.core;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.measures.Area;

public class QualifiedArea extends GMLObject implements CityGMLObject {
    private Area area;
    private Code typeOfArea;

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

    public Code getTypeOfArea() {
        return typeOfArea;
    }

    public void setTypeOfArea(Code typeOfArea) {
        this.typeOfArea = asChild(typeOfArea);
    }
}
