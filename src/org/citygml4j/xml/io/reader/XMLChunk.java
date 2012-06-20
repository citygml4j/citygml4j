package org.citygml4j.xml.io.reader;

import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.util.xml.saxevents.StartElement;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

public interface XMLChunk {
	public CityGML unmarshal() throws UnmarshalException, MissingADESchemaException;
	public CityGMLClass getCityGMLClass();
	public boolean isSetParentInfo();
	public ParentInfo getParentInfo();
	public boolean hasPassedXMLValidation();
	public void send(ContentHandler handler) throws SAXException;
	public StartElement getFirstStartElement();
}
