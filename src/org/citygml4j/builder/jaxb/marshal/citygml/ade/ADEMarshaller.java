package org.citygml4j.builder.jaxb.marshal.citygml.ade;

import java.util.HashMap;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.citygml4j.builder.jaxb.marshal.JAXBMarshaller;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.ade.binding.ADEContext;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;
import org.citygml4j.model.citygml.ade.generic.ADEGenericElement;
import org.w3c.dom.Element;

public class ADEMarshaller {
	private JAXBMarshaller jaxb;
	private HashMap<String, ADEContext> adeContexts;
	private ADEMarshallerHelper helper;

	public ADEMarshaller(JAXBMarshaller jaxb, HashMap<String, ADEContext> adeContexts) {
		if (adeContexts != null && !adeContexts.isEmpty()) {
			this.jaxb = jaxb;
			this.adeContexts = adeContexts;
			helper = new ADEMarshallerHelper(jaxb);
		}
	}

	@SuppressWarnings("unchecked")
	public JAXBElement<Object> marshalJAXBElement(ADEComponent ade) {
		switch (ade.getADEClass()) {
		case MODEL_OBJECT:
			JAXBElement<?> elem = marshalJAXBElement((ADEModelObject)ade);
			if (elem != null && elem.getValue() instanceof Object)
				return (JAXBElement<Object>)elem;
			break;
		case GENERIC_ELEMENT:	
			Element element = marshalDOMElement((ADEGenericElement)ade);
			if (element != null)
				return new JAXBElement<Object>(new QName(element.getNamespaceURI(), element.getLocalName()), Object.class, element);
			break;
		}

		return null;
	}

	public Element marshalDOMElement(ADEGenericElement ade) {
		ADEGenericElement adeGenericElement = (ADEGenericElement)ade;
		if (adeGenericElement.isSetContent())
			return adeGenericElement.getContent();

		return null;
	}

	public JAXBElement<?> marshalJAXBElement(ADEModelObject ade) {
		if (adeContexts != null) {
			ADEContext adeContext = adeContexts.get(ade.getNamespaceURI());
			if (adeContext != null && adeContext.getADEModule().getCityGMLVersion() == jaxb.getModuleContext().getCityGMLVersion())
				return adeContext.getADEMarshaller().marshalJAXBElement(ade, helper);
		}

		return null;
	}

	public Object marshal(ADEModelObject ade) {
		if (adeContexts != null) {
			ADEContext adeContext = adeContexts.get(ade.getNamespaceURI());
			if (adeContext != null && adeContext.getADEModule().getCityGMLVersion() == jaxb.getModuleContext().getCityGMLVersion())
				return adeContext.getADEMarshaller().marshal(ade, helper);
		}

		return null;
	}

}
