package org.citygml4j.builder.jaxb;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.citygml4j.model.module.Module;
import org.citygml4j.model.module.ModuleContext;
import org.citygml4j.model.module.citygml.AppearanceModule;
import org.citygml4j.model.module.citygml.BuildingModule;
import org.citygml4j.model.module.citygml.CityFurnitureModule;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.model.module.citygml.CityObjectGroupModule;
import org.citygml4j.model.module.citygml.CoreModule;
import org.citygml4j.model.module.citygml.GenericsModule;
import org.citygml4j.model.module.citygml.LandUseModule;
import org.citygml4j.model.module.citygml.ReliefModule;
import org.citygml4j.model.module.citygml.TexturedSurfaceModule;
import org.citygml4j.model.module.citygml.TransportationModule;
import org.citygml4j.model.module.citygml.VegetationModule;
import org.citygml4j.model.module.citygml.WaterBodyModule;
import org.citygml4j.model.module.gml.GMLCoreModule;
import org.citygml4j.model.module.xal.XALCoreModule;

public class JAXBContextPath {
	static HashMap<Module, String> contextPathMap;

	static {
		contextPathMap = new HashMap<Module, String>();

		contextPathMap.put(CoreModule.v0_4_0, "org.citygml4j.jaxb.citygml._0_4");
		contextPathMap.put(CoreModule.v1_0_0, "org.citygml4j.jaxb.citygml.core._1");
		contextPathMap.put(AppearanceModule.v1_0_0, "org.citygml4j.jaxb.citygml.app._1");
		contextPathMap.put(BuildingModule.v1_0_0, "org.citygml4j.jaxb.citygml.bldg._1");
		contextPathMap.put(CityFurnitureModule.v1_0_0, "org.citygml4j.jaxb.citygml.frn._1");
		contextPathMap.put(CityObjectGroupModule.v1_0_0, "org.citygml4j.jaxb.citygml.grp._1");
		contextPathMap.put(GenericsModule.v1_0_0, "org.citygml4j.jaxb.citygml.gen._1");
		contextPathMap.put(LandUseModule.v1_0_0, "org.citygml4j.jaxb.citygml.luse._1");
		contextPathMap.put(ReliefModule.v1_0_0, "org.citygml4j.jaxb.citygml.dem._1");
		contextPathMap.put(TexturedSurfaceModule.v1_0_0, "org.citygml4j.jaxb.citygml.tex._1");
		contextPathMap.put(TransportationModule.v1_0_0, "org.citygml4j.jaxb.citygml.tran._1");
		contextPathMap.put(VegetationModule.v1_0_0, "org.citygml4j.jaxb.citygml.veg._1");
		contextPathMap.put(WaterBodyModule.v1_0_0, "org.citygml4j.jaxb.citygml.wtr._1");
		contextPathMap.put(GMLCoreModule.v3_1_1, "org.citygml4j.jaxb.gml._3_1_1");
		contextPathMap.put(XALCoreModule.v2_0, "org.citygml4j.jaxb.xal");
	}
	
	public static String getContextPath() {
		HashSet<String> contextPaths = new HashSet<String>();

		for (Module module : contextPathMap.keySet()) {
			String contextPath = contextPathMap.get(module);
			if (contextPath != null)
				contextPaths.add(contextPath);
		}

		return createContextPath(contextPaths);
	}
	
	public static String getContextPath(String... packageNames) {
		StringBuilder builder = new StringBuilder(getContextPath());
		
		for (String contextPath : packageNames) {
			builder.append(":");
			builder.append(contextPath);
		}
		
		return builder.toString();	
	}
	
	public static String getContextPath(List<Module> modules) {
		HashSet<String> contextPaths = new HashSet<String>();

		for (Module module : modules) {
			String contextPath = contextPathMap.get(module);
			if (contextPath != null)
				contextPaths.add(contextPath);
		}

		return createContextPath(contextPaths);
	}
	
	public static String getContextPath(List<Module> modules, String... packageNames) {
		StringBuilder builder = new StringBuilder(getContextPath(modules));
		
		for (String contextPath : packageNames) {
			builder.append(":");
			builder.append(contextPath);
		}
		
		return builder.toString();
	}
	
	public static String getContextPath(CityGMLVersion version) {
		return getContextPath(version.getModules());
	}
	
	public static String getContextPath(CityGMLVersion version, String... packageNames) {
		return getContextPath(version.getModules(), packageNames);
	}
	
	public static String getContextPath(ModuleContext moduleContext) {
		return getContextPath(moduleContext.getModules());
	}
	
	public static String getContextPath(ModuleContext moduleContext, String... packageNames) {
		return getContextPath(moduleContext.getModules(), packageNames);
	}

	public static String getContextPath(Module... modules) {
		return getContextPath(modules);
	}

	private static String createContextPath(HashSet<String> contextPaths) {
		StringBuilder builder = new StringBuilder();
		int counter = 0;
		int size = contextPaths.size();

		for (String contextPath : contextPaths) {
			builder.append(contextPath);
			if (++counter < size)
				builder.append(":");
		}

		return builder.toString();
	}
}
