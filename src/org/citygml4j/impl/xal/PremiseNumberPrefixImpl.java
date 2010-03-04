package org.citygml4j.impl.xal;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.xal.PremiseNumberPrefix;
import org.citygml4j.model.xal.XALClass;
import org.citygml4j.visitor.XALFunction;
import org.citygml4j.visitor.XALVisitor;

public class PremiseNumberPrefixImpl implements PremiseNumberPrefix {
	private String value;
	private String type;
	private String numberPrefixSeparator;
	private String code;
	private Object parent;
	
	public String getValue() {
		return value;
	}

	public String getType() {
		return type;
	}

	public String getNumberPrefixSeparator() {
		return numberPrefixSeparator;
	}

	public boolean isSetValue() {
		return value != null;
	}

	public boolean isSetType() {
		return type != null;
	}

	public boolean isSetNumberPrefixSeparator() {
		return numberPrefixSeparator != null;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setNumberPrefixSeparator(String numberPrefixSeparator) {
		this.numberPrefixSeparator = numberPrefixSeparator;
	}

	public void unsetValue() {
		value = null;
	}

	public void unsetType() {
		type = null;
	}

	public void unsetNumberPrefixSeparator() {
		numberPrefixSeparator = null;
	}

	public XALClass getXALClass() {
		return XALClass.PREMISENUMBERPREFIX;
	}

	public String getCode() {
		return code;
	}

	public boolean isSetCode() {
		return code != null;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void unsetCode() {
		code = null;
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

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new PremiseNumberPrefixImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		PremiseNumberPrefix copy = (target == null) ? new PremiseNumberPrefixImpl() : (PremiseNumberPrefix)target;
		
		if (isSetValue())
			copy.setValue(copyBuilder.copy(value));
		
		if (isSetType())
			copy.setType(copyBuilder.copy(type));
		
		if (isSetNumberPrefixSeparator())
			copy.setNumberPrefixSeparator(copyBuilder.copy(numberPrefixSeparator));
		
		if (isSetCode())
			copy.setCode(copyBuilder.copy(code));
		
		copy.unsetParent();
		
		return copy;
	}
	
	public void visit(XALVisitor visitor) {
		visitor.accept(this);
	}
	
	public <T> T visit(XALFunction<T> visitor) {
		return visitor.accept(this);
	}

}
