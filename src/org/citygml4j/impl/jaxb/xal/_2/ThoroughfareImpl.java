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

	@Override
	public void addAddressLine(AddressLine addressLine) {
		thoroughfare.getAddressLine().add(((AddressLineImpl)addressLine).getJAXBObject());
	}

	@Override
	public void addThoroughfareName(ThoroughfareName thoroughfareName) {
		thoroughfare.getThoroughfareName().add(((ThoroughfareNameImpl)thoroughfareName).getJAXBObject());
	}

	@Override
	public void addThoroughfareNumber(ThoroughfareNumber thoroughfareNumber) {
		thoroughfare.getThoroughfareNumberOrThoroughfareNumberRange().add(((ThoroughfareNumberImpl)thoroughfareNumber).getJAXBObject());
	}

	@Override
	public void addThoroughfareNumberPrefix(ThoroughfareNumberPrefix thoroughfareNumberPrefix) {
		thoroughfare.getThoroughfareNumberPrefix().add(((ThoroughfareNumberPrefixImpl)thoroughfareNumberPrefix).getJAXBObject());
	}

	@Override
	public void addThoroughfareNumberRange(ThoroughfareNumberRange thoroughfareNumberRange) {
		thoroughfare.getThoroughfareNumberOrThoroughfareNumberRange().add(((ThoroughfareNumberRangeImpl)thoroughfareNumberRange).getJAXBObject());
	}

	@Override
	public void addThoroughfareNumberSuffix(ThoroughfareNumberSuffix thoroughfareNumberSuffix) {
		thoroughfare.getThoroughfareNumberSuffix().add(((ThoroughfareNumberSuffixImpl)thoroughfareNumberSuffix).getJAXBObject());
	}

	@Override
	public List<AddressLine> getAddressLine() {
		List<AddressLine> addressLineList = new ArrayList<AddressLine>();
		List<AddressLineElement> addressLineElemList = thoroughfare.getAddressLine();

		for (AddressLineElement addressLineElem : addressLineElemList)
			addressLineList.add(new AddressLineImpl(addressLineElem));

		return addressLineList;
	}

	@Override
	public DependentLocality getDependentLocality() {
		if (thoroughfare.isSetDependentLocality())
			return new DependentLocalityImpl(thoroughfare.getDependentLocality());

		return null;
	}

	@Override
	public DependentThoroughfare getDependentThoroughfare() {
		if (thoroughfare.isSetDependentThoroughfare())
			return new DependentThoroughfareImpl(thoroughfare.getDependentThoroughfare());

		return null;
	}

	@Override
	public String getDependentThoroughfares() {
		return thoroughfare.getDependentThoroughfares();
	}

	@Override
	public String getDependentThoroughfaresConnector() {
		return thoroughfare.getDependentThoroughfaresConnector();
	}

	@Override
	public String getDependentThoroughfaresIndicator() {
		return thoroughfare.getDependentThoroughfaresIndicator();
	}

	@Override
	public String getDependentThoroughfaresType() {
		return thoroughfare.getDependentThoroughfaresType();
	}

	@Override
	public Firm getFirm() {
		if (thoroughfare.isSetFirm())
			return new FirmImpl(thoroughfare.getFirm());

		return null;
	}

	@Override
	public PostalCode getPostalCode() {
		if (thoroughfare.isSetPostalCode())
			return new PostalCodeImpl(thoroughfare.getPostalCode());

		return null;
	}

	@Override
	public Premise getPremise() {
		if (thoroughfare.isSetPremise())
			return new PremiseImpl(thoroughfare.getPremise());

		return null;
	}

	@Override
	public ThoroughfareLeadingType getThoroughfareLeadingType() {
		if (thoroughfare.isSetThoroughfareLeadingType())
			return new ThoroughfareLeadingTypeImpl(thoroughfare.getThoroughfareLeadingType());

		return null;
	}

	@Override
	public List<ThoroughfareName> getThoroughfareName() {
		List<ThoroughfareName> nameList = new ArrayList<ThoroughfareName>();
		List<ThoroughfareNameType> nameElemList = thoroughfare.getThoroughfareName();

		for (ThoroughfareNameType nameElem : nameElemList)
			nameList.add(new ThoroughfareNameImpl(nameElem));

		return nameList;
	}

	@Override
	public List<Object> getThoroughfareNumberOrThoroughfareNumberRange() {
		List<Object> norList = new ArrayList<Object>();
		List<Object> norElemList = thoroughfare.getThoroughfareNumberOrThoroughfareNumberRange();

		for (Object object : norElemList) {
			if (object instanceof ThoroughfareNumberElement)
				norList.add(new ThoroughfareNumberImpl((ThoroughfareNumberElement)object));
			else if (object instanceof ThoroughfareElement.ThoroughfareNumberRange)
				norList.add(new ThoroughfareNumberRangeImpl((ThoroughfareElement.ThoroughfareNumberRange)object));
		}

		return norList;
	}

	@Override
	public List<ThoroughfareNumberPrefix> getThoroughfareNumberPrefix() {
		List<ThoroughfareNumberPrefix> prefixList = new ArrayList<ThoroughfareNumberPrefix>();
		List<ThoroughfareNumberPrefixElement> prefixElemList = thoroughfare.getThoroughfareNumberPrefix();

		for (ThoroughfareNumberPrefixElement prefixElem : prefixElemList)
			prefixList.add(new ThoroughfareNumberPrefixImpl(prefixElem));

		return prefixList;
	}

	@Override
	public List<ThoroughfareNumberSuffix> getThoroughfareNumberSuffix() {
		List<ThoroughfareNumberSuffix> suffixList = new ArrayList<ThoroughfareNumberSuffix>();
		List<ThoroughfareNumberSuffixElement> suffixElemList = thoroughfare.getThoroughfareNumberSuffix();

		for (ThoroughfareNumberSuffixElement suffixElem : suffixElemList)
			suffixList.add(new ThoroughfareNumberSuffixImpl(suffixElem));

		return suffixList;
	}

	@Override
	public ThoroughfarePostDirection getThoroughfarePostDirection() {
		if (thoroughfare.isSetThoroughfarePostDirection())
			return new ThoroughfarePostDirectionImpl(thoroughfare.getThoroughfarePostDirection());

		return null;
	}

	@Override
	public ThoroughfarePreDirection getThoroughfarePreDirection() {
		if (thoroughfare.isSetThoroughfarePreDirection())
			return new ThoroughfarePreDirectionImpl(thoroughfare.getThoroughfarePreDirection());

		return null;
	}

	@Override
	public ThoroughfareTrailingType getThoroughfareTrailingType() {
		if (thoroughfare.isSetThoroughfareTrailingType())
			return new ThoroughfareTrailingTypeImpl(thoroughfare.getThoroughfareTrailingType());

		return null;
	}

	@Override
	public String getType() {
		return thoroughfare.getType();
	}

	@Override
	public void setAddressLine(List<AddressLine> addressLine) {
		List<AddressLineElement> addressLineElemList = new ArrayList<AddressLineElement>();

		for (AddressLine addressLineItem : addressLine)
			addressLineElemList.add(((AddressLineImpl)addressLineItem).getJAXBObject());

		thoroughfare.unsetAddressLine();
		thoroughfare.getAddressLine().addAll(addressLineElemList);
	}

	@Override
	public void setDependentLocality(DependentLocality dependentLocality) {
		thoroughfare.setDependentLocality(((DependentLocalityImpl)dependentLocality).getJAXBObject());
	}

	@Override
	public void setDependentThoroughfare(DependentThoroughfare dependentThoroughfare) {
		thoroughfare.setDependentThoroughfare(((DependentThoroughfareImpl)dependentThoroughfare).getJAXBObject());
	}

	@Override
	public void setDependentThoroughfares(String dependentThoroughfares) {
		if (dependentThoroughfares.equals("Yes") || dependentThoroughfares.equals("No"))
			thoroughfare.setDependentThoroughfares(dependentThoroughfares);
	}

	@Override
	public void setDependentThoroughfaresConnector(String dependentThoroughfaresConnector) {
		thoroughfare.setDependentThoroughfaresConnector(dependentThoroughfaresConnector);
	}

	@Override
	public void setDependentThoroughfaresIndicator(String dependentThoroughfaresIndicator) {
		thoroughfare.setDependentThoroughfaresIndicator(dependentThoroughfaresIndicator);
	}

	@Override
	public void setDependentThoroughfaresType(String dependentThoroughfaresType) {
		thoroughfare.setDependentThoroughfaresType(dependentThoroughfaresType);
	}

	@Override
	public void setFirm(Firm firm) {
		thoroughfare.setFirm(((FirmImpl)firm).getJAXBObject());
	}

	@Override
	public void setPostalCode(PostalCode postalCode) {
		thoroughfare.setPostalCode(((PostalCodeImpl)postalCode).getJAXBObject());
	}

	@Override
	public void setPremise(Premise premise) {
		thoroughfare.setPremise(((PremiseImpl)premise).getJAXBObject());
	}

	@Override
	public void setThoroughfareLeadingType(ThoroughfareLeadingType thoroughfareLeadingType) {
		thoroughfare.setThoroughfareLeadingType(((ThoroughfareLeadingTypeImpl)thoroughfareLeadingType).getJAXBObject());
	}

	@Override
	public void setThoroughfareName(List<ThoroughfareName> thoroughfareName) {
		List<ThoroughfareNameType> nameElemList = new ArrayList<ThoroughfareNameType>();

		for (ThoroughfareName name : thoroughfareName)
			nameElemList.add(((ThoroughfareNameImpl)name).getJAXBObject());

		thoroughfare.unsetThoroughfareName();
		thoroughfare.getThoroughfareName().addAll(nameElemList);
	}

	@Override
	public void setThoroughfareNumberPrefix(List<ThoroughfareNumberPrefix> thoroughfareNumberPrefix) {
		List<ThoroughfareNumberPrefixElement> prefixElemList = new ArrayList<ThoroughfareNumberPrefixElement>();

		for (ThoroughfareNumberPrefix prefix : thoroughfareNumberPrefix)
			prefixElemList.add(((ThoroughfareNumberPrefixImpl)prefix).getJAXBObject());

		thoroughfare.unsetThoroughfareNumberPrefix();
		thoroughfare.getThoroughfareNumberPrefix().addAll(prefixElemList);
	}

	@Override
	public void setThoroughfareNumberSuffix(List<ThoroughfareNumberSuffix> thoroughfareNumberSuffix) {
		List<ThoroughfareNumberSuffixElement> suffixElemList = new ArrayList<ThoroughfareNumberSuffixElement>();

		for (ThoroughfareNumberSuffix suffix : thoroughfareNumberSuffix)
			suffixElemList.add(((ThoroughfareNumberSuffixImpl)suffix).getJAXBObject());

		thoroughfare.unsetThoroughfareNumberSuffix();
		thoroughfare.getThoroughfareNumberSuffix().addAll(suffixElemList);
	}

	@Override
	public void setThoroughfarePostDirection(ThoroughfarePostDirection thoroughfarePostDirection) {
		thoroughfare.setThoroughfarePostDirection(((ThoroughfarePostDirectionImpl)thoroughfarePostDirection).getJAXBObject());
	}

	@Override
	public void setThoroughfarePreDirection(ThoroughfarePreDirection thoroughfarePreDirection) {
		thoroughfare.setThoroughfarePreDirection(((ThoroughfarePreDirectionImpl)thoroughfarePreDirection).getJAXBObject());
	}

	@Override
	public void setThoroughfareTrailingType(ThoroughfareTrailingType thoroughfareTrailingType) {
		thoroughfare.setThoroughfareTrailingType(((ThoroughfareTrailingTypeImpl)thoroughfareTrailingType).getJAXBObject());
	}

	@Override
	public void setType(String type) {
		thoroughfare.setType(type);
	}

	@Override
	public boolean isSetAddressLine() {
		return thoroughfare.isSetAddressLine();
	}

	@Override
	public boolean isSetDependentLocality() {
		return thoroughfare.isSetDependentLocality();
	}

	@Override
	public boolean isSetDependentThoroughfare() {
		return thoroughfare.isSetDependentThoroughfare();
	}

	@Override
	public boolean isSetDependentThoroughfares() {
		return thoroughfare.isSetDependentThoroughfares();
	}

	@Override
	public boolean isSetDependentThoroughfaresConnector() {
		return thoroughfare.isSetDependentThoroughfaresConnector();
	}

	@Override
	public boolean isSetDependentThoroughfaresIndicator() {
		return thoroughfare.isSetDependentThoroughfaresIndicator();
	}

	@Override
	public boolean isSetDependentThoroughfaresType() {
		return thoroughfare.isSetDependentThoroughfaresType();
	}

	@Override
	public boolean isSetFirm() {
		return thoroughfare.isSetFirm();
	}

	@Override
	public boolean isSetPostalCode() {
		return thoroughfare.isSetPostalCode();
	}

	@Override
	public boolean isSetPremise() {
		return thoroughfare.isSetPremise();
	}

	@Override
	public boolean isSetThoroughfareLeadingType() {
		return thoroughfare.isSetThoroughfareLeadingType();
	}

	@Override
	public boolean isSetThoroughfareName() {
		return thoroughfare.isSetThoroughfareName();
	}

	@Override
	public boolean isSetThoroughfareNumberOrThoroughfareNumberRange() {
		return thoroughfare.isSetThoroughfareNumberOrThoroughfareNumberRange();
	}

	@Override
	public boolean isSetThoroughfareNumberPrefix() {
		return thoroughfare.isSetThoroughfareNumberPrefix();
	}

	@Override
	public boolean isSetThoroughfareNumberSuffix() {
		return thoroughfare.isSetThoroughfareNumberSuffix();
	}

	@Override
	public boolean isSetThoroughfarePostDirection() {
		return thoroughfare.isSetThoroughfarePostDirection();
	}

	@Override
	public boolean isSetThoroughfarePreDirection() {
		return thoroughfare.isSetThoroughfarePreDirection();
	}

	@Override
	public boolean isSetThoroughfareTrailingType() {
		return thoroughfare.isSetThoroughfareTrailingType();
	}

	@Override
	public boolean isSetType() {
		return thoroughfare.isSetType();
	}

	@Override
	public void unsetAddressLine() {
		thoroughfare.unsetAddressLine();
	}

	@Override
	public void unsetDependentLocality() {
		thoroughfare.setDependentLocality(null);
	}

	@Override
	public void unsetDependentThoroughfare() {
		thoroughfare.setDependentThoroughfare(null);
	}

	@Override
	public void unsetDependentThoroughfares() {
		thoroughfare.setDependentThoroughfares(null);
	}

	@Override
	public void unsetDependentThoroughfaresConnector() {
		thoroughfare.setDependentThoroughfaresConnector(null);
	}

	@Override
	public void unsetDependentThoroughfaresIndicator() {
		thoroughfare.setDependentThoroughfaresIndicator(null);
	}

	@Override
	public void unsetDependentThoroughfaresType() {
		thoroughfare.setDependentThoroughfaresType(null);
	}

	@Override
	public void unsetFirm() {
		thoroughfare.setFirm(null);
	}

	@Override
	public void unsetPostalCode() {
		thoroughfare.setPostalCode(null);
	}

	@Override
	public void unsetPremise() {
		thoroughfare.setPremise(null);
	}

	@Override
	public void unsetThoroughfareLeadingType() {
		thoroughfare.setThoroughfareLeadingType(null);
	}

	@Override
	public void unsetThoroughfareName() {
		thoroughfare.unsetThoroughfareName();
	}

	@Override
	public void unsetThoroughfareNumberOrThoroughfareNumberRange() {
		thoroughfare.unsetThoroughfareNumberOrThoroughfareNumberRange();
	}

	@Override
	public void unsetThoroughfareNumberPrefix() {
		thoroughfare.unsetThoroughfareNumberPrefix();
	}

	@Override
	public void unsetThoroughfareNumberSuffix() {
		thoroughfare.unsetThoroughfareNumberSuffix();
	}

	@Override
	public void unsetThoroughfarePostDirection() {
		thoroughfare.setThoroughfarePostDirection(null);
	}

	@Override
	public void unsetThoroughfarePreDirection() {
		thoroughfare.setThoroughfarePreDirection(null);
	}

	@Override
	public void unsetThoroughfareTrailingType() {
		thoroughfare.setThoroughfareTrailingType(null);
	}

	@Override
	public void unsetType() {
		thoroughfare.setType(null);
	}

	@Override
	public boolean unsetAddressLine(AddressLine addressLine) {
		if (thoroughfare.isSetAddressLine())
			return thoroughfare.getAddressLine().remove(((AddressLineImpl)addressLine).getJAXBObject());
		
		return false;
	}

	@Override
	public boolean unsetThoroughfareName(ThoroughfareName thoroughfareName) {
		if (thoroughfare.isSetThoroughfareName())
			return thoroughfare.getThoroughfareName().remove(((ThoroughfareNameImpl)thoroughfareName).getJAXBObject());
		
		return false;
	}

	@Override
	public boolean unsetThoroughfareNumberPrefix(ThoroughfareNumberPrefix thoroughfareNumberPrefix) {
		if (thoroughfare.isSetThoroughfareNumberPrefix())
			return thoroughfare.getThoroughfareNumberPrefix().remove(((ThoroughfareNumberPrefixImpl)thoroughfareNumberPrefix).getJAXBObject());
		
		return false;
	}

	@Override
	public boolean unsetThoroughfareNumberSuffix(ThoroughfareNumberSuffix thoroughfareNumberSuffix) {
		if (thoroughfare.isSetThoroughfareNumberSuffix())
			return thoroughfare.getThoroughfareNumberSuffix().remove(((ThoroughfareNumberSuffixImpl)thoroughfareNumberSuffix).getJAXBObject());
		
		return false;
	}


}
