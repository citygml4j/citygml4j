package org.citygml4j.builder.jaxb.marshal.citygml.ade;

import java.util.HashMap;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.citygml4j.builder.jaxb.marshal.JAXBMarshaller;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.ade.binding.ADEContext;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;
import org.citygml4j.model.citygml.ade.generic.ADEGenericElement;
import org.w3c.dom.Element;

public class ADEMarshaller {
	private HashMap<String, ADEContext> adeContexts;

	public ADEMarshaller(JAXBMarshaller jaxb, List<ADEContext> adeContexts) {
		if (adeContexts != null && !adeContexts.isEmpty()) {
			this.adeContexts = new HashMap<>();
			
			for (ADEContext adeContext : adeContexts) {
				if (adeContext != null && adeContext.getADEModule().getCityGMLVersion() == jaxb.getModuleContext().getCityGMLVersion()) {
					adeContext.getADEMarshaller().setADEMarshallerHelper(new ADEMarshallerHelper(jaxb));
					for (String packageName : adeContext.getModelPackageNames())
						this.adeContexts.put(packageName, adeContext);					
				}
			}
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
			ADEContext adeContext = adeContexts.get(ade.getClass().getPackage().getName());
			if (adeContext != null)
				return adeContext.getADEMarshaller().marshalJAXBElement(ade);
		}

		return null;
	}

	public Object marshal(ADEModelObject ade) {
		if (adeContexts != null) {
			ADEContext adeContext = adeContexts.get(ade.getClass().getPackage().getName());
			if (adeContext != null)
				return adeContext.getADEMarshaller().marshal(ade);
		}

		return null;
	}

}
