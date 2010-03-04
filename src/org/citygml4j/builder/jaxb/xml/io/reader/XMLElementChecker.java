package org.citygml4j.builder.jaxb.xml.io.reader;

import java.util.HashSet;
import java.util.Set;

import javax.xml.namespace.QName;

import org.citygml4j.builder.jaxb.xml.io.reader.saxevents.StartElement;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.module.Module;
import org.citygml4j.model.module.Modules;
import org.citygml4j.model.module.citygml.CityGMLModule;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.model.module.citygml.CoreModule;
import org.citygml4j.xml.io.reader.FeatureReadMode;
import org.citygml4j.xml.schema.ElementDecl;
import org.citygml4j.xml.schema.Schema;
import org.citygml4j.xml.schema.SchemaHandler;

public class XMLElementChecker {
	private static final HashSet<String> cityGMLCollectionProperties = new HashSet<String>();

	static {
		cityGMLCollectionProperties.add("cityObjectMember");
		cityGMLCollectionProperties.add("appearanceMember");
		cityGMLCollectionProperties.add("groupMember");
		cityGMLCollectionProperties.add("parent");
	}

	private final SchemaHandler schemaHandler;
	private final FeatureReadMode featureReadMode;
	private final boolean keepInlineAppearance;
	private final Set<Class<? extends CityGML>> excludes;
	private final XMLUtil util;

	XMLElementChecker(SchemaHandler schemaHandler, 
			FeatureReadMode featureReadMode, 
			boolean keepInlineAppearance,
			Set<Class<? extends CityGML>> exlcudes) {
		this.schemaHandler = schemaHandler;
		this.featureReadMode = featureReadMode;
		this.keepInlineAppearance = keepInlineAppearance;
		this.excludes = exlcudes;

		util = XMLUtil.getInstance();
	}

	private ElementInfo getGMLFeatureProperty(String localName) {
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

	private ElementInfo getCityGMLFeatureProperty(String localName, String namespaceURI, XMLChunk currentChunk) {
		ElementInfo elementInfo = null;
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

	private ElementInfo getCityGMLFeature(String localName, String namespaceURI) {
		ElementInfo elementInfo = null;

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

	private ElementInfo getADEElementInfo(String localName, String namespaceURI, ElementInfo lastElementInfo, boolean checkForFeature) {
		ElementInfo elementInfo = null;

		Schema schema = schemaHandler.getSchema(namespaceURI);
		if (schema != null) {
			ElementDecl parent = lastElementInfo != null ? lastElementInfo.elementDecl : null;
			ElementDecl elementDecl = schema.getElementDecl(localName, parent);

			if (elementDecl != null) {
				elementInfo = new ElementInfo(elementDecl);

				if (checkForFeature && elementDecl.isFeature()) {
					elementInfo.isFeature = true;
					
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

	public ElementInfo getElementInfo(QName name, XMLChunk currentChunk, ElementInfo lastElementInfo) {
		if (lastElementInfo != null && lastElementInfo.skipNestedElements)
			return lastElementInfo;

		ElementInfo elementInfo = null;
		String localName = name.getLocalPart();
		String namespaceURI = name.getNamespaceURI();

		if (lastElementInfo != null && lastElementInfo.isFeatureProperty) {
			if (util.isGMLElement(name))
				; // we do not support GML features
			else if (util.isCityGMLElement(name))
				elementInfo = getCityGMLFeature(localName, namespaceURI);
			else
				elementInfo = getADEElementInfo(localName, namespaceURI, lastElementInfo, true);
		}

		else {
			if (util.isGMLElement(name))
				elementInfo = getGMLFeatureProperty(localName);
			else if (util.isCityGMLElement(name))
				elementInfo = getCityGMLFeatureProperty(localName, namespaceURI, currentChunk);
			else if (featureReadMode == FeatureReadMode.SPLIT_PER_FEATURE)
				elementInfo = getADEElementInfo(localName, namespaceURI, lastElementInfo, false);
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

	}

}
