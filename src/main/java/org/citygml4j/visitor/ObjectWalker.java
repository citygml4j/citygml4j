/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2021 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.visitor;

import org.citygml4j.ADERegistry;
import org.citygml4j.ade.ADE;
import org.citygml4j.model.ade.ADEObject;
import org.citygml4j.model.ade.ADEProperty;
import org.citygml4j.model.appearance.*;
import org.citygml4j.model.bridge.*;
import org.citygml4j.model.building.*;
import org.citygml4j.model.cityfurniture.CityFurniture;
import org.citygml4j.model.cityobjectgroup.CityObjectGroup;
import org.citygml4j.model.cityobjectgroup.Role;
import org.citygml4j.model.cityobjectgroup.RoleProperty;
import org.citygml4j.model.construction.*;
import org.citygml4j.model.core.*;
import org.citygml4j.model.deprecated.appearance.DeprecatedPropertiesOfParameterizedTexture;
import org.citygml4j.model.deprecated.appearance.TextureAssociationReference;
import org.citygml4j.model.deprecated.bridge.*;
import org.citygml4j.model.deprecated.building.DeprecatedPropertiesOfAbstractBuilding;
import org.citygml4j.model.deprecated.building.DeprecatedPropertiesOfBuildingFurniture;
import org.citygml4j.model.deprecated.building.DeprecatedPropertiesOfBuildingInstallation;
import org.citygml4j.model.deprecated.building.DeprecatedPropertiesOfBuildingRoom;
import org.citygml4j.model.deprecated.cityfurniture.DeprecatedPropertiesOfCityFurniture;
import org.citygml4j.model.deprecated.cityobjectgroup.DeprecatedPropertiesOfCityObjectGroup;
import org.citygml4j.model.deprecated.cityobjectgroup.GroupMember;
import org.citygml4j.model.deprecated.construction.DeprecatedPropertiesOfAbstractFillingSurface;
import org.citygml4j.model.deprecated.core.DeprecatedPropertiesOfAbstractCityObject;
import org.citygml4j.model.deprecated.core.DeprecatedPropertiesOfAbstractThematicSurface;
import org.citygml4j.model.deprecated.generics.DeprecatedPropertiesOfGenericOccupiedSpace;
import org.citygml4j.model.deprecated.transportation.DeprecatedPropertiesOfAbstractTransportationSpace;
import org.citygml4j.model.deprecated.transportation.TransportationComplex;
import org.citygml4j.model.deprecated.tunnel.DeprecatedPropertiesOfAbstractTunnel;
import org.citygml4j.model.deprecated.tunnel.DeprecatedPropertiesOfHollowSpace;
import org.citygml4j.model.deprecated.tunnel.DeprecatedPropertiesOfTunnelFurniture;
import org.citygml4j.model.deprecated.tunnel.DeprecatedPropertiesOfTunnelInstallation;
import org.citygml4j.model.deprecated.vegetation.DeprecatedPropertiesOfPlantCover;
import org.citygml4j.model.deprecated.vegetation.DeprecatedPropertiesOfSolitaryVegetationObject;
import org.citygml4j.model.deprecated.waterbody.DeprecatedPropertiesOfWaterBody;
import org.citygml4j.model.dynamizer.*;
import org.citygml4j.model.generics.GenericLogicalSpace;
import org.citygml4j.model.generics.GenericOccupiedSpace;
import org.citygml4j.model.generics.GenericThematicSurface;
import org.citygml4j.model.generics.GenericUnoccupiedSpace;
import org.citygml4j.model.landuse.LandUse;
import org.citygml4j.model.pointcloud.PointCloud;
import org.citygml4j.model.relief.*;
import org.citygml4j.model.transportation.*;
import org.citygml4j.model.tunnel.*;
import org.citygml4j.model.vegetation.AbstractVegetationObject;
import org.citygml4j.model.vegetation.PlantCover;
import org.citygml4j.model.vegetation.SolitaryVegetationObject;
import org.citygml4j.model.versioning.TransactionProperty;
import org.citygml4j.model.versioning.Version;
import org.citygml4j.model.versioning.VersionTransition;
import org.citygml4j.model.waterbody.AbstractWaterBoundarySurface;
import org.citygml4j.model.waterbody.WaterBody;
import org.citygml4j.model.waterbody.WaterGroundSurface;
import org.citygml4j.model.waterbody.WaterSurface;
import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.base.*;
import org.xmlobjects.gml.model.common.GenericElement;
import org.xmlobjects.gml.model.coverage.*;
import org.xmlobjects.gml.model.deprecated.DefinitionProxy;
import org.xmlobjects.gml.model.dictionary.Definition;
import org.xmlobjects.gml.model.dictionary.DefinitionBase;
import org.xmlobjects.gml.model.dictionary.DefinitionProperty;
import org.xmlobjects.gml.model.dictionary.Dictionary;
import org.xmlobjects.gml.model.feature.AbstractFeatureMember;
import org.xmlobjects.gml.model.feature.FeatureProperty;
import org.xmlobjects.gml.model.geometry.AbstractGeometry;
import org.xmlobjects.gml.model.geometry.AbstractInlineGeometryProperty;
import org.xmlobjects.gml.model.geometry.GeometryArrayProperty;
import org.xmlobjects.gml.model.geometry.GeometryProperty;
import org.xmlobjects.gml.model.geometry.primitives.SurfacePatchArrayProperty;
import org.xmlobjects.gml.model.temporal.TimeInstant;
import org.xmlobjects.gml.model.temporal.TimeInstantProperty;
import org.xmlobjects.gml.model.temporal.TimePeriod;
import org.xmlobjects.gml.model.valueobjects.*;
import org.xmlobjects.gml.visitor.GeometryWalker;
import org.xmlobjects.gml.visitor.Visitable;
import org.xmlobjects.gml.visitor.VisitableGeometry;

import java.util.ArrayList;

public class ObjectWalker extends GeometryWalker implements ObjectVisitor, Walker {
    final ADEWalkerHelper adeWalkerHelper = new ADEWalkerHelper(this);

    public ObjectWalker() {
        ADERegistry registry = ADERegistry.getInstance();
        if (registry.hasADEs()) {
            for (ADE ade : registry.getADEs())
                withADEWalker(ade.getADEWalker());
        }
    }

    public ObjectWalker withADEWalker(ADEWalker walker) {
        if (walker != null) {
            adeWalkerHelper.addADEWalker(walker);
            walker.setParentWalker(this);
        }

        return this;
    }

    @Override
    public void visit(Visitable visitable) {
        if (visitable instanceof VisitableObject) {
            ((VisitableObject) visitable).accept(this);
        } else if (visitable instanceof org.xmlobjects.gml.visitor.VisitableObject) {
            ((org.xmlobjects.gml.visitor.VisitableObject) visitable).accept(this);
        } else if (visitable instanceof VisitableGeometry) {
            ((VisitableGeometry) visitable).accept(this);
        }
    }

    public void visit(AbstractGML object) {
    }

    @Override
    public void visit(AbstractGeometry geometry) {
        visit((AbstractGML) geometry);
    }

    public void visit(org.xmlobjects.gml.model.feature.AbstractFeature feature) {
        visit((AbstractGML) feature);

        if (feature.getLocation() != null)
            visit(feature.getLocation());

        if (feature.isSetGenericProperties()) {
            for (GenericElement genericElement : new ArrayList<>(feature.getGenericProperties()))
                visit(genericElement);
        }
    }

