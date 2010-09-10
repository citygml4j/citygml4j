package org.citygml4j.model.gml.valueObjects;

import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;


public interface ValueExtent extends GML, Child, Copyable {
	public CategoryExtent getCategoryExtent();
	public QuantityExtent getQuantityExtent();
	public CountExtent getCountExtent();
	public boolean isSetCategoryExtent();
	public boolean isSetQuantityExtent();
	public boolean isSetCountExtent();
	
	public void setCategoryExtent(CategoryExtent categoryExtent);
	public void setQuantityExtent(QuantityExtent quantityExtent);
	public void setCountExtent(CountExtent countExtent);
	public void unsetCategoryExtent();
	public void unsetQuantityExtent();
	public void unsetCountExtent();	
}
