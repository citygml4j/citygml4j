package org.citygml4j.model.xal;

import java.util.List;

public interface PremiseNumberRangeFrom extends XALBase {
	public List<AddressLine> getAddressLine();
	public List<PremiseNumberPrefix> getPremiseNumberPrefix();
	public List<PremiseNumber> getPremiseNumber();
	public List<PremiseNumberSuffix> getPremiseNumberSuffix();
	public boolean isSetAddressLine();
	public boolean isSetPremiseNumberPrefix();
	public boolean isSetPremiseNumber();
	public boolean isSetPremiseNumberSuffix();
	
	public void addAddressLine(AddressLine addressLine);
	public void setAddressLine(List<AddressLine> addressLine);
	public void addPremiseNumberPrefix(PremiseNumberPrefix premiseNumberPrefix);
	public void setPremiseNumberPrefix(List<PremiseNumberPrefix> premiseNumberPrefix);
	public void addPremiseNumber(PremiseNumber premiseNumber);
	public void setPremiseNumber(List<PremiseNumber> premiseNumber);
	public void addPremiseNumberSuffix(PremiseNumberSuffix premiseNumberSuffix);
	public void setPremiseNumberSuffix(List<PremiseNumberSuffix> premiseNumberSuffix);
	public void unsetAddressLine();
	public boolean unsetAddressLine(AddressLine addressLine);
	public void unsetPremiseNumberPrefix();
	public boolean unsetPremiseNumberPrefix(PremiseNumberPrefix premiseNumberPrefix);
	public void unsetPremiseNumber();
	public boolean unsetPremiseNumber(PremiseNumber premiseNumber);
	public void unsetPremiseNumberSuffix();
	public boolean unsetPremiseNumberSuffix(PremiseNumberSuffix premiseNumberSuffix);
}
