package org.citygml4j.model.gml.base;

import org.citygml4j.model.common.association.Associable;
import org.citygml4j.model.common.association.Association;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;

public interface AssociationByRep<T extends Associable & Child> extends GML, Association<T>, Child, Copyable {
	public T getObject();
	public boolean isSetObject();
	
	public void setObject(T object);
	public void unsetObject();
}
