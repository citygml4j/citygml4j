package org.citygml4j.impl.jaxb.xal._2;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.jaxb.xal.AddressLineElement;
import org.citygml4j.jaxb.xal.ThoroughfareElement;
import org.citygml4j.jaxb.xal.ThoroughfareNameType;
import org.citygml4j.jaxb.xal.ThoroughfareNumberElement;
import org.citygml4j.jaxb.xal.ThoroughfareNumberPrefixElement;
import org.citygml4j.jaxb.xal.ThoroughfareNumberSuffixElement;
import org.citygml4j.model.xal.AddressLine;
import org.citygml4j.model.xal.DependentLocality;
import org.citygml4j.model.xal.DependentThoroughfare;
import org.citygml4j.model.xal.Firm;
import org.citygml4j.model.xal.PostalCode;
import org.citygml4j.model.xal.Premise;
import org.citygml4j.model.xal.Thoroughfare;
import org.citygml4j.model.xal.ThoroughfareLeadingType;
import org.citygml4j.model.xal.ThoroughfareName;
import org.citygml4j.model.xal.ThoroughfareNumber;
import org.citygml4j.model.xal.ThoroughfareNumberPrefix;
import org.citygml4j.model.xal.ThoroughfareNumberRange;
import org.citygml4j.model.xal.ThoroughfareNumberSuffix;
import org.citygml4j.model.xal.ThoroughfarePostDirection;
import org.citygml4j.model.xal.ThoroughfarePreDirection;
import org.citygml4j.model.xal.ThoroughfareTrailingType;
import org.citygml4j.model.xal.XALClass;

public class ThoroughfareImpl extends XALBaseImpl implements Thoroughfare {
	private ThoroughfareElement thoroughfare;

	public ThoroughfareImpl() {
		thoroughfare = new ThoroughfareElement();
	}

	public ThoroughfareImpl(ThoroughfareElement thoroughfare) {
		this.thoroughfare = thoroughfare;
	}

	@Override
	public ThoroughfareElement getJAXBObject() {
		return thoroughfare;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.THOROUGHFARE;
	}

	public void addAddressLine(AddressLine addressLine) {
		thoroughfare.getAddressLine().add(((AddressLineImpl)addressLine).getJAXBObject());
	}

	public void addThoroughfareName(ThoroughfareName thoroughfareName) {
		thoroughfare.getThoroughfareName().add(((ThoroughfareNameImpl)thoroughfareName).getJAXBObject());
	}

	public void addThoroughfareNumber(ThoroughfareNumber thoroughfareNumber) {
		thoroughfare.getThoroughfareNumberOrThoroughfareNumberRange().add(((ThoroughfareNumberImpl)thoroughfareNumber).getJAXBObject());
	}

	public void addThoroughfareNumberPrefix(ThoroughfareNumberPrefix thoroughfareNumberPrefix) {
		thoroughfare.getThoroughfareNumberPrefix().add(((ThoroughfareNumberPrefixImpl)thoroughfareNumberPrefix).getJAXBObject());
	}

	public void addThoroughfareNumberRange(ThoroughfareNumberRange thoroughfareNumberRange) {
		thoroughfare.getThoroughfareNumberOrThoroughfareNumberRange().add(((ThoroughfareNumberRangeImpl)thoroughfareNumberRange).getJAXBObject());
	}

	public void addThoroughfareNumberSuffix(ThoroughfareNumberSuffix thoroughfareNumberSuffix) {
		thoroughfare.getThoroughfareNumberSuffix().add(((ThoroughfareNumberSuffixImpl)thoroughfareNumberSuffix).getJAXBObject());
	}

	public List<AddressLine> getAddressLine() {
		List<AddressLine> addressLineList = new ArrayList<AddressLine>();

		for (AddressLineElement addressLineElem : thoroughfare.getAddressLine())
			addressLineList.add(new AddressLineImpl(addressLineElem));

		return addressLineList;
	}

	public DependentLocality getDependentLocality() {
		if (thoroughfare.isSetDependentLocality())
			return new DependentLocalityImpl(thoroughfare.getDependentLocality());

		return null;
	}

	public DependentThoroughfare getDependentThoroughfare() {
		if (thoroughfare.isSetDependentThoroughfare())
			return new DependentThoroughfareImpl(thoroughfare.getDependentThoroughfare());

		return null;
	}

	public String getDependentThoroughfares() {
		return thoroughfare.getDependentThoroughfares();
	}

	public String getDependentThoroughfaresConnector() {
		return thoroughfare.getDependentThoroughfaresConnector();
	}

	public String getDependentThoroughfaresIndicator() {
		return thoroughfare.getDependentThoroughfaresIndicator();
	}

