/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2023 Claus Nagel <claus.nagel@gmail.com>
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
package org.citygml4j.model.module.gml;

import org.citygml4j.model.module.Module;

import java.util.ArrayList;
import java.util.List;

public class XLinkModule extends AbstractGMLModule {
	private static final List<XLinkModule> instances = new ArrayList<XLinkModule>();

	public static final XLinkModule v3_1_1;

	public XLinkModule (
			GMLModuleType type,
			GMLModuleVersion version,
			String namespaceURI, 
			String namespacePrefix, 
			String schemaLocation,
			Module... dependencies) {
		super(type, version, namespaceURI, namespacePrefix, schemaLocation, dependencies);
		instances.add(this);
	}

	static {
		v3_1_1 = new XLinkModule (
				GMLModuleType.XLINK,
				GMLModuleVersion.v3_1_1,
				"http://www.w3.org/1999/xlink", 
				"xlink", 
				"http://schemas.opengis.net/gml/3.1.1/xlink/xlinks.xsd",
				GMLCoreModule.v3_1_1);
	}

	public static List<XLinkModule> getInstances() {
		return instances;
	}
	
	public static XLinkModule getInstance(GMLModuleVersion version) {
		switch (version) {
		case v3_1_1:
			return v3_1_1;
		default:
			return null;
		}
	}
	
}