    public void visit(AbstractFeature feature) {
        visit((org.xmlobjects.gml.model.feature.AbstractFeature) feature);

        if (feature.hasADEProperties()) {
            for (ADEProperty property : new ArrayList<>(feature.getADEProperties()))
                visit(property);
        }
    }

    public void visit(AbstractAppearance appearance) {
        visit((AbstractFeatureWithLifespan) appearance);
    }

    public void visit(AbstractAtomicTimeseries atomicTimeseries) {
        visit((AbstractTimeseries) atomicTimeseries);
    }

    public void visit(AbstractBridge bridge) {
        visit((AbstractConstruction) bridge);

        if (bridge.isSetBridgeConstructiveElements()) {
            for (BridgeConstructiveElementProperty property : new ArrayList<>(bridge.getBridgeConstructiveElements()))
                visit(property);
        }

        if (bridge.isSetBridgeInstallations()) {
            for (BridgeInstallationProperty property : new ArrayList<>(bridge.getBridgeInstallations()))
                visit(property);
        }

        if (bridge.isSetBridgeRooms()) {
            for (BridgeRoomProperty property : new ArrayList<>(bridge.getBridgeRooms()))
                visit(property);
        }

        if (bridge.isSetBridgeFurniture()) {
            for (BridgeFurnitureProperty property : new ArrayList<>(bridge.getBridgeFurniture()))
                visit(property);
        }

        if (bridge.isSetAddresses()) {
            for (AddressProperty member : new ArrayList<>(bridge.getAddresses()))
                visit(member);
        }

        if (bridge.hasDeprecatedProperties()) {
            DeprecatedPropertiesOfAbstractBridge properties = bridge.getDeprecatedProperties();

            if (properties.isSetConsistsOfBridgeParts()) {
                for (BridgePartProperty property : new ArrayList<>(properties.getConsistsOfBridgeParts()))
                    visit(property);
            }

            if (properties.getLod1MultiSurface() != null)
                visit(properties.getLod1MultiSurface());

            if (properties.getLod4MultiCurve() != null)
                visit(properties.getLod4MultiCurve());

            if (properties.getLod4MultiSurface() != null)
                visit(properties.getLod4MultiSurface());

            if (properties.getLod4Solid() != null)
                visit(properties.getLod4Solid());

            if (properties.getLod4TerrainIntersectionCurve() != null)
                visit(properties.getLod4TerrainIntersectionCurve());
        }
    }

    public void visit(AbstractBuilding building) {
        visit((AbstractConstruction) building);

        if (building.isSetBuildingConstructiveElements()) {
            for (BuildingConstructiveElementProperty property : new ArrayList<>(building.getBuildingConstructiveElements()))
                visit(property);
        }

        if (building.isSetBuildingInstallations()) {
            for (BuildingInstallationProperty property : new ArrayList<>(building.getBuildingInstallations()))
                visit(property);
        }

        if (building.isSetBuildingRooms()) {
            for (BuildingRoomProperty property : new ArrayList<>(building.getBuildingRooms()))
                visit(property);
        }

        if (building.isSetBuildingFurniture()) {
            for (BuildingFurnitureProperty property : new ArrayList<>(building.getBuildingFurniture()))
                visit(property);
        }

        if (building.isSetBuildingSubdivisions()) {
            for (AbstractBuildingSubdivisionProperty property : new ArrayList<>(building.getBuildingSubdivisions()))
                visit(property);
        }

        if (building.isSetAddresses()) {
            for (AddressProperty member : new ArrayList<>(building.getAddresses()))
                visit(member);
        }

        if (building.hasDeprecatedProperties()) {
            DeprecatedPropertiesOfAbstractBuilding properties = building.getDeprecatedProperties();

            if (properties.isSetConsistsOfBuildingParts()) {
                for (BuildingPartProperty property : new ArrayList<>(properties.getConsistsOfBuildingParts()))
                    visit(property);
            }

            if (properties.getLod0RoofEdge() != null)
                visit(properties.getLod0RoofEdge());

            if (properties.getLod1MultiSurface() != null)
                visit(properties.getLod1MultiSurface());

            if (properties.getLod4MultiCurve() != null)
                visit(properties.getLod4MultiCurve());

            if (properties.getLod4MultiSurface() != null)
                visit(properties.getLod4MultiSurface());

            if (properties.getLod4Solid() != null)
                visit(properties.getLod4Solid());

            if (properties.getLod4TerrainIntersectionCurve() != null)
                visit(properties.getLod4TerrainIntersectionCurve());
        }
    }

    public void visit(AbstractBuildingSubdivision buildingSubdivision) {
        visit((AbstractLogicalSpace) buildingSubdivision);

        if (buildingSubdivision.isSetBuildingConstructiveElements()) {
            for (BuildingConstructiveElementProperty property : new ArrayList<>(buildingSubdivision.getBuildingConstructiveElements()))
                visit(property);
        }

        if (buildingSubdivision.isSetBuildingFurniture()) {
            for (BuildingFurnitureProperty property : new ArrayList<>(buildingSubdivision.getBuildingFurniture()))
                visit(property);
        }

        if (buildingSubdivision.isSetBuildingInstallations()) {
            for (BuildingInstallationProperty property : new ArrayList<>(buildingSubdivision.getBuildingInstallations()))
                visit(property);
        }

        if (buildingSubdivision.isSetBuildingRooms()) {
            for (BuildingRoomProperty property : new ArrayList<>(buildingSubdivision.getBuildingRooms()))
                visit(property);
        }
    }

    public void visit(AbstractCityObject cityObject) {
        visit((AbstractFeatureWithLifespan) cityObject);

        if (cityObject.isSetGeneralizesTo()) {
            for (AbstractCityObjectReference reference : new ArrayList<>(cityObject.getGeneralizesTo()))
                visit(reference);
        }

        if (cityObject.isSetRelatedTo()) {
            for (CityObjectRelationProperty property : new ArrayList<>(cityObject.getRelatedTo()))
                visit(property);
        }

        if (cityObject.isSetAppearances()) {
            for (AbstractAppearanceProperty property : new ArrayList<>(cityObject.getAppearances()))
                visit(property);
        }

        if (cityObject.isSetDynamizers()) {
            for (AbstractDynamizerProperty property : new ArrayList<>(cityObject.getDynamizers()))
                visit(property);
        }

        if (cityObject.hasDeprecatedProperties()) {
            DeprecatedPropertiesOfAbstractCityObject properties = cityObject.getDeprecatedProperties();

            if (properties.isSetGeneralizesTo()) {
                for (AbstractCityObjectProperty property : new ArrayList<>(properties.getGeneralizesTo()))
                    visit(property);
            }
        }
    }

    public void visit(AbstractConstruction construction) {
        visit((AbstractOccupiedSpace) construction);
    }

    public void visit(AbstractConstructionSurface constructionSurface) {
        visit((AbstractThematicSurface) constructionSurface);

        if (constructionSurface.isSetFillingSurfaces()) {
            for (AbstractFillingSurfaceProperty property : new ArrayList<>(constructionSurface.getFillingSurfaces()))
                visit(property);
        }
    }

    public void visit(AbstractConstructiveElement constructiveElement) {
        visit((AbstractOccupiedSpace) constructiveElement);

        if (constructiveElement.isSetFillings()) {
            for (AbstractFillingElementProperty property : new ArrayList<>(constructiveElement.getFillings()))
                visit(property);
        }
    }

