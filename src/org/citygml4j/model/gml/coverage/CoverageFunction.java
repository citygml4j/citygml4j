package org.citygml4j.model.gml.coverage;

import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.base.StringOrRef;


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
