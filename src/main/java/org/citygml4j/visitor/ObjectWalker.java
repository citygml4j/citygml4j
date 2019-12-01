package org.citygml4j.visitor;

import org.citygml4j.model.appearance.GeoreferencedTexture;
import org.citygml4j.model.appearance.TextureAssociation;
import org.citygml4j.model.bridge.AbstractBridge;
import org.citygml4j.model.bridge.BridgeConstructiveElement;
import org.citygml4j.model.bridge.BridgeFurniture;
import org.citygml4j.model.bridge.BridgeInstallation;
import org.citygml4j.model.bridge.BridgeRoom;
import org.citygml4j.model.building.AbstractBuilding;
import org.citygml4j.model.building.BuildingFurniture;
import org.citygml4j.model.building.BuildingInstallation;
import org.citygml4j.model.building.BuildingRoom;
import org.citygml4j.model.cityfurniture.CityFurniture;
import org.citygml4j.model.cityobjectgroup.CityObjectGroup;
import org.citygml4j.model.cityobjectgroup.Role;
import org.citygml4j.model.common.VisitableFeature;
import org.citygml4j.model.common.VisitableObject;
import org.citygml4j.model.construction.AbstractFillingSurface;
import org.citygml4j.model.core.AbstractAppearanceProperty;
import org.citygml4j.model.core.AbstractOccupiedSpace;
import org.citygml4j.model.core.AbstractPhysicalSpace;
import org.citygml4j.model.core.AbstractSpace;
import org.citygml4j.model.core.AbstractThematicSurface;
import org.citygml4j.model.core.Address;
import org.citygml4j.model.core.CityObjectRelation;
import org.citygml4j.model.core.ImplicitGeometry;
import org.citygml4j.model.deprecated.bridge.DeprecatedPropertiesOfAbstractBridge;
import org.citygml4j.model.deprecated.bridge.DeprecatedPropertiesOfBridgeConstructiveElement;
import org.citygml4j.model.deprecated.bridge.DeprecatedPropertiesOfBridgeFurniture;
import org.citygml4j.model.deprecated.bridge.DeprecatedPropertiesOfBridgeInstallation;
import org.citygml4j.model.deprecated.bridge.DeprecatedPropertiesOfBridgeRoom;
import org.citygml4j.model.deprecated.building.DeprecatedPropertiesOfAbstractBuilding;
import org.citygml4j.model.deprecated.building.DeprecatedPropertiesOfBuildingFurniture;
import org.citygml4j.model.deprecated.building.DeprecatedPropertiesOfBuildingInstallation;
import org.citygml4j.model.deprecated.building.DeprecatedPropertiesOfBuildingRoom;
import org.citygml4j.model.deprecated.cityfurniture.DeprecatedPropertiesOfCityFurniture;
import org.citygml4j.model.deprecated.cityobjectgroup.DeprecatedPropertiesOfCityObjectGroup;
import org.citygml4j.model.deprecated.construction.DeprecatedPropertiesOfAbstractFillingSurface;
import org.citygml4j.model.deprecated.core.DeprecatedPropertiesOfAbstractThematicSurface;
import org.citygml4j.model.deprecated.generics.DeprecatedPropertiesOfGenericOccupiedSpace;
import org.citygml4j.model.deprecated.transportation.DeprecatedPropertiesOfAbstractTransportationSpace;
import org.citygml4j.model.deprecated.tunnel.DeprecatedPropertiesOfAbstractTunnel;
import org.citygml4j.model.deprecated.tunnel.DeprecatedPropertiesOfHollowSpace;
import org.citygml4j.model.deprecated.tunnel.DeprecatedPropertiesOfTunnelFurniture;
import org.citygml4j.model.deprecated.tunnel.DeprecatedPropertiesOfTunnelInstallation;
import org.citygml4j.model.deprecated.vegetation.DeprecatedPropertiesOfPlantCover;
import org.citygml4j.model.deprecated.vegetation.DeprecatedPropertiesOfSolitaryVegetationObject;
import org.citygml4j.model.deprecated.waterbody.DeprecatedPropertiesOfWaterBody;
import org.citygml4j.model.dynamizer.GenericTimeseries;
import org.citygml4j.model.dynamizer.TimeValuePair;
import org.citygml4j.model.dynamizer.TimeValuePairProperty;
import org.citygml4j.model.generics.GenericOccupiedSpace;
import org.citygml4j.model.pointcloud.PointCloud;
import org.citygml4j.model.relief.AbstractReliefComponent;
import org.citygml4j.model.relief.BreaklineRelief;
import org.citygml4j.model.relief.MassPointRelief;
import org.citygml4j.model.relief.RasterRelief;
import org.citygml4j.model.relief.TINRelief;
import org.citygml4j.model.transportation.AbstractTransportationSpace;
import org.citygml4j.model.tunnel.AbstractTunnel;
import org.citygml4j.model.tunnel.HollowSpace;
import org.citygml4j.model.tunnel.TunnelFurniture;
import org.citygml4j.model.tunnel.TunnelInstallation;
import org.citygml4j.model.vegetation.PlantCover;
import org.citygml4j.model.vegetation.SolitaryVegetationObject;
import org.citygml4j.model.waterbody.WaterBody;
import org.xmlobjects.gml.model.base.AbstractGML;
import org.xmlobjects.gml.model.base.AbstractInlineProperty;
import org.xmlobjects.gml.model.base.AbstractProperty;
import org.xmlobjects.gml.model.coverage.AbstractCoverage;
import org.xmlobjects.gml.model.coverage.RangeSet;
import org.xmlobjects.gml.model.feature.AbstractFeature;
import org.xmlobjects.gml.model.geometry.AbstractGeometry;
import org.xmlobjects.gml.model.geometry.AbstractInlineGeometryProperty;
import org.xmlobjects.gml.model.geometry.GeometryArrayProperty;
import org.xmlobjects.gml.model.geometry.GeometryProperty;
import org.xmlobjects.gml.model.geometry.aggregates.AbstractGeometricAggregate;
import org.xmlobjects.gml.model.geometry.aggregates.AbstractMultiPoint;
import org.xmlobjects.gml.model.geometry.aggregates.MultiCurve;
import org.xmlobjects.gml.model.geometry.aggregates.MultiGeometry;
import org.xmlobjects.gml.model.geometry.aggregates.MultiPoint;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSolid;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSurface;
import org.xmlobjects.gml.model.geometry.compact.AbstractSimplePolygon;
import org.xmlobjects.gml.model.geometry.compact.SimpleMultiPoint;
import org.xmlobjects.gml.model.geometry.compact.SimplePolygon;
import org.xmlobjects.gml.model.geometry.compact.SimpleRectangle;
import org.xmlobjects.gml.model.geometry.compact.SimpleTriangle;
import org.xmlobjects.gml.model.geometry.complexes.CompositeCurve;
import org.xmlobjects.gml.model.geometry.complexes.CompositeSolid;
import org.xmlobjects.gml.model.geometry.complexes.CompositeSurface;
import org.xmlobjects.gml.model.geometry.complexes.GeometricComplex;
import org.xmlobjects.gml.model.geometry.grids.Grid;
import org.xmlobjects.gml.model.geometry.grids.RectifiedGrid;
import org.xmlobjects.gml.model.geometry.primitives.AbstractCurve;
import org.xmlobjects.gml.model.geometry.primitives.AbstractGeometricPrimitive;
import org.xmlobjects.gml.model.geometry.primitives.AbstractRing;
import org.xmlobjects.gml.model.geometry.primitives.AbstractRingProperty;
import org.xmlobjects.gml.model.geometry.primitives.AbstractSolid;
import org.xmlobjects.gml.model.geometry.primitives.AbstractSurface;
import org.xmlobjects.gml.model.geometry.primitives.AbstractSurfacePatch;
import org.xmlobjects.gml.model.geometry.primitives.Curve;
import org.xmlobjects.gml.model.geometry.primitives.CurveProperty;
import org.xmlobjects.gml.model.geometry.primitives.GeometricPrimitiveProperty;
import org.xmlobjects.gml.model.geometry.primitives.LineString;
import org.xmlobjects.gml.model.geometry.primitives.LinearRing;
import org.xmlobjects.gml.model.geometry.primitives.OrientableCurve;
import org.xmlobjects.gml.model.geometry.primitives.OrientableSurface;
import org.xmlobjects.gml.model.geometry.primitives.Point;
import org.xmlobjects.gml.model.geometry.primitives.PointProperty;
import org.xmlobjects.gml.model.geometry.primitives.Polygon;
import org.xmlobjects.gml.model.geometry.primitives.PolygonPatch;
import org.xmlobjects.gml.model.geometry.primitives.PolyhedralSurface;
import org.xmlobjects.gml.model.geometry.primitives.Rectangle;
import org.xmlobjects.gml.model.geometry.primitives.Ring;
import org.xmlobjects.gml.model.geometry.primitives.Shell;
import org.xmlobjects.gml.model.geometry.primitives.ShellProperty;
import org.xmlobjects.gml.model.geometry.primitives.Solid;
import org.xmlobjects.gml.model.geometry.primitives.SolidProperty;
import org.xmlobjects.gml.model.geometry.primitives.Surface;
import org.xmlobjects.gml.model.geometry.primitives.SurfacePatchArrayProperty;
import org.xmlobjects.gml.model.geometry.primitives.SurfaceProperty;
import org.xmlobjects.gml.model.geometry.primitives.Tin;
import org.xmlobjects.gml.model.geometry.primitives.Triangle;
import org.xmlobjects.gml.model.geometry.primitives.TriangulatedSurface;
import org.xmlobjects.gml.model.temporal.TimeInstant;
import org.xmlobjects.gml.model.temporal.TimeInstantProperty;
import org.xmlobjects.gml.model.temporal.TimePeriod;
import org.xmlobjects.gml.model.valueobjects.AbstractValue;
import org.xmlobjects.gml.model.valueobjects.CompositeValue;
import org.xmlobjects.gml.model.valueobjects.Value;
import org.xmlobjects.gml.model.valueobjects.ValueArray;
import org.xmlobjects.gml.model.valueobjects.ValueProperty;

