/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2012
 * Institute for Geodesy and Geoinformation Science
 * Technische Universität Berlin, Germany
 * http://www.igg.tu-berlin.de/
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 * 
 * $Id: ThoroughfareNumberOrRange.java 542 2012-11-29 20:56:44Z nagel $
 */
package org.citygml4j.model.xal;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;

public class ThoroughfareNumberOrRange implements XAL, Child, Copyable {
	private ThoroughfareNumber thoroughfareNumber;
	private ThoroughfareNumberRange thoroughfareNumberRange;
	private ModelObject parent;
	
	public ThoroughfareNumberOrRange() {
		
	}
	
	public ThoroughfareNumberOrRange(ThoroughfareNumber thoroughfareNumber) {
		setThoroughfareNumber(thoroughfareNumber);
	}
	
	public ThoroughfareNumberOrRange(ThoroughfareNumberRange thoroughfareNumberRange) {
		setThoroughfareNumberRange(thoroughfareNumberRange);
	}
	
	public ModelType getModelType() {
		return ModelType.XAL;
	}
	
	public XALClass getXALClass() {
		return XALClass.THOROUGHFARE_NUMBER_OR_RANGE;
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

	public ModelObject getParent() {
		return parent;
	}

	public void setParent(ModelObject parent) {
		this.parent = parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public void unsetParent() {
		parent = null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new ThoroughfareNumberOrRange(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		ThoroughfareNumberOrRange copy = (target == null) ? new ThoroughfareNumberOrRange() : (ThoroughfareNumberOrRange)target;
		
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
