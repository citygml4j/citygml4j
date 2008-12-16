package org.citygml4j.model.xal;

import java.util.List;

public interface ThoroughfareNumberRange extends XALBase, GrPostal {
	public List<AddressLine> getAddressLine();
	public ThoroughfareNumberFrom getThoroughfareNumberFrom();
	public ThoroughfareNumberTo getThoroughfareNumberTo();
	public String getRangeType();
	public String getIndicator();
	public String getSeparator();
	public String getIndicatorOccurrence();
	public String getNumberRangeOccurrence();
	public String getType();
	public boolean isSetAddressLine();
	public boolean isSetThoroughfareNumberFrom();
	public boolean isSetThoroughfareNumberTo();
	public boolean isSetRangeType();
	public boolean isSetIndicator();
	public boolean isSetSeparator();
	public boolean isSetIndicatorOccurrence();
	public boolean isSetNumberRangeOccurrence();
	public boolean isSetType();
	
	public void addAddressLine(AddressLine addressLine);
	public void setAddressLine(List<AddressLine> addressLine);
	public void setThoroughfareNumberFrom(ThoroughfareNumberFrom thoroughfareNumberFrom);
	public void setThoroughfareNumberTo(ThoroughfareNumberTo thoroughfareNumberTo);
	public void setRangeType(String rangeType);
	public void setIndicator(String indicator);
	public void setSeparator(String separator);
	public void setIndicatorOccurrence(String indicatorOccurrence);
	public void setNumberRangeOccurrence(String numberRangeOccurrence);
	public void setType(String type);
	public void unsetAddressLine();
	public boolean unsetAddressLine(AddressLine addressLine);
	public void unsetThoroughfareNumberFrom();
	public void unsetThoroughfareNumberTo();
	public void unsetRangeType();
	public void unsetIndicator();
	public void unsetSeparator();
	public void unsetIndicatorOccurrence();
	public void unsetNumberRangeOccurrence();
	public void unsetType();
}
