package org.citygml4j.xml.io.reader;

import org.citygml4j.model.citygml.CityGML;

public interface CityGMLReader {
	public boolean hasNextFeature() throws CityGMLReadException, MissingADESchemaException;	
	public boolean isSetParentInfo();

	public CityGML nextFeature() throws CityGMLReadException, MissingADESchemaException;
	public ParentInfo getParentInfo();	
	public String getBaseURI();	
	
	public void close() throws CityGMLReadException;
}
