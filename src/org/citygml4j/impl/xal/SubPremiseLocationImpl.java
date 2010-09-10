package org.citygml4j.impl.xal;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.visitor.XALFunctor;
import org.citygml4j.model.common.visitor.XALVisitor;
import org.citygml4j.model.xal.SubPremiseLocation;
import org.citygml4j.model.xal.XALClass;

public class SubPremiseLocationImpl implements SubPremiseLocation {
	private String content;
	private String code;
	private Object parent;
	
	public String getContent() {
		return content;
	}

	public boolean isSetContent() {
		return content != null;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void unsetContent() {
		content = null;
	}

	public XALClass getXALClass() {
		return XALClass.SUB_PREMISE_LOCATION;
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
		return copyTo(new SubPremiseLocationImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		SubPremiseLocation copy = (target == null) ? new SubPremiseLocationImpl() : (SubPremiseLocation)target;
		
		if (isSetContent())
			copy.setContent(copyBuilder.copy(content));
		
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
