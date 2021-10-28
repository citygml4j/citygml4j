/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2021 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.model.deprecated.vegetation;

import org.citygml4j.model.core.ImplicitGeometryProperty;
import org.citygml4j.model.deprecated.core.DeprecatedPropertiesOfAbstractCityObject;
import org.xmlobjects.gml.model.geometry.GeometryProperty;

public class DeprecatedPropertiesOfSolitaryVegetationObject extends DeprecatedPropertiesOfAbstractCityObject {
    private GeometryProperty<?> lod1Geometry;
    private GeometryProperty<?> lod2Geometry;
    private GeometryProperty<?> lod3Geometry;
    private GeometryProperty<?> lod4Geometry;
    private ImplicitGeometryProperty lod4ImplicitRepresentation;

    public GeometryProperty<?> getLod1Geometry() {
        return lod1Geometry;
    }

    public void setLod1Geometry(GeometryProperty<?> lod1Geometry) {
        this.lod1Geometry = asChild(lod1Geometry);
    }

    public GeometryProperty<?> getLod2Geometry() {
        return lod2Geometry;
    }

    public void setLod2Geometry(GeometryProperty<?> lod2Geometry) {
        this.lod2Geometry = asChild(lod2Geometry);
    }

    public GeometryProperty<?> getLod3Geometry() {
        return lod3Geometry;
    }

    public void setLod3Geometry(GeometryProperty<?> lod3Geometry) {
        this.lod3Geometry = asChild(lod3Geometry);
    }

    public GeometryProperty<?> getLod4Geometry() {
        return lod4Geometry;
    }

    public void setLod4Geometry(GeometryProperty<?> lod4Geometry) {
        this.lod4Geometry = asChild(lod4Geometry);
    }

    public ImplicitGeometryProperty getLod4ImplicitRepresentation() {
        return lod4ImplicitRepresentation;
    }

    public void setLod4ImplicitRepresentation(ImplicitGeometryProperty lod4ImplicitRepresentation) {
        this.lod4ImplicitRepresentation = asChild(lod4ImplicitRepresentation);
    }
}
