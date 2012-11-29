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
package org.citygml4j.model.module.gml;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.model.module.Module;

public class GMLCoreModule extends AbstractGMLModule {	
	private static final List<GMLCoreModule> instances = new ArrayList<GMLCoreModule>();
	
	public static final GMLCoreModule v3_1_1;
	
	public GMLCoreModule (
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
		v3_1_1 = new GMLCoreModule (
				GMLModuleType.CORE,
				GMLModuleVersion.v3_1_1,
				"http://www.opengis.net/gml", 
				"gml", 
				"http://schemas.opengis.net/gml/3.1.1/base/gml.xsd");
	}

	public static List<GMLCoreModule> getInstances() {
		return instances;
	}
	
	public static GMLCoreModule getInstance(GMLModuleVersion version) {
		switch (version) {
		case v3_1_1:
			return v3_1_1;
		default:
			return null;
		}
	}
	
}