	public String getDependentThoroughfaresType() {
		return thoroughfare.getDependentThoroughfaresType();
	}

	public Firm getFirm() {
		if (thoroughfare.isSetFirm())
			return new FirmImpl(thoroughfare.getFirm());

		return null;
	}

	public PostalCode getPostalCode() {
		if (thoroughfare.isSetPostalCode())
			return new PostalCodeImpl(thoroughfare.getPostalCode());

		return null;
	}

	public Premise getPremise() {
		if (thoroughfare.isSetPremise())
			return new PremiseImpl(thoroughfare.getPremise());

		return null;
	}

	public ThoroughfareLeadingType getThoroughfareLeadingType() {
		if (thoroughfare.isSetThoroughfareLeadingType())
			return new ThoroughfareLeadingTypeImpl(thoroughfare.getThoroughfareLeadingType());

		return null;
	}

	public List<ThoroughfareName> getThoroughfareName() {
		List<ThoroughfareName> nameList = new ArrayList<ThoroughfareName>();

		for (ThoroughfareNameType nameElem : thoroughfare.getThoroughfareName())
			nameList.add(new ThoroughfareNameImpl(nameElem));

		return nameList;
	}

	public List<Object> getThoroughfareNumberOrThoroughfareNumberRange() {
		List<Object> norList = new ArrayList<Object>();

		for (Object object : thoroughfare.getThoroughfareNumberOrThoroughfareNumberRange()) {
			if (object instanceof ThoroughfareNumberElement)
				norList.add(new ThoroughfareNumberImpl((ThoroughfareNumberElement)object));
			else if (object instanceof ThoroughfareElement.ThoroughfareNumberRange)
				norList.add(new ThoroughfareNumberRangeImpl((ThoroughfareElement.ThoroughfareNumberRange)object));
		}

		return norList;
	}

	public List<ThoroughfareNumberPrefix> getThoroughfareNumberPrefix() {
		List<ThoroughfareNumberPrefix> prefixList = new ArrayList<ThoroughfareNumberPrefix>();

		for (ThoroughfareNumberPrefixElement prefixElem : thoroughfare.getThoroughfareNumberPrefix())
			prefixList.add(new ThoroughfareNumberPrefixImpl(prefixElem));

		return prefixList;
	}

	public List<ThoroughfareNumberSuffix> getThoroughfareNumberSuffix() {
		List<ThoroughfareNumberSuffix> suffixList = new ArrayList<ThoroughfareNumberSuffix>();

		for (ThoroughfareNumberSuffixElement suffixElem : thoroughfare.getThoroughfareNumberSuffix())
			suffixList.add(new ThoroughfareNumberSuffixImpl(suffixElem));

		return suffixList;
	}

	public ThoroughfarePostDirection getThoroughfarePostDirection() {
		if (thoroughfare.isSetThoroughfarePostDirection())
			return new ThoroughfarePostDirectionImpl(thoroughfare.getThoroughfarePostDirection());

		return null;
	}

	public ThoroughfarePreDirection getThoroughfarePreDirection() {
		if (thoroughfare.isSetThoroughfarePreDirection())
			return new ThoroughfarePreDirectionImpl(thoroughfare.getThoroughfarePreDirection());

		return null;
	}

	public ThoroughfareTrailingType getThoroughfareTrailingType() {
		if (thoroughfare.isSetThoroughfareTrailingType())
			return new ThoroughfareTrailingTypeImpl(thoroughfare.getThoroughfareTrailingType());

		return null;
	}

	public String getType() {
		return thoroughfare.getType();
	}

	public void setAddressLine(List<AddressLine> addressLine) {
		List<AddressLineElement> addressLineElemList = new ArrayList<AddressLineElement>();

		for (AddressLine addressLineItem : addressLine)
			addressLineElemList.add(((AddressLineImpl)addressLineItem).getJAXBObject());

		thoroughfare.unsetAddressLine();
		thoroughfare.getAddressLine().addAll(addressLineElemList);
	}

	public void setDependentLocality(DependentLocality dependentLocality) {
		thoroughfare.setDependentLocality(((DependentLocalityImpl)dependentLocality).getJAXBObject());
	}

	public void setDependentThoroughfare(DependentThoroughfare dependentThoroughfare) {
		thoroughfare.setDependentThoroughfare(((DependentThoroughfareImpl)dependentThoroughfare).getJAXBObject());
	}

	public void setDependentThoroughfares(String dependentThoroughfares) {
		if (dependentThoroughfares.equals("Yes") || dependentThoroughfares.equals("No"))
			thoroughfare.setDependentThoroughfares(dependentThoroughfares);
	}

