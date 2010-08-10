package org.citygml4j.builder.jaxb.xml.io.reader;

import java.net.URI;
import java.util.NoSuchElementException;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.xml.io.reader.CityGMLReadException;
import org.citygml4j.xml.io.reader.MissingADESchemaException;
import org.citygml4j.xml.io.reader.ParentInfo;
import org.xml.sax.SAXException;

public class JAXBSimpleReader extends AbstractJAXBReader {
	private CityGML tmp;

	public JAXBSimpleReader(XMLStreamReader reader, JAXBInputFactory factory, URI baseURI) throws CityGMLReadException {
		super(reader, factory, baseURI);
		jaxbUnmarshaller.setParseSchema(parseSchema);
	}

	public void close() throws CityGMLReadException {
		super.close();
		tmp = null;
	}

	public boolean hasNextFeature() throws CityGMLReadException {
		if (tmp == null) {
			try {
				tmp = nextFeature();
			} catch (NoSuchElementException e) {
				//
			}
		}

		return tmp != null;
	}

	public CityGML nextFeature() throws CityGMLReadException {
		CityGML next = tmp;

		if (next == null) {
			try {
				while (reader.hasNext()) {
					if (reader.getEventType() == XMLStreamConstants.START_ELEMENT) {

						// keep track of schema documents
						if (parseSchema) {
							for (int i = 0; i < reader.getAttributeCount(); i++) {
								if (reader.getAttributeLocalName(i).equals("schemaLocation"))
									parseSchema(reader.getAttributeValue(i));
								else if (reader.getAttributeLocalName(i).equals("noNamespaceSchemaLocation"))
									schemaHandler.parseSchema("", reader.getAttributeValue(i));
							}
						}

						if (util.isCityGMLElement(reader.getName()) &&
								util.isCityGMLFeature(reader.getLocalName(), reader.getNamespaceURI())) {
							Unmarshaller unmarshaller = factory.builder.getJAXBContext().createUnmarshaller();

							// validate input
							if (useValidation) {
								unmarshaller.setSchema(validationSchemaHandler.getSchema());
								if (validationEventHandler != null)
									unmarshaller.setEventHandler(validationEventHandler);
							}							

							// unmarshal input
							Object result = unmarshaller.unmarshal(reader);

							// release memory
							unmarshaller = null;

							if (result instanceof JAXBElement<?>) {
								Object citygml = jaxbUnmarshaller.unmarshal((JAXBElement<?>)result);
								if (citygml instanceof CityGML && citygml instanceof AbstractFeature) {
									next = (CityGML)citygml;
									break;
								}
							}
						}
					}

					reader.next();
				}
			} catch (XMLStreamException e) {
				throw new CityGMLReadException("Caused by: ", e);
			} catch (JAXBException e) {
				throw new CityGMLReadException("Caused by: ", e);
			} catch (SAXException e) {
				throw new CityGMLReadException("Caused by: ", e);
			} catch (MissingADESchemaException e) {
				throw new CityGMLReadException("Caused by: ", e);
			}
		}

		if (next == null)
			throw new NoSuchElementException();
		else {
			tmp = null;
			return next;
		}	
	}

	public boolean isSetParentInfo() {
		return false;
	}

	public ParentInfo getParentInfo() {
		return null;
	}

}
