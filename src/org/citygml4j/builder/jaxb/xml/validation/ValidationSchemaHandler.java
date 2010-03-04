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
	
	public Schema getSchema() throws SAXException {
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
