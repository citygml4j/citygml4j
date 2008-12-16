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

	@Override
	public void addAddressLine(AddressLine addressLine) {
		postBox.getAddressLine().add(((AddressLineImpl)addressLine).getJAXBObject());
	}

	@Override
	public List<AddressLine> getAddressLine() {
		List<AddressLine> addressLineList = new ArrayList<AddressLine>();
		List<AddressLineElement> addressLineElemList = postBox.getAddressLine();

		for (AddressLineElement addressLineElem : addressLineElemList)
			addressLineList.add(new AddressLineImpl(addressLineElem));

		return addressLineList;
	}

	@Override
	public Firm getFirm() {
		if (postBox.isSetFirm())
			return new FirmImpl(postBox.getFirm());

		return null;
	}

	@Override
	public String getIndicator() {
		return postBox.getIndicator();
	}

	@Override
	public PostBoxNumber getPostBoxNumber() {
		if (postBox.isSetPostBoxNumber())
			return new PostBoxNumberImpl(postBox.getPostBoxNumber());

		return null;
	}

	@Override
	public PostBoxNumberExtension getPostBoxNumberExtension() {
		if (postBox.isSetPostBoxNumberExtension())
			return new PostBoxNumberExtensionImpl(postBox.getPostBoxNumberExtension());

		return null;
	}

	@Override
	public PostBoxNumberPrefix getPostBoxNumberPrefix() {
		if (postBox.isSetPostBoxNumberPrefix())
			return new PostBoxNumberPrefixImpl(postBox.getPostBoxNumberPrefix());

		return null;
	}

	@Override
	public PostBoxNumberSuffix getPostBoxNumberSuffix() {
		if (postBox.isSetPostBoxNumberSuffix())
			return new PostBoxNumberSuffixImpl(postBox.getPostBoxNumberSuffix());

		return null;
	}

	@Override
	public PostalCode getPostalCode() {
		if (postBox.isSetPostalCode())
			return new PostalCodeImpl(postBox.getPostalCode());

		return null;
	}

	@Override
	public String getType() {
		return postBox.getType();
	}

	@Override
	public void setAddressLine(List<AddressLine> addressLine) {
		List<AddressLineElement> addressLineElemList = new ArrayList<AddressLineElement>();

		for (AddressLine addressLineItem : addressLine)
			addressLineElemList.add(((AddressLineImpl)addressLineItem).getJAXBObject());

		postBox.unsetAddressLine();
		postBox.getAddressLine().addAll(addressLineElemList);
	}

	@Override
	public void setFirm(Firm firm) {
		postBox.setFirm(((FirmImpl)firm).getJAXBObject());
	}

	@Override
	public void setIndicator(String indicator) {
		postBox.setIndicator(indicator);
	}

	@Override
	public void setPostBoxNumber(PostBoxNumber postBoxNumber) {
		postBox.setPostBoxNumber(((PostBoxNumberImpl)postBoxNumber).getJAXBObject());
	}

	@Override
	public void setPostBoxNumberExtension(PostBoxNumberExtension postBoxNumberExtension) {
		postBox.setPostBoxNumberExtension(((PostBoxNumberExtensionImpl)postBoxNumberExtension).getJAXBObject());
	}

	@Override
	public void setPostBoxNumberPrefix(PostBoxNumberPrefix postBoxNumberPrefix) {
		postBox.setPostBoxNumberPrefix(((PostBoxNumberPrefixImpl)postBoxNumberPrefix).getJAXBObject());
	}

	@Override
	public void setPostBoxNumberSuffix(PostBoxNumberSuffix postBoxNumberSuffix) {
		postBox.setPostBoxNumberSuffix(((PostBoxNumberSuffixImpl)postBoxNumberSuffix).getJAXBObject());
	}

	@Override
	public void setPostalCode(PostalCode postalCode) {
		postBox.setPostalCode(((PostalCodeImpl)postalCode).getJAXBObject());
	}

	@Override
	public void setType(String type) {
		postBox.setType(type);
	}

	@Override
	public boolean isSetAddressLine() {
		return postBox.isSetAddressLine();
	}

	@Override
	public boolean isSetIndicator() {
		return postBox.isSetIndicator();
	}

	@Override
	public boolean isSetFirm() {
		return postBox.isSetFirm();
	}

	@Override
	public boolean isSetPostalCode() {
		return postBox.isSetPostalCode();
	}

	@Override
	public boolean isSetPostBoxNumber() {
		return postBox.isSetPostBoxNumber();
	}

	@Override
	public boolean isSetPostBoxNumberExtension() {
		return postBox.isSetPostBoxNumberExtension();
	}

	@Override
	public boolean isSetPostBoxNumberPrefix() {
		return postBox.isSetPostBoxNumberPrefix();
	}

	@Override
	public boolean isSetPostBoxNumberSuffix() {
		return postBox.isSetPostBoxNumberSuffix();
	}

	@Override
	public boolean isSetType() {
		return postBox.isSetType();
	}

	@Override
	public void unsetAddressLine() {
		postBox.unsetAddressLine();
	}

	@Override
	public void unsetIndicator() {
		postBox.setIndicator(null);
	}

	@Override
	public void unsetFirm() {
		postBox.setFirm(null);
	}

	@Override
	public void unsetPostalCode() {
		postBox.setPostalCode(null);
	}

	@Override
	public void unsetPostBoxNumber() {
		postBox.setPostBoxNumber(null);
	}

	@Override
	public void unsetPostBoxNumberExtension() {
		postBox.setPostBoxNumberExtension(null);
	}

	@Override
	public void unsetPostBoxNumberPrefix() {
		postBox.setPostBoxNumberPrefix(null);
	}

	@Override
	public void unsetPostBoxNumberSuffix() {
		postBox.setPostBoxNumberSuffix(null);
	}

	@Override
	public void unsetType() {
		postBox.setType(null);
	}

	@Override
	public boolean unsetAddressLine(AddressLine addressLine) {
		if (postBox.isSetAddressLine())
			return postBox.getAddressLine().remove(((AddressLineImpl)addressLine).getJAXBObject());
		
		return false;
	}

}
