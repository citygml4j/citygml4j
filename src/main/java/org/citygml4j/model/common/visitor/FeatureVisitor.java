/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2023 Claus Nagel <claus.nagel@gmail.com>
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
package org.citygml4j.model.common.visitor;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;
import org.citygml4j.model.citygml.ade.generic.ADEGenericElement;
import org.citygml4j.model.citygml.appearance.Appearance;
import org.citygml4j.model.citygml.appearance.GeoreferencedTexture;
import org.citygml4j.model.citygml.appearance.ParameterizedTexture;
import org.citygml4j.model.citygml.appearance.X3DMaterial;
import org.citygml4j.model.citygml.bridge.Bridge;
import org.citygml4j.model.citygml.bridge.BridgeConstructionElement;
import org.citygml4j.model.citygml.bridge.BridgeFurniture;
import org.citygml4j.model.citygml.bridge.BridgeInstallation;
import org.citygml4j.model.citygml.bridge.BridgePart;
import org.citygml4j.model.citygml.bridge.BridgeRoom;
import org.citygml4j.model.citygml.bridge.IntBridgeInstallation;
import org.citygml4j.model.citygml.building.Building;
import org.citygml4j.model.citygml.building.BuildingFurniture;
import org.citygml4j.model.citygml.building.BuildingInstallation;
import org.citygml4j.model.citygml.building.BuildingPart;
import org.citygml4j.model.citygml.building.IntBuildingInstallation;
import org.citygml4j.model.citygml.building.Room;
import org.citygml4j.model.citygml.cityfurniture.CityFurniture;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroup;
import org.citygml4j.model.citygml.core.Address;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.citygml.generics.GenericCityObject;
import org.citygml4j.model.citygml.landuse.LandUse;
import org.citygml4j.model.citygml.relief.BreaklineRelief;
import org.citygml4j.model.citygml.relief.MassPointRelief;
import org.citygml4j.model.citygml.relief.RasterRelief;
import org.citygml4j.model.citygml.relief.ReliefFeature;
import org.citygml4j.model.citygml.relief.TINRelief;
import org.citygml4j.model.citygml.transportation.AuxiliaryTrafficArea;
import org.citygml4j.model.citygml.transportation.Railway;
import org.citygml4j.model.citygml.transportation.Road;
import org.citygml4j.model.citygml.transportation.Square;
import org.citygml4j.model.citygml.transportation.Track;
import org.citygml4j.model.citygml.transportation.TrafficArea;
import org.citygml4j.model.citygml.transportation.TransportationComplex;
import org.citygml4j.model.citygml.tunnel.HollowSpace;
import org.citygml4j.model.citygml.tunnel.IntTunnelInstallation;
import org.citygml4j.model.citygml.tunnel.Tunnel;
import org.citygml4j.model.citygml.tunnel.TunnelFurniture;
import org.citygml4j.model.citygml.tunnel.TunnelInstallation;
import org.citygml4j.model.citygml.tunnel.TunnelPart;
import org.citygml4j.model.citygml.vegetation.PlantCover;
import org.citygml4j.model.citygml.vegetation.SolitaryVegetationObject;
import org.citygml4j.model.citygml.waterbody.WaterBody;
import org.citygml4j.model.citygml.waterbody.WaterClosureSurface;
import org.citygml4j.model.citygml.waterbody.WaterGroundSurface;
import org.citygml4j.model.citygml.waterbody.WaterSurface;
import org.citygml4j.model.gml.coverage.RectifiedGridCoverage;
import org.citygml4j.xml.schema.ElementDecl;
import org.w3c.dom.Element;

