package org.citygml4j.model.xal;

import java.util.List;

public interface ThoroughfareNumberFrom extends XALBase, GrPostal {
	public String getContent();
	public List<AddressLine> getAddressLine();
	public List<ThoroughfareNumberPrefix> getThoroughfareNumberPrefix();
	public List<ThoroughfareNumber> getThoroughfareNumber();
	public List<ThoroughfareNumberSuffix> getThoroughfareNumberSuffix();
	public boolean isSetContent();
	public boolean isSetAddressLine();
	public boolean isSetThoroughfareNumberPrefix();
	public boolean isSetThoroughfareNumber();
	public boolean isSetThoroughfareNumberSuffix();
	
	public void addContent(String content);
	public void addAddressLine(AddressLine addressLine);
	public void setAddressLine(List<AddressLine> addressLine);
	public void addThoroughfareNumberPrefix(ThoroughfareNumberPrefix thoroughfareNumberPrefix);
	public void setThoroughfareNumberPrefix(List<ThoroughfareNumberPrefix> thoroughfareNumberPrefix);
	public void addThoroughfareNumber(ThoroughfareNumber thoroughfareNumber);
	public void setThoroughfareNumber(List<ThoroughfareNumber> thoroughfareNumber);
	public void addThoroughfareNumberSuffix(ThoroughfareNumberSuffix thoroughfareNumberSuffix);
	public void setThoroughfareNumberSuffix(List<ThoroughfareNumberSuffix> thoroughfareNumberSuffix);
	public void unsetContent();
	public void unsetAddressLine();
	public boolean unsetAddressLine(AddressLine addressLine);
	public void unsetThoroughfareNumberPrefix();
	public boolean unsetThoroughfareNumberPrefix(ThoroughfareNumberPrefix thoroughfareNumberPrefix);
	public void unsetThoroughfareNumber();
	public boolean unsetThoroughfareNumber(ThoroughfareNumber thoroughfareNumber);
	public void unsetThoroughfareNumberSuffix();
	public boolean unsetThoroughfareNumberSuffix(ThoroughfareNumberSuffix thoroughfareNumberSuffix);
}
