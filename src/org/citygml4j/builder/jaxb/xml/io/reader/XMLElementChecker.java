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

import java.util.HashSet;
import java.util.Set;

import javax.xml.namespace.QName;

import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.module.Module;
import org.citygml4j.model.module.Modules;
import org.citygml4j.model.module.citygml.CityGMLModule;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.model.module.citygml.CoreModule;
import org.citygml4j.model.module.gml.GMLCoreModule;
import org.citygml4j.util.xml.saxevents.StartElement;
import org.citygml4j.xml.io.reader.FeatureReadMode;
import org.citygml4j.xml.io.reader.MissingADESchemaException;
import org.citygml4j.xml.schema.ElementDecl;
import org.citygml4j.xml.schema.Schema;
import org.citygml4j.xml.schema.SchemaHandler;
import org.xml.sax.SAXException;

public class XMLElementChecker {
	private final SchemaHandler schemaHandler;
	private final FeatureReadMode featureReadMode;
	private final boolean keepInlineAppearance;
	private final boolean parseSchema;
	private final Set<Class<? extends CityGML>> excludes;

	private final HashSet<String> cityGMLCollectionProperties;

	XMLElementChecker(SchemaHandler schemaHandler, 
			FeatureReadMode featureReadMode, 
			boolean keepInlineAppearance,
			boolean parseSchema,
			Set<Class<? extends CityGML>> exlcudes) {
		this.schemaHandler = schemaHandler;
		this.featureReadMode = featureReadMode;
		this.keepInlineAppearance = keepInlineAppearance;
		this.parseSchema = parseSchema;
		this.excludes = exlcudes;

		cityGMLCollectionProperties = new HashSet<String>();
		cityGMLCollectionProperties.add("cityObjectMember");
		cityGMLCollectionProperties.add("appearanceMember");
		cityGMLCollectionProperties.add("groupMember");
		cityGMLCollectionProperties.add("parent");
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

	public ElementInfo getGMLFeatureProperty(String localName) {
		ElementInfo elementInfo = null;

		if (localName.equals("featureMember")) {
			elementInfo = new ElementInfo();
			elementInfo.isFeatureProperty = true;
			elementInfo.hasXLink = true;

		} else if (localName.equals("featureMembers")) {
			elementInfo = new ElementInfo();
			elementInfo.isFeatureProperty = true;
		}

		return elementInfo;
	}

	public ElementInfo getCityGMLFeatureProperty(QName name, CityGMLChunk currentChunk) {
		ElementInfo elementInfo = null;
		String localName = name.getLocalPart();
		String namespaceURI = name.getNamespaceURI();
		
		boolean isFeatureProperty = false;
		boolean skipNestedElements = false;

		if (featureReadMode == FeatureReadMode.SPLIT_PER_COLLECTION_MEMBER) {
			if (cityGMLCollectionProperties.contains(localName))
				isFeatureProperty = true;

			if (localName.equals("appearanceMember") && 
					namespaceURI.equals(CoreModule.v0_4_0.getNamespaceURI())) {
				StartElement root = currentChunk.getParentStartElement();
				isFeatureProperty = root != null && root.getLocalName().equals("CityModel");
			}
		}

		else {
			Module module = Modules.getModule(namespaceURI);
			if (module instanceof CityGMLModule) {
				CityGMLModule cityGMLModule = (CityGMLModule)module;

				switch (cityGMLModule.getVersion()) {
				case v1_0_0:
					isFeatureProperty = cityGMLModule.hasFeaturePropertyElement(localName);					
					if (localName.equals("appearance"))
						skipNestedElements = keepInlineAppearance;

					break;
				case v0_4_0:
					for (CityGMLModule tmp : CityGMLVersion.v0_4_0.getCityGMLModules()) {
						isFeatureProperty = tmp.hasFeaturePropertyElement(localName);
						if (isFeatureProperty)
							break;
					}

					if (localName.equals("appearanceMember")) {
						StartElement root = currentChunk.getParentStartElement();
						if (root != null && !root.getLocalName().equals("CityModel"))
							skipNestedElements = keepInlineAppearance;
					}

					break;
				}
			}
		}

		if (isFeatureProperty) {
			elementInfo = new ElementInfo();
			elementInfo.isFeatureProperty = true;
			elementInfo.hasXLink = true;
			elementInfo.skipNestedElements = skipNestedElements;
		}

		return elementInfo;
	}

	public ElementInfo getCityGMLFeature(QName name, boolean isSetType) {
		ElementInfo elementInfo = null;
		String localName = name.getLocalPart();
		String namespaceURI = name.getNamespaceURI();

		Module module = Modules.getModule(namespaceURI);
		if (module instanceof CityGMLModule) {
			CityGMLModule cityGMLModule = (CityGMLModule)module;
			Class<? extends CityGML> featureClass = null;

			switch (cityGMLModule.getVersion()) {
			case v1_0_0:
				featureClass = cityGMLModule.getFeatureElementClass(localName);
				break;
			case v0_4_0:
				for (CityGMLModule tmp : CityGMLVersion.v0_4_0.getCityGMLModules()) {
					featureClass = tmp.getFeatureElementClass(localName);
					if (featureClass != null)
						break;
				}

				break;
			}

			if (featureClass != null) {
				elementInfo = new ElementInfo();
				elementInfo.isFeature = true;
				
				if (isSetType)
					elementInfo.type = CityGMLClass.fromInterface(featureClass);

				if (!excludes.isEmpty()) { 
					for (Class<? extends CityGML> exclude : excludes) {
						if (isSubclass(featureClass, exclude)) {
							elementInfo.isFeature = false;
							break;
						}
					}
				}				
			}

		}

		return elementInfo;
	}

	public ElementInfo getADEElementInfo(QName name, ElementInfo lastElementInfo, boolean checkForFeature, boolean isSetType) throws MissingADESchemaException {
		ElementInfo elementInfo = null;
		String localName = name.getLocalPart();
		String namespaceURI = name.getNamespaceURI();
		
		Schema schema = schemaHandler.getSchema(namespaceURI);

		// try and resolve unknown ADE schema
		if (schema == null && parseSchema) {
			try {
				schemaHandler.resolveAndParseSchema(namespaceURI);
				schema = schemaHandler.getSchema(namespaceURI);
			} catch (SAXException e) {
				//
			}
		}

		if (schema != null) {
			ElementDecl parent = lastElementInfo != null ? lastElementInfo.elementDecl : null;
			ElementDecl elementDecl = schema.getElementDecl(localName, parent);

			if (elementDecl != null) {
				elementInfo = new ElementInfo(elementDecl);

				if (checkForFeature && elementDecl.isFeature()) {
					elementInfo.isFeature = true;

					if (isSetType)
						elementInfo.type = CityGMLClass.ADE_COMPONENT;
					
					if (!excludes.isEmpty()) { 
						for (Class<? extends CityGML> exclude : excludes) {
							if (isSubclass(ADEComponent.class, exclude)) {
								elementInfo.isFeature = false;
								break;
							}
						}
					}

				} else if (elementDecl.hasXLinkAttribute()) {
					elementInfo.isFeatureProperty = true;
					elementInfo.hasXLink = true;
				}
			}
		}

		return elementInfo;
	}

	public ElementInfo getElementInfo(QName name, CityGMLChunk currentChunk, ElementInfo lastElementInfo, boolean isSetType) throws MissingADESchemaException {
		if (lastElementInfo != null && lastElementInfo.skipNestedElements)
			return lastElementInfo;

		ElementInfo elementInfo = null;

		if (lastElementInfo != null && lastElementInfo.isFeatureProperty) {
			if (isGMLElement(name))
				; // we do not support GML features
			else if (isCityGMLElement(name))
				elementInfo = getCityGMLFeature(name, isSetType);
			else
				elementInfo = getADEElementInfo(name, lastElementInfo, true, isSetType);
		}

		else {
			if (isGMLElement(name))
				elementInfo = getGMLFeatureProperty(name.getLocalPart());
			else if (isCityGMLElement(name))
				elementInfo = getCityGMLFeatureProperty(name, currentChunk);
			else if (featureReadMode == FeatureReadMode.SPLIT_PER_FEATURE)
				elementInfo = getADEElementInfo(name, lastElementInfo, false, false);
		}

		return elementInfo;
	}

	private boolean isSubclass(Class<?> a, Class<?> b) {
		if (a == null || b == null)
			return false;

		if (a == b)
			return true;

		for (Class<?> tmp : a.getInterfaces())
			if (isSubclass(tmp, b))
				return true;

		return false;
	}

	static class ElementInfo {
		private final ElementDecl elementDecl;

		private boolean isFeature = false;
		private boolean isFeatureProperty = false;
		private boolean hasXLink = false;
		private boolean skipNestedElements = false;
		private CityGMLClass type = CityGMLClass.UNDEFINED;

		ElementInfo() {
			elementDecl = null;
		}

		ElementInfo(ElementDecl decl) {
			this.elementDecl = decl;
		}

		boolean isFeature() {
			return isFeature;
		}

		boolean hasXLink() {
			return hasXLink;
		}
		
		CityGMLClass getType() {
			return type;
		}

	}

}
