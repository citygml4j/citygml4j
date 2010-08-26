package org.citygml4j.model.gml.grids;

import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;


public interface GridLimits extends GML, Child, Copyable {
	public GridEnvelope getGridEnvelope();
	public boolean isSetGridEnvelope();
	
	public void setGridEnvelope(GridEnvelope gridEnvelope);
	public void unsetGridEnvelope();
}
