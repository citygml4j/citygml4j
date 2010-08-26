package org.citygml4j.model.xal;

import java.util.List;

import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.common.visitor.XALFunctor;
import org.citygml4j.model.common.visitor.XALVisitor;

public interface ThoroughfareNumberTo extends XAL, GrPostal, Child, Copyable {
	public List<ThoroughfareNumberToContent> getContent();
	public boolean isSetContent();
	
	public void addContent(ThoroughfareNumberToContent content);
	public void setContent(List<ThoroughfareNumberToContent> content);
	public void addAddressLine(AddressLine addressLine);
	public void addThoroughfareNumberPrefix(ThoroughfareNumberPrefix thoroughfareNumberPrefix);
	public void addThoroughfareNumber(ThoroughfareNumber thoroughfareNumber);
	public void addThoroughfareNumberSuffix(ThoroughfareNumberSuffix thoroughfareNumberSuffix);
	public void addString(String string);
	public void unsetContent();
	public boolean unsetContent(ThoroughfareNumberToContent content);
	public boolean unsetAddressLine(AddressLine addressLine);
	public boolean unsetThoroughfareNumberPrefix(ThoroughfareNumberPrefix thoroughfareNumberPrefix);
	public boolean unsetThoroughfareNumber(ThoroughfareNumber thoroughfareNumber);
	public boolean unsetThoroughfareNumberSuffix(ThoroughfareNumberSuffix thoroughfareNumberSuffix);
	public boolean unsetString(String string);
	
	public void visit(XALVisitor visitor);
	public <T> T visit(XALFunctor<T> visitor);
}
