/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2020 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.builder.cityjson.marshal.citygml.ade;

import org.citygml4j.builder.cityjson.marshal.CityJSONMarshaller;
import org.citygml4j.builder.cityjson.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.builder.cityjson.marshal.citygml.appearance.AppearanceMarshaller;
import org.citygml4j.builder.cityjson.marshal.citygml.bridge.BridgeMarshaller;
import org.citygml4j.builder.cityjson.marshal.citygml.building.BuildingMarshaller;
import org.citygml4j.builder.cityjson.marshal.citygml.cityfurniture.CityFurnitureMarshaller;
import org.citygml4j.builder.cityjson.marshal.citygml.cityobjectgroup.CityObjectGroupMarshaller;
import org.citygml4j.builder.cityjson.marshal.citygml.core.CoreMarshaller;
import org.citygml4j.builder.cityjson.marshal.citygml.generics.GenericsMarshaller;
import org.citygml4j.builder.cityjson.marshal.citygml.landuse.LandUseMarshaller;
import org.citygml4j.builder.cityjson.marshal.citygml.relief.ReliefMarshaller;
import org.citygml4j.builder.cityjson.marshal.citygml.transportation.TransportationMarshaller;
import org.citygml4j.builder.cityjson.marshal.citygml.tunnel.TunnelMarshaller;
import org.citygml4j.builder.cityjson.marshal.citygml.vegetation.VegetationMarshaller;
import org.citygml4j.builder.cityjson.marshal.citygml.waterbody.WaterBodyMarshaller;
import org.citygml4j.builder.cityjson.marshal.gml.GMLMarshaller;

public class ADEMarshallerHelper {
    private final CityJSONMarshaller json;

    public ADEMarshallerHelper(CityJSONMarshaller json) {
        this.json = json;
    }

    public CityGMLMarshaller getCityGMLMarshaller() {
        return json.getCityGMLMarshaller();
    }

    public AppearanceMarshaller getAppearanceMarshaller() {
        return json.getCityGMLMarshaller().getAppearanceMarshaller();
    }

    public BridgeMarshaller getBridgeMarshaller() {
        return json.getCityGMLMarshaller().getBridgeMarshaller();
    }

    public BuildingMarshaller getBuildingMarshaller() {
        return json.getCityGMLMarshaller().getBuildingMarshaller();
    }

    public CoreMarshaller getCoreMarshaller() {
        return json.getCityGMLMarshaller().getCoreMarshaller();
    }

    public CityFurnitureMarshaller getCityFurnitureMarshaller() {
        return json.getCityGMLMarshaller().getCityFurnitureMarshaller();
    }

    public CityObjectGroupMarshaller getCityObjectGroupMarshaller() {
        return json.getCityGMLMarshaller().getCityObjectGroupMarshaller();
    }

    public GenericsMarshaller getGenericsMarshaller() {
        return json.getCityGMLMarshaller().getGenericsMarshaller();
    }

    public LandUseMarshaller getLandUseMarshaller() {
        return json.getCityGMLMarshaller().getLandUseMarshaller();
    }

    public ReliefMarshaller getReliefMarshaller() {
        return json.getCityGMLMarshaller().getReliefMarshaller();
    }

    public TransportationMarshaller getTransportationMarshaller() {
        return json.getCityGMLMarshaller().getTransportationMarshaller();
    }

    public TunnelMarshaller getTunnelMarshaller() {
        return json.getCityGMLMarshaller().getTunnelMarshaller();
    }

    public VegetationMarshaller getVegetationMarshaller() {
        return json.getCityGMLMarshaller().getVegetationMarshaller();
    }

    public WaterBodyMarshaller getWaterBodyMarshaller() {
        return json.getCityGMLMarshaller().getWaterBodyMarshaller();
    }

    public GMLMarshaller getGMLMarshaller() {
        return json.getGMLMarshaller();
    }

}
