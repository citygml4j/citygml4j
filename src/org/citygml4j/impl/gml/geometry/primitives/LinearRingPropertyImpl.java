package org.citygml4j.impl.gml.geometry.primitives;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.geometry.InlineGeometryPropertyImpl;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.primitives.LinearRing;
import org.citygml4j.model.gml.geometry.primitives.LinearRingProperty;

public class LinearRingPropertyImpl extends InlineGeometryPropertyImpl<LinearRing> implements LinearRingProperty {
	
	public ModelType getModelType() {
		return ModelType.GML;
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.LINEAR_RING_PROPERTY;
	}

	public LinearRing getLinearRing() {
		return super.getGeometry();
	}

	public boolean isSetLinearRing() {
		return super.isSetGeometry();
	}

	public void setLinearRing(LinearRing linearRing) {
		super.setGeometry(linearRing);
	}

	public void unsetLinearRing() {
		super.unsetGeometry();
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		LinearRingProperty copy = (target == null) ? new LinearRingPropertyImpl() : (LinearRingProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new LinearRingPropertyImpl(), copyBuilder);
	}
	
}
