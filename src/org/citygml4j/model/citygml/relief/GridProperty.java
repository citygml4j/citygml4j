package org.citygml4j.model.citygml.relief;

import org.citygml4j.model.gml.Association;
import org.citygml4j.model.gml.RectifiedGridCoverage;

public interface GridProperty extends ReliefModuleComponent, Association<RectifiedGridCoverage> {
	public RectifiedGridCoverage getRectifiedGridCoverage();
	public boolean isSetRectifiedGridCoverage();
	
	public void setRectifiedGridCoverage(RectifiedGridCoverage rectifiedGridCoverage);
	public void unsetRectifiedGridCoverage();
}
