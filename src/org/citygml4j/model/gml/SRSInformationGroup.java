package org.citygml4j.model.gml;

import java.util.List;

public interface SRSInformationGroup extends GMLBase {
	public List<String> getAxisLabels();
	public List<String> getUomLabels();
	public boolean isSetAxisLabels();
	public boolean isSetUomLabels();

	public void setAxisLabels(List<String> axisLabels);
	public void addAxisLabel(String axisLabel);
	public void setUomLabels(List<String> uomLabels);
	public void addUomLabel(String uomLabel);
	public void unsetAxisLabels();
	public boolean unsetAxisLabels(String axisLabel);
	public void unsetUomLabels();
	public boolean unsetUomLabels(String uomLabel);
}
