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
package org.citygml4j.util.xlink;

import org.citygml4j.model.citygml.ade.generic.ADEGenericElement;
import org.citygml4j.model.citygml.appearance.AppearanceModuleComponent;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.gml.base.AbstractGML;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.gml.feature.FeatureProperty;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.module.gml.GMLCoreModule;
import org.citygml4j.util.walker.GMLFunctionWalker;
import org.citygml4j.xml.schema.SchemaHandler;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XLinkResolver {
	private SchemaHandler schemaHandler;

	public XLinkResolver setSchemaHandler(SchemaHandler schemaHandler) {
		this.schemaHandler = schemaHandler;
		return this;
	}

	private ModelObject resolveXlink(String target, AbstractGML root, GMLIdWalker walker) {
		if (target == null || target.length() == 0)
			return null;
		
		if (root == null)
			return null;
		
		return root.accept(walker);
	}
	
	public ModelObject getObject(String target, AbstractGML root) {
		return resolveXlink(target, root, new GMLWalker(clipGMLId(target), schemaHandler));
	}	
	
	public AbstractGeometry getGeometry(String target, AbstractGML root) {
		ModelObject object = resolveXlink(target, root, new GeometryWalker(clipGMLId(target), schemaHandler));
		return object instanceof AbstractGeometry ? (AbstractGeometry)object : null;
	}
	
	public AbstractFeature getFeature(String target, AbstractGML root) {
		ModelObject object = resolveXlink(target, root, new FeatureWalker(clipGMLId(target), schemaHandler));
		return object instanceof AbstractFeature ? (AbstractFeature)object : null;
	}
	
	@SuppressWarnings("unchecked")
	public <T extends AbstractGML> T getAbstractGML(String target, AbstractGML root, Class<T> type) {
		if (type == null)
			return null;
		
		ModelObject object = getObject(target, root);
		return (type.isInstance(object)) ? (T)object : null;
	}
	
	private String clipGMLId(String target) {
		return target.replaceAll("^.*?#+?", "");
	}
	
	private static final class GMLWalker extends GMLIdWalker {
		
		GMLWalker(String gmlId, SchemaHandler schemaHandler) {
			super(gmlId, schemaHandler);
		}

		@Override
		public ModelObject apply(AbstractGML abstractGML) {
			return (abstractGML.isSetId() && super.gmlId.equals(abstractGML.getId())) ? abstractGML : null;
		}		
	}
	
	private static final class FeatureWalker extends GMLIdWalker {
		
		FeatureWalker(String gmlId, SchemaHandler schemaHandler) {
			super(gmlId, schemaHandler);
		}

		@Override
		public ModelObject apply(AbstractFeature abstractFeature) {
			return (abstractFeature.isSetId() && super.gmlId.equals(abstractFeature.getId())) ? abstractFeature : null;
		}
	}
	
	private static final class GeometryWalker extends GMLIdWalker {
		
		GeometryWalker(String gmlId, SchemaHandler schemaHandler) {
			super(gmlId, schemaHandler);
		}
		
		@Override
		public ModelObject apply(AbstractGeometry abstractGeometry) {
			return (abstractGeometry.isSetId() && super.gmlId.equals(abstractGeometry.getId())) ? abstractGeometry : null;
		}

		@Override
		public <E extends AbstractFeature> ModelObject apply(FeatureProperty<E> featureProperty) {
			if (featureProperty.isSetObject() && featureProperty.getObject() instanceof AppearanceModuleComponent)
				return null;
			
			return super.apply(featureProperty);
		}

		@Override
		public ModelObject apply(AbstractFeature abstractFeature) {
			if (abstractFeature instanceof AppearanceModuleComponent)
				return null;
			
			return super.apply(abstractFeature);
		}
		
	}
	
	private static abstract class GMLIdWalker extends GMLFunctionWalker<ModelObject> {
		private final String gmlId;
		
		GMLIdWalker(String gmlId, SchemaHandler schemaHandler) {
			this.gmlId = gmlId;
			setSchemaHandler(schemaHandler);
		}
		
		@Override
		public ModelObject apply(ADEGenericElement adeGenericElement) {
			if (adeGenericElement.isSetContent()) {
				ADEGenericElement result = adeGenericElement(adeGenericElement.getContent(), (Element)null);
				if (result != null)
					return (result.getContent() == adeGenericElement.getContent()) ? adeGenericElement : result;
			}

			return null;
		}

		protected ADEGenericElement adeGenericElement(Element element, Element parent) {	
			String elementId = element.getAttribute("id");
			if (elementId.length() == 0) {
				for (GMLCoreModule gml : GMLCoreModule.getInstances()) {
					switch (gml.getVersion()) {
					case v3_1_1:
						elementId = element.getAttributeNS(gml.getNamespaceURI(), "id");
						break;
					}

					if (elementId.length() > 0)
						break;
				}
			}

			if (elementId.length() > 0 && gmlId.equals(elementId))
				return new ADEGenericElement(element);

			NodeList childs = element.getChildNodes();
			for (int i = 0; i < childs.getLength(); ++i) {
				Node node = childs.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					ADEGenericElement ade = adeGenericElement((Element)node, element);
					if (ade != null)
						return ade;
				}
			}

			return null;
		}
	}
	
}
