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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 * 
 * $Id: CityGMLNamespaceContext.java 542 2012-11-29 20:56:44Z nagel $
 */
package org.citygml4j.xml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;

import org.citygml4j.model.module.Module;
import org.citygml4j.model.module.ModuleContext;
import org.citygml4j.model.module.citygml.CityGMLVersion;

public class CityGMLNamespaceContext implements NamespaceContext {
	private HashMap<String, String> namespaces;

	public CityGMLNamespaceContext() {
		namespaces = new HashMap<String, String>();
	}

	public void setPrefix(String prefix, String uri) {
		if (prefix == null)
			throw new IllegalArgumentException("namespace prefix may not be null.");

		if (uri == null)
			throw new IllegalArgumentException("namespace URI may not be null.");

		Iterator<Entry<String, String>> iter = namespaces.entrySet().iterator();
		while (iter.hasNext()) {
			Entry<String, String> entry = iter.next();
			if (entry.getValue().equals(prefix)) {
				iter.remove();
				break;
			}				
		}

		namespaces.put(uri, prefix);
	}

	public void setDefaultNamespace(String namespaceURI) {
		if (namespaceURI == null)
			throw new IllegalArgumentException("namespace URI may not be null.");

		if (!namespaceURI.equals(XMLConstants.NULL_NS_URI))
			setPrefix(XMLConstants.DEFAULT_NS_PREFIX, namespaceURI);
	}

	public String getPrefix(String namespaceURI) {
		if (namespaceURI == null)
			throw new IllegalArgumentException("namespace URI may not be null.");

		if (namespaceURI.equals(XMLConstants.NULL_NS_URI))
			return XMLConstants.DEFAULT_NS_PREFIX;
		
		if (namespaceURI.equals(XMLConstants.XML_NS_URI))
			return XMLConstants.XML_NS_PREFIX;
		
		if (namespaceURI.equals(XMLConstants.XMLNS_ATTRIBUTE_NS_URI))
			return XMLConstants.XMLNS_ATTRIBUTE;
		
		return namespaces.get(namespaceURI);
	}

	public String getNamespaceURI(String prefix) {
		if (prefix == null)
			throw new IllegalArgumentException("namespace prefix may not be null.");

		if (prefix.equals(XMLConstants.DEFAULT_NS_PREFIX)) {
			String tmp = namespaces.get(prefix);
			if (tmp != null)
				return tmp;
		}

		if (prefix.equals(XMLConstants.XML_NS_PREFIX))
			return XMLConstants.XML_NS_URI;

		if (prefix.equals(XMLConstants.XMLNS_ATTRIBUTE))
			return XMLConstants.XMLNS_ATTRIBUTE_NS_URI;

		Iterator<Entry<String, String>> iter = namespaces.entrySet().iterator();
		while (iter.hasNext()) {
			Entry<String, String> entry = iter.next();
			if (entry.getValue().equals(prefix))
				return entry.getKey();
		}

		return XMLConstants.NULL_NS_URI;
	}

	public Iterator<String> getPrefixes() {
		return namespaces.values().iterator();
	}

	public Iterator<String> getNamespaceURIs() {
		return namespaces.keySet().iterator();
	}
	
	public Iterator<String> getPrefixes(String namespaceURI) {
		if (namespaceURI == null)
			throw new IllegalArgumentException("namespace URI may not be null.");
				
		if (namespaceURI.equals(XMLConstants.XML_NS_URI)) {
			List<String> prefixes = new ArrayList<String>();
			prefixes.add(XMLConstants.XML_NS_PREFIX);
			return prefixes.iterator();
		}
		
		if (namespaceURI.equals(XMLConstants.XMLNS_ATTRIBUTE_NS_URI)) {
			List<String> prefixes = new ArrayList<String>();
			prefixes.add(XMLConstants.XMLNS_ATTRIBUTE);
			return prefixes.iterator();
		}
		
		return namespaces.values().iterator();
	}

	public void reset() {
		namespaces.clear();
	}

	public boolean isEmpty() {
		return namespaces.isEmpty();
	}

	public void setDefaultNamespace(Module module) {
		setDefaultNamespace(module.getNamespaceURI());
	}

	public void setPrefix(Module module) {
		setPrefix(module.getNamespacePrefix(), module.getNamespaceURI());
	}

	public void setPrefixes(CityGMLVersion version) {
		for (Module module : version.getModules())
			setPrefix(module);
	}

	public void setPrefixes(ModuleContext moduleContext) {
		for (Module module : moduleContext.getModules())
			setPrefix(module);
	}

}
