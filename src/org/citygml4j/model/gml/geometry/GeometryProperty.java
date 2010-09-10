package org.citygml4j.model.gml.geometry;

import org.citygml4j.model.gml.base.AssociationByRepOrRef;

public interface GeometryProperty<T extends AbstractGeometry> extends AssociationByRepOrRef<T> {
	public T getGeometry();
	public boolean isSetGeometry();

	public void setGeometry(T geometry);
	public void unsetGeometry();
}
