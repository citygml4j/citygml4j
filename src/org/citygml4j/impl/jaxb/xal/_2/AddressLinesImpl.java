package org.citygml4j.impl.jaxb.xal._2;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.jaxb.xal.AddressLineElement;
import org.citygml4j.jaxb.xal.AddressLinesType;
import org.citygml4j.model.xal.AddressLine;
import org.citygml4j.model.xal.AddressLines;
import org.citygml4j.model.xal.XALClass;

public class AddressLinesImpl extends XALBaseImpl implements AddressLines {
	private AddressLinesType addressLines;

	public AddressLinesImpl() {
		addressLines = new AddressLinesType();
	}

	public AddressLinesImpl(AddressLinesType addressLines) {
		this.addressLines = addressLines;
	}

	@Override
	public AddressLinesType getJAXBObject() {
		return addressLines;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.ADDRESSLINES;
	}

	@Override
	public void addAddressLine(AddressLine addressLine) {
		addressLines.getAddressLine().add(((AddressLineImpl)addressLine).getJAXBObject());
	}

	@Override
	public List<AddressLine> getAddressLine() {
		List<AddressLine> addressLineList = new ArrayList<AddressLine>();
		List<AddressLineElement> addressLineElemList = addressLines.getAddressLine();

		for (AddressLineElement addressLineElem : addressLineElemList)
			addressLineList.add(new AddressLineImpl(addressLineElem));

		return addressLineList;
	}

	@Override
	public void setAddressLine(List<AddressLine> addressLine) {
		List<AddressLineElement> addressLineElemList = new ArrayList<AddressLineElement>();

		for (AddressLine addressLineItem : addressLine)
			addressLineElemList.add(((AddressLineImpl)addressLineItem).getJAXBObject());

		addressLines.unsetAddressLine();
		addressLines.getAddressLine().addAll(addressLineElemList);
	}

	@Override
	public boolean isSetAddressLine() {
		return addressLines.isSetAddressLine();
	}

	@Override
	public void unsetAddressLine() {
		addressLines.unsetAddressLine();
	}

	@Override
	public boolean unsetAddressLine(AddressLine addressLine) {
		if (addressLines.isSetAddressLine())
			return addressLines.getAddressLine().remove(((AddressLineImpl)addressLine).getJAXBObject());
		
		return false;
	}

}
