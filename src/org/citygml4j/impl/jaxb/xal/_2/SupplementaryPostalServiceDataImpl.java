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

	public String getContent() {
		return supplementaryPostalServiceData.getContent();
	}

	public String getType() {
		return supplementaryPostalServiceData.getType();
	}

	public void setContent(String content) {
		supplementaryPostalServiceData.setContent(content);
	}

	public void setType(String type) {
		supplementaryPostalServiceData.setType(type);
	}

	public String getCode() {
		return supplementaryPostalServiceData.getCode();
	}

	public void setCode(String code) {
		supplementaryPostalServiceData.setCode(code);
	}

	public boolean isSetContent() {
		return supplementaryPostalServiceData.isSetContent();
	}

	public boolean isSetType() {
		return supplementaryPostalServiceData.isSetType();
	}

	public void unsetContent() {
		supplementaryPostalServiceData.setContent(null);
	}

	public void unsetType() {
		supplementaryPostalServiceData.setType(null);
	}

	public boolean isSetCode() {
		return supplementaryPostalServiceData.isSetCode();
	}

	public void unsetCode() {
		supplementaryPostalServiceData.setCode(null);
	}
}
