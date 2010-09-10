package org.citygml4j.impl.gml.geometry;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.base.AssociationByRepOrRefImpl;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryProperty;

public class GeometryPropertyImpl<T extends AbstractGeometry> extends AssociationByRepOrRefImpl<T> implements GeometryProperty<T> {
	
	public T getGeometry() {
		return super.getObject();
	}

	public boolean isSetGeometry() {
		return super.isSetObject();
	}

	public void setGeometry(T geometry) {
		super.setObject(geometry);
	}

	public void unsetGeometry() {
		super.unsetObject();
	}

	public GMLClass getGMLClass() {
		return GMLClass.GEOMETRY_PROPERTY;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new GeometryPropertyImpl<T>(), copyBuilder);
	}

	@SuppressWarnings("unchecked")
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		GeometryProperty<T> copy = (target == null) ? new GeometryPropertyImpl<T>() : (GeometryProperty<T>)target;
		return super.copyTo(copy, copyBuilder);
	}

}
