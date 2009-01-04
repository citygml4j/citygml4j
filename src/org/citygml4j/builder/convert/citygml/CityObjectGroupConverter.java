package org.citygml4j.builder.convert.citygml;

import org.citygml4j.factory.CityGMLFactory;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroup;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroupMember;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroupParent;
import org.citygml4j.model.citygml.core.CityObject;

public class CityObjectGroupConverter {
	private CityGMLConvertBuilder builder;
	private CityGMLFactory citygml;

	protected CityObjectGroupConverter(CityGMLConvertBuilder builder) {
		this.builder = builder;
		citygml = new CityGMLFactory();
	}

	protected CityObjectGroup convertCityObjectGroup(CityObjectGroup src) {
		CityObjectGroup dest = null;

		if (src instanceof ADEComponent) {
			ADEComponent tmp = builder.convertADEComponent((ADEComponent)src);
			if (tmp != null && tmp instanceof CityObjectGroup)
				dest = (CityObjectGroup)tmp;
		} else {
			dest = citygml.createCityObjectGroup(builder.convertContext.grpModule);
			if (dest != null)
				convertCityObjectGroup(src, dest);
		}

		return dest;
	}

	protected CityObjectGroupMember convertCityObjectGroupMember(CityObjectGroupMember src) {
		CityObjectGroupMember dest = citygml.createCityObjectGroupMember(builder.convertContext.grpModule);
		if (dest != null) {
			builder.gml.convertAssociation(src, dest);

			if (src.isSetGroupRole())
				dest.setGroupRole(src.getGroupRole());

			if (src.isSetObject()) {
				CityObject tmp = builder.core.convertCityObject(src.getObject());
				if (tmp != null)
					dest.setObject(tmp);
			}
		}

		return dest;
	}

	protected CityObjectGroupParent convertCityObjectGroupParent(CityObjectGroupParent src) {
		CityObjectGroupParent dest = citygml.createCityObjectGroupParent(builder.convertContext.grpModule);
		if (dest != null) {
			builder.gml.convertAssociation(src, dest);

			if (src.isSetObject()) {
				CityObject tmp = builder.core.convertCityObject(src.getObject());
				if (tmp != null)
					dest.setObject(tmp);
			}
		}

		return dest;
	}

	protected void convertCityObjectGroup(CityObjectGroup src, CityObjectGroup dest) {
		builder.core.convertCityObject(src, dest);

		if (src.isSetClazz())
			dest.setClazz(src.getClazz());

		if (src.isSetFunction())
			dest.setFunction(src.getFunction());

		if (src.isSetUsage())
			dest.setUsage(src.getUsage());

		if (src.isSetGroupMember()) {
			for (CityObjectGroupMember member : src.getGroupMember()) {
				CityObjectGroupMember tmp = convertCityObjectGroupMember(member);
				if (tmp != null)
					dest.addGroupMember(tmp);
			}
		}

		if (src.isSetParent()) {
			CityObjectGroupParent tmp = convertCityObjectGroupParent(src.getParent());
			if (tmp != null)
				dest.setParent(tmp);
		}

		if (src.isSetGeometry())
			dest.setGeometry(dest.getGeometry());

		if (src.isSetGenericApplicationPropertyOfCityObjectGroup()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfCityObjectGroup()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfCityObjectGroup(tmp);
			}
		}
	}
}
