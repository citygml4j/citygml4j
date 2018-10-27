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
package org.citygml4j.builder.jaxb.marshal.citygml.core;

import net.opengis.citygml._1.AbstractCityObjectType;
import net.opengis.citygml._1.AbstractSiteType;
import net.opengis.citygml._1.AddressPropertyType;
import net.opengis.citygml._1.AddressType;
import net.opengis.citygml._1.CityModelType;
import net.opengis.citygml._1.ExternalObjectReferenceType;
import net.opengis.citygml._1.ExternalReferenceType;
import net.opengis.citygml._1.GeneralizationRelationType;
import net.opengis.citygml._1.ImplicitGeometryType;
import net.opengis.citygml._1.ImplicitRepresentationPropertyType;
import net.opengis.citygml._1.ObjectFactory;
import net.opengis.citygml._1.XalAddressPropertyType;
import net.opengis.citygml.appearance._1.AppearancePropertyType;
import net.opengis.citygml.generics._1.AbstractGenericAttributeType;
import net.opengis.gml.FeaturePropertyType;
import org.citygml4j.builder.jaxb.marshal.JAXBMarshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.appearance.AppearanceMember;
import org.citygml4j.model.citygml.appearance.AppearanceProperty;
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
import org.citygml4j.model.citygml.generics.GenericAttributeSet;
import org.citygml4j.model.citygml.generics.StringAttribute;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.util.mapper.TypeMapper;
import org.w3._1999.xlink.ActuateType;
import org.w3._1999.xlink.ShowType;
import org.w3._1999.xlink.TypeType;
import org.w3c.dom.Element;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConstants;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Core100Marshaller {
	private final ReentrantLock lock = new ReentrantLock();
	private final ObjectFactory core = new ObjectFactory();
	private final JAXBMarshaller jaxb;
	private final CityGMLMarshaller citygml;
	private TypeMapper<JAXBElement<?>> elementMapper;
	private TypeMapper<Object> typeMapper;

	public Core100Marshaller(CityGMLMarshaller citygml) {
		this.citygml = citygml;
		jaxb = citygml.getJAXBMarshaller();
	}

	private TypeMapper<JAXBElement<?>> getElementMapper() {
		if (elementMapper == null) {
			lock.lock();
			try {
				if (elementMapper == null) {
					elementMapper = TypeMapper.<JAXBElement<?>>create()
							.with(Address.class, this::createAddress)
							.with(CityModel.class, this::createCityModel)
							.with(CityObjectMember.class, this::createCityObjectMember)
							.with(ImplicitGeometry.class, this::createImplicitGeometry);
				}
			} finally {
				lock.unlock();
			}
		}

		return elementMapper;
	}

	private TypeMapper<Object> getTypeMapper() {
		if (typeMapper == null) {
			lock.lock();
			try {
				if (typeMapper == null) {
					typeMapper = TypeMapper.create()
							.with(Address.class, this::marshalAddress)
							.with(AddressProperty.class, this::marshalAddressProperty)
							.with(CityModel.class, this::marshalCityModel)
							.with(CityObjectMember.class, this::marshalCityObjectMember)
							.with(ExternalObject.class, this::marshalExternalObject)
							.with(ExternalReference.class, this::marshalExternalReference)
							.with(GeneralizationRelation.class, this::marshalGeneralizationRelation)
							.with(ImplicitGeometry.class, this::marshalImplicitGeometry)
							.with(ImplicitRepresentationProperty.class, this::marshalImplicitRepresentationProperty)
							.with(XalAddressProperty.class, this::marshalXalAddressProperty);
				}
			} finally {
				lock.unlock();
			}
		}

		return typeMapper;
	}

	public JAXBElement<?> marshalJAXBElement(ModelObject src) {
		return getElementMapper().apply(src);
	}

	public Object marshal(ModelObject src) {
		return getTypeMapper().apply(src);
	}

	@SuppressWarnings("unchecked")
	public void marshalAbstractCityObject(AbstractCityObject src, AbstractCityObjectType dest) {
		jaxb.getGMLMarshaller().marshalAbstractFeature(src, dest);

		if (src.isSetCreationDate()) {
			ZonedDateTime date = src.getCreationDate();
			dest.setCreationDate(jaxb.getDataTypeFactory().newXMLGregorianCalendarDate(
					date.getYear(),
					date.getMonthValue(),
					date.getDayOfMonth(),
					DatatypeConstants.FIELD_UNDEFINED));
		}

		if (src.isSetTerminationDate()) {
			ZonedDateTime date = src.getTerminationDate();
			dest.setTerminationDate(jaxb.getDataTypeFactory().newXMLGregorianCalendarDate(
					date.getYear(),
					date.getMonthValue(),
					date.getDayOfMonth(),
					DatatypeConstants.FIELD_UNDEFINED));
		}

		if (src.isSetExternalReference()) {
			for (ExternalReference externalReference : src.getExternalReference())
				dest.getExternalReference().add(marshalExternalReference(externalReference));
		}

		if (src.isSetGeneralizesTo()) {
			for (GeneralizationRelation generalizationRelation : src.getGeneralizesTo())
				dest.getGeneralizesTo().add(marshalGeneralizationRelation(generalizationRelation));
		}

		if (src.isSetRelativeToTerrain()) {
			StringAttribute relativeToTerrain = new StringAttribute();
			relativeToTerrain.setName("relativeToTerrain");
			relativeToTerrain.setValue(src.getRelativeToTerrain().getValue());
			JAXBElement<?> elem = citygml.getGenerics100Marshaller().marshalJAXBElement(relativeToTerrain);
			if (elem != null && elem.getValue() instanceof AbstractGenericAttributeType)
				dest.get_GenericAttribute().add((JAXBElement<? extends AbstractGenericAttributeType>)elem);
		}

		if (src.isSetRelativeToWater()) {
			StringAttribute relativeToWater = new StringAttribute();
			relativeToWater.setName("relativeToWater");
			relativeToWater.setValue(src.getRelativeToWater().getValue());
			JAXBElement<?> elem = citygml.getGenerics100Marshaller().marshalJAXBElement(relativeToWater);
			if (elem != null && elem.getValue() instanceof AbstractGenericAttributeType)
				dest.get_GenericAttribute().add((JAXBElement<? extends AbstractGenericAttributeType>)elem);
		}

		if (src.isSetGenericAttribute()) {
			for (AbstractGenericAttribute genericAttribute : src.getGenericAttribute()) {
				if (genericAttribute.getCityGMLClass() == CityGMLClass.GENERIC_ATTRIBUTE_SET)				
					dest.get_GenericAttribute().addAll(citygml.getGenerics100Marshaller().marshalGenericAttributeSetElement((GenericAttributeSet)genericAttribute));				
				else {
					JAXBElement<?> elem = citygml.getGenerics100Marshaller().marshalJAXBElement(genericAttribute);
					if (elem != null && elem.getValue() instanceof AbstractGenericAttributeType)
						dest.get_GenericAttribute().add((JAXBElement<? extends AbstractGenericAttributeType>)elem);
				}
			}
		}

		if (src.isSetAppearance()) {
			for (AppearanceProperty appearanceProperty : src.getAppearance())
				dest.getAppearance().add(citygml.getAppearance100Marshaller().marshalAppearanceProperty(appearanceProperty));
		}

		if (src.isSetGenericApplicationPropertyOfCityObject()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfCityObject()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfCityObject().add(jaxbElement);
			}
		}

	}

	public void marshalAbstractSite(AbstractSite src, AbstractSiteType dest) {
		marshalAbstractCityObject(src, dest);

		if (src.isSetGenericApplicationPropertyOfSite()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfSite()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfSite().add(jaxbElement);
			}
		}
	}

	public void marshalAddress(Address src, AddressType dest) {
		jaxb.getGMLMarshaller().marshalAbstractFeature(src, dest);

		if (src.isSetXalAddress())
			dest.setXalAddress(marshalXalAddressProperty(src.getXalAddress()));

		if (src.isSetMultiPoint())
			dest.setMultiPoint(jaxb.getGMLMarshaller().marshalMultiPointProperty(src.getMultiPoint()));

		if (src.isSetGenericApplicationPropertyOfAddress()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfAddress()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfAddress().add(jaxbElement);
			}
		}
	}

	public AddressType marshalAddress(Address src) {
		AddressType dest = core.createAddressType();
		marshalAddress(src, dest);

		return dest;
	}

	public AddressPropertyType marshalAddressProperty(AddressProperty src) {
		AddressPropertyType dest = core.createAddressPropertyType();
		jaxb.getGMLMarshaller().marshalFeatureProperty(src, dest);

		if (src.isSetAddress()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getAddress());
			if (elem != null && elem.getValue() instanceof AddressType)
				dest.set_Object((JAXBElement<?>)elem);
		}

		return dest;
	}

	@SuppressWarnings("unchecked")
	public void marshalCityModel(CityModel src, CityModelType dest) {
		jaxb.getGMLMarshaller().marshalAbstractFeatureCollection(src, dest);

		if (src.isSetAppearanceMember()) {
			for (AppearanceMember member : src.getAppearanceMember()) {
				JAXBElement<?> elem = jaxb.marshalJAXBElement(member);
				if (elem != null && elem.getValue() instanceof AppearancePropertyType)
					dest.getFeatureMember().add((JAXBElement<AppearancePropertyType>)elem);
			}
		}

		if (src.isSetCityObjectMember()) {
			for (CityObjectMember member : src.getCityObjectMember()) {
				JAXBElement<?> elem = jaxb.marshalJAXBElement(member);
				if (elem != null && elem.getValue() instanceof FeaturePropertyType)
					dest.getFeatureMember().add((JAXBElement<? extends FeaturePropertyType>)elem);
			}
		}

		if (src.isSetGenericApplicationPropertyOfCityModel()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfCityModel()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfCityModel().add(jaxbElement);
			}
		}
	}

	public CityModelType marshalCityModel(CityModel src) {
		CityModelType dest = core.createCityModelType();
		marshalCityModel(src, dest);

		return dest;
	}

	public FeaturePropertyType marshalCityObjectMember(CityObjectMember src) {
		return jaxb.getGMLMarshaller().marshalFeatureProperty(src);		
	}

	public void marshalExternalObject(ExternalObject src, ExternalObjectReferenceType dest) {
		if (src.isSetName())
			dest.setName(src.getName());

		if (src.isSetUri())
			dest.setUri(src.getUri());
	}

	public ExternalObjectReferenceType marshalExternalObject(ExternalObject src) {
		ExternalObjectReferenceType dest = core.createExternalObjectReferenceType();
		marshalExternalObject(src, dest);		

		return dest;
	}

	public void marshalExternalReference(ExternalReference src, ExternalReferenceType dest) {
		if (src.isSetExternalObject())
			dest.setExternalObject(marshalExternalObject(src.getExternalObject()));

		if (src.isSetInformationSystem())
			dest.setInformationSystem(src.getInformationSystem());
	}

	public ExternalReferenceType marshalExternalReference(ExternalReference src) {
		ExternalReferenceType dest = core.createExternalReferenceType();
		marshalExternalReference(src, dest);

		return dest;
	}

	@SuppressWarnings("unchecked")
	public GeneralizationRelationType marshalGeneralizationRelation(GeneralizationRelation src) {
		GeneralizationRelationType dest = core.createGeneralizationRelationType();

		if (src.isSetCityObject()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src);
			if (elem != null && elem.getValue() instanceof AbstractCityObjectType)
				dest.set_CityObject((JAXBElement<? extends AbstractCityObjectType>)elem);
		}

		if (src.isSetGenericADEElement()) {
			Element element = jaxb.getADEMarshaller().marshalDOMElement(src.getGenericADEElement());
			if (element != null)
				dest.set_ADEComponent(element);
		}

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(TypeType.fromValue(src.getType().getValue()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(ShowType.fromValue(src.getShow().getValue()));

		if (src.isSetActuate())
			dest.setActuate(ActuateType.fromValue(src.getActuate().getValue()));

		return dest;
	}

	public void marshalImplicitGeometry(ImplicitGeometry src, ImplicitGeometryType dest) {
		jaxb.getGMLMarshaller().marshalAbstractGML(src, dest);

		if (src.isSetMimeType())
			dest.setMimeType(src.getMimeType().getValue());

		if (src.isSetLibraryObject())
			dest.setLibraryObject(src.getLibraryObject());

		if (src.isSetTransformationMatrix()) {
			List<Double> matrix = marshalTransformationMatrix4x4(src.getTransformationMatrix());
			if (matrix != null)
				dest.setTransformationMatrix(matrix);
		}

		if (src.isSetReferencePoint())
			dest.setReferencePoint(jaxb.getGMLMarshaller().marshalPointProperty(src.getReferencePoint()));

		if (src.isSetRelativeGMLGeometry())
			dest.setRelativeGMLGeometry(jaxb.getGMLMarshaller().marshalGeometryProperty(src.getRelativeGMLGeometry()));
	}

	public ImplicitGeometryType marshalImplicitGeometry(ImplicitGeometry src) {
		ImplicitGeometryType dest = core.createImplicitGeometryType();
		marshalImplicitGeometry(src, dest);

		return dest;
	}

	public ImplicitRepresentationPropertyType marshalImplicitRepresentationProperty(ImplicitRepresentationProperty src) {
		ImplicitRepresentationPropertyType dest = core.createImplicitRepresentationPropertyType();
		jaxb.getGMLMarshaller().marshalAssociationByRepOrRef(src, dest);

		if (src.isSetImplicitGeometry()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getImplicitGeometry());
			if (elem != null && elem.getValue() instanceof ImplicitGeometryType)
				dest.set_Object((JAXBElement<?>)elem);
		}

		return dest;

	}

	public List<Double> marshalTransformationMatrix2x2(TransformationMatrix2x2 src) {
		if (src.isSetMatrix())
			return src.getMatrix().toRowPackedList();

		return null;
	}

	public List<Double> marshalTransformationMatrix3x4(TransformationMatrix3x4 src) {
		if (src.isSetMatrix())
			return src.getMatrix().toRowPackedList();

		return null;
	}

	public List<Double> marshalTransformationMatrix4x4(TransformationMatrix4x4 src) {
		if (src.isSetMatrix())
			return src.getMatrix().toRowPackedList();

		return null;
	}

	public XalAddressPropertyType marshalXalAddressProperty(XalAddressProperty src) {
		XalAddressPropertyType dest = core.createXalAddressPropertyType();
		if (src.isSetAddressDetails())
			dest.setAddressDetails(jaxb.getXALMarshaller().marshalAddressDetails(src.getAddressDetails()));		

		return dest;
	}

	private JAXBElement<?> createAddress(Address src) {
		return core.createAddress(marshalAddress(src));
	}

	private JAXBElement<?> createCityModel(CityModel src) {
		return core.createCityModel(marshalCityModel(src));
	}

	private JAXBElement<?> createCityObjectMember(CityObjectMember src) {
		return core.createCityObjectMember(marshalCityObjectMember(src));
	}

	private JAXBElement<?> createImplicitGeometry(ImplicitGeometry src) {
		return core.createImplicitGeometry(marshalImplicitGeometry(src));
	}

}
