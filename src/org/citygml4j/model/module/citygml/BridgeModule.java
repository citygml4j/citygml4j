/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright 2013-2016 Claus Nagel <claus.nagel@gmail.com>
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.bridge.Bridge;
import org.citygml4j.model.citygml.bridge.BridgeConstructionElement;
import org.citygml4j.model.citygml.bridge.BridgeFurniture;
import org.citygml4j.model.citygml.bridge.BridgeInstallation;
import org.citygml4j.model.citygml.bridge.BridgePart;
import org.citygml4j.model.citygml.bridge.BridgeRoom;
import org.citygml4j.model.citygml.bridge.CeilingSurface;
import org.citygml4j.model.citygml.bridge.ClosureSurface;
import org.citygml4j.model.citygml.bridge.Door;
import org.citygml4j.model.citygml.bridge.FloorSurface;
import org.citygml4j.model.citygml.bridge.GroundSurface;
import org.citygml4j.model.citygml.bridge.IntBridgeInstallation;
import org.citygml4j.model.citygml.bridge.InteriorWallSurface;
import org.citygml4j.model.citygml.bridge.OuterCeilingSurface;
import org.citygml4j.model.citygml.bridge.OuterFloorSurface;
import org.citygml4j.model.citygml.bridge.RoofSurface;
import org.citygml4j.model.citygml.bridge.WallSurface;
import org.citygml4j.model.citygml.bridge.Window;
import org.citygml4j.model.module.Module;

public class BridgeModule extends AbstractCityGMLModule {
	private static final List<BridgeModule> instances = new ArrayList<BridgeModule>();

	public static final BridgeModule v2_0_0;

	private BridgeModule (
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
		v2_0_0 = new BridgeModule (
				CityGMLModuleType.BRIDGE,
				CityGMLModuleVersion.v2_0_0,
				"http://www.opengis.net/citygml/bridge/2.0",
				"brid",
				"http://schemas.opengis.net/citygml/bridge/2.0/bridge.xsd",			
				CoreModule.v2_0_0);

		v2_0_0.elementMap = new HashMap<String, Class<? extends CityGML>>();
		v2_0_0.elementMap.put("Bridge", Bridge.class);
		v2_0_0.elementMap.put("BridgePart", BridgePart.class);
		v2_0_0.elementMap.put("BridgeRoom", BridgeRoom.class);
		v2_0_0.elementMap.put("IntBridgeInstallation", IntBridgeInstallation.class);
		v2_0_0.elementMap.put("BridgeInstallation", BridgeInstallation.class);
		v2_0_0.elementMap.put("BridgeConstructionElement", BridgeConstructionElement.class);
		v2_0_0.elementMap.put("BridgeFurniture", BridgeFurniture.class);
		v2_0_0.elementMap.put("InteriorWallSurface", InteriorWallSurface.class);
		v2_0_0.elementMap.put("RoofSurface", RoofSurface.class);
		v2_0_0.elementMap.put("ClosureSurface", ClosureSurface.class);
		v2_0_0.elementMap.put("WallSurface", WallSurface.class);
		v2_0_0.elementMap.put("FloorSurface", FloorSurface.class);
		v2_0_0.elementMap.put("CeilingSurface", CeilingSurface.class);
		v2_0_0.elementMap.put("GroundSurface", GroundSurface.class);
		v2_0_0.elementMap.put("OuterFloorSurface", OuterFloorSurface.class);
		v2_0_0.elementMap.put("OuterCeilingSurface", OuterCeilingSurface.class);
		v2_0_0.elementMap.put("Window", Window.class);
		v2_0_0.elementMap.put("Door", Door.class);

		v2_0_0.propertySet = new HashSet<String>();
		v2_0_0.propertySet.add("address");
		v2_0_0.propertySet.add("boundedBy");
		v2_0_0.propertySet.add("opening");
		v2_0_0.propertySet.add("outerBridgeConstruction");
		v2_0_0.propertySet.add("outerBridgeInstallation");
		v2_0_0.propertySet.add("interiorBridgeInstallation");
		v2_0_0.propertySet.add("interiorBridgeRoom");
		v2_0_0.propertySet.add("consistsOfBridgePart");
		v2_0_0.propertySet.add("interiorFurniture");
		v2_0_0.propertySet.add("bridgeRoomInstallation");
	}

	public static List<BridgeModule> getInstances() {
		return instances;
	}
	
	public static BridgeModule getInstance(CityGMLModuleVersion version) {
		switch (version) {
		case v2_0_0:
			return v2_0_0;
		default:
			return null;
		}
	}
	
}
