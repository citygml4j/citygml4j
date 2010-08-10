package org.citygml4j.model.module.citygml;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.model.module.Module;

public class TexturedSurfaceModule extends AbstractCityGMLModule {
	private static final List<TexturedSurfaceModule> instances = new ArrayList<TexturedSurfaceModule>();

	public static final TexturedSurfaceModule v1_0_0;
	public static final TexturedSurfaceModule v0_4_0;

	private TexturedSurfaceModule (
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
		v1_0_0 = new TexturedSurfaceModule (
				CityGMLModuleType.TEXTURED_SURFACE,
				CityGMLModuleVersion.v1_0_0,
				"http://www.opengis.net/citygml/texturedsurface/1.0",
				"tex",
				"http://schemas.opengis.net/citygml/texturedsurface/1.0/texturedSurface.xsd",			
				CoreModule.v1_0_0);

		v0_4_0 = new TexturedSurfaceModule (
				CityGMLModuleType.TEXTURED_SURFACE,
				CoreModule.v0_4_0.getVersion(),
				CoreModule.v0_4_0.getNamespaceURI(),
				CoreModule.v0_4_0.getNamespacePrefix(),
				CoreModule.v0_4_0.getSchemaLocation(),		
				CoreModule.v0_4_0);
	}

	public static List<TexturedSurfaceModule> getInstances() {
		return instances;
	}

}
