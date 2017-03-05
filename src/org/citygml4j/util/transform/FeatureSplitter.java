/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright 2013-2017 Claus Nagel <claus.nagel@gmail.com>
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
package org.citygml4j.util.transform;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.ade.ADEGenericElement;
import org.citygml4j.model.citygml.appearance.Appearance;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.gml.feature.FeatureArrayProperty;
import org.citygml4j.model.gml.feature.FeatureProperty;
import org.citygml4j.model.module.gml.GMLCoreModule;
import org.citygml4j.model.module.gml.XLinkModule;
import org.citygml4j.util.child.ChildInfo;
import org.citygml4j.util.gmlid.DefaultGMLIdManager;
import org.citygml4j.util.gmlid.GMLIdManager;
import org.citygml4j.util.walker.FeatureWalker;
import org.citygml4j.xml.schema.ElementDecl;
import org.citygml4j.xml.schema.Schema;
import org.citygml4j.xml.schema.SchemaHandler;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FeatureSplitter {
	private final Splitter splitter;
	private final List<CityGML> result;
	private final GMLIdManager gmlIdManager;
	private final ChildInfo childInfo;
	private final SplitCopyBuilder copyBuilder;

	private FeatureSplitMode splitMode;
	private Set<Class<? extends CityGML>> excludes;
	private boolean keepInlineAppearance;
	private boolean splitCopy;

	public FeatureSplitter(SchemaHandler schemaHandler, GMLIdManager gmlIdManager) {
		this.gmlIdManager = gmlIdManager;

		result = new ArrayList<CityGML>();
		splitter = new Splitter(schemaHandler);
		childInfo = new ChildInfo();
		copyBuilder = new SplitCopyBuilder();

		splitMode = FeatureSplitMode.SPLIT_PER_FEATURE;
		excludes = new HashSet<Class<? extends CityGML>>();
		keepInlineAppearance = true;
		splitCopy = false;
	}

	public FeatureSplitter() {
		this(null, DefaultGMLIdManager.getInstance());
	}	

	public FeatureSplitter(GMLIdManager gmlIdManager) {
		this(null, gmlIdManager);
	}

	public FeatureSplitter(SchemaHandler schemaHandler) {
		this(schemaHandler, DefaultGMLIdManager.getInstance());
	}

	public void reset() {
		result.clear();
		splitter.reset();

		splitMode = FeatureSplitMode.SPLIT_PER_FEATURE;
		excludes.clear();
		keepInlineAppearance = true;
		splitCopy = false;
	}

	public List<CityGML> split(Object object) {
		result.clear();

		if (splitCopy) {
			object = copyBuilder.copy(object);
			copyBuilder.visited.clear();
		}

		if (object instanceof AbstractFeature)
			((AbstractFeature)object).accept(splitter);
		else if (object instanceof ADEGenericElement)
			splitter.visit((ADEGenericElement)object);
		else if (object instanceof Element)
			splitter.visit((Element)object, null);

		splitter.reset();
		return result;
	}

	public SchemaHandler getSchemaHandler() {
		return splitter.getSchemaHandler();
	}

	public FeatureSplitMode getSplitMode() {
		return splitMode;
	}

	public void setSplitMode(FeatureSplitMode splitMode) {
		if (splitMode == null)
			throw new IllegalArgumentException("split mode may not be null.");

		this.splitMode = splitMode;
	}

	public void exlcude(Class<? extends CityGML> cityGMLClass) {
		excludes.add(cityGMLClass);
	}

	public void clearExcludes() {
		excludes.clear();
	}

	public Set<Class<? extends CityGML>> getExcludes() {
		return excludes;
	}

	public void setExcludes(Set<Class<? extends CityGML>> excludes) {
		if (excludes == null)
			throw new IllegalArgumentException("set of excludes may not be null.");

		this.excludes = excludes;
	}

	public void setKeepInlineAppearance(boolean keepInlineAppearance) {
		this.keepInlineAppearance = keepInlineAppearance;
	}

	public boolean isKeepInlineAppearance() {
		return keepInlineAppearance;
	}

	public boolean isSplitCopy() {
		return splitCopy;
	}

	public void setSplitCopy(boolean splitCopy) {
		this.splitCopy = splitCopy;
	}

	private class SplitCopyBuilder extends CopyBuilder {
		private IdentityHashMap<Object, Object> visited = new IdentityHashMap<Object, Object>();

		@Override
		public Object copy(Object target) {
			Object copy = visited.get(target);
			if (copy != null)
				return copy;

			if (target instanceof AbstractFeature ||
					target instanceof FeatureProperty<?> ||
					target instanceof FeatureArrayProperty)
				copy = ((Copyable)target).copy(this);

			else if (target instanceof ADEGenericElement) {
				copy = ((Copyable)target).copy(this);				
				ADEGenericElement tmp = (ADEGenericElement)copy;
				tmp.setContent((Element)tmp.getContent().cloneNode(true));
			}				

			else 
				copy = target;

			if (copy != null)
				visited.put(target, copy);

			return copy;
		}
	}

	private class Splitter extends FeatureWalker { 
		private final SchemaHandler schemaHandler;

		Splitter(SchemaHandler schemaHandler) {
			super(schemaHandler);
			this.schemaHandler = schemaHandler;
		}

		@Override
		public void visit(Appearance appearance) {
			if (keepInlineAppearance && childInfo.getParentCityObject(appearance) != null)
				return;

			super.visit(appearance);
		}

		@Override
		public void visit(AbstractFeature feature) {
			if (!excludes.isEmpty())
				for (Class<? extends CityGML> exclude : excludes)
					if (exclude.isInstance(feature))
						return;

			ModelObject parent = feature.getParent();
			boolean addToResult = false;

			if (parent != null) {
				if (parent instanceof FeatureProperty<?>) {
					FeatureProperty<?> property = (FeatureProperty<?>)parent;				
					property.setHref('#' + getAndSetGmlId(feature));
					property.unsetFeature();
					addToResult = true;
				}

				else if (parent instanceof FeatureArrayProperty) {
					FeatureArrayProperty featureArray = (FeatureArrayProperty)parent;
					featureArray.unsetFeature(feature);
					addToResult = true;
				}

			} else
				addToResult = true;

			if (addToResult && feature instanceof CityGML)
				result.add((CityGML)feature);	

			super.visit(feature);
		}

		@Override
		public void visit(ADEGenericElement adeGenericElement) {
			if (!excludes.isEmpty())
				for (Class<? extends CityGML> exclude : excludes)
					if (exclude.isInstance(adeGenericElement))
						return;

			if (adeGenericElement.isSetContent() && schemaHandler != null && 
					shouldWalk() && addToVisited(adeGenericElement.getContent())) {				
				boolean addToResult = false;
				ModelObject parent = adeGenericElement.getParent();

				if (parent != null) {
					Schema schema = schemaHandler.getSchema(adeGenericElement.getNamespaceURI());
					if (schema != null) {
						ElementDecl elementDecl = schema.getElementDecl(adeGenericElement.getLocalName(), null);
						
						if (elementDecl != null && splitElement(elementDecl)) {
							if (parent instanceof FeatureProperty<?>) {
								FeatureProperty<?> property = (FeatureProperty<?>)parent;				
								property.setHref('#' + getAndSetGmlId(adeGenericElement.getContent()));
								property.unsetGenericADEComponent();
								addToResult = true;
							}

							else if (parent instanceof FeatureArrayProperty) {
								FeatureArrayProperty featureArray = (FeatureArrayProperty)parent;
								featureArray.unsetGenericADEComponent(adeGenericElement);
								addToResult = true;
							}
						}
					}
				} else
					addToResult = true;

				if (addToResult)
					result.add(adeGenericElement);
				
				// visit child elements
				adeGenericElement(adeGenericElement.getContent(), null, null);
			}
		}

		protected void adeGenericElement(Element element, Element parent, ElementDecl lastElement) {
			Schema schema = schemaHandler.getSchema(element.getNamespaceURI());

			if (schema != null) {
				ElementDecl tmp = schema.getElementDecl(element.getLocalName(), lastElement);
				if (tmp != null && 
						parent != null && 
						lastElement != null && 
						splitElement(tmp) &&
						lastElement.hasXLinkAttribute()) {
					parent.setAttributeNS(XLinkModule.v3_1_1.getNamespaceURI(), "href", '#' + getAndSetGmlId(element));
					parent.removeChild(element);
					if (parent.getTextContent().trim().length() == 0)
						parent.setTextContent("");

					result.add(new ADEGenericElement(element));
				}

				lastElement = tmp;
			}

			NodeList nodeList = element.getChildNodes();

			List<Element> children = new ArrayList<Element>(nodeList.getLength());
			for (int i = 0; i < nodeList.getLength(); ++i) {
				Node node = nodeList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE)
					children.add((Element)node);
			}			

			for (Element child : children)
				if (addToVisited(child))
					adeGenericElement((Element)child, element, lastElement);
		}

		private boolean splitElement(ElementDecl elementDecl) {
			boolean split = elementDecl.isFeature();
			if (splitMode == FeatureSplitMode.SPLIT_PER_COLLECTION_MEMBER && split)
				split = elementDecl.isGlobal() && elementDecl.substitutesFeature();

			return split;
		}

		private String getAndSetGmlId(AbstractFeature feature) {
			String gmlId = feature.getId();
			if (gmlId == null) {
				gmlId = gmlIdManager.generateUUID();
				feature.setId(gmlId);
			}

			return gmlId;
		}

		private String getAndSetGmlId(Element element) {
			String gmlId = element.getAttributeNS(GMLCoreModule.v3_1_1.getNamespaceURI(), "id");
			if (gmlId.length() == 0)
				gmlId = element.getAttribute("id");

			if (gmlId.length() == 0) {
				gmlId = gmlIdManager.generateUUID();
				element.setAttributeNS(GMLCoreModule.v3_1_1.getNamespaceURI(), "id", gmlId);
			}

			return gmlId;
		}
	}

}
