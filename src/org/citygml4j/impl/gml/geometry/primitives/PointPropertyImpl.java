package org.citygml4j.impl.gml.geometry.primitives;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.geometry.GeometryPropertyImpl;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.primitives.Point;
import org.citygml4j.model.gml.geometry.primitives.PointProperty;

public class PointPropertyImpl extends GeometryPropertyImpl<Point> implements PointProperty {

	public GMLClass getGMLClass() {
		return GMLClass.POINT_PROPERTY;
	}

	public Point getPoint() {
		return super.getGeometry();
	}

	public boolean isSetPoint() {
		return super.isSetGeometry();
	}

	public void setPoint(Point point) {
		super.setGeometry(point);
	}

	public void unsetPoint() {
		super.unsetGeometry();
	}
	
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		PointProperty copy = (target == null) ? new PointPropertyImpl() : (PointProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new PointPropertyImpl(), copyBuilder);
	}

}
