package org.citygml4j.builder;

import org.citygml4j.model.module.ModuleContext;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.CityGMLOutputFactory;
import org.citygml4j.xml.io.reader.CityGMLReadException;
import org.citygml4j.xml.schema.SchemaHandler;
import org.citygml4j.xml.validation.CityGMLValidateException;
import org.citygml4j.xml.validation.Validator;

public interface CityGMLBuilder {
	public CityGMLInputFactory createCityGMLInputFactory() throws CityGMLReadException;	
	public CityGMLInputFactory createCityGMLInputFactory(SchemaHandler schemaHandler);	
	public CityGMLOutputFactory createCityGMLOutputFactory() throws CityGMLReadException;	
	public CityGMLOutputFactory createCityGMLOutputFactory(ModuleContext moduleContext) throws CityGMLReadException;	
	public CityGMLOutputFactory createCityGMLOutputFactory(ModuleContext moduleContext, SchemaHandler schemaHandler);	
	public CityGMLOutputFactory createCityGMLOutputFactory(CityGMLVersion version) throws CityGMLReadException;	
	public CityGMLOutputFactory createCityGMLOutputFactory(CityGMLVersion version, SchemaHandler schemaHandler);	
	public CityGMLOutputFactory createCityGMLOutputFactory(SchemaHandler schemaHandler);	
	public Validator createValidator() throws CityGMLValidateException;	
	public Validator createValidator(SchemaHandler schemaHandler);
}