    public void visit(AbstractContinuousCoverage<?> continuousCoverage) {
        visit((AbstractCoverage<?>) continuousCoverage);
    }

    public void visit(AbstractCoverage<?> coverage) {
        visit((org.xmlobjects.gml.model.feature.AbstractFeature) coverage);

        if (coverage.getDomainSet() != null)
            visit(coverage.getDomainSet());

        if (coverage.getRangeSet() != null && coverage.getRangeSet().isSetValueArrays()) {
            for (ValueArray valueArray : new ArrayList<>(coverage.getRangeSet().getValueArrays())) {
                if (valueArray != null)
                    visit(valueArray);
            }
        }
    }

    public void visit(AbstractDiscreteCoverage<?> discreteCoverage) {
        visit((AbstractCoverage<?>) discreteCoverage);
    }

    public void visit(AbstractDynamizer dynamizer) {
        visit((AbstractFeatureWithLifespan) dynamizer);
    }

    public void visit(AbstractFeatureWithLifespan featureWithLifespan) {
        visit((AbstractFeature) featureWithLifespan);
    }

    public void visit(AbstractFillingElement fillingElement) {
        visit((AbstractOccupiedSpace) fillingElement);
    }

    public void visit(AbstractFillingSurface fillingSurface) {
        visit((AbstractThematicSurface) fillingSurface);

        if (fillingSurface.hasDeprecatedProperties()) {
            DeprecatedPropertiesOfAbstractFillingSurface properties = fillingSurface.getDeprecatedProperties();

            if (properties.getLod3ImplicitRepresentation() != null)
                visit(properties.getLod3ImplicitRepresentation());

            if (properties.getLod4ImplicitRepresentation() != null)
                visit(properties.getLod4ImplicitRepresentation());
        }
    }

    public void visit(AbstractFurniture furniture) {
        visit((AbstractOccupiedSpace) furniture);
    }

    public void visit(AbstractInstallation installation) {
        visit((AbstractOccupiedSpace) installation);
    }

    public void visit(AbstractLogicalSpace logicalSpace) {
        visit((AbstractSpace) logicalSpace);
    }

    public void visit(AbstractOccupiedSpace occupiedSpace) {
        visit((AbstractPhysicalSpace) occupiedSpace);

        if (occupiedSpace.getLod1ImplicitRepresentation() != null)
            visit(occupiedSpace.getLod1ImplicitRepresentation());

        if (occupiedSpace.getLod2ImplicitRepresentation() != null)
            visit(occupiedSpace.getLod2ImplicitRepresentation());

        if (occupiedSpace.getLod3ImplicitRepresentation() != null)
            visit(occupiedSpace.getLod3ImplicitRepresentation());
    }

    public void visit(AbstractPhysicalSpace physicalSpace) {
        visit((AbstractSpace) physicalSpace);

        if (physicalSpace.getPointCloud() != null)
            visit(physicalSpace.getPointCloud());

        if (physicalSpace.getLod1TerrainIntersectionCurve() != null)
            visit(physicalSpace.getLod1TerrainIntersectionCurve());

        if (physicalSpace.getLod2TerrainIntersectionCurve() != null)
            visit(physicalSpace.getLod2TerrainIntersectionCurve());

        if (physicalSpace.getLod3TerrainIntersectionCurve() != null)
            visit(physicalSpace.getLod3TerrainIntersectionCurve());
    }

    public void visit(AbstractPointCloud pointCloud) {
        visit((AbstractFeature) pointCloud);
    }

    public void visit(AbstractReliefComponent reliefComponent) {
        visit((AbstractSpaceBoundary) reliefComponent);

        if (reliefComponent.getExtent() != null)
            visit(reliefComponent.getExtent());
    }

    public void visit(AbstractSpace space) {
        visit((AbstractCityObject) space);

        if (space.isSetBoundaries()) {
            for (AbstractSpaceBoundaryProperty property : new ArrayList<>(space.getBoundaries()))
                visit(property);
        }

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

    public void visit(AbstractSpaceBoundary spaceBoundary) {
        visit((AbstractCityObject) spaceBoundary);
    }

    public void visit(AbstractSurfaceData surfaceData) {
        visit((AbstractFeature) surfaceData);
    }

    public void visit(AbstractTexture texture) {
        visit((AbstractSurfaceData) texture);
    }

    public void visit(AbstractThematicSurface thematicSurface) {
        visit((AbstractSpaceBoundary) thematicSurface);

        if (thematicSurface.getPointCloud() != null)
            visit(thematicSurface.getPointCloud());

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
            DeprecatedPropertiesOfAbstractThematicSurface properties = thematicSurface.getDeprecatedProperties();

            if (properties.getLod4MultiSurface() != null)
                visit(properties.getLod4MultiSurface());
        }
    }

    public void visit(AbstractTimeseries timeseries) {
        visit((AbstractFeature) timeseries);
    }

    public void visit(AbstractTransportationSpace transportationSpace) {
        visit((AbstractUnoccupiedSpace) transportationSpace);

        if (transportationSpace.isSetTrafficSpaces()) {
            for (TrafficSpaceProperty property : new ArrayList<>(transportationSpace.getTrafficSpaces()))
                visit(property);
        }

        if (transportationSpace.isSetAuxiliaryTrafficSpaces()) {
            for (AuxiliaryTrafficSpaceProperty property : new ArrayList<>(transportationSpace.getAuxiliaryTrafficSpaces()))
                visit(property);
        }

        if (transportationSpace.isSetHoles()) {
            for (HoleProperty property : new ArrayList<>(transportationSpace.getHoles()))
                visit(property);
        }

        if (transportationSpace.isSetMarkings()) {
            for (MarkingProperty property : new ArrayList<>(transportationSpace.getMarkings()))
                visit(property);
        }

        if (transportationSpace.hasDeprecatedProperties()) {
            DeprecatedPropertiesOfAbstractTransportationSpace properties = transportationSpace.getDeprecatedProperties();

            if (properties.getLod0Network() != null)
                visit(properties.getLod0Network());

            if (properties.getLod1MultiSurface() != null)
                visit(properties.getLod1MultiSurface());

            if (properties.getLod4MultiSurface() != null)
                visit(properties.getLod4MultiSurface());
        }
    }

    public void visit(AbstractTunnel tunnel) {
        visit((AbstractConstruction) tunnel);

        if (tunnel.isSetTunnelConstructiveElements()) {
            for (TunnelConstructiveElementProperty property : new ArrayList<>(tunnel.getTunnelConstructiveElements()))
                visit(property);
        }

        if (tunnel.isSetTunnelInstallations()) {
            for (TunnelInstallationProperty property : new ArrayList<>(tunnel.getTunnelInstallations()))
                visit(property);
        }

        if (tunnel.isSetHollowSpaces()) {
            for (HollowSpaceProperty property : new ArrayList<>(tunnel.getHollowSpaces()))
                visit(property);
        }

        if (tunnel.isSetTunnelFurniture()) {
            for (TunnelFurnitureProperty property : new ArrayList<>(tunnel.getTunnelFurniture()))
                visit(property);
        }

        if (tunnel.hasDeprecatedProperties()) {
            DeprecatedPropertiesOfAbstractTunnel properties = tunnel.getDeprecatedProperties();

            if (properties.isSetConsistsOfTunnelParts()) {
                for (TunnelPartProperty property : new ArrayList<>(properties.getConsistsOfTunnelParts()))
                    visit(property);
            }

            if (properties.getLod1MultiSurface() != null)
                visit(properties.getLod1MultiSurface());

            if (properties.getLod4MultiCurve() != null)
                visit(properties.getLod4MultiCurve());

            if (properties.getLod4MultiSurface() != null)
                visit(properties.getLod4MultiSurface());

            if (properties.getLod4Solid() != null)
                visit(properties.getLod4Solid());

            if (properties.getLod4TerrainIntersectionCurve() != null)
                visit(properties.getLod4TerrainIntersectionCurve());
        }
    }

