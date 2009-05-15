package org.citygml4j.impl.jaxb.xal._2;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.jaxb.xal.AddressLineElement;
import org.citygml4j.jaxb.xal.ThoroughfareElement;
import org.citygml4j.model.xal.AddressLine;
import org.citygml4j.model.xal.ThoroughfareNumberFrom;
import org.citygml4j.model.xal.ThoroughfareNumberRange;
import org.citygml4j.model.xal.ThoroughfareNumberTo;
import org.citygml4j.model.xal.XALClass;

public class ThoroughfareNumberRangeImpl extends XALBaseImpl implements ThoroughfareNumberRange {
	private ThoroughfareElement.ThoroughfareNumberRange numberRange;

	public ThoroughfareNumberRangeImpl() {
		numberRange = new ThoroughfareElement.ThoroughfareNumberRange();
	}

	public ThoroughfareNumberRangeImpl(ThoroughfareElement.ThoroughfareNumberRange numberRange) {
		this.numberRange = numberRange;
	}

	@Override
	public ThoroughfareElement.ThoroughfareNumberRange getJAXBObject() {
		return numberRange;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.THOROUGHFARENUMBERRANGE;
	}

	public void addAddressLine(AddressLine addressLine) {
		numberRange.getAddressLine().add(((AddressLineImpl)addressLine).getJAXBObject());
	}

	public List<AddressLine> getAddressLine() {
		List<AddressLine> addressLineList = new ArrayList<AddressLine>();

		for (AddressLineElement addressLineElem : numberRange.getAddressLine())
			addressLineList.add(new AddressLineImpl(addressLineElem));

		return addressLineList;
	}

	public String getIndicator() {
		return numberRange.getIndicator();
	}

	public String getIndicatorOccurrence() {
		return numberRange.getIndicatorOccurrence();
	}

	public String getNumberRangeOccurrence() {
		return numberRange.getNumberRangeOccurrence();
	}

	public String getRangeType() {
		return numberRange.getRangeType();
	}

	public String getSeparator() {
		return numberRange.getSeparator();
	}

	public ThoroughfareNumberFrom getThoroughfareNumberFrom() {
		if (numberRange.isSetThoroughfareNumberFrom())
			return new ThoroughfareNumberFromImpl(numberRange.getThoroughfareNumberFrom());

		return null;
	}

	public ThoroughfareNumberTo getThoroughfareNumberTo() {
		if (numberRange.isSetThoroughfareNumberTo())
			return new ThoroughfareNumberToImpl(numberRange.getThoroughfareNumberTo());

		return null;
	}

	public String getType() {
		return numberRange.getType();
	}

	public void setAddressLine(List<AddressLine> addressLine) {
		List<AddressLineElement> addressLineElemList = new ArrayList<AddressLineElement>();

		for (AddressLine addressLineItem : addressLine)
			addressLineElemList.add(((AddressLineImpl)addressLineItem).getJAXBObject());

		numberRange.unsetAddressLine();
		numberRange.getAddressLine().addAll(addressLineElemList);
	}

	public void setIndicator(String indicator) {
		numberRange.setIndicator(indicator);
	}

	public void setIndicatorOccurrence(String indicatorOccurrence) {
		if (indicatorOccurrence.equals("Before") || numberRange.equals("After"))
			numberRange.setIndicatorOccurrence(indicatorOccurrence);
	}

	public void setNumberRangeOccurrence(String numberRangeOccurrence) {
		if (numberRangeOccurrence.equals("BeforeName") || 
				numberRangeOccurrence.equals("AfterName") ||
				numberRangeOccurrence.equals("BeforeType") ||
				numberRangeOccurrence.equals("AfterType"))
			numberRange.setNumberRangeOccurrence(numberRangeOccurrence);
	}

	public void setRangeType(String rangeType) {
		if (rangeType.equals("Odd") || rangeType.equals("Even"))
			numberRange.setRangeType(rangeType);
	}

	public void setSeparator(String separator) {
		numberRange.setSeparator(separator);
	}

	public void setThoroughfareNumberFrom(ThoroughfareNumberFrom thoroughfareNumberFrom) {
		numberRange.setThoroughfareNumberFrom(((ThoroughfareNumberFromImpl)thoroughfareNumberFrom).getJAXBObject());
	}

	public void setThoroughfareNumberTo(ThoroughfareNumberTo thoroughfareNumberTo) {
		numberRange.setThoroughfareNumberTo(((ThoroughfareNumberToImpl)thoroughfareNumberTo).getJAXBObject());
	}

	public void setType(String type) {
		numberRange.setType(type);
	}

	public String getCode() {
		return numberRange.getCode();
	}

	public void setCode(String code) {
		numberRange.setCode(code);
	}

	public boolean isSetAddressLine() {
		return numberRange.isSetAddressLine();
	}

	public boolean isSetIndicator() {
		return numberRange.isSetIndicator();
	}

	public boolean isSetIndicatorOccurrence() {
		return numberRange.isSetIndicatorOccurrence();
	}

	public boolean isSetNumberRangeOccurrence() {
		return numberRange.isSetNumberRangeOccurrence();
	}

	public boolean isSetRangeType() {
		return numberRange.isSetRangeType();
	}

	public boolean isSetSeparator() {
		return numberRange.isSetSeparator();
	}

	public boolean isSetThoroughfareNumberFrom() {
		return numberRange.isSetThoroughfareNumberFrom();
	}

	public boolean isSetThoroughfareNumberTo() {
		return numberRange.isSetThoroughfareNumberTo();
	}

	public boolean isSetType() {
		return numberRange.isSetType();
	}

	public void unsetAddressLine() {
		numberRange.unsetAddressLine();
	}

	public void unsetIndicator() {
		numberRange.setIndicator(null);
	}

	public void unsetIndicatorOccurrence() {
		numberRange.setIndicatorOccurrence(null);
	}

	public void unsetNumberRangeOccurrence() {
		numberRange.setNumberRangeOccurrence(null);
	}

	public void unsetRangeType() {
		numberRange.setRangeType(null);
	}

	public void unsetSeparator() {
		numberRange.setSeparator(null);
	}

	public void unsetThoroughfareNumberFrom() {
		numberRange.setThoroughfareNumberFrom(null);
	}

	public void unsetThoroughfareNumberTo() {
		numberRange.setThoroughfareNumberTo(null);
	}

	public void unsetType() {
		numberRange.setType(null);
	}

	public boolean isSetCode() {
		return numberRange.isSetCode();
	}

	public void unsetCode() {
		numberRange.setCode(null);
	}

	public boolean unsetAddressLine(AddressLine addressLine) {
		if (numberRange.isSetAddressLine())
			return numberRange.getAddressLine().remove(((AddressLineImpl)addressLine).getJAXBObject());
		
		return false;
	}

}
