package org.citygml4j.builder.jaxb.unmarshal.citygml.cityobjectgroup;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.citygml4j.builder.jaxb.unmarshal.JAXBUnmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.CityGMLUnmarshaller;
import org.citygml4j.impl.citygml.cityobjectgroup.CityObjectGroupImpl;
import org.citygml4j.impl.citygml.cityobjectgroup.CityObjectGroupMemberImpl;
import org.citygml4j.impl.citygml.cityobjectgroup.CityObjectGroupParentImpl;
import org.citygml4j.jaxb.citygml.grp._1.CityObjectGroupMemberType;
import org.citygml4j.jaxb.citygml.grp._1.CityObjectGroupParentType;
import org.citygml4j.jaxb.citygml.grp._1.CityObjectGroupType;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroup;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroupMember;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroupParent;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.module.citygml.CityObjectGroupModule;
import org.citygml4j.xml.io.reader.MissingADESchemaException;

public class CityObjectGroup100Unmarshaller {
	private final CityObjectGroupModule module = CityObjectGroupModule.v1_0_0;
	private final JAXBUnmarshaller jaxb;
	private final CityGMLUnmarshaller citygml;

	public CityObjectGroup100Unmarshaller(CityGMLUnmarshaller citygml) {
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

		if (src instanceof CityObjectGroupType)
			dest = unmarshalCityObjectGroup((CityObjectGroupType)src);
		else if (src instanceof CityObjectGroupMemberType)
			dest = unmarshalCityObjectGroupMember((CityObjectGroupMemberType)src);
		else if (src instanceof CityObjectGroupParentType)
			dest = unmarshalCityObjectGroupParent((CityObjectGroupParentType)src);

		return dest;
	}

	public void unmarshalCityObjectGroup(CityObjectGroupType src, CityObjectGroup dest) throws MissingADESchemaException {
		citygml.getCore100Unmarshaller().unmarshalCityObject(src, dest);

		if (src.isSetClazz())
			dest.setClazz(src.getClazz());

		if (src.isSetFunction())
			dest.setFunction(src.getFunction());

		if (src.isSetUsage())
			dest.setUsage(src.getUsage());

		if (src.isSetGeometry())
			dest.setGeometry(jaxb.getGMLUnmarshaller().unmarshalGeometryProperty(src.getGeometry()));

		if (src.isSetGroupMember()) {
			for (CityObjectGroupMemberType cityObjectGroupMember : src.getGroupMember())
				dest.addGroupMember(unmarshalCityObjectGroupMember(cityObjectGroupMember));
		}

		if (src.isSetParent())
			dest.setGroupParent(unmarshalCityObjectGroupParent(src.getParent()));	
	}

	public CityObjectGroup unmarshalCityObjectGroup(CityObjectGroupType src) throws MissingADESchemaException {
		CityObjectGroup dest = new CityObjectGroupImpl(module);
		unmarshalCityObjectGroup(src, dest);

		return dest;
	}

	public CityObjectGroupMember unmarshalCityObjectGroupMember(CityObjectGroupMemberType src) throws MissingADESchemaException {
		CityObjectGroupMember dest = new CityObjectGroupMemberImpl(module);

		if (src.isSet_CityObject()) {
			Object object = jaxb.unmarshal(src.get_CityObject());
			if (object instanceof AbstractCityObject)
				dest.setObject((AbstractCityObject)object);
		}
		
		if (src.isSetGroupRole())
			dest.setGroupRole(src.getGroupRole());

		if (src.isSet_ADEComponent())
			dest.setGenericADEComponent(jaxb.getADEUnmarshaller().unmarshal(src.get_ADEComponent()));
		
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

	public CityObjectGroupParent unmarshalCityObjectGroupParent(CityObjectGroupParentType src) throws MissingADESchemaException {
		CityObjectGroupParent dest = new CityObjectGroupParentImpl(module);

		if (src.isSet_CityObject()) {
			Object object = jaxb.unmarshal(src.get_CityObject());
			if (object instanceof AbstractCityObject)
				dest.setObject((AbstractCityObject)object);
		}
		
		if (src.isSet_ADEComponent())
			dest.setGenericADEComponent(jaxb.getADEUnmarshaller().unmarshal(src.get_ADEComponent()));

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
	
	public boolean assignGenericProperty(ADEComponent genericProperty, QName substitutionGroup, CityGML dest) {
		String name = substitutionGroup.getLocalPart();
		boolean success = true;
		
		if (dest instanceof CityObjectGroup && name.equals("_GenericApplicationPropertyOfCityObjectGroup"))
			((CityObjectGroup)dest).addGenericApplicationPropertyOfCityObjectGroup(genericProperty);
		else 
			success = false;
		
		return success;
	}

}
