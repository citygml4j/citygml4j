package org.citygml4j.impl.gml;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.commons.child.ChildList;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.Value;
import org.citygml4j.model.gml.ValueArrayProperty;

public class ValueArrayPropertyImpl implements ValueArrayProperty {
	private List<Value> value;
	private Object parent;
	
	public GMLClass getGMLClass() {
		return GMLClass.VALUEARRAYPROPERTY;
	}

	public List<Value> getValue() {
		if (value == null)
			value = new ChildList<Value>(this);
		
		return value;
	}

	public boolean isSetValue() {
		return value != null && !value.isEmpty();
	}

	public void setValue(List<Value> value) {
		this.value = new ChildList<Value>(this, value);
	}

	public void addValue(Value value) {
		if (this.value == null)
			this.value = new ChildList<Value>(this);
		
		this.value.add(value);
	}

	public void unsetValue() {
		if (isSetValue())
			value.clear();
		
		value = null;
	}

	public boolean unsetValue(Value value) {
		return isSetValue() ? this.value.remove(value) : false;
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
	
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		ValueArrayProperty copy = (target == null) ? new ValueArrayPropertyImpl() : (ValueArrayProperty)target;
		
		if (isSetValue()) {
			for (Value part : value) {
				Value copyPart = (Value)copyBuilder.copy(part);
				copy.addValue(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		copy.unsetParent();
		
		return copy;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new ValueArrayPropertyImpl(), copyBuilder);
	}

}
