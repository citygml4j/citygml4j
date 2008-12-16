package org.citygml4j.impl.jaxb.citygml.core._0_4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.XMLGregorianCalendar;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.impl.jaxb.ObjectFactory;
import org.citygml4j.impl.jaxb.citygml.appearance._0_4.AppearancePropertyImpl;
import org.citygml4j.impl.jaxb.citygml.generics._0_4.GenericAttributeImpl;
import org.citygml4j.impl.jaxb.citygml.generics._0_4.GenericDateAttributeImpl;
import org.citygml4j.impl.jaxb.citygml.generics._0_4.GenericDoubleAttributeImpl;
import org.citygml4j.impl.jaxb.citygml.generics._0_4.GenericIntAttributeImpl;
import org.citygml4j.impl.jaxb.citygml.generics._0_4.GenericStringAttributeImpl;
import org.citygml4j.impl.jaxb.citygml.generics._0_4.GenericUriAttributeImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.AbstractFeatureImpl;
import org.citygml4j.jaxb.citygml._0_4.AppearancePropertyType;
import org.citygml4j.jaxb.citygml._0_4.DateAttributeType;
import org.citygml4j.jaxb.citygml._0_4.DoubleAttributeType;
import org.citygml4j.jaxb.citygml._0_4.ExternalReferenceType;
import org.citygml4j.jaxb.citygml._0_4.GeneralizationRelationType;
import org.citygml4j.jaxb.citygml._0_4.IntAttributeType;
import org.citygml4j.jaxb.citygml._0_4.StringAttributeType;
import org.citygml4j.jaxb.citygml._0_4.UriAttributeType;
import org.citygml4j.jaxb.citygml._0_4._CityObjectType;
import org.citygml4j.jaxb.citygml._0_4._GenericAttributeType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.appearance.AppearanceProperty;
import org.citygml4j.model.citygml.core.CityObject;
import org.citygml4j.model.citygml.core.CoreModule;
import org.citygml4j.model.citygml.core.ExternalReference;
import org.citygml4j.model.citygml.core.GeneralizationRelation;
import org.citygml4j.model.citygml.generics.GenericAttribute;

public abstract class CityObjectImpl extends AbstractFeatureImpl implements CityObject {
	private _CityObjectType cityObject;

	public CityObjectImpl(_CityObjectType cityObject) {
		super(cityObject);
		this.cityObject = cityObject;
	}

	@Override
	public _CityObjectType getJAXBObject() {
		return cityObject;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.CITYOBJECT;
	}

	@Override
	public CityGMLModule getCityGMLModule() {
		return CoreModule.v0_4_0;
	}

	@Override
	public XMLGregorianCalendar getCreationDate() {
		if (cityObject.isSetCreationDate())
			return cityObject.getCreationDate();

		return null;
	}

	@Override
	public XMLGregorianCalendar getTerminationDate() {
		if (cityObject.isSetTerminationDate())
			return cityObject.getTerminationDate();

		return null;
	}

	@Override
	public List<ExternalReference> getExternalReference() {
		if (cityObject.isSetExternalReference()) {
			List<ExternalReference> extRefList = new ArrayList<ExternalReference>();
			List<ExternalReferenceType> extRefTypeList = cityObject.getExternalReference();

			for (ExternalReferenceType extRefType : extRefTypeList)
				extRefList.add(new ExternalReferenceImpl(extRefType));

			return extRefList;
		}

		return null;
	}

