package org.citygml4j.model.citygml.relief;

import org.citygml4j.model.gml.coverage.RectifiedGridCoverage;
import org.citygml4j.model.gml.feature.FeatureProperty;

public interface GridProperty extends ReliefModuleComponent, FeatureProperty<RectifiedGridCoverage> {
	public RectifiedGridCoverage getRectifiedGridCoverage();
	public boolean isSetRectifiedGridCoverage();
	
	public void setRectifiedGridCoverage(RectifiedGridCoverage rectifiedGridCoverage);
	public void unsetRectifiedGridCoverage();
}
