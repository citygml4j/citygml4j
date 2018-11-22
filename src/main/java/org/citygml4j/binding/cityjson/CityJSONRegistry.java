package org.citygml4j.binding.cityjson;

import org.citygml4j.binding.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.binding.cityjson.feature.BridgeConstructionElementType;
import org.citygml4j.binding.cityjson.feature.BridgeInstallationType;
import org.citygml4j.binding.cityjson.feature.BridgePartType;
import org.citygml4j.binding.cityjson.feature.BridgeType;
import org.citygml4j.binding.cityjson.feature.BuildingInstallationType;
import org.citygml4j.binding.cityjson.feature.BuildingPartType;
import org.citygml4j.binding.cityjson.feature.BuildingType;
import org.citygml4j.binding.cityjson.feature.CityFurnitureType;
import org.citygml4j.binding.cityjson.feature.CityObjectGroupType;
import org.citygml4j.binding.cityjson.feature.GenericCityObjectType;
import org.citygml4j.binding.cityjson.feature.LandUseType;
import org.citygml4j.binding.cityjson.feature.PlantCoverType;
import org.citygml4j.binding.cityjson.feature.RailwayType;
import org.citygml4j.binding.cityjson.feature.RoadType;
import org.citygml4j.binding.cityjson.feature.SolitaryVegetationObjectType;
import org.citygml4j.binding.cityjson.feature.TINReliefType;
import org.citygml4j.binding.cityjson.feature.TransportSquareType;
import org.citygml4j.binding.cityjson.feature.TunnelInstallationType;
import org.citygml4j.binding.cityjson.feature.TunnelPartType;
import org.citygml4j.binding.cityjson.feature.TunnelType;
import org.citygml4j.binding.cityjson.feature.WaterBodyType;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CityJSONRegistry {
    private static CityJSONRegistry instance;

    private final Map<String, Class<? extends AbstractCityObjectType>> typeToClass;

    private CityJSONRegistry() {
        typeToClass = new ConcurrentHashMap<>();

        registerType("Building", BuildingType.class);
        registerType("BuildingPart", BuildingPartType.class);
        registerType("BuildingInstallation", BuildingInstallationType.class);
        registerType("Bridge", BridgeType.class);
        registerType("BridgePart", BridgePartType.class);
        registerType("BridgeInstallation", BridgeInstallationType.class);
        registerType("BridgeConstructionElement", BridgeConstructionElementType.class);
        registerType("TINRelief", TINReliefType.class);
        registerType("WaterBody", WaterBodyType.class);
        registerType("PlantCover", PlantCoverType.class);
        registerType("SolitaryVegetationObject", SolitaryVegetationObjectType.class);
        registerType("LandUse", LandUseType.class);
        registerType("CityFurniture", CityFurnitureType.class);
        registerType("GenericCityObject", GenericCityObjectType.class);
        registerType("Road", RoadType.class);
        registerType("Railway", RailwayType.class);
        registerType("TransportSquare", TransportSquareType.class);
        registerType("Tunnel", TunnelType.class);
        registerType("TunnelPart", TunnelPartType.class);
        registerType("TunnelInstallation", TunnelInstallationType.class);
        registerType("CityObjectGroup", CityObjectGroupType.class);
    }

    public static synchronized CityJSONRegistry getInstance() {
        if (instance == null)
            instance = new CityJSONRegistry();

        return instance;
    }

    public String getCityObjectType(AbstractCityObjectType cityObject) {
        String type = null;
        for (Map.Entry<String, Class<? extends AbstractCityObjectType>> entry : typeToClass.entrySet()) {
            if (cityObject.getClass() == entry.getValue()) {
                type = entry.getKey();
                break;
            }
        }

        if (type == null)
            type = cityObject.getClass().getTypeName();

        return type;
    }

    public Class<?> getCityObjectClass(String type) {
        Class<?> typeClass = typeToClass.get(type);
        if (typeClass == null) {
            try {
                Class<?> tmp = Class.forName(type);
                if (AbstractCityObjectType.class.isAssignableFrom(tmp))
                    typeClass = tmp;
            } catch (ClassNotFoundException e) {
                //
            }
        }

        return typeClass;
    }

    private void registerType(String type, Class<? extends AbstractCityObjectType> typeClass) {
        typeToClass.put(type, typeClass);
    }
}
