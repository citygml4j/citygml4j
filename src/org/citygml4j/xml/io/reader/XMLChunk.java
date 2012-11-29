/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2012
 * Institute for Geodesy and Geoinformation Science
 * Technische Universität Berlin, Germany
 * http://www.igg.tu-berlin.de/
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 */
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
