/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
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
 */
package org.citygml4j.xml.schema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.sun.xml.xsom.XSAttGroupDecl;
import com.sun.xml.xsom.XSAttributeDecl;
import com.sun.xml.xsom.XSAttributeUse;
import com.sun.xml.xsom.XSComplexType;
import com.sun.xml.xsom.XSElementDecl;
import com.sun.xml.xsom.XSSchema;
import com.sun.xml.xsom.XSSchemaSet;
import com.sun.xml.xsom.XSSimpleType;
import com.sun.xml.xsom.XSType;

public class Schema {
	final XSSchemaSet schemaSet;
	final SchemaHandler handler;
	final XSSchema schema;
	final String namespaceURI;

	private final HashMap<String, ElementDecl> uniqueElements;
	private final HashMap<String, List<ElementDecl>> multipleElements;
	private final HashMap<ElementDecl, HashMap<String, ElementDecl>> localElements;

	public Schema(XSSchemaSet schemaSet, String namespaceURI, SchemaHandler handler) {
		this.schemaSet = schemaSet;
		this.handler = handler;
		this.namespaceURI = namespaceURI;

		schema = schemaSet.getSchema(namespaceURI);
		if (schema == null)
			throw new IllegalStateException("no XSSchema associated with the namespace '" + namespaceURI + "'.");

		uniqueElements = new HashMap<String, ElementDecl>();
		multipleElements = new HashMap<String, List<ElementDecl>>();
		localElements = new HashMap<ElementDecl, HashMap<String,ElementDecl>>();
	}

	public XSSchema getXSSchema() {
		return schema;
	}

	public String getNamespaceURI() {
		return namespaceURI;
	}

	public XSSchemaSet getXSSchemaSet() {
		return schemaSet;
	}

	public ElementDecl getGlobalElementDecl(String localName) {
		XSElementDecl decl = schema.getElementDecl(localName);
		return decl != null ? new ElementDecl(decl, this) : null;
	}

	public ElementDecl getElementDecl(String localName, ElementDecl parent) {
		ElementDecl element = null;
		HashMap<String, ElementDecl> local = null;

		if (parent != null) {
			local = localElements.get(parent);
			if (local != null)
				element = local.get(localName);
		}

		if (element == null) {
			List<ElementDecl> candidates = getElementDecls(localName);
			if (candidates.size() == 1)
				element = candidates.get(0);

			else if (parent != null) {
				List<XSElementDecl> children = parent.getChildElements();

				for (ElementDecl candidate : candidates) {
					if (candidate.isGlobal()) {
						for (XSElementDecl child : children) {
							if (child.canBeSubstitutedBy(candidate.getXSElementDecl())) {
								element = candidate;
								break;
							}
						}

						if (element != null)
							break;

					} else {
						if (children.contains(candidate.getXSElementDecl())) {
							element = candidate;
							break;
						}
					}
				}

				if (element != null) {
					if (local == null) {
						local = new HashMap<String, ElementDecl>();
						localElements.put(parent, local);
					}

					local.put(localName, element);
				}
			}
		}

		return element;
	}

	public List<ElementDecl> getElementDecls(final String localName) {
		if (multipleElements.containsKey(localName))
			return multipleElements.get(localName);

		final List<ElementDecl> elements = new ArrayList<ElementDecl>();
		ElementDecl element = uniqueElements.get(localName);

		if (element != null)
			elements.add(element);
		else {
			SchemaWalker schemaWalker = new SchemaWalker() {

				@Override
				public void schema(XSSchema schema) {
					for (XSElementDecl e : schema.getElementDecls().values())
						if (shouldWalk() && addToVisited(e))
							elementDecl(e);

					for (XSComplexType t : schema.getComplexTypes().values())
						if (shouldWalk() && addToVisited(t))
							t.visit(this);
				}

				@Override
				public void elementDecl(XSElementDecl decl) {
					if (localName.equals(decl.getName()) && 
							schema.getTargetNamespace().equals(decl.getTargetNamespace()))
						elements.add(new ElementDecl(decl, Schema.this));

					if (decl.getType().isLocal() && shouldWalk() && addToVisited(decl.getType()))
						decl.getType().visit(this);
				}

				public void complexType(XSComplexType type) {
					if (shouldWalk() && addToVisited(type.getContentType()))
						type.getContentType().visit(this);
				}

				@Override
				public void attGroupDecl(XSAttGroupDecl decl) {
				}

				@Override
				public void attributeDecl(XSAttributeDecl decl) {
				}

				@Override
				public void attributeUse(XSAttributeUse use) {
				}

				@Override
				public void simpleType(XSSimpleType simpleType) {
				}

			};

			schemaWalker.visit(schema);

			if (elements.size() > 1)
				multipleElements.put(localName, elements);
			else if (elements.size() == 1)
				uniqueElements.put(localName, elements.get(0));			
		}

		return elements;
	}

	public boolean haveSameTypeDefinition(List<ElementDecl> elementDecls) {
		Iterator<ElementDecl> iter = elementDecls.iterator();				
		ElementDecl first = iter.next();				
		XSType refType = first.getXSElementDecl().getType();

		while (iter.hasNext())
			if (iter.next().getXSElementDecl().getType() != refType)
				return false;

		return true;
	}

}