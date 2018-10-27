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
package org.citygml4j.util.internal.xml;

import javax.xml.transform.Templates;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;

public class TransformerChainFactory {
	private final SAXTransformerFactory factory;
	private Templates[] templates;

	public TransformerChainFactory(Templates[] templates) throws TransformerConfigurationException {
		if (templates == null || templates.length == 0)
			throw new IllegalArgumentException("no transformation templates provided.");
				
		this.templates = templates;		
		this.factory = (SAXTransformerFactory)TransformerFactory.newInstance();
	}
	
	public TransformerChain buildChain() throws TransformerConfigurationException {
		TransformerHandler[] handlers = new TransformerHandler[templates.length];
		
		for (int i = templates.length - 1; i >= 0; i--) {
			handlers[i] = factory.newTransformerHandler(templates[i]);
			if (i < templates.length - 1)
				handlers[i].setResult(new SAXResult(handlers[i + 1]));
		}
		
		return new TransformerChain(handlers[0], handlers[handlers.length - 1]);
	}
	
	public void updateTemplates(Templates[] templates) {
		if (templates == null || templates.length == 0)
			throw new IllegalArgumentException("no transformation templates provided.");

		this.templates = templates;
	}
	
	public SAXTransformerFactory getTransformerFactory() {
		return factory;
	}
	
	public Templates[] getTemplates() {
		return templates;
	}
	
}
