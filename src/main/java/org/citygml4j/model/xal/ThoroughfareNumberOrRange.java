/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.citygml4j.model.xal;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelObject;
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
