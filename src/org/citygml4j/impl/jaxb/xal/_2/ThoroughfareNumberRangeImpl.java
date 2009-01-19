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

	@Override
	public void addAddressLine(AddressLine addressLine) {
		numberRange.getAddressLine().add(((AddressLineImpl)addressLine).getJAXBObject());
	}

	@Override
	public List<AddressLine> getAddressLine() {
		List<AddressLine> addressLineList = new ArrayList<AddressLine>();

		for (AddressLineElement addressLineElem : numberRange.getAddressLine())
			addressLineList.add(new AddressLineImpl(addressLineElem));

		return addressLineList;
	}

	@Override
	public String getIndicator() {
		return numberRange.getIndicator();
	}

	@Override
	public String getIndicatorOccurrence() {
		return numberRange.getIndicatorOccurrence();
	}

	@Override
	public String getNumberRangeOccurrence() {
		return numberRange.getNumberRangeOccurrence();
	}

	@Override
	public String getRangeType() {
		return numberRange.getRangeType();
	}

	@Override
	public String getSeparator() {
		return numberRange.getSeparator();
	}

	@Override
	public ThoroughfareNumberFrom getThoroughfareNumberFrom() {
		if (numberRange.isSetThoroughfareNumberFrom())
			return new ThoroughfareNumberFromImpl(numberRange.getThoroughfareNumberFrom());

		return null;
	}

	@Override
	public ThoroughfareNumberTo getThoroughfareNumberTo() {
		if (numberRange.isSetThoroughfareNumberTo())
			return new ThoroughfareNumberToImpl(numberRange.getThoroughfareNumberTo());

		return null;
	}

	@Override
	public String getType() {
		return numberRange.getType();
	}

	@Override
	public void setAddressLine(List<AddressLine> addressLine) {
		List<AddressLineElement> addressLineElemList = new ArrayList<AddressLineElement>();

		for (AddressLine addressLineItem : addressLine)
			addressLineElemList.add(((AddressLineImpl)addressLineItem).getJAXBObject());

		numberRange.unsetAddressLine();
		numberRange.getAddressLine().addAll(addressLineElemList);
	}

	@Override
	public void setIndicator(String indicator) {
		numberRange.setIndicator(indicator);
	}

	@Override
	public void setIndicatorOccurrence(String indicatorOccurrence) {
		if (indicatorOccurrence.equals("Before") || numberRange.equals("After"))
			numberRange.setIndicatorOccurrence(indicatorOccurrence);
	}

	@Override
	public void setNumberRangeOccurrence(String numberRangeOccurrence) {
		if (numberRangeOccurrence.equals("BeforeName") || 
				numberRangeOccurrence.equals("AfterName") ||
				numberRangeOccurrence.equals("BeforeType") ||
				numberRangeOccurrence.equals("AfterType"))
			numberRange.setNumberRangeOccurrence(numberRangeOccurrence);
	}

	@Override
	public void setRangeType(String rangeType) {
		if (rangeType.equals("Odd") || rangeType.equals("Even"))
			numberRange.setRangeType(rangeType);
	}

	@Override
	public void setSeparator(String separator) {
		numberRange.setSeparator(separator);
	}

	@Override
	public void setThoroughfareNumberFrom(ThoroughfareNumberFrom thoroughfareNumberFrom) {
		numberRange.setThoroughfareNumberFrom(((ThoroughfareNumberFromImpl)thoroughfareNumberFrom).getJAXBObject());
	}

	@Override
	public void setThoroughfareNumberTo(ThoroughfareNumberTo thoroughfareNumberTo) {
		numberRange.setThoroughfareNumberTo(((ThoroughfareNumberToImpl)thoroughfareNumberTo).getJAXBObject());
	}

	@Override
	public void setType(String type) {
		numberRange.setType(type);
	}

	@Override
	public String getCode() {
		return numberRange.getCode();
	}

	@Override
	public void setCode(String code) {
		numberRange.setCode(code);
	}

	@Override
	public boolean isSetAddressLine() {
		return numberRange.isSetAddressLine();
	}

	@Override
	public boolean isSetIndicator() {
		return numberRange.isSetIndicator();
	}

	@Override
	public boolean isSetIndicatorOccurrence() {
		return numberRange.isSetIndicatorOccurrence();
	}

	@Override
	public boolean isSetNumberRangeOccurrence() {
		return numberRange.isSetNumberRangeOccurrence();
	}

	@Override
	public boolean isSetRangeType() {
		return numberRange.isSetRangeType();
	}

	@Override
	public boolean isSetSeparator() {
		return numberRange.isSetSeparator();
	}

	@Override
	public boolean isSetThoroughfareNumberFrom() {
		return numberRange.isSetThoroughfareNumberFrom();
	}

	@Override
	public boolean isSetThoroughfareNumberTo() {
		return numberRange.isSetThoroughfareNumberTo();
	}

	@Override
	public boolean isSetType() {
		return numberRange.isSetType();
	}

	@Override
	public void unsetAddressLine() {
		numberRange.unsetAddressLine();
	}

	@Override
	public void unsetIndicator() {
		numberRange.setIndicator(null);
	}

	@Override
	public void unsetIndicatorOccurrence() {
		numberRange.setIndicatorOccurrence(null);
	}

	@Override
	public void unsetNumberRangeOccurrence() {
		numberRange.setNumberRangeOccurrence(null);
	}

	@Override
	public void unsetRangeType() {
		numberRange.setRangeType(null);
	}

	@Override
	public void unsetSeparator() {
		numberRange.setSeparator(null);
	}

	@Override
	public void unsetThoroughfareNumberFrom() {
		numberRange.setThoroughfareNumberFrom(null);
	}

	@Override
	public void unsetThoroughfareNumberTo() {
		numberRange.setThoroughfareNumberTo(null);
	}

	@Override
	public void unsetType() {
		numberRange.setType(null);
	}

	@Override
	public boolean isSetCode() {
		return numberRange.isSetCode();
	}

	@Override
	public void unsetCode() {
		numberRange.setCode(null);
	}

	@Override
	public boolean unsetAddressLine(AddressLine addressLine) {
		if (numberRange.isSetAddressLine())
			return numberRange.getAddressLine().remove(((AddressLineImpl)addressLine).getJAXBObject());
		
		return false;
	}

}
