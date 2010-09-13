package org.citygml4j.impl.xal;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.visitor.XALFunctor;
import org.citygml4j.model.common.visitor.XALVisitor;
import org.citygml4j.model.xal.CountryNameCode;
import org.citygml4j.model.xal.XALClass;

public class CountryNameCodeImpl implements CountryNameCode {
	private String content;
	private String scheme;
	private String code;
	private Object parent;
	
	public String getContent() {
		return content;
	}

	public String getScheme() {
		return scheme;
	}

	public boolean isSetContent() {
		return content != null;
	}

	public boolean isSetScheme() {
		return scheme != null;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setScheme(String scheme) {
		this.scheme = scheme;
	}

	public void unsetContent() {
		content = null;
	}

	public void unsetScheme() {
		scheme = null;
	}

	public ModelType getModelType() {
		return ModelType.XAL;
	}

	public XALClass getXALClass() {
		return XALClass.COUNTRY_NAME_CODE;
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
		return copyTo(new CountryNameCodeImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		CountryNameCode copy = (target == null) ? new CountryNameCodeImpl() : (CountryNameCode)target;
		
		if (isSetContent())
			copy.setContent(copyBuilder.copy(content));
		
		if (isSetScheme())
			copy.setScheme(copyBuilder.copy(scheme));
		
		if (isSetCode())
			copy.setCode(copyBuilder.copy(code));
		
		copy.unsetParent();
		
		return copy;
	}
	
	public void visit(XALVisitor visitor) {
		visitor.visit(this);
	}
	
	public <T> T visit(XALFunctor<T> visitor) {
		return visitor.apply(this);
	}

}