	@Override
	public List<GenericAttribute> getGenericAttribute() {
		if (cityObject.isSet_GenericAttribute()) {
			List<GenericAttribute> genericAttributeList = new ArrayList<GenericAttribute>();
			List<JAXBElement<? extends _GenericAttributeType>> genericAttributeTypeList = cityObject.get_GenericAttribute();

			for (JAXBElement<? extends _GenericAttributeType> genericAttributeType : genericAttributeTypeList) {
				if (genericAttributeType.getValue() != null) {
					if (genericAttributeType.getValue() instanceof StringAttributeType)
						genericAttributeList.add(new GenericStringAttributeImpl((StringAttributeType)genericAttributeType.getValue()));
					else if (genericAttributeType.getValue() instanceof IntAttributeType)
						genericAttributeList.add(new GenericIntAttributeImpl((IntAttributeType)genericAttributeType.getValue()));
					else if (genericAttributeType.getValue() instanceof DoubleAttributeType)
						genericAttributeList.add(new GenericDoubleAttributeImpl((DoubleAttributeType)genericAttributeType.getValue()));
					else if (genericAttributeType.getValue() instanceof DateAttributeType)
						genericAttributeList.add(new GenericDateAttributeImpl((DateAttributeType)genericAttributeType.getValue()));
					else if (genericAttributeType.getValue() instanceof UriAttributeType)
						genericAttributeList.add(new GenericUriAttributeImpl((UriAttributeType)genericAttributeType.getValue()));
				}
			}

			return genericAttributeList;
		}

		return null;
	}

	@Override
	public void setCreationDate(XMLGregorianCalendar creationDate) {
		cityObject.setCreationDate(creationDate);
	}

	@Override
	public void setTerminationDate(XMLGregorianCalendar terminationDate) {
		cityObject.setTerminationDate(terminationDate);
	}

	@Override
	public void addGenericAttribute(GenericAttribute genericAttribute) {
		JAXBElement<? extends _GenericAttributeType> jaxbElem = null;

		switch (genericAttribute.getCityGMLClass()) {
		case STRINGATTRIBUTE:
			jaxbElem = ObjectFactory.CITYGML_0_4.createStringAttribute(((GenericStringAttributeImpl)genericAttribute).getJAXBObject());
			break;
		case INTATTRIBUTE:
			jaxbElem = ObjectFactory.CITYGML_0_4.createIntAttribute(((GenericIntAttributeImpl)genericAttribute).getJAXBObject());
			break;
		case DOUBLEATTRIBUTE:
			jaxbElem = ObjectFactory.CITYGML_0_4.createDoubleAttribute(((GenericDoubleAttributeImpl)genericAttribute).getJAXBObject());
			break;
		case URIATTRIBUTE:
			jaxbElem = ObjectFactory.CITYGML_0_4.createUriAttribute(((GenericUriAttributeImpl)genericAttribute).getJAXBObject());
			break;
		case DATEATTRIBUTE:
			jaxbElem = ObjectFactory.CITYGML_0_4.createDateAttribute(((GenericDateAttributeImpl)genericAttribute).getJAXBObject());
			break;
		}

		if (jaxbElem != null) {
			List<JAXBElement<? extends _GenericAttributeType>> genericAttributeTypeList = cityObject.get_GenericAttribute();
			genericAttributeTypeList.add(jaxbElem);
		}
	}

	@Override
	public void setGenericAttribute(List<GenericAttribute> genericAttribute) {
		List<JAXBElement<? extends _GenericAttributeType>> genericAttributeTypeList = new ArrayList<JAXBElement<? extends _GenericAttributeType>>();
		for (GenericAttribute generic : genericAttribute) {
			JAXBElement<? extends _GenericAttributeType> jaxbElem = null;

			switch (generic.getCityGMLClass()) {
			case STRINGATTRIBUTE:
				jaxbElem = ObjectFactory.CITYGML_0_4.createStringAttribute(((GenericStringAttributeImpl)generic).getJAXBObject());
				break;
			case INTATTRIBUTE:
				jaxbElem = ObjectFactory.CITYGML_0_4.createIntAttribute(((GenericIntAttributeImpl)generic).getJAXBObject());
				break;
			case DOUBLEATTRIBUTE:
				jaxbElem = ObjectFactory.CITYGML_0_4.createDoubleAttribute(((GenericDoubleAttributeImpl)generic).getJAXBObject());
				break;
			case URIATTRIBUTE:
				jaxbElem = ObjectFactory.CITYGML_0_4.createUriAttribute(((GenericUriAttributeImpl)generic).getJAXBObject());
				break;
			case DATEATTRIBUTE:
				jaxbElem = ObjectFactory.CITYGML_0_4.createDateAttribute(((GenericDateAttributeImpl)generic).getJAXBObject());
				break;
			}

			if (jaxbElem != null)
				genericAttributeTypeList.add(jaxbElem);
		}

		cityObject.unset_GenericAttribute();
		cityObject.get_GenericAttribute().addAll(genericAttributeTypeList);
	}

