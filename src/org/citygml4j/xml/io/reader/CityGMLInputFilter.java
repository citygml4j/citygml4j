package org.citygml4j.xml.io.reader;

import org.citygml4j.model.citygml.CityGMLClass;

public interface CityGMLInputFilter {
	public boolean accept(CityGMLClass type);
}
