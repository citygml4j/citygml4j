package org.citygml4j.impl.jaxb.citygml.generics._0_4;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.citygml4j.impl.jaxb.ObjectFactory;
import org.citygml4j.impl.jaxb.citygml.AbstractCityGMLModelMapperImpl;
import org.citygml4j.jaxb.citygml._0_4.GenericCityObjectType;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.CityGMLBase;
import org.citygml4j.model.citygml.generics.GenericCityObject;

public class Generics040ModelMapperImpl extends AbstractCityGMLModelMapperImpl {

	public GenericCityObject toCityGML(GenericCityObjectType genericCityObject, QName name) {		
		if (genericCityObject.getClass().equals(GenericCityObjectType.class))
			return new GenericCityObjectImpl(genericCityObject);
		else
			return (GenericCityObject)jaxb2ade(genericCityObject, name, GenericCityObject.class);
	}
			
	public JAXBElement<? extends GenericCityObjectType> toJAXB(GenericCityObject genericCityObject) {
		if (!(genericCityObject instanceof ADEComponent))
			return ObjectFactory.CITYGML_0_4.createGenericCityObject(((GenericCityObjectImpl)genericCityObject).getJAXBObject());
		else
			return ade2jaxb((ADEComponent)genericCityObject, GenericCityObjectType.class);
	}
	
	public CityGMLBase toCityGML(JAXBElement<?> jaxbElem) {
		CityGMLBase cityGMLBase = null;
		
		if (jaxbElem.getValue() != null) {
			Object value = jaxbElem.getValue();
			QName name = jaxbElem.getName();
			
			if (value instanceof GenericCityObjectType)
				cityGMLBase = toCityGML((GenericCityObjectType)value, name);
		}

		return cityGMLBase;
	}

	public JAXBElement<?> toJAXB(CityGMLBase cityGML) {
		JAXBElement<?> jaxbElem = null;
		
		if (cityGML instanceof GenericCityObject)
			jaxbElem = toJAXB((GenericCityObject)cityGML);
		
		return jaxbElem;
	}

}
