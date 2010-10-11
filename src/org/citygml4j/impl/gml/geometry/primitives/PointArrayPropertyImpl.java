package org.citygml4j.impl.gml.geometry.primitives;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.geometry.GeometryArrayPropertyImpl;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.primitives.Point;
import org.citygml4j.model.gml.geometry.primitives.PointArrayProperty;

public class PointArrayPropertyImpl extends GeometryArrayPropertyImpl<Point> implements PointArrayProperty {
	
	public void addPoint(Point point) {
		super.addGeometry(point);
	}

	public List<Point> getPoint() {
		return super.getGeometry();
	}

	public boolean isSetPoint() {
		return super.isSetGeometry();
	}

	public void setPoint(List<Point> point) {
		super.setGeometry(point);
	}

	public void unsetPoint() {
		super.unsetGeometry();
	}

	public boolean unsetPoint(Point point) {
		return super.unsetGeometry(point);
	}

	public ModelType getModelType() {
		return ModelType.GML;
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.POINT_ARRAY_PROPERTY;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new PointArrayPropertyImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		PointArrayProperty copy = (target == null) ? new PointArrayPropertyImpl() : (PointArrayProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
