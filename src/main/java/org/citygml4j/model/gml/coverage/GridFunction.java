/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2023 Claus Nagel <claus.nagel@gmail.com>
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
import org.citygml4j.model.common.base.ModelObjects;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.GMLClass;

import java.util.ArrayList;
import java.util.List;

public class GridFunction implements GML, Child, Copyable {
	private SequenceRule sequenceRule;
	private List<Integer> startPoint;
	private ModelObject parent;

	public GMLClass getGMLClass() {
		return GMLClass.GRID_FUNCTION;
	}

	public SequenceRule getSequenceRule() {
		return sequenceRule;
	}

	public List<Integer> getStartPoint() {
		if (startPoint == null)
			startPoint = new ArrayList<>();
		
		return startPoint;
	}

	public boolean isSetSequenceRule() {
		return sequenceRule != null;
	}

	public boolean isSetStartPoint() {
		return startPoint != null && !startPoint.isEmpty();
	}

	public void setSequenceRule(SequenceRule sequenceRule) {
		this.sequenceRule = ModelObjects.setParent(sequenceRule, this);
	}

	public void addStartPoint(Integer startPoint) {
		getStartPoint().add(startPoint);
	}

	public void setStartPoint(List<Integer> startPoint) {
		this.startPoint = startPoint;
	}

	public void unsetSequenceRule() {
		sequenceRule = ModelObjects.setNull(sequenceRule);
	}

	public void unsetStartPoint() {
		startPoint = null;
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
	
	@SuppressWarnings("unchecked")
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		GridFunction copy = (target == null) ? new GridFunction() : (GridFunction)target;
		
		if (isSetSequenceRule()) {
			copy.setSequenceRule((SequenceRule)copyBuilder.copy(sequenceRule));
			if (copy.getSequenceRule() == sequenceRule)
				sequenceRule.setParent(this);
		}
		
		if (isSetStartPoint())
			copy.setStartPoint((List<Integer>)copyBuilder.copy(startPoint));					
		
		copy.unsetParent();
		
		return copy;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new GridFunction(), copyBuilder);
	}

}
