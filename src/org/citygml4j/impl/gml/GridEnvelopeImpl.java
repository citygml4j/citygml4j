package org.citygml4j.impl.gml;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.GridEnvelope;

public class GridEnvelopeImpl implements GridEnvelope {
	private List<Integer> low;
	private List<Integer> high;
	private Object parent;
	
	public GMLClass getGMLClass() {
		return GMLClass.GRIDENVELOPE;
	}

	public List<Integer> getLow() {
		if (low == null)
			low = new ArrayList<Integer>();
		
		return low;
	}

	public List<Integer> getHigh() {
		if (high == null)
			high = new ArrayList<Integer>();
		
		return high;
	}

	public boolean isSetLow() {
		return low != null && !low.isEmpty();
	}

	public boolean isSetHigh() {
		return high != null && !high.isEmpty();
	}

	public void addLow(Integer low) {
		if (this.low == null)
			this.low = new ArrayList<Integer>();
		
		this.low.add(low);
	}

	public void addHigh(Integer high) {
		if (this.high == null)
			this.high = new ArrayList<Integer>();
		
		this.high.add(high);
	}

	public void setLow(List<Integer> low) {
		this.low = low;
	}

	public void setHigh(List<Integer> high) {
		this.high = high;
	}

	public void unsetLow() {
		low = null;
	}

	public void unsetHigh() {
		high = null;
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
		GridEnvelope copy = (target == null) ? new GridEnvelopeImpl() : (GridEnvelope)target;
		
		if (isSetLow())
			copy.setLow((List<Integer>)copyBuilder.copy(low));
		
		if (isSetHigh())
			copy.setHigh((List<Integer>)copyBuilder.copy(high));
		
		copy.unsetParent();
		
		return copy;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new GridEnvelopeImpl(), copyBuilder);
	}

}
