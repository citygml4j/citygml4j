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
package org.citygml4j.model.module.xal;

import org.citygml4j.model.module.Module;

import java.util.ArrayList;
import java.util.List;

public class XALCoreModule extends AbstractXALModule {	
	private static final List<XALCoreModule> instances = new ArrayList<XALCoreModule>();

	public static final XALCoreModule v2_0;

	public XALCoreModule (
			XALModuleType type,
			XALModuleVersion version,
			String namespaceURI, 
			String namespacePrefix, 
			String schemaLocation,
			Module... dependencies) {
		super(type, version, namespaceURI, namespacePrefix, schemaLocation, dependencies);
		instances.add(this);
	}

	static {
		v2_0 = new XALCoreModule (
				XALModuleType.CORE,
				XALModuleVersion.v2_0,
				"urn:oasis:names:tc:ciq:xsdschema:xAL:2.0", 
				"xAL", 
				"http://schemas.opengis.net/citygml/xAL/xAL.xsd");
	}

	public static List<XALCoreModule> getInstances() {
		return instances;
	}
	
	public static XALCoreModule getInstance(XALModuleVersion version) {
		switch (version) {
		case v2_0:
			return v2_0;
		default:
			return null;
		}
	}
	
}
