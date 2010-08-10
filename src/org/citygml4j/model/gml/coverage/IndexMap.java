package org.citygml4j.model.gml.coverage;

import java.util.List;


public interface IndexMap extends GridFunction {
	public List<Integer> getLookUpTable();
	public boolean isSetLookUpTable();
	
	public void addLookUpIndex(Integer lookUpIndex);
	public void setLookUpTable(List<Integer> lookUpTable);
	public void unsetLookUpTable();
}
