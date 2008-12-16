package org.citygml4j.model.gml;

public interface Association<T extends AbstractGML> extends GMLBase, AssociationAttributeGroup {
	public T getObject();
	public boolean isSetObject();
	
	public void setObject(T object);
	public void unsetObject();
}