import java.util.ArrayList;

public abstract class ObjectWalker extends FeatureWalker implements ObjectVisitor {

    public void visit(AbstractGML gml) {
    }

    @Override
    public void visit(AbstractFeature feature) {
        visit((AbstractGML) feature);
        super.visit(feature);

        if (feature.getLocation() != null)
            visit(feature.getLocation());
    }

    @Override
    public void visit(AbstractBridge bridge) {
        super.visit(bridge);

        if (bridge.hasDeprecatedProperties()) {
            DeprecatedPropertiesOfAbstractBridge deprecatedProperties = bridge.getDeprecatedProperties();

            if (deprecatedProperties.getLod1MultiSurface() != null)
                visit(deprecatedProperties.getLod1MultiSurface());

            if (deprecatedProperties.getLod4MultiCurve() != null)
                visit(deprecatedProperties.getLod4MultiCurve());

            if (deprecatedProperties.getLod4MultiSurface() != null)
                visit(deprecatedProperties.getLod4MultiSurface());

            if (deprecatedProperties.getLod4Solid() != null)
                visit(deprecatedProperties.getLod4Solid());

            if (deprecatedProperties.getLod4TerrainIntersectionCurve() != null)
                visit(deprecatedProperties.getLod4TerrainIntersectionCurve());
        }
    }

