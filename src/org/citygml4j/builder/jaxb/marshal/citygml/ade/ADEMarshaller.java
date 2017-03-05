package org.citygml4j.builder.jaxb.marshal.citygml.ade;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.ade.ADEGenericElement;
import org.w3c.dom.Element;

public class ADEMarshaller {

	public JAXBElement<Object> marshalJAXBElement(ADEComponent ade) {
		Element element = marshalDOMElement(ade);
		if (element != null)
			return new JAXBElement<Object>(new QName(element.getNamespaceURI(), element.getLocalName()), Object.class, element);
		else
			return null;
	}
	
	public Element marshalDOMElement(ADEComponent ade) {
		switch (ade.getADEClass()) {
		case GENERIC_ELEMENT:
			ADEGenericElement adeGenericElement = (ADEGenericElement)ade;
			if (adeGenericElement.isSetContent())
				return adeGenericElement.getContent();
		}
		
		return null;
	}
	
}
