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

package org.citygml4j.visitor;

import org.citygml4j.model.ade.ADEObject;
import org.citygml4j.model.appearance.Appearance;
import org.citygml4j.model.appearance.GeoreferencedTexture;
import org.citygml4j.model.appearance.ParameterizedTexture;
import org.citygml4j.model.appearance.TextureAssociation;
import org.citygml4j.model.appearance.X3DMaterial;
import org.citygml4j.model.bridge.Bridge;
import org.citygml4j.model.bridge.BridgeConstructiveElement;
import org.citygml4j.model.bridge.BridgeFurniture;
import org.citygml4j.model.bridge.BridgeInstallation;
import org.citygml4j.model.bridge.BridgePart;
import org.citygml4j.model.bridge.BridgeRoom;
import org.citygml4j.model.building.Building;
import org.citygml4j.model.building.BuildingConstructiveElement;
import org.citygml4j.model.building.BuildingFurniture;
import org.citygml4j.model.building.BuildingInstallation;
import org.citygml4j.model.building.BuildingPart;
import org.citygml4j.model.building.BuildingRoom;
import org.citygml4j.model.building.BuildingUnit;
import org.citygml4j.model.building.Storey;
import org.citygml4j.model.cityfurniture.CityFurniture;
import org.citygml4j.model.cityobjectgroup.CityObjectGroup;
import org.citygml4j.model.cityobjectgroup.Role;
import org.citygml4j.model.construction.CeilingSurface;
import org.citygml4j.model.construction.Door;
import org.citygml4j.model.construction.DoorSurface;
import org.citygml4j.model.construction.FloorSurface;
import org.citygml4j.model.construction.GroundSurface;
import org.citygml4j.model.construction.InteriorWallSurface;
import org.citygml4j.model.construction.OtherConstruction;
import org.citygml4j.model.construction.OuterCeilingSurface;
import org.citygml4j.model.construction.OuterFloorSurface;
import org.citygml4j.model.construction.RoofSurface;
import org.citygml4j.model.construction.WallSurface;
import org.citygml4j.model.construction.Window;
import org.citygml4j.model.construction.WindowSurface;
import org.citygml4j.model.core.Address;
import org.citygml4j.model.core.CityModel;
import org.citygml4j.model.core.CityObjectRelation;
import org.citygml4j.model.core.ClosureSurface;
import org.citygml4j.model.core.ImplicitGeometry;
import org.citygml4j.model.deprecated.transportation.TransportationComplex;
import org.citygml4j.model.dynamizer.CompositeTimeseries;
import org.citygml4j.model.dynamizer.Dynamizer;
import org.citygml4j.model.dynamizer.GenericTimeseries;
import org.citygml4j.model.dynamizer.StandardFileTimeseries;
import org.citygml4j.model.dynamizer.TabulatedFileTimeseries;
import org.citygml4j.model.generics.GenericLogicalSpace;
import org.citygml4j.model.generics.GenericOccupiedSpace;
import org.citygml4j.model.generics.GenericThematicSurface;
import org.citygml4j.model.generics.GenericUnoccupiedSpace;
import org.citygml4j.model.landuse.LandUse;
import org.citygml4j.model.pointcloud.PointCloud;
import org.citygml4j.model.relief.BreaklineRelief;
import org.citygml4j.model.relief.MassPointRelief;
import org.citygml4j.model.relief.RasterRelief;
import org.citygml4j.model.relief.ReliefFeature;
import org.citygml4j.model.relief.TINRelief;
import org.citygml4j.model.transportation.AuxiliaryTrafficArea;
import org.citygml4j.model.transportation.AuxiliaryTrafficSpace;
import org.citygml4j.model.transportation.ClearanceSpace;
import org.citygml4j.model.transportation.Hole;
import org.citygml4j.model.transportation.HoleSurface;
import org.citygml4j.model.transportation.Intersection;
import org.citygml4j.model.transportation.Marking;
import org.citygml4j.model.transportation.Railway;
import org.citygml4j.model.transportation.Road;
import org.citygml4j.model.transportation.Section;
import org.citygml4j.model.transportation.Square;
import org.citygml4j.model.transportation.Track;
import org.citygml4j.model.transportation.TrafficArea;
import org.citygml4j.model.transportation.TrafficSpace;
import org.citygml4j.model.transportation.Waterway;
import org.citygml4j.model.tunnel.HollowSpace;
import org.citygml4j.model.tunnel.Tunnel;
import org.citygml4j.model.tunnel.TunnelConstructiveElement;
import org.citygml4j.model.tunnel.TunnelFurniture;
import org.citygml4j.model.tunnel.TunnelInstallation;
import org.citygml4j.model.tunnel.TunnelPart;
import org.citygml4j.model.vegetation.PlantCover;
import org.citygml4j.model.vegetation.SolitaryVegetationObject;
import org.citygml4j.model.versioning.Version;
import org.citygml4j.model.versioning.VersionTransition;
import org.citygml4j.model.waterbody.WaterBody;
import org.citygml4j.model.waterbody.WaterGroundSurface;
import org.citygml4j.model.waterbody.WaterSurface;

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
