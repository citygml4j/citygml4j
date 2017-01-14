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
package org.citygml4j.builder;

import org.citygml4j.model.module.ModuleContext;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.CityGMLOutputFactory;
import org.citygml4j.xml.io.reader.CityGMLReadException;
import org.citygml4j.xml.io.writer.CityGMLWriteException;
import org.citygml4j.xml.schema.SchemaHandler;
import org.citygml4j.xml.validation.CityGMLValidateException;
import org.citygml4j.xml.validation.Validator;

public interface CityGMLBuilder {
	public CityGMLInputFactory createCityGMLInputFactory() throws CityGMLReadException;	
	public CityGMLInputFactory createCityGMLInputFactory(SchemaHandler schemaHandler);	
	public CityGMLOutputFactory createCityGMLOutputFactory() throws CityGMLWriteException;	
	public CityGMLOutputFactory createCityGMLOutputFactory(ModuleContext moduleContext) throws CityGMLWriteException;	
	public CityGMLOutputFactory createCityGMLOutputFactory(ModuleContext moduleContext, SchemaHandler schemaHandler);	
	public CityGMLOutputFactory createCityGMLOutputFactory(CityGMLVersion version) throws CityGMLWriteException;	
	public CityGMLOutputFactory createCityGMLOutputFactory(CityGMLVersion version, SchemaHandler schemaHandler);	
	public CityGMLOutputFactory createCityGMLOutputFactory(SchemaHandler schemaHandler);	
	public Validator createValidator() throws CityGMLValidateException;	
	public Validator createValidator(SchemaHandler schemaHandler);
}
