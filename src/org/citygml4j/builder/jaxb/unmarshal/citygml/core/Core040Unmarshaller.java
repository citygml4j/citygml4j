/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
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
 */
package org.citygml4j.builder.jaxb.unmarshal.citygml.core;

import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.citygml4j.builder.jaxb.unmarshal.JAXBUnmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.CityGMLUnmarshaller;
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
import org.citygml4j.jaxb.citygml._0_4.AddressPropertyType;
import org.citygml4j.jaxb.citygml._0_4.AddressType;
import org.citygml4j.jaxb.citygml._0_4.AppearancePropertyType;
import org.citygml4j.jaxb.citygml._0_4.CityModelType;
import org.citygml4j.jaxb.citygml._0_4.ExternalObjectReferenceType;
import org.citygml4j.jaxb.citygml._0_4.ExternalReferenceType;
import org.citygml4j.jaxb.citygml._0_4.GeneralizationRelationType;
import org.citygml4j.jaxb.citygml._0_4.ImplicitGeometryType;
import org.citygml4j.jaxb.citygml._0_4.ImplicitRepresentationPropertyType;
import org.citygml4j.jaxb.citygml._0_4.XalAddressPropertyType;
import org.citygml4j.jaxb.citygml._0_4._CityObjectType;
import org.citygml4j.jaxb.citygml._0_4._GenericAttributeType;
import org.citygml4j.jaxb.citygml._0_4._SiteType;
import org.citygml4j.jaxb.gml._3_1_1.FeaturePropertyType;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.AbstractSite;
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
import org.citygml4j.model.citygml.generics.AbstractGenericAttribute;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.module.citygml.CoreModule;
import org.citygml4j.xml.io.reader.MissingADESchemaException;

public class Core040Unmarshaller {
	private final CoreModule module = CoreModule.v0_4_0;
	private final JAXBUnmarshaller jaxb;
	private final CityGMLUnmarshaller citygml;

	public Core040Unmarshaller(CityGMLUnmarshaller citygml) {
		this.citygml = citygml;
		jaxb = citygml.getJAXBUnmarshaller();
	}

	public CityGML unmarshal(JAXBElement<?> src) throws MissingADESchemaException {
		return unmarshal(src.getValue());
	}

	public CityGML unmarshal(Object src) throws MissingADESchemaException {
		if (src instanceof JAXBElement<?>)
			return unmarshal((JAXBElement<?>)src);

		CityGML dest = null;

		if (src instanceof AddressType)
			dest = unmarshalAddress((AddressType)src);
		else if (src instanceof AddressPropertyType)
			dest = unmarshalAddressProperty((AddressPropertyType)src);
		else if (src instanceof CityModelType)
			dest = unmarshalCityModel((CityModelType)src);
		else if (src instanceof FeaturePropertyType)
			dest = unmarshalCityObjectMember((FeaturePropertyType)src);
		else if (src instanceof ExternalObjectReferenceType)
			dest = unmarshalExternalObject((ExternalObjectReferenceType)src);
		else if (src instanceof ExternalReferenceType)
			dest = unmarshalExternalReference((ExternalReferenceType)src);
		else if (src instanceof GeneralizationRelationType)
			dest = unmarshalGeneralizationRelation((GeneralizationRelationType)src);
		else if (src instanceof ImplicitGeometryType)
			dest = unmarshalImplicitGeometry((ImplicitGeometryType)src);
		else if (src instanceof ImplicitRepresentationPropertyType)
			dest = unmarshalImplicitRepresentationProperty((ImplicitRepresentationPropertyType)src);
		else if (src instanceof XalAddressPropertyType)
			dest = unmarshalXalAddressProperty((XalAddressPropertyType)src);

		return dest;
	}

