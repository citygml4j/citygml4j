package org.citygml4j.impl.xal;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.xal.PremiseNumberRange;
import org.citygml4j.model.xal.PremiseNumberRangeFrom;
import org.citygml4j.model.xal.PremiseNumberRangeTo;
import org.citygml4j.model.xal.XALClass;
import org.citygml4j.visitor.XALFunction;
import org.citygml4j.visitor.XALVisitor;

public class PremiseNumberRangeImpl implements PremiseNumberRange {
	private PremiseNumberRangeFrom premiseNumberRangeFrom;
	private PremiseNumberRangeTo premiseNumberRangeTo;
	private String rangeType;
	private String indicator;
	private String separator;
	private String type;
	private String indicatorOccurrence;
	private String numberRangeOccurrence;
	private Object parent;
	
	public String getIndicator() {
		return indicator;
	}

	public String getIndicatorOccurence() {
		return indicatorOccurrence;
	}

	public String getNumberRangeOccurence() {
		return numberRangeOccurrence;
	}

	public PremiseNumberRangeFrom getPremiseNumberRangeFrom() {
		return premiseNumberRangeFrom;
	}

	public PremiseNumberRangeTo getPremiseNumberRangeTo() {
		return premiseNumberRangeTo;
	}

	public String getRangeType() {
		return rangeType;
	}

	public String getSeparator() {
		return separator;
	}

	public String getType() {
		return type;
	}

	public boolean isSetIndicator() {
		return indicator != null;
	}

	public boolean isSetIndicatorOccurence() {
		return indicatorOccurrence != null;
	}

	public boolean isSetNumberRangeOccurence() {
		return numberRangeOccurrence != null;
	}

	public boolean isSetPremiseNumberRangeFrom() {
		return premiseNumberRangeFrom != null;
	}

	public boolean isSetPremiseNumberRangeTo() {
		return premiseNumberRangeTo != null;
	}

	public boolean isSetRangeType() {
		return rangeType != null;
	}

	public boolean isSetSeparator() {
		return separator != null;
	}

	public boolean isSetType() {
		return type != null;
	}

	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}

	public void setIndicatorOccurence(String indicatorOccurence) {
		if (indicatorOccurrence.equals("Before") || indicatorOccurrence.equals("After"))
			this.indicatorOccurrence = indicatorOccurence;
	} 

	public void setNumberRangeOccurence(String numberRangeOccurence) {
		if (numberRangeOccurrence.equals("BeforeName") || numberRangeOccurrence.equals("AfterName") ||
				numberRangeOccurrence.equals("BeforeType") || numberRangeOccurrence.equals("AfterType"))
			this.numberRangeOccurrence = numberRangeOccurence;
	}

	public void setPremiseNumberRangeFrom(PremiseNumberRangeFrom premiseNumberRangeFrom) {
		if (premiseNumberRangeFrom != null)
			premiseNumberRangeFrom.setParent(this);
		
		this.premiseNumberRangeFrom = premiseNumberRangeFrom;
	}

	public void setPremiseNumberRangeTo(PremiseNumberRangeTo premiseNumberRangeTo) {
		if (premiseNumberRangeTo != null)
			premiseNumberRangeTo.setParent(this);
		
		this.premiseNumberRangeTo = premiseNumberRangeTo;
	}

	public void setRangeType(String rangeType) {
		this.rangeType = rangeType;
	}

	public void setSeparator(String separator) {
		this.separator = separator;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void unsetIndicator() {
		indicator = null;
	}

	public void unsetIndicatorOccurence() {
		indicatorOccurrence = null;
	}

	public void unsetNumberRangeOccurence() {
		numberRangeOccurrence = null;
	}

	public void unsetPremiseNumberRangeFrom() {
		if (isSetPremiseNumberRangeFrom())
			premiseNumberRangeFrom.unsetParent();
		
		premiseNumberRangeFrom = null;
	}

	public void unsetPremiseNumberRangeTo() {
		if (isSetPremiseNumberRangeTo())
			premiseNumberRangeTo.unsetParent();
		
		premiseNumberRangeTo = null;
	}

	public void unsetRangeType() {
		rangeType = null;
	}

	public void unsetSeparator() {
		separator = null;
	}

	public void unsetType() {
		type = null;
	}

	public XALClass getXALClass() {
		return XALClass.PREMISE_NUMBER_RANGE;
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
		return copyTo(new PremiseNumberRangeImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		PremiseNumberRange copy = (target == null) ? new PremiseNumberRangeImpl() : (PremiseNumberRange)target;
		
		if (isSetPremiseNumberRangeFrom()) {
			copy.setPremiseNumberRangeFrom((PremiseNumberRangeFrom)copyBuilder.copy(premiseNumberRangeFrom));
			if (copy.getPremiseNumberRangeFrom() == premiseNumberRangeFrom)
				premiseNumberRangeFrom.setParent(this);
		}
		
		if (isSetPremiseNumberRangeTo()) {
			copy.setPremiseNumberRangeTo((PremiseNumberRangeTo)copyBuilder.copy(premiseNumberRangeTo));
			if (copy.getPremiseNumberRangeTo() == premiseNumberRangeTo)
				premiseNumberRangeTo.setParent(this);
		}
		
		if (isSetRangeType())
			copy.setRangeType(copyBuilder.copy(rangeType));
		
		if (isSetIndicator())
			copy.setIndicator(copyBuilder.copy(indicator));
		
		if (isSetSeparator())
			copy.setSeparator(copyBuilder.copy(separator));
		
		if (isSetType())
			copy.setType(copyBuilder.copy(type));
		
		if (isSetIndicatorOccurence())
			copy.setIndicatorOccurence(copyBuilder.copy(indicatorOccurrence));
		
		if (isSetNumberRangeOccurence())
			copy.setNumberRangeOccurence(copyBuilder.copy(numberRangeOccurrence));
		
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
