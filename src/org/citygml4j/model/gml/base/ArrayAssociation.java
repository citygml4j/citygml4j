package org.citygml4j.model.gml.base;

import java.util.List;

public interface ArrayAssociation<T extends Associable> extends Association<T> {
	public List<T> getObject();
	public boolean isSetObject();
	
	public void addObject(T object);
	public void setObject(List<T> object);
	public boolean unsetObject(T object);
	public void unsetObject();
}
