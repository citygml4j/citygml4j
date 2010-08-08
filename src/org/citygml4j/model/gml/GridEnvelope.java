package org.citygml4j.model.gml;

import java.util.List;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface GridEnvelope extends GML, Child, Copyable {
	public List<Integer> getLow();
	public List<Integer> getHigh();
	public boolean isSetLow();
	public boolean isSetHigh();
	
	public void addLow(Integer low);
	public void addHigh(Integer high);
	public void setLow(List<Integer> low);
	public void setHigh(List<Integer> high);
	public void unsetLow();
	public void unsetHigh();
}
