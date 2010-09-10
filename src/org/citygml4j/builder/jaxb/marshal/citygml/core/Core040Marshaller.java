package org.citygml4j.builder.jaxb.marshal.citygml.core;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;

import org.citygml4j.builder.jaxb.marshal.JAXBMarshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.jaxb.citygml._0_4.AddressPropertyType;
import org.citygml4j.jaxb.citygml._0_4.AddressType;
import org.citygml4j.jaxb.citygml._0_4.AppearancePropertyType;
import org.citygml4j.jaxb.citygml._0_4.CityModelType;
import org.citygml4j.jaxb.citygml._0_4.ExternalObjectReferenceType;
import org.citygml4j.jaxb.citygml._0_4.ExternalReferenceType;
import org.citygml4j.jaxb.citygml._0_4.GeneralizationRelationType;
import org.citygml4j.jaxb.citygml._0_4.ImplicitGeometryType;
import org.citygml4j.jaxb.citygml._0_4.ImplicitRepresentationPropertyType;
import org.citygml4j.jaxb.citygml._0_4.ObjectFactory;
import org.citygml4j.jaxb.citygml._0_4.XalAddressPropertyType;
import org.citygml4j.jaxb.citygml._0_4._CityObjectType;
import org.citygml4j.jaxb.citygml._0_4._GenericAttributeType;
import org.citygml4j.jaxb.citygml._0_4._SiteType;
import org.citygml4j.jaxb.gml._3_1_1.FeaturePropertyType;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.appearance.AppearanceMember;
import org.citygml4j.model.citygml.appearance.AppearanceProperty;
import org.citygml4j.model.citygml.core.Address;
import org.citygml4j.model.citygml.core.AddressProperty;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.CityObjectMember;
import org.citygml4j.model.citygml.core.CoreModuleComponent;
import org.citygml4j.model.citygml.core.ExternalObject;
import org.citygml4j.model.citygml.core.ExternalReference;
import org.citygml4j.model.citygml.core.GeneralizationRelation;
import org.citygml4j.model.citygml.core.ImplicitGeometry;
import org.citygml4j.model.citygml.core.ImplicitRepresentationProperty;
import org.citygml4j.model.citygml.core.AbstractSite;
import org.citygml4j.model.citygml.core.TransformationMatrix2x2;
import org.citygml4j.model.citygml.core.TransformationMatrix3x4;
import org.citygml4j.model.citygml.core.TransformationMatrix4x4;
import org.citygml4j.model.citygml.core.XalAddressProperty;
import org.citygml4j.model.citygml.generics.AbstractGenericAttribute;

public class Core040Marshaller {
	private final ObjectFactory core = new ObjectFactory();
	private final JAXBMarshaller jaxb;
	private final CityGMLMarshaller citygml;
	
	public Core040Marshaller(CityGMLMarshaller citygml) {
		this.citygml = citygml;
		jaxb = citygml.getJAXBMarshaller();
	}

	public ObjectFactory getObjectFactory() {
		return core;
	}
	
	public JAXBElement<?> marshalJAXBElement(Object src) {
		JAXBElement<?> dest = null;

		CoreModuleComponent orig = null;

		if (src instanceof CoreModuleComponent) {
			orig = (CoreModuleComponent)src;
			src = marshal(src);
		}

		if (src instanceof AddressType)
			dest = core.createAddress((AddressType)src);
		else if (src instanceof CityModelType)
			dest = core.createCityModel((CityModelType)src);
		else if (src instanceof FeaturePropertyType && orig instanceof CityObjectMember)
			dest = core.createCityObjectMember((FeaturePropertyType)src);
		else if (src instanceof ImplicitGeometryType)
			dest = core.createImplicitGeometry((ImplicitGeometryType)src);
		
		return dest;
	}
	
	public Object marshal(Object src) {
		Object dest = null;
		
		if (src instanceof Address)
			dest = marshalAddress((Address)src);
		else if (src instanceof AddressProperty)
			dest = marshalAddressProperty((AddressProperty)src);
		else if (src instanceof CityModel)
			dest = marshalCityModel((CityModel)src);
		else if (src instanceof CityObjectMember)
			dest = marshalCityObjectMember((CityObjectMember)src);
		else if (src instanceof ExternalObject)
			dest = marshalExternalObject((ExternalObject)src);
		else if (src instanceof ExternalReference)
			dest = marshalExternalReference((ExternalReference)src);
		else if (src instanceof GeneralizationRelation)
			dest = marshalGeneralizationRelation((GeneralizationRelation)src);
		else if (src instanceof ImplicitGeometry)
			dest = marshalImplicitGeometry((ImplicitGeometry)src);
		else if (src instanceof ImplicitRepresentationProperty)
			dest = marshalImplicitRepresentationProperty((ImplicitRepresentationProperty)src);
		else if (src instanceof XalAddressProperty)
			dest = marshalXalAddressProperty((XalAddressProperty)src);
		
		return dest;
	}
	