	public void unmarshalCityObject(_CityObjectType src, AbstractCityObject dest) throws MissingADESchemaException {
		jaxb.getGMLUnmarshaller().unmarshalAbstractFeature(src, dest);

		if (src.isSetCreationDate())
			dest.setCreationDate(src.getCreationDate().toGregorianCalendar());

		if (src.isSetTerminationDate())
			dest.setTerminationDate(src.getTerminationDate().toGregorianCalendar());

		if (src.isSetExternalReference()) {
			for (ExternalReferenceType externalReference : src.getExternalReference())
				dest.addExternalReference(unmarshalExternalReference(externalReference));
		}

		if (src.isSetGeneralizesTo()) {
			for (GeneralizationRelationType generalizationRelation : src.getGeneralizesTo())
				dest.addGeneralizesTo(unmarshalGeneralizationRelation(generalizationRelation));
		}

		if (src.isSet_GenericAttribute()) {
			for (JAXBElement<? extends _GenericAttributeType> elem : src.get_GenericAttribute()) {
				ModelObject genericAttribute = jaxb.unmarshal(elem);
				if (genericAttribute instanceof AbstractGenericAttribute)
					dest.addGenericAttribute((AbstractGenericAttribute)genericAttribute);
			}
		}

		if (src.isSetAppearanceMember()) {
			for (AppearancePropertyType appearance : src.getAppearanceMember())
				dest.addAppearance(citygml.getAppearance040Unmarshaller().unmarshalAppearanceProperty(appearance));
		}
	}

	public void unmarshalSite(_SiteType src, AbstractSite dest) throws MissingADESchemaException {
		unmarshalCityObject(src, dest);
	}

	public void unmarshalAddress(AddressType src, Address dest) throws MissingADESchemaException {
		jaxb.getGMLUnmarshaller().unmarshalAbstractFeature(src, dest);

		if (src.isSetXalAddress())
			dest.setXalAddress(unmarshalXalAddressProperty(src.getXalAddress()));

		if (src.isSetMultiPoint())
			dest.setMultiPoint(jaxb.getGMLUnmarshaller().unmarshalMultiPointProperty(src.getMultiPoint()));
	}

	public Address unmarshalAddress(AddressType src) throws MissingADESchemaException {
		Address dest = new AddressImpl(module);
		unmarshalAddress(src, dest);

		return dest;
	}

	public AddressProperty unmarshalAddressProperty(AddressPropertyType src) throws MissingADESchemaException {
		AddressProperty dest = new AddressPropertyImpl(module);
		jaxb.getGMLUnmarshaller().unmarshalFeatureProperty(src, dest);

		if (src.isSet_Object()) {
			ModelObject object = jaxb.unmarshal(src.get_Object());
			if (object instanceof Address)
				dest.setObject((Address)object);
		}

		return dest;
	}

	public void unmarshalCityModel(CityModelType src, CityModel dest) throws MissingADESchemaException {
		jaxb.getGMLUnmarshaller().unmarshalAbstractFeatureCollection(src, dest);
	}

	public CityModel unmarshalCityModel(CityModelType src) throws MissingADESchemaException {
		CityModel dest = new CityModelImpl(module);
		unmarshalCityModel(src, dest);

		return dest;
	}

	public CityObjectMember unmarshalCityObjectMember(FeaturePropertyType src) throws MissingADESchemaException {
		CityObjectMember dest = new CityObjectMemberImpl(module);
		jaxb.getGMLUnmarshaller().unmarshalFeatureProperty(src, dest);

		if (src.isSet_Feature()) {
			ModelObject abstractFeature = jaxb.unmarshal(src.get_Feature());
			if (abstractFeature instanceof AbstractCityObject)
				dest.setFeature((AbstractCityObject)abstractFeature);
		}

		return dest;
	}

	public void unmarshalExternalReference(ExternalReferenceType src, ExternalReference dest) {
		if (src.isSetExternalObject())
			dest.setExternalObject(unmarshalExternalObject(src.getExternalObject()));

		if (src.isSetInformationSystem())
			dest.setInformationSystem(src.getInformationSystem());
	}

	public ExternalReference unmarshalExternalReference(ExternalReferenceType src) {
		ExternalReference dest = new ExternalReferenceImpl(module);
		unmarshalExternalReference(src, dest);

		return dest;
	}

	public void unmarshalExternalObject(ExternalObjectReferenceType src, ExternalObject dest) {
		if (src.isSetName())
			dest.setName(src.getName());

		if (src.isSetUri())
			dest.setUri(src.getUri());
	}

	public ExternalObject unmarshalExternalObject(ExternalObjectReferenceType src) {
		ExternalObject dest = new ExternalObjectImpl(module);
		unmarshalExternalObject(src, dest);

		return dest;
	}

	public GeneralizationRelation unmarshalGeneralizationRelation(GeneralizationRelationType src) throws MissingADESchemaException {
		GeneralizationRelation dest = new GeneralizationRelationImpl(module);
		jaxb.getGMLUnmarshaller().unmarshalFeatureProperty(src, dest);

		if (src.isSet_Object()) {
			ModelObject object = jaxb.unmarshal(src.get_Object());
			if (object instanceof AbstractCityObject)
				dest.setObject((AbstractCityObject)object);
		}

		return dest;
	}

