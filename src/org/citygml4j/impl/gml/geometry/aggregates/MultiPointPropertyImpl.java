package org.citygml4j.impl.gml.geometry.aggregates;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.geometry.GeometryPropertyImpl;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.aggregates.MultiPoint;
import org.citygml4j.model.gml.geometry.aggregates.MultiPointProperty;

public class MultiPointPropertyImpl extends GeometryPropertyImpl<MultiPoint> implements MultiPointProperty {

	public MultiPoint getMultiPoint() {
		return super.getGeometry();
	}

	public boolean isSetMultiPoint() {
		return super.isSetGeometry();
	}

	public void setMultiPoint(MultiPoint multiPoint) {
		super.setGeometry(multiPoint);
	}

	public void unsetMultiPoint() {
		super.unsetGeometry();
	}

	public GMLClass getGMLClass() {
		return GMLClass.MULTI_POINT_PROPERTY;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new MultiPointPropertyImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		MultiPointProperty copy = (target == null) ? new MultiPointPropertyImpl() : (MultiPointProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
