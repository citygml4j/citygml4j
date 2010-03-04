package org.citygml4j.model.gml;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;
import org.citygml4j.visitor.GMLFunction;
import org.citygml4j.visitor.GMLVisitor;

public interface AbstractGML extends GML, StandardObjectProperties, Child, Copyable {
	public String getId();
	public boolean isSetId();
	
	public void setId(String id);
	public void unsetId();
	
	public void visit(GMLVisitor visitor);
	public <T> T apply(GMLFunction<T> visitor);
}
