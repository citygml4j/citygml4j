package org.citygml4j.xml.io;

import java.io.File;
import java.io.OutputStream;
import java.io.Writer;

import javax.xml.bind.ValidationEventHandler;
import javax.xml.transform.stream.StreamResult;

import org.citygml4j.commons.gmlid.GMLIdManager;
import org.citygml4j.model.module.ModuleContext;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.xml.io.writer.CityGMLWriteException;
import org.citygml4j.xml.io.writer.CityGMLWriter;
import org.citygml4j.xml.io.writer.CityModelWriter;
import org.citygml4j.xml.schema.SchemaHandler;

public interface CityGMLOutputFactory {
	public static final String FEATURE_WRITE_MODE = "org.citygml4j.featureWriteMode";
	public static final String KEEP_INLINE_APPEARANCE = "org.citygml4j.keepInlineAppearance";
	public static final String SPLIT_COPY = "org.citygml4j.splitCopy";
	public static final String EXCLUDE_FROM_SPLITTING = "org.citygml4j.excludeFromSplitting";
	public static final String USE_VALIDATION = "org.citygml4j.useValidation";

	public ModuleContext getModuleContext();
	public SchemaHandler getSchemaHandler();
	public GMLIdManager getGMLIdManager();
	public ValidationEventHandler getValidationEventHandler();
	public Object getProperty(String name);
	public void setModuleContext(ModuleContext moduleContext);
	public void setCityGMLVersion(CityGMLVersion version);
	public void setSchemaHandler(SchemaHandler schemaHandler);
	public void setGMLIdManager(GMLIdManager gmlIdManager);
	public void setValidationEventHandler(ValidationEventHandler validationEventHandler);
	public void setProperty(String name, Object value);
	
	public CityGMLWriter createCityGMLWriter(File file) throws CityGMLWriteException;
	public CityGMLWriter createCityGMLWriter(File file, String encoding) throws CityGMLWriteException;
	public CityGMLWriter createCityGMLWriter(OutputStream outputStream) throws CityGMLWriteException;
	public CityGMLWriter createCityGMLWriter(OutputStream outputStream, String encoding) throws CityGMLWriteException;
	public CityGMLWriter createCityGMLWriter(Writer writer) throws CityGMLWriteException;
	public CityGMLWriter createCityGMLWriter(StreamResult streamResult, String encoding) throws CityGMLWriteException;
	public CityGMLWriter createCityGMLWriter(File file, ModuleContext moduleContext) throws CityGMLWriteException;
	public CityGMLWriter createCityGMLWriter(File file, String encoding, ModuleContext moduleContext) throws CityGMLWriteException;
	public CityGMLWriter createCityGMLWriter(OutputStream outputStream, ModuleContext moduleContext) throws CityGMLWriteException;
	public CityGMLWriter createCityGMLWriter(OutputStream outputStream, String encoding, ModuleContext moduleContext) throws CityGMLWriteException;
	public CityGMLWriter createCityGMLWriter(Writer writer, ModuleContext moduleContext) throws CityGMLWriteException;
	public CityGMLWriter createCityGMLWriter(StreamResult streamResult, String encoding, ModuleContext moduleContext) throws CityGMLWriteException;
	
	public CityModelWriter createCityModelWriter(File file) throws CityGMLWriteException;
	public CityModelWriter createCityModelWriter(File file, String encoding) throws CityGMLWriteException;
	public CityModelWriter createCityModelWriter(OutputStream outputStream) throws CityGMLWriteException;
	public CityModelWriter createCityModelWriter(OutputStream outputStream, String encoding) throws CityGMLWriteException;
	public CityModelWriter createCityModelWriter(Writer writer) throws CityGMLWriteException;
	public CityModelWriter createCityModelWriter(StreamResult streamResult, String encoding) throws CityGMLWriteException;
	public CityModelWriter createCityModelWriter(File file, ModuleContext moduleContext) throws CityGMLWriteException;
	public CityModelWriter createCityModelWriter(File file, String encoding, ModuleContext moduleContext) throws CityGMLWriteException;
	public CityModelWriter createCityModelWriter(OutputStream outputStream, ModuleContext moduleContext) throws CityGMLWriteException;
	public CityModelWriter createCityModelWriter(OutputStream outputStream, String encoding, ModuleContext moduleContext) throws CityGMLWriteException;
	public CityModelWriter createCityModelWriter(Writer writer, ModuleContext moduleContext) throws CityGMLWriteException;
	public CityModelWriter createCityModelWriter(StreamResult streamResult, String encoding, ModuleContext moduleContext) throws CityGMLWriteException;

}
