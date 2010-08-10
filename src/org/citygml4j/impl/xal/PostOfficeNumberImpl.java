package org.citygml4j.impl.xal;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.xal.PostOfficeNumber;
import org.citygml4j.model.xal.XALClass;
import org.citygml4j.visitor.XALFunction;
import org.citygml4j.visitor.XALVisitor;

public class PostOfficeNumberImpl implements PostOfficeNumber {
	private String content;
	private String indicatorOccurrence;
	private String indicator;
	private String code;
	private Object parent;
	
	public String getContent() {
		return content;
	}

	public String getIndicatorOccurrence() {
		return indicatorOccurrence;
	}

	public String getIndicator() {
		return indicator;
	}

	public boolean isSetContent() {
		return content != null;
	}

	public boolean isSetIndicatorOccurrence() {
		return indicatorOccurrence != null;
	}

	public boolean isSetIndicator() {
		return indicator != null;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setIndicatorOccurrence(String indicatorOccurrence) {
		if (indicatorOccurrence.equals("Before") || indicatorOccurrence.equals("After"))
			this.indicatorOccurrence = indicatorOccurrence;
	}

	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}

	public void unsetContent() {
		content = null;
	}

	public void unsetIndicatorOccurrence() {
		indicatorOccurrence = null;
	}

	public void unsetIndicator() {
		indicator = null;
	}

	public XALClass getXALClass() {
		return XALClass.POST_OFFICE_NUMBER;
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
		return copyTo(new PostOfficeNumberImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		PostOfficeNumber copy = (target == null) ? new PostOfficeNumberImpl() : (PostOfficeNumber)target;
		
		if (isSetContent())
			copy.setContent(copyBuilder.copy(content));
		
		if (isSetIndicatorOccurrence())
			copy.setIndicatorOccurrence(copyBuilder.copy(indicatorOccurrence));
		
		if (isSetIndicator())
			copy.setIndicator(copyBuilder.copy(indicator));
		
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
