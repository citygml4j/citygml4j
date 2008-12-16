package org.citygml4j.model.citygml;

import javax.xml.bind.JAXBElement;

import org.citygml4j.model.citygml.core.CityGMLBase;

public interface CityGMLModelMapper {
	// mapping between implementation and JAXB
	public CityGMLBase toCityGML(JAXBElement<?> jaxbElem);
	public JAXBElement<?> toJAXB(CityGMLBase cityGML);
}
