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
package org.citygml4j.builder.jaxb.xml.io.writer;

import java.util.List;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.ValidationEventHandler;

import org.citygml4j.builder.jaxb.marshal.JAXBMarshaller;
import org.citygml4j.builder.jaxb.xml.validation.ValidationSchemaHandler;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.module.Module;
import org.citygml4j.model.module.ModuleContext;
import org.citygml4j.model.module.citygml.CityGMLModule;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.model.module.citygml.CoreModule;
import org.citygml4j.util.transform.FeatureSplitMode;
import org.citygml4j.util.transform.FeatureSplitter;
import org.citygml4j.util.xml.SAXWriter;
import org.citygml4j.xml.CityGMLNamespaceContext;
import org.citygml4j.xml.io.CityGMLOutputFactory;
import org.citygml4j.xml.io.writer.AbstractCityGMLWriter;
import org.citygml4j.xml.io.writer.CityGMLWriteException;
import org.citygml4j.xml.io.writer.FeatureWriteMode;
import org.citygml4j.xml.schema.ElementDecl;
import org.citygml4j.xml.schema.Schema;
import org.citygml4j.xml.schema.SchemaHandler;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public abstract class AbstractJAXBWriter implements AbstractCityGMLWriter {
	SAXWriter writer;
	JAXBMarshaller jaxbMarshaller;
	JAXBContext jaxbContext;
	FeatureSplitter featureSplitter;
	FeatureWriteMode featureWriteMode;

	boolean useValidation;
	ValidationSchemaHandler validationSchemaHandler;
	ValidationEventHandler validationEventHandler;
	
	private SchemaHandler schemaHandler;
	
	@SuppressWarnings("unchecked")
	public AbstractJAXBWriter(SAXWriter writer, JAXBOutputFactory factory, ModuleContext moduleContext) throws CityGMLWriteException {
		this.writer = writer;

		jaxbMarshaller = factory.builder.createJAXBMarshaller(new ModuleContext(moduleContext));
		jaxbContext = factory.builder.getJAXBContext();
		schemaHandler = factory.getSchemaHandler();

		featureWriteMode = (FeatureWriteMode)factory.getProperty(CityGMLOutputFactory.FEATURE_WRITE_MODE);
		useValidation = (Boolean)factory.getProperty(CityGMLOutputFactory.USE_VALIDATION);
		
		if (featureWriteMode == FeatureWriteMode.SPLIT_PER_COLLECTION_MEMBER) {
			featureSplitter = new FeatureSplitter(schemaHandler, factory.getGMLIdManager());
			featureSplitter.setSplitMode(FeatureSplitMode.SPLIT_PER_COLLECTION_MEMBER);
			featureSplitter.setKeepInlineAppearance(
					(Boolean)factory.getProperty(CityGMLOutputFactory.KEEP_INLINE_APPEARANCE));
			featureSplitter.setSplitCopy(
					(Boolean)factory.getProperty(CityGMLOutputFactory.SPLIT_COPY));			
			featureSplitter.setExcludes(
					(Set<Class<? extends CityGML>>)factory.getProperty(CityGMLOutputFactory.EXCLUDE_FROM_SPLITTING));		
		}
		
		if (useValidation) {
			if (schemaHandler == null) {
				try {
					schemaHandler = SchemaHandler.newInstance();
				} catch (SAXException e) {
					throw new CityGMLWriteException("Caused by: ", e);
				}
			}
			
			validationSchemaHandler = new ValidationSchemaHandler(schemaHandler);
			validationEventHandler = factory.getValidationEventHandler();
		}
	}

	public void close() throws CityGMLWriteException {
		try {
			jaxbMarshaller = null;
			jaxbContext = null;
			featureSplitter = null;
			schemaHandler = null;

			validationSchemaHandler = null;
			validationEventHandler = null;
			
			if (writer != null)
				writer.close();
		} catch (SAXException e) {
			throw new CityGMLWriteException("Caused by: ", e);
		}
	}

	public void reset() {
		if (writer != null)
			writer.reset();
	}

	public void flush() throws CityGMLWriteException {
		try {
			if (writer != null)
				writer.flush();
		} catch (SAXException e) {
			throw new CityGMLWriteException("Caused by: ", e);
		}
	}

	public void setSchemaLocation(String namespaceURI, String schemaLocation) {
		writer.setSchemaLocation(namespaceURI, schemaLocation);
	}

	public boolean getEscapeCharacters() {
		return writer.getEscapeCharacters();
	}

	public String[] getHeaderComment() {
		return writer.getHeaderComment();
	}

	public String getIndentString() {
		return writer.getIndentString();
	}

	public CityGMLNamespaceContext getNamespaceContext() {
		return writer.getNamespaceContext();
	}

	public String getNamespaceURI(String prefix) {
		return writer.getNamespaceURI(prefix);
	}

	public String getPrefix(String uri) {
		return writer.getPrefix(uri);
	}

	public String getSchemaLocation(String namespaceURI) {
		return writer.getSchemaLocation(namespaceURI);
	}

	public boolean isWriteEncoding() {
		return writer.isWriteEncoding();
	}

	public boolean isWriteXMLDecl() {
		return writer.isWriteXMLDecl();
	}

	public void setDefaultNamespace(String uri) {
		writer.setDefaultNamespace(uri);
	}

	public void setEscapeCharacters(boolean escapeCharacters) {
		writer.setEscapeCharacters(escapeCharacters);
	}

	public void setHeaderComment(String... headerMessage) {
		writer.setHeaderComment(headerMessage);
	}

	public void unsetHeaderComment() {
		writer.unsetHeaderComment();
	}

	public void setIndentString(String indentString) {
		writer.setIndentString(indentString);
	}

	public void setNamespaceContext(CityGMLNamespaceContext context) {
		writer.setNamespaceContext(context);
	}

	public void setPrefix(String prefix, String uri) {
		writer.setPrefix(prefix, uri);
	}

	public void setWriteEncoding(boolean writeEncoding) {
		writer.setWriteEncoding(writeEncoding);
	}

	public void setWriteXMLDecl(boolean writeXMLDecl) {
		writer.setWriteXMLDecl(writeXMLDecl);
	}

	public ModuleContext getModuleContext() {
		return jaxbMarshaller.getModuleContext();
	}

	public void setModuleContext(ModuleContext moduleContext) {
		jaxbMarshaller.setModuleContext(moduleContext);
	}

	public void setSchemaLocation(Module module) {
		setSchemaLocation(module.getNamespaceURI(), module.getSchemaLocation());
	}

	public void setSchemaLocations(CityGMLVersion version) {
		for (CityGMLModule module : version.getCityGMLModules()) {
			if (module instanceof CoreModule)
				continue;

			setSchemaLocation(module);
		}
	}

	public void setSchemaLocations(ModuleContext moduleContext) {
		for (CityGMLModule module : moduleContext.getCityGMLModules()) {
			if (module instanceof CoreModule)
				continue;

			setSchemaLocation(module);
		}
	}

	public void setDefaultNamespace(Module module) {
		setDefaultNamespace(module.getNamespaceURI());
	}

	public void setPrefix(Module module) {
		setPrefix(module.getNamespacePrefix(), module.getNamespaceURI());
	}

	public void setPrefixes(CityGMLVersion version) {
		for (Module module : version.getModules())
			setPrefix(module);
	}

	public void setPrefixes(ModuleContext moduleContext) {
		for (Module module : moduleContext.getModules())
			setPrefix(module);
	}
	
	protected boolean isCityObject(ADEComponent adeComponent) {
		boolean isCityObject = false;
		
		if (schemaHandler != null) {
			Element element = adeComponent.getContent();

			Schema schema = schemaHandler.getSchema(element.getNamespaceURI());
			if (schema != null) {
				List<ElementDecl> elementDecls = schema.getElementDecls(element.getLocalName());
				if (elementDecls.size() == 1)
					isCityObject = elementDecls.get(0).isCityObject();
			}
		}
		
		return isCityObject;
	}

}
