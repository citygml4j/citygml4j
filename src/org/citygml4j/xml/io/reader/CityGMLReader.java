package org.citygml4j.xml.io.reader;

import org.citygml4j.model.citygml.CityGML;

public interface CityGMLReader {
	public boolean hasNextFeature() throws CityGMLReadException;	
	public CityGML nextFeature() throws CityGMLReadException;
	public boolean isSetParentInfo();
	public ParentInfo getParentInfo();	
	public void close() throws CityGMLReadException;
}
