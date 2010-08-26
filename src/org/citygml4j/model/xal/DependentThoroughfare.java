package org.citygml4j.model.xal;

import java.util.List;

import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.common.visitor.XALFunctor;
import org.citygml4j.model.common.visitor.XALVisitor;

public interface DependentThoroughfare extends XAL, Child, Copyable {
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
	
	public void visit(XALVisitor visitor);
	public <T> T visit(XALFunctor<T> visitor);
}
