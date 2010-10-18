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
package org.citygml4j.util.xlink;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.gml.base.AbstractGML;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.module.gml.GMLCoreModule;
import org.citygml4j.util.walker.GMLFunctionWalker;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XLinkResolver {
	
	public ModelObject getObject(String target, AbstractGML root) {
		if (target == null || target.length() == 0)
			return null;
		
		if (root == null)
			return null;
		
		GMLIdWalker walker = new GMLIdWalker(clipGMLId(target));
		return root.accept(walker);
	}
	
	public AbstractGeometry getGeometry(String target, AbstractGML root) {
		ModelObject object = getObject(target, root);
		return object instanceof AbstractGeometry ? (AbstractGeometry)object : null;
	}
	
	public AbstractFeature getFeature(String target, AbstractGML root) {
		ModelObject object = getObject(target, root);
		return object instanceof AbstractFeature ? (AbstractFeature)object : null;
	}
	
	@SuppressWarnings("unchecked")
	public <T extends AbstractGML> T getAbstractGML(String target, AbstractGML root, Class<T> type) {
		if (type == null)
			return null;
		
		Object object = getObject(target, root);
		return (type.isInstance(object)) ? (T)object : null;
	}
	
	private String clipGMLId(String target) {
		return target.replaceAll("^.*?#+?", "");
	}
	
	private static final class GMLIdWalker extends GMLFunctionWalker<ModelObject> {
		private final String gmlId;
		
		GMLIdWalker(String gmlId) {
			this.gmlId = gmlId;
		}
		
		@Override
		public ModelObject apply(AbstractGML abstractGML) {
			return (abstractGML.isSetId() && gmlId.equals(abstractGML.getId())) ? abstractGML : null;
		}
		
		@Override
		public ModelObject apply(ADEComponent adeComponent) {
			if (adeComponent.isSetContent() && addToVisited(adeComponent.getContent())) {
				ADEComponent result = adeComponent(adeComponent.getContent(), (Element)null);
				if (result != null)
					return (result.getContent() == adeComponent.getContent()) ? adeComponent : result;
			}

			return null;
		}

		protected ADEComponent adeComponent(Element element, Element parent) {	
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
				return new ADEComponent(element);

			NodeList childs = element.getChildNodes();
			for (int i = 0; i < childs.getLength(); ++i) {
				Node node = childs.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE && addToVisited(node)) {
					ADEComponent ade = adeComponent((Element)node, element);
					if (ade != null)
						return ade;
				}
			}

			return null;
		}
	}
	
}