    @Override
    public void visit(AbstractBuilding building) {
        super.visit(building);

        if (building.hasDeprecatedProperties()) {
            DeprecatedPropertiesOfAbstractBuilding deprecatedProperties = building.getDeprecatedProperties();

            if (deprecatedProperties.getLod0RoofEdge() != null)
                visit(deprecatedProperties.getLod0RoofEdge());

            if (deprecatedProperties.getLod1MultiSurface() != null)
                visit(deprecatedProperties.getLod1MultiSurface());

            if (deprecatedProperties.getLod4MultiCurve() != null)
                visit(deprecatedProperties.getLod4MultiCurve());

            if (deprecatedProperties.getLod4MultiSurface() != null)
                visit(deprecatedProperties.getLod4MultiSurface());

            if (deprecatedProperties.getLod4Solid() != null)
                visit(deprecatedProperties.getLod4Solid());

            if (deprecatedProperties.getLod4TerrainIntersectionCurve() != null)
                visit(deprecatedProperties.getLod4TerrainIntersectionCurve());
        }
    }

    @Override
    public void visit(AbstractCoverage<?> coverage) {
        super.visit(coverage);

        if (coverage.getDomainSet() != null)
            visit(coverage.getDomainSet());

        if (coverage.getRangeSet() != null) {
            RangeSet rangeSet = coverage.getRangeSet();

            if (rangeSet.getValueArrays() != null) {
                for (ValueArray valueArray : rangeSet.getValueArrays())
                    visit(valueArray);
            }
        }
    }

    @Override
    public void visit(AbstractFillingSurface fillingSurface) {
        super.visit(fillingSurface);

        if (fillingSurface.hasDeprecatedProperties()) {
            DeprecatedPropertiesOfAbstractFillingSurface deprecatedProperties = fillingSurface.getDeprecatedProperties();

            if (deprecatedProperties.getLod3ImplicitRepresentation() != null)
                visit(deprecatedProperties.getLod3ImplicitRepresentation());

            if (deprecatedProperties.getLod4ImplicitRepresentation() != null)
                visit(deprecatedProperties.getLod4ImplicitRepresentation());
        }
    }

    @Override
    public void visit(AbstractOccupiedSpace occupiedSpace) {
        super.visit(occupiedSpace);

        if (occupiedSpace.getLod1ImplicitRepresentation() != null)
            visit(occupiedSpace.getLod1ImplicitRepresentation());

        if (occupiedSpace.getLod2ImplicitRepresentation() != null)
            visit(occupiedSpace.getLod2ImplicitRepresentation());

        if (occupiedSpace.getLod3ImplicitRepresentation() != null)
            visit(occupiedSpace.getLod3ImplicitRepresentation());
    }

    @Override
    public void visit(AbstractPhysicalSpace physicalSpace) {
        super.visit(physicalSpace);

        if (physicalSpace.getLod1TerrainIntersectionCurve() != null)
            visit(physicalSpace.getLod1TerrainIntersectionCurve());

        if (physicalSpace.getLod2TerrainIntersectionCurve() != null)
            visit(physicalSpace.getLod2TerrainIntersectionCurve());

        if (physicalSpace.getLod3TerrainIntersectionCurve() != null)
            visit(physicalSpace.getLod3TerrainIntersectionCurve());
    }

    @Override
    public void visit(AbstractReliefComponent reliefComponent) {
        super.visit(reliefComponent);

        if (reliefComponent.getExtent() != null)
            visit(reliefComponent.getExtent());
    }

    @Override
    public void visit(AbstractSpace space) {
        super.visit(space);

        if (space.getLod0Point() != null)
            visit(space.getLod0Point());

        if (space.getLod0MultiSurface() != null)
            visit(space.getLod0MultiSurface());

        if (space.getLod0MultiCurve() != null)
            visit(space.getLod0MultiCurve());

        if (space.getLod1Solid() != null)
            visit(space.getLod1Solid());

        if (space.getLod2Solid() != null)
            visit(space.getLod2Solid());

        if (space.getLod2MultiSurface() != null)
            visit(space.getLod2MultiSurface());

        if (space.getLod2MultiCurve() != null)
            visit(space.getLod2MultiCurve());

        if (space.getLod3Solid() != null)
            visit(space.getLod3Solid());

        if (space.getLod3MultiSurface() != null)
            visit(space.getLod3MultiSurface());

        if (space.getLod3MultiCurve() != null)
            visit(space.getLod3MultiCurve());
    }

    @Override
    public void visit(AbstractThematicSurface thematicSurface) {
        super.visit(thematicSurface);

        if (thematicSurface.getLod0MultiCurve() != null)
            visit(thematicSurface.getLod0MultiCurve());

        if (thematicSurface.getLod0MultiSurface() != null)
            visit(thematicSurface.getLod0MultiSurface());

        if (thematicSurface.getLod1MultiSurface() != null)
            visit(thematicSurface.getLod1MultiSurface());

        if (thematicSurface.getLod2MultiSurface() != null)
            visit(thematicSurface.getLod2MultiSurface());

        if (thematicSurface.getLod3MultiSurface() != null)
            visit(thematicSurface.getLod3MultiSurface());

        if (thematicSurface.hasDeprecatedProperties()) {
            DeprecatedPropertiesOfAbstractThematicSurface deprecatedProperties = thematicSurface.getDeprecatedProperties();

            if (deprecatedProperties.getLod4MultiSurface() != null)
                visit(deprecatedProperties.getLod4MultiSurface());
        }
    }

