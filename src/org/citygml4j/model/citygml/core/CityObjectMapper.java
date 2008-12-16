package org.citygml4j.model.citygml.core;

import javax.xml.bind.JAXBElement;

import org.citygml4j.jaxb.gml._3_1_1.AbstractFeatureType;

public interface CityObjectMapper {
	public CityObject toCityGML(JAXBElement<? extends AbstractFeatureType> abstractFeature);
	public JAXBElement<? extends AbstractFeatureType> toJAXB(CityObject cityObject);
}
