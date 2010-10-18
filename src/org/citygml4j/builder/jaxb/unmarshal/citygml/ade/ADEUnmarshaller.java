/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universitaet Berlin, Germany
 * http://www.igg.tu-berlin.de/
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 */
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
