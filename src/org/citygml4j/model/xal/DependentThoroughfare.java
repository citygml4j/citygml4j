package org.citygml4j.model.xal;

import java.util.List;

public interface DependentThoroughfare extends XALBase {
	public List<AddressLine> getAddressLine();
	public ThoroughfarePreDirection getThoroughfarePreDirection();
	public ThoroughfareLeadingType getThoroughfareLeadingType();
	public List<ThoroughfareName> getThoroughfareName();
	public ThoroughfareTrailingType getThoroughfareTrailingType();
	public ThoroughfarePostDirection getThoroughfarePostDirection();
	public String getType();
	public boolean isSetAddressLine();
	public boolean isSetThoroughfarePreDirection();
	public boolean isSetThoroughfareLeadingType();
	public boolean isSetThoroughfareName();
	public boolean isSetThoroughfareTrailingType();
	public boolean isSetThoroughfarePostDirection();
	public boolean isSetType();
	
	public void addAddressLine(AddressLine addressLine);
	public void setAddressLine(List<AddressLine> addressLine);
	public void setThoroughfarePreDirection(ThoroughfarePreDirection thoroughfarePreDirection);
	public void setThoroughfareLeadingType(ThoroughfareLeadingType thoroughfareLeadingType);
	public void addThoroughfareName(ThoroughfareName thoroughfareName);
	public void setThoroughfareName(List<ThoroughfareName> thoroughfareName);
	public void setThoroughfareTrailingType(ThoroughfareTrailingType thoroughfareTrailingType);
	public void setThoroughfarePostDirection(ThoroughfarePostDirection thoroughfarePostDirection);
	public void setType(String type);
	public void unsetAddressLine();
	public boolean unsetAddressLine(AddressLine addressLine);
	public void unsetThoroughfarePreDirection();
	public void unsetThoroughfareLeadingType();
	public void unsetThoroughfareName();
	public boolean unsetThoroughfareName(ThoroughfareName thoroughfareName);
	public void unsetThoroughfareTrailingType();
	public void unsetThoroughfarePostDirection();
	public void unsetType();
}