	public void setDependentThoroughfaresConnector(String dependentThoroughfaresConnector) {
		thoroughfare.setDependentThoroughfaresConnector(dependentThoroughfaresConnector);
	}

	public void setDependentThoroughfaresIndicator(String dependentThoroughfaresIndicator) {
		thoroughfare.setDependentThoroughfaresIndicator(dependentThoroughfaresIndicator);
	}

	public void setDependentThoroughfaresType(String dependentThoroughfaresType) {
		thoroughfare.setDependentThoroughfaresType(dependentThoroughfaresType);
	}

	public void setFirm(Firm firm) {
		thoroughfare.setFirm(((FirmImpl)firm).getJAXBObject());
	}

	public void setPostalCode(PostalCode postalCode) {
		thoroughfare.setPostalCode(((PostalCodeImpl)postalCode).getJAXBObject());
	}

	public void setPremise(Premise premise) {
		thoroughfare.setPremise(((PremiseImpl)premise).getJAXBObject());
	}

	public void setThoroughfareLeadingType(ThoroughfareLeadingType thoroughfareLeadingType) {
		thoroughfare.setThoroughfareLeadingType(((ThoroughfareLeadingTypeImpl)thoroughfareLeadingType).getJAXBObject());
	}

	public void setThoroughfareName(List<ThoroughfareName> thoroughfareName) {
		List<ThoroughfareNameType> nameElemList = new ArrayList<ThoroughfareNameType>();

		for (ThoroughfareName name : thoroughfareName)
			nameElemList.add(((ThoroughfareNameImpl)name).getJAXBObject());

		thoroughfare.unsetThoroughfareName();
		thoroughfare.getThoroughfareName().addAll(nameElemList);
	}

	public void setThoroughfareNumberPrefix(List<ThoroughfareNumberPrefix> thoroughfareNumberPrefix) {
		List<ThoroughfareNumberPrefixElement> prefixElemList = new ArrayList<ThoroughfareNumberPrefixElement>();

		for (ThoroughfareNumberPrefix prefix : thoroughfareNumberPrefix)
			prefixElemList.add(((ThoroughfareNumberPrefixImpl)prefix).getJAXBObject());

		thoroughfare.unsetThoroughfareNumberPrefix();
		thoroughfare.getThoroughfareNumberPrefix().addAll(prefixElemList);
	}

	public void setThoroughfareNumberSuffix(List<ThoroughfareNumberSuffix> thoroughfareNumberSuffix) {
		List<ThoroughfareNumberSuffixElement> suffixElemList = new ArrayList<ThoroughfareNumberSuffixElement>();

		for (ThoroughfareNumberSuffix suffix : thoroughfareNumberSuffix)
			suffixElemList.add(((ThoroughfareNumberSuffixImpl)suffix).getJAXBObject());

		thoroughfare.unsetThoroughfareNumberSuffix();
		thoroughfare.getThoroughfareNumberSuffix().addAll(suffixElemList);
	}

	public void setThoroughfarePostDirection(ThoroughfarePostDirection thoroughfarePostDirection) {
		thoroughfare.setThoroughfarePostDirection(((ThoroughfarePostDirectionImpl)thoroughfarePostDirection).getJAXBObject());
	}

	public void setThoroughfarePreDirection(ThoroughfarePreDirection thoroughfarePreDirection) {
		thoroughfare.setThoroughfarePreDirection(((ThoroughfarePreDirectionImpl)thoroughfarePreDirection).getJAXBObject());
	}

	public void setThoroughfareTrailingType(ThoroughfareTrailingType thoroughfareTrailingType) {
		thoroughfare.setThoroughfareTrailingType(((ThoroughfareTrailingTypeImpl)thoroughfareTrailingType).getJAXBObject());
	}

	public void setType(String type) {
		thoroughfare.setType(type);
	}

	public boolean isSetAddressLine() {
		return thoroughfare.isSetAddressLine();
	}

	public boolean isSetDependentLocality() {
		return thoroughfare.isSetDependentLocality();
	}

	public boolean isSetDependentThoroughfare() {
		return thoroughfare.isSetDependentThoroughfare();
	}

	public boolean isSetDependentThoroughfares() {
		return thoroughfare.isSetDependentThoroughfares();
	}

	public boolean isSetDependentThoroughfaresConnector() {
		return thoroughfare.isSetDependentThoroughfaresConnector();
	}

	public boolean isSetDependentThoroughfaresIndicator() {
		return thoroughfare.isSetDependentThoroughfaresIndicator();
	}

	public boolean isSetDependentThoroughfaresType() {
		return thoroughfare.isSetDependentThoroughfaresType();
	}

	public boolean isSetFirm() {
		return thoroughfare.isSetFirm();
	}

	public boolean isSetPostalCode() {
		return thoroughfare.isSetPostalCode();
	}

