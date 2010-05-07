package org.citygml4j.impl.jaxb.xal._2;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.jaxb.xal.AddressLineElement;
import org.citygml4j.jaxb.xal.PostBoxElement;
import org.citygml4j.model.xal.AddressLine;
import org.citygml4j.model.xal.Firm;
import org.citygml4j.model.xal.PostBox;
import org.citygml4j.model.xal.PostBoxNumber;
import org.citygml4j.model.xal.PostBoxNumberExtension;
import org.citygml4j.model.xal.PostBoxNumberPrefix;
import org.citygml4j.model.xal.PostBoxNumberSuffix;
import org.citygml4j.model.xal.PostalCode;
import org.citygml4j.model.xal.XALClass;

public class PostBoxImpl extends XALBaseImpl implements PostBox {
	private PostBoxElement postBox;

	public PostBoxImpl() {
		postBox = new PostBoxElement();
	}

	public PostBoxImpl(PostBoxElement postBox) {
		this.postBox = postBox;
	}

	@Override
	public PostBoxElement getJAXBObject() {
		return postBox;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.POSTBOX;
	}

	public void addAddressLine(AddressLine addressLine) {
		postBox.getAddressLine().add(((AddressLineImpl)addressLine).getJAXBObject());
	}

	public List<AddressLine> getAddressLine() {
		List<AddressLine> addressLineList = new ArrayList<AddressLine>();

		for (AddressLineElement addressLineElem : postBox.getAddressLine())
			addressLineList.add(new AddressLineImpl(addressLineElem));

		return addressLineList;
	}

	public Firm getFirm() {
		if (postBox.isSetFirm())
			return new FirmImpl(postBox.getFirm());

		return null;
	}

	public String getIndicator() {
		return postBox.getIndicator();
	}

	public PostBoxNumber getPostBoxNumber() {
		if (postBox.isSetPostBoxNumber())
			return new PostBoxNumberImpl(postBox.getPostBoxNumber());

		return null;
	}

	public PostBoxNumberExtension getPostBoxNumberExtension() {
		if (postBox.isSetPostBoxNumberExtension())
			return new PostBoxNumberExtensionImpl(postBox.getPostBoxNumberExtension());

		return null;
	}

	public PostBoxNumberPrefix getPostBoxNumberPrefix() {
		if (postBox.isSetPostBoxNumberPrefix())
			return new PostBoxNumberPrefixImpl(postBox.getPostBoxNumberPrefix());

		return null;
	}

	public PostBoxNumberSuffix getPostBoxNumberSuffix() {
		if (postBox.isSetPostBoxNumberSuffix())
			return new PostBoxNumberSuffixImpl(postBox.getPostBoxNumberSuffix());

		return null;
	}

	public PostalCode getPostalCode() {
		if (postBox.isSetPostalCode())
			return new PostalCodeImpl(postBox.getPostalCode());

		return null;
	}

	public String getType() {
		return postBox.getType();
	}

	public void setAddressLine(List<AddressLine> addressLine) {
		List<AddressLineElement> addressLineElemList = new ArrayList<AddressLineElement>();

		for (AddressLine addressLineItem : addressLine)
			addressLineElemList.add(((AddressLineImpl)addressLineItem).getJAXBObject());

		postBox.unsetAddressLine();
		postBox.getAddressLine().addAll(addressLineElemList);
	}

	public void setFirm(Firm firm) {
		postBox.setFirm(((FirmImpl)firm).getJAXBObject());
	}

	public void setIndicator(String indicator) {
		postBox.setIndicator(indicator);
	}

	public void setPostBoxNumber(PostBoxNumber postBoxNumber) {
		postBox.setPostBoxNumber(((PostBoxNumberImpl)postBoxNumber).getJAXBObject());
	}

	public void setPostBoxNumberExtension(PostBoxNumberExtension postBoxNumberExtension) {
		postBox.setPostBoxNumberExtension(((PostBoxNumberExtensionImpl)postBoxNumberExtension).getJAXBObject());
	}

	public void setPostBoxNumberPrefix(PostBoxNumberPrefix postBoxNumberPrefix) {
		postBox.setPostBoxNumberPrefix(((PostBoxNumberPrefixImpl)postBoxNumberPrefix).getJAXBObject());
	}

	public void setPostBoxNumberSuffix(PostBoxNumberSuffix postBoxNumberSuffix) {
		postBox.setPostBoxNumberSuffix(((PostBoxNumberSuffixImpl)postBoxNumberSuffix).getJAXBObject());
	}

	public void setPostalCode(PostalCode postalCode) {
		postBox.setPostalCode(((PostalCodeImpl)postalCode).getJAXBObject());
	}

	public void setType(String type) {
		postBox.setType(type);
	}

	public boolean isSetAddressLine() {
		return postBox.isSetAddressLine();
	}

	public boolean isSetIndicator() {
		return postBox.isSetIndicator();
	}

	public boolean isSetFirm() {
		return postBox.isSetFirm();
	}

	public boolean isSetPostalCode() {
		return postBox.isSetPostalCode();
	}

	public boolean isSetPostBoxNumber() {
		return postBox.isSetPostBoxNumber();
	}

	public boolean isSetPostBoxNumberExtension() {
		return postBox.isSetPostBoxNumberExtension();
	}

	public boolean isSetPostBoxNumberPrefix() {
		return postBox.isSetPostBoxNumberPrefix();
	}

	public boolean isSetPostBoxNumberSuffix() {
		return postBox.isSetPostBoxNumberSuffix();
	}

	public boolean isSetType() {
		return postBox.isSetType();
	}

	public void unsetAddressLine() {
		postBox.unsetAddressLine();
	}

	public void unsetIndicator() {
		postBox.setIndicator(null);
	}

	public void unsetFirm() {
		postBox.setFirm(null);
	}

	public void unsetPostalCode() {
		postBox.setPostalCode(null);
	}

	public void unsetPostBoxNumber() {
		postBox.setPostBoxNumber(null);
	}

	public void unsetPostBoxNumberExtension() {
		postBox.setPostBoxNumberExtension(null);
	}

	public void unsetPostBoxNumberPrefix() {
		postBox.setPostBoxNumberPrefix(null);
	}

	public void unsetPostBoxNumberSuffix() {
		postBox.setPostBoxNumberSuffix(null);
	}

	public void unsetType() {
		postBox.setType(null);
	}

	public boolean unsetAddressLine(AddressLine addressLine) {
		if (postBox.isSetAddressLine())
			return postBox.getAddressLine().remove(((AddressLineImpl)addressLine).getJAXBObject());
		
		return false;
	}

}
