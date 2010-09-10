package org.citygml4j.impl.gml.geometry.aggregates;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.geometry.GeometryPropertyImpl;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.aggregates.MultiPolygon;
import org.citygml4j.model.gml.geometry.aggregates.MultiPolygonProperty;

public class MultiPolygonPropertyImpl extends GeometryPropertyImpl<MultiPolygon> implements MultiPolygonProperty {
	
	public MultiPolygon getMultiPolygon() {
		return super.getGeometry();
	}

	public boolean isSetMultiPolygon() {
		return super.isSetGeometry();
	}

	public void setMultiPolygon(MultiPolygon multiPolygon) {
		super.setGeometry(multiPolygon);
	}

	public void unsetMultiPolygon() {
		super.unsetGeometry();
	}

	public GMLClass getGMLClass() {
		return GMLClass.MULTI_POLYGON_PROPERTY;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new MultiPolygonPropertyImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		MultiPolygonProperty copy = (target == null) ? new MultiPolygonPropertyImpl() : (MultiPolygonProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
