/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
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
	public void visit(Appearance appearance);
	public void visit(GeoreferencedTexture georeferencedTexture);
	public void visit(ParameterizedTexture parameterizedTexture);
	public void visit(X3DMaterial x3dMaterial);
	public void visit(Bridge bridge);
	public void visit(BridgeConstructionElement bridgeConstructionElement);
	public void visit(BridgeFurniture bridgeFurniture);
	public void visit(BridgeInstallation bridgeInstallation);
	public void visit(BridgePart bridgePart);
	public void visit(BridgeRoom bridgeRoom);
	public void visit(IntBridgeInstallation intBridgeInstallation);	
	public void visit(org.citygml4j.model.citygml.bridge.CeilingSurface ceilingSurface);
	public void visit(org.citygml4j.model.citygml.bridge.OuterCeilingSurface outerCeilingSurface);
	public void visit(org.citygml4j.model.citygml.bridge.ClosureSurface closureSurface);
	public void visit(org.citygml4j.model.citygml.bridge.FloorSurface floorSurface);
	public void visit(org.citygml4j.model.citygml.bridge.OuterFloorSurface outerFloorSurface);
	public void visit(org.citygml4j.model.citygml.bridge.GroundSurface groundSurface);
	public void visit(org.citygml4j.model.citygml.bridge.InteriorWallSurface interiorWallSurface);
	public void visit(org.citygml4j.model.citygml.bridge.RoofSurface roofSurface);
	public void visit(org.citygml4j.model.citygml.bridge.WallSurface wallSurface);
	public void visit(org.citygml4j.model.citygml.bridge.Door door);
	public void visit(org.citygml4j.model.citygml.bridge.Window window);
	public void visit(Building building);
	public void visit(BuildingFurniture buildingFurniture);
	public void visit(BuildingInstallation buildingInstallation);
	public void visit(BuildingPart buildingPart);
	public void visit(IntBuildingInstallation intBuildingInstallation);
	public void visit(Room room);
	public void visit(org.citygml4j.model.citygml.building.CeilingSurface ceilingSurface);
	public void visit(org.citygml4j.model.citygml.building.OuterCeilingSurface outerCeilingSurface);
	public void visit(org.citygml4j.model.citygml.building.ClosureSurface closureSurface);
	public void visit(org.citygml4j.model.citygml.building.FloorSurface floorSurface);
	public void visit(org.citygml4j.model.citygml.building.OuterFloorSurface outerFloorSurface);
	public void visit(org.citygml4j.model.citygml.building.GroundSurface groundSurface);
	public void visit(org.citygml4j.model.citygml.building.InteriorWallSurface interiorWallSurface);
	public void visit(org.citygml4j.model.citygml.building.RoofSurface roofSurface);
	public void visit(org.citygml4j.model.citygml.building.WallSurface wallSurface);
	public void visit(org.citygml4j.model.citygml.building.Door door);
	public void visit(org.citygml4j.model.citygml.building.Window window);
	public void visit(HollowSpace hollowSpace);
	public void visit(IntTunnelInstallation intTunnelInstallation);
	public void visit(Tunnel tunnel);
	public void visit(TunnelFurniture tunnelFurniture);
	public void visit(TunnelInstallation tunnelInstallation);
	public void visit(TunnelPart tunnelPart);
	public void visit(org.citygml4j.model.citygml.tunnel.CeilingSurface ceilingSurface);
	public void visit(org.citygml4j.model.citygml.tunnel.OuterCeilingSurface outerCeilingSurface);
	public void visit(org.citygml4j.model.citygml.tunnel.ClosureSurface closureSurface);
	public void visit(org.citygml4j.model.citygml.tunnel.FloorSurface floorSurface);
	public void visit(org.citygml4j.model.citygml.tunnel.OuterFloorSurface outerFloorSurface);
	public void visit(org.citygml4j.model.citygml.tunnel.GroundSurface groundSurface);
	public void visit(org.citygml4j.model.citygml.tunnel.InteriorWallSurface interiorWallSurface);
	public void visit(org.citygml4j.model.citygml.tunnel.RoofSurface roofSurface);
	public void visit(org.citygml4j.model.citygml.tunnel.WallSurface wallSurface);
	public void visit(org.citygml4j.model.citygml.tunnel.Door door);
	public void visit(org.citygml4j.model.citygml.tunnel.Window window);
	public void visit(CityFurniture cityFurniture);
	public void visit(CityObjectGroup cityObjectGroup);
	public void visit(Address address);
	public void visit(CityModel cityModel);
	public void visit(GenericCityObject genericCityObject);
	public void visit(LandUse landUse);
	public void visit(BreaklineRelief breaklineRelief);
	public void visit(MassPointRelief massPointRelief);
	public void visit(RasterRelief rasterRelief);
	public void visit(ReliefFeature reliefFeature);
	public void visit(TINRelief tinRelief);
	public void visit(AuxiliaryTrafficArea auxiliaryTrafficArea);
	public void visit(Railway railway);
	public void visit(RectifiedGridCoverage rectifiedGridCoverage);
	public void visit(Road road);
	public void visit(Square square);
	public void visit(Track track);
	public void visit(TrafficArea trafficArea);
	public void visit(TransportationComplex transportationComplex);
	public void visit(PlantCover plantCover);
	public void visit(SolitaryVegetationObject solitaryVegetationObject);
	public void visit(WaterBody waterBody);
	public void visit(WaterClosureSurface waterClosureSurface);
	public void visit(WaterGroundSurface waterGroundSurface);
	public void visit(WaterSurface waterSurface);
	public void visit(ADEComponent adeComponent);
	public void visit(ADEModelObject adeModelClass);
	public void visit(ADEGenericElement adeGenericElement);
	public void visit(Element element, ElementDecl decl);
}
