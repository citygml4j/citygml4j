package org.citygml4j.impl.gml.coverage;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.base.StringOrRef;
import org.citygml4j.model.gml.coverage.CoverageFunction;
import org.citygml4j.model.gml.coverage.GridFunction;

public class CoverageFunctionImpl implements CoverageFunction {
	private StringOrRef mappingRule;
	private GridFunction gridFunction;
	private ModelObject parent;
	
	public CoverageFunctionImpl() {
		
	}
	
	public CoverageFunctionImpl(StringOrRef mappingRule) {
		setMappingRule(mappingRule);
	}
	
	public CoverageFunctionImpl(GridFunction gridFunction) {
		setGridFunction(gridFunction);
	}

	public ModelType getModelType() {
		return ModelType.GML;
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.COVERAGE_FUNCTION;
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
	
	public ModelObject getParent() {
		return parent;
	}

	public void setParent(ModelObject parent) {
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
