/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2019 Claus Nagel <claus.nagel@gmail.com>
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
package org.citygml4j.builder.jaxb.unmarshal.citygml.ade;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.unmarshal.JAXBUnmarshaller;
import org.citygml4j.model.citygml.ade.binding.ADEContext;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;
import org.citygml4j.model.citygml.ade.generic.ADEGenericElement;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.module.Modules;
import org.citygml4j.model.module.ade.ADEModule;
import org.citygml4j.xml.io.reader.MissingADESchemaException;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBElement;
import java.util.HashMap;
import java.util.Map;

public class ADEUnmarshaller {
	private final JAXBUnmarshaller jaxb;
	private Map<String, org.citygml4j.model.citygml.ade.binding.ADEUnmarshaller> unmarshallers;

	public ADEUnmarshaller(JAXBUnmarshaller jaxb) {
		this.jaxb = jaxb;

		CityGMLContext context = CityGMLContext.getInstance();
		if (context.hasADEContexts()) {
			this.unmarshallers = new HashMap<>();
			ADEUnmarshallerHelper helper = new ADEUnmarshallerHelper(jaxb);

			for (ADEContext adeContext : context.getADEContexts()) {
				org.citygml4j.model.citygml.ade.binding.ADEUnmarshaller unmarshaller = adeContext.createADEUnmarshaller();
				if (unmarshaller != null) {
					unmarshaller.setADEUnmarshallerHelper(helper);
					for (ADEModule module : adeContext.getADEModules())
						this.unmarshallers.put(module.getNamespaceURI(), unmarshaller);
				}
			}
		}
	}

	public ADEGenericElement unmarshal(Element element) throws MissingADESchemaException {
		if (jaxb.isParseSchema()) {
			try {
				jaxb.getSchemaHandler().parseSchema(element);
				jaxb.getSchemaHandler().parseSchema(element.getNamespaceURI(), null);
			} catch (SAXException e) {
				// 
			}
		}

		try {
			jaxb.getSchemaHandler().resolveAndParseSchema(element.getNamespaceURI());
		} catch (SAXException e) {
			// 
		} catch (MissingADESchemaException e) {
			if (jaxb.isThrowMissingADESchema())
				throw e;
		}

		return new ADEGenericElement(element);
	}

	public ADEModelObject unmarshal(JAXBElement<?> src) throws MissingADESchemaException {
		if (unmarshallers != null) {
			org.citygml4j.model.citygml.ade.binding.ADEUnmarshaller unmarshaller = unmarshallers.get(src.getName().getNamespaceURI());
			if (unmarshaller != null) {
				ADEModelObject ade = unmarshaller.unmarshal(src);

				// set ADE module information
				if (ade instanceof AbstractFeature && !((AbstractFeature) ade).isSetModule())
					((AbstractFeature) ade).setModule(Modules.getModule(src.getName().getNamespaceURI()));

				return ade;
			}
		}

		return null;
	}

	public ADEModelObject unmarshal(Object src) throws MissingADESchemaException {
		if (unmarshallers != null) {
			for (org.citygml4j.model.citygml.ade.binding.ADEUnmarshaller unmarshaller : unmarshallers.values()) {
				ADEModelObject ade = unmarshaller.unmarshal(src);
				if (ade != null)
					return ade;
			}
		}

		return null;
	}

}
