package org.citygml4j.model.xal;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface ThoroughfareNumberFromContent extends Child, Copyable {
	public AddressLine getAddressLine();
	public ThoroughfareNumber getThoroughfareNumber();
	public ThoroughfareNumberPrefix getThoroughfareNumberPrefix();
	public ThoroughfareNumberSuffix getThoroughfareNumberSuffix();
	public String getString();
	public boolean isSetAddressLine();
	public boolean isSetThoroughfareNumber();
	public boolean isSetThoroughfareNumberPrefix();
	public boolean isSetThoroughfareNumberSuffix();
	public boolean isSetString();
	
	public void setAddressLine(AddressLine addressLine);
	public void setThoroughfareNumber(ThoroughfareNumber thoroughfareNumber);
	public void setThoroughfareNumberPrefix(ThoroughfareNumberPrefix thoroughfareNumberPrefix);
	public void setThoroughfareNumberSuffix(ThoroughfareNumberSuffix thoroughfareNumberSuffix);
	public void setString(String string);
	public void unsetAddressLine();
	public void unsetThoroughfareNumber();
	public void unsetThoroughfareNumberPrefix();
	public void unsetThoroughfareNumberSuffix();
	public void unsetString();
}
