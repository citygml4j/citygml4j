package org.citygml4j.impl.xal;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.xal.AddressLongitudeDirection;
import org.citygml4j.model.xal.XALClass;
import org.citygml4j.visitor.XALFunction;
import org.citygml4j.visitor.XALVisitor;

public class AddressLongitudeDirectionImpl implements AddressLongitudeDirection {
	private String content;
	private String type;
	private String code;
	private Object parent;
	
	public String getContent() {
		return content;
	}

	public String getType() {
		return type;
	}

	public boolean isSetContent() {
		return content != null;
	}

	public boolean isSetType() {
		return type != null;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void unsetContent() {
		content = null;
	}

	public void unsetType() {
		type = null;
	}

	public XALClass getXALClass() {
		return XALClass.ADDRESS_LONGITUDE_DIRECTION;
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
		return copyTo(new AddressLongitudeDirectionImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		AddressLongitudeDirection copy = (target == null) ? new AddressLongitudeDirectionImpl() : (AddressLongitudeDirection)target;
		
		if (isSetContent())
			copy.setContent(copyBuilder.copy(content));
		
		if (isSetType())
			copy.setType(copyBuilder.copy(type));
		
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
