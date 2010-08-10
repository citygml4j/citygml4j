package org.citygml4j.model.gml.base;

import java.util.List;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;
import org.citygml4j.model.gml.GML;


public interface ArrayAssociation<T extends Associable> extends GML, Child, Copyable {
	public List<T> getObject();
	public boolean isSetObject();
	
	public void addObject(T object);
	public void setObject(List<T> object);
	public boolean unsetObject(T object);
	public void unsetObject();
}
