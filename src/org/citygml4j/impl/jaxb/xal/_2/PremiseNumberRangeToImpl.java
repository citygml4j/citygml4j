package org.citygml4j.impl.jaxb.xal._2;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.jaxb.xal.AddressLineElement;
import org.citygml4j.jaxb.xal.PremiseElement;
import org.citygml4j.jaxb.xal.PremiseNumberElement;
import org.citygml4j.jaxb.xal.PremiseNumberPrefixElement;
import org.citygml4j.jaxb.xal.PremiseNumberSuffixElement;
import org.citygml4j.model.xal.AddressLine;
import org.citygml4j.model.xal.PremiseNumber;
import org.citygml4j.model.xal.PremiseNumberPrefix;
import org.citygml4j.model.xal.PremiseNumberRangeTo;
import org.citygml4j.model.xal.PremiseNumberSuffix;
import org.citygml4j.model.xal.XALClass;

public class PremiseNumberRangeToImpl extends XALBaseImpl implements PremiseNumberRangeTo {
	private PremiseElement.PremiseNumberRange.PremiseNumberRangeTo premiseNumberRangeTo;

	public PremiseNumberRangeToImpl() {
		premiseNumberRangeTo = new PremiseElement.PremiseNumberRange.PremiseNumberRangeTo();
	}

	public PremiseNumberRangeToImpl(PremiseElement.PremiseNumberRange.PremiseNumberRangeTo premiseNumberRangeTo) {
		this.premiseNumberRangeTo = premiseNumberRangeTo;
	}

	@Override
	public PremiseElement.PremiseNumberRange.PremiseNumberRangeTo getJAXBObject() {
		return premiseNumberRangeTo;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.PREMISENUMBERRANGETO;
	}

	public void addAddressLine(AddressLine addressLine) {
		premiseNumberRangeTo.getAddressLine().add(((AddressLineImpl)addressLine).getJAXBObject());
	}

	public void addPremiseNumber(PremiseNumber premiseNumber) {
		premiseNumberRangeTo.getPremiseNumber().add(((PremiseNumberImpl)premiseNumber).getJAXBObject());
	}

	public void addPremiseNumberPrefix(PremiseNumberPrefix premiseNumberPrefix) {
		premiseNumberRangeTo.getPremiseNumberPrefix().add(((PremiseNumberPrefixImpl)premiseNumberPrefix).getJAXBObject());
	}

	public void addPremiseNumberSuffix(PremiseNumberSuffix premiseNumberSuffix) {
		premiseNumberRangeTo.getPremiseNumberSuffix().add(((PremiseNumberSuffixImpl)premiseNumberSuffix).getJAXBObject());
	}

	public List<AddressLine> getAddressLine() {
		List<AddressLine> addressLineList = new ArrayList<AddressLine>();

		for (AddressLineElement addressLineElem : premiseNumberRangeTo.getAddressLine())
			addressLineList.add(new AddressLineImpl(addressLineElem));

		return addressLineList;
	}

	public List<PremiseNumber> getPremiseNumber() {
		List<PremiseNumber> premiseNumberList = new ArrayList<PremiseNumber>();

		for (PremiseNumberElement premiseNumberElem : premiseNumberRangeTo.getPremiseNumber())
			premiseNumberList.add(new PremiseNumberImpl(premiseNumberElem));

		return premiseNumberList;
	}

	public List<PremiseNumberPrefix> getPremiseNumberPrefix() {
		List<PremiseNumberPrefix> prefixList = new ArrayList<PremiseNumberPrefix>();

		for (PremiseNumberPrefixElement prefixElem : premiseNumberRangeTo.getPremiseNumberPrefix())
			prefixList.add(new PremiseNumberPrefixImpl(prefixElem));

		return prefixList;
	}

	public List<PremiseNumberSuffix> getPremiseNumberSuffix() {
		List<PremiseNumberSuffix> suffixList = new ArrayList<PremiseNumberSuffix>();

		for (PremiseNumberSuffixElement suffixElem : premiseNumberRangeTo.getPremiseNumberSuffix())
			suffixList.add(new PremiseNumberSuffixImpl(suffixElem));

		return suffixList;
	}

