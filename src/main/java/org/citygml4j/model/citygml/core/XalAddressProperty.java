/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2022 Claus Nagel <claus.nagel@gmail.com>
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
package org.citygml4j.model.citygml.core;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.gml.base.AssociationByRep;
import org.citygml4j.model.xal.AddressDetails;

public class XalAddressProperty extends AssociationByRep<AddressDetails> implements CoreModuleComponent {

	public XalAddressProperty() {
		
	}
	
	public XalAddressProperty(AddressDetails addressDetails) {
		super(addressDetails);
	}
	
	public AddressDetails getAddressDetails() {
		return super.getObject();
	}

	public boolean isSetAddressDetails() {
		return super.isSetObject();
	}

	public void setAddressDetails(AddressDetails addressDetails) {
		super.setObject(addressDetails);
	}

	public void unsetAddressDetails() {
		super.unsetObject();
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.XAL_ADDRESS_PROPERTY;
	}

	public Class<AddressDetails> getAssociableClass() {
		return AddressDetails.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new XalAddressProperty(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		XalAddressProperty copy = (target == null) ? new XalAddressProperty() : (XalAddressProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
