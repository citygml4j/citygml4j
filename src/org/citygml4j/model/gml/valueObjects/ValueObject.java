package org.citygml4j.model.gml.valueObjects;

import org.citygml4j.model.common.association.Associable;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;

public interface ValueObject extends GML, Associable, Child, Copyable {
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
