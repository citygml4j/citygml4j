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
package handling_ade.generic.catching_schema_parse_errors.util;

import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;

public class SchemaEntityResolver implements EntityResolver {

	public InputSource resolveEntity(String publicId, String systemId) {
		System.out.println("SCHEMA ENTITY RESOLVE ERROR: Failed to parse schema '" + publicId + "' when reading from '" + systemId +"'");
		
		InputSource inputSource = null;
		if (publicId.equals("http://www.citygml.org/ade/noise_de/2.0")) {
			inputSource = new InputSource("datasets/schemas/CityGML-NoiseADE-2_0_0.xsd");
			System.out.println("FIX: Reading from '" + inputSource.getSystemId() + "'\n");
		}
			
		return inputSource;
	}

}
