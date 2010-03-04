package org.citygml4j.impl.xal;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.xal.AddressIdentifier;
import org.citygml4j.model.xal.XALClass;
import org.citygml4j.visitor.XALFunction;
import org.citygml4j.visitor.XALVisitor;

public class AddressIdentifierImpl implements AddressIdentifier {
	private String content;
	private String identifierType;
	private String type;
	private String code;
	private Object parent;
	
	public String getContent() {
		return content;
	}

	public String getIdentifierType() {
		return identifierType;
	}

	public String getType() {
		return type;
	}

	public boolean isSetContent() {
		return content != null;
	}

	public boolean isSetIdentifierType() {
		return identifierType != null;
	}

	public boolean isSetType() {
		return type != null;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setIdentifierType(String identifierType) {
		this.identifierType = identifierType;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void unsetContent() {
		content = null;
	}

	public void unsetIdentifierType() {
		identifierType = null;
	}

	public void unsetType() {
		type = null;
	}

	public XALClass getXALClass() {
		return XALClass.ADDRESSIDENTIFIER;
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
		return copyTo(new AddressIdentifierImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		AddressIdentifier copy = (target == null) ? new AddressIdentifierImpl() : (AddressIdentifier)target;
		
		if (isSetContent())
			copy.setContent(copyBuilder.copy(content));
		
		if (isSetIdentifierType())
			copy.setIdentifierType(copyBuilder.copy(identifierType));
		
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
