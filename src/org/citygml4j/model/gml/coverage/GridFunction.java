/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universitaet Berlin, Germany
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
 */
package org.citygml4j.model.gml.coverage;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.coverage.GridFunction;
import org.citygml4j.model.gml.coverage.SequenceRule;

public class GridFunction implements GML, Child, Copyable {
	private SequenceRule sequenceRule;
	private List<Integer> startPoint;
	private ModelObject parent;

	public ModelType getModelType() {
		return ModelType.GML;
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.GRID_FUNCTION;
	}

	public SequenceRule getSequenceRule() {
		return sequenceRule;
	}

	public List<Integer> getStartPoint() {
		if (startPoint == null)
			startPoint = new ArrayList<Integer>();
		
		return startPoint;
	}

	public boolean isSetSequenceRule() {
		return sequenceRule != null;
	}

	public boolean isSetStartPoint() {
		return startPoint != null && !startPoint.isEmpty();
	}

	public void setSequenceRule(SequenceRule sequenceRule) {
		if (sequenceRule != null)
			sequenceRule.setParent(this);
		
		this.sequenceRule = sequenceRule;
	}

	public void addStartPoint(Integer startPoint) {
		if (this.startPoint == null)
			this.startPoint = new ArrayList<Integer>();
		
		this.startPoint.add(startPoint);
	}

	public void setStartPoint(List<Integer> startPoint) {
		this.startPoint = startPoint;
	}

	public void unsetSequenceRule() {
		if (isSetSequenceRule())
			sequenceRule.unsetParent();
		
		sequenceRule = null;
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
