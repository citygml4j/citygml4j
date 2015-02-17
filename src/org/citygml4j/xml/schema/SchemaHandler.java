/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright (C) 2013 - 2015,
 * Claus Nagel <claus.nagel@gmail.com>
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
 */
package org.citygml4j.xml.schema;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.citygml4j.model.module.Modules;
import org.citygml4j.model.module.citygml.CityGMLModule;
import org.citygml4j.xml.io.reader.MissingADESchemaException;
import org.w3c.dom.Element;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

import com.sun.xml.xsom.XSSchema;
import com.sun.xml.xsom.XSSchemaSet;
import com.sun.xml.xsom.parser.XSOMParser;

public class SchemaHandler {	
	private static SchemaHandler instance = null;

	private final HashSet<XSSchemaSet> schemaSets;
	private final HashMap<String, String> schemaLocations;
	private final HashMap<String, String> visited;
	private final HashMap<String, Schema> schemas;

	private EntityResolver schemaEntityResolver;
	private ErrorHandler schemaErrorHandler;

	public static synchronized SchemaHandler newInstance() throws SAXException {
		if (instance == null) {
			instance = new SchemaHandler();

			URL schemaURL = SchemaHandler.class.getResource("/schemas/CityGML/citygml4j_profile.xsd");
			if (schemaURL == null)
				throw new SAXException("Failed to parse CityGML schemas. Could not find '/schemas/CityGML/citygml4j_profile.xsd' on classpath.");

			instance.parse(schemaURL.toString());
		}

		SchemaHandler schemaHandler = new SchemaHandler();
		schemaHandler.schemaSets.addAll(instance.schemaSets);
		schemaHandler.visited.putAll(instance.visited);
		
		// CityGML 0.4.0
		schemaHandler.schemaLocations.put("http://www.citygml.org/citygml/1/0/0", SchemaHandler.class.getResource("/schemas/CityGML/0.4.0/CityGML.xsd").toString());

		return schemaHandler;
	}

	private SchemaHandler() {
		// just to thwart instantiation
		schemaSets = new HashSet<XSSchemaSet>();
		schemaLocations = new HashMap<String, String>();
		visited = new HashMap<String, String>();		
		schemas = new HashMap<String, Schema>();
	}

	public void reset() {
		schemaSets.clear();
		schemaLocations.clear();
		visited.clear();
		schemas.clear();

		schemaSets.addAll(instance.schemaSets);
		visited.putAll(instance.visited);
	}

	public Schema getSchema(String namespaceURI) {
		Schema schema = schemas.get(namespaceURI);
		if (schema != null)
			return schema;
		
		// CityGML 0.4.0
		if ("http://www.citygml.org/citygml/1/0/0".equals(namespaceURI)) {
			try {
				parse(schemaLocations.get(namespaceURI));
			} catch (SAXException e) {
				// 
			}
		}

		XSSchemaSet schemaSet = getXSSchemaSet(namespaceURI);
		if (schemaSet != null) {
			schema = new Schema(schemaSet, namespaceURI, this);
			schemas.put(namespaceURI, schema);
		}

		return schema;
	}

	private XSSchemaSet getXSSchemaSet(String namespaceURI) {
		for (XSSchemaSet schemaSet : schemaSets)
			for (XSSchema schema : schemaSet.getSchemas())
				if (schema.getTargetNamespace().equals(namespaceURI))
					return schemaSet;

		return null;
	}

	public EntityResolver getSchemaEntityResolver() {
		return schemaEntityResolver;
	}

	public void setSchemaEntityResolver(EntityResolver schemaEntityResolver) {
		this.schemaEntityResolver = schemaEntityResolver;
	}

	public ErrorHandler getErrorHandler() {
		return schemaErrorHandler;
	}

	public void setErrorHandler(ErrorHandler schemaErrorHandler) {
		this.schemaErrorHandler = schemaErrorHandler;
	}

	public boolean registerSchemaLocation(String namespaceURI, File schemaLocation) {
		if (Modules.getModule(namespaceURI) != null)
			return false;
		
		// CityGML 0.4.0
		if ("http://www.citygml.org/citygml/1/0/0".equals(namespaceURI))
			return false;

		schemaLocations.put(namespaceURI, schemaLocation.toURI().toString());
		return true;
	}

