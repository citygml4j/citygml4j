/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package validating_citygml;

import helpers.Logger;
import helpers.Util;
import org.citygml4j.xml.CityGMLContext;
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
