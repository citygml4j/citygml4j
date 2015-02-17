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
package org.citygml4j.builder.jaxb.marshal;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.citygml4j.builder.jaxb.JAXBBuilder;
import org.citygml4j.builder.jaxb.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.builder.jaxb.marshal.gml.GMLMarshaller;
import org.citygml4j.builder.jaxb.marshal.xal.XALMarshaller;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.module.ModuleContext;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class JAXBMarshaller {
	private final CityGMLMarshaller citygml;
	private final GMLMarshaller gml;
	private final XALMarshaller xal;
	private final JAXBBuilder jaxbBuilder;

	private ModuleContext moduleContext;	
	private Document document;

	public JAXBMarshaller(JAXBBuilder jaxbBuilder, ModuleContext moduleContext) {
		this.jaxbBuilder = jaxbBuilder;
		this.moduleContext = moduleContext;

		citygml = new CityGMLMarshaller(this);
		gml = new GMLMarshaller(this);
		xal = new XALMarshaller();
	}

	public JAXBElement<?> marshalJAXBElement(Object src) {
		JAXBElement<?> dest = citygml.marshalJAXBElement(src);		
		if (dest == null)
			dest = gml.marshalJAXBElement(src);
		if (dest == null)
			dest = xal.marshalJAXBElement(src);

		return dest;
	}

	public Element marshalDOMElement(Object src) {
		Element dest = null;

		try {
			if (document == null) {			
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder docBuilder = factory.newDocumentBuilder();
				document = docBuilder.newDocument();
			}
			
			dest = marshalDOMElement(src, document);
		} catch (ParserConfigurationException e) {
			// 
		}

		return dest;		
	}
	
	public Element marshalDOMElement(Object src, Document document) {
		Element dest = null;

		try {
			Marshaller marshaller = jaxbBuilder.getJAXBContext().createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);

			Element foo = document.createElement("foo");
			JAXBElement<?> jaxbElement = (src instanceof JAXBElement<?>) ? (JAXBElement<?>)src : marshalJAXBElement(src);
			if (jaxbElement != null)
				marshaller.marshal(jaxbElement, foo);

			Node child = foo.getFirstChild();
			if (child instanceof Element)
				dest = (Element)child;			
		} catch (JAXBException e) {
			//
		}

		return dest;
	}
	
	public Element marshalDOMElement(JAXBElement<?> src, JAXBContext ctx) {
		Element dest = null;

		try {
			if (document == null) {			
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder docBuilder = factory.newDocumentBuilder();
				document = docBuilder.newDocument();
			}
			
			Marshaller marshaller = ctx.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);

			Element foo = document.createElement("foo");
			marshaller.marshal(src, foo);

			Node child = foo.getFirstChild();
			if (child instanceof Element)
				dest = (Element)child;			
		} catch (JAXBException e) {
			//
		} catch (ParserConfigurationException e) {
			// 
		}

		return dest;
	}
	
	public Object marshal(ModelObject src) {
		Object dest = citygml.marshal(src);		
		if (dest == null)
			dest = gml.marshal(src);
		if (dest == null)
			dest = xal.marshal(src);

		return dest;
	}

	public ModuleContext getModuleContext() {
		return moduleContext;
	}

	public void setModuleContext(ModuleContext moduleContext) {
		if (moduleContext == null)
			throw new IllegalArgumentException("module context URI may not be null.");

		this.moduleContext = moduleContext;
	}

	public CityGMLMarshaller getCityGMLMarshaller() {
		return citygml;
	}

	public GMLMarshaller getGMLMarshaller() {
		return gml;
	}

	public XALMarshaller getXALMarshaller() {
		return xal;
	}

}
