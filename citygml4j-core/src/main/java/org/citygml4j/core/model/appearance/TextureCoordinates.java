/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2022 Claus Nagel <claus.nagel@gmail.com>
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