package org.citygml4j.impl.jaxb.citygml.core._1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.XMLGregorianCalendar;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.impl.jaxb.ObjectFactory;
import org.citygml4j.impl.jaxb.citygml.appearance._1.AppearancePropertyImpl;
import org.citygml4j.impl.jaxb.citygml.generics._1.GenericAttributeImpl;
import org.citygml4j.impl.jaxb.citygml.generics._1.GenericDateAttributeImpl;
import org.citygml4j.impl.jaxb.citygml.generics._1.GenericDoubleAttributeImpl;
import org.citygml4j.impl.jaxb.citygml.generics._1.GenericIntAttributeImpl;
import org.citygml4j.impl.jaxb.citygml.generics._1.GenericStringAttributeImpl;
import org.citygml4j.impl.jaxb.citygml.generics._1.GenericUriAttributeImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.AbstractFeatureImpl;
import org.citygml4j.jaxb.citygml.app._1.AppearancePropertyType;
import org.citygml4j.jaxb.citygml.core._1.AbstractCityObjectType;
import org.citygml4j.jaxb.citygml.core._1.ExternalReferenceType;
import org.citygml4j.jaxb.citygml.core._1.GeneralizationRelationType;
import org.citygml4j.jaxb.citygml.gen._1.AbstractGenericAttributeType;
import org.citygml4j.jaxb.citygml.gen._1.DateAttributeType;
import org.citygml4j.jaxb.citygml.gen._1.DoubleAttributeType;
import org.citygml4j.jaxb.citygml.gen._1.IntAttributeType;
import org.citygml4j.jaxb.citygml.gen._1.StringAttributeType;
import org.citygml4j.jaxb.citygml.gen._1.UriAttributeType;
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
	private AbstractCityObjectType cityObject;

	public CityObjectImpl(AbstractCityObjectType cityObject) {
		super(cityObject);
		this.cityObject = cityObject;
	}

	@Override
	public AbstractCityObjectType getJAXBObject() {
		return cityObject;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.CITYOBJECT;
	}

	@Override
	public CityGMLModule getCityGMLModule() {
		return CoreModule.v1_0_0;
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
		List<ExternalReference> extRefList = new ArrayList<ExternalReference>();

		for (ExternalReferenceType extRefType : cityObject.getExternalReference())
			extRefList.add(new ExternalReferenceImpl(extRefType));

		return extRefList;
	}

	@Override
	public List<GenericAttribute> getGenericAttribute() {
		List<GenericAttribute> genericAttributeList = new ArrayList<GenericAttribute>();

		for (JAXBElement<?> jaxbElem : cityObject.get_GenericApplicationPropertyOfCityObject()) {
			if (jaxbElem.getValue() == null || !(jaxbElem.getValue() instanceof AbstractGenericAttributeType))
				continue;

			if (jaxbElem.getValue() instanceof StringAttributeType)
				genericAttributeList.add(new GenericStringAttributeImpl((StringAttributeType)jaxbElem.getValue()));
			else if (jaxbElem.getValue() instanceof IntAttributeType)
				genericAttributeList.add(new GenericIntAttributeImpl((IntAttributeType)jaxbElem.getValue()));
			else if (jaxbElem.getValue() instanceof DoubleAttributeType)
				genericAttributeList.add(new GenericDoubleAttributeImpl((DoubleAttributeType)jaxbElem.getValue()));
			else if (jaxbElem.getValue() instanceof DateAttributeType)
				genericAttributeList.add(new GenericDateAttributeImpl((DateAttributeType)jaxbElem.getValue()));
			else if (jaxbElem.getValue() instanceof UriAttributeType)
				genericAttributeList.add(new GenericUriAttributeImpl((UriAttributeType)jaxbElem.getValue()));
		}

		return genericAttributeList;
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
		JAXBElement<?> jaxbElem = null;

		switch (genericAttribute.getCityGMLClass()) {
		case STRINGATTRIBUTE:
			jaxbElem = ObjectFactory.GEN_1.createStringAttribute(((GenericStringAttributeImpl)genericAttribute).getJAXBObject());
			break;
		case INTATTRIBUTE:
			jaxbElem = ObjectFactory.GEN_1.createIntAttribute(((GenericIntAttributeImpl)genericAttribute).getJAXBObject());
			break;
		case DOUBLEATTRIBUTE:
			jaxbElem = ObjectFactory.GEN_1.createDoubleAttribute(((GenericDoubleAttributeImpl)genericAttribute).getJAXBObject());
			break;
		case URIATTRIBUTE:
			jaxbElem = ObjectFactory.GEN_1.createUriAttribute(((GenericUriAttributeImpl)genericAttribute).getJAXBObject());
			break;
		case DATEATTRIBUTE:
			jaxbElem = ObjectFactory.GEN_1.createDateAttribute(((GenericDateAttributeImpl)genericAttribute).getJAXBObject());
			break;
		}

		if (jaxbElem != null)
			cityObject.get_GenericApplicationPropertyOfCityObject().add(jaxbElem);
	}

	@Override
	public void setGenericAttribute(List<GenericAttribute> genericAttribute) {
		List<JAXBElement<? extends AbstractGenericAttributeType>> genericAttributeTypeList = new ArrayList<JAXBElement<? extends AbstractGenericAttributeType>>();
		for (GenericAttribute generic : genericAttribute) {
			JAXBElement<? extends AbstractGenericAttributeType> jaxbElem = null;

			switch (generic.getCityGMLClass()) {
			case STRINGATTRIBUTE:
				jaxbElem = ObjectFactory.GEN_1.createStringAttribute(((GenericStringAttributeImpl)generic).getJAXBObject());
				break;
			case INTATTRIBUTE:
				jaxbElem = ObjectFactory.GEN_1.createIntAttribute(((GenericIntAttributeImpl)generic).getJAXBObject());
				break;
			case DOUBLEATTRIBUTE:
				jaxbElem = ObjectFactory.GEN_1.createDoubleAttribute(((GenericDoubleAttributeImpl)generic).getJAXBObject());
				break;
			case URIATTRIBUTE:
				jaxbElem = ObjectFactory.GEN_1.createUriAttribute(((GenericUriAttributeImpl)generic).getJAXBObject());
				break;
			case DATEATTRIBUTE:
				jaxbElem = ObjectFactory.GEN_1.createDateAttribute(((GenericDateAttributeImpl)generic).getJAXBObject());
				break;
			}

			if (jaxbElem != null)
				genericAttributeTypeList.add(jaxbElem);
		}

		Iterator<JAXBElement<?>> iter = cityObject.get_GenericApplicationPropertyOfCityObject().iterator();
		while (iter.hasNext()) {
			JAXBElement<?> jaxbElem = iter.next();			
			if (jaxbElem.getValue() != null && jaxbElem.getValue() instanceof AbstractGenericAttributeType)
				iter.remove();
		}

		cityObject.get_GenericApplicationPropertyOfCityObject().addAll(genericAttributeTypeList);
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
		List<GeneralizationRelation> genRelList = new ArrayList<GeneralizationRelation>();

		for (GeneralizationRelationType genRelType : cityObject.getGeneralizesTo())
			genRelList.add(new GeneralizationRelationImpl(genRelType));

		return genRelList;
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
	public void addAppearance(AppearanceProperty appearance) {
		cityObject.get_GenericApplicationPropertyOfCityObject().add(ObjectFactory.APP_1.createAppearance(((AppearancePropertyImpl)appearance).getJAXBObject()));
	}

	@Override
	public List<AppearanceProperty> getAppearance() {
		List<AppearanceProperty> appPropList = new ArrayList<AppearanceProperty>();

		for (JAXBElement<?> jaxbElem : cityObject.get_GenericApplicationPropertyOfCityObject())
			if (jaxbElem.getValue() != null && jaxbElem.getValue() instanceof AppearancePropertyType)
				appPropList.add(new AppearancePropertyImpl((AppearancePropertyType)jaxbElem.getValue()));

		return appPropList;
	}

	@Override
	public void setAppearance(List<AppearanceProperty> appearance) {
		List<JAXBElement<AppearancePropertyType>> appPropTypeList = new ArrayList<JAXBElement<AppearancePropertyType>>(); 

		for (AppearanceProperty appProp : appearance)
			appPropTypeList.add(ObjectFactory.APP_1.createAppearance(((AppearancePropertyImpl)appProp).getJAXBObject()));

		Iterator<JAXBElement<?>> iter = cityObject.get_GenericApplicationPropertyOfCityObject().iterator();
		while (iter.hasNext()) {
			JAXBElement<?> jaxbElem = iter.next();			
			if (jaxbElem.getValue() != null && jaxbElem.getValue() instanceof AppearancePropertyType)
				iter.remove();
		}

		cityObject.get_GenericApplicationPropertyOfCityObject().addAll(appPropTypeList);
	}

	@Override
	public void addGenericApplicationPropertyOfCityObject(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			cityObject.get_GenericApplicationPropertyOfCityObject().add(jaxbElem);
	}

	@Override
	public List<ADEComponent> getGenericApplicationPropertyOfCityObject() {
		List<ADEComponent> adeList = new ArrayList<ADEComponent>();

		for (JAXBElement<?> elem : cityObject.get_GenericApplicationPropertyOfCityObject()) {
			if (elem.getValue() != null &&
					!(elem.getValue() instanceof AbstractGenericAttributeType) &&
					!(elem.getValue() instanceof AppearancePropertyType)) {
				ADEComponent ade = ModelMapper.ADE.toADEComponent(elem.getValue(), elem.getName());
				if (ade != null)
					adeList.add(ade);
			}
		}

		return adeList;
	}

	@Override
	public void setGenericApplicationPropertyOfCityObject(List<ADEComponent> adeObject) {
		List<JAXBElement<?>> elemList = new ArrayList<JAXBElement<?>>();

		for (ADEComponent ade : adeObject) {
			JAXBElement<?> elem = ModelMapper.ADE.toJAXB(ade);
			if (elem != null)
				elemList.add(elem);
		}

		Iterator<JAXBElement<?>> iter = cityObject.get_GenericApplicationPropertyOfCityObject().iterator();
		while (iter.hasNext()) {
			JAXBElement<?> jaxbElem = iter.next();			
			if (jaxbElem.getValue() != null && 
					!(jaxbElem.getValue() instanceof AbstractGenericAttributeType) &&
					!(jaxbElem.getValue() instanceof AppearancePropertyType))
				iter.remove();
		}

		cityObject.get_GenericApplicationPropertyOfCityObject().addAll(elemList);
	}

	@Override
	public boolean isSetAppearance() {
		return (getAppearance() != null);
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
		return (getGenericAttribute() != null);
	}

	@Override
	public boolean isSetTerminationDate() {
		return cityObject.isSetTerminationDate();
	}

	@Override
	public void unsetAppearance() {
		if (cityObject.isSet_GenericApplicationPropertyOfCityObject()) {
			Iterator<JAXBElement<?>> iter = cityObject.get_GenericApplicationPropertyOfCityObject().iterator();
			while (iter.hasNext()) {
				JAXBElement<?> jaxbElem = iter.next();			
				if (jaxbElem.getValue() != null && jaxbElem.getValue() instanceof AppearancePropertyType)
					iter.remove();
			}
		}
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
		if (cityObject.isSet_GenericApplicationPropertyOfCityObject()) {
			Iterator<JAXBElement<?>> iter = cityObject.get_GenericApplicationPropertyOfCityObject().iterator();
			while (iter.hasNext()) {
				JAXBElement<?> jaxbElem = iter.next();			
				if (jaxbElem.getValue() != null && jaxbElem.getValue() instanceof AbstractGenericAttributeType)
					iter.remove();
			}
		}
	}

	@Override
	public void unsetTerminationDate() {
		cityObject.setTerminationDate(null);
	}

	@Override
	public boolean unsetAppearance(AppearanceProperty appearanceMember) {
		if (cityObject.isSet_GenericApplicationPropertyOfCityObject()) {
			Iterator<JAXBElement<?>> iter = cityObject.get_GenericApplicationPropertyOfCityObject().iterator();
			while (iter.hasNext()) {
				JAXBElement<?> elem = iter.next();
				if (elem.getValue() != null && elem.getValue().equals(((AppearancePropertyImpl)appearanceMember).getJAXBObject())) {
					iter.remove();
					return true;
				}
			}				
		}

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
				if (elem.getValue() != null && elem.getValue() != null) {
					JAXBElement<?> ade = ModelMapper.ADE.toJAXB(adeObject);
					if (ade != null && ade.getValue() != null && elem.getValue().equals(ade.getValue())) {
						iter.remove();
						return true;
					}
				}
			}				
		}

		return false;
	}

	@Override
	public boolean unsetGenericAttribute(GenericAttribute genericAttribute) {
		if (cityObject.isSet_GenericApplicationPropertyOfCityObject()) {
			Iterator<JAXBElement<?>> iter = cityObject.get_GenericApplicationPropertyOfCityObject().iterator();
			while (iter.hasNext()) {
				JAXBElement<?> elem = iter.next();
				if (elem.getValue() != null && elem.getValue().equals(((GenericAttributeImpl)genericAttribute).getJAXBObject())) {
					iter.remove();
					return true;
				}
			}				
		}

		return false;
	}

}
