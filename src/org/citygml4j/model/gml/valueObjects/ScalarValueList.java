package org.citygml4j.model.gml.valueObjects;

import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.basicTypes.BooleanOrNullList;
import org.citygml4j.model.gml.basicTypes.CodeOrNullList;
import org.citygml4j.model.gml.basicTypes.IntegerOrNullList;
import org.citygml4j.model.gml.basicTypes.MeasureOrNullList;


public interface ScalarValueList extends GML, Child, Copyable {
	public BooleanOrNullList getBooleanList();
	public CodeOrNullList getCategoryList();
	public MeasureOrNullList getQuantityList();
	public IntegerOrNullList getCountList();
	public boolean isSetBooleanList();
	public boolean isSetCategoryList();
	public boolean isSetQuantityList();
	public boolean isSetCountList();
	
	public void setBooleanList(BooleanOrNullList booleanList);
	public void setCategoryList(CodeOrNullList categoryList);
	public void setQuantityList(MeasureOrNullList quantityList);
	public void setCountList(IntegerOrNullList countList);
	public void unsetBooleanList();
	public void unsetCategoryList();
	public void unsetQuantityList();
	public void unsetCountList();
}
