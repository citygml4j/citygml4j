/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.appearance;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.geometry.primitives.LinearRing;

import java.util.ArrayList;
import java.util.List;

public class TextureCoordinates extends GMLObject implements CityGMLObject {
    private List<Double> value;
    private RingReference ring;

    public TextureCoordinates() {
    }

    public TextureCoordinates(List<Double> value, RingReference ring) {
        this.value = value;
        setRing(ring);
    }

    public TextureCoordinates(List<Double> value, String ring) {
        this(value, new RingReference(ring));
    }

    public TextureCoordinates(List<Double> value, LinearRing ring) {
        this(value, new RingReference(ring));
    }

    public List<Double> getValue() {
        if (value == null)
            value = new ArrayList<>();

        return value;
    }

    public boolean isSetValue() {
        return value != null && !value.isEmpty();
    }

    public void setValue(List<Double> value) {
        this.value = value;
    }

    public RingReference getRing() {
        return ring;
    }

    public void setRing(RingReference ring) {
        this.ring = asChild(ring);
    }
}
