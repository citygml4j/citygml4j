/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universitaet Berlin, Germany
 * http://www.igg.tu-berlin.de/
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 */
package org.citygml4j.model.common.visitor;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.appearance.Appearance;
import org.citygml4j.model.citygml.appearance.GeoreferencedTexture;
import org.citygml4j.model.citygml.appearance.ParameterizedTexture;
import org.citygml4j.model.citygml.appearance.X3DMaterial;
import org.citygml4j.model.citygml.building.Building;
import org.citygml4j.model.citygml.building.BuildingFurniture;
import org.citygml4j.model.citygml.building.BuildingInstallation;
import org.citygml4j.model.citygml.building.BuildingPart;
import org.citygml4j.model.citygml.building.Door;
import org.citygml4j.model.citygml.building.IntBuildingInstallation;
import org.citygml4j.model.citygml.building.Room;
import org.citygml4j.model.citygml.building.Window;
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
	public T apply(Appearance appearance);
	public T apply(GeoreferencedTexture georeferencedTexture);
	public T apply(ParameterizedTexture parameterizedTexture);
	public T apply(X3DMaterial x3dMaterial);
	
/*	public T apply(org.citygml4j.model.citygml.bridge.CeilingSurface ceilingSurface);
	public T apply(org.citygml4j.model.citygml.bridge.OuterCeilingSurface outerCeilingSurface);
	public T apply(org.citygml4j.model.citygml.bridge.ClosureSurface closureSurface);
	public T apply(org.citygml4j.model.citygml.bridge.FloorSurface floorSurface);
	public T apply(org.citygml4j.model.citygml.bridge.OuterFloorSurface outerFloorSurface);
	public T apply(org.citygml4j.model.citygml.bridge.GroundSurface groundSurface);
	public T apply(org.citygml4j.model.citygml.bridge.InteriorWallSurface interiorWallSurface);
	public T apply(org.citygml4j.model.citygml.bridge.RoofSurface roofSurface);
	public T apply(org.citygml4j.model.citygml.bridge.WallSurface wallSurface);
*/
	
	
	public T apply(BuildingFurniture buildingFurniture);
	public T apply(Building building);
	public T apply(BuildingInstallation buildingInstallation);
	public T apply(BuildingPart buildingPart);
	public T apply(org.citygml4j.model.citygml.building.CeilingSurface ceilingSurface);
	public T apply(org.citygml4j.model.citygml.building.OuterCeilingSurface outerCeilingSurface);
	public T apply(org.citygml4j.model.citygml.building.ClosureSurface closureSurface);
	public T apply(Door door);
	public T apply(org.citygml4j.model.citygml.building.FloorSurface floorSurface);
	public T apply(org.citygml4j.model.citygml.building.OuterFloorSurface outerFloorSurface);
	public T apply(org.citygml4j.model.citygml.building.GroundSurface groundSurface);
	public T apply(IntBuildingInstallation intBuildingInstallation);
	public T apply(org.citygml4j.model.citygml.building.InteriorWallSurface interiorWallSurface);
	public T apply(org.citygml4j.model.citygml.building.RoofSurface roofSurface);
	public T apply(Room room);
	public T apply(org.citygml4j.model.citygml.building.WallSurface wallSurface);
	public T apply(Window window);
	public T apply(CityFurniture cityFurniture);
	public T apply(CityObjectGroup cityObjectGroup);
	public T apply(Address address);
	public T apply(CityModel cityModel);
	public T apply(GenericCityObject genericCityObject);
	public T apply(LandUse landUse);
	public T apply(BreaklineRelief breaklineRelief);
	public T apply(MassPointRelief massPointRelief);
	public T apply(RasterRelief rasterRelief);
	public T apply(ReliefFeature reliefFeature);
	public T apply(TINRelief tinRelief);
	public T apply(AuxiliaryTrafficArea auxiliaryTrafficArea);
	public T apply(Railway railway);
	public T apply(RectifiedGridCoverage rectifiedGridCoverage);
	public T apply(Road road);
	public T apply(Square square);
	public T apply(Track track);
	public T apply(TrafficArea trafficArea);
	public T apply(TransportationComplex transportationComplex);
	public T apply(PlantCover plantCover);
	public T apply(SolitaryVegetationObject solitaryVegetationObject);
	public T apply(WaterBody waterBody);
	public T apply(WaterClosureSurface waterClosureSurface);
	public T apply(WaterGroundSurface waterGroundSurface);
	public T apply(WaterSurface waterSurface);
	public T apply(ADEComponent adeComponent);
	public T apply(Element element, ElementDecl decl);
}
