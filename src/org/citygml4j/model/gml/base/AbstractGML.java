package org.citygml4j.model.gml.base;

import org.citygml4j.model.common.association.Associable;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.gml.GML;


public interface AbstractGML extends GML, StandardObjectProperties, Associable, Child, Copyable {
	public String getId();
	public boolean isSetId();
	
	public void setId(String id);
	public void unsetId();
	
	public void accept(GMLVisitor visitor);
	public <T> T accept(GMLFunctor<T> visitor);
}
