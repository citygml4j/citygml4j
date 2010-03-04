package org.citygml4j.builder.jaxb.unmarshal;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.citygml4j.builder.jaxb.JAXBBuilder;
import org.citygml4j.builder.jaxb.unmarshal.citygml.CityGMLUnmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.ade.ADEUnmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.gml.GMLUnmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.xal.XALUnmarshaller;
import org.citygml4j.xml.schema.SchemaHandler;
import org.w3c.dom.Element;

public class JAXBUnmarshaller {
	private final CityGMLUnmarshaller citygml;
	private final GMLUnmarshaller gml;
	private final XALUnmarshaller xal;
	private final ADEUnmarshaller ade;

	private final JAXBBuilder jaxbBuilder;
	private final SchemaHandler schemaHandler;
	private boolean parseSchema = true;
	private boolean freeJAXBElements = true;

	public JAXBUnmarshaller(JAXBBuilder jaxbBuilder, SchemaHandler schemaHandler) {
		this.jaxbBuilder = jaxbBuilder;
		this.schemaHandler = schemaHandler;

		citygml = new CityGMLUnmarshaller(this);
		gml = new GMLUnmarshaller(this);
		xal = new XALUnmarshaller();
		ade = new ADEUnmarshaller(this);
	}

	public Object unmarshal(JAXBElement<?> src) {
		Object dest = citygml.unmarshal(src);
		if (dest == null)
			dest = gml.unmarshal(src);
		if (dest == null)
			dest = xal.unmarshal(src);

		// release memory
		if (freeJAXBElements)
			src.setValue(null);

		return dest;
	}

	public Object unmarshal(Element element) {
		Object dest = null;

		try {
			Unmarshaller um = jaxbBuilder.getJAXBContext().createUnmarshaller();			
			dest = um.unmarshal(element);	
			if (dest instanceof JAXBElement<?>)
				dest = unmarshal((JAXBElement<?>)dest);
		} catch (JAXBException e) {
			//
		}

		return dest;
	}

	public Object unmarshal(Object src) {
		if (src instanceof JAXBElement<?>)
			return unmarshal((JAXBElement<?>)src);

		if (src instanceof Element)
			return unmarshal((Element)src);

		Object dest = citygml.unmarshal(src);
		if (dest == null)
			dest = gml.unmarshal(src);
		if (dest == null)
			dest = xal.unmarshal(src);

		return dest;
	}

	public CityGMLUnmarshaller getCityGMLUnmarshaller() {
		return citygml;
	}

	public GMLUnmarshaller getGMLUnmarshaller() {
		return gml;
	}

	public XALUnmarshaller getXALUnmarshaller() {
		return xal;
	}

	public ADEUnmarshaller getADEUnmarshaller() {
		return ade;
	}

	public SchemaHandler getSchemaHandler() {
		return schemaHandler;
	}

	public boolean isParseSchema() {
		return parseSchema;
	}

	public void setParseSchema(boolean parseSchema) {
		this.parseSchema = parseSchema;
	}

	public boolean isFreeJAXBElements() {
		return freeJAXBElements;
	}

	public void setFreeJAXBElements(boolean freeJAXBElements) {
		this.freeJAXBElements = freeJAXBElements;
	}	

}