    @Override
    public void visit(AbstractTransportationSpace transportationSpace) {
        super.visit(transportationSpace);

        if (transportationSpace.hasDeprecatedProperties()) {
            DeprecatedPropertiesOfAbstractTransportationSpace deprecatedProperties = transportationSpace.getDeprecatedProperties();

            if (deprecatedProperties.getLod0Network() != null)
                visit(deprecatedProperties.getLod0Network());

            if (deprecatedProperties.getLod1MultiSurface() != null)
                visit(deprecatedProperties.getLod1MultiSurface());

            if (deprecatedProperties.getLod4MultiSurface() != null)
                visit(deprecatedProperties.getLod4MultiSurface());
        }
    }

    @Override
    public void visit(AbstractTunnel tunnel) {
        super.visit(tunnel);

        if (tunnel.hasDeprecatedProperties()) {
            DeprecatedPropertiesOfAbstractTunnel deprecatedProperties = tunnel.getDeprecatedProperties();

            if (deprecatedProperties.getLod1MultiSurface() != null)
                visit(deprecatedProperties.getLod1MultiSurface());

            if (deprecatedProperties.getLod4MultiCurve() != null)
                visit(deprecatedProperties.getLod4MultiCurve());

            if (deprecatedProperties.getLod4MultiSurface() != null)
                visit(deprecatedProperties.getLod4MultiSurface());

            if (deprecatedProperties.getLod4Solid() != null)
                visit(deprecatedProperties.getLod4Solid());

            if (deprecatedProperties.getLod4TerrainIntersectionCurve() != null)
                visit(deprecatedProperties.getLod4TerrainIntersectionCurve());
        }
    }

    @Override
    public void visit(Address address) {
        super.visit(address);

        if (address.getMultiPoint() != null)
            visit(address.getMultiPoint());
    }

    @Override
    public void visit(BreaklineRelief breaklineRelief) {
        super.visit(breaklineRelief);

        if (breaklineRelief.getRidgeOrValleyLines() != null)
            visit(breaklineRelief.getRidgeOrValleyLines());

        if (breaklineRelief.getBreaklines() != null)
            visit(breaklineRelief.getBreaklines());
    }

    @Override
    public void visit(BridgeConstructiveElement bridgeConstructiveElement) {
        super.visit(bridgeConstructiveElement);

        if (bridgeConstructiveElement.hasDeprecatedProperties()) {
            DeprecatedPropertiesOfBridgeConstructiveElement deprecatedProperties = bridgeConstructiveElement.getDeprecatedProperties();

            if (deprecatedProperties.getLod1Geometry() != null)
                visit(deprecatedProperties.getLod1Geometry());

            if (deprecatedProperties.getLod2Geometry() != null)
                visit(deprecatedProperties.getLod2Geometry());

            if (deprecatedProperties.getLod3Geometry() != null)
                visit(deprecatedProperties.getLod3Geometry());

            if (deprecatedProperties.getLod4Geometry() != null)
                visit(deprecatedProperties.getLod4Geometry());

            if (deprecatedProperties.getLod4TerrainIntersectionCurve() != null)
                visit(deprecatedProperties.getLod4TerrainIntersectionCurve());

            if (deprecatedProperties.getLod4ImplicitRepresentation() != null)
                visit(deprecatedProperties.getLod4ImplicitRepresentation());
        }
    }

    @Override
    public void visit(BridgeFurniture bridgeFurniture) {
        super.visit(bridgeFurniture);

        if (bridgeFurniture.hasDeprecatedProperties()) {
            DeprecatedPropertiesOfBridgeFurniture deprecatedProperties = bridgeFurniture.getDeprecatedProperties();

            if (deprecatedProperties.getLod4Geometry() != null)
                visit(deprecatedProperties.getLod4Geometry());

            if (deprecatedProperties.getLod4ImplicitRepresentation() != null)
                visit(deprecatedProperties.getLod4ImplicitRepresentation());
        }
    }

    @Override
    public void visit(BridgeInstallation bridgeInstallation) {
        super.visit(bridgeInstallation);

        if (bridgeInstallation.hasDeprecatedProperties()) {
            DeprecatedPropertiesOfBridgeInstallation deprecatedProperties = bridgeInstallation.getDeprecatedProperties();

            if (deprecatedProperties.getLod2Geometry() != null)
                visit(deprecatedProperties.getLod2Geometry());

            if (deprecatedProperties.getLod3Geometry() != null)
                visit(deprecatedProperties.getLod3Geometry());

            if (deprecatedProperties.getLod4Geometry() != null)
                visit(deprecatedProperties.getLod4Geometry());

            if (deprecatedProperties.getLod4ImplicitRepresentation() != null)
                visit(deprecatedProperties.getLod4ImplicitRepresentation());
        }
    }

    @Override
    public void visit(BridgeRoom bridgeRoom) {
        super.visit(bridgeRoom);

        if (bridgeRoom.hasDeprecatedProperties()) {
            DeprecatedPropertiesOfBridgeRoom deprecatedProperties = bridgeRoom.getDeprecatedProperties();

            if (deprecatedProperties.getLod4Solid() != null)
                visit(deprecatedProperties.getLod4Solid());

            if (deprecatedProperties.getLod4MultiSurface() != null)
                visit(deprecatedProperties.getLod4MultiSurface());
        }
    }

    @Override
    public void visit(BuildingFurniture buildingFurniture) {
        super.visit(buildingFurniture);

        if (buildingFurniture.hasDeprecatedProperties()) {
            DeprecatedPropertiesOfBuildingFurniture deprecatedProperties = buildingFurniture.getDeprecatedProperties();

            if (deprecatedProperties.getLod4Geometry() != null)
                visit(deprecatedProperties.getLod4Geometry());

            if (deprecatedProperties.getLod4ImplicitRepresentation() != null)
                visit(deprecatedProperties.getLod4ImplicitRepresentation());
        }
    }

