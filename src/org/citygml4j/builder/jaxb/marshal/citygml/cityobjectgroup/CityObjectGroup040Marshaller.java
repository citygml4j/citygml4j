package org.citygml4j.builder.jaxb.marshal.citygml.cityobjectgroup;

import javax.xml.bind.JAXBElement;

import org.citygml4j.builder.jaxb.marshal.JAXBMarshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.jaxb.citygml._0_4.CityObjectGroupMemberType;
import org.citygml4j.jaxb.citygml._0_4.CityObjectGroupType;
import org.citygml4j.jaxb.citygml._0_4.ObjectFactory;
import org.citygml4j.jaxb.citygml._0_4._CityObjectType;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroup;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroupMember;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroupModuleComponent;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroupParent;
import org.citygml4j.model.common.base.ModelObject;

public class CityObjectGroup040Marshaller {
	private final ObjectFactory grp;
	private final JAXBMarshaller jaxb;
	private final CityGMLMarshaller citygml;

	public CityObjectGroup040Marshaller(CityGMLMarshaller citygml) {
		this.citygml = citygml;
		jaxb = citygml.getJAXBMarshaller();

		grp = citygml.getCore040Marshaller().getObjectFactory();
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
		citygml.getCore040Marshaller().marshalCityObject(src, dest);

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

	public CityObjectGroupMemberType marshalCityObjectGroupMember(CityObjectGroupMember src) {
		CityObjectGroupMemberType dest = grp.createCityObjectGroupMemberType();
		jaxb.getGMLMarshaller().marshalFeatureProperty(src, dest);

		if (src.isSetCityObject()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getCityObject());
			if (elem != null && elem.getValue() instanceof _CityObjectType)
				dest.set_Object((JAXBElement<?>)elem);
		}

		if (src.isSetGroupRole())
			dest.setGroupRole(src.getGroupRole());

		return dest;
	}

	public CityObjectGroupMemberType marshalCityObjectGroupParent(CityObjectGroupParent src) {
		CityObjectGroupMemberType dest = grp.createCityObjectGroupMemberType();
		jaxb.getGMLMarshaller().marshalFeatureProperty(src, dest);

		if (src.isSetCityObject()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getCityObject());
			if (elem != null && elem.getValue() instanceof _CityObjectType)
				dest.set_Object((JAXBElement<?>)elem);
		}

		return dest;
	}

}
