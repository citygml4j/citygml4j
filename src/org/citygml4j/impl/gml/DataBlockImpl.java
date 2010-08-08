package org.citygml4j.impl.gml;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.Coordinates;
import org.citygml4j.model.gml.DataBlock;
import org.citygml4j.model.gml.DoubleOrNullList;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.RangeParameters;

public class DataBlockImpl implements DataBlock {
	private RangeParameters rangeParameters;
	private Coordinates tupleList;
	private DoubleOrNullList doubleOrNullTupleList;
	private Object parent;

	public GMLClass getGMLClass() {
		return GMLClass.DATABLOCK;
	}

	public RangeParameters getRangeParameters() {
		return rangeParameters;
	}

	public Coordinates getTupleList() {
		return tupleList;
	}

	public DoubleOrNullList getDoubleOrNullTupleList() {
		return doubleOrNullTupleList;
	}

	public boolean isSetRangeParameters() {
		return rangeParameters != null;
	}

	public boolean isSetTupleList() {
		return tupleList != null;
	}

	public boolean isSetDoubleOrNullTupleList() {
		return doubleOrNullTupleList != null;
	}

	public void setRangeParameters(RangeParameters rangeParameters) {
		if (rangeParameters != null)
			rangeParameters.setParent(this);
		
		this.rangeParameters = rangeParameters;
	}

	public void setTupleList(Coordinates tupleList) {
		if (tupleList != null)
			tupleList.setParent(this);
		
		this.tupleList = tupleList;
		
		unsetDoubleOrNullTupleList();
	}

	public void setDoubleOrNullTupleList(DoubleOrNullList doubleOrNullTupleList) {
		if (doubleOrNullTupleList != null)
			doubleOrNullTupleList.setParent(this);
		
		this.doubleOrNullTupleList = doubleOrNullTupleList;
		
		unsetTupleList();
	}

	public void unsetRangeParameters() {
		if (isSetRangeParameters())
			rangeParameters.unsetParent();
		
		rangeParameters = null;
	}

	public void unsetTupleList() {
		if (isSetTupleList())
			tupleList.unsetParent();
		
		tupleList = null;
	}

	public void unsetDoubleOrNullTupleList() {
		if (isSetDoubleOrNullTupleList())
			doubleOrNullTupleList.unsetParent();
		
		doubleOrNullTupleList = null;
	}
	
	public Object getParent() {
		return parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public void setParent(Object parent) {
		this.parent = parent;
	}

	public void unsetParent() {
		parent = null;
	}
	
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		DataBlock copy = (target == null) ? new DataBlockImpl() : (DataBlock)target;
		
		if (isSetRangeParameters()) {
			copy.setRangeParameters((RangeParameters)copyBuilder.copy(rangeParameters));
			if (copy.getRangeParameters() == rangeParameters)
				rangeParameters.setParent(this);
		}
		
		if (isSetTupleList()) {
			copy.setTupleList((Coordinates)copyBuilder.copy(tupleList));
			if (copy.getTupleList() == tupleList)
				tupleList.setParent(this);
		}
		
		if (isSetDoubleOrNullTupleList()) {
			copy.setDoubleOrNullTupleList((DoubleOrNullList)copyBuilder.copy(doubleOrNullTupleList));
			if (copy.getDoubleOrNullTupleList() == doubleOrNullTupleList)
				doubleOrNullTupleList.setParent(this);
		}
		
		copy.unsetParent();
		
		return copy;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new DataBlockImpl(), copyBuilder);
	}

}
