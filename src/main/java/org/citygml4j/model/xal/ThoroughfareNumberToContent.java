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

public class ThoroughfareNumberToContent implements XAL, Child, Copyable {
	private AddressLine addressLine;
	private ThoroughfareNumber thoroughfareNumber;
	private ThoroughfareNumberPrefix thoroughfareNumberPrefix;
	private ThoroughfareNumberSuffix thoroughfareNumberSuffix;
	private String string;	
	private ModelObject parent;
	
	public ThoroughfareNumberToContent() {
		
	}
	
	public ThoroughfareNumberToContent(AddressLine addressLine) {
		setAddressLine(addressLine);
	}
	
	public ThoroughfareNumberToContent(ThoroughfareNumber thoroughfareNumber) {
		setThoroughfareNumber(thoroughfareNumber);
	}
	
	public ThoroughfareNumberToContent(ThoroughfareNumberPrefix thoroughfareNumberPrefix) {
		setThoroughfareNumberPrefix(thoroughfareNumberPrefix);
	}
	
	public ThoroughfareNumberToContent(ThoroughfareNumberSuffix thoroughfareNumberSuffix) {
		setThoroughfareNumberSuffix(thoroughfareNumberSuffix);
	}
	
	public ThoroughfareNumberToContent(String string) {
		setString(string);
	}
	
	public XALClass getXALClass() {
		return XALClass.THOROUGHFARE_NUMBER_TO_CONTENT;
	}

	public AddressLine getAddressLine() {
		return addressLine;
	}

	public String getString() {
		return string;
	}

	public ThoroughfareNumber getThoroughfareNumber() {
		return thoroughfareNumber;
	}

	public ThoroughfareNumberPrefix getThoroughfareNumberPrefix() {
		return thoroughfareNumberPrefix;
	}

	public ThoroughfareNumberSuffix getThoroughfareNumberSuffix() {
		return thoroughfareNumberSuffix;
	}

	public boolean isSetAddressLine() {
		return addressLine != null;
	}

	public boolean isSetString() {
		return string != null;
	}

	public boolean isSetThoroughfareNumber() {
		return thoroughfareNumber != null;
	}

	public boolean isSetThoroughfareNumberPrefix() {
		return thoroughfareNumberPrefix != null;
	}

	public boolean isSetThoroughfareNumberSuffix() {
		return thoroughfareNumberSuffix != null;
	}

	public void setAddressLine(AddressLine addressLine) {
		if (addressLine != null)
			addressLine.setParent(this);
		
		this.addressLine = addressLine;
		unsetString();
		unsetThoroughfareNumber();
		unsetThoroughfareNumberPrefix();
		unsetThoroughfareNumberSuffix();
	}

	public void setThoroughfareNumber(ThoroughfareNumber thoroughfareNumber) {
		if (thoroughfareNumber != null)
			thoroughfareNumber.setParent(this);
		
		this.thoroughfareNumber = thoroughfareNumber;
		unsetString();
		unsetAddressLine();
		unsetThoroughfareNumberPrefix();
		unsetThoroughfareNumberSuffix();
	}

	public void setThoroughfareNumberPrefix(ThoroughfareNumberPrefix thoroughfareNumberPrefix) {
		if (thoroughfareNumberPrefix != null)
			thoroughfareNumberPrefix.setParent(this);
		
		this.thoroughfareNumberPrefix = thoroughfareNumberPrefix;
		unsetString();
		unsetAddressLine();
		unsetThoroughfareNumber();
		unsetThoroughfareNumberSuffix();
	}

	public void setThoroughfareNumberSuffix(ThoroughfareNumberSuffix thoroughfareNumberSuffix) {
		if (thoroughfareNumberSuffix != null)
			thoroughfareNumberSuffix.setParent(this);
		
		this.thoroughfareNumberSuffix = thoroughfareNumberSuffix;
		unsetString();
		unsetAddressLine();
		unsetThoroughfareNumber();
		unsetThoroughfareNumberPrefix();
	}

	public void setString(String string) {
		this.string = string;
		unsetAddressLine();
		unsetThoroughfareNumber();
		unsetThoroughfareNumberPrefix();
		unsetThoroughfareNumberSuffix();
	}

	public void unsetAddressLine() {
		if (isSetAddressLine())
			addressLine.unsetParent();
		
		addressLine = null;
	}

	public void unsetString() {
		string = null;
	}

	public void unsetThoroughfareNumber() {
		if (isSetThoroughfareNumber())
			thoroughfareNumber.unsetParent();
		
		thoroughfareNumber = null;
	}

	public void unsetThoroughfareNumberPrefix() {
		if (isSetThoroughfareNumberPrefix())
			thoroughfareNumberPrefix.unsetParent();
		
		thoroughfareNumberPrefix = null;
	}

	public void unsetThoroughfareNumberSuffix() {
		if (isSetThoroughfareNumberSuffix())
			thoroughfareNumberSuffix.unsetParent();
		
		thoroughfareNumberSuffix = null;
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
		return copyTo(new ThoroughfareNumberFromContent(), copyBuilder);
	}
	
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		ThoroughfareNumberToContent copy = (target == null) ? new ThoroughfareNumberToContent() : (ThoroughfareNumberToContent)target;
		
		if (isSetAddressLine()) {
			copy.setAddressLine((AddressLine)copyBuilder.copy(addressLine));
			if (copy.getAddressLine() == addressLine)
				addressLine.setParent(this);
		}
		
		if (isSetThoroughfareNumber()) {
			copy.setThoroughfareNumber((ThoroughfareNumber)copyBuilder.copy(thoroughfareNumber));
			if (copy.getThoroughfareNumber() == thoroughfareNumber)
				thoroughfareNumber.setParent(this);
		}
		
		if (isSetThoroughfareNumberPrefix()) {
			copy.setThoroughfareNumberPrefix((ThoroughfareNumberPrefix)copyBuilder.copy(thoroughfareNumberPrefix));
			if (copy.getThoroughfareNumberPrefix() == thoroughfareNumberPrefix)
				thoroughfareNumberPrefix.setParent(this);
		}
		
		if (isSetThoroughfareNumberSuffix()) {
			copy.setThoroughfareNumberSuffix((ThoroughfareNumberSuffix)copyBuilder.copy(thoroughfareNumberSuffix));
			if (copy.getThoroughfareNumberSuffix() == thoroughfareNumberSuffix)
				thoroughfareNumberSuffix.setParent(this);
		}
		
		if (isSetString())
			copy.setString(copyBuilder.copy(string));
		
		copy.unsetParent();
		
		return copy;
	}

}
