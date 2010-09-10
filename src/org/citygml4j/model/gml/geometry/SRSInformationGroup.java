package org.citygml4j.model.gml.geometry;

import java.util.List;

import org.citygml4j.model.gml.GML;


public interface SRSInformationGroup extends GML {
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