    @Override
    public void visit(BuildingInstallation buildingInstallation) {
        super.visit(buildingInstallation);

        if (buildingInstallation.hasDeprecatedProperties()) {
            DeprecatedPropertiesOfBuildingInstallation deprecatedProperties = buildingInstallation.getDeprecatedProperties();

            if (deprecatedProperties.getLod2Geometry() != null)
                visit(deprecatedProperties.getLod2Geometry());

            if (deprecatedProperties.getLod3Geometry() != null)
                visit(deprecatedProperties.getLod3Geometry());

            if (deprecatedProperties.getLod4Geometry() != null)
                visit(deprecatedProperties.getLod4Geometry());

            if (deprecatedProperties.getLod4ImplicitRepresentation() != null)
                visit(deprecatedProperties.getLod4ImplicitRepresentation());
        }
    }

    @Override
    public void visit(BuildingRoom buildingRoom) {
        super.visit(buildingRoom);

        if (buildingRoom.hasDeprecatedProperties()) {
            DeprecatedPropertiesOfBuildingRoom deprecatedProperties = buildingRoom.getDeprecatedProperties();

            if (deprecatedProperties.getLod4Solid() != null)
                visit(deprecatedProperties.getLod4Solid());

            if (deprecatedProperties.getLod4MultiSurface() != null)
                visit(deprecatedProperties.getLod4MultiSurface());
        }
    }

    @Override
    public void visit(CityFurniture cityFurniture) {
        super.visit(cityFurniture);

        if (cityFurniture.hasDeprecatedProperties()) {
            DeprecatedPropertiesOfCityFurniture deprecatedProperties = cityFurniture.getDeprecatedProperties();

            if (deprecatedProperties.getLod1Geometry() != null)
                visit(deprecatedProperties.getLod1Geometry());

            if (deprecatedProperties.getLod2Geometry() != null)
                visit(deprecatedProperties.getLod2Geometry());

            if (deprecatedProperties.getLod3Geometry() != null)
                visit(deprecatedProperties.getLod3Geometry());

            if (deprecatedProperties.getLod4Geometry() != null)
                visit(deprecatedProperties.getLod4Geometry());

            if (deprecatedProperties.getLod4TerrainIntersectionCurve() != null)
                visit(deprecatedProperties.getLod4TerrainIntersectionCurve());

            if (deprecatedProperties.getLod4ImplicitRepresentation() != null)
                visit(deprecatedProperties.getLod4ImplicitRepresentation());
        }
    }

    @Override
    public void visit(CityObjectGroup cityObjectGroup) {
        super.visit(cityObjectGroup);

        if (cityObjectGroup.hasDeprecatedProperties()) {
            DeprecatedPropertiesOfCityObjectGroup deprecatedProperties = cityObjectGroup.getDeprecatedProperties();

            if (deprecatedProperties.getGeometry() != null)
                visit(deprecatedProperties.getGeometry());
        }
    }

    @Override
    public void visit(GenericOccupiedSpace genericOccupiedSpace) {
        super.visit(genericOccupiedSpace);

        if (genericOccupiedSpace.hasDeprecatedProperties()) {
            DeprecatedPropertiesOfGenericOccupiedSpace deprecatedProperties = genericOccupiedSpace.getDeprecatedProperties();

            if (deprecatedProperties.getLod0Geometry() != null)
                visit(deprecatedProperties.getLod0Geometry());

            if (deprecatedProperties.getLod1Geometry() != null)
                visit(deprecatedProperties.getLod1Geometry());

            if (deprecatedProperties.getLod2Geometry() != null)
                visit(deprecatedProperties.getLod2Geometry());

            if (deprecatedProperties.getLod3Geometry() != null)
                visit(deprecatedProperties.getLod3Geometry());

            if (deprecatedProperties.getLod4Geometry() != null)
                visit(deprecatedProperties.getLod4Geometry());

            if (deprecatedProperties.getLod0TerrainIntersectionCurve() != null)
                visit(deprecatedProperties.getLod0TerrainIntersectionCurve());

            if (deprecatedProperties.getLod4TerrainIntersectionCurve() != null)
                visit(deprecatedProperties.getLod4TerrainIntersectionCurve());

            if (deprecatedProperties.getLod0ImplicitRepresentation() != null)
                visit(deprecatedProperties.getLod0ImplicitRepresentation());

            if (deprecatedProperties.getLod4ImplicitRepresentation() != null)
                visit(deprecatedProperties.getLod4ImplicitRepresentation());
        }
    }

    @Override
    public void visit(GenericTimeseries genericTimeseries) {
        super.visit(genericTimeseries);

        for (TimeValuePairProperty property : genericTimeseries.getTimeValuePairs()) {
            if (property.getObject() != null)
                visit(property.getObject());
        }
    }

    @Override
    public void visit(GeoreferencedTexture georeferencedTexture) {
        super.visit(georeferencedTexture);

        if (georeferencedTexture.getReferencePoint() != null)
            visit(georeferencedTexture.getReferencePoint());
    }

    @Override
    public void visit(HollowSpace hollowSpace) {
        super.visit(hollowSpace);

        if (hollowSpace.hasDeprecatedProperties()) {
            DeprecatedPropertiesOfHollowSpace deprecatedProperties = hollowSpace.getDeprecatedProperties();

            if (deprecatedProperties.getLod4Solid() != null)
                visit(deprecatedProperties.getLod4Solid());

            if (deprecatedProperties.getLod4MultiSurface() != null)
                visit(deprecatedProperties.getLod4MultiSurface());
        }
    }

    @Override
    public void visit(MassPointRelief massPointRelief) {
        super.visit(massPointRelief);

        if (massPointRelief.getReliefPoints() != null)
            visit(massPointRelief.getReliefPoints());
    }

