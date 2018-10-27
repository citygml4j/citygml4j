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
package org.citygml4j.model.module.gml;

import org.citygml4j.model.module.AbstractModuleConfiguration;
import org.citygml4j.model.module.Module;

import java.util.ArrayList;
import java.util.List;

public class GMLVersion extends AbstractModuleConfiguration {
	private static final List<GMLVersion> instances = new ArrayList<GMLVersion>();

	public static final GMLVersion DEFAULT;
	public static final GMLVersion v3_1_1;

	private GMLVersion(Module... modules) {
		super(modules);
		instances.add(this);
	}

	static {
		v3_1_1 = new GMLVersion(
				GMLCoreModule.v3_1_1,
				XLinkModule.v3_1_1
		);

		DEFAULT = v3_1_1;
	}

	public List<GMLModule> getGMLModules() {
		List<GMLModule> gml = new ArrayList<GMLModule>();
		for (Module module : modules)
			gml.add((GMLModule)module);

		return gml;
	}

}
