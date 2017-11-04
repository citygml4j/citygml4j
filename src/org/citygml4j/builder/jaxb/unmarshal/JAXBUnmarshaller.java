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
package org.citygml4j.builder.jaxb.unmarshal;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.citygml4j.builder.jaxb.JAXBBuilder;
import org.citygml4j.builder.jaxb.unmarshal.citygml.CityGMLUnmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.ade.ADEUnmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.gml.GMLUnmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.xal.XALUnmarshaller;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.xml.io.reader.MissingADESchemaException;
import org.citygml4j.xml.schema.SchemaHandler;
import org.w3c.dom.Element;

public class JAXBUnmarshaller {
	private final CityGMLUnmarshaller citygml;
	private final GMLUnmarshaller gml;
	private final XALUnmarshaller xal;
	private final ADEUnmarshaller ade;

	private final JAXBBuilder jaxbBuilder;
	private final SchemaHandler schemaHandler;
	private boolean parseSchema = true;
	private boolean throwMissingADESchema = true;
	private boolean releaseJAXBElements = true;

	public JAXBUnmarshaller(JAXBBuilder jaxbBuilder, SchemaHandler schemaHandler) {
		this.jaxbBuilder = jaxbBuilder;
		this.schemaHandler = schemaHandler;

		citygml = new CityGMLUnmarshaller(this);
		gml = new GMLUnmarshaller(this);
		xal = new XALUnmarshaller();
		ade = new ADEUnmarshaller(this);
	}

	public ModelObject unmarshal(JAXBElement<?> src) throws MissingADESchemaException {
		ModelObject dest = citygml.unmarshal(src);
		if (dest == null)
			dest = gml.unmarshal(src);
		if (dest == null)
			dest = xal.unmarshal(src);
		if (dest == null)
			dest = ade.unmarshal(src);

		// release memory
		if (releaseJAXBElements)
			src.setValue(null);

		return dest;
	}

	public ModelObject unmarshal(Element element) throws MissingADESchemaException {
		ModelObject dest = null;

		try {
			Unmarshaller um = jaxbBuilder.getJAXBContext().createUnmarshaller();			
			Object jaxb = um.unmarshal(element);	
			if (jaxb instanceof JAXBElement<?>)
				dest = unmarshal((JAXBElement<?>)jaxb);
		} catch (JAXBException e) {
			//
		}

		return dest;
	}

	public ModelObject unmarshal(Object src) throws MissingADESchemaException {
		if (src instanceof JAXBElement<?>)
			return unmarshal((JAXBElement<?>)src);

		if (src instanceof Element)
			return unmarshal((Element)src);

		ModelObject dest = citygml.unmarshal(src);
		if (dest == null)
			dest = gml.unmarshal(src);
		if (dest == null)
			dest = xal.unmarshal(src);
		if (dest == null)
			dest = ade.unmarshal(src);
		
		return dest;
	}

	public CityGMLUnmarshaller getCityGMLUnmarshaller() {
		return citygml;
	}

	public GMLUnmarshaller getGMLUnmarshaller() {
		return gml;
	}

	public XALUnmarshaller getXALUnmarshaller() {
		return xal;
	}

	public ADEUnmarshaller getADEUnmarshaller() {
		return ade;
	}

	public SchemaHandler getSchemaHandler() {
		return schemaHandler;
	}

	public boolean isParseSchema() {
		return parseSchema;
	}

	public void setParseSchema(boolean parseSchema) {
		this.parseSchema = parseSchema;
	}

	public boolean isThrowMissingADESchema() {
		return throwMissingADESchema;
	}

	public void setThrowMissingADESchema(boolean throwMissingADESchema) {
		this.throwMissingADESchema = throwMissingADESchema;
	}

	public boolean isReleaseJAXBElementsFromMemory() {
		return releaseJAXBElements;
	}

	public void setReleaseJAXBElementsFromMemory(boolean releaseJAXBElements) {
		this.releaseJAXBElements = releaseJAXBElements;
	}	

}
