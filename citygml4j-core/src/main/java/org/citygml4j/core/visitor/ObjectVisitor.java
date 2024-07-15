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

package org.citygml4j.core.visitor;

import org.citygml4j.core.model.ade.ADEObject;
import org.citygml4j.core.model.appearance.*;
import org.citygml4j.core.model.bridge.*;
import org.citygml4j.core.model.building.*;
import org.citygml4j.core.model.cityfurniture.CityFurniture;
import org.citygml4j.core.model.cityobjectgroup.CityObjectGroup;
import org.citygml4j.core.model.cityobjectgroup.Role;
import org.citygml4j.core.model.construction.*;
import org.citygml4j.core.model.core.*;
import org.citygml4j.core.model.deprecated.transportation.TransportationComplex;
import org.citygml4j.core.model.dynamizer.*;
import org.citygml4j.core.model.generics.GenericLogicalSpace;
import org.citygml4j.core.model.generics.GenericOccupiedSpace;
import org.citygml4j.core.model.generics.GenericThematicSurface;
import org.citygml4j.core.model.generics.GenericUnoccupiedSpace;
import org.citygml4j.core.model.landuse.LandUse;
import org.citygml4j.core.model.pointcloud.PointCloud;
import org.citygml4j.core.model.relief.*;
import org.citygml4j.core.model.transportation.*;
import org.citygml4j.core.model.tunnel.*;
import org.citygml4j.core.model.vegetation.PlantCover;
import org.citygml4j.core.model.vegetation.SolitaryVegetationObject;
import org.citygml4j.core.model.versioning.Version;
import org.citygml4j.core.model.versioning.VersionTransition;
import org.citygml4j.core.model.waterbody.WaterBody;
import org.citygml4j.core.model.waterbody.WaterGroundSurface;
import org.citygml4j.core.model.waterbody.WaterSurface;

public interface ObjectVisitor extends org.xmlobjects.gml.visitor.ObjectVisitor {
    void visit(Address address);

    void visit(Appearance appearance);

    void visit(AuxiliaryTrafficArea auxiliaryTrafficArea);

    void visit(AuxiliaryTrafficSpace auxiliaryTrafficSpace);

    void visit(BreaklineRelief breaklineRelief);

    void visit(Bridge bridge);

    void visit(BridgeConstructiveElement bridgeConstructiveElement);

    void visit(BridgeFurniture bridgeFurniture);

    void visit(BridgeInstallation bridgeInstallation);

    void visit(BridgePart bridgePart);

    void visit(BridgeRoom bridgeRoom);

    void visit(Building building);

    void visit(BuildingConstructiveElement buildingConstructiveElement);

    void visit(BuildingFurniture buildingFurniture);

    void visit(BuildingInstallation buildingInstallation);

    void visit(BuildingPart buildingPart);

    void visit(BuildingRoom buildingRoom);

    void visit(BuildingUnit buildingUnit);

    void visit(CeilingSurface ceilingSurface);

    void visit(CityFurniture cityFurniture);

    void visit(CityModel cityModel);

    void visit(CityObjectGroup cityObjectGroup);

    void visit(CityObjectRelation cityObjectRelation);

    void visit(ClearanceSpace clearanceSpace);

    void visit(ClosureSurface closureSurface);

    void visit(CompositeTimeseries compositeTimeseries);

    void visit(Door door);

    void visit(DoorSurface doorSurface);

    void visit(Dynamizer dynamizer);

    void visit(FloorSurface floorSurface);

    void visit(GenericLogicalSpace genericLogicalSpace);

    void visit(GenericOccupiedSpace genericOccupiedSpace);

    void visit(GenericThematicSurface genericThematicSurface);

    void visit(GenericTimeseries genericTimeseries);

    void visit(GenericUnoccupiedSpace genericUnoccupiedSpace);

    void visit(GeoreferencedTexture georeferencedTexture);

    void visit(GroundSurface groundSurface);

    void visit(Hole hole);

    void visit(HoleSurface holeSurface);

    void visit(HollowSpace hollowSpace);

    void visit(ImplicitGeometry implicitGeometry);

    void visit(InteriorWallSurface interiorWallSurface);

    void visit(Intersection intersection);

    void visit(LandUse landUse);

    void visit(Marking marking);

    void visit(MassPointRelief massPointRelief);

    void visit(OtherConstruction otherConstruction);

    void visit(OuterCeilingSurface outerCeilingSurface);

    void visit(OuterFloorSurface outerFloorSurface);

    void visit(ParameterizedTexture parameterizedTexture);

    void visit(PlantCover plantCover);

    void visit(PointCloud pointCloud);

    void visit(Railway railway);

    void visit(RasterRelief rasterRelief);

    void visit(ReliefFeature reliefFeature);

    void visit(Road road);

    void visit(Role role);

    void visit(RoofSurface roofSurface);

    void visit(Section section);

    void visit(SolitaryVegetationObject solitaryVegetationObject);

    void visit(Square square);

    void visit(StandardFileTimeseries standardFileTimeseries);

    void visit(Storey storey);

    void visit(TabulatedFileTimeseries tabulatedFileTimeseries);

    void visit(TextureAssociation textureAssociation);

    void visit(TINRelief tinRelief);

    void visit(Track track);

    void visit(TrafficArea trafficArea);

    void visit(TrafficSpace trafficSpace);

    void visit(TransportationComplex transportationComplex);

    void visit(Tunnel tunnel);

    void visit(TunnelConstructiveElement tunnelConstructiveElement);

    void visit(TunnelFurniture tunnelFurniture);

    void visit(TunnelInstallation tunnelInstallation);

    void visit(TunnelPart tunnelPart);

    void visit(Version version);

    void visit(VersionTransition versionTransition);

    void visit(WallSurface wallSurface);

    void visit(WaterBody waterBody);

    void visit(WaterGroundSurface waterGroundSurface);

    void visit(WaterSurface waterSurface);

    void visit(Waterway waterway);

    void visit(Window window);

    void visit(WindowSurface windowSurface);

    void visit(X3DMaterial x3dMaterial);

    void visit(ADEObject adeObject);
}
