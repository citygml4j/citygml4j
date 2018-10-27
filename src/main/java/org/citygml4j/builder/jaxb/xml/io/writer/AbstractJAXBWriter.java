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
package org.citygml4j.builder.jaxb.xml.io.writer;

import org.citygml4j.builder.jaxb.CityGMLBuilderException;
import org.citygml4j.builder.jaxb.marshal.JAXBMarshaller;
import org.citygml4j.builder.jaxb.xml.validation.ValidationSchemaHandler;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.ade.binding.ADEContext;
import org.citygml4j.model.citygml.ade.generic.ADEGenericElement;
import org.citygml4j.model.module.Module;
import org.citygml4j.model.module.ModuleContext;
import org.citygml4j.model.module.ade.ADEModule;
import org.citygml4j.model.module.citygml.CityGMLModule;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.model.module.citygml.CoreModule;
import org.citygml4j.util.internal.xml.TransformerChainFactory;
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

import javax.xml.bind.JAXBContext;
import javax.xml.bind.ValidationEventHandler;
import java.util.List;
import java.util.Set;

public abstract class AbstractJAXBWriter implements AbstractCityGMLWriter {
	SAXWriter writer;
	JAXBMarshaller jaxbMarshaller;
	JAXBContext jaxbContext;
	FeatureSplitter featureSplitter;
	FeatureWriteMode featureWriteMode;
	TransformerChainFactory transformerChainFactory;

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
		transformerChainFactory = factory.getTransformerChainFactory();

		featureWriteMode = (FeatureWriteMode)factory.getProperty(CityGMLOutputFactory.FEATURE_WRITE_MODE);
		useValidation = (Boolean)factory.getProperty(CityGMLOutputFactory.USE_VALIDATION);

		if (featureWriteMode == FeatureWriteMode.SPLIT_PER_COLLECTION_MEMBER) {
			featureSplitter = new FeatureSplitter()
					.setSchemaHandler(schemaHandler)
					.setGMLIdManager(factory.getGMLIdManager())
					.setSplitMode(FeatureSplitMode.SPLIT_PER_COLLECTION_MEMBER)
					.keepInlineAppearance((Boolean)factory.getProperty(CityGMLOutputFactory.KEEP_INLINE_APPEARANCE))
					.splitCopy((Boolean)factory.getProperty(CityGMLOutputFactory.SPLIT_COPY))
					.exclude((Set<Class<? extends CityGML>>)factory.getProperty(CityGMLOutputFactory.EXCLUDE_FROM_SPLITTING));
		}

		if (useValidation) {
			if (schemaHandler == null) {
				try {
					schemaHandler = factory.builder.getDefaultSchemaHandler();
				} catch (CityGMLBuilderException e) {
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

	public void setIndentString(String indent) {
		writer.setIndentString(indent);
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

		for (ADEModule adeModule : moduleContext.getADEModules())
			setSchemaLocation(adeModule);
	}

	public void setSchemaLocations(List<ADEContext> adeContexts) {
		for (ADEContext adeContext : adeContexts) {
			for (ADEModule module : adeContext.getADEModules()) {
				if (module != null && module.getSchemaLocation() != null)
					setSchemaLocation(module.getNamespaceURI(), module.getSchemaLocation());
			}
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

	public void setPrefixes(List<ADEContext> adeContexts) {
		for (ADEContext adeContext : adeContexts) {
			for (ADEModule module : adeContext.getADEModules()) {
				if (module != null && module.getNamespacePrefix() != null)
					setPrefix(module);
			}
		}
	}

	protected boolean isCityObject(ADEGenericElement adeGenericElement) {
		boolean isCityObject = false;

		if (schemaHandler != null) {
			Element element = adeGenericElement.getContent();

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
