/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright (C) 2013 - 2015,
 * Claus Nagel <claus.nagel@gmail.com>
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
