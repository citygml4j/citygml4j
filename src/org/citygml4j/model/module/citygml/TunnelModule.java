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
import org.citygml4j.model.citygml.building.RoofSurface;
import org.citygml4j.model.citygml.building.Room;
import org.citygml4j.model.citygml.building.WallSurface;
import org.citygml4j.model.citygml.building.Window;
import org.citygml4j.model.module.Module;

public class TunnelModule extends AbstractConstructionModule {
	private static final List<TunnelModule> instances = new ArrayList<TunnelModule>();

	public static final TunnelModule v2_0_0;

	private TunnelModule (
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
		v2_0_0 = new TunnelModule (
				CityGMLModuleType.TUNNEL,
				CityGMLModuleVersion.v2_0_0,
				"http://www.opengis.net/citygml/tunnel/2.0",
				"tun",
				"http://schemas.opengis.net/citygml/tunnel/2.0/tunnel.xsd",			
				CoreModule.v2_0_0);
		
		v2_0_0.elementMap = new HashMap<String, Class<? extends CityGML>>();
		v2_0_0.elementMap.put("Tunnel", Building.class);
		v2_0_0.elementMap.put("TunnelPart", BuildingPart.class);
		v2_0_0.elementMap.put("HollowSpace", Room.class);
		v2_0_0.elementMap.put("IntTunnelInstallation", IntBuildingInstallation.class);
		v2_0_0.elementMap.put("TunnelInstallation", BuildingInstallation.class);
		v2_0_0.elementMap.put("TunnelFurniture", BuildingFurniture.class);
		v2_0_0.elementMap.put("InteriorWallSurface", InteriorWallSurface.class);
		v2_0_0.elementMap.put("RoofSurface", RoofSurface.class);
		v2_0_0.elementMap.put("ClosureSurface", ClosureSurface.class);
		v2_0_0.elementMap.put("WallSurface", WallSurface.class);
		v2_0_0.elementMap.put("FloorSurface", FloorSurface.class);
		v2_0_0.elementMap.put("CeilingSurface", CeilingSurface.class);
		v2_0_0.elementMap.put("GroundSurface", GroundSurface.class);
		v2_0_0.elementMap.put("Window", Window.class);
		v2_0_0.elementMap.put("Door", Door.class);
		
		v2_0_0.propertySet = new HashSet<String>();
		v2_0_0.propertySet.add("boundedBy");
		v2_0_0.propertySet.add("opening");
		v2_0_0.propertySet.add("outerTunnelInstallation");
		v2_0_0.propertySet.add("interiorTunnelInstallation");
		v2_0_0.propertySet.add("interiorHollowSpace");
		v2_0_0.propertySet.add("consistsOfTunnelPart");
		v2_0_0.propertySet.add("interiorFurniture");
		v2_0_0.propertySet.add("hollowSpaceInstallation");
	}
	
	public static List<TunnelModule> getInstances() {
		return instances;
	}
}
