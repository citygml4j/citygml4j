package org.citygml4j.builder.jaxb.unmarshal.citygml.ade;

import org.citygml4j.builder.jaxb.unmarshal.JAXBUnmarshaller;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.xml.io.reader.MissingADESchemaException;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class ADEUnmarshaller {
	private final JAXBUnmarshaller jaxb;

	public ADEUnmarshaller(JAXBUnmarshaller jaxb) {
		this.jaxb = jaxb;
	}

	public ADEComponent unmarshal(Element element) throws MissingADESchemaException {
		if (jaxb.isParseSchema()) {
			try {
				jaxb.getSchemaHandler().parseSchema(element);
				jaxb.getSchemaHandler().parseSchema(element.getNamespaceURI(), null);
				jaxb.getSchemaHandler().resolveAndParseSchema(element.getNamespaceURI());
			} catch (SAXException e) {
				// 
			}
		}

		return new ADEComponent(element);
	}

}
