/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2020 Claus Nagel <claus.nagel@gmail.com>
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

package validating_citygml;

import helpers.Logger;
import helpers.Util;
import org.citygml4j.CityGMLContext;
import org.citygml4j.xml.schema.CityGMLSchemaHandler;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.nio.file.Path;

public class XMLValidation {

    public static void main(String[] args) throws Exception {
        Logger log = Logger.start(XMLValidation.class);

        CityGMLContext context = CityGMLContext.newInstance();

        log.print("Getting default CityGML schemas from schema handler");
        CityGMLSchemaHandler schemaHandler = context.getDefaultSchemaHandler();
        Source[] schemas = schemaHandler.getSchemas();

        log.print("Creating XML schema factory and validator");
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = schemaFactory.newSchema(schemas);

        Validator validator = schema.newValidator();

        validator.setErrorHandler(new ErrorHandler() {
            @Override
            public void error(SAXParseException exception) {
                String message = "[" + exception.getLineNumber() + ", " +
                        exception.getColumnNumber() + "] " +
                        exception.getMessage();

                log.print(message);
            }

            @Override
            public void warning(SAXParseException exception) {
                error(exception);
            }

            @Override
            public void fatalError(SAXParseException exception) {
                error(exception);
            }
        });

        Path file = Util.SAMPLE_DATA_DIR.resolve("invalid_building_v3.gml");
        log.print("Validating the file " + file);

        validator.validate(new StreamSource(file.toFile()));

        log.finish();
    }
}
