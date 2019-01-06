package org.citygml4j.binding.cityjson;

import org.citygml4j.binding.cityjson.extension.ExtensibleType;
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
import org.citygml4j.binding.cityjson.geometry.SemanticsType;
import org.citygml4j.model.citygml.ade.ADEException;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class CityJSONRegistry {
    private static CityJSONRegistry instance;

    private final Map<String, Class<? extends AbstractCityObjectType>> types;
    private final Map<String, Class<? extends SemanticsType>> semanticSurfaces;
    private final Map<Class<? extends ExtensibleType>, Map<String, Type>> properties;

    private final Set<String> coreTypes;

    private CityJSONRegistry() {
        types = new ConcurrentHashMap<>();
        semanticSurfaces = new ConcurrentHashMap<>();
        properties = new ConcurrentHashMap<>();

        types.put("Building", BuildingType.class);
        types.put("BuildingPart", BuildingPartType.class);
        types.put("BuildingInstallation", BuildingInstallationType.class);
        types.put("Bridge", BridgeType.class);
        types.put("BridgePart", BridgePartType.class);
        types.put("BridgeInstallation", BridgeInstallationType.class);
        types.put("BridgeConstructionElement", BridgeConstructionElementType.class);
        types.put("TINRelief", TINReliefType.class);
        types.put("WaterBody", WaterBodyType.class);
        types.put("PlantCover", PlantCoverType.class);
        types.put("SolitaryVegetationObject", SolitaryVegetationObjectType.class);
        types.put("LandUse", LandUseType.class);
        types.put("CityFurniture", CityFurnitureType.class);
        types.put("GenericCityObject", GenericCityObjectType.class);
        types.put("Road", RoadType.class);
        types.put("Railway", RailwayType.class);
        types.put("TransportSquare", TransportSquareType.class);
        types.put("Tunnel", TunnelType.class);
        types.put("TunnelPart", TunnelPartType.class);
        types.put("TunnelInstallation", TunnelInstallationType.class);
        types.put("CityObjectGroup", CityObjectGroupType.class);

        semanticSurfaces.put("RoofSurface", SemanticsType.class);
        semanticSurfaces.put("GroundSurface", SemanticsType.class);
        semanticSurfaces.put("WallSurface", SemanticsType.class);
        semanticSurfaces.put("ClosureSurface", SemanticsType.class);
        semanticSurfaces.put("OuterCeilingSurface", SemanticsType.class);
        semanticSurfaces.put("OuterFloorSurface", SemanticsType.class);
        semanticSurfaces.put("Window", SemanticsType.class);
        semanticSurfaces.put("Door", SemanticsType.class);
        semanticSurfaces.put("TrafficArea", SemanticsType.class);
        semanticSurfaces.put("AuxiliaryTrafficArea", SemanticsType.class);
        semanticSurfaces.put("WaterSurface", SemanticsType.class);
        semanticSurfaces.put("WaterGroundSurface", SemanticsType.class);
        semanticSurfaces.put("WaterClosureSurface", SemanticsType.class);

        coreTypes = new HashSet<>(types.keySet());
    }

    public static synchronized CityJSONRegistry getInstance() {
        if (instance == null)
            instance = new CityJSONRegistry();

        return instance;
    }

    public boolean isCoreCityObject(String type) {
        return coreTypes.contains(type);
    }

    public String getCityObjectType(AbstractCityObjectType cityObject) {
        String type = null;
        for (Map.Entry<String, Class<? extends AbstractCityObjectType>> entry : types.entrySet()) {
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
        Class<?> typeClass = types.get(type);
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

    public void registerCityObject(String type, Class<? extends AbstractCityObjectType> typeClass) throws ADEException {
        if (type == null)
            throw new ADEException("The city object type must not be null.");

        if (typeClass == null)
            throw new ADEException("The city object type class must not be null.");

        if (types.containsKey(type))
            throw new ADEException("The city object type '" + type + "' is already registered.");

        if (types.containsValue(typeClass))
            throw new ADEException("The city object type class '" + typeClass.getTypeName() + "' is already registered.");

        types.put(type, typeClass);
    }

    public void unregisterCityObject(String type) {
        types.remove(type);
    }

    public String getSemanticSurfaceType(SemanticsType semanticsType) {
        String type = null;
        for (Map.Entry<String, Class<? extends SemanticsType>> entry : semanticSurfaces.entrySet()) {
            if (semanticsType.getClass() == entry.getValue()) {
                type = entry.getKey();
                break;
            }
        }

        if (type == null)
            type = semanticsType.getClass().getTypeName();

        return type;
    }

    public Class<?> getSemanticSurfaceClass(String type) {
        Class<?> typeClass = semanticSurfaces.get(type);
        if (typeClass == null) {
            try {
                Class<?> tmp = Class.forName(type);
                if (SemanticsType.class.isAssignableFrom(tmp))
                    typeClass = tmp;
            } catch (ClassNotFoundException e) {
                //
            }
        }

        return typeClass;
    }

    public void registerSemanticSurface(String type, Class<? extends SemanticsType> semanticSurfaceClass) throws ADEException {
        if (type == null)
            throw new ADEException("The semantic surface type must not be null.");

        if (semanticSurfaceClass == null)
            throw new ADEException("The semantic surface class must not be null.");

        if (semanticSurfaces.containsKey(type))
            throw new ADEException("The semantic surface type '" + type + "' is already registered.");

        if (semanticSurfaces.containsValue(semanticSurfaceClass))
            throw new ADEException("The semantic surface class '" + semanticSurfaceClass.getTypeName() + "' is already registered.");

        semanticSurfaces.put(type, semanticSurfaceClass);
    }

    public void unregisterSemanticSurface(String type) {
        semanticSurfaces.remove(type);
    }

    public Type getExtensionPropertyClass(String propertyName, ExtensibleType target) {
        for (Map.Entry<Class<? extends ExtensibleType>, Map<String, Type>> entry : properties.entrySet()) {
            if (entry.getKey().isInstance(target))
                return entry.getValue().get(propertyName);
        }

        return null;
    }

    public boolean hasExtensionProperty(String propertyName, ExtensibleType target) {
        return getExtensionPropertyClass(propertyName, target) != null;
    }

    public void registerExtensionProperty(String name, Type attributeType, Class<? extends ExtensibleType> targetClass) throws ADEException {
        if (name == null)
            throw new ADEException("The extension property name must not be null.");

        if (attributeType == null)
            throw new ADEException("The extension property type must not be null.");

        if (targetClass == null)
            throw new ADEException("The extension property target class must not be null.");

        for (Map.Entry<Class<? extends ExtensibleType>, Map<String, Type>> entry : properties.entrySet()) {
            if (entry.getKey().isAssignableFrom(targetClass) || targetClass.isAssignableFrom(entry.getKey())) {
                if (entry.getValue().containsKey(name))
                    throw new ADEException("The extension property '" + name + "' is already registered with " + entry.getKey().getTypeName());
            }
        }

        Map<String, Type> property = properties.computeIfAbsent(targetClass, v -> new ConcurrentHashMap<>());
        property.put(name, attributeType);
    }

    public void unregisterExtensionProperty(String name, Class<? extends ExtensibleType> targetClass) {
        if (targetClass != null) {
            for (Map.Entry<Class<? extends ExtensibleType>, Map<String, Type>> entry : properties.entrySet()) {
                if (entry.getKey().isAssignableFrom(targetClass) || targetClass.isAssignableFrom(entry.getKey()))
                    entry.getValue().remove(name);
            }
        }
    }
}
