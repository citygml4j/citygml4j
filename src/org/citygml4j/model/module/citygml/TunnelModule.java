/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2012
 * Institute for Geodesy and Geoinformation Science
 * Technische Universität Berlin, Germany
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
 * 
 * $Id$
 */
package org.citygml4j.model.module.citygml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.tunnel.CeilingSurface;
import org.citygml4j.model.citygml.tunnel.ClosureSurface;
import org.citygml4j.model.citygml.tunnel.Door;
import org.citygml4j.model.citygml.tunnel.FloorSurface;
import org.citygml4j.model.citygml.tunnel.GroundSurface;
import org.citygml4j.model.citygml.tunnel.HollowSpace;
import org.citygml4j.model.citygml.tunnel.IntTunnelInstallation;
import org.citygml4j.model.citygml.tunnel.InteriorWallSurface;
import org.citygml4j.model.citygml.tunnel.OuterCeilingSurface;
import org.citygml4j.model.citygml.tunnel.OuterFloorSurface;
import org.citygml4j.model.citygml.tunnel.RoofSurface;
import org.citygml4j.model.citygml.tunnel.Tunnel;
import org.citygml4j.model.citygml.tunnel.TunnelFurniture;
import org.citygml4j.model.citygml.tunnel.TunnelInstallation;
import org.citygml4j.model.citygml.tunnel.TunnelPart;
import org.citygml4j.model.citygml.tunnel.WallSurface;
import org.citygml4j.model.citygml.tunnel.Window;
import org.citygml4j.model.module.Module;

public class TunnelModule extends AbstractCityGMLModule {
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
		v2_0_0.elementMap.put("Tunnel", Tunnel.class);
		v2_0_0.elementMap.put("TunnelPart", TunnelPart.class);
		v2_0_0.elementMap.put("HollowSpace", HollowSpace.class);
		v2_0_0.elementMap.put("IntTunnelInstallation", IntTunnelInstallation.class);
		v2_0_0.elementMap.put("TunnelInstallation", TunnelInstallation.class);
		v2_0_0.elementMap.put("TunnelFurniture", TunnelFurniture.class);
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
	
	public static TunnelModule getInstance(CityGMLModuleVersion version) {
		switch (version) {
		case v2_0_0:
			return v2_0_0;
		default:
			return null;
		}
	}
	
}