    public void visit(AbstractUnoccupiedSpace unoccupiedSpace) {
        visit((AbstractPhysicalSpace) unoccupiedSpace);
    }

    public void visit(AbstractVegetationObject vegetationObject) {
        visit((AbstractOccupiedSpace) vegetationObject);
    }

    public void visit(AbstractVersion version) {
        visit((AbstractFeatureWithLifespan) version);
    }

    public void visit(AbstractVersionTransition versionTransition) {
        visit((AbstractFeatureWithLifespan) versionTransition);
    }

    public void visit(AbstractWaterBoundarySurface waterBoundarySurface) {
        visit((AbstractThematicSurface) waterBoundarySurface);
    }

    @Override
    public void visit(Address address) {
        visit((AbstractFeature) address);

        if (address.getMultiPoint() != null)
            visit(address.getMultiPoint());
    }

    @Override
    public void visit(Appearance appearance) {
        visit((AbstractAppearance) appearance);

        if (appearance.isSetSurfaceData()) {
            for (AbstractSurfaceDataProperty property : new ArrayList<>(appearance.getSurfaceData()))
                visit(property);
        }
    }

    @Override
    public void visit(AuxiliaryTrafficArea auxiliaryTrafficArea) {
        visit((AbstractThematicSurface) auxiliaryTrafficArea);
    }

    @Override
    public void visit(AuxiliaryTrafficSpace auxiliaryTrafficSpace) {
        visit((AbstractUnoccupiedSpace) auxiliaryTrafficSpace);
    }

    @Override
    public void visit(BreaklineRelief breaklineRelief) {
        visit((AbstractReliefComponent) breaklineRelief);

        if (breaklineRelief.getRidgeOrValleyLines() != null)
            visit(breaklineRelief.getRidgeOrValleyLines());

        if (breaklineRelief.getBreaklines() != null)
            visit(breaklineRelief.getBreaklines());
    }

    @Override
    public void visit(Bridge bridge) {
        visit((AbstractBridge) bridge);

        if (bridge.isSetBridgeParts()) {
            for (BridgePartProperty property : new ArrayList<>(bridge.getBridgeParts()))
                visit(property);
        }
    }

    @Override
    public void visit(BridgeConstructiveElement bridgeConstructiveElement) {
        visit((AbstractConstructiveElement) bridgeConstructiveElement);

        if (bridgeConstructiveElement.hasDeprecatedProperties()) {
            DeprecatedPropertiesOfBridgeConstructiveElement properties = bridgeConstructiveElement.getDeprecatedProperties();

            if (properties.getLod1Geometry() != null)
                visit(properties.getLod1Geometry());

            if (properties.getLod2Geometry() != null)
                visit(properties.getLod2Geometry());

            if (properties.getLod3Geometry() != null)
                visit(properties.getLod3Geometry());

            if (properties.getLod4Geometry() != null)
                visit(properties.getLod4Geometry());

            if (properties.getLod4TerrainIntersectionCurve() != null)
                visit(properties.getLod4TerrainIntersectionCurve());

            if (properties.getLod4ImplicitRepresentation() != null)
                visit(properties.getLod4ImplicitRepresentation());
        }
    }

    @Override
    public void visit(BridgeFurniture bridgeFurniture) {
        visit((AbstractFurniture) bridgeFurniture);

        if (bridgeFurniture.hasDeprecatedProperties()) {
            DeprecatedPropertiesOfBridgeFurniture properties = bridgeFurniture.getDeprecatedProperties();

            if (properties.getLod4Geometry() != null)
                visit(properties.getLod4Geometry());

            if (properties.getLod4ImplicitRepresentation() != null)
                visit(properties.getLod4ImplicitRepresentation());
        }
    }

    @Override
    public void visit(BridgeInstallation bridgeInstallation) {
        visit((AbstractInstallation) bridgeInstallation);

        if (bridgeInstallation.hasDeprecatedProperties()) {
            DeprecatedPropertiesOfBridgeInstallation properties = bridgeInstallation.getDeprecatedProperties();

            if (properties.getLod2Geometry() != null)
                visit(properties.getLod2Geometry());

            if (properties.getLod3Geometry() != null)
                visit(properties.getLod3Geometry());

            if (properties.getLod4Geometry() != null)
                visit(properties.getLod4Geometry());

            if (properties.getLod4ImplicitRepresentation() != null)
                visit(properties.getLod4ImplicitRepresentation());
        }
    }

    @Override
    public void visit(BridgePart bridgePart) {
        visit((AbstractBridge) bridgePart);
    }

    @Override
    public void visit(BridgeRoom bridgeRoom) {
        visit((AbstractUnoccupiedSpace) bridgeRoom);

        if (bridgeRoom.isSetBridgeFurniture()) {
            for (BridgeFurnitureProperty property : new ArrayList<>(bridgeRoom.getBridgeFurniture()))
                visit(property);
        }

        if (bridgeRoom.isSetBridgeInstallations()) {
            for (BridgeInstallationProperty property : new ArrayList<>(bridgeRoom.getBridgeInstallations()))
                visit(property);
        }

        if (bridgeRoom.hasDeprecatedProperties()) {
            DeprecatedPropertiesOfBridgeRoom properties = bridgeRoom.getDeprecatedProperties();

            if (properties.getLod4Solid() != null)
                visit(properties.getLod4Solid());

            if (properties.getLod4MultiSurface() != null)
                visit(properties.getLod4MultiSurface());
        }
    }

    @Override
    public void visit(Building building) {
        visit((AbstractBuilding) building);

        if (building.isSetBuildingParts()) {
            for (BuildingPartProperty property : new ArrayList<>(building.getBuildingParts()))
                visit(property);
        }
    }

    @Override
    public void visit(BuildingConstructiveElement buildingConstructiveElement) {
        visit((AbstractConstructiveElement) buildingConstructiveElement);
    }

    @Override
    public void visit(BuildingFurniture buildingFurniture) {
        visit((AbstractFurniture) buildingFurniture);

        if (buildingFurniture.hasDeprecatedProperties()) {
            DeprecatedPropertiesOfBuildingFurniture properties = buildingFurniture.getDeprecatedProperties();

            if (properties.getLod4Geometry() != null)
                visit(properties.getLod4Geometry());

            if (properties.getLod4ImplicitRepresentation() != null)
                visit(properties.getLod4ImplicitRepresentation());
        }
    }

    @Override
    public void visit(BuildingInstallation buildingInstallation) {
        visit((AbstractInstallation) buildingInstallation);

        if (buildingInstallation.hasDeprecatedProperties()) {
            DeprecatedPropertiesOfBuildingInstallation properties = buildingInstallation.getDeprecatedProperties();

            if (properties.getLod2Geometry() != null)
                visit(properties.getLod2Geometry());

            if (properties.getLod3Geometry() != null)
                visit(properties.getLod3Geometry());

            if (properties.getLod4Geometry() != null)
                visit(properties.getLod4Geometry());

            if (properties.getLod4ImplicitRepresentation() != null)
                visit(properties.getLod4ImplicitRepresentation());
        }
    }

