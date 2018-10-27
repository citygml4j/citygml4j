/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright 2013-2017 Claus Nagel <claus.nagel@gmail.com>
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
package org.citygml4j.builder.jaxb.xml.validation;

import org.citygml4j.xml.schema.SchemaHandler;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class ValidationSchemaHandler {
	private final SchemaFactory schemaFactory;
	
	private SchemaHandler schemaHandler;
	private Schema schema;
	private AtomicInteger size = new AtomicInteger(-1);
		
	public ValidationSchemaHandler(SchemaHandler schemaHandler) {
		this.schemaHandler = schemaHandler;
		schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
	}
	
	public Schema getSchema() throws SAXException {
		int currentSize = size.get();
		if (currentSize != schemaHandler.size() && size.compareAndSet(currentSize, schemaHandler.size()))
			schema = schemaFactory.newSchema(schemaHandler.getSchemaSources());
		
		return schema;
	}
	
	public SchemaHandler getSchemaHandler() {
		return schemaHandler;
	}
	
	public void setSchemaHandler(SchemaHandler schemaHandler) {
		if (schemaHandler == null)
			throw new IllegalArgumentException("schema handler may not be null.");

		this.schemaHandler = schemaHandler;
		size.set(-1);
	}
}
