package org.citygml4j.xml.io.writer;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.gml.feature.AbstractFeature;

public interface CityModelWriter extends AbstractCityGMLWriter {
	public void writeStartDocument() throws CityGMLWriteException;
	public void writeEndDocument() throws CityGMLWriteException;
	public void writeFeatureMember(AbstractFeature feature) throws CityGMLWriteException;
	public void writeFeatureMember(ADEComponent adeComponent) throws CityGMLWriteException;
	public void writeFeatureMembers(List<Object> features) throws CityGMLWriteException;
	
	public CityModelInfo getCityModelInfo();	
	public void setCityModelInfo(CityModelInfo cityModelInfo);
}
