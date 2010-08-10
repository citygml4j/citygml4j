package org.citygml4j.model.gml.base;

import org.citygml4j.model.gml.GML;
import org.citygml4j.visitor.GMLFunction;
import org.citygml4j.visitor.GMLVisitor;


public interface AbstractGML extends GML, StandardObjectProperties, Associable {
	public String getId();
	public boolean isSetId();
	
	public void setId(String id);
	public void unsetId();
	
	public void visit(GMLVisitor visitor);
	public <T> T apply(GMLFunction<T> visitor);
}