	public void unmarshalImplicitGeometry(ImplicitGeometryType src, ImplicitGeometry dest) {
		jaxb.getGMLUnmarshaller().unmarshalAbstractGML(src, dest);

		if (src.isSetMimeType())
			dest.setMimeType(src.getMimeType());

		if (src.isSetLibraryObject())
			dest.setLibraryObject(src.getLibraryObject());

		if (src.isSetTransformationMatrix())
			dest.setTransformationMatrix(unmarshalTransformationMatrix4x4(src.getTransformationMatrix()));

		if (src.isSetReferencePoint())
			dest.setReferencePoint(jaxb.getGMLUnmarshaller().unmarshalPointProperty(src.getReferencePoint()));

		if (src.isSetRelativeGMLGeometry())
			dest.setRelativeGeometry(jaxb.getGMLUnmarshaller().unmarshalGeometryProperty(src.getRelativeGMLGeometry()));
	}

	public ImplicitGeometry unmarshalImplicitGeometry(ImplicitGeometryType src) {
		ImplicitGeometry dest = new ImplicitGeometryImpl(module);
		unmarshalImplicitGeometry(src, dest);

		return dest;
	}

	public ImplicitRepresentationProperty unmarshalImplicitRepresentationProperty(ImplicitRepresentationPropertyType src) throws MissingADESchemaException {
		ImplicitRepresentationProperty dest = new ImplicitRepresentationPropertyImpl(module);
		jaxb.getGMLUnmarshaller().unmarshalAssociationByRepOrRef(src, dest);

		if (src.isSet_Object()) {
			ModelObject object = jaxb.unmarshal(src.get_Object());
			if (object instanceof ImplicitGeometry)
				dest.setObject((ImplicitGeometry)object);
		}

		return dest;
	}

	public TransformationMatrix2x2 unmarshalTransformationMatrix2x2(List<Double> src) {
		try {
			TransformationMatrix2x2 dest = new TransformationMatrix2x2Impl(module);	

			Matrix matrix = new Matrix(2, 2);
			matrix.setMatrix(src);
			dest.setMatrix(matrix);

			return dest;
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	public TransformationMatrix3x4 unmarshalTransformationMatrix3x4(List<Double> src) {
		try {
			TransformationMatrix3x4 dest = new TransformationMatrix3x4Impl(module);	

			Matrix matrix = new Matrix(3, 4);
			matrix.setMatrix(src);
			dest.setMatrix(matrix);

			return dest;
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	public TransformationMatrix4x4 unmarshalTransformationMatrix4x4(List<Double> src) {
		try {
			TransformationMatrix4x4 dest = new TransformationMatrix4x4Impl(module);	

			Matrix matrix = new Matrix(4, 4);
			matrix.setMatrix(src);
			dest.setMatrix(matrix);

			return dest;
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	public XalAddressProperty unmarshalXalAddressProperty(XalAddressPropertyType src) {
		XalAddressProperty dest = new XalAddressPropertyImpl(module);

		if (src.isSetAddressDetails())
			dest.setAddressDetails(jaxb.getXALUnmarshaller().unmarshalAddressDetails(src.getAddressDetails()));		

		return dest;
	}
	
	public boolean assignGenericProperty(ADEComponent genericProperty, QName substitutionGroup, CityGML dest) {
		String name = substitutionGroup.getLocalPart();
		boolean success = true;
		
		if (dest instanceof AbstractCityObject && name.equals("_GenericApplicationPropertyOfCityObject"))
			((AbstractCityObject)dest).addGenericApplicationPropertyOfCityObject(genericProperty);
		else if (dest instanceof AbstractSite && name.equals("_GenericApplicationPropertyOfSite"))
			((AbstractSite)dest).addGenericApplicationPropertyOfSite(genericProperty);
		else if (dest instanceof Address && name.equals("_GenericApplicationPropertyOfAddress"))
			((Address)dest).addGenericApplicationPropertyOfAddress(genericProperty);
		else if (dest instanceof CityModel && name.equals("_GenericApplicationPropertyOfCityModel"))
			((CityModel)dest).addGenericApplicationPropertyOfCityModel(genericProperty);
		else 
			success = false;
		
		return success;
	}

}
