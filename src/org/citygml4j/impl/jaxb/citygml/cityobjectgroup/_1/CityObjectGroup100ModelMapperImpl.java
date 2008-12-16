package org.citygml4j.impl.jaxb.citygml.cityobjectgroup._1;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.citygml4j.impl.jaxb.ObjectFactory;
import org.citygml4j.impl.jaxb.citygml.AbstractCityGMLModelMapperImpl;
import org.citygml4j.jaxb.citygml.grp._1.CityObjectGroupType;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroup;
import org.citygml4j.model.citygml.core.CityGMLBase;

public class CityObjectGroup100ModelMapperImpl extends AbstractCityGMLModelMapperImpl {

	public CityObjectGroup toCityGML(CityObjectGroupType cityObjectGroup, QName name) {		
		if (cityObjectGroup.getClass().equals(CityObjectGroupType.class))
			return new CityObjectGroupImpl(cityObjectGroup);
		else
			return (CityObjectGroup)jaxb2ade(cityObjectGroup, name, CityObjectGroup.class);
	}
	
	public JAXBElement<? extends CityObjectGroupType> toJAXB(CityObjectGroup cityObjectGroup) {
		if (!(cityObjectGroup instanceof ADEComponent))
			return ObjectFactory.GRP_1.createCityObjectGroup(((CityObjectGroupImpl)cityObjectGroup).getJAXBObject());
		else
			return ade2jaxb((ADEComponent)cityObjectGroup, CityObjectGroupType.class);
	}
	
	@Override
	public CityGMLBase toCityGML(JAXBElement<?> jaxbElem) {
		CityGMLBase cityGMLBase = null;
		
		if (jaxbElem.getValue() != null) {
			Object value = jaxbElem.getValue();
			QName name = jaxbElem.getName();
			
			if (value instanceof CityObjectGroupType)
				cityGMLBase = toCityGML((CityObjectGroupType)value, name);		
		}

		return cityGMLBase;
	}

	@Override
	public JAXBElement<?> toJAXB(CityGMLBase cityGML) {
		JAXBElement<?> jaxbElem = null;
		
		if (cityGML instanceof CityObjectGroup)
			jaxbElem = toJAXB((CityObjectGroup)cityGML);	
		
		return jaxbElem;
	}

}
