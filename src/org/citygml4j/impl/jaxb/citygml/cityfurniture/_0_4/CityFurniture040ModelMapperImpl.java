package org.citygml4j.impl.jaxb.citygml.cityfurniture._0_4;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.citygml4j.impl.jaxb.ObjectFactory;
import org.citygml4j.impl.jaxb.citygml.AbstractCityGMLModelMapperImpl;
import org.citygml4j.jaxb.citygml._0_4.CityFurnitureType;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.cityfurniture.CityFurniture;
import org.citygml4j.model.citygml.core.CityGMLBase;

public class CityFurniture040ModelMapperImpl extends AbstractCityGMLModelMapperImpl {

	public CityFurniture toCityGML(CityFurnitureType cityFurniture, QName name) {		
		if (cityFurniture.getClass().equals(CityFurnitureType.class))
			return new CityFurnitureImpl(cityFurniture);
		else
			return (CityFurniture)jaxb2ade(cityFurniture, name, CityFurniture.class);
	}
	
	public JAXBElement<? extends CityFurnitureType> toJAXB(CityFurniture cityFurniture) {
		if (!(cityFurniture instanceof ADEComponent))
			return ObjectFactory.CITYGML_0_4.createCityFurniture(((CityFurnitureImpl)cityFurniture).getJAXBObject());
		else
			return ade2jaxb((ADEComponent)cityFurniture, CityFurnitureType.class);
	}
	
	@Override
	public CityGMLBase toCityGML(JAXBElement<?> jaxbElem) {
		CityGMLBase cityGMLBase = null;
		
		if (jaxbElem.getValue() != null) {
			Object value = jaxbElem.getValue();
			QName name = jaxbElem.getName();
			
			if (value instanceof CityFurnitureType)
				cityGMLBase = toCityGML((CityFurnitureType)value, name);		
		}

		return cityGMLBase;
	}

	@Override
	public JAXBElement<?> toJAXB(CityGMLBase cityGML) {
		JAXBElement<?> jaxbElem = null;
		
		if (cityGML instanceof CityFurniture)
			jaxbElem = toJAXB((CityFurniture)cityGML);	
		
		return jaxbElem;
	}

}
