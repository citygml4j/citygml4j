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
package org.citygml4j.builder.jaxb.marshal;

import java.util.HashMap;

import javax.xml.XMLConstants;

import org.citygml4j.model.module.Module;
import org.citygml4j.model.module.ModuleContext;
import org.citygml4j.model.module.citygml.CityGMLVersion;

import com.sun.xml.bind.marshaller.NamespacePrefixMapper;

public class JAXBNamespacePrefixMapper extends NamespacePrefixMapper {
	private HashMap<String, String> prefixMap;

	JAXBNamespacePrefixMapper() {
		prefixMap = new HashMap<String, String>();
		
		prefixMap.put("http://www.w3.org/2001/SMIL20/", "smil20");
		prefixMap.put("http://www.w3.org/2001/SMIL20/Language", "smil20lang");
		prefixMap.put(XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI, "xsi");
		prefixMap.put(XMLConstants.XML_NS_URI, XMLConstants.XML_NS_PREFIX);
	}
	
	public JAXBNamespacePrefixMapper(CityGMLVersion version) {
		this();
		setNamespacePrefixMapping(version);
	}
	
	public JAXBNamespacePrefixMapper(ModuleContext moduleContext) {
		this();
		setNamespacePrefixMapping(moduleContext);
	}
		
	public void setNamespacePrefixMapping(String uri, String prefix) {
		prefixMap.put(uri, prefix);
	}
	
	public void setNamespacePrefixMapping(CityGMLVersion version) {
		for (Module module : version.getModules())
			setNamespacePrefixMapping(module.getNamespaceURI(), module.getNamespacePrefix());
	}
	
	public void setNamespacePrefixMapping(ModuleContext moduleContext) {
		for (Module module : moduleContext.getModules())
			setNamespacePrefixMapping(module.getNamespaceURI(), module.getNamespacePrefix());
	}

	public String getNamespacePrefixMapping(String uri) {
		return prefixMap.get(uri);
	}

	@Override
	public String getPreferredPrefix(String uri, String suggestion, boolean requirePrefix) {
		String prefix = prefixMap.get(uri);
		if (prefix != null)
			return prefix;

		return suggestion;
	}
}