	@SuppressWarnings("unchecked")
	public void marshalCityObject(AbstractCityObject src, _CityObjectType dest) {
		jaxb.getGMLMarshaller().marshalAbstractFeature(src, dest);

		if (src.isSetCreationDate()) {
			try {
				GregorianCalendar date = src.getCreationDate();
				DatatypeFactory factory = DatatypeFactory.newInstance();
				dest.setCreationDate(factory.newXMLGregorianCalendarDate(
						date.get(Calendar.YEAR),
						date.get(Calendar.MONTH) + 1,
						date.get(Calendar.DAY_OF_MONTH),
						DatatypeConstants.FIELD_UNDEFINED));
			} catch (DatatypeConfigurationException e) {
				// 
			}
		}

		if (src.isSetTerminationDate()) {
			try {
				GregorianCalendar date = src.getTerminationDate();
				DatatypeFactory factory = DatatypeFactory.newInstance();
				dest.setTerminationDate(factory.newXMLGregorianCalendarDate(
						date.get(Calendar.YEAR),
						date.get(Calendar.MONTH) + 1,
						date.get(Calendar.DAY_OF_MONTH),
						DatatypeConstants.FIELD_UNDEFINED));
			} catch (DatatypeConfigurationException e) {
				// 
			}
		}

		if (src.isSetExternalReference()) {
			for (ExternalReference externalReference : src.getExternalReference())
				dest.getExternalReference().add(marshalExternalReference(externalReference));
		}

		if (src.isSetGeneralizesTo()) {
			for (GeneralizationRelation generalizationRelation : src.getGeneralizesTo())
				dest.getGeneralizesTo().add(marshalGeneralizationRelation(generalizationRelation));
		}

		if (src.isSetGenericAttribute()) {
			for (AbstractGenericAttribute genericAttribute : src.getGenericAttribute()) {
				JAXBElement<?> elem = jaxb.marshalJAXBElement(genericAttribute);
				if (elem != null && elem.getValue() instanceof _GenericAttributeType)
					dest.get_GenericAttribute().add((JAXBElement<? extends _GenericAttributeType>)elem);
			}
		}

		if (src.isSetAppearance()) {
			for (AppearanceProperty appearanceProperty : src.getAppearance())
				dest.getAppearanceMember().add(citygml.getAppearance040Marshaller().marshalAppearanceProperty(appearanceProperty));
		}

		if (src.isSetGenericApplicationPropertyOfCityObject()) {
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfCityObject())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfCityObject().add(citygml.ade2jaxbElement(adeComponent));
		}

	}

	public void marshalSite(AbstractSite src, _SiteType dest) {
		marshalCityObject(src, dest);

		if (src.isSetGenericApplicationPropertyOfSite()) {
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfSite())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfSite().add(citygml.ade2jaxbElement(adeComponent));
		}
	}	
	
	public void marshalAddress(Address src, AddressType dest) {
		jaxb.getGMLMarshaller().marshalAbstractFeature(src, dest);

		if (src.isSetXalAddress())
			dest.setXalAddress(marshalXalAddressProperty(src.getXalAddress()));

		if (src.isSetMultiPoint())
			dest.setMultiPoint(jaxb.getGMLMarshaller().marshalMultiPointProperty(src.getMultiPoint()));
		
		if (src.isSetGenericApplicationPropertyOfAddress()) {
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfAddress())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfAddress().add(citygml.ade2jaxbElement(adeComponent));
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
		
		if (src.isSetCityObjectMember()) {
			for (CityObjectMember member : src.getCityObjectMember()) {
				JAXBElement<?> elem = jaxb.marshalJAXBElement(member);
				if (elem != null && elem.getValue() instanceof FeaturePropertyType)
					dest.getFeatureMember().add((JAXBElement<? extends FeaturePropertyType>)elem);
			}
		}
		
		if (src.isSetAppearanceMember()) {
			for (AppearanceMember member : src.getAppearanceMember()) {
				JAXBElement<?> elem = jaxb.marshalJAXBElement(member);
				if (elem != null && elem.getValue() instanceof AppearancePropertyType)
					dest.getFeatureMember().add((JAXBElement<AppearancePropertyType>)elem);
			}
		}
		
		if (src.isSetGenericApplicationPropertyOfCityModel()) {
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfCityModel())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfCityModel().add(citygml.ade2jaxbElement(adeComponent));
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
	
	public GeneralizationRelationType marshalGeneralizationRelation(GeneralizationRelation src) {
		GeneralizationRelationType dest = core.createGeneralizationRelationType();
		jaxb.getGMLMarshaller().marshalFeatureProperty(src, dest);
		
		if (src.isSetCityObject()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src);
			if (elem != null && elem.getValue() instanceof _CityObjectType)
				dest.set_Object((JAXBElement<?>)elem);
		}		

		return dest;
	}
	
	public void marshalImplicitGeometry(ImplicitGeometry src, ImplicitGeometryType dest) {
		jaxb.getGMLMarshaller().marshalAbstractGML(src, dest);

		if (src.isSetMimeType())
			dest.setMimeType(src.getMimeType());

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
	
}
