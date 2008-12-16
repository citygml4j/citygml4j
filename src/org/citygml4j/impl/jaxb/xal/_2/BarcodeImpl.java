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

	@Override
	public String getContent() {
		return barcode.getContent();
	}

	@Override
	public String getType() {
		return barcode.getType();
	}

	@Override
	public void setContent(String content) {
		barcode.setContent(content);
	}

	@Override
	public void setType(String type) {
		barcode.setType(type);
	}

	@Override
	public String getCode() {
		return barcode.getCode();
	}

	@Override
	public void setCode(String code) {
		barcode.setCode(code);
	}

	@Override
	public boolean isSetContent() {
		return barcode.isSetContent();
	}

	@Override
	public boolean isSetType() {
		return barcode.isSetType();
	}

	@Override
	public void unsetContent() {
		barcode.setContent(null);
	}

	@Override
	public void unsetType() {
		barcode.setType(null);
	}

	@Override
	public boolean isSetCode() {
		return barcode.isSetCode();
	}

	@Override
	public void unsetCode() {
		barcode.setCode(null);
	}

}
