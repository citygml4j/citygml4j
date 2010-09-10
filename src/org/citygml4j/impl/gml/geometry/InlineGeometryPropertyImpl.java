package org.citygml4j.impl.gml.geometry;

import org.citygml4j.impl.gml.base.AssociationByRepImpl;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.InlineGeometryProperty;

public abstract class InlineGeometryPropertyImpl<T extends AbstractGeometry> extends AssociationByRepImpl<T> implements InlineGeometryProperty<T> {
	
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
		return GMLClass.INLINE_GEOMETRY_PROPERTY;
	}
	
}
