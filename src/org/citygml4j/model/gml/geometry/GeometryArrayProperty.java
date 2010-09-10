package org.citygml4j.model.gml.geometry;

import java.util.List;

import org.citygml4j.model.gml.base.ArrayAssociation;

public interface GeometryArrayProperty<T extends AbstractGeometry> extends ArrayAssociation<T> {
	public List<T> getGeometry();
	public boolean isSetGeometry();
	
	public void addGeometry(T geometry);
	public void setGeometry(List<T> geometry);
	public boolean unsetGeometry(T geometry);
	public void unsetGeometry();
}
