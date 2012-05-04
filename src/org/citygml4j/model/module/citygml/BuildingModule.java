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
package org.citygml4j.model.module.citygml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.building.Building;
import org.citygml4j.model.citygml.building.BuildingFurniture;
import org.citygml4j.model.citygml.building.BuildingInstallation;
import org.citygml4j.model.citygml.building.BuildingPart;
import org.citygml4j.model.citygml.building.CeilingSurface;
import org.citygml4j.model.citygml.building.ClosureSurface;
import org.citygml4j.model.citygml.building.Door;
import org.citygml4j.model.citygml.building.FloorSurface;
import org.citygml4j.model.citygml.building.GroundSurface;
import org.citygml4j.model.citygml.building.IntBuildingInstallation;
import org.citygml4j.model.citygml.building.InteriorWallSurface;
import org.citygml4j.model.citygml.building.OuterCeilingSurface;
import org.citygml4j.model.citygml.building.OuterFloorSurface;
import org.citygml4j.model.citygml.building.RoofSurface;
import org.citygml4j.model.citygml.building.Room;
import org.citygml4j.model.citygml.building.WallSurface;
import org.citygml4j.model.citygml.building.Window;
import org.citygml4j.model.module.Module;

public class BuildingModule extends AbstractCityGMLModule {
	private static final List<BuildingModule> instances = new ArrayList<BuildingModule>();

	public static final BuildingModule v2_0_0;
	public static final BuildingModule v1_0_0;
	public static final BuildingModule v0_4_0;

	private BuildingModule (
			CityGMLModuleType type, 
			CityGMLModuleVersion version,
			String namespaceURI, 
			String namespacePrefix, 
			String schemaLocation,
			Module... dependencies) {
		super(type, version, namespaceURI, namespacePrefix, schemaLocation, dependencies);		
		instances.add(this);
	}

	static {
		v2_0_0 = new BuildingModule (
				CityGMLModuleType.BUILDING,
				CityGMLModuleVersion.v2_0_0,
				"http://www.opengis.net/citygml/building/2.0",
				"bldg",
				"http://schemas.opengis.net/citygml/building/2.0/building.xsd",			
				CoreModule.v2_0_0);
		
		v1_0_0 = new BuildingModule (
				CityGMLModuleType.BUILDING,
				CityGMLModuleVersion.v1_0_0,
				"http://www.opengis.net/citygml/building/1.0",
				"bldg",
				"http://schemas.opengis.net/citygml/building/1.0/building.xsd",			
				CoreModule.v1_0_0);

		v0_4_0 = new BuildingModule (
				CityGMLModuleType.BUILDING,
				CoreModule.v0_4_0.getVersion(),
				CoreModule.v0_4_0.getNamespaceURI(),
				CoreModule.v0_4_0.getNamespacePrefix(),
				CoreModule.v0_4_0.getSchemaLocation(),		
				CoreModule.v0_4_0);
		
		v2_0_0.elementMap = new HashMap<String, Class<? extends CityGML>>();
		v2_0_0.elementMap.put("Building", Building.class);
		v2_0_0.elementMap.put("BuildingPart", BuildingPart.class);
		v2_0_0.elementMap.put("Room", Room.class);
		v2_0_0.elementMap.put("IntBuildingInstallation", IntBuildingInstallation.class);
		v2_0_0.elementMap.put("BuildingInstallation", BuildingInstallation.class);
		v2_0_0.elementMap.put("BuildingFurniture", BuildingFurniture.class);
		v2_0_0.elementMap.put("InteriorWallSurface", InteriorWallSurface.class);
		v2_0_0.elementMap.put("RoofSurface", RoofSurface.class);
		v2_0_0.elementMap.put("ClosureSurface", ClosureSurface.class);
		v2_0_0.elementMap.put("WallSurface", WallSurface.class);
		v2_0_0.elementMap.put("FloorSurface", FloorSurface.class);
		v2_0_0.elementMap.put("CeilingSurface", CeilingSurface.class);
		v2_0_0.elementMap.put("GroundSurface", GroundSurface.class);
		v2_0_0.elementMap.put("Window", Window.class);
		v2_0_0.elementMap.put("Door", Door.class);
		v0_4_0.elementMap = v1_0_0.elementMap = v2_0_0.elementMap;
		
		v2_0_0.elementMap.put("OuterFloorSurface", OuterFloorSurface.class);
		v2_0_0.elementMap.put("OuterCeilingSurface", OuterCeilingSurface.class);
		
		v2_0_0.propertySet = new HashSet<String>();
		v2_0_0.propertySet.add("address");
		v2_0_0.propertySet.add("boundedBy");
		v2_0_0.propertySet.add("opening");
		v2_0_0.propertySet.add("outerBuildingInstallation");
		v2_0_0.propertySet.add("interiorBuildingInstallation");
		v2_0_0.propertySet.add("interiorRoom");
		v2_0_0.propertySet.add("consistsOfBuildingPart");
		v2_0_0.propertySet.add("interiorFurniture");
		v2_0_0.propertySet.add("roomInstallation");
		v0_4_0.propertySet = v1_0_0.propertySet = v2_0_0.propertySet;
	}
	
	public static List<BuildingModule> getInstances() {
		return instances;
	}
	
	public static BuildingModule getInstance(CityGMLModuleVersion version) {
		switch (version) {
		case v2_0_0:
			return v2_0_0;
		case v1_0_0:
			return v1_0_0;
		case v0_4_0:
			return v0_4_0;
		default:
			return null;
		}
	}
	
}
