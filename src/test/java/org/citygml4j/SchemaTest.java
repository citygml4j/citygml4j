package org.citygml4j;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xmlobjects.schema.SchemaHandler;

import java.io.File;

public class SchemaTest {

    public static void main(String[] args) throws Exception {

        SchemaHandler h = new SchemaHandler();

        h.setErrorHandler(new ErrorHandler() {
            @Override
            public void warning(SAXParseException exception) throws SAXException {
                exception.printStackTrace();
            }

            @Override
            public void error(SAXParseException exception) throws SAXException {
                exception.printStackTrace();
            }

            @Override
            public void fatalError(SAXParseException exception) throws SAXException {
                exception.printStackTrace();
            }
        });


        long time = System.currentTimeMillis();
        h.parseSchema(SchemaTest.class.getResource("/org/citygml4j/schemas/citygml4j.xsd"));
        System.out.println(((System.currentTimeMillis() - time) / 1000.0) + ": finished.");

        System.out.println();
        System.out.println();

        time = System.currentTimeMillis();

        h.parseSchema(new File("datasets/schemas/citygml4j.xsd"));
        System.out.println(((System.currentTimeMillis() - time) / 1000.0) + ": finished.");




        System.out.println();
    }

}
