package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.PostalCodeElement;
import org.citygml4j.model.xal.PostalCodeNumberExtension;
import org.citygml4j.model.xal.XALClass;

public class PostalCodeNumberExtensionImpl extends XALBaseImpl implements PostalCodeNumberExtension {
	private PostalCodeElement.PostalCodeNumberExtension postalCodeNumberExtension;
	
	public PostalCodeNumberExtensionImpl() {
		postalCodeNumberExtension = new PostalCodeElement.PostalCodeNumberExtension();
	}
	
	public PostalCodeNumberExtensionImpl(PostalCodeElement.PostalCodeNumberExtension postalCodeNumberExtension) {
		this.postalCodeNumberExtension = postalCodeNumberExtension;
	}
	
	@Override
	public PostalCodeElement.PostalCodeNumberExtension getJAXBObject() {
		return postalCodeNumberExtension;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.POSTALCODENUMBEREXTENSION;
	}

	public String getContent() {
		return postalCodeNumberExtension.getContent();
	}

	public String getNumberExtensionSeparator() {
		return postalCodeNumberExtension.getNumberExtensionSeparator();
	}

	public String getType() {
		return postalCodeNumberExtension.getType();
	}

	public void setContent(String content) {
		postalCodeNumberExtension.setContent(content);
	}

	public void setNumberExtensionSeparator(String numberExtensionSeparator) {
		postalCodeNumberExtension.setNumberExtensionSeparator(numberExtensionSeparator);
	}

	public void setType(String type) {
		postalCodeNumberExtension.setType(type);
	}

	public String getCode() {
		return postalCodeNumberExtension.getCode();
	}

	public void setCode(String code) {
		postalCodeNumberExtension.setCode(code);
	}

	public boolean isSetContent() {
		return postalCodeNumberExtension.isSetContent();
	}

	public boolean isSetNumberExtensionSeparator() {
		return postalCodeNumberExtension.isSetNumberExtensionSeparator();
	}

	public boolean isSetType() {
		return postalCodeNumberExtension.isSetType();
	}

	public void unsetContent() {
		postalCodeNumberExtension.setContent(null);
	}

	public void unsetNumberExtensionSeparator() {
		postalCodeNumberExtension.setNumberExtensionSeparator(null);
	}

	public void unsetType() {
		postalCodeNumberExtension.setType(null);
	}

	public boolean isSetCode() {
		return postalCodeNumberExtension.isSetCode();
	}

	public void unsetCode() {
		postalCodeNumberExtension.setCode(null);
	}

}
