package org.citygml4j.impl.gml;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.model.gml.Coord;
import org.citygml4j.model.gml.Coordinates;
import org.citygml4j.model.gml.DirectPosition;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.Point;
import org.citygml4j.visitor.GMLFunction;
import org.citygml4j.visitor.GMLVisitor;
import org.citygml4j.visitor.GeometryFunction;
import org.citygml4j.visitor.GeometryVisitor;

public class PointImpl extends AbstractGeometricPrimitiveImpl implements Point {
	private DirectPosition pos;
	private Coordinates coordinates;
	private Coord coord;

	public BoundingBox calcBoundingBox() {
		BoundingBox bbox = new BoundingBox();
		List<Double> points = toList3d();

		for (int i = 0; i < points.size(); i += 3) {
			bbox.updateLowerCorner(points.get(i), points.get(i + 1), points.get(i + 2));
			bbox.updateUpperCorner(points.get(i), points.get(i + 1), points.get(i + 2));
		}
		
		if (bbox.getLowerCorner().isEqual(Double.MAX_VALUE) && 
				bbox.getUpperCorner().isEqual(-Double.MAX_VALUE))
			return null;
		else
			return bbox;
	}

	public GMLClass getGMLClass() {
		return GMLClass.POINT;
	}
	
	public Coord getCoord() {
		return coord;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public DirectPosition getPos() {
		return pos;
	}

	public boolean isSetCoord() {
		return coord != null;
	}

	public boolean isSetCoordinates() {
		return coordinates != null;
	}

	public boolean isSetPos() {
		return pos != null;
	}

	public void setCoord(Coord coord) {
		if (coord != null)
			coord.setParent(this);
		
		this.coord = coord;
	}

	public void setCoordinates(Coordinates coordinates) {
		if (coordinates != null)
			coordinates.setParent(this);
		
		this.coordinates = coordinates;
	}

	public void setPos(DirectPosition pos) {
		if (pos != null)
			pos.setParent(this);
		
		this.pos = pos;
	}

	public List<Double> toList3d() {
		List<Double> tmp = new ArrayList<Double>();

		if (isSetPos())
			tmp.addAll(pos.toList3d());
		else if (isSetCoord())
			tmp.addAll(coord.toList3d());
		else if (isSetCoordinates())
			tmp.addAll(coordinates.toList3d());

		return tmp;
	}

	public void unsetCoord() {
		if (isSetCoord())
			coord.unsetParent();
		
		coord = null;
	}

	public void unsetCoordinates() {
		if (isSetCoordinates())
			coordinates.unsetParent();
		
		coordinates = null;
	}

	public void unsetPos() {
		if (isSetPos())
			pos.unsetParent();
		
		pos = null;
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Point copy = (target == null) ? new PointImpl() : (Point)target;		
		super.copyTo(copy, copyBuilder);
		
		if (isSetPos()) {
			copy.setPos((DirectPosition)copyBuilder.copy(pos));
			if (copy.getPos() == pos)
				pos.setParent(this);
		}
		
		if (isSetCoordinates()) {
			copy.setCoordinates((Coordinates)copyBuilder.copy(coordinates));
			if (copy.getCoordinates() == coordinates)
				coordinates.setParent(this);
		}
		
		if (isSetCoord()) {
			copy.setCoord((Coord)copyBuilder.copy(coord));
			if (copy.getCoord() == coord)
				coord.setParent(this);
		}
		
		return copy;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new PointImpl(), copyBuilder);
	}
	
	public void visit(GeometryVisitor visitor) {
		visitor.accept(this);
	}

	public <T> T apply(GeometryFunction<T> visitor) {
		return visitor.accept(this);
	}
	
	public void visit(GMLVisitor visitor) {
		visitor.accept(this);
	}
	
	public <T> T apply(GMLFunction<T> visitor) {
		return visitor.accept(this);
	}
	
}
