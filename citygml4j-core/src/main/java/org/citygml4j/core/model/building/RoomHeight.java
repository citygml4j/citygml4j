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

package org.citygml4j.core.model.building;

import org.citygml4j.core.model.CityGMLObject;
import org.citygml4j.core.model.construction.HeightStatusValue;
import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.measures.Length;

public class RoomHeight extends GMLObject implements CityGMLObject {
    private Code highReference;
    private Code lowReference;
    private HeightStatusValue status;
    private Length value;

    public RoomHeight() {
    }

    public RoomHeight(Code highReference, Code lowReference, HeightStatusValue status, Length value) {
        this.highReference = highReference;
        this.lowReference = lowReference;
        this.status = status;
        setValue(value);
    }

    public Code getHighReference() {
        return highReference;
    }

    public void setHighReference(Code highReference) {
        this.highReference = asChild(highReference);
    }

    public Code getLowReference() {
        return lowReference;
    }

    public void setLowReference(Code lowReference) {
        this.lowReference = asChild(lowReference);
    }

    public HeightStatusValue getStatus() {
        return status;
    }

    public void setStatus(HeightStatusValue status) {
        this.status = status;
    }

    public Length getValue() {
        return value;
    }

    public void setValue(Length value) {
        this.value = asChild(value);
    }
}
