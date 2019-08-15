package org.citygml4j;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xmlobjects.XMLObjects;
import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.schema.SchemaHandler;
import org.xmlobjects.schema.SchemaHandlerException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLReaderFactory;
import org.xmlobjects.xml.Namespaces;

import java.io.File;

public class Test {

    public static void main(String[] args) throws Exception {
        XMLObjects xmlObjects = XMLObjects.newInstance();
        XMLReaderFactory factory = XMLReaderFactory.newInstance(xmlObjects);
        factory.createDOMAsFallback(true);

        SchemaHandler h = new SchemaHandler();
        h.parseSchema(Test.class.getResource("/org/citygml4j/schemas/citygml4j.xsd"));
        System.out.println("kjh");
        factory.withSchemaHandler(h);

        factory.withProperty("bla", true);

        long time = System.currentTimeMillis();
        GMLObject object = null;
        Namespaces bla = null;

        try (XMLReader reader = factory.createReader(new File("datasets/building_3.gml"))) {
            object = xmlObjects.fromXML(reader, GMLObject.class);
            System.out.println(((System.currentTimeMillis() - time) / 1000.0) + ": " + object);
            bla = reader.getNamespaces();
        }

        /*Namespaces namespaces = Namespaces.of(GMLConstants.GML_3_2_NAMESPACE);

        XMLWriterFactory out = XMLWriterFactory.newInstance(xmlObjects);
        try (XMLWriter writer = out.createWriter(new File("datasets/out.gml"))) {
            writer.useIndentString("  ")
                    .usePrefix("gml", GMLConstants.GML_3_2_NAMESPACE)
                    .usePrefix("gmlce", GMLConstants.GML_3_3_CE_NAMESPACE)
                    .usePrefix("gmlxbt", GMLConstants.GML_3_3_XBT_NAMESPACE)
                    .usePrefix("xlink", GMLConstants.XLINK_NAMESPACE);

            xmlObjects.toXML(writer, object, namespaces);
        }*/

        System.out.println("ende");
    }


}
