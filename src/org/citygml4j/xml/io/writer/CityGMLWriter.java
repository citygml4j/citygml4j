package org.citygml4j.xml.io.writer;

import org.citygml4j.model.gml.AbstractFeature;

public interface CityGMLWriter extends AbstractCityGMLWriter {
	public void write(AbstractFeature abstractFeature) throws CityGMLWriteException;
}
