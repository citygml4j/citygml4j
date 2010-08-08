package org.citygml4j.model.gml;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface CoverageFunction extends GML, Child, Copyable {
	public StringOrRef getMappingRule();
	public GridFunction getGridFunction();	
	public boolean isSetMappingRule();
	public boolean isSetGridFunction();	
	
	public void setMappingRule(StringOrRef mappingRule);
	public void setGridFunction(GridFunction gridFunction);	
	public void unsetMappingRule();
	public void unsetGridFunction();
	
}
