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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 */
package org.citygml4j.model.citygml.core;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.gml.feature.FeatureProperty;
import org.citygml4j.model.module.citygml.CoreModule;

public class AddressProperty extends FeatureProperty<Address> implements CoreModuleComponent {
	private CoreModule module;
	
	public AddressProperty() {
		
	}
	
	public AddressProperty(Address address) {
		super(address);
	}
	
	public AddressProperty(String href) {
		super(href);
	}
	
	public AddressProperty(CoreModule module) {
		this.module = module;
	}
	
	public Address getAddress() {
		return super.getObject();
	}

	public boolean isSetAddress() {
		return super.isSetObject();
	}

	public void setAddress(Address address) {
		super.setObject(address);
	}

	public void unsetAddress() {
		super.unsetObject();
	}

	@Override
	public ModelType getModelType() {
		return ModelType.CITYGML;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.ADDRESS_PROPERTY;
	}

	public final CoreModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public Class<Address> getAssociableClass() {
		return Address.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new AddressProperty(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		AddressProperty copy = (target == null) ? new AddressProperty() : (AddressProperty)target;
		return super.copyTo(copy, copyBuilder);		
	}

}