    @Override
    public void visit(PlantCover plantCover) {
        super.visit(plantCover);

        if (plantCover.hasDeprecatedProperties()) {
            DeprecatedPropertiesOfPlantCover deprecatedProperties = plantCover.getDeprecatedProperties();

            if (deprecatedProperties.getLod1MultiSurface() != null)
                visit(deprecatedProperties.getLod1MultiSurface());

            if (deprecatedProperties.getLod4MultiSurface() != null)
                visit(deprecatedProperties.getLod4MultiSurface());

            if (deprecatedProperties.getLod1MultiSolid() != null)
                visit(deprecatedProperties.getLod1MultiSolid());

            if (deprecatedProperties.getLod2MultiSolid() != null)
                visit(deprecatedProperties.getLod2MultiSolid());

            if (deprecatedProperties.getLod3MultiSolid() != null)
                visit(deprecatedProperties.getLod3MultiSolid());

            if (deprecatedProperties.getLod4MultiSolid() != null)
                visit(deprecatedProperties.getLod4MultiSolid());
        }
    }

    @Override
    public void visit(PointCloud pointCloud) {
        super.visit(pointCloud);

        if (pointCloud.getPoints() != null)
            visit(pointCloud.getPoints());
    }

    @Override
    public void visit(RasterRelief rasterRelief) {
        super.visit(rasterRelief);

        if (rasterRelief.getGrid() != null)
            visit(rasterRelief.getGrid());
    }

    @Override
    public void visit(SolitaryVegetationObject solitaryVegetationObject) {
        super.visit(solitaryVegetationObject);

        if (solitaryVegetationObject.hasDeprecatedProperties()) {
            DeprecatedPropertiesOfSolitaryVegetationObject deprecatedProperties = solitaryVegetationObject.getDeprecatedProperties();

            if (deprecatedProperties.getLod1Geometry() != null)
                visit(deprecatedProperties.getLod1Geometry());

            if (deprecatedProperties.getLod2Geometry() != null)
                visit(deprecatedProperties.getLod2Geometry());

            if (deprecatedProperties.getLod3Geometry() != null)
                visit(deprecatedProperties.getLod3Geometry());

            if (deprecatedProperties.getLod4Geometry() != null)
                visit(deprecatedProperties.getLod4Geometry());

            if (deprecatedProperties.getLod4ImplicitRepresentation() != null)
                visit(deprecatedProperties.getLod4ImplicitRepresentation());
        }
    }

    @Override
    public void visit(TINRelief tinRelief) {
        super.visit(tinRelief);

        if (tinRelief.getTin() != null)
            visit(tinRelief.getTin());
    }

    @Override
    public void visit(TunnelFurniture tunnelFurniture) {
        super.visit(tunnelFurniture);

        if (tunnelFurniture.hasDeprecatedProperties()) {
            DeprecatedPropertiesOfTunnelFurniture deprecatedProperties = tunnelFurniture.getDeprecatedProperties();

            if (deprecatedProperties.getLod4Geometry() != null)
                visit(deprecatedProperties.getLod4Geometry());

            if (deprecatedProperties.getLod4ImplicitRepresentation() != null)
                visit(deprecatedProperties.getLod4ImplicitRepresentation());
        }
    }

    @Override
    public void visit(TunnelInstallation tunnelInstallation) {
        super.visit(tunnelInstallation);

        if (tunnelInstallation.hasDeprecatedProperties()) {
            DeprecatedPropertiesOfTunnelInstallation deprecatedProperties = tunnelInstallation.getDeprecatedProperties();

            if (deprecatedProperties.getLod2Geometry() != null)
                visit(deprecatedProperties.getLod2Geometry());

            if (deprecatedProperties.getLod3Geometry() != null)
                visit(deprecatedProperties.getLod3Geometry());

            if (deprecatedProperties.getLod4Geometry() != null)
                visit(deprecatedProperties.getLod4Geometry());

            if (deprecatedProperties.getLod4ImplicitRepresentation() != null)
                visit(deprecatedProperties.getLod4ImplicitRepresentation());
        }
    }

    @Override
    public void visit(WaterBody waterBody) {
        super.visit(waterBody);

        if (waterBody.hasDeprecatedProperties()) {
            DeprecatedPropertiesOfWaterBody deprecatedProperties = waterBody.getDeprecatedProperties();

            if (deprecatedProperties.getLod1MultiCurve() != null)
                visit(deprecatedProperties.getLod1MultiCurve());

            if (deprecatedProperties.getLod1MultiSurface() != null)
                visit(deprecatedProperties.getLod1MultiSurface());

            if (deprecatedProperties.getLod4Solid() != null)
                visit(deprecatedProperties.getLod4Solid());
        }
    }

    public void visit(AbstractGeometry geometry) {
        visit((AbstractGML) geometry);
    }

    public void visit(AbstractGeometricAggregate geometricAggregate) {
        visit((AbstractGeometry) geometricAggregate);
    }

    public void visit(AbstractGeometricPrimitive geometricPrimitive) {
        visit((AbstractGeometry) geometricPrimitive);
    }

    public void visit(AbstractMultiPoint multiPoint) {
        visit((AbstractGeometricAggregate) multiPoint);
    }

    public void visit(AbstractCurve curve) {
        visit((AbstractGeometricPrimitive) curve);
    }

    public void visit(AbstractSolid solid) {
        visit((AbstractGeometricPrimitive) solid);
    }

    public void visit(AbstractSurface surface) {
        visit((AbstractGeometricPrimitive) surface);
    }

    public void visit(AbstractRing ring) {
        visit((AbstractCurve) ring);
    }

