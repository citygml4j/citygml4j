/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2024 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.core.model.construction;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.geometry.DirectPosition;

public class Elevation extends GMLObject implements CityGMLObject {
    private Code elevationReference;
    private DirectPosition elevationValue;

    public Elevation() {
    }

    public Elevation(Code elevationReference, DirectPosition elevationValue) {
        setElevationReference(elevationReference);
        setElevationValue(elevationValue);
    }

    public Code getElevationReference() {
        return elevationReference;
    }

    public void setElevationReference(Code elevationReference) {
        this.elevationReference = asChild(elevationReference);
    }

    public DirectPosition getElevationValue() {
        return elevationValue;
    }

    public void setElevationValue(DirectPosition elevationValue) {
        this.elevationValue = asChild(elevationValue);
    }
}
