package org.citygml4j.impl.xal;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.xal.ThoroughfareNumber;
import org.citygml4j.model.xal.ThoroughfareNumberOrRange;
import org.citygml4j.model.xal.ThoroughfareNumberRange;

public class ThoroughfareNumberOrRangeImpl implements ThoroughfareNumberOrRange {
	private ThoroughfareNumber thoroughfareNumber;
	private ThoroughfareNumberRange thoroughfareNumberRange;
	private Object parent;
	
	public ThoroughfareNumberOrRangeImpl() {
		
	}
	
	public ThoroughfareNumberOrRangeImpl(ThoroughfareNumber thoroughfareNumber) {
		setThoroughfareNumber(thoroughfareNumber);
	}
	
	public ThoroughfareNumberOrRangeImpl(ThoroughfareNumberRange thoroughfareNumberRange) {
		setThoroughfareNumberRange(thoroughfareNumberRange);
	}
	
	public ThoroughfareNumber getThoroughfareNumber() {
		return thoroughfareNumber;
	}

	public ThoroughfareNumberRange getThoroughfareNumberRange() {
		return thoroughfareNumberRange;
	}

	public boolean isSetThoroughfareNumber() {
		return thoroughfareNumber != null;
	}

	public boolean isSetThoroughfareNumberRange() {
		return thoroughfareNumberRange != null;
	}

	public void setThoroughfareNumber(ThoroughfareNumber thoroughfareNumber) {
		if (thoroughfareNumber != null)
			thoroughfareNumber.setParent(this);
		
		this.thoroughfareNumber = thoroughfareNumber;
		unsetThoroughfareNumberRange();
	}

	public void setThoroughfareNumberRange(ThoroughfareNumberRange thoroughfareNumberRange) {
		if (thoroughfareNumberRange != null)
			thoroughfareNumberRange.setParent(this);
		
		this.thoroughfareNumberRange = thoroughfareNumberRange;
		unsetThoroughfareNumber();
	}

	public void unsetThoroughfareNumber() {
		if (isSetThoroughfareNumber())
			thoroughfareNumber.unsetParent();
		
		thoroughfareNumber = null;
	}

	public void unsetThoroughfareNumberRange() {
		if (isSetThoroughfareNumberRange())
			thoroughfareNumberRange.unsetParent();
		
		thoroughfareNumberRange = null;
	}

	public Object getParent() {
		return parent;
	}

	public void setParent(Object parent) {
		this.parent = parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public void unsetParent() {
		parent = null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new ThoroughfareNumberOrRangeImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		ThoroughfareNumberOrRange copy = (target == null) ? new ThoroughfareNumberOrRangeImpl() : (ThoroughfareNumberOrRange)target;
		
		if (isSetThoroughfareNumber()) {
			copy.setThoroughfareNumber((ThoroughfareNumber)copyBuilder.copy(thoroughfareNumber));
			if (copy.getThoroughfareNumber() == thoroughfareNumber)
				thoroughfareNumber.setParent(this);
		}
		
		if (isSetThoroughfareNumberRange()) {
			copy.setThoroughfareNumberRange((ThoroughfareNumberRange)copyBuilder.copy(thoroughfareNumberRange));
			if (copy.getThoroughfareNumberRange() == thoroughfareNumberRange)
				thoroughfareNumberRange.setParent(this);
		}
		
		copy.unsetParent();
		
		return copy;
	}

}
