package org.citygml4j.model.deprecated;

import org.citygml4j.model.core.ImplicitGeometryProperty;
import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;
import org.xmlobjects.gml.model.geometry.GeometryProperty;
import org.xmlobjects.gml.model.geometry.aggregates.MultiCurveProperty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class DeprecatedProperties extends GMLObject {
    public static final String GML_ID = "id";
    public static final String TARGET_URI = "uri";
    public static final String ROLE = "role";
    public static final String INT_BRIDGE_INSTALLATION = "IntBridgeInstallation";
    public static final String INT_BUILDING_INSTALLATION = "IntBuildingInstallation";
    public static final String INT_TUNNEL_INSTALLATION = "IntTunnelInstallation";
    public static final String TRANSPORTATION_COMPLEX = "TransportationComplex";

    public static final String CONSISTS_OF_BUILDING_PART = "consistsOfBuildingPart";
    public static final String OUTER_BUILDING_INSTALLATION = "outerBuildingInstallation";
    public static final String INTERIOR_BUILDING_INSTALLATION = "interiorBuildingInstallation";
    public static final String INTERIOR_ROOM = "interiorRoom";
    public static final String CONSISTS_OF_BRIDGE_PART = "consistsOfBridgePart";
    public static final String OUTER_BRIDGE_CONSTRUCTION = "outerBridgeConstruction";
    public static final String OUTER_BRIDGE_INSTALLATION = "outerBridgeInstallation";
    public static final String INTERIOR_BRIDGE_INSTALLATION = "interiorBridgeInstallation";
    public static final String INTERIOR_BRIDGE_ROOM = "interiorBridgeRoom";
    public static final String CONSISTS_OF_TUNNEL_PART = "consistsOfTunnelPart";
    public static final String OUTER_TUNNEL_INSTALLATION = "outerTunnelInstallation";
    public static final String INTERIOR_TUNNEL_INSTALLATION = "interiorTunnelInstallation";
    public static final String INTERIOR_HOLLOW_SPACE = "interiorHollowSpace";
    public static final String GENERALIZES_TO_OBJECT = "generalizesTo";
    public static final String OPENING = "opening";

    public static final String LOD0_ROOF_EDGE = "lod0RoofEdge";
    public static final String LOD0_MULTI_CURVE = "lod0MultiCurve";
    public static final String LOD1_MULTI_CURVE = "lod1MultiCurve";
    public static final String LOD4_MULTI_CURVE = "lod4MultiCurve";
    public static final String LOD1_MULTI_SURFACE = "lod1MultiSurface";
    public static final String LOD4_MULTI_SURFACE = "lod4MultiSurface";
    public static final String LOD4_SURFACE = "lod4Surface";
    public static final String LOD4_SOLID = "lod4Solid";
    public static final String LOD0_GEOMETRY = "lod0Geometry";
    public static final String LOD1_GEOMETRY = "lod1Geometry";
    public static final String LOD2_GEOMETRY = "lod2Geometry";
    public static final String LOD3_GEOMETRY = "lod3Geometry";
    public static final String LOD4_GEOMETRY = "lod4Geometry";
    public static final String LOD1_MULTI_SOLID = "lod1MultiSolid";
    public static final String LOD2_MULTI_SOLID = "lod2MultiSolid";
    public static final String LOD3_MULTI_SOLID = "lod3MultiSolid";
    public static final String LOD4_MULTI_SOLID = "lod4MultiSolid";
    public static final String GEOMETRY = "geometry";

    private Map<String, List<FeatureProperty>> features;
    private Map<Integer, Map<String, GeometryProperty>> geometries;
    private MultiCurveProperty lod0TerrainIntersectionCurve;
    private MultiCurveProperty lod1TerrainIntersectionCurve;
    private MultiCurveProperty lod2TerrainIntersectionCurve;
    private MultiCurveProperty lod3TerrainIntersectionCurve;
    private MultiCurveProperty lod4TerrainIntersectionCurve;
    private ImplicitGeometryProperty lod0ImplicitRepresentation;
    private ImplicitGeometryProperty lod1ImplicitRepresentation;
    private ImplicitGeometryProperty lod2ImplicitRepresentation;
    private ImplicitGeometryProperty lod3ImplicitRepresentation;
    private ImplicitGeometryProperty lod4ImplicitRepresentation;

    public List<FeatureProperty> getFeatures(String name) {
        return features != null ? features.get(name) : Collections.emptyList();
    }

    public <T extends FeatureProperty> List<T> getFeatures(String name, Class<T> type) {
        return getFeatures(name).stream()
                .filter(Objects::nonNull)
                .filter(p -> type.isAssignableFrom(p.getClass()))
                .map(type::cast)
                .collect(Collectors.toList());
    }

    public List<FeatureProperty> getFeatures() {
        return features != null ?
                features.values().stream().flatMap(Collection::stream).collect(Collectors.toList()) :
                Collections.emptyList();
    }

    public void addFeature(String name, FeatureProperty property) {
        if (features == null)
            features = new HashMap<>();

        features.computeIfAbsent(name, v -> new ArrayList<>()).add(asChild(property));
    }

    public boolean containsFeatures(String name) {
        return features != null && features.containsKey(name);
    }

    public void removeFeatures(String name) {
        if (features != null)
            features.remove(name);
    }

    public void clearFeatures() {
        if (features != null)
            features.clear();
    }

    public GeometryProperty getGeometry(int lod, String name) {
        return geometries != null ? geometries.getOrDefault(lod, Collections.emptyMap()).get(name) : null;
    }

    public GeometryProperty getNonLodGeometry(String name) {
        return getGeometry(-1, name);
    }

    public <T extends GeometryProperty> T getGeometry(int lod, String name, Class<T> type) {
        if (geometries != null) {
            GeometryProperty property = geometries.getOrDefault(lod, Collections.emptyMap()).get(name);
            return property != null && type.isAssignableFrom(property.getClass()) ? type.cast(property) : null;
        } else
            return null;
    }

    public <T extends GeometryProperty> T getNonLodGeometry(String name, Class<T> type) {
        return getGeometry(-1, name, type);
    }

    public List<GeometryProperty> getGeometries(int lod) {
        return geometries != null ?
                new ArrayList<>(geometries.getOrDefault(lod, Collections.emptyMap()).values()) :
                Collections.emptyList();
    }

    public List<GeometryProperty> getNonLodGeometries() {
        return getGeometries(-1);
    }

    public void addGeometry(int lod, String name, GeometryProperty property) {
        if (geometries == null)
            geometries = new HashMap<>();

        geometries.computeIfAbsent(lod, v -> new HashMap<>()).put(name, asChild(property));
    }

    public void addNonLodGeometry(String name, GeometryProperty property) {
        addGeometry(-1, name, property);
    }

    public boolean containsGeometry(int lod, String name) {
        return geometries != null && geometries.getOrDefault(lod, Collections.emptyMap()).containsKey(name);
    }

    public boolean containsNonLodGeometry(String name) {
        return containsGeometry(-1, name);
    }

    public void removeGeometry(int lod, String name) {
        if (geometries != null && geometries.containsKey(lod))
            geometries.get(lod).remove(name);
    }

    public void removeNonLodGeometry(String name) {
        removeGeometry(-1, name);
    }

    public void clearGeometries() {
        if (geometries != null)
            geometries.clear();
    }

    public MultiCurveProperty getLod0TerrainIntersectionCurve() {
        return lod0TerrainIntersectionCurve;
    }

    public void setLod0TerrainIntersectionCurve(MultiCurveProperty lod0TerrainIntersectionCurve) {
        this.lod0TerrainIntersectionCurve = asChild(lod0TerrainIntersectionCurve);
    }

    public MultiCurveProperty getLod1TerrainIntersectionCurve() {
        return lod1TerrainIntersectionCurve;
    }

    public void setLod1TerrainIntersectionCurve(MultiCurveProperty lod1TerrainIntersectionCurve) {
        this.lod1TerrainIntersectionCurve = asChild(lod1TerrainIntersectionCurve);
    }

    public MultiCurveProperty getLod2TerrainIntersectionCurve() {
        return lod2TerrainIntersectionCurve;
    }

    public void setLod2TerrainIntersectionCurve(MultiCurveProperty lod2TerrainIntersectionCurve) {
        this.lod2TerrainIntersectionCurve = asChild(lod2TerrainIntersectionCurve);
    }

    public MultiCurveProperty getLod3TerrainIntersectionCurve() {
        return lod3TerrainIntersectionCurve;
    }

    public void setLod3TerrainIntersectionCurve(MultiCurveProperty lod3TerrainIntersectionCurve) {
        this.lod3TerrainIntersectionCurve = asChild(lod3TerrainIntersectionCurve);
    }

    public MultiCurveProperty getLod4TerrainIntersectionCurve() {
        return lod4TerrainIntersectionCurve;
    }

    public void setLod4TerrainIntersectionCurve(MultiCurveProperty lod4TerrainIntersectionCurve) {
        this.lod4TerrainIntersectionCurve = asChild(lod4TerrainIntersectionCurve);
    }

    public ImplicitGeometryProperty getLod0ImplicitRepresentation() {
        return lod0ImplicitRepresentation;
    }

    public void setLod0ImplicitRepresentation(ImplicitGeometryProperty lod0ImplicitRepresentation) {
        this.lod0ImplicitRepresentation = asChild(lod0ImplicitRepresentation);
    }

    public ImplicitGeometryProperty getLod1ImplicitRepresentation() {
        return lod1ImplicitRepresentation;
    }

    public void setLod1ImplicitRepresentation(ImplicitGeometryProperty lod1ImplicitRepresentation) {
        this.lod1ImplicitRepresentation = asChild(lod1ImplicitRepresentation);
    }

    public ImplicitGeometryProperty getLod2ImplicitRepresentation() {
        return lod2ImplicitRepresentation;
    }

    public void setLod2ImplicitRepresentation(ImplicitGeometryProperty lod2ImplicitRepresentation) {
        this.lod2ImplicitRepresentation = asChild(lod2ImplicitRepresentation);
    }

    public ImplicitGeometryProperty getLod3ImplicitRepresentation() {
        return lod3ImplicitRepresentation;
    }

    public void setLod3ImplicitRepresentation(ImplicitGeometryProperty lod3ImplicitRepresentation) {
        this.lod3ImplicitRepresentation = asChild(lod3ImplicitRepresentation);
    }

    public ImplicitGeometryProperty getLod4ImplicitRepresentation() {
        return lod4ImplicitRepresentation;
    }

    public void setLod4ImplicitRepresentation(ImplicitGeometryProperty lod4ImplicitRepresentation) {
        this.lod4ImplicitRepresentation = asChild(lod4ImplicitRepresentation);
    }

    public MultiCurveProperty getTerrainIntersectionCurve(int lod) {
        switch (lod) {
            case 0:
                return getLod0TerrainIntersectionCurve();
            case 1:
                return getLod1TerrainIntersectionCurve();
            case 2:
                return getLod2TerrainIntersectionCurve();
            case 3:
                return getLod3TerrainIntersectionCurve();
            case 4:
                return getLod4TerrainIntersectionCurve();
            default:
                return null;
        }
    }

    public boolean setTerrainIntersectionCurve(int lod, MultiCurveProperty property) {
        switch (lod) {
            case 0:
                setLod0TerrainIntersectionCurve(property);
                return true;
            case 1:
                setLod1TerrainIntersectionCurve(property);
                return true;
            case 2:
                setLod2TerrainIntersectionCurve(property);
                return true;
            case 3:
                setLod3TerrainIntersectionCurve(property);
                return true;
            case 4:
                setLod4TerrainIntersectionCurve(property);
                return true;
            default:
                return false;
        }
    }

    public ImplicitGeometryProperty getImplicitRepresentation(int lod) {
        switch (lod) {
            case 0:
                return getLod0ImplicitRepresentation();
            case 1:
                return getLod1ImplicitRepresentation();
            case 2:
                return getLod2ImplicitRepresentation();
            case 3:
                return getLod3ImplicitRepresentation();
            case 4:
                return getLod4ImplicitRepresentation();
            default:
                return null;
        }
    }

    public boolean setImplicitRepresentation(int lod, ImplicitGeometryProperty property) {
        switch (lod) {
            case 0:
                setLod0ImplicitRepresentation(property);
                return true;
            case 1:
                setLod1ImplicitRepresentation(property);
                return true;
            case 2:
                setLod2ImplicitRepresentation(property);
                return true;
            case 3:
                setLod3ImplicitRepresentation(property);
                return true;
            case 4:
                setLod4ImplicitRepresentation(property);
                return true;
            default:
                return false;
        }
    }
}
