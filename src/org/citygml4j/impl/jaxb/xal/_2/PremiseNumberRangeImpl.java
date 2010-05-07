package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.PremiseElement;
import org.citygml4j.model.xal.PremiseNumberRange;
import org.citygml4j.model.xal.PremiseNumberRangeFrom;
import org.citygml4j.model.xal.PremiseNumberRangeTo;
import org.citygml4j.model.xal.XALClass;

public class PremiseNumberRangeImpl extends XALBaseImpl implements PremiseNumberRange {
	private PremiseElement.PremiseNumberRange premiseNumberRange;
	
	public PremiseNumberRangeImpl() {
		premiseNumberRange = new PremiseElement.PremiseNumberRange();
	}
	
	public PremiseNumberRangeImpl(PremiseElement.PremiseNumberRange premiseNumberRange) {
		this.premiseNumberRange = premiseNumberRange;
	}
	
	@Override
	public PremiseElement.PremiseNumberRange getJAXBObject() {
		return premiseNumberRange;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.PREMISENUMBERRANGE;
	}

	public String getIndicator() {
		return premiseNumberRange.getIndicator();
	}

	public String getIndicatorOccurrence() {
		return premiseNumberRange.getIndicatorOccurence();
	}

	public String getNumberRangeOccurrence() {
		return premiseNumberRange.getNumberRangeOccurence();
	}

	public PremiseNumberRangeFrom getPremiseNumberRangeFrom() {
		if (premiseNumberRange.isSetPremiseNumberRangeFrom())
			return new PremiseNumberRangeFromImpl(premiseNumberRange.getPremiseNumberRangeFrom());
		
		return null;
	}

	public PremiseNumberRangeTo getPremiseNumberRangeTo() {
		if (premiseNumberRange.isSetPremiseNumberRangeTo())
			return new PremiseNumberRangeToImpl(premiseNumberRange.getPremiseNumberRangeTo());
		
		return null;
	}

	public String getRangeType() {
		return premiseNumberRange.getRangeType();
	}

	public String getSeparator() {
		return premiseNumberRange.getSeparator();
	}

	public String getType() {
		return premiseNumberRange.getType();
	}

	public void setIndicatorOccurrence(String indicatorOccurrence) {
		if (indicatorOccurrence.equals("Befaore") || indicatorOccurrence.equals("After"))
			premiseNumberRange.setIndicatorOccurence(indicatorOccurrence);
	}
	
	public void setIndicator(String indicator) {
		premiseNumberRange.setIndicator(indicator);
	}

	public void setNumberRangeOccurrence(String numberRangeOccurrence) {
		if (numberRangeOccurrence.equals("BeforeName") ||
				numberRangeOccurrence.equals("AfterName") ||
				numberRangeOccurrence.equals("BeforeType") ||
				numberRangeOccurrence.equals("AfterType"))
			premiseNumberRange.setNumberRangeOccurence(numberRangeOccurrence);
	}

	public void setPremiseNumberRangeFrom(PremiseNumberRangeFrom premiseNumberRangeFrom) {
		premiseNumberRange.setPremiseNumberRangeFrom(((PremiseNumberRangeFromImpl)premiseNumberRangeFrom).getJAXBObject());
	}

	public void setPremiseNumberRangeTo(PremiseNumberRangeTo premiseNumberRangeTo) {
		premiseNumberRange.setPremiseNumberRangeTo(((PremiseNumberRangeToImpl)premiseNumberRangeTo).getJAXBObject());
	}

	public void setRangeType(String rangeType) {
		premiseNumberRange.setRangeType(rangeType);
	}

	public void setSeparator(String separator) {
		premiseNumberRange.setSeparator(separator);
	}

	public void setType(String type) {
		premiseNumberRange.setType(type);
	}

	public boolean isSetIndicator() {
		return premiseNumberRange.isSetIndicator();
	}

	public boolean isSetIndicatorOccurrence() {
		return premiseNumberRange.isSetIndicatorOccurence();
	}

	public boolean isSetNumberRangeOccurrence() {
		return premiseNumberRange.isSetNumberRangeOccurence();
	}

	public boolean isSetPremiseNumberRangeFrom() {
		return premiseNumberRange.isSetPremiseNumberRangeFrom();
	}

	public boolean isSetPremiseNumberRangeTo() {
		return premiseNumberRange.isSetPremiseNumberRangeTo();
	}

	public boolean isSetRangeType() {
		return premiseNumberRange.isSetRangeType();
	}

	public boolean isSetSeparator() {
		return premiseNumberRange.isSetSeparator();
	}

	public boolean isSetType() {
		return premiseNumberRange.isSetType();
	}

	public void unsetIndicator() {
		premiseNumberRange.setIndicator(null);
	}

	public void unsetIndicatorOccurrence() {
		premiseNumberRange.setIndicatorOccurence(null);
	}

	public void unsetNumberRangeOccurrence() {
		premiseNumberRange.setNumberRangeOccurence(null);
	}

	public void unsetPremiseNumberRangeFrom() {
		premiseNumberRange.setPremiseNumberRangeFrom(null);
	}

	public void unsetPremiseNumberRangeTo() {
		premiseNumberRange.setPremiseNumberRangeTo(null);
	}

	public void unsetRangeType() {
		premiseNumberRange.setRangeType(null);
	}

	public void unsetSeparator() {
		premiseNumberRange.setSeparator(null);
	}

	public void unsetType() {
		premiseNumberRange.setType(null);
	}

}
