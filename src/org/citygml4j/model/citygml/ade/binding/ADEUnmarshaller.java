package org.citygml4j.model.citygml.ade.binding;

import javax.xml.bind.JAXBElement;

import org.citygml4j.builder.jaxb.unmarshal.citygml.ade.ADEUnmarshallerHelper;
import org.citygml4j.xml.io.reader.MissingADESchemaException;

public interface ADEUnmarshaller {
	public ADEModelObject unmarshal(JAXBElement<?> src, ADEUnmarshallerHelper helper) throws MissingADESchemaException;
	public ADEModelObject unmarshal(Object src, ADEUnmarshallerHelper helper) throws MissingADESchemaException;
}
