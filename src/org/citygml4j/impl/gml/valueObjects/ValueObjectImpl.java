package org.citygml4j.impl.gml.valueObjects;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.valueObjects.CompositeValue;
import org.citygml4j.model.gml.valueObjects.ScalarValue;
import org.citygml4j.model.gml.valueObjects.ScalarValueList;
import org.citygml4j.model.gml.valueObjects.ValueExtent;
import org.citygml4j.model.gml.valueObjects.ValueObject;

public class ValueObjectImpl implements ValueObject {
	private ScalarValue scalarValue;
	private ScalarValueList scalarValueList;
	private ValueExtent valueExtent;
	private CompositeValue compositeValue;
	private Object parent;
	
	public ValueObjectImpl() {
		
	}
	
	public ValueObjectImpl(ScalarValue scalarValue) {
		setScalarValue(scalarValue);
	}
	
	public ValueObjectImpl(ScalarValueList scalarValueList) {
		setScalarValueList(scalarValueList);
	}
	
	public ValueObjectImpl(ValueExtent valueExtent) {
		setValueExtent(valueExtent);
	}
	
	public ValueObjectImpl(CompositeValue compositeValue) {
		setCompositeValue(compositeValue);
	}

	public ModelType getModelType() {
		return ModelType.GML;
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.VALUE_OBJECT;
	}

	public ScalarValue getScalarValue() {
		return scalarValue;
	}

	public ScalarValueList getScalarValueList() {
		return scalarValueList;
	}

	public ValueExtent getValueExtent() {
		return valueExtent;
	}

	public CompositeValue getCompositeValue() {
		return compositeValue;
	}

	public boolean isSetScalarValue() {
		return scalarValue != null;
	}

	public boolean isSetScalarValueList() {
		return scalarValueList != null;
	}

	public boolean isSetValueExtent() {
		return valueExtent != null;
	}

	public boolean isSetCompositeValue() {
		return compositeValue != null;
	}

	public void setScalarValue(ScalarValue scalarValue) {
		if (scalarValue != null)
			scalarValue.setParent(this);
		
		this.scalarValue = scalarValue;
		
		unsetCompositeValue();
		unsetScalarValueList();
		unsetValueExtent();
	}

	public void setScalarValueList(ScalarValueList scalarValueList) {
		if (scalarValueList != null)
			scalarValueList.setParent(this);
		
		this.scalarValueList = scalarValueList;
		
		unsetCompositeValue();
		unsetScalarValue();
		unsetValueExtent();
	}

	public void setValueExtent(ValueExtent valueExtent) {
		if (valueExtent != null)
			valueExtent.setParent(this);
		
		this.valueExtent = valueExtent;
		
		unsetCompositeValue();
		unsetScalarValue();
		unsetScalarValueList();
	}

	public void setCompositeValue(CompositeValue compositeValue) {
		if (compositeValue != null)
			compositeValue.setParent(this);
		
		this.compositeValue = compositeValue;
		
		unsetScalarValue();
		unsetScalarValueList();
		unsetValueExtent();
	}

	public void unsetScalarValue() {
		if (isSetScalarValue())
			scalarValue.unsetParent();
		
		scalarValue = null;
	}

	public void unsetScalarValueList() {
		if (isSetScalarValueList())
			scalarValueList.unsetParent();
		
		scalarValueList = null;
	}

	public void unsetValueExtent() {
		if (isSetValueExtent())
			valueExtent.unsetParent();
		
		valueExtent = null;
	}

	public void unsetCompositeValue() {
		if (isSetCompositeValue())
			compositeValue.unsetParent();
		
		compositeValue = null;
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
		ValueObject copy = (target == null) ? new ValueObjectImpl() : (ValueObject)target;
		
		if (isSetScalarValue()) {
			copy.setScalarValue((ScalarValue)copyBuilder.copy(scalarValue));
			if (copy.getScalarValue() == scalarValue)
				scalarValue.setParent(this);
		}
		
		if (isSetScalarValueList()) {
			copy.setScalarValueList((ScalarValueList)copyBuilder.copy(scalarValueList));
			if (copy.getScalarValueList() == scalarValueList)
				scalarValueList.setParent(this);
		}
		
		if (isSetValueExtent()) {
			copy.setValueExtent((ValueExtent)copyBuilder.copy(valueExtent));
			if (copy.getValueExtent() == valueExtent)
				valueExtent.setParent(this);
		}
		
		if (isSetCompositeValue()) {
			copy.setCompositeValue((CompositeValue)copyBuilder.copy(compositeValue));
			if (copy.getCompositeValue() == compositeValue)
				compositeValue.setParent(this);
		}
		
		copy.unsetParent();
		
		return copy;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new ValueObjectImpl(), copyBuilder);
	}

}
