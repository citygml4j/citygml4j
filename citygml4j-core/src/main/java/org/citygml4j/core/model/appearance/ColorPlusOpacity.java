/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2025 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.citygml4j.core.model.appearance;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.GMLObject;

import java.util.List;

public class ColorPlusOpacity extends GMLObject implements CityGMLObject {
    private Color color;
    private Double opacity;

    public ColorPlusOpacity() {
        color = new Color();
    }

    public ColorPlusOpacity(double red, double green, double blue) {
        color = new Color(red, green, blue);
    }

    public ColorPlusOpacity(double red, double green, double blue, double opacity) {
        this(red, green, blue);
        setOpacity(opacity);
    }

    public ColorPlusOpacity(double value, double opacity) {
        this(value, value, value, opacity);
    }

    public ColorPlusOpacity(double value) {
        this(value, value, value);
    }

    public static ColorPlusOpacity fromList(List<Double> values) {
        ColorPlusOpacity colorPlusOpacity = new ColorPlusOpacity();
        if (values != null && values.size() > 3) {
            colorPlusOpacity.setColor(Color.fromList(values.subList(0, 3)));
            colorPlusOpacity.setOpacity(values.get(3));
        }

        return colorPlusOpacity;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        if (color != null)
            this.color = color;
    }

    public double getRed() {
        return color.getRed();
    }

    public void setRed(double red) {
        color.setRed(red);
    }

    public double getGreen() {
        return color.getGreen();
    }

    public void setGreen(double green) {
        color.setGreen(green);
    }

    public double getBlue() {
        return color.getBlue();
    }

    public void setBlue(double blue) {
        color.setBlue(blue);
    }

    public double getOpacity() {
        return opacity != null ? opacity : 1;
    }

    public void setOpacity(double opacity) {
        if (opacity >= 0 && opacity <= 1)
            this.opacity = opacity;
    }

    public List<Double> toList() {
        List<Double> values = color.toList();
        if (opacity != null)
            values.add(opacity);

        return values;
    }
}
