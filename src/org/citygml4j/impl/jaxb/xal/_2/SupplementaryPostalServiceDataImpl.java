package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.AddressDetails;
import org.citygml4j.model.xal.SupplementaryPostalServiceData;
import org.citygml4j.model.xal.XALClass;

public class SupplementaryPostalServiceDataImpl extends XALBaseImpl implements SupplementaryPostalServiceData {
	private AddressDetails.PostalServiceElements.SupplementaryPostalServiceData supplementaryPostalServiceData;
	
	public SupplementaryPostalServiceDataImpl() {
		supplementaryPostalServiceData = new AddressDetails.PostalServiceElements.SupplementaryPostalServiceData();
	}
	
	public SupplementaryPostalServiceDataImpl(AddressDetails.PostalServiceElements.SupplementaryPostalServiceData supplementaryPostalServiceData) {
		this.supplementaryPostalServiceData = supplementaryPostalServiceData;
	}
	
	@Override
	public AddressDetails.PostalServiceElements.SupplementaryPostalServiceData getJAXBObject() {
		return supplementaryPostalServiceData;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.ADDRESSLATITUDEDIRECTION;
	}

	@Override
	public String getContent() {
		return supplementaryPostalServiceData.getContent();
	}

	@Override
	public String getType() {
		return supplementaryPostalServiceData.getType();
	}

	@Override
	public void setContent(String content) {
		supplementaryPostalServiceData.setContent(content);
	}

	@Override
	public void setType(String type) {
		supplementaryPostalServiceData.setType(type);
	}

	@Override
	public String getCode() {
		return supplementaryPostalServiceData.getCode();
	}

	@Override
	public void setCode(String code) {
		supplementaryPostalServiceData.setCode(code);
	}

	@Override
	public boolean isSetContent() {
		return supplementaryPostalServiceData.isSetContent();
	}

	@Override
	public boolean isSetType() {
		return supplementaryPostalServiceData.isSetType();
	}

	@Override
	public void unsetContent() {
		supplementaryPostalServiceData.setContent(null);
	}

	@Override
	public void unsetType() {
		supplementaryPostalServiceData.setType(null);
	}

	@Override
	public boolean isSetCode() {
		return supplementaryPostalServiceData.isSetCode();
	}

	@Override
	public void unsetCode() {
		supplementaryPostalServiceData.setCode(null);
	}
}
