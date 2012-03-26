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

public interface FeatureVisitor extends Visitor {
	public void visit(Appearance appearance);
	public void visit(GeoreferencedTexture georeferencedTexture);
	public void visit(ParameterizedTexture parameterizedTexture);
	public void visit(X3DMaterial x3dMaterial);
	
	
/*	public void visit(org.citygml4j.model.citygml.bridge.CeilingSurface ceilingSurface);
	public void visit(org.citygml4j.model.citygml.bridge.OuterCeilingSurface outerCeilingSurface);
	public void visit(org.citygml4j.model.citygml.bridge.ClosureSurface closureSurface);
	public void visit(org.citygml4j.model.citygml.bridge.FloorSurface floorSurface);
	public void visit(org.citygml4j.model.citygml.bridge.OuterFloorSurface outerFloorSurface);
	public void visit(org.citygml4j.model.citygml.bridge.GroundSurface groundSurface);
	public void visit(org.citygml4j.model.citygml.bridge.InteriorWallSurface interiorWallSurface);
	public void visit(org.citygml4j.model.citygml.bridge.RoofSurface roofSurface);
	public void visit(org.citygml4j.model.citygml.bridge.WallSurface wallSurface);
*/
	
	
	
	public void visit(BuildingFurniture buildingFurniture);
	public void visit(Building building);
	public void visit(BuildingInstallation buildingInstallation);
	public void visit(BuildingPart buildingPart);
	public void visit(org.citygml4j.model.citygml.building.CeilingSurface ceilingSurface);
	public void visit(org.citygml4j.model.citygml.building.OuterCeilingSurface outerCeilingSurface);
	public void visit(org.citygml4j.model.citygml.building.ClosureSurface closureSurface);
	public void visit(Door door);
	public void visit(org.citygml4j.model.citygml.building.FloorSurface floorSurface);
	public void visit(org.citygml4j.model.citygml.building.OuterFloorSurface outerFloorSurface);
	public void visit(org.citygml4j.model.citygml.building.GroundSurface groundSurface);
	public void visit(IntBuildingInstallation intBuildingInstallation);
	public void visit(org.citygml4j.model.citygml.building.InteriorWallSurface interiorWallSurface);
	public void visit(org.citygml4j.model.citygml.building.RoofSurface roofSurface);
	public void visit(Room room);
	public void visit(org.citygml4j.model.citygml.building.WallSurface wallSurface);
	public void visit(Window window);
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
	public void visit(Element element, ElementDecl decl);
}
