package org.citygml4j.impl.gml;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.GridEnvelope;
import org.citygml4j.model.gml.GridLimits;

public class GridLimitsImpl implements GridLimits {
	private GridEnvelope gridEnvelope;
	private Object parent;
	
	public GMLClass getGMLClass() {
		return GMLClass.GRIDLIMITS;
	}

	public GridEnvelope getGridEnvelope() {
		return gridEnvelope;
	}

	public boolean isSetGridEnvelope() {
		return gridEnvelope != null;
	}

	public void setGridEnvelope(GridEnvelope gridEnvelope) {
		if (gridEnvelope != null)
			gridEnvelope.setParent(this);
		
		this.gridEnvelope = gridEnvelope;
	}

	public void unsetGridEnvelope() {
		if (isSetGridEnvelope())
			gridEnvelope.unsetParent();
		
		gridEnvelope = null;
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
	
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		GridLimits copy = (target == null) ? new GridLimitsImpl() : (GridLimits)target;
		
		if (isSetGridEnvelope()) {
			copy.setGridEnvelope((GridEnvelope)copyBuilder.copy(gridEnvelope));
			if (copy.getGridEnvelope() == gridEnvelope)
				gridEnvelope.setParent(this);
		}
		
		copy.unsetParent();
		
		return copy;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new GridLimitsImpl(), copyBuilder);
	}

}
