package org.citygml4j.model.gml;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface GridLimits extends GML, Child, Copyable {
	public GridEnvelope getGridEnvelope();
	public boolean isSetGridEnvelope();
	
	public void setGridEnvelope(GridEnvelope gridEnvelope);
	public void unsetGridEnvelope();
}
