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

public class BridgeModule extends AbstractConstructionModule {
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
