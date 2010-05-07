package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.AddressDetails;
import org.citygml4j.model.xal.Barcode;
import org.citygml4j.model.xal.XALClass;

public class BarcodeImpl extends XALBaseImpl implements Barcode {
	private AddressDetails.PostalServiceElements.Barcode barcode;
	
	public BarcodeImpl() {
		barcode = new AddressDetails.PostalServiceElements.Barcode();
	}
	
	public BarcodeImpl(AddressDetails.PostalServiceElements.Barcode barcode) {
		this.barcode = barcode;
	}
	
	@Override
	public AddressDetails.PostalServiceElements.Barcode getJAXBObject() {
		return barcode;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.BARCODE;
	}

	public String getContent() {
		return barcode.getContent();
	}

	public String getType() {
		return barcode.getType();
	}

	public void setContent(String content) {
		barcode.setContent(content);
	}

	public void setType(String type) {
		barcode.setType(type);
	}

	public String getCode() {
		return barcode.getCode();
	}

	public void setCode(String code) {
		barcode.setCode(code);
	}

	public boolean isSetContent() {
		return barcode.isSetContent();
	}

	public boolean isSetType() {
		return barcode.isSetType();
	}

	public void unsetContent() {
		barcode.setContent(null);
	}

	public void unsetType() {
		barcode.setType(null);
	}

	public boolean isSetCode() {
		return barcode.isSetCode();
	}

	public void unsetCode() {
		barcode.setCode(null);
	}

}