public interface FeatureVisitor extends Visitor {
	void visit(Appearance appearance);
	void visit(GeoreferencedTexture georeferencedTexture);
	void visit(ParameterizedTexture parameterizedTexture);
	void visit(X3DMaterial x3dMaterial);
	void visit(Bridge bridge);
	void visit(BridgeConstructionElement bridgeConstructionElement);
	void visit(BridgeFurniture bridgeFurniture);
	void visit(BridgeInstallation bridgeInstallation);
	void visit(BridgePart bridgePart);
	void visit(BridgeRoom bridgeRoom);
	void visit(IntBridgeInstallation intBridgeInstallation);	
	void visit(org.citygml4j.model.citygml.bridge.CeilingSurface ceilingSurface);
	void visit(org.citygml4j.model.citygml.bridge.OuterCeilingSurface outerCeilingSurface);
	void visit(org.citygml4j.model.citygml.bridge.ClosureSurface closureSurface);
	void visit(org.citygml4j.model.citygml.bridge.FloorSurface floorSurface);
	void visit(org.citygml4j.model.citygml.bridge.OuterFloorSurface outerFloorSurface);
	void visit(org.citygml4j.model.citygml.bridge.GroundSurface groundSurface);
	void visit(org.citygml4j.model.citygml.bridge.InteriorWallSurface interiorWallSurface);
	void visit(org.citygml4j.model.citygml.bridge.RoofSurface roofSurface);
	void visit(org.citygml4j.model.citygml.bridge.WallSurface wallSurface);
	void visit(org.citygml4j.model.citygml.bridge.Door door);
	void visit(org.citygml4j.model.citygml.bridge.Window window);
	void visit(Building building);
	void visit(BuildingFurniture buildingFurniture);
	void visit(BuildingInstallation buildingInstallation);
	void visit(BuildingPart buildingPart);
	void visit(IntBuildingInstallation intBuildingInstallation);
	void visit(Room room);
	void visit(org.citygml4j.model.citygml.building.CeilingSurface ceilingSurface);
	void visit(org.citygml4j.model.citygml.building.OuterCeilingSurface outerCeilingSurface);
	void visit(org.citygml4j.model.citygml.building.ClosureSurface closureSurface);
	void visit(org.citygml4j.model.citygml.building.FloorSurface floorSurface);
	void visit(org.citygml4j.model.citygml.building.OuterFloorSurface outerFloorSurface);
	void visit(org.citygml4j.model.citygml.building.GroundSurface groundSurface);
	void visit(org.citygml4j.model.citygml.building.InteriorWallSurface interiorWallSurface);
	void visit(org.citygml4j.model.citygml.building.RoofSurface roofSurface);
	void visit(org.citygml4j.model.citygml.building.WallSurface wallSurface);
	void visit(org.citygml4j.model.citygml.building.Door door);
	void visit(org.citygml4j.model.citygml.building.Window window);
	void visit(HollowSpace hollowSpace);
	void visit(IntTunnelInstallation intTunnelInstallation);
	void visit(Tunnel tunnel);
	void visit(TunnelFurniture tunnelFurniture);
	void visit(TunnelInstallation tunnelInstallation);
	void visit(TunnelPart tunnelPart);
	void visit(org.citygml4j.model.citygml.tunnel.CeilingSurface ceilingSurface);
	void visit(org.citygml4j.model.citygml.tunnel.OuterCeilingSurface outerCeilingSurface);
	void visit(org.citygml4j.model.citygml.tunnel.ClosureSurface closureSurface);
	void visit(org.citygml4j.model.citygml.tunnel.FloorSurface floorSurface);
	void visit(org.citygml4j.model.citygml.tunnel.OuterFloorSurface outerFloorSurface);
	void visit(org.citygml4j.model.citygml.tunnel.GroundSurface groundSurface);
	void visit(org.citygml4j.model.citygml.tunnel.InteriorWallSurface interiorWallSurface);
	void visit(org.citygml4j.model.citygml.tunnel.RoofSurface roofSurface);
	void visit(org.citygml4j.model.citygml.tunnel.WallSurface wallSurface);
	void visit(org.citygml4j.model.citygml.tunnel.Door door);
	void visit(org.citygml4j.model.citygml.tunnel.Window window);
	void visit(CityFurniture cityFurniture);
	void visit(CityObjectGroup cityObjectGroup);
	void visit(Address address);
	void visit(CityModel cityModel);
	void visit(GenericCityObject genericCityObject);
	void visit(LandUse landUse);
	void visit(BreaklineRelief breaklineRelief);
	void visit(MassPointRelief massPointRelief);
	void visit(RasterRelief rasterRelief);
	void visit(ReliefFeature reliefFeature);
	void visit(TINRelief tinRelief);
	void visit(AuxiliaryTrafficArea auxiliaryTrafficArea);
	void visit(Railway railway);
	void visit(RectifiedGridCoverage rectifiedGridCoverage);
	void visit(Road road);
	void visit(Square square);
	void visit(Track track);
	void visit(TrafficArea trafficArea);
	void visit(TransportationComplex transportationComplex);
	void visit(PlantCover plantCover);
	void visit(SolitaryVegetationObject solitaryVegetationObject);
	void visit(WaterBody waterBody);
	void visit(WaterClosureSurface waterClosureSurface);
	void visit(WaterGroundSurface waterGroundSurface);
	void visit(WaterSurface waterSurface);
	void visit(ADEComponent adeComponent);
	void visit(ADEModelObject adeModelClass);
	void visit(ADEGenericElement adeGenericElement);
	void visit(Element element, ElementDecl decl);
}
