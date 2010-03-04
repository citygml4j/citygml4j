package org.citygml4j.model.gml;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;
import org.citygml4j.model.citygml.ade.ADEComponent;

public interface Association<T extends AbstractGML> extends GML, AssociationAttributeGroup, Child, Copyable {
	public T getObject();
	public ADEComponent getGenericADEComponent();
	public boolean isSetObject();
	public boolean isSetGenericADEComponent();
	
	public void setObject(T object);
	public void setGenericADEComponent(ADEComponent genericADEComponent);
	public void unsetObject();
	public void unsetGenericADEComponent();
}
