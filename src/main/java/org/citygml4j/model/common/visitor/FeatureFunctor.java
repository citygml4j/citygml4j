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
package org.citygml4j.model.common.visitor;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;
import org.citygml4j.model.citygml.ade.generic.ADEGenericElement;
import org.citygml4j.model.citygml.appearance.Appearance;
import org.citygml4j.model.citygml.appearance.GeoreferencedTexture;
import org.citygml4j.model.citygml.appearance.ParameterizedTexture;
import org.citygml4j.model.citygml.appearance.X3DMaterial;
import org.citygml4j.model.citygml.bridge.*;
import org.citygml4j.model.citygml.building.*;
import org.citygml4j.model.citygml.cityfurniture.CityFurniture;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroup;
import org.citygml4j.model.citygml.core.Address;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.citygml.generics.GenericCityObject;
import org.citygml4j.model.citygml.landuse.LandUse;
import org.citygml4j.model.citygml.relief.*;
import org.citygml4j.model.citygml.transportation.*;
import org.citygml4j.model.citygml.tunnel.*;
import org.citygml4j.model.citygml.vegetation.PlantCover;
import org.citygml4j.model.citygml.vegetation.SolitaryVegetationObject;
import org.citygml4j.model.citygml.waterbody.WaterBody;
import org.citygml4j.model.citygml.waterbody.WaterClosureSurface;
import org.citygml4j.model.citygml.waterbody.WaterGroundSurface;
import org.citygml4j.model.citygml.waterbody.WaterSurface;
import org.citygml4j.model.gml.coverage.RectifiedGridCoverage;
import org.citygml4j.xml.schema.ElementDecl;
import org.w3c.dom.Element;

public interface FeatureFunctor<T> extends Functor<T> {
    T apply(Appearance appearance);

    T apply(GeoreferencedTexture georeferencedTexture);

    T apply(ParameterizedTexture parameterizedTexture);

    T apply(X3DMaterial x3dMaterial);

    T apply(Bridge bridge);

    T apply(BridgeConstructionElement bridgeConstructionElement);

    T apply(BridgeFurniture bridgeFurniture);

    T apply(BridgeInstallation bridgeInstallation);

    T apply(BridgePart bridgePart);

    T apply(BridgeRoom bridgeRoom);

    T apply(IntBridgeInstallation intBridgeInstallation);

    T apply(org.citygml4j.model.citygml.bridge.CeilingSurface ceilingSurface);

    T apply(org.citygml4j.model.citygml.bridge.OuterCeilingSurface outerCeilingSurface);

    T apply(org.citygml4j.model.citygml.bridge.ClosureSurface closureSurface);

    T apply(org.citygml4j.model.citygml.bridge.FloorSurface floorSurface);

    T apply(org.citygml4j.model.citygml.bridge.OuterFloorSurface outerFloorSurface);

    T apply(org.citygml4j.model.citygml.bridge.GroundSurface groundSurface);

    T apply(org.citygml4j.model.citygml.bridge.InteriorWallSurface interiorWallSurface);

    T apply(org.citygml4j.model.citygml.bridge.RoofSurface roofSurface);

    T apply(org.citygml4j.model.citygml.bridge.WallSurface wallSurface);

    T apply(org.citygml4j.model.citygml.bridge.Door door);

    T apply(org.citygml4j.model.citygml.bridge.Window window);

    T apply(Building building);

    T apply(BuildingFurniture buildingFurniture);

    T apply(BuildingInstallation buildingInstallation);

    T apply(BuildingPart buildingPart);

    T apply(IntBuildingInstallation intBuildingInstallation);

    T apply(Room room);

    T apply(org.citygml4j.model.citygml.building.CeilingSurface ceilingSurface);

    T apply(org.citygml4j.model.citygml.building.OuterCeilingSurface outerCeilingSurface);

    T apply(org.citygml4j.model.citygml.building.ClosureSurface closureSurface);

    T apply(org.citygml4j.model.citygml.building.FloorSurface floorSurface);

    T apply(org.citygml4j.model.citygml.building.OuterFloorSurface outerFloorSurface);

    T apply(org.citygml4j.model.citygml.building.GroundSurface groundSurface);

    T apply(org.citygml4j.model.citygml.building.InteriorWallSurface interiorWallSurface);

    T apply(org.citygml4j.model.citygml.building.RoofSurface roofSurface);

    T apply(org.citygml4j.model.citygml.building.WallSurface wallSurface);

    T apply(org.citygml4j.model.citygml.building.Door door);

    T apply(org.citygml4j.model.citygml.building.Window window);

    T apply(HollowSpace hollowSpace);

    T apply(IntTunnelInstallation intTunnelInstallation);

    T apply(Tunnel tunnel);

    T apply(TunnelFurniture tunnelFurniture);

    T apply(TunnelInstallation tunnelInstallation);

    T apply(TunnelPart tunnelPart);

    T apply(org.citygml4j.model.citygml.tunnel.CeilingSurface ceilingSurface);

    T apply(org.citygml4j.model.citygml.tunnel.OuterCeilingSurface outerCeilingSurface);

    T apply(org.citygml4j.model.citygml.tunnel.ClosureSurface closureSurface);

    T apply(org.citygml4j.model.citygml.tunnel.FloorSurface floorSurface);

    T apply(org.citygml4j.model.citygml.tunnel.OuterFloorSurface outerFloorSurface);

    T apply(org.citygml4j.model.citygml.tunnel.GroundSurface groundSurface);

    T apply(org.citygml4j.model.citygml.tunnel.InteriorWallSurface interiorWallSurface);

    T apply(org.citygml4j.model.citygml.tunnel.RoofSurface roofSurface);

    T apply(org.citygml4j.model.citygml.tunnel.WallSurface wallSurface);

    T apply(org.citygml4j.model.citygml.tunnel.Door door);

    T apply(org.citygml4j.model.citygml.tunnel.Window window);

    T apply(CityFurniture cityFurniture);

    T apply(CityObjectGroup cityObjectGroup);

    T apply(Address address);

    T apply(CityModel cityModel);

    T apply(GenericCityObject genericCityObject);

    T apply(LandUse landUse);

    T apply(BreaklineRelief breaklineRelief);

    T apply(MassPointRelief massPointRelief);

    T apply(RasterRelief rasterRelief);

    T apply(ReliefFeature reliefFeature);

    T apply(TINRelief tinRelief);

    T apply(AuxiliaryTrafficArea auxiliaryTrafficArea);

    T apply(Railway railway);

    T apply(RectifiedGridCoverage rectifiedGridCoverage);

    T apply(Road road);

    T apply(Square square);

    T apply(Track track);

    T apply(TrafficArea trafficArea);

    T apply(TransportationComplex transportationComplex);

    T apply(PlantCover plantCover);

    T apply(SolitaryVegetationObject solitaryVegetationObject);

    T apply(WaterBody waterBody);

    T apply(WaterClosureSurface waterClosureSurface);

    T apply(WaterGroundSurface waterGroundSurface);

    T apply(WaterSurface waterSurface);

    T apply(ADEComponent adeComponent);

    T apply(ADEModelObject adeModelClass);

    T apply(ADEGenericElement adeGenericElement);

    T apply(Element element, ElementDecl decl);
}