	public void setAddressLine(List<AddressLine> addressLine) {
		List<AddressLineElement> addressLineElemList = new ArrayList<AddressLineElement>();

		for (AddressLine addressLineItem : addressLine)
			addressLineElemList.add(((AddressLineImpl)addressLineItem).getJAXBObject());

		premiseNumberRangeTo.unsetAddressLine();
		premiseNumberRangeTo.getAddressLine().addAll(addressLineElemList);
	}

	public void setPremiseNumber(List<PremiseNumber> premiseNumber) {
		List<PremiseNumberElement> premiseNumberElemList = new ArrayList<PremiseNumberElement>();

		for (PremiseNumber premiseNumberItem : premiseNumber)
			premiseNumberElemList.add(((PremiseNumberImpl)premiseNumberItem).getJAXBObject());

		premiseNumberRangeTo.unsetPremiseNumber();
		premiseNumberRangeTo.getPremiseNumber().addAll(premiseNumberElemList);
	}

	public void setPremiseNumberPrefix(List<PremiseNumberPrefix> premiseNumberPrefix) {
		List<PremiseNumberPrefixElement> prefixElemList = new ArrayList<PremiseNumberPrefixElement>();

		for (PremiseNumberPrefix prefixItem : premiseNumberPrefix)
			prefixElemList.add(((PremiseNumberPrefixImpl)prefixItem).getJAXBObject());

		premiseNumberRangeTo.unsetPremiseNumberPrefix();
		premiseNumberRangeTo.getPremiseNumberPrefix().addAll(prefixElemList);
	}

	public void setPremiseNumberSuffix(List<PremiseNumberSuffix> premiseNumberSuffix) {
		List<PremiseNumberSuffixElement> suffixElemList = new ArrayList<PremiseNumberSuffixElement>();

		for (PremiseNumberSuffix suffixItem : premiseNumberSuffix)
			suffixElemList.add(((PremiseNumberSuffixImpl)suffixItem).getJAXBObject());

		premiseNumberRangeTo.unsetPremiseNumberSuffix();
		premiseNumberRangeTo.getPremiseNumberSuffix().addAll(suffixElemList);
	}

	public boolean isSetAddressLine() {
		return premiseNumberRangeTo.isSetAddressLine();
	}

	public boolean isSetPremiseNumber() {
		return premiseNumberRangeTo.isSetPremiseNumber();
	}

	public boolean isSetPremiseNumberPrefix() {
		return premiseNumberRangeTo.isSetPremiseNumberPrefix();
	}

	public boolean isSetPremiseNumberSuffix() {
		return premiseNumberRangeTo.isSetPremiseNumberSuffix();
	}

	public void unsetAddressLine() {
		premiseNumberRangeTo.unsetAddressLine();
	}

	public void unsetPremiseNumber() {
		premiseNumberRangeTo.unsetPremiseNumber();
	}

	public void unsetPremiseNumberPrefix() {
		premiseNumberRangeTo.unsetPremiseNumberPrefix();
	}

	public void unsetPremiseNumberSuffix() {
		premiseNumberRangeTo.unsetPremiseNumberSuffix();
	}

	public boolean unsetAddressLine(AddressLine addressLine) {
		if (premiseNumberRangeTo.isSetAddressLine())
			return premiseNumberRangeTo.getAddressLine().remove(((AddressLineImpl)addressLine).getJAXBObject());
		
		return false;
	}

	public boolean unsetPremiseNumber(PremiseNumber premiseNumber) {
		if (premiseNumberRangeTo.isSetPremiseNumber())
			return premiseNumberRangeTo.getPremiseNumber().remove(((PremiseNumberImpl)premiseNumber).getJAXBObject());
		
		return false;
	}

	public boolean unsetPremiseNumberPrefix(PremiseNumberPrefix premiseNumberPrefix) {
		if (premiseNumberRangeTo.isSetPremiseNumberPrefix())
			return premiseNumberRangeTo.getPremiseNumberPrefix().remove(((PremiseNumberPrefixImpl)premiseNumberPrefix).getJAXBObject());
		
		return false;
	}

	public boolean unsetPremiseNumberSuffix(PremiseNumberSuffix premiseNumberSuffix) {
		if (premiseNumberRangeTo.isSetPremiseNumberSuffix())
			return premiseNumberRangeTo.getPremiseNumberSuffix().remove(((PremiseNumberSuffixImpl)premiseNumberSuffix).getJAXBObject());
		
		return false;
	}
	
}
