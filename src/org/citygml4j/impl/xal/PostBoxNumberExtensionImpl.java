package org.citygml4j.impl.xal;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.visitor.XALFunctor;
import org.citygml4j.model.common.visitor.XALVisitor;
import org.citygml4j.model.xal.PostBoxNumberExtension;
import org.citygml4j.model.xal.XALClass;

public class PostBoxNumberExtensionImpl implements PostBoxNumberExtension {
	private String content;
	private String numberExtensionSeparator;
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
		return XALClass.POST_BOX_NUMBER_EXTENSION;
	}

	public String getNumberExtensionSeparator() {
		return numberExtensionSeparator;
	}

	public boolean isSetNumberExtensionSeparator() {
		return numberExtensionSeparator != null;
	}

	public void setNumberExtensionSeparator(String numberExtensionSeparator) {
		this.numberExtensionSeparator = numberExtensionSeparator;
	}

	public void unsetNumberExtensionSeparator() {
		numberExtensionSeparator = null;
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
		return copyTo(new PostBoxNumberExtensionImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		PostBoxNumberExtension copy = (target == null) ? new PostBoxNumberExtensionImpl() : (PostBoxNumberExtension)target;
		
		if (isSetContent())
			copy.setContent(copyBuilder.copy(content));
		
		if (isSetNumberExtensionSeparator())
			copy.setNumberExtensionSeparator(copyBuilder.copy(numberExtensionSeparator));
		
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
