/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2022 Claus Nagel <claus.nagel@gmail.com>
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
package handling_ade.generic.catching_schema_parse_errors.util;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class SchemaParseErrorHandler implements ErrorHandler {

	public void error(SAXParseException exception) throws SAXException {
		System.out.println("SCHEMA PARSE ERROR: " + exception.getMessage() + "\n");
	}

	public void fatalError(SAXParseException exception) throws SAXException {
		System.out.println("SCHEMA PARSE FATAL ERROR: " + exception.getMessage() + "\n");
	}

	public void warning(SAXParseException exception) throws SAXException {
		System.out.println("SCHEMA PARSE WARNING: " + exception.getMessage() + "\n");
	}

}
