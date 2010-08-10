package org.citygml4j.model.gml.coverage;


public interface RectifiedGridCoverage extends AbstractDiscreteCoverage {
	public RectifiedGridDomain getRectifiedGridDomain();
	public boolean isSetRectifiedGridDomain();
	
	public void setRectifiedGridDomain(RectifiedGridDomain rectifiedGridDomain);
	public void unsetRectifiedGridDomain();
}
