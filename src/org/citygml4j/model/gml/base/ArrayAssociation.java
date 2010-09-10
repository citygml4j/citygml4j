package org.citygml4j.model.gml.base;

import java.util.List;

import org.citygml4j.model.common.association.Associable;
import org.citygml4j.model.common.association.Association;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;

public interface ArrayAssociation<T extends Associable & Child> extends GML, Association<T>, Child, Copyable {
	public List<T> getObject();
	public boolean isSetObject();
	
	public void addObject(T object);
	public void setObject(List<T> object);
	public boolean unsetObject(T object);
	public void unsetObject();
}
