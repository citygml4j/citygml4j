package org.citygml4j.impl.jaxb.gml._3_1_1;

import org.citygml4j.jaxb.gml._3_1_1.DirectPositionType;
import org.citygml4j.jaxb.gml._3_1_1.PointPropertyType;
import org.citygml4j.model.gml.DirectPosition;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.GeometricPositionGroup;
import org.citygml4j.model.gml.PointProperty;

public class GeometricPositionGroupImpl extends GMLBaseImpl implements GeometricPositionGroup {
	private DirectPositionType posType;
	private PointPropertyType pointPropertyType;
		
	public GeometricPositionGroupImpl(DirectPosition pos) {
		posType = ((DirectPositionImpl)pos).getJAXBObject();
		pointPropertyType = null;
	}
	
	public GeometricPositionGroupImpl(PointProperty pointProperty) {
		pointPropertyType = ((PointPropertyImpl)pointProperty).getJAXBObject();
		posType = null;
	}
	
	public GeometricPositionGroupImpl(DirectPositionType posType) {
		this.posType = posType;
		pointPropertyType = null;
	}
	
	public GeometricPositionGroupImpl(PointPropertyType pointPropertyType) {
		this.pointPropertyType = pointPropertyType;
		posType = null;
	}
	
	@Override
	public GMLClass getGMLClass() {
		return GMLClass.GEOMETRICPOSITIONGROUP;
	}

	@Override
	public Object getJAXBObject() {
		return (posType != null) ? posType : pointPropertyType;		
	}

	public PointProperty getPointProperty() {
		if (pointPropertyType != null)
			return new PointPropertyImpl(pointPropertyType);
		
		return null;
	}

	public DirectPosition getPos() {
		if (posType != null)
			return new DirectPositionImpl(posType);
		
		return null;
	}

	public void setPointProperty(PointProperty pointProperty) {
		pointPropertyType = ((PointPropertyImpl)pointProperty).getJAXBObject();
		posType = null;
	}

	public void setPos(DirectPosition pos) {
		posType = ((DirectPositionImpl)pos).getJAXBObject();
		pointPropertyType = null;
	}

	public boolean isSetPointProperty() {
		return pointPropertyType != null;
	}

	public boolean isSetPos() {
		return posType != null;
	}

	public void unsetPointProperty() {
		pointPropertyType = null;
	}

	public void unsetPos() {
		posType = null;
	}

}