	public void addExternalReference(ExternalReference externalReference) {
		cityObject.getExternalReference().add(((ExternalReferenceImpl)externalReference).getJAXBObject());
	}

	@Override
	public void setExternalReference(List<ExternalReference> externalReference) {
		List<ExternalReferenceType> externalReferenceTypeList = new ArrayList<ExternalReferenceType>();

		for (ExternalReference externalRef : externalReference)
			externalReferenceTypeList.add(((ExternalReferenceImpl)externalRef).getJAXBObject());

		cityObject.unsetExternalReference();
		cityObject.getExternalReference().addAll(externalReferenceTypeList);
	}

	@Override
	public void addGeneralizesTo(GeneralizationRelation generalizesTo) {
		cityObject.getGeneralizesTo().add(((GeneralizationRelationImpl)generalizesTo).getJAXBObject());
	}

	@Override
	public List<GeneralizationRelation> getGeneralizesTo() {
		if (cityObject.isSetGeneralizesTo()) {
			List<GeneralizationRelation> genRelList = new ArrayList<GeneralizationRelation>();
			List<GeneralizationRelationType> genRelTypeList = cityObject.getGeneralizesTo();

			for (GeneralizationRelationType genRelType : genRelTypeList)
				genRelList.add(new GeneralizationRelationImpl(genRelType));

			return genRelList;
		}

		return null;
	}

	@Override
	public void setGeneralizesTo(List<GeneralizationRelation> generalizesTo) {
		List<GeneralizationRelationType> genRelTypeList = new ArrayList<GeneralizationRelationType>();

		for (GeneralizationRelation genRel : generalizesTo)
			genRelTypeList.add(((GeneralizationRelationImpl)genRel).getJAXBObject());

		cityObject.unsetGeneralizesTo();
		cityObject.getGeneralizesTo().addAll(genRelTypeList);
	}

	@Override
	public void addAppearance(AppearanceProperty appearanceMember) {
		cityObject.getAppearanceMember().add(((AppearancePropertyImpl)appearanceMember).getJAXBObject());
	}

	@Override
	public List<AppearanceProperty> getAppearance() {
		if (cityObject.isSetAppearanceMember()) {
			List<AppearanceProperty> appPropList = new ArrayList<AppearanceProperty>();
			List<AppearancePropertyType> appPropTypeList = cityObject.getAppearanceMember();

			for (AppearancePropertyType appPropType : appPropTypeList)
				appPropList.add(new AppearancePropertyImpl(appPropType));

			return appPropList;
		}

		return null;
	}

	@Override
	public void setAppearance(List<AppearanceProperty> appearanceMember) {
		List<AppearancePropertyType> appPropTypeList = new ArrayList<AppearancePropertyType>();

		for (AppearanceProperty appProp : appearanceMember)
			appPropTypeList.add(((AppearancePropertyImpl)appProp).getJAXBObject());

		cityObject.unsetAppearanceMember();
		cityObject.getAppearanceMember().addAll(appPropTypeList);
	}
	
	@Override
	public void addGenericApplicationPropertyOfCityObject(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			cityObject.get_GenericApplicationPropertyOfCityObject().add(jaxbElem);
	}

	@Override
	public List<ADEComponent> getGenericApplicationPropertyOfCityObject() {
		if (cityObject.isSet_GenericApplicationPropertyOfCityObject()) {
			List<ADEComponent> adeList = new ArrayList<ADEComponent>();
			List<JAXBElement<?>> elemList = cityObject.get_GenericApplicationPropertyOfCityObject();
			
			for (JAXBElement<?> elem : elemList) {
				if (elem.getValue() != null) {
					ADEComponent ade = ModelMapper.ADE.toADEComponent(elem.getValue(), elem.getName());
					if (ade != null)
						adeList.add(ade);
				}
			}
			
			if (!adeList.isEmpty())
				return adeList;
		}
		
		return null;
	}

