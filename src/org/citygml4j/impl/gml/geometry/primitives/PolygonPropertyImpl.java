package org.citygml4j.impl.gml.geometry.primitives;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.geometry.GeometryPropertyImpl;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.primitives.Polygon;
import org.citygml4j.model.gml.geometry.primitives.PolygonProperty;

public class PolygonPropertyImpl extends GeometryPropertyImpl<Polygon> implements PolygonProperty {
	
	public Polygon getPolygon() {
		return super.getGeometry();
	}

	public boolean isSetPolygon() {
		return super.isSetGeometry();
	}

	public void setPolygon(Polygon polygon) {
		super.setGeometry(polygon);
	}

	public void unsetPolygon() {
		super.unsetGeometry();
	}

	public GMLClass getGMLClass() {
		return GMLClass.POLYGON_PROPERTY;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new PolygonPropertyImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		PolygonProperty copy = (target == null) ? new PolygonPropertyImpl() : (PolygonProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
