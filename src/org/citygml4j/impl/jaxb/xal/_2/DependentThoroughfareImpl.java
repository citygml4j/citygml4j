package org.citygml4j.impl.jaxb.xal._2;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.jaxb.xal.AddressLineElement;
import org.citygml4j.jaxb.xal.ThoroughfareElement;
import org.citygml4j.jaxb.xal.ThoroughfareNameType;
import org.citygml4j.model.xal.AddressLine;
import org.citygml4j.model.xal.DependentThoroughfare;
import org.citygml4j.model.xal.ThoroughfareLeadingType;
import org.citygml4j.model.xal.ThoroughfareName;
import org.citygml4j.model.xal.ThoroughfarePostDirection;
import org.citygml4j.model.xal.ThoroughfarePreDirection;
import org.citygml4j.model.xal.ThoroughfareTrailingType;
import org.citygml4j.model.xal.XALClass;

public class DependentThoroughfareImpl extends XALBaseImpl implements DependentThoroughfare {
	private ThoroughfareElement.DependentThoroughfare dependentThoroughfare;

	public DependentThoroughfareImpl() {
		dependentThoroughfare = new ThoroughfareElement.DependentThoroughfare();
	}

	public DependentThoroughfareImpl(ThoroughfareElement.DependentThoroughfare dependentThoroughfare) {
		this.dependentThoroughfare = dependentThoroughfare;
	}

	@Override
	public ThoroughfareElement.DependentThoroughfare getJAXBObject() {
		return dependentThoroughfare;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.DEPENDENTTHOROUGHFARE;
	}

	public void addAddressLine(AddressLine addressLine) {
		dependentThoroughfare.getAddressLine().add(((AddressLineImpl)addressLine).getJAXBObject());
	}

	public void addThoroughfareName(ThoroughfareName thoroughfareName) {
		dependentThoroughfare.getThoroughfareName().add(((ThoroughfareNameImpl)thoroughfareName).getJAXBObject());
	}

	public List<AddressLine> getAddressLine() {
		List<AddressLine> addressLineList = new ArrayList<AddressLine>();

		for (AddressLineElement addressLineElem : dependentThoroughfare.getAddressLine())
			addressLineList.add(new AddressLineImpl(addressLineElem));

		return addressLineList;
	}

	public ThoroughfareLeadingType getThoroughfareLeadingType() {
		if (dependentThoroughfare.isSetThoroughfareLeadingType())
			return new ThoroughfareLeadingTypeImpl(dependentThoroughfare.getThoroughfareLeadingType());

		return null;
	}

	public List<ThoroughfareName> getThoroughfareName() {
		List<ThoroughfareName> nameList = new ArrayList<ThoroughfareName>();

		for (ThoroughfareNameType nameElem : dependentThoroughfare.getThoroughfareName())
			nameList.add(new ThoroughfareNameImpl(nameElem));

		return nameList;
	}

	public ThoroughfarePostDirection getThoroughfarePostDirection() {
		if (dependentThoroughfare.isSetThoroughfarePostDirection())
			return new ThoroughfarePostDirectionImpl(dependentThoroughfare.getThoroughfarePostDirection());

		return null;
	}

	public ThoroughfarePreDirection getThoroughfarePreDirection() {
		if (dependentThoroughfare.isSetThoroughfarePreDirection())
			return new ThoroughfarePreDirectionImpl(dependentThoroughfare.getThoroughfarePreDirection());

		return null;
	}

	public ThoroughfareTrailingType getThoroughfareTrailingType() {
		if (dependentThoroughfare.isSetThoroughfareTrailingType())
			return new ThoroughfareTrailingTypeImpl(dependentThoroughfare.getThoroughfareTrailingType());

		return null;
	}

	public String getType() {
		return dependentThoroughfare.getType();
	}

	public void setAddressLine(List<AddressLine> addressLine) {
		List<AddressLineElement> addressLineElemList = new ArrayList<AddressLineElement>();

		for (AddressLine addressLineItem : addressLine)
			addressLineElemList.add(((AddressLineImpl)addressLineItem).getJAXBObject());

		dependentThoroughfare.unsetAddressLine();
		dependentThoroughfare.getAddressLine().addAll(addressLineElemList);
	}

