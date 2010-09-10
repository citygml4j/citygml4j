package org.citygml4j.impl.gml.geometry.primitives;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.geometry.GeometryPropertyImpl;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.primitives.AbstractGeometricPrimitive;
import org.citygml4j.model.gml.geometry.primitives.GeometricPrimitiveProperty;

public class GeometricPrimitivePropertyImpl extends GeometryPropertyImpl<AbstractGeometricPrimitive> implements GeometricPrimitiveProperty {

	public AbstractGeometricPrimitive getGeometricPrimitive() {
		return super.getGeometry();
	}

	public boolean isSetGeometricPrimitive() {
		return super.isSetGeometry();
	}

	public void setGeometricPrimitive(AbstractGeometricPrimitive abstractGeometricPrimitive) {
		super.setGeometry(abstractGeometricPrimitive);
	}

	public void unsetGeometricPrimitive() {
		super.unsetGeometry();
	}

	public GMLClass getGMLClass() {
		return GMLClass.GEOMETRIC_PRIMITIVE_PROPERTY;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new GeometricPrimitivePropertyImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		GeometricPrimitiveProperty copy = (target == null) ? new GeometricPrimitivePropertyImpl() : (GeometricPrimitiveProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
