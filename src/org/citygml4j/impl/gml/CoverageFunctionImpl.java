package org.citygml4j.impl.gml;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.CoverageFunction;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.GridFunction;
import org.citygml4j.model.gml.StringOrRef;

public class CoverageFunctionImpl implements CoverageFunction {
	private StringOrRef mappingRule;
	private GridFunction gridFunction;
	private Object parent;
	
	public CoverageFunctionImpl() {
		
	}
	
	public CoverageFunctionImpl(StringOrRef mappingRule) {
		setMappingRule(mappingRule);
	}
	
	public CoverageFunctionImpl(GridFunction gridFunction) {
		setGridFunction(gridFunction);
	}

	public GMLClass getGMLClass() {
		return GMLClass.COVERAGEFUNCTION;
	}

	public StringOrRef getMappingRule() {
		return mappingRule;
	}

	public GridFunction getGridFunction() {
		return gridFunction;
	}

	public boolean isSetMappingRule() {
		return mappingRule != null;
	}

	public boolean isSetGridFunction() {
		return gridFunction != null;
	}

	public void setMappingRule(StringOrRef mappingRule) {
		if (mappingRule != null)
			mappingRule.setParent(this);
		
		this.mappingRule = mappingRule;
		
		unsetGridFunction();
	}

	public void setGridFunction(GridFunction gridFunction) {
		if (gridFunction != null)
			gridFunction.setParent(this);
		
		this.gridFunction = gridFunction;
		
		unsetMappingRule();
	}

	public void unsetMappingRule() {
		if (isSetMappingRule())
			mappingRule.unsetParent();
		
		mappingRule = null;
	}

	public void unsetGridFunction() {
		if (isSetGridFunction())
			gridFunction.unsetParent();
		
		gridFunction = null;
	}
	
	public Object getParent() {
		return parent;
	}

	public void setParent(Object parent) {
		this.parent = parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public void unsetParent() {
		parent = null;
	}
	
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		CoverageFunction copy = (target == null) ? new CoverageFunctionImpl() : (CoverageFunction)target;
		
		if (isSetMappingRule()) {
			copy.setMappingRule((StringOrRef)copyBuilder.copy(mappingRule));
			if (copy.getMappingRule() == mappingRule)
				mappingRule.setParent(this);
		}
		
		if (isSetGridFunction()) {
			copy.setGridFunction((GridFunction)copyBuilder.copy(gridFunction));
			if (copy.getGridFunction() == gridFunction)
				gridFunction.setParent(this);
		}
		
		copy.unsetParent();
		
		return copy;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new CoverageFunctionImpl(), copyBuilder);
	}

}
