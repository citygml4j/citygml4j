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
package org.citygml4j.builder.jaxb.marshal.citygml.ade;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.marshal.JAXBMarshaller;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.ade.binding.ADEContext;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;
import org.citygml4j.model.citygml.ade.generic.ADEGenericElement;
import org.citygml4j.model.module.ade.ADEModule;
import org.w3c.dom.Element;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import java.util.HashMap;
import java.util.Map;

public class ADEMarshaller {
	private Map<String, ADEContext> adeContexts;

	public ADEMarshaller(JAXBMarshaller jaxb) {
		CityGMLContext context = CityGMLContext.getInstance();
		if (context.hasADEContexts()) {
			this.adeContexts = new HashMap<>();
			ADEMarshallerHelper helper = new ADEMarshallerHelper(jaxb);

			for (ADEContext adeContext : context.getADEContexts()) {
				for (ADEModule module : adeContext.getADEModules()) {
					if (module.getCityGMLVersion() == jaxb.getModuleContext().getCityGMLVersion()) {
						adeContext.getADEMarshaller().setADEMarshallerHelper(helper);
						for (String packageName : adeContext.getModelPackageNames())
							this.adeContexts.put(packageName, adeContext);	
					}
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	public JAXBElement<Object> marshalJAXBElement(ADEComponent ade) {
		switch (ade.getADEClass()) {
		case MODEL_OBJECT:
			JAXBElement<?> elem = marshalJAXBElement((ADEModelObject)ade);
			if (elem != null && elem.getValue() != null)
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
		return ade.isSetContent() ? ade.getContent() : null;
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
