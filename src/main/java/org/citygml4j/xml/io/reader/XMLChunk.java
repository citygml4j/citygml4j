/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.citygml4j.xml.io.reader;

import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.CityGMLClass;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

import javax.xml.namespace.QName;

public interface XMLChunk {
	public CityGML unmarshal() throws UnmarshalException, MissingADESchemaException;
	public QName getTypeName();
	public CityGMLClass getCityGMLClass();
	public boolean isSetParentInfo();
	public ParentInfo getParentInfo();
	public boolean hasPassedXMLValidation();
	public void send(ContentHandler handler, boolean release) throws SAXException;
}