    @Override
    public void visit(BuildingPart buildingPart) {
        visit((AbstractBuilding) buildingPart);
    }

    @Override
    public void visit(BuildingRoom buildingRoom) {
        visit((AbstractUnoccupiedSpace) buildingRoom);

        if (buildingRoom.isSetBuildingFurniture()) {
            for (BuildingFurnitureProperty property : new ArrayList<>(buildingRoom.getBuildingFurniture()))
                visit(property);
        }

        if (buildingRoom.isSetBuildingInstallations()) {
            for (BuildingInstallationProperty property : new ArrayList<>(buildingRoom.getBuildingInstallations()))
                visit(property);
        }

        if (buildingRoom.hasDeprecatedProperties()) {
            DeprecatedPropertiesOfBuildingRoom properties = buildingRoom.getDeprecatedProperties();

            if (properties.getLod4Solid() != null)
                visit(properties.getLod4Solid());

            if (properties.getLod4MultiSurface() != null)
                visit(properties.getLod4MultiSurface());
        }
    }

    @Override
    public void visit(BuildingUnit buildingUnit) {
        visit((AbstractBuildingSubdivision) buildingUnit);

        if (buildingUnit.isSetStoreys()) {
            for (StoreyProperty property : new ArrayList<>(buildingUnit.getStoreys()))
                visit(property);
        }

        if (buildingUnit.isSetAddresses()) {
            for (AddressProperty property : new ArrayList<>(buildingUnit.getAddresses()))
                visit(property);
        }
    }

    @Override
    public void visit(CeilingSurface ceilingSurface) {
        visit((AbstractConstructionSurface) ceilingSurface);
    }

    @Override
    public void visit(CityFurniture cityFurniture) {
        visit((AbstractOccupiedSpace) cityFurniture);

        if (cityFurniture.hasDeprecatedProperties()) {
            DeprecatedPropertiesOfCityFurniture properties = cityFurniture.getDeprecatedProperties();

            if (properties.getLod1Geometry() != null)
                visit(properties.getLod1Geometry());

            if (properties.getLod2Geometry() != null)
                visit(properties.getLod2Geometry());

            if (properties.getLod3Geometry() != null)
                visit(properties.getLod3Geometry());

            if (properties.getLod4Geometry() != null)
                visit(properties.getLod4Geometry());

            if (properties.getLod4TerrainIntersectionCurve() != null)
                visit(properties.getLod4TerrainIntersectionCurve());

            if (properties.getLod4ImplicitRepresentation() != null)
                visit(properties.getLod4ImplicitRepresentation());
        }
    }

    @Override
    public void visit(CityModel cityModel) {
        visit((AbstractFeatureWithLifespan) cityModel);

        if (cityModel.isSetCityObjectMembers()) {
            for (AbstractCityObjectProperty property : new ArrayList<>(cityModel.getCityObjectMembers()))
                visit(property);
        }

        if (cityModel.isSetAppearanceMembers()) {
            for (AbstractAppearanceProperty property : new ArrayList<>(cityModel.getAppearanceMembers()))
                visit(property);
        }

        if (cityModel.isSetFeatureMembers()) {
            for (AbstractFeatureProperty property : new ArrayList<>(cityModel.getFeatureMembers()))
                visit(property);
        }

        if (cityModel.isSetVersionMembers()) {
            for (AbstractVersionProperty property : new ArrayList<>(cityModel.getVersionMembers()))
                visit(property);
        }

        if (cityModel.isSetVersionTransitionMembers()) {
            for (AbstractVersionTransitionProperty property : new ArrayList<>(cityModel.getVersionTransitionMembers()))
                visit(property);
        }
    }

    @Override
    public void visit(CityObjectGroup cityObjectGroup) {
        visit((AbstractLogicalSpace) cityObjectGroup);

        if (cityObjectGroup.isSetGroupMembers()) {
            for (RoleProperty property : new ArrayList<>(cityObjectGroup.getGroupMembers()))
                visit(property);
        }

        if (cityObjectGroup.getGroupParent() != null)
            visit(cityObjectGroup.getGroupParent());

        if (cityObjectGroup.hasDeprecatedProperties()) {
            DeprecatedPropertiesOfCityObjectGroup properties = cityObjectGroup.getDeprecatedProperties();

            if (properties.isSetGroupMembers()) {
                for (GroupMember member : new ArrayList<>(properties.getGroupMembers()))
                    visit(member);
            }

            if (properties.getGroupParent() != null)
                visit(properties.getGroupParent());

            if (properties.getGeometry() != null)
                visit(properties.getGeometry());
        }
    }

    @Override
    public void visit(CityObjectRelation cityObjectRelation) {
        visit((AbstractGML) cityObjectRelation);

        if (cityObjectRelation.getRelatedTo() != null)
            visit(cityObjectRelation.getRelatedTo());
    }

    @Override
    public void visit(ClearanceSpace clearanceSpace) {
        visit((AbstractUnoccupiedSpace) clearanceSpace);
    }

    @Override
    public void visit(ClosureSurface closureSurface) {
        visit((AbstractThematicSurface) closureSurface);
    }

    @Override
    public void visit(CompositeTimeseries compositeTimeseries) {
        visit((AbstractTimeseries) compositeTimeseries);

        if (compositeTimeseries.isSetComponents()) {
            for (TimeseriesComponentProperty property : new ArrayList<>(compositeTimeseries.getComponents()))
                visit(property);
        }
    }

    @Override
    public void visit(CompositeValue compositeValue) {
        visit((AbstractGML) compositeValue);

        if (compositeValue.isSetValueComponent()) {
            for (ValueProperty property : new ArrayList<>(compositeValue.getValueComponent())) {
                if (property.getObject() != null)
                    visit(property.getObject());
            }
        }

        if (compositeValue.getValueComponents() != null && compositeValue.getValueComponents().isSetObjects()) {
            for (Value value : new ArrayList<>(compositeValue.getValueComponents().getObjects())) {
                if (value != null)
                    visit(value);
            }
        }
    }

    public void visit(DefinitionBase definitionBase) {
        visit((AbstractGML) definitionBase);
    }

    @Override
    public void visit(Definition definition) {
        visit((DefinitionBase) definition);
    }

    @Override
    public void visit(DefinitionProxy definitionProxy) {
        visit((Definition) definitionProxy);

        if (definitionProxy.getDefinitionRef() != null)
            visit(definitionProxy.getDefinitionRef());
    }

    @Override
    public void visit(Dictionary dictionary) {
        visit((Definition) dictionary);

        if (dictionary.isSetDefinitions()) {
            for (DefinitionProperty property : new ArrayList<>(dictionary.getDefinitions()))
                visit(property);
        }
    }

    @Override
    public void visit(Door door) {
        visit((AbstractFillingElement) door);

        if (door.isSetAddresses()) {
            for (AddressProperty property : new ArrayList<>(door.getAddresses()))
                visit(property);
        }
    }

    @Override
    public void visit(DoorSurface doorSurface) {
        visit((AbstractFillingSurface) doorSurface);

        if (doorSurface.isSetAddresses()) {
            for (AddressProperty property : new ArrayList<>(doorSurface.getAddresses()))
                visit(property);
        }
    }

