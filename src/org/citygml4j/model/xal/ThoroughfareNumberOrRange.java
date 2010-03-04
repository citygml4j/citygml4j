package org.citygml4j.model.xal;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface ThoroughfareNumberOrRange extends Child, Copyable {
	public ThoroughfareNumber getThoroughfareNumber();
	public ThoroughfareNumberRange getThoroughfareNumberRange();
	public boolean isSetThoroughfareNumber();
	public boolean isSetThoroughfareNumberRange();
	
	public void setThoroughfareNumber(ThoroughfareNumber thoroughfareNumber);
	public void setThoroughfareNumberRange(ThoroughfareNumberRange thoroughfareNumberRange);
	public void unsetThoroughfareNumber();
	public void unsetThoroughfareNumberRange();
}
