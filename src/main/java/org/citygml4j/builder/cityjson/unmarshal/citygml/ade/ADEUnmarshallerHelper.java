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

package org.citygml4j.builder.cityjson.unmarshal.citygml.ade;

import org.citygml4j.builder.cityjson.unmarshal.CityJSONUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.citygml.CityGMLUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.citygml.appearance.AppearanceUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.citygml.bridge.BridgeUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.citygml.building.BuildingUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.citygml.cityfurniture.CityFurnitureUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.citygml.cityobjectgroup.CityObjectGroupUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.citygml.core.CoreUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.citygml.generics.GenericsUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.citygml.landuse.LandUseUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.citygml.relief.ReliefUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.citygml.transportation.TransportationUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.citygml.vegetation.VegetationUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.citygml.waterbody.WaterBodyUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.gml.GMLUnmarshaller;

public class ADEUnmarshallerHelper {
    private final CityJSONUnmarshaller json;

    public ADEUnmarshallerHelper(CityJSONUnmarshaller json) {
        this.json = json;
    }

    public CityGMLUnmarshaller getCityGMLUnmarshaller() {
        return json.getCityGMLUnmarshaller();
    }

    public AppearanceUnmarshaller getAppearanceUnmarshaller() {
        return json.getCityGMLUnmarshaller().getAppearanceUnmarshaller();
    }

    public BridgeUnmarshaller getBridgeUnmarshaller() {
        return json.getCityGMLUnmarshaller().getBridgeUnmarshaller();
    }

    public BuildingUnmarshaller getBuildingUnmarshaller() {
        return json.getCityGMLUnmarshaller().getBuildingUnmarshaller();
    }

    public CityFurnitureUnmarshaller getCityFurnitureUnmarshaller() {
        return json.getCityGMLUnmarshaller().getCityFurnitureUnmarshaller();
    }

    public CityObjectGroupUnmarshaller getCiyCityObjectGroupUnmarshaller() {
        return json.getCityGMLUnmarshaller().getCiyCityObjectGroupUnmarshaller();
    }

    public CoreUnmarshaller getCoreUnmarshaller() {
        return json.getCityGMLUnmarshaller().getCoreUnmarshaller();
    }

    public GenericsUnmarshaller getGenericsUnmarshaller() {
        return json.getCityGMLUnmarshaller().getGenericsUnmarshaller();
    }

    public LandUseUnmarshaller getLandUseUnmarshaller() {
        return json.getCityGMLUnmarshaller().getLandUseUnmarshaller();
    }

    public ReliefUnmarshaller getReliefUnmarshaller() {
        return json.getCityGMLUnmarshaller().getReliefUnmarshaller();
    }

    public TransportationUnmarshaller getTransportationUnmarshaller() {
        return json.getCityGMLUnmarshaller().getTransportationUnmarshaller();
    }

    public VegetationUnmarshaller getVegetationUnmarshaller() {
        return json.getCityGMLUnmarshaller().getVegetationUnmarshaller();
    }

    public WaterBodyUnmarshaller getWaterBodyUnmarshaller() {
        return json.getCityGMLUnmarshaller().getWaterBodyUnmarshaller();
    }

    public GMLUnmarshaller getGMLUnmarshaller() {
        return json.getGMLUnmarshaller();
    }
}
