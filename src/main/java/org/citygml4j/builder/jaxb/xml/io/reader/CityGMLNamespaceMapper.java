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
package org.citygml4j.builder.jaxb.xml.io.reader;

import org.citygml4j.model.module.citygml.AppearanceModule;
import org.citygml4j.model.module.citygml.CityGMLModule;
import org.citygml4j.model.module.citygml.CityGMLModuleType;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.model.module.citygml.CoreModule;
import org.citygml4j.model.module.citygml.GenericsModule;
import org.citygml4j.model.module.citygml.TexturedSurfaceModule;

import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import javax.xml.stream.Location;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.Stack;

public class CityGMLNamespaceMapper implements XMLStreamReader {
	private final XMLStreamReader reader;

	private Stack<ParentFeatureElement> parents;
	private ParentFeatureElement parent;
	private QName currentName;
	
	private boolean isCityGML;
	private int depth = 0;

	public CityGMLNamespaceMapper(XMLStreamReader reader) {
		this.reader = reader;
		parents = new Stack<ParentFeatureElement>();
	}

	public void close() throws XMLStreamException {
		reader.close();
		parents = null;
	}

	public int getAttributeCount() {
		return reader.getAttributeCount();
	}

	public String getAttributeLocalName(int arg0) {
		return reader.getAttributeLocalName(arg0);
	}

	public QName getAttributeName(int arg0) {
		return reader.getAttributeName(arg0);
	}

	public String getAttributeNamespace(int arg0) {
		String namespaceURI = reader.getAttributeNamespace(arg0);
		return (namespaceURI != null && namespaceURI.startsWith("http://www.citygml.org/citygml")) ? currentName.getNamespaceURI() : reader.getAttributeNamespace(arg0);
	}

	public String getAttributePrefix(int arg0) {
		return reader.getAttributePrefix(arg0);
	}

	public String getAttributeType(int arg0) {
		return reader.getAttributeType(arg0);
	}

	public String getAttributeValue(int arg0) {
		return reader.getAttributeValue(arg0);
	}

	public String getAttributeValue(String arg0, String arg1) {
		return reader.getAttributeValue(arg0, arg1);
	}

	public String getCharacterEncodingScheme() {
		return reader.getCharacterEncodingScheme();
	}

	public String getElementText() throws XMLStreamException {
		return reader.getElementText();
	}

	public String getEncoding() {
		return reader.getEncoding();
	}

	public int getEventType() {
		return reader.getEventType();
	}

	public String getLocalName() {
		return isCityGML ? currentName.getLocalPart() : reader.getLocalName();
	}

	public Location getLocation() {
		return reader.getLocation();
	}

	public QName getName() {
		return isCityGML ? currentName : reader.getName();
	}

	public NamespaceContext getNamespaceContext() {
		return reader.getNamespaceContext();
	}

	public int getNamespaceCount() {
		return reader.getNamespaceCount();
	}

	public String getNamespacePrefix(int arg0) {
		return reader.getNamespacePrefix(arg0);
	}

	public String getNamespaceURI() {
		return isCityGML ? currentName.getNamespaceURI() : reader.getNamespaceURI();
	}

	public String getNamespaceURI(String arg0) {
		return reader.getNamespaceURI(arg0);
	}

	public String getNamespaceURI(int arg0) {
		return reader.getNamespaceURI(arg0);
	}

	public String getPIData() {
		return reader.getPIData();
	}

	public String getPITarget() {
		return reader.getPITarget();
	}

	public String getPrefix() {
		return reader.getPrefix();
	}

	public Object getProperty(String arg0) throws IllegalArgumentException {
		return reader.getProperty(arg0);
	}

	public String getText() {
		return reader.getText();
	}

	public char[] getTextCharacters() {
		return reader.getTextCharacters();
	}

	public int getTextCharacters(int arg0, char[] arg1, int arg2, int arg3) throws XMLStreamException {
		return reader.getTextCharacters(arg0, arg1, arg2, arg3);
	}

	public int getTextLength() {
		return reader.getTextLength();
	}

