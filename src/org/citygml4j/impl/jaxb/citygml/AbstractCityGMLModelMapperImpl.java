package org.citygml4j.impl.jaxb.citygml;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.model.citygml.CityGMLModelMapper;
import org.citygml4j.model.citygml.ade.ADEComponent;

public abstract class AbstractCityGMLModelMapperImpl implements CityGMLModelMapper {

	public ADEComponent jaxb2ade(Object jaxbObject, QName name, Class<?> parent) {
		ADEComponent ade = ModelMapper.ADE.toADEComponent(jaxbObject, name);
		return (parent.isInstance(ade)) ? ade : null;
	}
	
	@SuppressWarnings("unchecked")
	public <T> JAXBElement<? extends T> ade2jaxb(ADEComponent ade, Class<T> parent) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(ade);
		return (jaxbElem != null &&
				jaxbElem.getValue() != null &&
				parent.isInstance(jaxbElem.getValue())) ? 
						(JAXBElement<? extends T>)jaxbElem : null;
	}
}
