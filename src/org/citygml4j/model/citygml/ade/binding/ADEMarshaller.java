package org.citygml4j.model.citygml.ade.binding;

import javax.xml.bind.JAXBElement;

import org.citygml4j.builder.jaxb.marshal.citygml.ade.ADEMarshallerHelper;

public interface ADEMarshaller {
	public JAXBElement<?> marshalJAXBElement(ADEModelObject src, ADEMarshallerHelper helper);
	public Object marshal(ADEModelObject src, ADEMarshallerHelper helper);
}
