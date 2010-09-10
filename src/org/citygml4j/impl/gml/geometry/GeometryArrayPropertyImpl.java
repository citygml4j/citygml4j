package org.citygml4j.impl.gml.geometry;

import java.util.List;

import org.citygml4j.impl.gml.base.ArrayAssociationImpl;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryArrayProperty;

public abstract class GeometryArrayPropertyImpl<T extends AbstractGeometry> extends ArrayAssociationImpl<T> implements GeometryArrayProperty<T> {

	public List<T> getGeometry() {
		return super.getObject();
	}

	public boolean isSetGeometry() {
		return super.isSetObject();
	}

	public void addGeometry(T geometry) {
		super.addObject(geometry);
	}

	public void setGeometry(List<T> geometry) {
		super.setObject(geometry);
	}

	public boolean unsetGeometry(T geometry) {
		return super.unsetObject(geometry);
	}

	public void unsetGeometry() {
		super.unsetObject();
	}

	public GMLClass getGMLClass() {
		return GMLClass.GEOMETRY_ARRAY_PROPERTY;
	}

}
