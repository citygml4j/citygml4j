package org.citygml4j.impl.xal;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.visitor.XALFunctor;
import org.citygml4j.model.common.visitor.XALVisitor;
import org.citygml4j.model.xal.PostBoxNumberSuffix;
import org.citygml4j.model.xal.XALClass;

public class PostBoxNumberSuffixImpl implements PostBoxNumberSuffix {
	private String content;
	private String numberSuffixSeparator;
	private String code;
	private Object parent;
	
	public String getContent() {
		return content;
	}

	public String getNumberSuffixSeparator() {
		return numberSuffixSeparator;
	}

	public boolean isSetContent() {
		return content != null;
	}

	public boolean isSetNumberSuffixSeparator() {
		return numberSuffixSeparator != null;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setNumberSuffixSeparator(String numberSuffixSeparator) {
		this.numberSuffixSeparator = numberSuffixSeparator;
	}

	public void unsetContent() {
		content = null;
	}

	public void unsetNumberSuffixSeparator() {
		numberSuffixSeparator = null;
	}

	public ModelType getModelType() {
		return ModelType.XAL;
	}

	public XALClass getXALClass() {
		return XALClass.POST_BOX_NUMBER_SUFFIX;
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
		return copyTo(new PostBoxNumberSuffixImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		PostBoxNumberSuffix copy = (target == null) ? new PostBoxNumberSuffixImpl() : (PostBoxNumberSuffix)target;
		
		if (isSetContent())
			copy.setContent(copyBuilder.copy(content));
		
		if (isSetNumberSuffixSeparator())
			copy.setNumberSuffixSeparator(copyBuilder.copy(numberSuffixSeparator));
		
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
