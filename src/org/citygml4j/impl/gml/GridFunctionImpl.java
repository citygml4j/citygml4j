package org.citygml4j.impl.gml;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.GridFunction;
import org.citygml4j.model.gml.SequenceRule;

public class GridFunctionImpl implements GridFunction {
	private SequenceRule sequenceRule;
	private List<Integer> startPoint;
	private Object parent;

	public GMLClass getGMLClass() {
		return GMLClass.GRIDFUNCTION;
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
	
	@SuppressWarnings("unchecked")
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		GridFunction copy = (target == null) ? new GridFunctionImpl() : (GridFunction)target;
		
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
		return copyTo(new GridFunctionImpl(), copyBuilder);
	}

}
