package org.citygml4j.builder.cityjson.unmarshal.citygml.ade;

import org.citygml4j.builder.cityjson.unmarshal.CityJSONUnmarshaller;
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

    public CityJSONUnmarshaller getCityJSONUnmarshaller() {
        return json;
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
