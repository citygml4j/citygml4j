package org.citygml4j.model.gml.grids;

import java.util.List;

import org.citygml4j.model.gml.geometry.AbstractGeometry;

public interface Grid extends AbstractGeometry {
	public GridLimits getLimits();
	public List<String> getAxisName();
	public Integer getDimension();
	public boolean isSetLimits();
	public boolean isSetAxisName();
	public boolean isSetDimension();
	
	public void setLimits(GridLimits limits);
	public void addAxisName(String axisName);
	public void setAxisName(List<String> axisName);
	public void setDimension(Integer dimension);
	public void unsetLimits();
	public void unsetAxisName();
}
