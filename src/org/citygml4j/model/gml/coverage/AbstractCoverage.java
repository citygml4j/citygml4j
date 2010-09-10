package org.citygml4j.model.gml.coverage;

import org.citygml4j.model.gml.feature.AbstractFeature;

public interface AbstractCoverage extends AbstractFeature {
	// not fully implemented since CityGML only uses RectifiedGridCoverage
	// which is derived by restriction
	public RangeSet getRangeSet();
	public Integer getDimension();
	public boolean isSetRangeSet();
	public boolean isSetDimension();
	
	public void setRangeSet(RangeSet rangeSet);
	public void setDimension(Integer dimension);
	public void unsetRangeSet();
	public void unsetDimension();
}