    public void visit(AbstractSimplePolygon simplePolygon) {
        visit((AbstractSurface) simplePolygon);
    }

    public void visit(AbstractSurfacePatch surfacePatch) {
    }

    @Override
    public void visit(CityObjectRelation cityObjectRelation) {
        visit((AbstractGML) cityObjectRelation);
        super.visit(cityObjectRelation);
    }

    @Override
    public void visit(ImplicitGeometry implicitGeometry) {
        visit((AbstractGML) implicitGeometry);

        for (AbstractAppearanceProperty property : new ArrayList<>(implicitGeometry.getAppearances()))
            visit(property);

        if (implicitGeometry.getReferencePoint() != null)
            visit(implicitGeometry.getReferencePoint());

        if (implicitGeometry.getRelativeGMLGeometry() != null)
            visit(implicitGeometry.getRelativeGMLGeometry());
    }

    @Override
    public void visit(Role role) {
        visit((AbstractGML) role);
        super.visit(role);
    }

    @Override
    public void visit(TextureAssociation textureAssociation) {
        visit((AbstractGML) textureAssociation);
    }

    @Override
    public void visit(CompositeValue compositeValue) {
        visit((AbstractGML) compositeValue);

        for (ValueProperty property : new ArrayList<>(compositeValue.getValueComponent())) {
            if (property.getObject() != null)
                visit(property.getObject());
        }

        if (compositeValue.getValueComponents() != null) {
            for (Value value : compositeValue.getValueComponents().getObjects())
                visit(value);
        }
    }

    @Override
    public void visit(TimeInstant timeInstant) {
        visit((AbstractGML) timeInstant);
    }

    @Override
    public void visit(TimePeriod timePeriod) {
        visit((AbstractGML) timePeriod);

        if (timePeriod.getBegin() != null)
            visit(timePeriod.getBegin());

        if (timePeriod.getEnd() != null)
            visit(timePeriod.getEnd());
    }

    @Override
    public void visit(ValueArray valueArray) {
        visit((CompositeValue) valueArray);
    }

    @Override
    public void visit(CompositeCurve compositeCurve) {
        visit((AbstractCurve) compositeCurve);

        for (CurveProperty property : new ArrayList<>(compositeCurve.getCurveMembers()))
            visit(property);
    }

    @Override
    public void visit(CompositeSolid compositeSolid) {
        visit((AbstractSolid) compositeSolid);

        for (SolidProperty property : new ArrayList<>(compositeSolid.getSolidMembers()))
            visit(property);
    }

    @Override
    public void visit(CompositeSurface compositeSurface) {
        visit((AbstractSurface) compositeSurface);

        for (SurfaceProperty property : new ArrayList<>(compositeSurface.getSurfaceMembers()))
            visit(property);
    }

    @Override
    public void visit(Curve curve) {
        visit((AbstractCurve) curve);
    }

    @Override
    public void visit(GeometricComplex geometricComplex) {
        visit((AbstractGeometry) geometricComplex);

        for (GeometricPrimitiveProperty property : new ArrayList<>(geometricComplex.getElements()))
            visit(property);
    }

    @Override
    public void visit(Grid grid) {
        visit((AbstractGeometry) grid);
    }

    @Override
    public void visit(LinearRing linearRing) {
        visit((AbstractRing) linearRing);
    }

    @Override
    public void visit(LineString lineString) {
        visit((AbstractCurve) lineString);
    }

    @Override
    public void visit(MultiCurve multiCurve) {
        visit((AbstractGeometricAggregate) multiCurve);

        for (CurveProperty property : new ArrayList<>(multiCurve.getCurveMember()))
            visit(property);

        if (multiCurve.getCurveMembers() != null)
            visit(multiCurve.getCurveMembers());
    }

    @Override
    public void visit(MultiGeometry multiGeometry) {
        visit((AbstractGeometricAggregate) multiGeometry);

        for (GeometryProperty<?> property : new ArrayList<>(multiGeometry.getGeometryMember()))
            visit(property);

        if (multiGeometry.getGeometryMembers() != null)
            visit(multiGeometry.getGeometryMembers());
    }

    @Override
    public void visit(MultiPoint multiPoint) {
        visit((AbstractMultiPoint) multiPoint);

        for (PointProperty property : new ArrayList<>(multiPoint.getPointMember()))
            visit(property);

        if (multiPoint.getPointMembers() != null)
            visit(multiPoint.getPointMembers());
    }

    @Override
    public void visit(MultiSolid multiSolid) {
        visit((AbstractGeometricAggregate) multiSolid);

        for (SolidProperty property : new ArrayList<>(multiSolid.getSolidMember()))
            visit(property);

        if (multiSolid.getSolidMembers() != null)
            visit(multiSolid.getSolidMembers());
    }

    @Override
    public void visit(MultiSurface multiSurface) {
        visit((AbstractGeometricAggregate) multiSurface);

        for (SurfaceProperty property : new ArrayList<>(multiSurface.getSurfaceMember()))
            visit(property);

        if (multiSurface.getSurfaceMembers() != null)
            visit(multiSurface.getSurfaceMembers());
    }

    @Override
    public void visit(OrientableCurve orientableCurve) {
        visit((AbstractCurve) orientableCurve);

        if (orientableCurve.getBaseCurve() != null)
            visit(orientableCurve.getBaseCurve());
    }

    @Override
    public void visit(OrientableSurface orientableSurface) {
        visit((AbstractSurface) orientableSurface);

        if (orientableSurface.getBaseSurface() != null)
            visit(orientableSurface.getBaseSurface());
    }

    @Override
    public void visit(Point point) {
        visit((AbstractGeometricPrimitive) point);
    }

