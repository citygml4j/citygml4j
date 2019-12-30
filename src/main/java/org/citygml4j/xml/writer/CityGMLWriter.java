package org.citygml4j.xml.writer;

import org.citygml4j.model.CityGMLObject;
import org.citygml4j.model.CityGMLVersion;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.stream.XMLWriterFactory;

import javax.xml.transform.sax.SAXResult;

public class CityGMLWriter extends AbstractCityGMLWriter<CityGMLWriter> {
    private volatile boolean isValid = true;

    public CityGMLWriter(XMLWriter writer, CityGMLVersion version, XMLWriterFactory factory) {
        super(writer, version, factory);
    }

    public void write(CityGMLObject object) throws CityGMLWriteException {
        if (!isValid)
            throw new CityGMLWriteException("CityGMLWriter cannot be used to write more than one object.");

        try {
            XMLWriter writer;
            if (transformer != null) {
                writer = factory.createWriter(transformer.getRootHandler());
                transformer.setResult(new SAXResult(this.writer.getContentHandler()));
            } else
                writer = this.writer;

            writer.writeStartDocument();
            writer.writeObject(object, namespaces);
            writer.writeEndDocument();
        } catch (ObjectSerializeException | XMLWriteException e) {
            throw new CityGMLWriteException("Caused by:", e);
        } finally {
            isValid = false;
        }
    }
}
