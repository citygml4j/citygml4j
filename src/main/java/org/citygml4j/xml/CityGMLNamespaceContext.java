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
package org.citygml4j.xml;

import org.citygml4j.model.module.Module;
import org.citygml4j.model.module.ModuleContext;
import org.citygml4j.model.module.citygml.CityGMLVersion;

import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

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
