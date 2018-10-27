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
package org.citygml4j.builder.jaxb.xml.io.writer;

import org.citygml4j.builder.jaxb.CityGMLBuilder;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.module.ModuleContext;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.util.gmlid.DefaultGMLIdManager;
import org.citygml4j.util.gmlid.GMLIdManager;
import org.citygml4j.util.internal.xml.TransformerChainFactory;
import org.citygml4j.util.xml.SAXWriter;
import org.citygml4j.xml.io.CityGMLOutputFactory;
import org.citygml4j.xml.io.writer.CityGMLWriteException;
import org.citygml4j.xml.io.writer.CityGMLWriter;
import org.citygml4j.xml.io.writer.CityModelWriter;
import org.citygml4j.xml.io.writer.FeatureWriteMode;
import org.citygml4j.xml.schema.SchemaHandler;

import javax.xml.bind.ValidationEventHandler;
import javax.xml.transform.Templates;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class JAXBOutputFactory implements CityGMLOutputFactory {
	CityGMLBuilder builder;
	private SchemaHandler schemaHandler;	
	private ModuleContext moduleContext;
	private GMLIdManager gmlIdManager;
	private ValidationEventHandler validationEventHandler;
	private TransformerChainFactory transformerChainFactory;

	private FeatureWriteMode featureWriteMode;
	private Set<Class<? extends CityGML>> excludes;
	private boolean keepInlineAppearance;
	private boolean splitCopy;
	private boolean useValidation;
	
	public JAXBOutputFactory(CityGMLBuilder builder, ModuleContext moduleContext, SchemaHandler schemaHandler) {
		this.builder = builder;
		this.schemaHandler = schemaHandler;
		this.moduleContext = moduleContext;

		gmlIdManager = DefaultGMLIdManager.getInstance();
		featureWriteMode = FeatureWriteMode.NO_SPLIT;
		excludes = new HashSet<>();
		keepInlineAppearance = true;
		splitCopy = true;
	}
	
	public JAXBOutputFactory(CityGMLBuilder builder) {
		this(builder, new ModuleContext(), null);
	}
	
	public JAXBOutputFactory(CityGMLBuilder builder, ModuleContext moduleContext) {
		this(builder, moduleContext, null);
	}
	
	public JAXBOutputFactory(CityGMLBuilder builder, SchemaHandler schemaHandler) {
		this(builder, new ModuleContext(), schemaHandler);
	}
	
	public CityGMLWriter createCityGMLWriter(File file, ModuleContext moduleContext) throws CityGMLWriteException {
		try {
			createParentDirectories(file.toPath());
			return new JAXBSimpleWriter(
					new SAXWriter(new OutputStreamWriter(new FileOutputStream(file))), 
					this, 
					moduleContext);
		} catch (IOException e) {
			throw new CityGMLWriteException("Caused by: ", e);
		}
	}

	public CityGMLWriter createCityGMLWriter(File file, String encoding, ModuleContext moduleContext) throws CityGMLWriteException {
		try {
			createParentDirectories(file.toPath());
			return new JAXBSimpleWriter(
					new SAXWriter(new OutputStreamWriter(new FileOutputStream(file), encoding)), 
					this, 
					moduleContext);
		} catch (IOException e) {
			throw new CityGMLWriteException("Caused by: ", e);
		}
	}

	public CityGMLWriter createCityGMLWriter(OutputStream outputStream, ModuleContext moduleContext) throws CityGMLWriteException {
		try {
			return new JAXBSimpleWriter(
					new SAXWriter(outputStream), 
					this, 
					moduleContext);
		} catch (IOException e) {
			throw new CityGMLWriteException("Caused by: ", e);
		}
	}

	public CityGMLWriter createCityGMLWriter(OutputStream outputStream, String encoding, ModuleContext moduleContext) throws CityGMLWriteException {
		try {
			return new JAXBSimpleWriter(
					new SAXWriter(outputStream, encoding), 
					this, 
					moduleContext);
		} catch (IOException e) {
			throw new CityGMLWriteException("Caused by: ", e);
		}
	}

	public CityGMLWriter createCityGMLWriter(StreamResult streamResult, String encoding, ModuleContext moduleContext) throws CityGMLWriteException {
		try {
			return new JAXBSimpleWriter(
					new SAXWriter(streamResult, encoding), 
					this, 
					moduleContext);
		} catch (IOException e) {
			throw new CityGMLWriteException("Caused by: ", e);
		}
	}

	public CityGMLWriter createCityGMLWriter(Writer writer, ModuleContext moduleContext) throws CityGMLWriteException {
		try {
			return new JAXBSimpleWriter(
					new SAXWriter(writer), 
					this, 
					moduleContext);
		} catch (IOException e) {
			throw new CityGMLWriteException("Caused by: ", e);
		}
	}
	
	public CityGMLWriter createCityGMLWriter(File file, String encoding) throws CityGMLWriteException {
		return createCityGMLWriter(file, encoding, moduleContext);
	}

	public CityGMLWriter createCityGMLWriter(File file) throws CityGMLWriteException {
		return createCityGMLWriter(file, moduleContext);
	}
	
	public CityGMLWriter createCityGMLWriter(OutputStream outputStream, String encoding) throws CityGMLWriteException {
		return createCityGMLWriter(outputStream, encoding, moduleContext);
	}

	public CityGMLWriter createCityGMLWriter(OutputStream outputStream) throws CityGMLWriteException {
		return createCityGMLWriter(outputStream, moduleContext);
	}
	
	public CityGMLWriter createCityGMLWriter(StreamResult streamResult, String encoding) throws CityGMLWriteException {
		return createCityGMLWriter(streamResult, encoding, moduleContext);
	}
	
	public CityGMLWriter createCityGMLWriter(Writer writer) throws CityGMLWriteException {
		return createCityGMLWriter(writer, moduleContext);
	}

	public CityModelWriter createCityModelWriter(File file, ModuleContext moduleContext) throws CityGMLWriteException {
		try {
			createParentDirectories(file.toPath());
			return new JAXBModelWriter(
					new SAXWriter(new OutputStreamWriter(new FileOutputStream(file))), 
					this, 
					moduleContext);
		} catch (IOException e) {
			throw new CityGMLWriteException("Caused by: ", e);
		}
	}

	public CityModelWriter createCityModelWriter(File file, String encoding, ModuleContext moduleContext) throws CityGMLWriteException {
		try {
			createParentDirectories(file.toPath());
			return new JAXBModelWriter(
					new SAXWriter(new OutputStreamWriter(new FileOutputStream(file), encoding)), 
					this, 
					moduleContext);
		} catch (IOException e) {
			throw new CityGMLWriteException("Caused by: ", e);
		}
	}

	public CityModelWriter createCityModelWriter(OutputStream outputStream, ModuleContext moduleContext) throws CityGMLWriteException {
		try {
			return new JAXBModelWriter(
					new SAXWriter(outputStream), 
					this, 
					moduleContext);
		} catch (IOException e) {
			throw new CityGMLWriteException("Caused by: ", e);
		}
	}

	public CityModelWriter createCityModelWriter(OutputStream outputStream, String encoding, ModuleContext moduleContext) throws CityGMLWriteException {
		try {
			return new JAXBModelWriter(
					new SAXWriter(outputStream, encoding), 
					this, 
					moduleContext);
		} catch (IOException e) {
			throw new CityGMLWriteException("Caused by: ", e);
		}
	}

	public CityModelWriter createCityModelWriter(StreamResult streamResult, String encoding, ModuleContext moduleContext) throws CityGMLWriteException {
		try {
			return new JAXBModelWriter(
					new SAXWriter(streamResult, encoding), 
					this, 
					moduleContext);
		} catch (IOException e) {
			throw new CityGMLWriteException("Caused by: ", e);
		}
	}

	public CityModelWriter createCityModelWriter(Writer writer, ModuleContext moduleContext) throws CityGMLWriteException {
		try {
			return new JAXBModelWriter(
					new SAXWriter(writer), 
					this, 
					moduleContext);
		} catch (IOException e) {
			throw new CityGMLWriteException("Caused by: ", e);
		}
	}
	
	public CityModelWriter createCityModelWriter(File file, String encoding) throws CityGMLWriteException {
		return createCityModelWriter(file, encoding, moduleContext);
	}

	public CityModelWriter createCityModelWriter(File file) throws CityGMLWriteException {
		return createCityModelWriter(file, moduleContext);
	}
	
	public CityModelWriter createCityModelWriter(OutputStream outputStream, String encoding) throws CityGMLWriteException {
		return createCityModelWriter(outputStream, encoding, moduleContext);
	}

	public CityModelWriter createCityModelWriter(OutputStream outputStream) throws CityGMLWriteException {
		return createCityModelWriter(outputStream, moduleContext);
	}
	
	public CityModelWriter createCityModelWriter(StreamResult streamResult, String encoding) throws CityGMLWriteException {
		return createCityModelWriter(streamResult, encoding, moduleContext);
	}
	
	public CityModelWriter createCityModelWriter(Writer writer) throws CityGMLWriteException {
		return createCityModelWriter(writer, moduleContext);
	}
	
	public ModuleContext getModuleContext() {
		return moduleContext;
	}

	public SchemaHandler getSchemaHandler() {
		return schemaHandler;
	}

	public void setSchemaHandler(SchemaHandler schemaHandler) {
		if (schemaHandler == null)
			throw new IllegalArgumentException("schema handler may not be null.");

		this.schemaHandler = schemaHandler;
	}

	public void setModuleContext(ModuleContext moduleContext) {
		if (moduleContext == null)
			throw new IllegalArgumentException("module context may not be null.");

		this.moduleContext = moduleContext;
	}

	public void setCityGMLVersion(CityGMLVersion version) {
		if (version == null)
			throw new IllegalArgumentException("CityGML version may not be null.");

		moduleContext = new ModuleContext(version);
	}

	public GMLIdManager getGMLIdManager() {
		return gmlIdManager;
	}

	public void setGMLIdManager(GMLIdManager gmlIdManager) {
		if (gmlIdManager == null)
			throw new IllegalArgumentException("gml:id manager may not be null.");

		this.gmlIdManager = gmlIdManager;
	}

	public ValidationEventHandler getValidationEventHandler() {
		return validationEventHandler;
	}

	public void setValidationEventHandler(ValidationEventHandler validationEventHandler) {
		if (validationEventHandler == null)
			throw new IllegalArgumentException("validation event handler may not be null.");

		this.validationEventHandler = validationEventHandler;
	}

	public void setTransformationTemplates(Templates... transformationTemplates) throws CityGMLWriteException {
		if (transformationTemplates == null)
			throw new IllegalArgumentException("transformation templates may not be null.");

		try {
			if (transformerChainFactory == null)
				transformerChainFactory = new TransformerChainFactory(transformationTemplates);
			else
				transformerChainFactory.updateTemplates(transformationTemplates);
		} catch (TransformerConfigurationException e) {
			throw new CityGMLWriteException("Caused by: ", e);
		}
	}

	public Templates[] getTransformationTemplates() {
		return transformerChainFactory == null ? null : transformerChainFactory.getTemplates();
	}

	public TransformerChainFactory getTransformerChainFactory() {
		return transformerChainFactory;
	}

	public Object getProperty(String name) {
		Objects.requireNonNull(name, "property name may not be null.");

		if (name.equals(CityGMLOutputFactory.FEATURE_WRITE_MODE))
			return featureWriteMode;
		if (name.equals(CityGMLOutputFactory.KEEP_INLINE_APPEARANCE))
			return keepInlineAppearance;
		if (name.equals(CityGMLOutputFactory.SPLIT_COPY))
			return splitCopy;
		if (name.equals(CityGMLOutputFactory.USE_VALIDATION))
			return useValidation;
		if (name.equals(CityGMLOutputFactory.EXCLUDE_FROM_SPLITTING))
			return excludes;

		throw new IllegalArgumentException("the property '" + name + "' is not supported.");
	}

	@SuppressWarnings("unchecked")
	public void setProperty(String name, Object value) {
		Objects.requireNonNull(name, "property name may not be null.");

		if (name.equals(CityGMLOutputFactory.FEATURE_WRITE_MODE)) {
			FeatureWriteMode mode = FeatureWriteMode.fromValue(value.toString());
			if (mode != null)
				featureWriteMode = mode;

			return;
		}

		if (name.equals(CityGMLOutputFactory.KEEP_INLINE_APPEARANCE)) {
			if (value instanceof Boolean)
				keepInlineAppearance = (Boolean)value;

			return;		
		}

		if (name.equals(CityGMLOutputFactory.SPLIT_COPY)) {
			if (value instanceof Boolean)
				splitCopy = (Boolean)value;

			return;		
		}

		if (name.equals(CityGMLOutputFactory.USE_VALIDATION)) {
			if (value instanceof Boolean)
				useValidation = (Boolean)value;

			return;		
		}

		if (name.equals(CityGMLOutputFactory.EXCLUDE_FROM_SPLITTING)) {
			if (value instanceof Class<?>) {
				if (isSubclassOfCityGML((Class<?>)value))
					excludes.add((Class<? extends CityGML>)value);
				else
					throw new IllegalArgumentException("exclude must be of type Class<? extends CityGML>.");

				return;
			}

			else if (value instanceof Collection<?>) {
				for (Object o : (Collection<?>)value) {
					if (isSubclassOfCityGML((Class<?>)o))
						excludes.add((Class<? extends CityGML>)o);
					else
						throw new IllegalArgumentException("exclude must be of type Class<? extends CityGML>.");
				}

				return;
			}

			else if (value instanceof Class<?>[]) {
				for (Object o : (Class<?>[])value) {
					if (isSubclassOfCityGML((Class<?>)o))
						excludes.add((Class<? extends CityGML>)o);
					else
						throw new IllegalArgumentException("exclude must be of type Class<? extends CityGML>.");
				}

				return;
			}
		}

		throw new IllegalArgumentException("the key-value pair '" + name + " - " + value.getClass().getName() + "' is not supported.");
	}

	private boolean isSubclassOfCityGML(Class<?> a) {
		if (a == null)
			return false;

		if (a == CityGML.class)
			return true;

		for (Class<?> tmp : a.getInterfaces())
			if (isSubclassOfCityGML(tmp))
				return true;

		return a.getSuperclass() != Object.class && isSubclassOfCityGML(a.getSuperclass());
	}

	private void createParentDirectories(Path path) throws IOException {
		Path parent = path.getParent();
		if (parent != null && !Files.exists(parent))
			Files.createDirectories(parent);
	}
	
}
