package org.citygml4j.util.xlink;

import org.citygml4j.model.gml.base.AbstractGML;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.gml.geometry.AbstractGeometry;

public class XLinkResolver {
	
	public Object getObject(String target, AbstractGML root) {
		if (target == null || target.length() == 0)
			return null;
		
		if (root == null)
			return null;
		
		GMLIdWalker walker = new GMLIdWalker(clipGMLId(target));
		return root.accept(walker);
	}
	
	public AbstractGeometry getGeometry(String target, AbstractGML root) {
		Object object = getObject(target, root);
		return object instanceof AbstractGeometry ? (AbstractGeometry)object : null;
	}
	
	public AbstractFeature getFeature(String target, AbstractGML root) {
		Object object = getObject(target, root);
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
	
}
