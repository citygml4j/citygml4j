package org.citygml4j.impl.xal;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.visitor.XALFunctor;
import org.citygml4j.model.common.visitor.XALVisitor;
import org.citygml4j.model.xal.SubPremiseNumber;
import org.citygml4j.model.xal.XALClass;

public class SubPremiseNumberImpl implements SubPremiseNumber {
	private String content;
	private String indicator;
	private String indicatorOccurrence;
	private String premiseNumberSeparator;
	private String numberTypeOccurrence;
	private String type;
	private String code;
	private Object parent;
		
	public String getContent() {
		return content;
	}

	public String getIndicator() {
		return indicator;
	}

	public String getIndicatorOccurrence() {
		return indicatorOccurrence;
	}

	public String getNumberTypeOccurrence() {
		return numberTypeOccurrence;
	}

	public String getPremiseNumberSeparator() {
		return premiseNumberSeparator;
	}

	public String getType() {
		return type;
	}

	public boolean isSetContent() {
		return content != null;
	}

	public boolean isSetIndicator() {
		return indicator != null;
	}

	public boolean isSetIndicatorOccurrence() {
		return indicatorOccurrence != null;
	}

	public boolean isSetNumberTypeOccurrence() {
		return numberTypeOccurrence != null;
	}

	public boolean isSetPremiseNumberSeparator() {
		return premiseNumberSeparator != null;
	}

	public boolean isSetType() {
		return type != null;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}

	public void setIndicatorOccurrence(String indicatorOccurrence) {
		if (indicatorOccurrence.equals("Before") || indicatorOccurrence.equals("After"))
			this.indicatorOccurrence = indicatorOccurrence;
	}

	public void setNumberTypeOccurrence(String numberTypeOccurrence) {
		if (numberTypeOccurrence.equals("Before") || numberTypeOccurrence.equals("After"))
			this.numberTypeOccurrence = numberTypeOccurrence;
	}

	public void setPremiseNumberSeparator(String premiseNumberSeparator) {
		this.premiseNumberSeparator = premiseNumberSeparator;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void unsetContent() {
		content = null;
	}

	public void unsetIndicator() {
		indicator = null;
	}

	public void unsetIndicatorOccurrence() {
		indicatorOccurrence = null;
	}

	public void unsetNumberTypeOccurrence() {
		numberTypeOccurrence = null;
	}

	public void unsetPremiseNumberSeparator() {
		premiseNumberSeparator = null;
	}

	public void unsetType() {
		type = null;
	}

	public ModelType getModelType() {
		return ModelType.XAL;
	}

	public XALClass getXALClass() {
		return XALClass.SUB_PREMISE_NUMBER;
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
		return copyTo(new SubPremiseNumberImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		SubPremiseNumber copy = (target == null) ? new SubPremiseNumberImpl() : (SubPremiseNumber)target;
		
		if (isSetContent())
			copy.setContent(copyBuilder.copy(content));

		if (isSetPremiseNumberSeparator())
			copy.setPremiseNumberSeparator(copyBuilder.copy(premiseNumberSeparator));

		if (isSetType())
			copy.setType(copyBuilder.copy(type));

		if (isSetIndicator())
			copy.setIndicator(copyBuilder.copy(indicator));

		if (isSetIndicatorOccurrence())
			copy.setIndicatorOccurrence(copyBuilder.copy(indicatorOccurrence));

		if (isSetNumberTypeOccurrence())
			copy.setNumberTypeOccurrence(copyBuilder.copy(numberTypeOccurrence));
		
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
