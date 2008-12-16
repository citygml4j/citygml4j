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

	@Override
	public String getIndicator() {
		return premiseNumberRange.getIndicator();
	}

	@Override
	public String getIndicatorOccurrence() {
		return premiseNumberRange.getIndicatorOccurence();
	}

	@Override
	public String getNumberRangeOccurrence() {
		return premiseNumberRange.getNumberRangeOccurence();
	}

	@Override
	public PremiseNumberRangeFrom getPremiseNumberRangeFrom() {
		if (premiseNumberRange.isSetPremiseNumberRangeFrom())
			return new PremiseNumberRangeFromImpl(premiseNumberRange.getPremiseNumberRangeFrom());
		
		return null;
	}

	@Override
	public PremiseNumberRangeTo getPremiseNumberRangeTo() {
		if (premiseNumberRange.isSetPremiseNumberRangeTo())
			return new PremiseNumberRangeToImpl(premiseNumberRange.getPremiseNumberRangeTo());
		
		return null;
	}

	@Override
	public String getRangeType() {
		return premiseNumberRange.getRangeType();
	}

	@Override
	public String getSeparator() {
		return premiseNumberRange.getSeparator();
	}

	@Override
	public String getType() {
		return premiseNumberRange.getType();
	}

	@Override
	public void setIndicatorOccurrence(String indicatorOccurrence) {
		if (indicatorOccurrence.equals("Befaore") || indicatorOccurrence.equals("After"))
			premiseNumberRange.setIndicatorOccurence(indicatorOccurrence);
	}
	
	@Override
	public void setIndicator(String indicator) {
		premiseNumberRange.setIndicator(indicator);
	}

	@Override
	public void setNumberRangeOccurrence(String numberRangeOccurrence) {
		if (numberRangeOccurrence.equals("BeforeName") ||
				numberRangeOccurrence.equals("AfterName") ||
				numberRangeOccurrence.equals("BeforeType") ||
				numberRangeOccurrence.equals("AfterType"))
			premiseNumberRange.setNumberRangeOccurence(numberRangeOccurrence);
	}

	@Override
	public void setPremiseNumberRangeFrom(PremiseNumberRangeFrom premiseNumberRangeFrom) {
		premiseNumberRange.setPremiseNumberRangeFrom(((PremiseNumberRangeFromImpl)premiseNumberRangeFrom).getJAXBObject());
	}

	@Override
	public void setPremiseNumberRangeTo(PremiseNumberRangeTo premiseNumberRangeTo) {
		premiseNumberRange.setPremiseNumberRangeTo(((PremiseNumberRangeToImpl)premiseNumberRangeTo).getJAXBObject());
	}

	@Override
	public void setRangeType(String rangeType) {
		premiseNumberRange.setRangeType(rangeType);
	}

	@Override
	public void setSeparator(String separator) {
		premiseNumberRange.setSeparator(separator);
	}

	@Override
	public void setType(String type) {
		premiseNumberRange.setType(type);
	}

	@Override
	public boolean isSetIndicator() {
		return premiseNumberRange.isSetIndicator();
	}

	@Override
	public boolean isSetIndicatorOccurrence() {
		return premiseNumberRange.isSetIndicatorOccurence();
	}

	@Override
	public boolean isSetNumberRangeOccurrence() {
		return premiseNumberRange.isSetNumberRangeOccurence();
	}

	@Override
	public boolean isSetPremiseNumberRangeFrom() {
		return premiseNumberRange.isSetPremiseNumberRangeFrom();
	}

	@Override
	public boolean isSetPremiseNumberRangeTo() {
		return premiseNumberRange.isSetPremiseNumberRangeTo();
	}

	@Override
	public boolean isSetRangeType() {
		return premiseNumberRange.isSetRangeType();
	}

	@Override
	public boolean isSetSeparator() {
		return premiseNumberRange.isSetSeparator();
	}

	@Override
	public boolean isSetType() {
		return premiseNumberRange.isSetType();
	}

	@Override
	public void unsetIndicator() {
		premiseNumberRange.setIndicator(null);
	}

	@Override
	public void unsetIndicatorOccurrence() {
		premiseNumberRange.setIndicatorOccurence(null);
	}

	@Override
	public void unsetNumberRangeOccurrence() {
		premiseNumberRange.setNumberRangeOccurence(null);
	}

	@Override
	public void unsetPremiseNumberRangeFrom() {
		premiseNumberRange.setPremiseNumberRangeFrom(null);
	}

	@Override
	public void unsetPremiseNumberRangeTo() {
		premiseNumberRange.setPremiseNumberRangeTo(null);
	}

	@Override
	public void unsetRangeType() {
		premiseNumberRange.setRangeType(null);
	}

	@Override
	public void unsetSeparator() {
		premiseNumberRange.setSeparator(null);
	}

	@Override
	public void unsetType() {
		premiseNumberRange.setType(null);
	}

}
