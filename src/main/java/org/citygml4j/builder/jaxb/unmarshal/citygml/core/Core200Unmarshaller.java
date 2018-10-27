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
package org.citygml4j.builder.jaxb.unmarshal.citygml.core;

import net.opengis.citygml._2.AbstractCityObjectType;
import net.opengis.citygml._2.AbstractSiteType;
import net.opengis.citygml._2.AddressPropertyType;
import net.opengis.citygml._2.AddressType;
import net.opengis.citygml._2.CityModelType;
import net.opengis.citygml._2.ExternalObjectReferenceType;
import net.opengis.citygml._2.ExternalReferenceType;
import net.opengis.citygml._2.GeneralizationRelationType;
import net.opengis.citygml._2.ImplicitGeometryType;
import net.opengis.citygml._2.ImplicitRepresentationPropertyType;
import net.opengis.citygml._2.RelativeToTerrainType;
import net.opengis.citygml._2.RelativeToWaterType;
import net.opengis.citygml._2.XalAddressPropertyType;
import net.opengis.citygml.appearance._2.AppearancePropertyElement;
import net.opengis.citygml.generics._2.AbstractGenericAttributeType;
import net.opengis.gml.FeaturePropertyType;
import org.citygml4j.builder.jaxb.unmarshal.JAXBUnmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.CityGMLUnmarshaller;
import org.citygml4j.geometry.Matrix;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;
import org.citygml4j.model.citygml.ade.generic.ADEGenericElement;
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
import org.citygml4j.model.citygml.core.RelativeToTerrain;
import org.citygml4j.model.citygml.core.RelativeToWater;
import org.citygml4j.model.citygml.core.TransformationMatrix2x2;
import org.citygml4j.model.citygml.core.TransformationMatrix3x4;
import org.citygml4j.model.citygml.core.TransformationMatrix4x4;
import org.citygml4j.model.citygml.core.XalAddressProperty;
import org.citygml4j.model.citygml.generics.AbstractGenericAttribute;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.gml.xlink.XLinkActuate;
import org.citygml4j.model.gml.xlink.XLinkShow;
import org.citygml4j.model.gml.xlink.XLinkType;
import org.citygml4j.model.module.citygml.CoreModule;
import org.citygml4j.util.mapper.CheckedTypeMapper;
import org.citygml4j.xml.io.reader.MissingADESchemaException;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Core200Unmarshaller {
	private final ReentrantLock lock = new ReentrantLock();
	private final CoreModule module = CoreModule.v2_0_0;
	private final JAXBUnmarshaller jaxb;
	private final CityGMLUnmarshaller citygml;
	private CheckedTypeMapper<CityGML> typeMapper;

	public Core200Unmarshaller(CityGMLUnmarshaller citygml) {
		this.citygml = citygml;
		jaxb = citygml.getJAXBUnmarshaller();
	}

	private CheckedTypeMapper<CityGML> getTypeMapper() {
		if (typeMapper == null) {
			lock.lock();
			try {
				if (typeMapper == null) {
					typeMapper = CheckedTypeMapper.<CityGML>create()
							.with(AddressType.class, this::unmarshalAddress)
							.with(AddressPropertyType.class, this::unmarshalAddressProperty)
							.with(CityModelType.class, this::unmarshalCityModel)
							.with(ExternalObjectReferenceType.class, this::unmarshalExternalObject)
							.with(ExternalReferenceType.class, this::unmarshalExternalReference)
							.with(GeneralizationRelationType.class, this::unmarshalGeneralizationRelation)
							.with(ImplicitGeometryType.class, this::unmarshalImplicitGeometry)
							.with(ImplicitRepresentationPropertyType.class, this::unmarshalImplicitRepresentationProperty)
							.with(RelativeToTerrainType.class, this::unmarshalRelativeToTerrain)
							.with(RelativeToWaterType.class, this::unmarshalRelativeToWater)
							.with(XalAddressPropertyType.class, this::unmarshalXalAddressProperty)
							.with(FeaturePropertyType.class, this::unmarshalCityObjectMember)
							.with(JAXBElement.class, this::unmarshal);
				}
			} finally {
				lock.unlock();
			}
		}

		return typeMapper;
	}

	public CityGML unmarshal(JAXBElement<?> src) throws MissingADESchemaException {
		return unmarshal(src.getValue());
	}

	public CityGML unmarshal(Object src) throws MissingADESchemaException {
		return getTypeMapper().apply(src);
	}

	public void unmarshalAbstractCityObject(AbstractCityObjectType src, AbstractCityObject dest) throws MissingADESchemaException {
		jaxb.getGMLUnmarshaller().unmarshalAbstractFeature(src, dest);

		if (src.isSetCreationDate())
			dest.setCreationDate(src.getCreationDate().toGregorianCalendar().toZonedDateTime());

		if (src.isSetTerminationDate())
			dest.setTerminationDate(src.getTerminationDate().toGregorianCalendar().toZonedDateTime());

		if (src.isSetRelativeToTerrain())
			dest.setRelativeToTerrain(unmarshalRelativeToTerrain(src.getRelativeToTerrain()));

		if (src.isSetRelativeToWater())
			dest.setRelativeToWater(unmarshalRelativeToWater(src.getRelativeToWater()));

		if (src.isSetExternalReference()) {
			for (ExternalReferenceType externalReference : src.getExternalReference())
				dest.addExternalReference(unmarshalExternalReference(externalReference));
		}

		if (src.isSetGeneralizesTo()) {
			for (GeneralizationRelationType generalizationRelation : src.getGeneralizesTo())
				dest.addGeneralizesTo(unmarshalGeneralizationRelation(generalizationRelation));
		}

		if (src.isSet_GenericAttribute()) {
			for (JAXBElement<? extends AbstractGenericAttributeType> elem : src.get_GenericAttribute()) {
				ModelObject genericAttribute = jaxb.unmarshal(elem);
				if (genericAttribute instanceof AbstractGenericAttribute)
					dest.addGenericAttribute((AbstractGenericAttribute)genericAttribute);
			}
		}

		if (src.isSetAppearance()) {
			for (AppearancePropertyElement appearance : src.getAppearance())
				dest.addAppearance(citygml.getAppearance200Unmarshaller().unmarshalAppearanceProperty(appearance));
		}

		if (src.isSet_GenericApplicationPropertyOfCityObject()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfCityObject()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfCityObject(ade);
			}
		}
	}

	public void unmarshalAbstractSite(AbstractSiteType src, AbstractSite dest) throws MissingADESchemaException {
		unmarshalAbstractCityObject(src, dest);

		if (src.isSet_GenericApplicationPropertyOfSite()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfSite()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfSite(ade);
			}
		}
	}

	public void unmarshalAddress(AddressType src, Address dest) throws MissingADESchemaException {
		jaxb.getGMLUnmarshaller().unmarshalAbstractFeature(src, dest);

		if (src.isSetXalAddress())
			dest.setXalAddress(unmarshalXalAddressProperty(src.getXalAddress()));

		if (src.isSetMultiPoint())
			dest.setMultiPoint(jaxb.getGMLUnmarshaller().unmarshalMultiPointProperty(src.getMultiPoint()));

		if (src.isSet_GenericApplicationPropertyOfAddress()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfAddress()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfAddress(ade);
			}
		}
	}

	public Address unmarshalAddress(AddressType src) throws MissingADESchemaException {
		Address dest = new Address(module);
		unmarshalAddress(src, dest);

		return dest;
	}

	public AddressProperty unmarshalAddressProperty(AddressPropertyType src) throws MissingADESchemaException {
		AddressProperty dest = new AddressProperty(module);

		if (src.isSet_Feature()) {
			ModelObject object = jaxb.unmarshal(src.get_Feature());
			if (object instanceof Address)
				dest.setAddress((Address)object);
		}

		if (src.isSet_ADEComponent())
			dest.setGenericADEElement(jaxb.getADEUnmarshaller().unmarshal(src.get_ADEComponent()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(XLinkType.fromValue(src.getType().value()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(XLinkShow.fromValue(src.getShow().value()));

		if (src.isSetActuate())
			dest.setActuate(XLinkActuate.fromValue(src.getActuate().value()));

		return dest;
	}

	public void unmarshalCityModel(CityModelType src, CityModel dest) throws MissingADESchemaException {
		jaxb.getGMLUnmarshaller().unmarshalAbstractFeatureCollection(src, dest);

		if (src.isSet_GenericApplicationPropertyOfCityModel()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfCityModel()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfCityModel(ade);
			}
		}
	}

	public CityModel unmarshalCityModel(CityModelType src) throws MissingADESchemaException {
		CityModel dest = new CityModel(module);
		unmarshalCityModel(src, dest);

		return dest;
	}

	public CityObjectMember unmarshalCityObjectMember(FeaturePropertyType src) throws MissingADESchemaException {
		CityObjectMember dest = new CityObjectMember(module);
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
		ExternalReference dest = new ExternalReference(module);
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
		ExternalObject dest = new ExternalObject(module);
		unmarshalExternalObject(src, dest);

		return dest;
	}

	public GeneralizationRelation unmarshalGeneralizationRelation(GeneralizationRelationType src) throws MissingADESchemaException {
		GeneralizationRelation dest = new GeneralizationRelation(module);

		if (src.isSet_CityObject()) {
			ModelObject object = jaxb.unmarshal(src.get_CityObject());
			if (object instanceof AbstractCityObject)
				dest.setObject((AbstractCityObject)object);
		}

		if (src.isSet_ADEComponent())
			dest.setGenericADEElement(jaxb.getADEUnmarshaller().unmarshal(src.get_ADEComponent()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(XLinkType.fromValue(src.getType().value()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(XLinkShow.fromValue(src.getShow().value()));

		if (src.isSetActuate())
			dest.setActuate(XLinkActuate.fromValue(src.getActuate().value()));

		return dest;
	}

	public void unmarshalImplicitGeometry(ImplicitGeometryType src, ImplicitGeometry dest) {
		jaxb.getGMLUnmarshaller().unmarshalAbstractGML(src, dest);

		if (src.isSetMimeType())
			dest.setMimeType(jaxb.getGMLUnmarshaller().unmarshalCode(src.getMimeType()));

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
		ImplicitGeometry dest = new ImplicitGeometry(module);
		unmarshalImplicitGeometry(src, dest);

		return dest;
	}

	public ImplicitRepresentationProperty unmarshalImplicitRepresentationProperty(ImplicitRepresentationPropertyType src) throws MissingADESchemaException {
		ImplicitRepresentationProperty dest = new ImplicitRepresentationProperty(module);

		if (src.isSetImplicitGeometry())
			dest.setImplicitGeometry(unmarshalImplicitGeometry(src.getImplicitGeometry()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(XLinkType.fromValue(src.getType().value()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(XLinkShow.fromValue(src.getShow().value()));

		if (src.isSetActuate())
			dest.setActuate(XLinkActuate.fromValue(src.getActuate().value()));

		return dest;

	}

	public TransformationMatrix2x2 unmarshalTransformationMatrix2x2(List<Double> src) {
		try {
			TransformationMatrix2x2 dest = new TransformationMatrix2x2(module);	

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
			TransformationMatrix3x4 dest = new TransformationMatrix3x4(module);	

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
			TransformationMatrix4x4 dest = new TransformationMatrix4x4(module);	

			Matrix matrix = new Matrix(4, 4);
			matrix.setMatrix(src);
			dest.setMatrix(matrix);

			return dest;
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	public RelativeToTerrain unmarshalRelativeToTerrain(RelativeToTerrainType src) {
		return RelativeToTerrain.fromValue(src.value());
	}

	public RelativeToWater unmarshalRelativeToWater(RelativeToWaterType src) {
		return RelativeToWater.fromValue(src.value());
	}

	public XalAddressProperty unmarshalXalAddressProperty(XalAddressPropertyType src) {
		XalAddressProperty dest = new XalAddressProperty(module);

		if (src.isSetAddressDetails())
			dest.setAddressDetails(jaxb.getXALUnmarshaller().unmarshalAddressDetails(src.getAddressDetails()));		

		return dest;
	}

	public boolean assignGenericProperty(ADEGenericElement genericProperty, QName substitutionGroup, CityGML dest) {
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
