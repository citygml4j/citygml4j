package org.citygml4j.xml.io.writer;

import org.citygml4j.model.gml.feature.AbstractFeature;

public interface CityGMLWriter extends AbstractCityGMLWriter {
	public void write(AbstractFeature abstractFeature) throws CityGMLWriteException;
}
