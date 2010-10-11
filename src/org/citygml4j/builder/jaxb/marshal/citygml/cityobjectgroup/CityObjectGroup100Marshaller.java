package org.citygml4j.builder.jaxb.marshal.citygml.cityobjectgroup;

import javax.xml.bind.JAXBElement;

import org.citygml4j.builder.jaxb.marshal.JAXBMarshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.jaxb.citygml.core._1.AbstractCityObjectType;
import org.citygml4j.jaxb.citygml.grp._1.CityObjectGroupMemberType;
import org.citygml4j.jaxb.citygml.grp._1.CityObjectGroupParentType;
import org.citygml4j.jaxb.citygml.grp._1.CityObjectGroupType;
import org.citygml4j.jaxb.citygml.grp._1.ObjectFactory;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroup;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroupMember;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroupModuleComponent;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroupParent;
import org.citygml4j.model.common.base.ModelObject;

public class CityObjectGroup100Marshaller {
	private final ObjectFactory grp = new ObjectFactory();
	private final JAXBMarshaller jaxb;
	private final CityGMLMarshaller citygml;
	
	public CityObjectGroup100Marshaller(CityGMLMarshaller citygml) {
		this.citygml = citygml;
		jaxb = citygml.getJAXBMarshaller();
	}

	public JAXBElement<?> marshalJAXBElement(Object src) {
		JAXBElement<?> dest = null;
		
		if (src instanceof CityObjectGroupModuleComponent)
			src = marshal((CityObjectGroupModuleComponent)src);
		
		if (src instanceof CityObjectGroupType)
			dest = grp.createCityObjectGroup((CityObjectGroupType)src);
		
		return dest;
	}
	
	public Object marshal(ModelObject src) {
		Object dest = null;
		
		if (src instanceof CityObjectGroup)
			dest = marshalCityObjectGroup((CityObjectGroup)src);
		else if (src instanceof CityObjectGroupMember)
			dest = marshalCityObjectGroupMember((CityObjectGroupMember)src);
		else if (src instanceof CityObjectGroupParent)
			dest = marshalCityObjectGroupParent((CityObjectGroupParent)src);
		
		return dest;
	}
	
	public void marshalCityObjectGroup(CityObjectGroup src, CityObjectGroupType dest) {
		citygml.getCore100Marshaller().marshalCityObject(src, dest);

		if (src.isSetClazz())
			dest.setClazz(src.getClazz());

		if (src.isSetFunction())
			dest.setFunction(src.getFunction());

		if (src.isSetUsage())
			dest.setUsage(src.getUsage());

		if (src.isSetGeometry())
			dest.setGeometry(jaxb.getGMLMarshaller().marshalGeometryProperty(src.getGeometry()));

		if (src.isSetGroupMember()) {
			for (CityObjectGroupMember cityObjectGroupMember : src.getGroupMember())
				dest.getGroupMember().add(marshalCityObjectGroupMember(cityObjectGroupMember));
		}

		if (src.isSetGroupParent())
			dest.setParent(marshalCityObjectGroupParent(src.getGroupParent()));	
		
		if (src.isSetGenericApplicationPropertyOfCityObjectGroup()) {
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfCityObjectGroup())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfCityObjectGroup().add(citygml.ade2jaxbElement(adeComponent));
		}
	}

	public CityObjectGroupType marshalCityObjectGroup(CityObjectGroup src) {
		CityObjectGroupType dest = grp.createCityObjectGroupType();
		marshalCityObjectGroup(src, dest);

		return dest;
	}
		
	@SuppressWarnings("unchecked")
	public CityObjectGroupMemberType marshalCityObjectGroupMember(CityObjectGroupMember src) {
		CityObjectGroupMemberType dest = grp.createCityObjectGroupMemberType();

		if (src.isSetCityObject()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getCityObject());
			if (elem != null && elem.getValue() instanceof AbstractCityObjectType)
				dest.set_CityObject((JAXBElement<? extends AbstractCityObjectType>)elem);
		}
		
		if (src.isSetGenericADEComponent()) {
			ADEComponent adeComponent = src.getGenericADEComponent();
			if (adeComponent.isSetContent())
				dest.set_ADEComponent(adeComponent.getContent());
		}
		
		if (src.isSetGroupRole())
			dest.setGroupRole(src.getGroupRole());
		
		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(src.getShow());

		if (src.isSetActuate())
			dest.setActuate(src.getActuate());

		return dest;
	}
	
	@SuppressWarnings("unchecked")
	public CityObjectGroupParentType marshalCityObjectGroupParent(CityObjectGroupParent src) {
		CityObjectGroupParentType dest = grp.createCityObjectGroupParentType();

		if (src.isSetCityObject()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getCityObject());
			if (elem != null && elem.getValue() instanceof AbstractCityObjectType)
				dest.set_CityObject((JAXBElement<? extends AbstractCityObjectType>)elem);
		}
		
		if (src.isSetGenericADEComponent()) {
			ADEComponent adeComponent = src.getGenericADEComponent();
			if (adeComponent.isSetContent())
				dest.set_ADEComponent(adeComponent.getContent());
		}

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(src.getShow());

		if (src.isSetActuate())
			dest.setActuate(src.getActuate());

		return dest;
	}
	
}