	public void setThoroughfareLeadingType(ThoroughfareLeadingType thoroughfareLeadingType) {
		dependentThoroughfare.setThoroughfareLeadingType(((ThoroughfareLeadingTypeImpl)thoroughfareLeadingType).getJAXBObject());
	}

	public void setThoroughfareName(List<ThoroughfareName> thoroughfareName) {
		List<ThoroughfareNameType> nameElemList = new ArrayList<ThoroughfareNameType>();

		for (ThoroughfareName name : thoroughfareName)
			nameElemList.add(((ThoroughfareNameImpl)name).getJAXBObject());

		dependentThoroughfare.unsetThoroughfareName();
		dependentThoroughfare.getThoroughfareName().addAll(nameElemList);
	}

	public void setThoroughfarePostDirection(ThoroughfarePostDirection thoroughfarePostDirection) {
		dependentThoroughfare.setThoroughfarePostDirection(((ThoroughfarePostDirectionImpl)thoroughfarePostDirection).getJAXBObject());
	}

	public void setThoroughfarePreDirection(ThoroughfarePreDirection thoroughfarePreDirection) {
		dependentThoroughfare.setThoroughfarePreDirection(((ThoroughfarePreDirectionImpl)thoroughfarePreDirection).getJAXBObject());
	}

	public void setThoroughfareTrailingType(ThoroughfareTrailingType thoroughfareTrailingType) {
		dependentThoroughfare.setThoroughfareTrailingType(((ThoroughfareTrailingTypeImpl)thoroughfareTrailingType).getJAXBObject());
	}

	public void setType(String type) {
		dependentThoroughfare.setType(type);
	}

	public boolean isSetAddressLine() {
		return dependentThoroughfare.isSetAddressLine();
	}

	public boolean isSetThoroughfareLeadingType() {
		return dependentThoroughfare.isSetThoroughfareLeadingType();
	}

	public boolean isSetThoroughfareName() {
		return dependentThoroughfare.isSetThoroughfareName();
	}

	public boolean isSetThoroughfarePostDirection() {
		return dependentThoroughfare.isSetThoroughfarePostDirection();
	}

	public boolean isSetThoroughfarePreDirection() {
		return dependentThoroughfare.isSetThoroughfarePreDirection();
	}

	public boolean isSetThoroughfareTrailingType() {
		return dependentThoroughfare.isSetThoroughfareTrailingType();
	}

	public boolean isSetType() {
		return dependentThoroughfare.isSetType();
	}

	public void unsetAddressLine() {
		dependentThoroughfare.unsetAddressLine();
	}

	public void unsetThoroughfareLeadingType() {
		dependentThoroughfare.setThoroughfareLeadingType(null);
	}

	public void unsetThoroughfareName() {
		dependentThoroughfare.unsetThoroughfareName();
	}

	public void unsetThoroughfarePostDirection() {
		dependentThoroughfare.setThoroughfarePostDirection(null);
	}

	public void unsetThoroughfarePreDirection() {
		dependentThoroughfare.setThoroughfarePreDirection(null);
	}

	public void unsetThoroughfareTrailingType() {
		dependentThoroughfare.setThoroughfareTrailingType(null);
	}

	public void unsetType() {
		dependentThoroughfare.setType(null);
	}

	public boolean unsetAddressLine(AddressLine addressLine) {
		if (dependentThoroughfare.isSetAddressLine())
			return dependentThoroughfare.getAddressLine().remove(((AddressLineImpl)addressLine).getJAXBObject());
		
		return false;
	}

	public boolean unsetThoroughfareName(ThoroughfareName thoroughfareName) {
		if (dependentThoroughfare.isSetThoroughfareName())
			return dependentThoroughfare.getThoroughfareName().remove(((ThoroughfareNameImpl)thoroughfareName).getJAXBObject());
		
		return false;
	}

}
