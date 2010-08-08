package org.citygml4j.model.gml;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

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
