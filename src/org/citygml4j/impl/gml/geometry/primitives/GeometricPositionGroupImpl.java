package org.citygml4j.impl.gml.geometry.primitives;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.primitives.DirectPosition;
import org.citygml4j.model.gml.geometry.primitives.GeometricPositionGroup;
import org.citygml4j.model.gml.geometry.primitives.PointProperty;

public class GeometricPositionGroupImpl implements GeometricPositionGroup {
	private DirectPosition pos;
	private PointProperty pointProperty;
	private ModelObject parent;
	
	public GeometricPositionGroupImpl() {
		
	}
	
	public GeometricPositionGroupImpl(DirectPosition pos) {
		setPos(pos);
	}
	
	public GeometricPositionGroupImpl(PointProperty pointProperty) {
		setPointProperty(pointProperty);
	}
	
	public PointProperty getPointProperty() {
		return pointProperty;
	}

	public DirectPosition getPos() {
		return pos;
	}

	public boolean isSetPointProperty() {
		return pointProperty != null;
	}

	public boolean isSetPos() {
		return pos != null;
	}

	public void setPointProperty(PointProperty pointProperty) {
		if (pointProperty != null)
			pointProperty.setParent(this);
		
		this.pointProperty = pointProperty;
		unsetPos();
	}

	public void setPos(DirectPosition pos) {
		if (pos != null)
			pos.setParent(this);
		
		this.pos = pos;
		unsetPointProperty();
	}

	public void unsetPointProperty() {
		if (isSetPointProperty())
			pointProperty.unsetParent();
		
		pointProperty = null;
	}

	public void unsetPos() {
		if (isSetPos())
			pos.unsetParent();
		
		pos = null;
	}

	public ModelType getModelType() {
		return ModelType.GML;
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.GEOMETRIC_POSITION_GROUP;
	}

	public ModelObject getParent() {
		return parent;
	}

	public void setParent(ModelObject parent) {
		this.parent = parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public List<Double> toList3d() {
		List<Double> tmp = new ArrayList<Double>();

		if (isSetPos())
			tmp.addAll(pos.toList3d());
		else if (isSetPointProperty() && pointProperty.isSetPoint())
			tmp.addAll(pointProperty.getPoint().toList3d());

		return tmp;
	}

	public void unsetParent() {
		parent = null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new GeometricPositionGroupImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		GeometricPositionGroup copy = (target == null) ? new GeometricPositionGroupImpl() : (GeometricPositionGroup)target;
		
		if (isSetPointProperty()) {
			copy.setPointProperty((PointProperty)copyBuilder.copy(pointProperty));
			if (copy.getPointProperty() == pointProperty)
				pointProperty.setParent(this);
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
