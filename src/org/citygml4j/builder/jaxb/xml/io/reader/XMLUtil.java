/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universitaet Berlin, Germany
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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 */
package org.citygml4j.builder.jaxb.xml.io.reader;

import javax.xml.namespace.QName;

import org.citygml4j.model.module.Module;
import org.citygml4j.model.module.Modules;
import org.citygml4j.model.module.citygml.CityGMLModule;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.model.module.citygml.CoreModule;
import org.citygml4j.model.module.gml.GMLCoreModule;

public class XMLUtil {
	private static XMLUtil instance;

	public synchronized static XMLUtil getInstance() {
		if (instance == null)
			instance = new XMLUtil();

		return instance;
	}

	private XMLUtil() {
		// just to thwart instantiation
	}

	public boolean isCityGMLElement(String namespaceURI) {
		return (namespaceURI.startsWith("http://www.opengis.net/citygml") ||
				CoreModule.v0_4_0.getNamespaceURI().equals(namespaceURI));
	}

	public boolean isCityGMLElement(QName name) {
		return isCityGMLElement(name.getNamespaceURI());
	}

	public boolean isGMLElement(String namespaceURI) {
		return GMLCoreModule.v3_1_1.getNamespaceURI().equals(namespaceURI);
	}

	public boolean isGMLElement(QName name) {
		return isGMLElement(name.getNamespaceURI());
	}

	public boolean isParentInfoElement(String namespaceURI, String localPart) {
		if (isGMLElement(namespaceURI)) {
			if (localPart.equals("metaDataProperty") ||
					localPart.equals("description") ||
					localPart.equals("name") ||
					localPart.equals("boundedBy") ||
					localPart.equals("location"))
				return true;					
		} else if (isCityGMLElement(namespaceURI)) {
			if (localPart.equals("appearance") ||
					localPart.equals("appearanceMember"))
				return true;
		}

		return false;
	}

	public boolean isParentInfoElement(QName name) {
		return isParentInfoElement(name.getNamespaceURI(), name.getLocalPart());
	}
	
	public boolean isCityGMLFeature(String localName, String namespaceURI) {
		boolean isFeature = false;

		Module module = Modules.getModule(namespaceURI);
		if (module instanceof CityGMLModule) {
			CityGMLModule cityGMLModule = (CityGMLModule)module;

			switch (cityGMLModule.getVersion()) {
			case v1_0_0:
				isFeature = cityGMLModule.hasFeatureElement(localName);
				break;
			case v0_4_0:
				for (CityGMLModule tmp : CityGMLVersion.v0_4_0.getCityGMLModules()) {
					isFeature = tmp.hasFeatureElement(localName);
					if (isFeature)
						break;
				}

				break;
			}
		}

		return isFeature;
	}
}
