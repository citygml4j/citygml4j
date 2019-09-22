package org.citygml4j.model.appearance;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.GMLObject;

import java.util.ArrayList;
import java.util.List;

public class TextureCoordinates extends GMLObject implements CityGMLObject {
    private List<Double> value;
    private String ring;

    public TextureCoordinates() {
    }

    public TextureCoordinates(List<Double> value, String ring) {
        this.value = value;
        this.ring = ring;
    }

    public List<Double> getValue() {
        if (value == null)
            value = new ArrayList<>();

        return value;
    }

    public void setValue(List<Double> value) {
        this.value = value;
    }

    public String getRing() {
        return ring;
    }

    public void setRing(String ring) {
        this.ring = ring;
    }
}