	public void parseSchema(Element element) throws SAXException {
		String schemaLocation = element.getAttributeNS(XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI, "schemaLocation");
		if (schemaLocation.length() == 0)
			schemaLocation = element.getAttribute("schemaLocation");

		if (schemaLocation.length() > 0) {
			String[] split = schemaLocation.trim().split("\\s+");
			if (split.length % 2 == 0)	
				for (int i = 0; i < split.length; i += 2) 
					parseSchema(split[i], split[i+1]);
		}
	}

	public void parseSchema(File schemaLocation) throws SAXException {
		parse(schemaLocation.toURI().toString());
	}

	public void parseSchema(String namespaceURI, String schemaLocation) throws SAXException {
		if (visited.containsKey(namespaceURI))
			return;

		if (schemaLocations.containsKey(namespaceURI))
			schemaLocation = schemaLocations.get(namespaceURI);			

		try {
			parse(schemaLocation);
		} catch (SAXException e) {
			if (schemaEntityResolver != null) {
				InputSource inputSource = null;

				try {
					inputSource = schemaEntityResolver.resolveEntity(namespaceURI, schemaLocation);
					if (inputSource != null)
						parse(inputSource.getSystemId());

				} catch (IOException io) {
					throw new SAXException("Caused by: ", io);
				}				
			} else
				throw e;
		}
	}

	public void resolveAndParseSchema(String namespaceURI) throws SAXException, MissingADESchemaException {
		if (visited.containsKey(namespaceURI))
			return;

		InputSource is = null;

		if (schemaEntityResolver != null) {
			try {
				is = schemaEntityResolver.resolveEntity(namespaceURI, null);				
			} catch (IOException e) {
				throw new SAXException(e);
			}
		}

		if (is == null)
			throw new MissingADESchemaException("Failed to resolve ADE Schema document for target namespace " + namespaceURI);

		parse(is);
	}

	private void parse(String schemaLocation) throws SAXException {
		if (schemaLocation == null)
			return;

		parse(new InputSource(schemaLocation));
	}

	private void parse(InputSource is) throws SAXException {
		if (is == null)
			return;

		XSOMParser parser = new XSOMParser();
		parser.setEntityResolver(new EntityResolver() {

			public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
				InputSource inputSource = null;

				if (publicId != null) {
					for (Entry<String, String> entry : visited.entrySet()) {					
						if (entry.getKey().equals(publicId)) {
							inputSource = new InputSource(entry.getValue());
							inputSource.setPublicId(publicId);
							inputSource.setSystemId(entry.getValue());
							break;
						}
					}
				}

				if (inputSource == null && publicId != null && schemaEntityResolver != null)
					inputSource = schemaEntityResolver.resolveEntity(publicId, systemId);

				return inputSource;
			}

		});

		if (schemaErrorHandler != null)
			parser.setErrorHandler(schemaErrorHandler);

		parser.parse(is);
		XSSchemaSet schemaSet = parser.getResult();

		if (schemaSet != null) {			
			for (XSSchema schema : schemaSet.getSchemas()) {
				Locator locator = schema.getLocator();
				if (locator != null) {
					String systemId = locator.getSystemId();
					String visitedId = visited.get(schema.getTargetNamespace());

					if (visitedId == null)
						visited.put(schema.getTargetNamespace(), systemId);
					else {
						try {
							URL cachedURL = new URL(visitedId);						
							URL offeredURL = new URL(systemId);
							
							if (!(cachedURL.getProtocol().equals("file") || cachedURL.getProtocol().equals("jar")) && 
									(offeredURL.getProtocol().equals("file") || offeredURL.getProtocol().equals("jar")))
								visited.put(schema.getTargetNamespace(), systemId);
							
						} catch (MalformedURLException e) {
							//
						}
					}
				}
			}

			schemaSets.add(schemaSet);
		}
	}

	public Set<String> getTargetNamespaces() {
		return visited.keySet();
	}

	public int size() {
		return visited.size();
	}

	public boolean isEmpty() {
		return visited.isEmpty();
	}

	public Source[] getSchemaSources() {
		Source[] sources = new Source[visited.size()];

		int i = 0;
		for (String systemId : visited.values())
			sources[i++] = new StreamSource(systemId);

		return sources;
	}

	public Source getSchemaSource(Schema schema) {
		String systemId = visited.get(schema.namespaceURI);
		if (systemId != null)
			return new StreamSource(systemId);

		return null;
	}

	public Source getSchemaSource(CityGMLModule module) {
		String systemId = visited.get(module.getNamespaceURI());
		if (systemId != null)
			return new StreamSource(systemId);

		return null;
	}

}
