/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universitaet Berlin, Germany
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
 */
package org.citygml4j.impl.citygml.core;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.base.AssociationByRepImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.core.XalAddressProperty;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.module.citygml.CoreModule;
import org.citygml4j.model.xal.AddressDetails;

public class XalAddressPropertyImpl extends AssociationByRepImpl<AddressDetails> implements XalAddressProperty {
	private CoreModule module;

	public XalAddressPropertyImpl() {
		
	}
	
	public XalAddressPropertyImpl(CoreModule module) {
		this.module = module;
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

	@Override
	public ModelType getModelType() {
		return ModelType.CITYGML;
	}
	
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.XAL_ADDRESS_PROPERTY;
	}

	public final CoreModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new XalAddressPropertyImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		XalAddressProperty copy = (target == null) ? new XalAddressPropertyImpl() : (XalAddressProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
