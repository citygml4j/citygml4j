package org.citygml4j.model.appearance;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.GMLObject;

import java.util.ArrayList;
import java.util.List;

public class Color extends GMLObject implements CityGMLObject {
    private double red;
    private double green;
    private double blue;

    public Color() {
    }

    public Color(double red, double green, double blue) {
        setRed(red);
        setGreen(green);
        setBlue(blue);
    }

    public Color(double value) {
        this(value, value, value);
    }

    public static Color fromList(List<Double> values) {
        Color color = new Color();
        if (values != null && values.size() > 2) {
            color.setRed(values.get(0) != null ? values.get(0) : 0);
            color.setGreen(values.get(1) != null ? values.get(1) : 0);
            color.setBlue(values.get(2) != null ? values.get(2) : 0);
        }

        return color;
    }

    public double getRed() {
        return red;
    }

    public void setRed(double red) {
        if (red >= 0 && red <= 1)
            this.red = red;
    }

    public double getGreen() {
        return green;
    }

    public void setGreen(double green) {
        if (green >= 0 && green <= 1)
            this.green = green;
    }

    public double getBlue() {
        return blue;
    }

    public void setBlue(double blue) {
        if (blue >= 0 && blue <= 1)
            this.blue = blue;
    }

    public List<Double> toList() {
        List<Double> values = new ArrayList<>(3);
        values.add(red);
        values.add(green);
        values.add(blue);

        return values;
    }
}