	public int getTextStart() {
		return reader.getTextStart();
	}

	public String getVersion() {
		return reader.getVersion();
	}

	public boolean hasName() {
		return reader.hasName();
	}

	public boolean hasNext() throws XMLStreamException {
		return reader.hasNext();
	}

	public boolean hasText() {
		return reader.hasText();
	}

	public boolean isAttributeSpecified(int arg0) {
		return reader.isAttributeSpecified(arg0);
	}

	public boolean isCharacters() {
		return reader.isCharacters();
	}

	public boolean isEndElement() {
		return reader.isEndElement();
	}

	public boolean isStandalone() {
		return reader.isStandalone();
	}

	public boolean isStartElement() {
		return reader.isStartElement();
	}

	public boolean isWhiteSpace() {
		return reader.isWhiteSpace();
	}

	public int next() throws XMLStreamException {
		int event = reader.next();
		
		if (event == XMLStreamConstants.START_ELEMENT) {
			String localPart = reader.getLocalName();
			String namespaceURI = reader.getNamespaceURI();
			depth++;

			if (namespaceURI.startsWith("http://www.citygml.org/citygml")) {
				isCityGML = true;

				if (localPart.equals("creationDate") ||
						localPart.equals("terminationDate") ||
						localPart.equals("generalizesTo")) {
					namespaceURI = CoreModule.v1_0_0.getNamespaceURI();
				}

				else if (localPart.equals("externalReference")) {
					parents.push(parent);
					parent = new ParentFeatureElement(localPart, CoreModule.v1_0_0.getNamespaceURI(), depth);
					namespaceURI = CoreModule.v1_0_0.getNamespaceURI();
				} 

				else if (localPart.equals("stringAttribute") ||
						localPart.equals("intAttribute") ||
						localPart.equals("doubleAttribute") ||
						localPart.equals("dateAttribute") ||
						localPart.equals("uriAttribute")) {
					parents.push(parent);
					parent = new ParentFeatureElement(localPart, GenericsModule.v1_0_0.getNamespaceURI(), depth);
					namespaceURI = GenericsModule.v1_0_0.getNamespaceURI();
				}

				else if (localPart.equals("appearanceMember")) {
					if (parent != null && !parent.localPart.equals("CityModel"))
						localPart = "appearance";

					namespaceURI = AppearanceModule.v1_0_0.getNamespaceURI();					
				}
				
				else if (localPart.equals("TexturedSurface") ||
						localPart.equals("SimpleTexture") ||
						localPart.equals("Material")) {
					namespaceURI = TexturedSurfaceModule.v1_0_0.getNamespaceURI();
				}

				else {
					for (CityGMLModule module : CityGMLVersion.v1_0_0.getCityGMLModules()) {
						if (module.getType() == CityGMLModuleType.BRIDGE || module.getType() == CityGMLModuleType.TUNNEL)
							continue;

						if (module.hasFeature(localPart)) {
							parents.push(parent);
							parent = new ParentFeatureElement(localPart, module.getNamespaceURI(), depth);
							break;
						}		
					}

					namespaceURI = parent.namespaceURI;
				}

			} else
				isCityGML = false;
			
			currentName = new QName(namespaceURI, localPart);

		} else if (event == XMLStreamConstants.END_ELEMENT) {
			if (parent != null && parent.depth == depth)
				parent = parents.pop();

			depth--;
		}

		return event;
	}

	public int nextTag() throws XMLStreamException {
		return reader.nextTag();
	}

	public void require(int arg0, String arg1, String arg2) throws XMLStreamException {
		reader.require(arg0, arg1, arg2);
	}

	public boolean standaloneSet() {
		return reader.standaloneSet();
	}

	private final class ParentFeatureElement {
		private final String localPart;
		private final String namespaceURI;
		private final int depth;

		public ParentFeatureElement(String localPart, String namespaceURI, int depth) {
			this.localPart = localPart;
			this.namespaceURI = namespaceURI;
			this.depth = depth;
		}
	}

}
