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
package org.citygml4j.factory;

import org.citygml4j.geometry.Matrix;
import org.citygml4j.impl.citygml.core.AddressImpl;
import org.citygml4j.impl.citygml.core.AddressPropertyImpl;
import org.citygml4j.impl.citygml.core.CityModelImpl;
import org.citygml4j.impl.citygml.core.CityObjectMemberImpl;
import org.citygml4j.impl.citygml.core.ExternalObjectImpl;
import org.citygml4j.impl.citygml.core.ExternalReferenceImpl;
import org.citygml4j.impl.citygml.core.GeneralizationRelationImpl;
import org.citygml4j.impl.citygml.core.ImplicitGeometryImpl;
import org.citygml4j.impl.citygml.core.ImplicitRepresentationPropertyImpl;
import org.citygml4j.impl.citygml.core.TransformationMatrix2x2Impl;
import org.citygml4j.impl.citygml.core.TransformationMatrix3x4Impl;
import org.citygml4j.impl.citygml.core.TransformationMatrix4x4Impl;
import org.citygml4j.impl.citygml.core.XalAddressPropertyImpl;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.Address;
import org.citygml4j.model.citygml.core.AddressProperty;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.citygml.core.CityObjectMember;
import org.citygml4j.model.citygml.core.ExternalObject;
import org.citygml4j.model.citygml.core.ExternalReference;
import org.citygml4j.model.citygml.core.GeneralizationRelation;
import org.citygml4j.model.citygml.core.ImplicitGeometry;
import org.citygml4j.model.citygml.core.ImplicitRepresentationProperty;
import org.citygml4j.model.citygml.core.TransformationMatrix2x2;
import org.citygml4j.model.citygml.core.TransformationMatrix3x4;
import org.citygml4j.model.citygml.core.TransformationMatrix4x4;
import org.citygml4j.model.citygml.core.XalAddressProperty;
import org.citygml4j.model.xal.AddressDetails;
import org.w3c.dom.Element;

public class CoreFactory {

	public CoreFactory() {
		
	}

	public Address createAddress() {
		return new AddressImpl();
	}

	public AddressProperty createAddressProperty() {
		return new AddressPropertyImpl();
	}
	
	public AddressProperty createAddressProperty(Address address) {
		AddressProperty addressProperty = new AddressPropertyImpl();
		addressProperty.setAddress(address);
		return addressProperty;
	}
	
	public AddressProperty createAddressProperty(String xlink) {
		AddressProperty addressProperty = new AddressPropertyImpl();
		addressProperty.setHref(xlink);
		return addressProperty;
	}

	public CityModel createCityModel() {
		return new CityModelImpl();
	}

	public CityObjectMember createCityObjectMember() {
		return new CityObjectMemberImpl();
	}
	
	public CityObjectMember createCityObjectMember(AbstractCityObject cityObject) {
		CityObjectMember cityObjectMember = new CityObjectMemberImpl();
		cityObjectMember.setCityObject(cityObject);
		return cityObjectMember;
	}
	
	public CityObjectMember createCityObjectMember(String xlink) {
		CityObjectMember cityObjectMember = new CityObjectMemberImpl();
		cityObjectMember.setHref(xlink);
		return cityObjectMember;
	}

	public ExternalObject createExternalObject() {
		return new ExternalObjectImpl();
	}

	public ExternalReference createExternalReference() {
		return new ExternalReferenceImpl();
	}

	public GeneralizationRelation createGeneralizationRelation() {
		return new GeneralizationRelationImpl();
	}
	
	public GeneralizationRelation createGeneralizationRelation(AbstractCityObject cityObject) {
		GeneralizationRelation generalizationRelation = new GeneralizationRelationImpl();
		generalizationRelation.setCityObject(cityObject);
		return generalizationRelation;
	}
	
	public GeneralizationRelation createGeneralizationRelation(String xlink) {
		GeneralizationRelation generalizationRelation = new GeneralizationRelationImpl();
		generalizationRelation.setHref(xlink);
		return generalizationRelation;
	}
	
	public ADEComponent createADEComponent() {
		return new ADEComponent();
	}

	public ADEComponent createADEComponent(Element content) {
		return new ADEComponent(content);
	}
	
	public ImplicitGeometry createImplicitGeometry() {
		return new ImplicitGeometryImpl();
	}

	public ImplicitRepresentationProperty createImplicitRepresentationProperty() {
		return new ImplicitRepresentationPropertyImpl();
	}
	
	public ImplicitRepresentationProperty createImplicitRepresentationProperty(ImplicitGeometry implicitGeometry) {
		ImplicitRepresentationProperty implicitRepresentationProperty = new ImplicitRepresentationPropertyImpl();
		implicitRepresentationProperty.setImplicitGeometry(implicitGeometry);
		return implicitRepresentationProperty;
	}
	
	public ImplicitRepresentationProperty createImplicitRepresentationProperty(String xlink) {
		ImplicitRepresentationProperty implicitRepresentationProperty = new ImplicitRepresentationPropertyImpl();
		implicitRepresentationProperty.setHref(xlink);
		return implicitRepresentationProperty;
	}

	public TransformationMatrix2x2 createTransformationMatrix2x2() {
		return new TransformationMatrix2x2Impl();
	}

	public TransformationMatrix2x2 createTransformationMatrix2x2(Matrix matrix) {
		return new TransformationMatrix2x2Impl(matrix);
	}

	public TransformationMatrix3x4 createTransformationMatrix3x4() {
		return new TransformationMatrix3x4Impl();
	}

	public TransformationMatrix3x4 createTransformationMatrix3x4(Matrix matrix) {
		return new TransformationMatrix3x4Impl(matrix);
	}

	public TransformationMatrix4x4 createTransformationMatrix4x4() {
		return new TransformationMatrix4x4Impl();
	}

	public TransformationMatrix4x4 createTransformationMatrix4x4(Matrix matrix) {
		return new TransformationMatrix4x4Impl(matrix);
	}

	public XalAddressProperty createXalAddressProperty() {
		return new XalAddressPropertyImpl();
	}
	
	public XalAddressProperty createXalAddressProperty(AddressDetails addressDetails) {
		XalAddressProperty xalAddressProperty = new XalAddressPropertyImpl();
		xalAddressProperty.setAddressDetails(addressDetails);
		return xalAddressProperty;
	}
	
}
