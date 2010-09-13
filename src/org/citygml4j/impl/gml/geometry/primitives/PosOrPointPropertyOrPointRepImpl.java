package org.citygml4j.impl.gml.geometry.primitives;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.primitives.DirectPosition;
import org.citygml4j.model.gml.geometry.primitives.PointProperty;
import org.citygml4j.model.gml.geometry.primitives.PointRep;
import org.citygml4j.model.gml.geometry.primitives.PosOrPointPropertyOrPointRep;

public class PosOrPointPropertyOrPointRepImpl implements PosOrPointPropertyOrPointRep {
	private DirectPosition pos;
	private PointProperty pointProperty;
	private PointRep pointRep;
	private Object parent;
	
	public PosOrPointPropertyOrPointRepImpl() {
		
	}
	
	public PosOrPointPropertyOrPointRepImpl(DirectPosition pos) {
		setPos(pos);
	}
	
	public PosOrPointPropertyOrPointRepImpl(PointProperty pointProperty) {
		setPointProperty(pointProperty);
	}
	
	public PosOrPointPropertyOrPointRepImpl(PointRep pointRep) {
		setPointRep(pointRep);
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

	public boolean isSetPointProperty() {
		return pointProperty != null;
	}

	public boolean isSetPointRep() {
		return pointRep != null;
	}

	public boolean isSetPos() {
		return pos != null;
	}

	public void setPos(DirectPosition pos) {
		if (pos != null)
			pos.setParent(this);
		
		this.pos = pos;
		unsetPointProperty();
		unsetPointRep();
	}

	public void setPointProperty(PointProperty pointProperty) {
		if (pointProperty != null)
			pointProperty.setParent(this);
		
		this.pointProperty = pointProperty;
		unsetPointRep();
		unsetPos();
	}

	public void setPointRep(PointRep pointRep) {
		if (pointRep != null)
			pointRep.setParent(this);
		
		this.pointRep = pointRep;
		unsetPointProperty();
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

	public ModelType getModelType() {
		return ModelType.GML;
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.POS_OR_POINT_PROPERTY_OR_POINT_REP;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new PosOrPointPropertyOrPointRepImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		PosOrPointPropertyOrPointRep copy = (target == null) ? new PosOrPointPropertyOrPointRepImpl() : (PosOrPointPropertyOrPointRep)target;
		
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
		
		copy.unsetParent();
		
		return copy;
	}

}
