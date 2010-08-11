package org.citygml4j.model.gml.base;

public interface AssociationByRep<T extends Associable> extends Association<T> {
	public T getObject();
	public boolean isSetObject();
	
	public void setObject(T object);
	public void unsetObject();
}
