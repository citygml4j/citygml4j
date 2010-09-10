package org.citygml4j.model.gml.coverage;

import org.citygml4j.model.gml.grids.RectifiedGrid;

public interface RectifiedGridDomain extends DomainSet<RectifiedGrid> {
	public RectifiedGrid getRectifiedGrid();
	public boolean isSetRectifiedGrid();
	
	public void setRectifiedGrid(RectifiedGrid rectifiedGrid);
	public void unsetRectifiedGrid();
}