    @Override
    public void visit(Polygon polygon) {
        visit((AbstractSurface) polygon);

        if (polygon.getExterior() != null)
            visit(polygon.getExterior());

        for (AbstractRingProperty property : new ArrayList<>(polygon.getInterior()))
            visit(property);
    }

    @Override
    public void visit(PolyhedralSurface polyhedralSurface) {
        visit((Surface) polyhedralSurface);
    }

    @Override
    public void visit(RectifiedGrid rectifiedGrid) {
        visit((Grid) rectifiedGrid);

        if (rectifiedGrid.getOrigin() != null)
            visit(rectifiedGrid.getOrigin());
    }

    @Override
    public void visit(Ring ring) {
        visit((AbstractRing) ring);

        for (CurveProperty property : new ArrayList<>(ring.getCurveMembers()))
            visit(property);
    }

    @Override
    public void visit(Shell shell) {
        visit((AbstractSurface) shell);

        for (SurfaceProperty property : new ArrayList<>(shell.getSurfaceMembers()))
            visit(property);
    }

    @Override
    public void visit(SimpleMultiPoint simpleMultiPoint) {
        visit((AbstractMultiPoint) simpleMultiPoint);
    }

    @Override
    public void visit(SimplePolygon simplePolygon) {
        visit((AbstractSimplePolygon) simplePolygon);
    }

    @Override
    public void visit(SimpleRectangle simpleRectangle) {
        visit((AbstractSimplePolygon) simpleRectangle);
    }

    @Override
    public void visit(SimpleTriangle simpleTriangle) {
        visit((AbstractSimplePolygon) simpleTriangle);
    }

    @Override
    public void visit(Solid solid) {
        visit((AbstractSolid) solid);

        if (solid.getExterior() != null)
            visit(solid.getExterior());

        for (ShellProperty property : new ArrayList<>(solid.getInterior()))
            visit(property);
    }

    @Override
    public void visit(Surface surface) {
        visit((AbstractSurface) surface);

        if (surface.getPatches() != null)
            visit(surface.getPatches());
    }

    @Override
    public void visit(Tin tin) {
        visit((TriangulatedSurface) tin);
    }

    @Override
    public void visit(TriangulatedSurface triangulatedSurface) {
        visit((Surface) triangulatedSurface);
    }

    public void visit(PolygonPatch polygonPatch) {
        visit((AbstractSurfacePatch) polygonPatch);

        if (polygonPatch.getExterior() != null)
            visit(polygonPatch.getExterior());

        for (AbstractRingProperty property : new ArrayList<>(polygonPatch.getInterior()))
            visit(property);
    }

    public void visit(Rectangle rectangle) {
        visit((AbstractSurfacePatch) rectangle);

        if (rectangle.getExterior() != null)
            visit(rectangle.getExterior());
    }

    public void visit(Triangle triangle) {
        visit((AbstractSurfacePatch) triangle);

        if (triangle.getExterior() != null)
            visit(triangle.getExterior());
    }

    @Override
    public void visit(AbstractProperty<?> property) {
        if (shouldWalk && property.getObject() != null) {
            Object object = property.getObject();
            if (object instanceof VisitableFeature)
                ((VisitableFeature) object).accept(this);
            else if (object instanceof VisitableObject)
                ((VisitableObject) object).accept(this);
            else if (object instanceof AbstractGeometry)
                ((AbstractGeometry) object).accept(this);
        }
    }

    @Override
    public void visit(AbstractInlineProperty<?> property) {
        if (shouldWalk && property.getObject() != null) {
            Object object = property.getObject();
            if (object instanceof VisitableFeature)
                ((VisitableFeature) object).accept(this);
            else if (object instanceof VisitableObject)
                ((VisitableObject) object).accept(this);
            else if (object instanceof AbstractGeometry)
                ((AbstractGeometry) object).accept(this);
        }
    }

    public void visit(GeometryProperty<?> property) {
        if (shouldWalk && property.getObject() != null)
            property.getObject().accept(this);
    }

    public void visit(AbstractInlineGeometryProperty<?> property) {
        if (shouldWalk && property.getObject() != null)
            property.getObject().accept(this);
    }

    public void visit(GeometryArrayProperty<?> property) {
        for (AbstractGeometry geometry : new ArrayList<>(property.getObjects())) {
            if (shouldWalk)
                geometry.accept(this);
        }
    }

    public void visit(SurfacePatchArrayProperty<?> property) {
        for (AbstractSurfacePatch patch : property.getObjects()) {
            if (shouldWalk) {
                if (patch instanceof PolygonPatch)
                    visit((PolygonPatch) patch);
                else if (patch instanceof Rectangle)
                    visit((Rectangle) patch);
                else if (patch instanceof Triangle)
                    visit((Triangle) patch);
            }
        }
    }

    private void visit(Value value) {
        if (shouldWalk) {
            if (value.getValue() != null)
                visit(value.getValue());
            else if (value.getGeometry() != null)
                value.getGeometry().accept(this);
            else if (value.getGenericElement() != null)
                visit(value.getGenericElement());
        }
    }

    private void visit(AbstractValue value) {
        if (value instanceof CompositeValue)
            ((CompositeValue) value).accept(this);
    }

    private void visit(TimeInstantProperty property) {
        if (shouldWalk && property.getObject() != null)
            property.getObject().accept(this);
    }

    private void visit(TimeValuePair timeValuePair) {
        if (shouldWalk) {
            if (timeValuePair.getGeometryValue() != null)
                visit(timeValuePair.getGeometryValue());
            else if (timeValuePair.getImplicitGeometryValue() != null)
                visit(timeValuePair.getImplicitGeometryValue());
            else if (timeValuePair.getAppearanceValue() != null)
                visit(timeValuePair.getAppearanceValue());
        }
    }
}
