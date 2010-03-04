package org.citygml4j.impl.gml;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.commons.child.ChildList;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.Point;
import org.citygml4j.model.gml.PointArrayProperty;

public class PointArrayPropertyImpl implements PointArrayProperty {
	private List<Point> point;
	private Object parent;
	
	public void addPoint(Point point) {
		if (this.point == null)
			this.point = new ChildList<Point>(this);
		
		this.point.add(point);
	}

	public List<Point> getPoint() {
		if (point == null)
			point = new ChildList<Point>(this);
		
		return point;
	}

	public boolean isSetPoint() {
		return point != null && !point.isEmpty();
	}

	public void setPoint(List<Point> point) {
		this.point = new ChildList<Point>(this, point);
	}

	public void unsetPoint() {
		if (isSetPoint())
			point.clear();
		
		point = null;
	}

	public boolean unsetPoint(Point point) {
		return isSetPoint() ? this.point.remove(point) : false;
	}

	public GMLClass getGMLClass() {
		return GMLClass.POINTARRAYPROPERTY;
	}

	public Object getParent() {
		return parent;
	}

	public void setParent(Object parent) {
		this.parent = parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public void unsetParent() {
		parent = null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new PointArrayPropertyImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		PointArrayProperty copy = (target == null) ? new PointArrayPropertyImpl() : (PointArrayProperty)target;
		
		if (isSetPoint()) {
			for (Point part : point) {
				Point copyPart = (Point)copyBuilder.copy(part);
				copy.addPoint(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		copy.unsetParent();
		
		return copy;
	}

}
