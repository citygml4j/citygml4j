package org.citygml4j.xml.validation;

import javax.xml.bind.ValidationEventHandler;

import org.citygml4j.model.module.ModuleContext;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.xml.schema.SchemaHandler;

public interface Validator {
	public SchemaHandler getSchemaHandler();
	public ValidationEventHandler getValidationEventHandler();
	public void setSchemaHandler(SchemaHandler schemaHandler);
	public void setValidationEventHandler(ValidationEventHandler validationEventHandler);
	
	public void validate(Object object, ModuleContext moduleContext) throws CityGMLValidateException;	
	public void validate(Object object, CityGMLVersion version) throws CityGMLValidateException;
}
