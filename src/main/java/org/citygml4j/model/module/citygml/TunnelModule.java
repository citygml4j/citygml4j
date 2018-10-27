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

import org.citygml4j.model.citygml.tunnel.AbstractBoundarySurface;
import org.citygml4j.model.citygml.tunnel.AbstractOpening;
import org.citygml4j.model.citygml.tunnel.AbstractTunnel;
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
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.module.Module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

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
		
		v2_0_0.features = new HashMap<String, Class<? extends AbstractFeature>>();
		v2_0_0.features.put("Tunnel", Tunnel.class);
		v2_0_0.features.put("TunnelPart", TunnelPart.class);
		v2_0_0.features.put("HollowSpace", HollowSpace.class);
		v2_0_0.features.put("IntTunnelInstallation", IntTunnelInstallation.class);
		v2_0_0.features.put("TunnelInstallation", TunnelInstallation.class);
		v2_0_0.features.put("TunnelFurniture", TunnelFurniture.class);
		v2_0_0.features.put("InteriorWallSurface", InteriorWallSurface.class);
		v2_0_0.features.put("RoofSurface", RoofSurface.class);
		v2_0_0.features.put("ClosureSurface", ClosureSurface.class);
		v2_0_0.features.put("WallSurface", WallSurface.class);
		v2_0_0.features.put("FloorSurface", FloorSurface.class);
		v2_0_0.features.put("CeilingSurface", CeilingSurface.class);
		v2_0_0.features.put("GroundSurface", GroundSurface.class);
		v2_0_0.features.put("OuterFloorSurface", OuterFloorSurface.class);
		v2_0_0.features.put("OuterCeilingSurface", OuterCeilingSurface.class);
		v2_0_0.features.put("Window", Window.class);
		v2_0_0.features.put("Door", Door.class);
		v2_0_0.features.put("_AbstractTunnel", AbstractTunnel.class);
		v2_0_0.features.put("_BoundarySurface", AbstractBoundarySurface.class);
		v2_0_0.features.put("_Opening", AbstractOpening.class);

		v2_0_0.featureProperties = new HashSet<String>();
		v2_0_0.featureProperties.add("boundedBy");
		v2_0_0.featureProperties.add("opening");
		v2_0_0.featureProperties.add("outerTunnelInstallation");
		v2_0_0.featureProperties.add("interiorTunnelInstallation");
		v2_0_0.featureProperties.add("interiorHollowSpace");
		v2_0_0.featureProperties.add("consistsOfTunnelPart");
		v2_0_0.featureProperties.add("interiorFurniture");
		v2_0_0.featureProperties.add("hollowSpaceInstallation");
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
	
	@Override
	public boolean isTopLevelFeature(String name) {
		return "Tunnel".equals(name);
	}
	
}