    @Override
    public void visit(Dynamizer dynamizer) {
        visit((AbstractDynamizer) dynamizer);

        if (dynamizer.getSensorConnection() != null
                && dynamizer.getSensorConnection().getObject() != null
                && dynamizer.getSensorConnection().getObject().getSensorLocation() != null)
            visit(dynamizer.getSensorConnection().getObject().getSensorLocation());

        if (dynamizer.getDynamicData() != null)
            visit(dynamizer.getDynamicData());
    }

    @Override
    public void visit(FloorSurface floorSurface) {
        visit((AbstractConstructionSurface) floorSurface);
    }

    @Override
    public void visit(GenericLogicalSpace genericLogicalSpace) {
        visit((AbstractLogicalSpace) genericLogicalSpace);
    }

    @Override
    public void visit(GenericOccupiedSpace genericOccupiedSpace) {
        visit((AbstractOccupiedSpace) genericOccupiedSpace);

        if (genericOccupiedSpace.hasDeprecatedProperties()) {
            DeprecatedPropertiesOfGenericOccupiedSpace properties = genericOccupiedSpace.getDeprecatedProperties();

            if (properties.getLod0Geometry() != null)
                visit(properties.getLod0Geometry());

            if (properties.getLod1Geometry() != null)
                visit(properties.getLod1Geometry());

            if (properties.getLod2Geometry() != null)
                visit(properties.getLod2Geometry());

            if (properties.getLod3Geometry() != null)
                visit(properties.getLod3Geometry());

            if (properties.getLod4Geometry() != null)
                visit(properties.getLod4Geometry());

            if (properties.getLod0TerrainIntersectionCurve() != null)
                visit(properties.getLod0TerrainIntersectionCurve());

            if (properties.getLod4TerrainIntersectionCurve() != null)
                visit(properties.getLod4TerrainIntersectionCurve());

            if (properties.getLod0ImplicitRepresentation() != null)
                visit(properties.getLod0ImplicitRepresentation());

            if (properties.getLod4ImplicitRepresentation() != null)
                visit(properties.getLod4ImplicitRepresentation());
        }
    }

    @Override
    public void visit(GenericThematicSurface genericThematicSurface) {
        visit((AbstractThematicSurface) genericThematicSurface);
    }

    @Override
    public void visit(GenericTimeseries genericTimeseries) {
        visit((AbstractAtomicTimeseries) genericTimeseries);

        if (genericTimeseries.isSetTimeValuePairs()) {
            for (TimeValuePairProperty property : new ArrayList<>(genericTimeseries.getTimeValuePairs())) {
                if (property.getObject() != null)
                    visit(property.getObject());
            }
        }
    }

    @Override
    public void visit(GenericUnoccupiedSpace genericUnoccupiedSpace) {
        visit((AbstractUnoccupiedSpace) genericUnoccupiedSpace);
    }

    @Override
    public void visit(GeoreferencedTexture georeferencedTexture) {
        visit((AbstractTexture) georeferencedTexture);

        if (georeferencedTexture.getReferencePoint() != null)
            visit(georeferencedTexture.getReferencePoint());

        if (georeferencedTexture.isSetTargets()) {
            for (GeometryReference reference : new ArrayList<>(georeferencedTexture.getTargets()))
                visit(reference);
        }
    }

    @Override
    public void visit(GridCoverage gridCoverage) {
        visit((AbstractDiscreteCoverage<?>) gridCoverage);
    }

    @Override
    public void visit(GroundSurface groundSurface) {
        visit((AbstractConstructionSurface) groundSurface);
    }

    @Override
    public void visit(Hole hole) {
        visit((AbstractUnoccupiedSpace) hole);
    }

    @Override
    public void visit(HoleSurface holeSurface) {
        visit((AbstractThematicSurface) holeSurface);
    }

    @Override
    public void visit(HollowSpace hollowSpace) {
        visit((AbstractUnoccupiedSpace) hollowSpace);

        if (hollowSpace.isSetTunnelFurniture()) {
            for (TunnelFurnitureProperty property : new ArrayList<>(hollowSpace.getTunnelFurniture()))
                visit(property);
        }

        if (hollowSpace.isSetTunnelInstallations()) {
            for (TunnelInstallationProperty property : new ArrayList<>(hollowSpace.getTunnelInstallations()))
                visit(property);
        }

        if (hollowSpace.hasDeprecatedProperties()) {
            DeprecatedPropertiesOfHollowSpace properties = hollowSpace.getDeprecatedProperties();

            if (properties.getLod4Solid() != null)
                visit(properties.getLod4Solid());

            if (properties.getLod4MultiSurface() != null)
                visit(properties.getLod4MultiSurface());
        }
    }

    @Override
    public void visit(ImplicitGeometry implicitGeometry) {
        visit((AbstractGML) implicitGeometry);

        if (implicitGeometry.isSetAppearances()) {
            for (AbstractAppearanceProperty property : new ArrayList<>(implicitGeometry.getAppearances()))
                visit(property);
        }

        if (implicitGeometry.getReferencePoint() != null)
            visit(implicitGeometry.getReferencePoint());

        if (implicitGeometry.getRelativeGeometry() != null)
            visit(implicitGeometry.getRelativeGeometry());
    }

    @Override
    public void visit(InteriorWallSurface interiorWallSurface) {
        visit((AbstractConstructionSurface) interiorWallSurface);
    }

    @Override
    public void visit(Intersection intersection) {
        visit((AbstractTransportationSpace) intersection);
    }

    @Override
    public void visit(LandUse landUse) {
        visit((AbstractThematicSurface) landUse);
    }

    @Override
    public void visit(Marking marking) {
        visit((AbstractThematicSurface) marking);
    }

    @Override
    public void visit(MassPointRelief massPointRelief) {
        visit((AbstractReliefComponent) massPointRelief);

        if (massPointRelief.getPointCloud() != null)
            visit(massPointRelief.getPointCloud());

        if (massPointRelief.getReliefPoints() != null)
            visit(massPointRelief.getReliefPoints());
    }

    @Override
    public void visit(MultiCurveCoverage multiCurveCoverage) {
        visit((AbstractDiscreteCoverage<?>) multiCurveCoverage);
    }

    @Override
    public void visit(MultiPointCoverage multiPointCoverage) {
        visit((AbstractDiscreteCoverage<?>) multiPointCoverage);
    }

    @Override
    public void visit(MultiSolidCoverage multiSolidCoverage) {
        visit((AbstractDiscreteCoverage<?>) multiSolidCoverage);
    }

    @Override
    public void visit(MultiSurfaceCoverage multiSurfaceCoverage) {
        visit((AbstractDiscreteCoverage<?>) multiSurfaceCoverage);
    }

    @Override
    public void visit(OtherConstruction otherConstruction) {
        visit((AbstractConstruction) otherConstruction);
    }

    @Override
    public void visit(OuterCeilingSurface outerCeilingSurface) {
        visit((AbstractConstructionSurface) outerCeilingSurface);
    }

    @Override
    public void visit(OuterFloorSurface outerFloorSurface) {
        visit((AbstractConstructionSurface) outerFloorSurface);
    }

    @Override
    public void visit(ParameterizedTexture parameterizedTexture) {
        visit((AbstractTexture) parameterizedTexture);

        if (parameterizedTexture.isSetTextureParameterizations()) {
            for (TextureAssociationProperty property : new ArrayList<>(parameterizedTexture.getTextureParameterizations()))
                visit(property);
        }

        if (parameterizedTexture.hasDeprecatedProperties()) {
            DeprecatedPropertiesOfParameterizedTexture properties = parameterizedTexture.getDeprecatedProperties();

            if (properties.isSetTargets()) {
                for (TextureAssociationReference reference : new ArrayList<>(properties.getTargets()))
                    visit(reference);
            }
        }
    }

