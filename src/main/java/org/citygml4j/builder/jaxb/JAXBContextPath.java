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
package org.citygml4j.builder.jaxb;

import org.citygml4j.CityGMLContext;
import org.citygml4j.model.citygml.ade.binding.ADEContext;

import java.util.Arrays;
import java.util.Collection;
import java.util.StringJoiner;

public class JAXBContextPath {

	public static String getContextPath() {
		return buildContextPath().toString();
	}

	public static String getContextPath(Collection<String> packageNames) {
		StringJoiner joiner = buildContextPath();

		if (packageNames != null) {
			for (String contextPath : packageNames)
				joiner.add(contextPath);
		}

		return joiner.toString();
	}

	public static String getContextPath(String... packageNames) {
		return getContextPath(Arrays.asList(packageNames));
	}

	private static StringJoiner buildContextPath() {
		StringJoiner joiner = new StringJoiner(":");

		// CityGML 2.0
		joiner.add("net.opengis.citygml._2");
		joiner.add("net.opengis.citygml.appearance._2");
		joiner.add("net.opengis.citygml.bridge._2");
		joiner.add("net.opengis.citygml.building._2");
		joiner.add("net.opengis.citygml.cityfurniture._2");
		joiner.add("net.opengis.citygml.cityobjectgroup._2");
		joiner.add("net.opengis.citygml.generics._2");
		joiner.add("net.opengis.citygml.landuse._2");
		joiner.add("net.opengis.citygml.relief._2");
		joiner.add("net.opengis.citygml.texturedsurface._2");
		joiner.add("net.opengis.citygml.transportation._2");
		joiner.add("net.opengis.citygml.tunnel._2");
		joiner.add("net.opengis.citygml.vegetation._2");
		joiner.add("net.opengis.citygml.waterbody._2");

		// CityGML 1.0
		joiner.add("net.opengis.citygml._1");
		joiner.add("net.opengis.citygml.appearance._1");
		joiner.add("net.opengis.citygml.building._1");
		joiner.add("net.opengis.citygml.cityfurniture._1");
		joiner.add("net.opengis.citygml.cityobjectgroup._1");
		joiner.add("net.opengis.citygml.generics._1");
		joiner.add("net.opengis.citygml.landuse._1");
		joiner.add("net.opengis.citygml.relief._1");
		joiner.add("net.opengis.citygml.texturedsurface._1");
		joiner.add("net.opengis.citygml.transportation._1");
		joiner.add("net.opengis.citygml.vegetation._1");
		joiner.add("net.opengis.citygml.waterbody._1");

		// GML 3.1.1 and xAL 2.0
		joiner.add("net.opengis.gml");
		joiner.add("oasis.names.tc.ciq.xsdschema.xal._2");

		// ADE context paths
		CityGMLContext context = CityGMLContext.getInstance();
		if (context.hasADEContexts()) {
			for (ADEContext adeContext : CityGMLContext.getInstance().getADEContexts()) {
				for (String contextPath : adeContext.getJAXBPackageNames())
					joiner.add(contextPath);
			}
		}

		return joiner;
	}
}
