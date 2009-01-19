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

	@Override
	public void addAddressLine(AddressLine addressLine) {
		dependentThoroughfare.getAddressLine().add(((AddressLineImpl)addressLine).getJAXBObject());
	}

	@Override
	public void addThoroughfareName(ThoroughfareName thoroughfareName) {
		dependentThoroughfare.getThoroughfareName().add(((ThoroughfareNameImpl)thoroughfareName).getJAXBObject());
	}

	@Override
	public List<AddressLine> getAddressLine() {
		List<AddressLine> addressLineList = new ArrayList<AddressLine>();

		for (AddressLineElement addressLineElem : dependentThoroughfare.getAddressLine())
			addressLineList.add(new AddressLineImpl(addressLineElem));

		return addressLineList;
	}

	@Override
	public ThoroughfareLeadingType getThoroughfareLeadingType() {
		if (dependentThoroughfare.isSetThoroughfareLeadingType())
			return new ThoroughfareLeadingTypeImpl(dependentThoroughfare.getThoroughfareLeadingType());

		return null;
	}

	@Override
	public List<ThoroughfareName> getThoroughfareName() {
		List<ThoroughfareName> nameList = new ArrayList<ThoroughfareName>();

		for (ThoroughfareNameType nameElem : dependentThoroughfare.getThoroughfareName())
			nameList.add(new ThoroughfareNameImpl(nameElem));

		return nameList;
	}

	@Override
	public ThoroughfarePostDirection getThoroughfarePostDirection() {
		if (dependentThoroughfare.isSetThoroughfarePostDirection())
			return new ThoroughfarePostDirectionImpl(dependentThoroughfare.getThoroughfarePostDirection());

		return null;
	}

	@Override
	public ThoroughfarePreDirection getThoroughfarePreDirection() {
		if (dependentThoroughfare.isSetThoroughfarePreDirection())
			return new ThoroughfarePreDirectionImpl(dependentThoroughfare.getThoroughfarePreDirection());

		return null;
	}

	@Override
	public ThoroughfareTrailingType getThoroughfareTrailingType() {
		if (dependentThoroughfare.isSetThoroughfareTrailingType())
			return new ThoroughfareTrailingTypeImpl(dependentThoroughfare.getThoroughfareTrailingType());

		return null;
	}

	@Override
	public String getType() {
		return dependentThoroughfare.getType();
	}

	@Override
	public void setAddressLine(List<AddressLine> addressLine) {
		List<AddressLineElement> addressLineElemList = new ArrayList<AddressLineElement>();

		for (AddressLine addressLineItem : addressLine)
			addressLineElemList.add(((AddressLineImpl)addressLineItem).getJAXBObject());

		dependentThoroughfare.unsetAddressLine();
		dependentThoroughfare.getAddressLine().addAll(addressLineElemList);
	}

	@Override
	public void setThoroughfareLeadingType(ThoroughfareLeadingType thoroughfareLeadingType) {
		dependentThoroughfare.setThoroughfareLeadingType(((ThoroughfareLeadingTypeImpl)thoroughfareLeadingType).getJAXBObject());
	}

	@Override
	public void setThoroughfareName(List<ThoroughfareName> thoroughfareName) {
		List<ThoroughfareNameType> nameElemList = new ArrayList<ThoroughfareNameType>();

		for (ThoroughfareName name : thoroughfareName)
			nameElemList.add(((ThoroughfareNameImpl)name).getJAXBObject());

		dependentThoroughfare.unsetThoroughfareName();
		dependentThoroughfare.getThoroughfareName().addAll(nameElemList);
	}

	@Override
	public void setThoroughfarePostDirection(ThoroughfarePostDirection thoroughfarePostDirection) {
		dependentThoroughfare.setThoroughfarePostDirection(((ThoroughfarePostDirectionImpl)thoroughfarePostDirection).getJAXBObject());
	}

	@Override
	public void setThoroughfarePreDirection(ThoroughfarePreDirection thoroughfarePreDirection) {
		dependentThoroughfare.setThoroughfarePreDirection(((ThoroughfarePreDirectionImpl)thoroughfarePreDirection).getJAXBObject());
	}

	@Override
	public void setThoroughfareTrailingType(ThoroughfareTrailingType thoroughfareTrailingType) {
		dependentThoroughfare.setThoroughfareTrailingType(((ThoroughfareTrailingTypeImpl)thoroughfareTrailingType).getJAXBObject());
	}

	@Override
	public void setType(String type) {
		dependentThoroughfare.setType(type);
	}

	@Override
	public boolean isSetAddressLine() {
		return dependentThoroughfare.isSetAddressLine();
	}

	@Override
	public boolean isSetThoroughfareLeadingType() {
		return dependentThoroughfare.isSetThoroughfareLeadingType();
	}

	@Override
	public boolean isSetThoroughfareName() {
		return dependentThoroughfare.isSetThoroughfareName();
	}

	@Override
	public boolean isSetThoroughfarePostDirection() {
		return dependentThoroughfare.isSetThoroughfarePostDirection();
	}

	@Override
	public boolean isSetThoroughfarePreDirection() {
		return dependentThoroughfare.isSetThoroughfarePreDirection();
	}

	@Override
	public boolean isSetThoroughfareTrailingType() {
		return dependentThoroughfare.isSetThoroughfareTrailingType();
	}

	@Override
	public boolean isSetType() {
		return dependentThoroughfare.isSetType();
	}

	@Override
	public void unsetAddressLine() {
		dependentThoroughfare.unsetAddressLine();
	}

	@Override
	public void unsetThoroughfareLeadingType() {
		dependentThoroughfare.setThoroughfareLeadingType(null);
	}

	@Override
	public void unsetThoroughfareName() {
		dependentThoroughfare.unsetThoroughfareName();
	}

	@Override
	public void unsetThoroughfarePostDirection() {
		dependentThoroughfare.setThoroughfarePostDirection(null);
	}

	@Override
	public void unsetThoroughfarePreDirection() {
		dependentThoroughfare.setThoroughfarePreDirection(null);
	}

	@Override
	public void unsetThoroughfareTrailingType() {
		dependentThoroughfare.setThoroughfareTrailingType(null);
	}

	@Override
	public void unsetType() {
		dependentThoroughfare.setType(null);
	}

	@Override
	public boolean unsetAddressLine(AddressLine addressLine) {
		if (dependentThoroughfare.isSetAddressLine())
			return dependentThoroughfare.getAddressLine().remove(((AddressLineImpl)addressLine).getJAXBObject());
		
		return false;
	}

	@Override
	public boolean unsetThoroughfareName(ThoroughfareName thoroughfareName) {
		if (dependentThoroughfare.isSetThoroughfareName())
			return dependentThoroughfare.getThoroughfareName().remove(((ThoroughfareNameImpl)thoroughfareName).getJAXBObject());
		
		return false;
	}

}
