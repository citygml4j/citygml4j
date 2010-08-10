package org.citygml4j.impl.xal;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.xal.PremiseNumber;
import org.citygml4j.model.xal.XALClass;
import org.citygml4j.visitor.XALFunction;
import org.citygml4j.visitor.XALVisitor;

public class PremiseNumberImpl implements PremiseNumber {
	private String content;
	private String numberType;
	private String type;
	private String indicator;
	private String indicatorOccurrence;
	private String numberTypeOccurrence;
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

	public String getNumberType() {
		return numberType;
	}

	public String getNumberTypeOccurrence() {
		return numberTypeOccurrence;
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

	public boolean isSetNumberType() {
		return numberType != null;
	}

	public boolean isSetNumberTypeOccurrence() {
		return numberTypeOccurrence != null;
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

	public void setNumberType(String numberType) {
		if (numberType.equals("Single") || numberType.equals("Range"))
			this.numberType = numberType;
	}

	public void setNumberTypeOccurrence(String numberTypeOccurrence) {
		if (numberTypeOccurrence.equals("Before") || numberTypeOccurrence.equals("After"))
			this.numberTypeOccurrence = numberTypeOccurrence;
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

	public void unsetNumberType() {
		numberType = null;
	}

	public void unsetNumberTypeOccurrence() {
		numberTypeOccurrence = null;
	}

	public void unsetType() {
		type = null;
	}

	public XALClass getXALClass() {
		return XALClass.PREMISE_NUMBER;
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
		return copyTo(new PremiseNumberImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		PremiseNumber copy = (target == null) ? new PremiseNumberImpl() : (PremiseNumber)target;

		if (isSetContent())
			copy.setContent(copyBuilder.copy(content));

		if (isSetNumberType())
			copy.setNumberType(copyBuilder.copy(numberType));

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
		visitor.accept(this);
	}
	
	public <T> T visit(XALFunction<T> visitor) {
		return visitor.accept(this);
	}
	
}
