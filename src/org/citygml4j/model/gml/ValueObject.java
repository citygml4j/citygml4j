package org.citygml4j.model.gml;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface ValueObject extends GML, Child, Copyable {
	public ScalarValue getScalarValue();
	public ScalarValueList getScalarValueList();
	public ValueExtent getValueExtent();
	public CompositeValue getCompositeValue();	
	public boolean isSetScalarValue();
	public boolean isSetScalarValueList();
	public boolean isSetValueExtent();
	public boolean isSetCompositeValue();
	
	public void setScalarValue(ScalarValue scalarValue);
	public void setScalarValueList(ScalarValueList scalarValueList);
	public void setValueExtent(ValueExtent valueExtent);
	public void setCompositeValue(CompositeValue compositeValue);
	public void unsetScalarValue();
	public void unsetScalarValueList();
	public void unsetValueExtent();
	public void unsetCompositeValue();
}