    @Override
    public void visit(PlantCover plantCover) {
        visit((AbstractVegetationObject) plantCover);

        if (plantCover.hasDeprecatedProperties()) {
            DeprecatedPropertiesOfPlantCover properties = plantCover.getDeprecatedProperties();

            if (properties.getLod1MultiSurface() != null)
                visit(properties.getLod1MultiSurface());

            if (properties.getLod4MultiSurface() != null)
                visit(properties.getLod4MultiSurface());

            if (properties.getLod1MultiSolid() != null)
                visit(properties.getLod1MultiSolid());

            if (properties.getLod2MultiSolid() != null)
                visit(properties.getLod2MultiSolid());

            if (properties.getLod3MultiSolid() != null)
                visit(properties.getLod3MultiSolid());

            if (properties.getLod4MultiSolid() != null)
                visit(properties.getLod4MultiSolid());
        }
    }

    @Override
    public void visit(PointCloud pointCloud) {
        visit((AbstractPointCloud) pointCloud);

        if (pointCloud.getPoints() != null)
            visit(pointCloud.getPoints());
    }

    @Override
    public void visit(Railway railway) {
        visit((AbstractTransportationSpace) railway);

        if (railway.isSetSections()) {
            for (SectionProperty property : new ArrayList<>(railway.getSections()))
                visit(property);
        }

        if (railway.isSetIntersections()) {
            for (IntersectionProperty property : new ArrayList<>(railway.getIntersections()))
                visit(property);
        }
    }

    @Override
    public void visit(RasterRelief rasterRelief) {
        visit((AbstractReliefComponent) rasterRelief);

        if (rasterRelief.getGrid() != null)
            visit(rasterRelief.getGrid());
    }

    @Override
    public void visit(RectifiedGridCoverage rectifiedGridCoverage) {
        visit((AbstractDiscreteCoverage<?>) rectifiedGridCoverage);
    }

    @Override
    public void visit(ReliefFeature reliefFeature) {
        visit((AbstractSpaceBoundary) reliefFeature);

        if (reliefFeature.isSetReliefComponents()) {
            for (AbstractReliefComponentProperty property : new ArrayList<>(reliefFeature.getReliefComponents()))
                visit(property);
        }
    }

    @Override
    public void visit(Road road) {
        visit((AbstractTransportationSpace) road);

        if (road.isSetSections()) {
            for (SectionProperty property : new ArrayList<>(road.getSections()))
                visit(property);
        }

        if (road.isSetIntersections()) {
            for (IntersectionProperty property : new ArrayList<>(road.getIntersections()))
                visit(property);
        }
    }

    public void visit(Role role) {
        visit((AbstractGML) role);

        if (role.getGroupMember() != null)
            visit(role.getGroupMember());
    }

    @Override
    public void visit(RoofSurface roofSurface) {
        visit((AbstractConstructionSurface) roofSurface);
    }

    @Override
    public void visit(Section section) {
        visit((AbstractTransportationSpace) section);
    }

    @Override
    public void visit(SolitaryVegetationObject solitaryVegetationObject) {
        visit((AbstractVegetationObject) solitaryVegetationObject);

        if (solitaryVegetationObject.hasDeprecatedProperties()) {
            DeprecatedPropertiesOfSolitaryVegetationObject properties = solitaryVegetationObject.getDeprecatedProperties();

            if (properties.getLod1Geometry() != null)
                visit(properties.getLod1Geometry());

            if (properties.getLod2Geometry() != null)
                visit(properties.getLod2Geometry());

            if (properties.getLod3Geometry() != null)
                visit(properties.getLod3Geometry());

            if (properties.getLod4Geometry() != null)
                visit(properties.getLod4Geometry());

            if (properties.getLod4ImplicitRepresentation() != null)
                visit(properties.getLod4ImplicitRepresentation());
        }
    }

    @Override
    public void visit(Square square) {
        visit((AbstractTransportationSpace) square);
    }

    @Override
    public void visit(StandardFileTimeseries standardFileTimeseries) {
        visit((AbstractAtomicTimeseries) standardFileTimeseries);
    }

    @Override
    public void visit(Storey storey) {
        visit((AbstractBuildingSubdivision) storey);

        if (storey.isSetBuildingUnits()) {
            for (BuildingUnitProperty property : new ArrayList<>(storey.getBuildingUnits()))
                visit(property);
        }
    }

    @Override
    public void visit(TabulatedFileTimeseries tabulatedFileTimeseries) {
        visit((AbstractAtomicTimeseries) tabulatedFileTimeseries);
    }

