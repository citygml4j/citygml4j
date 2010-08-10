package org.citygml4j.model.gml.geometry;

import org.citygml4j.model.gml.base.AssociationByRep;

public interface InlineGeometryProperty<T extends AbstractGeometry> extends AssociationByRep<T> {
	public T getGeometry();
	public boolean isSetGeometry();

	public void setGeometry(T geometry);
	public void unsetGeometry();
}