	@Override
	public void setGenericApplicationPropertyOfCityObject(List<ADEComponent> adeObject) {
		List<JAXBElement<?>> elemList = new ArrayList<JAXBElement<?>>();
		
		for (ADEComponent ade : adeObject) {
			JAXBElement<?> elem = ModelMapper.ADE.toJAXB(ade);
			if (elem != null)
				elemList.add(elem);
		}
		
		if (!elemList.isEmpty()) {
			cityObject.unset_GenericApplicationPropertyOfCityObject();
			cityObject.get_GenericApplicationPropertyOfCityObject().addAll(elemList);
		}
	}

	@Override
	public boolean isSetAppearance() {
		return cityObject.isSetAppearanceMember();
	}

	@Override
	public boolean isSetCreationDate() {
		return cityObject.isSetCreationDate();
	}

	@Override
	public boolean isSetExternalReference() {
		return cityObject.isSetExternalReference();
	}

	@Override
	public boolean isSetGeneralizesTo() {
		return cityObject.isSetGeneralizesTo();
	}

	@Override
	public boolean isSetGenericApplicationPropertyOfCityObject() {
		return cityObject.isSet_GenericApplicationPropertyOfCityObject();
	}

	@Override
	public boolean isSetGenericAttribute() {
		return cityObject.isSet_GenericAttribute();
	}

	@Override
	public boolean isSetTerminationDate() {
		return cityObject.isSetTerminationDate();
	}

	@Override
	public void unsetAppearance() {
		cityObject.unsetAppearanceMember();
	}

	@Override
	public void unsetCreationDate() {
		cityObject.setCreationDate(null);
	}

	@Override
	public void unsetExternalReference() {
		cityObject.unsetExternalReference();
	}

	@Override
	public void unsetGeneralizesTo() {
		cityObject.unsetGeneralizesTo();
	}

	@Override
	public void unsetGenericApplicationPropertyOfCityObject() {
		cityObject.unset_GenericApplicationPropertyOfCityObject();
	}

	@Override
	public void unsetGenericAttribute() {
		cityObject.unset_GenericAttribute();
	}

	@Override
	public void unsetTerminationDate() {
		cityObject.setTerminationDate(null);
	}

	@Override
	public boolean unsetAppearance(AppearanceProperty appearanceMember) {
		if (cityObject.isSetAppearanceMember())
			return cityObject.getAppearanceMember().remove(((AppearancePropertyImpl)appearanceMember).getJAXBObject());
		
		return false;
	}

	@Override
	public boolean unsetExternalReference(ExternalReference externalReference) {
		if (cityObject.isSetExternalReference())
			return cityObject.getExternalReference().remove(((ExternalReferenceImpl)externalReference).getJAXBObject());
		
		return false;
	}

	@Override
	public boolean unsetGeneralizesTo(GeneralizationRelation generalizesTo) {
		if (cityObject.isSetGeneralizesTo())
			return cityObject.getGeneralizesTo().remove(((GeneralizationRelationImpl)generalizesTo).getJAXBObject());
		
		return false;
	}

	@Override
	public boolean unsetGenericApplicationPropertyOfCityObject(ADEComponent adeObject) {
		if (cityObject.isSet_GenericApplicationPropertyOfCityObject()) {
			Iterator<JAXBElement<?>> iter = cityObject.get_GenericApplicationPropertyOfCityObject().iterator();
			while (iter.hasNext()) {
				JAXBElement<?> elem = iter.next();
				if (elem.getValue() != null && elem.getValue().equals(adeObject.getJAXBObject())) {
					iter.remove();
					return true;
				}
			}				
		}

		return false;
	}

	@Override
	public boolean unsetGenericAttribute(GenericAttribute genericAttribute) {
		if (cityObject.isSet_GenericAttribute()) 
			return cityObject.get_GenericAttribute().remove(((GenericAttributeImpl)genericAttribute).getJAXBObject());
		
		return false;
	}
	
}