    @Override
    public void visit(TextureAssociation textureAssociation) {
        visit((AbstractGML) textureAssociation);

        if (textureAssociation.getTarget() != null)
            visit(textureAssociation.getTarget());

        if (textureAssociation.getTextureParameterization() != null
                && textureAssociation.getTextureParameterization().getObject() instanceof TexCoordList) {
            TexCoordList texCoordList = (TexCoordList) textureAssociation.getTextureParameterization().getObject();
            if (texCoordList.isSetTextureCoordinates()) {
                for (TextureCoordinates textureCoordinates : texCoordList.getTextureCoordinates()) {
                    if (textureCoordinates.getRing() != null)
                        visit(textureCoordinates.getRing());
                }
            }
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
    public void visit(TINRelief tinRelief) {
        visit((AbstractReliefComponent) tinRelief);

        if (tinRelief.getTin() != null)
            visit(tinRelief.getTin());
    }

    @Override
    public void visit(Track track) {
        visit((AbstractTransportationSpace) track);

        if (track.isSetSections()) {
            for (SectionProperty property : new ArrayList<>(track.getSections()))
                visit(property);
        }

        if (track.isSetIntersections()) {
            for (IntersectionProperty property : new ArrayList<>(track.getIntersections()))
                visit(property);
        }
    }

    @Override
    public void visit(TrafficArea trafficArea) {
        visit((AbstractThematicSurface) trafficArea);
    }

    @Override
    public void visit(TrafficSpace trafficSpace) {
        visit((AbstractUnoccupiedSpace) trafficSpace);

        if (trafficSpace.isSetPredecessors()) {
            for (TrafficSpaceReference reference : new ArrayList<>(trafficSpace.getPredecessors()))
                visit(reference);
        }

        if (trafficSpace.isSetSuccessors()) {
            for (TrafficSpaceReference reference : new ArrayList<>(trafficSpace.getSuccessors()))
                visit(reference);
        }

        if (trafficSpace.isSetClearanceSpaces()) {
            for (ClearanceSpaceProperty property : new ArrayList<>(trafficSpace.getClearanceSpaces()))
                visit(property);
        }
    }

    @Override
    public void visit(TransportationComplex transportationComplex) {
        visit((AbstractTransportationSpace) transportationComplex);
    }

    @Override
    public void visit(Tunnel tunnel) {
        visit((AbstractTunnel) tunnel);

        if (tunnel.isSetTunnelParts()) {
            for (TunnelPartProperty property : new ArrayList<>(tunnel.getTunnelParts()))
                visit(property);
        }
    }

    @Override
    public void visit(TunnelConstructiveElement tunnelConstructiveElement) {
        visit((AbstractConstructiveElement) tunnelConstructiveElement);
    }

    @Override
    public void visit(TunnelFurniture tunnelFurniture) {
        visit((AbstractFurniture) tunnelFurniture);

        if (tunnelFurniture.hasDeprecatedProperties()) {
            DeprecatedPropertiesOfTunnelFurniture properties = tunnelFurniture.getDeprecatedProperties();

            if (properties.getLod4Geometry() != null)
                visit(properties.getLod4Geometry());

            if (properties.getLod4ImplicitRepresentation() != null)
                visit(properties.getLod4ImplicitRepresentation());
        }
    }

    @Override
    public void visit(TunnelInstallation tunnelInstallation) {
        visit((AbstractInstallation) tunnelInstallation);

        if (tunnelInstallation.hasDeprecatedProperties()) {
            DeprecatedPropertiesOfTunnelInstallation properties = tunnelInstallation.getDeprecatedProperties();

            if (properties.getLod2Geometry() != null)
                visit(properties.getLod2Geometry());

            if (properties.getLod3Geometry() != null)
                visit(properties.getLod3Geometry());

            if (properties.getLod4Geometry() != null)
                visit(properties.getLod4Geometry());

            if (properties.getLod4ImplicitRepresentation() != null)
                visit(properties.getLod4ImplicitRepresentation());
        }
    }

    @Override
    public void visit(TunnelPart tunnelPart) {
        visit((AbstractTunnel) tunnelPart);
    }

    @Override
    public void visit(ValueArray valueArray) {
        visit((CompositeValue) valueArray);
    }

    @Override
    public void visit(Version version) {
        visit((AbstractVersion) version);

        if (version.isSetVersionMembers()) {
            for (AbstractFeatureWithLifespanReference reference : new ArrayList<>(version.getVersionMembers()))
                visit(reference);
        }
    }

    @Override
    public void visit(VersionTransition versionTransition) {
        visit((AbstractVersionTransition) versionTransition);

        if (versionTransition.getFrom() != null)
            visit(versionTransition.getFrom());

        if (versionTransition.getTo() != null)
            visit(versionTransition.getTo());

        if (versionTransition.isSetTransactions()) {
            for (TransactionProperty property : versionTransition.getTransactions()) {
                if (property.getObject() != null) {
                    visit(property.getObject().getOldFeature());
                    visit(property.getObject().getNewFeature());
                }
            }
        }
    }

    @Override
    public void visit(WallSurface wallSurface) {
        visit((AbstractConstructionSurface) wallSurface);
    }

    @Override
    public void visit(WaterBody waterBody) {
        visit((AbstractOccupiedSpace) waterBody);

        if (waterBody.hasDeprecatedProperties()) {
            DeprecatedPropertiesOfWaterBody properties = waterBody.getDeprecatedProperties();

            if (properties.getLod1MultiCurve() != null)
                visit(properties.getLod1MultiCurve());

            if (properties.getLod1MultiSurface() != null)
                visit(properties.getLod1MultiSurface());

            if (properties.getLod4Solid() != null)
                visit(properties.getLod4Solid());
        }
    }

    @Override
    public void visit(WaterGroundSurface waterGroundSurface) {
        visit((AbstractWaterBoundarySurface) waterGroundSurface);
    }

    @Override
    public void visit(WaterSurface waterSurface) {
        visit((AbstractWaterBoundarySurface) waterSurface);
    }

    @Override
    public void visit(Waterway waterway) {
        visit((AbstractTransportationSpace) waterway);

        if (waterway.isSetSections()) {
            for (SectionProperty property : new ArrayList<>(waterway.getSections()))
                visit(property);
        }

        if (waterway.isSetIntersections()) {
            for (IntersectionProperty property : new ArrayList<>(waterway.getIntersections()))
                visit(property);
        }
    }

    @Override
    public void visit(Window window) {
        visit((AbstractFillingElement) window);
    }

    @Override
    public void visit(WindowSurface windowSurface) {
        visit((AbstractFillingSurface) windowSurface);
    }

    @Override
    public void visit(X3DMaterial x3dMaterial) {
        visit((AbstractSurfaceData) x3dMaterial);

        if (x3dMaterial.isSetTargets()) {
            for (GeometryReference reference : new ArrayList<>(x3dMaterial.getTargets()))
                visit(reference);
        }
    }

    @Override
    public void visit(ADEObject adeObject) {
        boolean visited = adeWalkerHelper.visitObject(adeObject, adeObject.getClass());

        if (!visited && adeObject instanceof GMLObject) {
            Class<?> parent = adeObject.getClass();
            while ((parent = parent.getSuperclass()) != Object.class) {
                if (adeWalkerHelper.visitObject(adeObject, parent))
                    break;
            }

            adeWalkerHelper.visitFields(adeObject);
        }
    }

    public void visit(GenericElement genericElement) {
    }

    public void visit(FeatureProperty<?> property) {
        visit((AbstractProperty<?>) property);

        if (shouldWalk && property != null && property.getGenericElement() != null)
            visit(property.getGenericElement());
    }

    public void visit(AbstractFeatureMember<?> member) {
        visit((AbstractInlineProperty<?>) member);

        if (shouldWalk && member != null && member.getGenericElement() != null)
            visit(member.getGenericElement());
    }

    @Override
    protected void visitObject(Object object) {
        if (object instanceof ADEObject)
            visit((ADEObject) object);
        else if (object instanceof VisitableObject)
            ((VisitableObject) object).accept(this);
        else if (object instanceof org.xmlobjects.gml.visitor.VisitableObject)
            ((org.xmlobjects.gml.visitor.VisitableObject) object).accept(this);
        else if (object instanceof VisitableGeometry)
            ((VisitableGeometry) object).accept(this);
        else if (object instanceof AbstractAssociation<?>)
            visitProperty((AbstractAssociation<?>) object);
    }

    private void visitProperty(AbstractAssociation<?> property) {
        if (property instanceof FeatureProperty<?>)
            visit((FeatureProperty<?>) property);
        else if (property instanceof GeometryProperty<?>)
            visit((GeometryProperty<?>) property);
        else if (property instanceof AbstractFeatureMember<?>)
            visit((AbstractFeatureMember<?>) property);
        else if (property instanceof AbstractReference<?>)
            visit((AbstractReference<?>) property);
        else if (property instanceof GeometryArrayProperty<?>)
            visit((GeometryArrayProperty<?>) property);
        else if (property instanceof SurfacePatchArrayProperty<?>)
            visit((SurfacePatchArrayProperty<?>) property);
        else if (property instanceof AbstractInlineGeometryProperty<?>)
            visit((AbstractInlineGeometryProperty<?>) property);
        else if (property instanceof AbstractInlineProperty<?>)
            visit((AbstractInlineProperty<?>) property);
        else if (property instanceof AbstractProperty<?>)
            visit((AbstractProperty<?>) property);
        else if (property instanceof AbstractInlineOrByReferenceProperty<?>)
            visit((AbstractInlineOrByReferenceProperty<?>) property);
        else if (property instanceof AbstractArrayProperty<?>)
            visit((AbstractArrayProperty<?>) property);
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
        if (value instanceof ADEObject)
            visit((ADEObject) value);
        else if (value instanceof CompositeValue)
            ((CompositeValue) value).accept(this);
    }

    private void visit(TimeInstantProperty property) {
        if (shouldWalk && property != null && property.getObject() != null)
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
