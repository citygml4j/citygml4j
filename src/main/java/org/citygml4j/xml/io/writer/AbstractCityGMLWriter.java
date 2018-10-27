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
package org.citygml4j.xml.io.writer;

import org.citygml4j.model.citygml.ade.binding.ADEContext;
import org.citygml4j.model.module.Module;
import org.citygml4j.model.module.ModuleContext;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.xml.CityGMLNamespaceContext;

import java.util.List;

public interface AbstractCityGMLWriter extends AutoCloseable {
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
	public void setIndentString(String indent);
	public void setWriteEncoding(boolean writeEncoding);
	public void setWriteXMLDecl(boolean writeXMLDecl);
	public void setHeaderComment(String... comment);
	public void unsetHeaderComment();
	public void setPrefix(String prefix, String uri);
	public void setPrefix(Module module);
	public void setPrefixes(CityGMLVersion version);
	public void setPrefixes(ModuleContext moduleContext);
	public void setPrefixes(List<ADEContext> adeContexts);
	public void setDefaultNamespace(String uri);
	public void setDefaultNamespace(Module module);
	public void setSchemaLocation(String namespaceURI, String schemaLocation);
	public void setSchemaLocation(Module module);
	public void setSchemaLocations(CityGMLVersion version);
	public void setSchemaLocations(ModuleContext moduleContext);
	public void setSchemaLocations(List<ADEContext> adeContexts);
	public void setModuleContext(ModuleContext moduleContext);
}
