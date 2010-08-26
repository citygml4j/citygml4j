package org.citygml4j.model.gml.coverage;

import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.basicTypes.Coordinates;
import org.citygml4j.model.gml.basicTypes.DoubleOrNullList;


public interface DataBlock extends GML, Child, Copyable {
	public RangeParameters getRangeParameters();
	public Coordinates getTupleList();
	public DoubleOrNullList getDoubleOrNullTupleList();
	public boolean isSetRangeParameters();
	public boolean isSetTupleList();
	public boolean isSetDoubleOrNullTupleList();
	
	public void setRangeParameters(RangeParameters rangeParameters);
	public void setTupleList(Coordinates tupleList);
	public void setDoubleOrNullTupleList(DoubleOrNullList doubleOrNullTupleList);
	public void unsetRangeParameters();
	public void unsetTupleList();
	public void unsetDoubleOrNullTupleList();
}
