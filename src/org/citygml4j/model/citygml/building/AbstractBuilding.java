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
package org.citygml4j.model.citygml.building;

import java.util.GregorianCalendar;
import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.AddressProperty;
import org.citygml4j.model.citygml.core.AbstractSite;
import org.citygml4j.model.gml.basicTypes.MeasureOrNullList;
import org.citygml4j.model.gml.geometry.aggregates.MultiCurveProperty;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurfaceProperty;
import org.citygml4j.model.gml.geometry.primitives.SolidProperty;
import org.citygml4j.model.gml.measures.Length;

public interface AbstractBuilding extends BuildingModuleComponent, AbstractSite {
	public String getClazz();
	public List<String> getFunction();
	public List<String> getUsage();
	public GregorianCalendar getYearOfConstruction();
	public GregorianCalendar getYearOfDemolition();
	public String getRoofType();
	public Length getMeasuredHeight();
	public Integer getStoreysAboveGround();
	public Integer getStoreysBelowGround();
	public MeasureOrNullList getStoreyHeightsAboveGround();
	public MeasureOrNullList getStoreyHeightsBelowGround();
	public SolidProperty getLod1Solid();
	public SolidProperty getLod2Solid();
	public SolidProperty getLod3Solid();
	public SolidProperty getLod4Solid();
	public MultiCurveProperty getLod1TerrainIntersection();
	public MultiCurveProperty getLod2TerrainIntersection();
	public MultiCurveProperty getLod3TerrainIntersection();
	public MultiCurveProperty getLod4TerrainIntersection();
	public MultiCurveProperty getLod2MultiCurve();
	public MultiCurveProperty getLod3MultiCurve();
	public MultiCurveProperty getLod4MultiCurve();
	public MultiSurfaceProperty getLod1MultiSurface();
	public MultiSurfaceProperty getLod2MultiSurface();
	public MultiSurfaceProperty getLod3MultiSurface();
	public MultiSurfaceProperty getLod4MultiSurface();
	public List<BuildingInstallationProperty> getOuterBuildingInstallation();
	public List<IntBuildingInstallationProperty> getInteriorBuildingInstallation();
	public List<BoundarySurfaceProperty> getBoundedBySurface();
	public List<BuildingPartProperty> getConsistsOfBuildingPart();
	public List<InteriorRoomProperty> getInteriorRoom();
	public List<AddressProperty> getAddress();
	public List<ADEComponent> getGenericApplicationPropertyOfAbstractBuilding();

	public boolean isSetClazz();
	public boolean isSetFunction();
	public boolean isSetUsage();
	public boolean isSetYearOfConstruction();
	public boolean isSetYearOfDemolition();
	public boolean isSetRoofType();
	public boolean isSetMeasuredHeight();
	public boolean isSetStoreysAboveGround();
	public boolean isSetStoreysBelowGround();
	public boolean isSetStoreyHeightsAboveGround();
	public boolean isSetStoreyHeightsBelowGround();
	public boolean isSetLod1Solid();
	public boolean isSetLod2Solid();
	public boolean isSetLod3Solid();
	public boolean isSetLod4Solid();
	public boolean isSetLod1TerrainIntersection();
	public boolean isSetLod2TerrainIntersection();
	public boolean isSetLod3TerrainIntersection();
	public boolean isSetLod4TerrainIntersection();
	public boolean isSetLod2MultiCurve();
	public boolean isSetLod3MultiCurve();
	public boolean isSetLod4MultiCurve();
	public boolean isSetLod1MultiSurface();
	public boolean isSetLod2MultiSurface();
	public boolean isSetLod3MultiSurface();
	public boolean isSetLod4MultiSurface();
	public boolean isSetOuterBuildingInstallation();
	public boolean isSetInteriorBuildingInstallation();
	public boolean isSetBoundedBySurface();
	public boolean isSetConsistsOfBuildingPart();
	public boolean isSetInteriorRoom();
	public boolean isSetAddress();
	public boolean isSetGenericApplicationPropertyOfAbstractBuilding();

