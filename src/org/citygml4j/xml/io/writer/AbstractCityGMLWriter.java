package org.citygml4j.xml.io.writer;

import org.citygml4j.model.module.Module;
import org.citygml4j.model.module.ModuleContext;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.xml.CityGMLNamespaceContext;

public interface AbstractCityGMLWriter {
	public void close() throws CityGMLWriteException;
	public void flush() throws CityGMLWriteException;
	public void reset();
	
	public boolean getEscapeCharacters();
	public CityGMLNamespaceContext getNamespaceContext();
	public String getPrefix(String uri);
	public String getNamespaceURI(String prefix);
	public String getIndentString();
	public boolean isWriteEncoding();
	public boolean isWriteXMLDecl();
	public String[] getHeaderComment();
	public String getSchemaLocation(String namespaceURI);
	public ModuleContext getModuleContext();
	
	public void setEscapeCharacters(boolean escapeCharacters);
	public void setNamespaceContext(CityGMLNamespaceContext context);
	public void setIndentString(String indentString);
	public void setWriteEncoding(boolean writeEncoding);
	public void setWriteXMLDecl(boolean writeXMLDecl);
	public void setHeaderComment(String... comment);
	public void unsetHeaderComment();
	public void setPrefix(String prefix, String uri);
	public void setPrefix(Module module);
	public void setPrefixes(CityGMLVersion version);
	public void setPrefixes(ModuleContext moduleContext);
	public void setDefaultNamespace(String uri);
	public void setDefaultNamespace(Module module);
	public void setSchemaLocation(String namespaceURI, String schemaLocation);
	public void setSchemaLocation(Module module);
	public void setSchemaLocations(CityGMLVersion version);
	public void setSchemaLocations(ModuleContext moduleContext);
	public void setModuleContext(ModuleContext moduleContext);
}
