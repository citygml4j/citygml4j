/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright 2013-2017 Claus Nagel <claus.nagel@gmail.com>
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
package org.citygml4j.model.module.citygml;

import org.citygml4j.model.citygml.building.AbstractBoundarySurface;
import org.citygml4j.model.citygml.building.AbstractBuilding;
import org.citygml4j.model.citygml.building.AbstractOpening;
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
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.module.Module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class BuildingModule extends AbstractCityGMLModule {
	private static final List<BuildingModule> instances = new ArrayList<BuildingModule>();

	public static final BuildingModule v2_0_0;
	public static final BuildingModule v1_0_0;

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

		v2_0_0.features = new HashMap<String, Class<? extends AbstractFeature>>();
		v2_0_0.features.put("Building", Building.class);
		v2_0_0.features.put("BuildingPart", BuildingPart.class);
		v2_0_0.features.put("Room", Room.class);
		v2_0_0.features.put("IntBuildingInstallation", IntBuildingInstallation.class);
		v2_0_0.features.put("BuildingInstallation", BuildingInstallation.class);
		v2_0_0.features.put("BuildingFurniture", BuildingFurniture.class);
		v2_0_0.features.put("InteriorWallSurface", InteriorWallSurface.class);
		v2_0_0.features.put("RoofSurface", RoofSurface.class);
		v2_0_0.features.put("ClosureSurface", ClosureSurface.class);
		v2_0_0.features.put("WallSurface", WallSurface.class);
		v2_0_0.features.put("FloorSurface", FloorSurface.class);
		v2_0_0.features.put("CeilingSurface", CeilingSurface.class);
		v2_0_0.features.put("GroundSurface", GroundSurface.class);
		v2_0_0.features.put("Window", Window.class);
		v2_0_0.features.put("Door", Door.class);
		v2_0_0.features.put("_AbstractBuilding", AbstractBuilding.class);
		v2_0_0.features.put("_BoundarySurface", AbstractBoundarySurface.class);
		v2_0_0.features.put("_Opening", AbstractOpening.class);		
		v1_0_0.features = v2_0_0.features;
		
		v2_0_0.features.put("OuterFloorSurface", OuterFloorSurface.class);
		v2_0_0.features.put("OuterCeilingSurface", OuterCeilingSurface.class);
		
		v2_0_0.featureProperties = new HashSet<String>();
		v2_0_0.featureProperties.add("address");
		v2_0_0.featureProperties.add("boundedBy");
		v2_0_0.featureProperties.add("opening");
		v2_0_0.featureProperties.add("outerBuildingInstallation");
		v2_0_0.featureProperties.add("interiorBuildingInstallation");
		v2_0_0.featureProperties.add("interiorRoom");
		v2_0_0.featureProperties.add("consistsOfBuildingPart");
		v2_0_0.featureProperties.add("interiorFurniture");
		v2_0_0.featureProperties.add("roomInstallation");
		v1_0_0.featureProperties = v2_0_0.featureProperties;
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
		default:
			return null;
		}
	}
	
	@Override
	public boolean isTopLevelFeature(String name) {
		return "Building".equals(name);
	}
	
}
