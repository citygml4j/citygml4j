/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universitaet Berlin, Germany
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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 */
package org.citygml4j.builder.jaxb.xml.validation;

import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.citygml4j.xml.schema.SchemaHandler;
import org.xml.sax.SAXException;

public class ValidationSchemaHandler {
	private final SchemaFactory schemaFactory;
	
	private SchemaHandler schemaHandler;
	private Schema schema;
	private int size = -1;
	
	public ValidationSchemaHandler(SchemaHandler schemaHandler) {
		this.schemaHandler = schemaHandler;
		schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
	}
	
	public synchronized Schema getSchema() throws SAXException {
		if (size != schemaHandler.size()) {
			size = schemaHandler.size();
			schema = schemaFactory.newSchema(schemaHandler.getSchemaSources());
		}
		
		return schema;
	}
	
	public SchemaHandler getSchemaHandler() {
		return schemaHandler;
	}
	
	public void setSchemaHandler(SchemaHandler schemaHandler) {
		if (schemaHandler == null)
			throw new IllegalArgumentException("schema handler may not be null.");

		this.schemaHandler = schemaHandler;
		size = -1;
	}
}
