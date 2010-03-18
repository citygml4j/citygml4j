package org.citygml4j.builder.jaxb.unmarshal.citygml.cityobjectgroup;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.citygml4j.builder.jaxb.unmarshal.JAXBUnmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.CityGMLUnmarshaller;
import org.citygml4j.impl.citygml.cityobjectgroup.CityObjectGroupImpl;
import org.citygml4j.impl.citygml.cityobjectgroup.CityObjectGroupMemberImpl;
import org.citygml4j.impl.citygml.cityobjectgroup.CityObjectGroupParentImpl;
import org.citygml4j.jaxb.citygml._0_4.CityObjectGroupMemberType;
import org.citygml4j.jaxb.citygml._0_4.CityObjectGroupType;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroup;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroupMember;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroupParent;
import org.citygml4j.model.citygml.core.CityObject;
import org.citygml4j.model.module.citygml.CityObjectGroupModule;
import org.citygml4j.xml.io.reader.MissingADESchemaException;

public class CityObjectGroup040Unmarshaller {
	private final CityObjectGroupModule module = CityObjectGroupModule.v0_4_0;
	private final JAXBUnmarshaller jaxb;
	private final CityGMLUnmarshaller citygml;

	public CityObjectGroup040Unmarshaller(CityGMLUnmarshaller citygml) {
		this.citygml = citygml;
		jaxb = citygml.getJAXBUnmarshaller();
	}

	public CityGML unmarshal(JAXBElement<?> src) throws MissingADESchemaException {
		final String localPart = src.getName().getLocalPart();
		final Object value = src.getValue();

		CityGML dest = null;

		if (localPart.equals("parent"))
			dest = unmarshalCityObjectGroupParent((CityObjectGroupMemberType)value);
		else
			dest = unmarshal(src.getValue());

		return dest;
	}

	public CityGML unmarshal(Object src) throws MissingADESchemaException {
		if (src instanceof JAXBElement<?>)
			return unmarshal((JAXBElement<?>)src);

		CityGML dest = null;

		if (src instanceof CityObjectGroupType)
			dest = unmarshalCityObjectGroup((CityObjectGroupType)src);
		else if (src instanceof CityObjectGroupMemberType)
			dest = unmarshalCityObjectGroupMember((CityObjectGroupMemberType)src);

		return dest;
	}

	public void unmarshalCityObjectGroup(CityObjectGroupType src, CityObjectGroup dest) throws MissingADESchemaException {
		citygml.getCore040Unmarshaller().unmarshalCityObject(src, dest);

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
		jaxb.getGMLUnmarshaller().unmarshalAssociation(src, dest);

		if (src.isSetGroupRole())
			dest.setGroupRole(src.getGroupRole());

		if (src.isSet_Object()) {
			Object object = jaxb.unmarshal(src.get_Object());
			if (object instanceof CityObject)
				dest.setObject((CityObject)object);
		}

		return dest;
	}

	public CityObjectGroupParent unmarshalCityObjectGroupParent(CityObjectGroupMemberType src) throws MissingADESchemaException {
		CityObjectGroupParent dest = new CityObjectGroupParentImpl(module);
		jaxb.getGMLUnmarshaller().unmarshalAssociation(src, dest);

		if (src.isSet_Object()) {
			Object object = jaxb.unmarshal(src.get_Object());
			if (object instanceof CityObject)
				dest.setObject((CityObject)object);
		}

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
