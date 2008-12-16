package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.AddressDetails;
import org.citygml4j.model.xal.SortingCode;
import org.citygml4j.model.xal.XALClass;

public class SortingCodeImpl extends XALBaseImpl implements SortingCode {
	private AddressDetails.PostalServiceElements.SortingCode sortingCode;
	
	public SortingCodeImpl() {
		sortingCode = new AddressDetails.PostalServiceElements.SortingCode();
	}
	
	public SortingCodeImpl(AddressDetails.PostalServiceElements.SortingCode sortingCode) {
		this.sortingCode = sortingCode;
	}
	
	@Override
	public AddressDetails.PostalServiceElements.SortingCode getJAXBObject() {
		return sortingCode;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.SORTINGCODE;
	}

	@Override
	public String getType() {
		return sortingCode.getType();
	}

	@Override
	public void setType(String type) {
		sortingCode.setType(type);
	}

	@Override
	public String getCode() {
		return sortingCode.getCode();
	}

	@Override
	public void setCode(String code) {
		sortingCode.setCode(code);
	}

	@Override
	public boolean isSetType() {
		return sortingCode.isSetType();
	}

	@Override
	public void unsetType() {
		sortingCode.setType(null);
	}

	@Override
	public boolean isSetCode() {
		return sortingCode.isSetCode();
	}

	@Override
	public void unsetCode() {
		sortingCode.setCode(null);
	}
}
