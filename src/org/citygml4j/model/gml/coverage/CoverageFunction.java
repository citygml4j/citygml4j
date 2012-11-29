/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2012
 * Institute for Geodesy and Geoinformation Science
 * Technische Universität Berlin, Germany
 * http://www.igg.tu-berlin.de/
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 * 
 * $Id$
 */
package org.citygml4j.model.gml.coverage;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelType;
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
