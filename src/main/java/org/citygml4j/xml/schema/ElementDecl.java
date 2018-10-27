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
package org.citygml4j.xml.schema;

import com.sun.xml.xsom.XSAttributeDecl;
import com.sun.xml.xsom.XSElementDecl;
import com.sun.xml.xsom.XSSchema;
import com.sun.xml.xsom.XSType;
import org.citygml4j.model.module.citygml.CoreModule;
import org.citygml4j.model.module.gml.GMLCoreModule;
import org.citygml4j.model.module.gml.XLinkModule;

import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class ElementDecl {
	private final XSElementDecl element;
	private final Schema schema;
	private final EnumSet<TypeFlag> typeFlag;

	private enum TypeFlag {
		ABSTRACT_GML, FEATURE, FEATURE_COLLECTION, CITY_OBJECT, GEOMETRY, FEATURE_PROPERTY, GEOMETRY_PROPERTY, XLINK,
		NO_ABSTRACT_GML, NO_FEATURE, NO_FEATURE_COLLECTION, NO_CITY_OBJECT, NO_GEOMETRY, NO_FEATURE_PROPERTY, NO_GEOMETRY_PROPERTY, NO_XLINK
	}

	public ElementDecl(XSElementDecl decl, Schema schema) {
		this.element = decl;
		this.schema = schema;

		typeFlag = EnumSet.noneOf(TypeFlag.class);
	}

	public XSElementDecl getXSElementDecl() {
		return element;
	}

	public boolean isGlobal() {
		return element.isGlobal();
	}

	public boolean isLocal() {
		return element.isLocal();
	}
	
	public boolean isAbstract() {
		return element.isAbstract();
	}

	public String getNamespaceURI() {
		return element.getTargetNamespace();
	}

	public String getLocalName() {
		return element.getName();
	}

	public QName getSubsitutionGroup() {
		XSElementDecl head = element.getSubstAffiliation();
		return (head != null) ? new QName(head.getTargetNamespace(), head.getName()) : null;
	}

	public QName getRootSubsitutionGroup() {
		XSElementDecl tmp = element;
		XSElementDecl head = null;

		while ((tmp = tmp.getSubstAffiliation()) != null)
			head = tmp;

		return (head != null) ? new QName(head.getTargetNamespace(), head.getName()) : null;
	}

	public boolean substitutes(String namespaceURI, String localName) {
		XSElementDecl tmp = element;

		while ((tmp = tmp.getSubstAffiliation()) != null) {
			if (namespaceURI.equals(tmp.getTargetNamespace()) && 
					localName.equals(tmp.getName()))
				return true;
		}

		return false;
	}

	public boolean substitutesFeature() {
		boolean substitutesFeature = false;

		for (GMLCoreModule module : GMLCoreModule.getInstances()) {
			switch (module.getVersion()) {
			case v3_1_1:
				substitutesFeature = substitutes(module.getNamespaceURI(), "_Feature");
				break;
			}

			if (substitutesFeature)
				break;
		}

		return substitutesFeature;
	}

	public boolean substitutesGeometry() {
		boolean substitutesGeometry = false;

		for (GMLCoreModule module : GMLCoreModule.getInstances()) {
			switch (module.getVersion()) {
			case v3_1_1:
				substitutesGeometry = substitutes(module.getNamespaceURI(), "_Geometry");
				break;
			}

			if (substitutesGeometry)
				break;
		}

		return substitutesGeometry;
	}

	public boolean isAbstractGML() {
		if (typeFlag.contains(TypeFlag.ABSTRACT_GML))
			return true;
		else if (typeFlag.contains(TypeFlag.NO_ABSTRACT_GML))
			return false;

		boolean isAbstractGML = false;
		for (GMLCoreModule module : GMLCoreModule.getInstances()) {
			XSSchema gml = schema.schemaSet.getSchema(module.getNamespaceURI());
			if (gml == null)
				continue;

			switch (module.getVersion()) {
			case v3_1_1:
				isAbstractGML = isDerivedFromComplexType(gml, "AbstractGMLType");
				break;
			}

			if (isAbstractGML)
				break;
		}

		if (isAbstractGML) {
			typeFlag.add(TypeFlag.ABSTRACT_GML);
		} else {
			typeFlag.add(TypeFlag.NO_ABSTRACT_GML);
			typeFlag.add(TypeFlag.NO_FEATURE);
			typeFlag.add(TypeFlag.NO_FEATURE_COLLECTION);
			typeFlag.add(TypeFlag.NO_CITY_OBJECT);
			typeFlag.add(TypeFlag.NO_GEOMETRY);
		}		

		return isAbstractGML;
	}

	public boolean isFeature() {
		if (typeFlag.contains(TypeFlag.FEATURE))
			return true;
		else if (typeFlag.contains(TypeFlag.NO_FEATURE))
			return false;

		boolean isFeature = false;
		for (GMLCoreModule module : GMLCoreModule.getInstances()) {
			XSSchema gml = schema.schemaSet.getSchema(module.getNamespaceURI());
			if (gml == null)
				continue;

			switch (module.getVersion()) {
			case v3_1_1:
				isFeature = isDerivedFromComplexType(gml, "AbstractFeatureType");
				break;
			}

			if (isFeature)
				break;
		}

		if (isFeature) {
			typeFlag.add(TypeFlag.ABSTRACT_GML);
			typeFlag.add(TypeFlag.FEATURE);
		} else {
			typeFlag.add(TypeFlag.NO_FEATURE);
			typeFlag.add(TypeFlag.NO_CITY_OBJECT);
		}		

		return isFeature;
	}
	
	public boolean isFeatureCollection() {
		if (typeFlag.contains(TypeFlag.FEATURE_COLLECTION))
			return true;
		else if (typeFlag.contains(TypeFlag.NO_FEATURE_COLLECTION))
			return false;

		boolean isFeatureCollection = false;
		for (GMLCoreModule module : GMLCoreModule.getInstances()) {
			XSSchema gml = schema.schemaSet.getSchema(module.getNamespaceURI());
			if (gml == null)
				continue;

			switch (module.getVersion()) {
			case v3_1_1:
				isFeatureCollection = isDerivedFromComplexType(gml, "AbstractFeatureCollectionType");
				break;
			}

			if (isFeatureCollection)
				break;
		}

		if (isFeatureCollection) {
			typeFlag.add(TypeFlag.ABSTRACT_GML);
			typeFlag.add(TypeFlag.FEATURE);
			typeFlag.add(TypeFlag.FEATURE_COLLECTION);
		} else {
			typeFlag.add(TypeFlag.NO_FEATURE);
			typeFlag.add(TypeFlag.NO_FEATURE_COLLECTION);
		}		

		return isFeatureCollection;
	}

	public boolean isGeometry() {
		if (typeFlag.contains(TypeFlag.GEOMETRY))
			return true;
		else if (typeFlag.contains(TypeFlag.NO_GEOMETRY))
			return false;

		boolean isGeometry = false;
		for (GMLCoreModule module : GMLCoreModule.getInstances()) {
			XSSchema gml = schema.schemaSet.getSchema(module.getNamespaceURI());
			if (gml == null)
				continue;

			switch (module.getVersion()) {
			case v3_1_1:
				isGeometry = isDerivedFromComplexType(gml, "AbstractGeometryType");
				break;
			}

			if (isGeometry)
				break;
		}

		if (isGeometry) {
			typeFlag.add(TypeFlag.ABSTRACT_GML);
			typeFlag.add(TypeFlag.GEOMETRY);
		} else {
			typeFlag.add(TypeFlag.NO_GEOMETRY);
		}		

		return isGeometry;
	}

	public boolean isCityObject() {
		if (typeFlag.contains(TypeFlag.CITY_OBJECT))
			return true;
		else if (typeFlag.contains(TypeFlag.NO_CITY_OBJECT))
			return false;

		boolean isCityObject = false;
		for (CoreModule module : CoreModule.getInstances()) {
			XSSchema core = schema.schemaSet.getSchema(module.getNamespaceURI());
			if (core == null)
				continue;

			isCityObject = isDerivedFromComplexType(core, "AbstractCityObjectType");
			if (isCityObject)
				break;
		}
		
		if (!isCityObject && schema.schemaSet.getSchema("http://www.citygml.org/citygml/1/0/0") != null)
			isCityObject = isDerivedFromComplexType(schema.schemaSet.getSchema("http://www.citygml.org/citygml/1/0/0"), "_CityObjectType");

		if (isCityObject) {
			typeFlag.add(TypeFlag.ABSTRACT_GML);
			typeFlag.add(TypeFlag.FEATURE);
			typeFlag.add(TypeFlag.CITY_OBJECT);
		} else {
			typeFlag.add(TypeFlag.NO_CITY_OBJECT);
		}		

		return isCityObject;
	}

	public boolean isFeatureProperty() {
		if (typeFlag.contains(TypeFlag.FEATURE_PROPERTY))
			return true;
		else if (typeFlag.contains(TypeFlag.NO_FEATURE_PROPERTY))
			return false;

		boolean isFeatureProperty = false;
		for (XSElementDecl child : getChildElements()) {
			Schema childSchema = schema.handler.getSchema(child.getTargetNamespace());
			List<ElementDecl> childElementDecls = childSchema.getElementDecls(child.getName());

			if (childElementDecls.size() == 1) {
				if (childElementDecls.get(0).isFeature())
					isFeatureProperty = true;
			} else {
				for (GMLCoreModule module : GMLCoreModule.getInstances()) {
					XSSchema gml = schema.schemaSet.getSchema(module.getNamespaceURI());
					if (gml == null)
						continue;

					switch (module.getVersion()) {
					case v3_1_1:
						isFeatureProperty = child.getType().isDerivedFrom(gml.getType("AbstractFeatureType"));
						break;
					}

					if (isFeatureProperty)
						break;
				}
			}

			if (isFeatureProperty)
				break;
		}

		if (isFeatureProperty) {
			typeFlag.add(TypeFlag.FEATURE_PROPERTY);
			typeFlag.add(TypeFlag.NO_GEOMETRY_PROPERTY);
		} else
			typeFlag.add(TypeFlag.NO_FEATURE_PROPERTY);			

		return isFeatureProperty;
	}

	public boolean isGeometryProperty() {
		if (typeFlag.contains(TypeFlag.GEOMETRY_PROPERTY))
			return true;
		else if (typeFlag.contains(TypeFlag.NO_GEOMETRY_PROPERTY))
			return false;

		boolean isGeometryProperty = false;
		for (XSElementDecl child : getChildElements()) {
			Schema childSchema = schema.handler.getSchema(child.getTargetNamespace());
			List<ElementDecl> childElementDecls = childSchema.getElementDecls(child.getName());

			if (childElementDecls.size() == 1) {
				if (childElementDecls.get(0).isGeometry())
					isGeometryProperty = true;
			} else {
				for (GMLCoreModule module : GMLCoreModule.getInstances()) {
					XSSchema gml = schema.schemaSet.getSchema(module.getNamespaceURI());
					if (gml == null)
						continue;

					switch (module.getVersion()) {
					case v3_1_1:
						isGeometryProperty = child.getType().isDerivedFrom(gml.getType("AbstractGeometryType"));
						break;
					}

					if (isGeometryProperty)
						break;
				}
			}

			if (isGeometryProperty)
				break;
		}

		if (isGeometryProperty) {
			typeFlag.add(TypeFlag.GEOMETRY_PROPERTY);
			typeFlag.add(TypeFlag.NO_FEATURE_PROPERTY);
		} else
			typeFlag.add(TypeFlag.NO_GEOMETRY_PROPERTY);		

		return isGeometryProperty;
	}

	public boolean hasXLinkAttribute() {
		if (typeFlag.contains(TypeFlag.XLINK))
			return true;
		else if (typeFlag.contains(TypeFlag.NO_XLINK))
			return false;

		final boolean[] hasXLink = new boolean[1];		
		SchemaWalker walker = new SchemaWalker() {

			@Override
			public void elementDecl(XSElementDecl decl) {
			}

			@Override
			public void attributeDecl(XSAttributeDecl decl) {
				if (XLinkModule.v3_1_1.getNamespaceURI().equals(decl.getTargetNamespace()) &&
						decl.getName().equals("href")) {
					hasXLink[0] = true;
					setShouldWalk(false);
				}
			}

		};

		element.getType().visit(walker);

		if (hasXLink[0])
			typeFlag.add(TypeFlag.XLINK);
		else
			typeFlag.add(TypeFlag.NO_XLINK);

		return hasXLink[0];
	}

	private boolean isDerivedFromComplexType(XSSchema schema, String localPart) {
		XSType base = schema.getType(localPart);
		if (base != null) {
			if (base.isSimpleType()) {
				typeFlag.add(TypeFlag.NO_ABSTRACT_GML);
				typeFlag.add(TypeFlag.NO_FEATURE);
				typeFlag.add(TypeFlag.NO_FEATURE_COLLECTION);
				typeFlag.add(TypeFlag.NO_CITY_OBJECT);
				typeFlag.add(TypeFlag.NO_GEOMETRY);
				typeFlag.add(TypeFlag.NO_FEATURE_PROPERTY);
				typeFlag.add(TypeFlag.NO_GEOMETRY_PROPERTY);

				return false;
			} else
				return element.getType().isDerivedFrom(base);
		} 

		return false;
	}

	List<XSElementDecl> getChildElements() {
		final List<XSElementDecl> childs = new ArrayList<XSElementDecl>();
		SchemaWalker schemaWalker = new SchemaWalker() {

			@Override
			public void elementDecl(XSElementDecl child) {
				childs.add(child);
			}

		};

		element.getType().visit(schemaWalker);
		return childs;
	}

}
