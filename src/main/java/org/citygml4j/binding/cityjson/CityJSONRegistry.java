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
import org.citygml4j.binding.cityjson.geometry.SemanticsType;
import org.citygml4j.model.citygml.ade.ADEException;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CityJSONRegistry {
    private static CityJSONRegistry instance;

    private final Map<String, Class<? extends AbstractCityObjectType>> types;
    private final Map<String, Class<? extends SemanticsType>> semanticSurfaces;
    private final Map<Class<? extends AbstractCityObjectType>, Map<String, Type>> attributes;

    private CityJSONRegistry() {
        types = new ConcurrentHashMap<>();
        semanticSurfaces = new ConcurrentHashMap<>();
        attributes = new ConcurrentHashMap<>();

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
    }

    public static synchronized CityJSONRegistry getInstance() {
        if (instance == null)
            instance = new CityJSONRegistry();

        return instance;
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

        if (!type.startsWith("+"))
            type = "+" + type;

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

        if (!type.startsWith("+"))
            type = "+" + type;

        semanticSurfaces.put(type, semanticSurfaceClass);
    }

    public void unregisterSemanticSurface(String type) {
        semanticSurfaces.remove(type);
    }

    public Type getExtensionAttributeClass(String propertyName, AbstractCityObjectType target) {
        for (Map.Entry<Class<? extends AbstractCityObjectType>, Map<String, Type>> entry : attributes.entrySet()) {
            if (entry.getKey().isInstance(target))
                return entry.getValue().get(propertyName);
        }

        return null;
    }

    public boolean hasExtensionAttribute(String propertyName, AbstractCityObjectType target) {
        return getExtensionAttributeClass(propertyName, target) != null;
    }

    public void registerExtensionAttribute(String name, Type attributeType, Class<? extends AbstractCityObjectType> targetClass) throws ADEException {
        if (name == null)
            throw new ADEException("The extension attribute name must not be null.");

        if (attributeType == null)
            throw new ADEException("The extension attribute type must not be null.");

        if (targetClass == null)
            throw new ADEException("The extension attribute target class must not be null.");

        for (Map.Entry<Class<? extends AbstractCityObjectType>, Map<String, Type>> entry : attributes.entrySet()) {
            if (entry.getKey().isAssignableFrom(targetClass) || targetClass.isAssignableFrom(entry.getKey())) {
                if (entry.getValue().containsKey(name))
                    throw new ADEException("The extension attribute '" + name + "' is already registered with " + entry.getKey().getTypeName());
            }
        }

        if (!name.startsWith("+"))
            name = "+" + name;

        Map<String, Type> attribute = attributes.computeIfAbsent(targetClass, v -> new ConcurrentHashMap<>());
        attribute.put(name, attributeType);
    }

    public void unregisterExtensionAttribute(String name, Class<? extends AbstractCityObjectType> targetClass) {
        if (targetClass != null) {
            for (Map.Entry<Class<? extends AbstractCityObjectType>, Map<String, Type>> entry : attributes.entrySet()) {
                if (entry.getKey().isAssignableFrom(targetClass) || targetClass.isAssignableFrom(entry.getKey()))
                    entry.getValue().remove(name);
            }
        }
    }
}