	public void setClazz(String clazz);
	public void setFunction(List<String> function);
	public void addFunction(String function);
	public void setUsage(List<String> usage);
	public void addUsage(String usage);
	public void setYearOfConstruction(GregorianCalendar yearOfConstruction);
	public void setYearOfDemolition(GregorianCalendar yearOfDemolition);
	public void setRoofType(String roofType);
	public void setMeasuredHeight(Length measuredHeight);
	public void setStoreysAboveGround(Integer storeysAboveGround);
	public void setStoreysBelowGround(Integer storeysBelowGround);
	public void setStoreyHeightsAboveGround(MeasureOrNullList storeyHeightsAboveGround);
	public void setStoreyHeightsBelowGround(MeasureOrNullList storeyHeightsBelowGround);
	public void setLod1Solid(SolidProperty lod1Solid);
	public void setLod2Solid(SolidProperty lod2Solid);
	public void setLod3Solid(SolidProperty lod3Solid);
	public void setLod4Solid(SolidProperty lod4Solid);
	public void setLod1TerrainIntersection(MultiCurveProperty lod1TerrainIntersection);
	public void setLod2TerrainIntersection(MultiCurveProperty lod2TerrainIntersection);
	public void setLod3TerrainIntersection(MultiCurveProperty lod3TerrainIntersection);
	public void setLod4TerrainIntersection(MultiCurveProperty lod4TerrainIntersection);
	public void setLod2MultiCurve(MultiCurveProperty lod2MultiCurve);
	public void setLod3MultiCurve(MultiCurveProperty lod3MultiCurve);
	public void setLod4MultiCurve(MultiCurveProperty lod4MultiCurve);
	public void setLod1MultiSurface(MultiSurfaceProperty lod1MultiSurface);
	public void setLod2MultiSurface(MultiSurfaceProperty lod2MultiSurface);
	public void setLod3MultiSurface(MultiSurfaceProperty lod3MultiSurface);
	public void setLod4MultiSurface(MultiSurfaceProperty lod4MultiSurface);
	public void setOuterBuildingInstallation(List<BuildingInstallationProperty> outerBuildingInstallation);
	public void addOuterBuildingInstallation(BuildingInstallationProperty outerBuildingInstallation);
	public void setInteriorBuildingInstallation(List<IntBuildingInstallationProperty> interiorBuildingInstallation);
	public void addInteriorBuildingInstallation(IntBuildingInstallationProperty interiorBuildingInstallation);
	public void setBoundedBySurface(List<BoundarySurfaceProperty> boundedBySurface);
	public void addBoundedBySurface(BoundarySurfaceProperty boundedBySurface);
	public void setInteriorRoom(List<InteriorRoomProperty> interiorRoom);
	public void addInteriorRoom(InteriorRoomProperty interiorRoom);
	public void setConsistsOfBuildingPart(List<BuildingPartProperty> buildingPart);
	public void addConsistsOfBuildingPart(BuildingPartProperty buildingPart);
	public void setAddress(List<AddressProperty> address);
	public void addAddress(AddressProperty address);	
	public void addGenericApplicationPropertyOfAbstractBuilding(ADEComponent ade);
	public void setGenericApplicationPropertyOfAbstractBuilding(List<ADEComponent> ade);
	
	public void unsetClazz();
	public void unsetFunction();
	public boolean unsetFunction(String function);
	public void unsetUsage();
	public boolean unsetUsage(String usage);
	public void unsetYearOfConstruction();
	public void unsetYearOfDemolition();
	public void unsetRoofType();
	public void unsetMeasuredHeight();
	public void unsetStoreysAboveGround();
	public void unsetStoreysBelowGround();
	public void unsetStoreyHeightsAboveGround();
	public void unsetStoreyHeightsBelowGround();
	public void unsetLod1Solid();
	public void unsetLod2Solid();
	public void unsetLod3Solid();
	public void unsetLod4Solid();
	public void unsetLod1TerrainIntersection();
	public void unsetLod2TerrainIntersection();
	public void unsetLod3TerrainIntersection();
	public void unsetLod4TerrainIntersection();
	public void unsetLod2MultiCurve();
	public void unsetLod3MultiCurve();
	public void unsetLod4MultiCurve();
	public void unsetLod1MultiSurface();
	public void unsetLod2MultiSurface();
	public void unsetLod3MultiSurface();
	public void unsetLod4MultiSurface();
	public void unsetOuterBuildingInstallation();
	public boolean unsetOuterBuildingInstallation(BuildingInstallationProperty outerBuildingInstallation);
	public void unsetInteriorBuildingInstallation();
	public boolean unsetInteriorBuildingInstallation(IntBuildingInstallationProperty interiorBuildingInstallation);
	public void unsetBoundedBySurface();
	public boolean unsetBoundedBySurface(BoundarySurfaceProperty boundedBySurface);
	public void unsetConsistsOfBuildingPart();
	public boolean unsetConsistsOfBuildingPart(BuildingPartProperty buildingPart);
	public void unsetInteriorRoom();
	public boolean unsetInteriorRoom(InteriorRoomProperty interiorRoom);
	public void unsetAddress();
	public boolean unsetAddress(AddressProperty address);
	public void unsetGenericApplicationPropertyOfAbstractBuilding();
	public boolean unsetGenericApplicationPropertyOfAbstractBuilding(ADEComponent ade);
}
