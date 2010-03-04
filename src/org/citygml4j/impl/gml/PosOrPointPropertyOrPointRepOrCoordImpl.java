package org.citygml4j.impl.gml;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.Coord;
import org.citygml4j.model.gml.DirectPosition;
import org.citygml4j.model.gml.PointProperty;
import org.citygml4j.model.gml.PointRep;
import org.citygml4j.model.gml.PosOrPointPropertyOrPointRepOrCoord;

public class PosOrPointPropertyOrPointRepOrCoordImpl implements PosOrPointPropertyOrPointRepOrCoord {
	private DirectPosition pos;
	private PointProperty pointProperty;
	private PointRep pointRep;
	private Coord coord;
	private Object parent;
	
	public PosOrPointPropertyOrPointRepOrCoordImpl() {
		
	}
	
	public PosOrPointPropertyOrPointRepOrCoordImpl(DirectPosition pos) {
		setPos(pos);
	}
	
	public PosOrPointPropertyOrPointRepOrCoordImpl(PointProperty pointProperty) {
		setPointProperty(pointProperty);
	}
	
	public PosOrPointPropertyOrPointRepOrCoordImpl(PointRep pointRep) {
		setPointRep(pointRep);
	}
	
	public PosOrPointPropertyOrPointRepOrCoordImpl(Coord coord) {
		setCoord(coord);
	}
	
	public PointProperty getPointProperty() {
		return pointProperty;
	}

	public PointRep getPointRep() {
		return pointRep;
	}

	public DirectPosition getPos() {
		return pos;
	}

	public Coord getCoord() {
		return coord;
	}

	public boolean isSetPointProperty() {
		return pointProperty != null;
	}

	public boolean isSetPointRep() {
		return pointRep != null;
	}

	public boolean isSetPos() {
		return pos != null;
	}

	public boolean isSetCoord() {
		return coord != null;
	}

	public void setPos(DirectPosition pos) {
		if (pos != null)
			pos.setParent(this);
		
		this.pos = pos;
		unsetPointProperty();
		unsetPointRep();
		unsetCoord();
	}

	public void setPointProperty(PointProperty pointProperty) {
		if (pointProperty != null)
			pointProperty.setParent(this);
		
		this.pointProperty = pointProperty;
		unsetPointRep();
		unsetPos();
		unsetCoord();
	}

	public void setPointRep(PointRep pointRep) {
		if (pointRep != null)
			pointRep.setParent(this);
		
		this.pointRep = pointRep;
		unsetPointProperty();
		unsetPos();
		unsetCoord();
	}

	public void setCoord(Coord coord) {
		if (coord != null)
			coord.setParent(this);
		
		this.coord = coord;
		unsetPointProperty();
		unsetPointRep();
		unsetPos();
	}

	public List<Double> toList3d() {
		List<Double> tmp = new ArrayList<Double>();

		if (isSetPos())
			tmp.addAll(pos.toList3d());
		else if (isSetPointProperty() && pointProperty.isSetPoint())
			tmp.addAll(pointProperty.getPoint().toList3d());
		else if (isSetPointRep() && pointRep.isSetPoint())
			tmp.addAll(pointRep.getPoint().toList3d());
		else if (isSetCoord())
			tmp.addAll(coord.toList3d());

		return tmp;
	}

	public void unsetPointProperty() {
		if (isSetPointProperty())
			pointProperty.unsetParent();
		
		pointProperty = null;
	}

	public void unsetPointRep() {
		if (isSetPointRep())
			pointRep.unsetParent();
		
		pointRep = null;
	}

	public void unsetPos() {
		if (isSetPos())
			pos.unsetParent();
		
		pos = null;
	}
	
	public void unsetCoord() {
		if (isSetCoord())
			coord.unsetParent();
		
		coord = null;
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
		return copyTo(new PosOrPointPropertyOrPointRepOrCoordImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		PosOrPointPropertyOrPointRepOrCoord copy = (target == null) ? new PosOrPointPropertyOrPointRepOrCoordImpl() : (PosOrPointPropertyOrPointRepOrCoord)target;
		
		if (isSetPointProperty()) {
			copy.setPointProperty((PointProperty)copyBuilder.copy(pointProperty));
			if (copy.getPointProperty() == pointProperty)
				pointProperty.setParent(this);
		}
		
		if (isSetPointRep()) {
			copy.setPointRep((PointRep)copyBuilder.copy(pointRep));
			if (copy.getPointRep() == pointRep)
				pointRep.setParent(this);
		}
		
		if (isSetPos()) {
			copy.setPos((DirectPosition)copyBuilder.copy(pos));
			if (copy.getPos() == pos)
				pos.setParent(this);
		}
		
		if (isSetCoord()) {
			copy.setCoord((Coord)copyBuilder.copy(coord));
			if (copy.getCoord() == coord)
				coord.setParent(this);
		}
		
		copy.unsetParent();
		
		return copy;
	}

}
