/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
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

import org.citygml4j.model.module.Module;

import java.util.ArrayList;
import java.util.List;

public class TexturedSurfaceModule extends AbstractCityGMLModule {
	private static final List<TexturedSurfaceModule> instances = new ArrayList<TexturedSurfaceModule>();

	public static final TexturedSurfaceModule v2_0_0;
	public static final TexturedSurfaceModule v1_0_0;

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
		v2_0_0 = new TexturedSurfaceModule (
				CityGMLModuleType.TEXTURED_SURFACE,
				CityGMLModuleVersion.v2_0_0,
				"http://www.opengis.net/citygml/texturedsurface/2.0",
				"tex",
				"http://schemas.opengis.net/citygml/texturedsurface/2.0/texturedSurface.xsd",			
				CoreModule.v2_0_0);
		
		v1_0_0 = new TexturedSurfaceModule (
				CityGMLModuleType.TEXTURED_SURFACE,
				CityGMLModuleVersion.v1_0_0,
				"http://www.opengis.net/citygml/texturedsurface/1.0",
				"tex",
				"http://schemas.opengis.net/citygml/texturedsurface/1.0/texturedSurface.xsd",			
				CoreModule.v1_0_0);
	}

	public static List<TexturedSurfaceModule> getInstances() {
		return instances;
	}
	
	public static TexturedSurfaceModule getInstance(CityGMLModuleVersion version) {
		switch (version) {
		case v2_0_0:
			return v2_0_0;
		case v1_0_0:
			return v1_0_0;
		default:
			return null;
		}
	}

}
