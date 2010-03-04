package org.citygml4j.model.module.citygml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.appearance.Appearance;
import org.citygml4j.model.citygml.appearance.GeoreferencedTexture;
import org.citygml4j.model.citygml.appearance.ParameterizedTexture;
import org.citygml4j.model.citygml.appearance.X3DMaterial;
import org.citygml4j.model.module.Module;

public class AppearanceModule extends AbstractCityGMLModule {
	private static final List<AppearanceModule> instances = new ArrayList<AppearanceModule>();

	public static final AppearanceModule v1_0_0;
	public static final AppearanceModule v0_4_0;

	private AppearanceModule (
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
		v1_0_0 = new AppearanceModule (
				CityGMLModuleType.APPEARANCE,
				CityGMLModuleVersion.v1_0_0,
				"http://www.opengis.net/citygml/appearance/1.0",
				"app",
				"http://schemas.opengis.net/citygml/appearance/1.0/appearance.xsd",		
				CoreModule.v1_0_0);

		v0_4_0 = new AppearanceModule (
				CityGMLModuleType.APPEARANCE,
				CoreModule.v0_4_0.getVersion(),
				CoreModule.v0_4_0.getNamespaceURI(),
				CoreModule.v0_4_0.getNamespacePrefix(),
				CoreModule.v0_4_0.getSchemaLocation(),		
				CoreModule.v0_4_0);
		
		v1_0_0.elementMap = new HashMap<String, Class<? extends CityGML>>();
		v1_0_0.elementMap.put("Appearance", Appearance.class);
		v1_0_0.elementMap.put("ParameterizedTexture", ParameterizedTexture.class);
		v1_0_0.elementMap.put("GeoreferencedTexture", GeoreferencedTexture.class);
		v1_0_0.elementMap.put("X3DMaterial", X3DMaterial.class);
		v0_4_0.elementMap = v1_0_0.elementMap;
		
		v1_0_0.propertySet = new HashSet<String>();
		v1_0_0.propertySet.add("appearance");
		v1_0_0.propertySet.add("appearanceMember");
		v1_0_0.propertySet.add("surfaceDataMember");
		
		v0_4_0.propertySet = new HashSet<String>();
		v0_4_0.propertySet.add("appearanceMember");
		v0_4_0.propertySet.add("surfaceDataMember");
	}

	public static List<AppearanceModule> getInstances() {
		return instances;
	}

}
