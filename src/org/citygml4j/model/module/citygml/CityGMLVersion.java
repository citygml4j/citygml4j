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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 */
package org.citygml4j.model.module.citygml;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.model.module.AbstractModuleConfiguration;
import org.citygml4j.model.module.Module;
import org.citygml4j.model.module.gml.GMLCoreModule;
import org.citygml4j.model.module.gml.GMLModule;
import org.citygml4j.model.module.gml.XLinkModule;
import org.citygml4j.model.module.xal.AbstractXALModule;
import org.citygml4j.model.module.xal.XALCoreModule;

public class CityGMLVersion extends AbstractModuleConfiguration {
	private static final List<CityGMLVersion> instances = new ArrayList<CityGMLVersion>();

	public static final CityGMLVersion DEFAULT;
	public static final CityGMLVersion v2_0_0;
	public static final CityGMLVersion v1_0_0;

	private CityGMLVersion(Module... modules) {
		super(modules);
		instances.add(this);
	}

	static {		
		v2_0_0 = new CityGMLVersion(
				AppearanceModule.v2_0_0,
				BridgeModule.v2_0_0,
				BuildingModule.v2_0_0,
				CityFurnitureModule.v2_0_0,
				CityObjectGroupModule.v2_0_0,
				CoreModule.v2_0_0,
				GenericsModule.v2_0_0,
				LandUseModule.v2_0_0,
				ReliefModule.v2_0_0,
				TexturedSurfaceModule.v2_0_0,
				TransportationModule.v2_0_0,
				TunnelModule.v2_0_0,
				VegetationModule.v2_0_0,
				WaterBodyModule.v2_0_0,
				GMLCoreModule.v3_1_1,
				XLinkModule.v3_1_1,
				XALCoreModule.v2_0				
		);
		
		v1_0_0 = new CityGMLVersion(
				AppearanceModule.v1_0_0,
				BuildingModule.v1_0_0,
				CityFurnitureModule.v1_0_0,
				CityObjectGroupModule.v1_0_0,
				CoreModule.v1_0_0,
				GenericsModule.v1_0_0,
				LandUseModule.v1_0_0,
				ReliefModule.v1_0_0,
				TexturedSurfaceModule.v1_0_0,
				TransportationModule.v1_0_0,
				VegetationModule.v1_0_0,
				WaterBodyModule.v1_0_0,
				GMLCoreModule.v3_1_1,
				XLinkModule.v3_1_1,
				XALCoreModule.v2_0				
		);
		
		DEFAULT = v2_0_0;
	}

	public List<CityGMLModule> getCityGMLModules() {
		List<CityGMLModule> citygml = new ArrayList<CityGMLModule>();
		for (Module module : modules)
			if (module instanceof CityGMLModule)
				citygml.add((CityGMLModule)module);

		return citygml;
	}

	public List<GMLModule> getGMLModules() {
		List<GMLModule> gml = new ArrayList<GMLModule>();
		for (Module module : modules)
			if (module instanceof GMLModule)
				gml.add((GMLModule)module);

		return gml;
	}

	public List<AbstractXALModule> getXALModules() {
		List<AbstractXALModule> xal = new ArrayList<AbstractXALModule>();
		for (Module module : modules)
			if (module instanceof AbstractXALModule)
				xal.add((AbstractXALModule)module);

		return xal;
	}

	public static List<CityGMLVersion> getInstances() {
		return instances;
	}
	
	@Override
	public String toString() {
		if (this == v2_0_0)
			return "2.0.0";
		else if (this == v1_0_0)
			return "1.0.0";
		else
			return super.toString();
	}

}