	public boolean isSetPremise() {
		return thoroughfare.isSetPremise();
	}

	public boolean isSetThoroughfareLeadingType() {
		return thoroughfare.isSetThoroughfareLeadingType();
	}

	public boolean isSetThoroughfareName() {
		return thoroughfare.isSetThoroughfareName();
	}

	public boolean isSetThoroughfareNumberOrThoroughfareNumberRange() {
		return thoroughfare.isSetThoroughfareNumberOrThoroughfareNumberRange();
	}

	public boolean isSetThoroughfareNumberPrefix() {
		return thoroughfare.isSetThoroughfareNumberPrefix();
	}

	public boolean isSetThoroughfareNumberSuffix() {
		return thoroughfare.isSetThoroughfareNumberSuffix();
	}

	public boolean isSetThoroughfarePostDirection() {
		return thoroughfare.isSetThoroughfarePostDirection();
	}

	public boolean isSetThoroughfarePreDirection() {
		return thoroughfare.isSetThoroughfarePreDirection();
	}

	public boolean isSetThoroughfareTrailingType() {
		return thoroughfare.isSetThoroughfareTrailingType();
	}

	public boolean isSetType() {
		return thoroughfare.isSetType();
	}

	public void unsetAddressLine() {
		thoroughfare.unsetAddressLine();
	}

	public void unsetDependentLocality() {
		thoroughfare.setDependentLocality(null);
	}

	public void unsetDependentThoroughfare() {
		thoroughfare.setDependentThoroughfare(null);
	}

	public void unsetDependentThoroughfares() {
		thoroughfare.setDependentThoroughfares(null);
	}

	public void unsetDependentThoroughfaresConnector() {
		thoroughfare.setDependentThoroughfaresConnector(null);
	}

	public void unsetDependentThoroughfaresIndicator() {
		thoroughfare.setDependentThoroughfaresIndicator(null);
	}

	public void unsetDependentThoroughfaresType() {
		thoroughfare.setDependentThoroughfaresType(null);
	}

	public void unsetFirm() {
		thoroughfare.setFirm(null);
	}

	public void unsetPostalCode() {
		thoroughfare.setPostalCode(null);
	}

	public void unsetPremise() {
		thoroughfare.setPremise(null);
	}

	public void unsetThoroughfareLeadingType() {
		thoroughfare.setThoroughfareLeadingType(null);
	}

	public void unsetThoroughfareName() {
		thoroughfare.unsetThoroughfareName();
	}

	public void unsetThoroughfareNumberOrThoroughfareNumberRange() {
		thoroughfare.unsetThoroughfareNumberOrThoroughfareNumberRange();
	}

	public void unsetThoroughfareNumberPrefix() {
		thoroughfare.unsetThoroughfareNumberPrefix();
	}

	public void unsetThoroughfareNumberSuffix() {
		thoroughfare.unsetThoroughfareNumberSuffix();
	}

	public void unsetThoroughfarePostDirection() {
		thoroughfare.setThoroughfarePostDirection(null);
	}

	public void unsetThoroughfarePreDirection() {
		thoroughfare.setThoroughfarePreDirection(null);
	}

	public void unsetThoroughfareTrailingType() {
		thoroughfare.setThoroughfareTrailingType(null);
	}

	public void unsetType() {
		thoroughfare.setType(null);
	}

	public boolean unsetAddressLine(AddressLine addressLine) {
		if (thoroughfare.isSetAddressLine())
			return thoroughfare.getAddressLine().remove(((AddressLineImpl)addressLine).getJAXBObject());
		
		return false;
	}

	public boolean unsetThoroughfareName(ThoroughfareName thoroughfareName) {
		if (thoroughfare.isSetThoroughfareName())
			return thoroughfare.getThoroughfareName().remove(((ThoroughfareNameImpl)thoroughfareName).getJAXBObject());
		
		return false;
	}

	public boolean unsetThoroughfareNumberPrefix(ThoroughfareNumberPrefix thoroughfareNumberPrefix) {
		if (thoroughfare.isSetThoroughfareNumberPrefix())
			return thoroughfare.getThoroughfareNumberPrefix().remove(((ThoroughfareNumberPrefixImpl)thoroughfareNumberPrefix).getJAXBObject());
		
		return false;
	}

	public boolean unsetThoroughfareNumberSuffix(ThoroughfareNumberSuffix thoroughfareNumberSuffix) {
		if (thoroughfare.isSetThoroughfareNumberSuffix())
			return thoroughfare.getThoroughfareNumberSuffix().remove(((ThoroughfareNumberSuffixImpl)thoroughfareNumberSuffix).getJAXBObject());
		
		return false;
	}


}
