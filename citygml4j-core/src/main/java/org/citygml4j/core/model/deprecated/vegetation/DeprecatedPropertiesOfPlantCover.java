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

package org.citygml4j.core.model.deprecated.vegetation;

import org.citygml4j.core.model.deprecated.core.DeprecatedPropertiesOfAbstractCityObject;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSolidProperty;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSurfaceProperty;

public class DeprecatedPropertiesOfPlantCover extends DeprecatedPropertiesOfAbstractCityObject {
    private MultiSurfaceProperty lod1MultiSurface;
    private MultiSurfaceProperty lod4MultiSurface;
    private MultiSolidProperty lod1MultiSolid;
    private MultiSolidProperty lod2MultiSolid;
    private MultiSolidProperty lod3MultiSolid;
    private MultiSolidProperty lod4MultiSolid;

    public MultiSurfaceProperty getLod1MultiSurface() {
        return lod1MultiSurface;
    }

    public void setLod1MultiSurface(MultiSurfaceProperty lod1MultiSurface) {
        this.lod1MultiSurface = asChild(lod1MultiSurface);
    }

    public MultiSurfaceProperty getLod4MultiSurface() {
        return lod4MultiSurface;
    }

    public void setLod4MultiSurface(MultiSurfaceProperty lod4MultiSurface) {
        this.lod4MultiSurface = asChild(lod4MultiSurface);
    }

    public MultiSolidProperty getLod1MultiSolid() {
        return lod1MultiSolid;
    }

    public void setLod1MultiSolid(MultiSolidProperty lod1MultiSolid) {
        this.lod1MultiSolid = asChild(lod1MultiSolid);
    }

    public MultiSolidProperty getLod2MultiSolid() {
        return lod2MultiSolid;
    }

    public void setLod2MultiSolid(MultiSolidProperty lod2MultiSolid) {
        this.lod2MultiSolid = asChild(lod2MultiSolid);
    }

    public MultiSolidProperty getLod3MultiSolid() {
        return lod3MultiSolid;
    }

    public void setLod3MultiSolid(MultiSolidProperty lod3MultiSolid) {
        this.lod3MultiSolid = asChild(lod3MultiSolid);
    }

    public MultiSolidProperty getLod4MultiSolid() {
        return lod4MultiSolid;
    }

    public void setLod4MultiSolid(MultiSolidProperty lod4MultiSolid) {
        this.lod4MultiSolid = asChild(lod4MultiSolid);
    }
}
