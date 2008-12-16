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

	@Override
	public String getContent() {
		return postalCodeNumberExtension.getContent();
	}

	@Override
	public String getNumberExtensionSeparator() {
		return postalCodeNumberExtension.getNumberExtensionSeparator();
	}

	@Override
	public String getType() {
		return postalCodeNumberExtension.getType();
	}

	@Override
	public void setContent(String content) {
		postalCodeNumberExtension.setContent(content);
	}

	@Override
	public void setNumberExtensionSeparator(String numberExtensionSeparator) {
		postalCodeNumberExtension.setNumberExtensionSeparator(numberExtensionSeparator);
	}

	@Override
	public void setType(String type) {
		postalCodeNumberExtension.setType(type);
	}

	@Override
	public String getCode() {
		return postalCodeNumberExtension.getCode();
	}

	@Override
	public void setCode(String code) {
		postalCodeNumberExtension.setCode(code);
	}

	@Override
	public boolean isSetContent() {
		return postalCodeNumberExtension.isSetContent();
	}

	@Override
	public boolean isSetNumberExtensionSeparator() {
		return postalCodeNumberExtension.isSetNumberExtensionSeparator();
	}

	@Override
	public boolean isSetType() {
		return postalCodeNumberExtension.isSetType();
	}

	@Override
	public void unsetContent() {
		postalCodeNumberExtension.setContent(null);
	}

	@Override
	public void unsetNumberExtensionSeparator() {
		postalCodeNumberExtension.setNumberExtensionSeparator(null);
	}

	@Override
	public void unsetType() {
		postalCodeNumberExtension.setType(null);
	}

	@Override
	public boolean isSetCode() {
		return postalCodeNumberExtension.isSetCode();
	}

	@Override
	public void unsetCode() {
		postalCodeNumberExtension.setCode(null);
	}

}
