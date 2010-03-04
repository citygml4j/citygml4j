package org.citygml4j.impl.xal;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.xal.PostalCodeNumberExtension;
import org.citygml4j.model.xal.XALClass;
import org.citygml4j.visitor.XALFunction;
import org.citygml4j.visitor.XALVisitor;

public class PostalCodeNumberExtensionImpl implements PostalCodeNumberExtension {
	private String content;
	private String numberExtensionSeparator;
	private String type;
	private String code;
	private Object parent;
	
	public String getContent() {
		return content;
	}

	public String getNumberExtensionSeparator() {
		return numberExtensionSeparator;
	}

	public String getType() {
		return type;
	}

	public boolean isSetContent() {
		return content != null;
	}

	public boolean isSetNumberExtensionSeparator() {
		return numberExtensionSeparator != null;
	}

	public boolean isSetType() {
		return type != null;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setNumberExtensionSeparator(String numberExtensionSeparator) {
		this.numberExtensionSeparator = numberExtensionSeparator;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void unsetContent() {
		content = null;
	}

	public void unsetNumberExtensionSeparator() {
		numberExtensionSeparator = null;
	}

	public void unsetType() {
		type = null;
	}

	public XALClass getXALClass() {
		return XALClass.POSTALCODENUMBEREXTENSION;
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
		return copyTo(new PostalCodeNumberExtensionImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		PostalCodeNumberExtension copy = (target == null) ? new PostalCodeNumberExtensionImpl() : (PostalCodeNumberExtension)target;
		
		if (isSetContent())
			copy.setContent(copyBuilder.copy(content));
		
		if (isSetNumberExtensionSeparator())
			copy.setNumberExtensionSeparator(copyBuilder.copy(numberExtensionSeparator));
		
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
