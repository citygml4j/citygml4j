/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.citygml4j.model.gml.coverage;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.base.StringOrRef;

public class CoverageFunction implements GML, Child, Copyable {
	private StringOrRef mappingRule;
	private GridFunction gridFunction;
	private ModelObject parent;
	
	public CoverageFunction() {
		
	}
	
	public CoverageFunction(StringOrRef mappingRule) {
		setMappingRule(mappingRule);
	}
	
	public CoverageFunction(GridFunction gridFunction) {
		setGridFunction(gridFunction);
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
		CoverageFunction copy = (target == null) ? new CoverageFunction() : (CoverageFunction)target;
		
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
		return copyTo(new CoverageFunction(), copyBuilder);
	}

}
