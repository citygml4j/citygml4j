package org.citygml4j.impl.xal;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.xal.PostBoxNumberPrefix;
import org.citygml4j.model.xal.XALClass;
import org.citygml4j.visitor.XALFunction;
import org.citygml4j.visitor.XALVisitor;

public class PostBoxNumberPrefixImpl implements PostBoxNumberPrefix {
	private String content;
	private String numberPrefixSeparator;
	private String code;
	private Object parent;
	
	public String getContent() {
		return content;
	}

	public String getNumberPrefixSeparator() {
		return numberPrefixSeparator;
	}

	public boolean isSetContent() {
		return content != null;
	}

	public boolean isSetNumberPrefixSeparator() {
		return numberPrefixSeparator != null;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setNumberPrefixSeparator(String numberPrefixSeparator) {
		this.numberPrefixSeparator = numberPrefixSeparator;
	}

	public void unsetContent() {
		content = null;
	}

	public void unsetNumberPrefixSeparator() {
		numberPrefixSeparator = null;
	}

	public XALClass getXALClass() {
		return XALClass.POST_BOX_NUMBER_PREFIX;
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
		return copyTo(new PostBoxNumberPrefixImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		PostBoxNumberPrefix copy = (target == null) ? new PostBoxNumberPrefixImpl() : (PostBoxNumberPrefix)target;
		
		if (isSetContent())
			copy.setContent(copyBuilder.copy(content));
		
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
