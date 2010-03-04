package org.citygml4j.impl.gml;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.commons.child.ChildList;
import org.citygml4j.model.gml.ControlPoint;
import org.citygml4j.model.gml.DirectPositionList;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.GeometricPositionGroup;

public class ControlPointImpl implements ControlPoint {
	private DirectPositionList posList;
	private List<GeometricPositionGroup> geometricPositionGroup;
	private Object parent;
	
	public void addGeometricPositionGroup(GeometricPositionGroup geometricPositionGroup) {
		if (this.geometricPositionGroup == null)
			this.geometricPositionGroup = new ChildList<GeometricPositionGroup>(this);
		
		this.geometricPositionGroup.add(geometricPositionGroup);
		unsetPosList();
	}

	public List<GeometricPositionGroup> getGeometricPositionGroup() {
		if (geometricPositionGroup == null)
			geometricPositionGroup = new ChildList<GeometricPositionGroup>(this);
		
		return geometricPositionGroup;
	}

	public DirectPositionList getPosList() {
		return posList;
	}

	public boolean isSetGeometricPositionGroup() {
		return geometricPositionGroup != null && !geometricPositionGroup.isEmpty();
	}

	public boolean isSetPosList() {
		return posList != null;
	}

	public void setGeometricPositionGroup(List<GeometricPositionGroup> geometricPositionGroup) {
		this.geometricPositionGroup = new ChildList<GeometricPositionGroup>(this, geometricPositionGroup);
		unsetPosList();
	}

	public void setPosList(DirectPositionList posList) {
		if (posList != null)
			posList.setParent(this);
		
		this.posList = posList;
		unsetGeometricPositionGroup();
	}

	public List<Double> toList3d() {
		List<Double> tmp = new ArrayList<Double>();
		
		if (isSetPosList())
			tmp.addAll(posList.toList3d());
		else if (isSetGeometricPositionGroup())
			for (GeometricPositionGroup part : geometricPositionGroup)
				tmp.addAll(part.toList3d());
		
		return tmp;
	}

	public void unsetGeometricPositionGroup() {
		if (isSetGeometricPositionGroup())
			geometricPositionGroup.clear();
		
		geometricPositionGroup = null;
	}

	public boolean unsetGeometricPositionGroup(GeometricPositionGroup geometricPositionGroup) {
		return isSetGeometricPositionGroup() ? this.geometricPositionGroup.remove(geometricPositionGroup) : false;
	}

	public void unsetPosList() {
		if (isSetPosList())
			posList.unsetParent();
		
		posList = null;
	}

	public GMLClass getGMLClass() {
		return GMLClass.CONTROLPOINT;
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
		return copyTo(new ControlPointImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		ControlPoint copy = (target == null) ? new ControlPointImpl() : (ControlPoint)target;
		
		if (isSetGeometricPositionGroup()) {
			for (GeometricPositionGroup part : geometricPositionGroup) {
				GeometricPositionGroup copyPart = (GeometricPositionGroup)copyBuilder.copy(part);
				copy.addGeometricPositionGroup(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetPosList()) {
			copy.setPosList((DirectPositionList)copyBuilder.copy(posList));
			if (copy.getPosList() == posList)
				posList.setParent(this);
		}
		
		copy.unsetParent();
		
		return copy;
	}

}
