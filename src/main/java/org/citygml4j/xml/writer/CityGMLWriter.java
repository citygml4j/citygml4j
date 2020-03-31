package org.citygml4j.xml.writer;

import org.citygml4j.model.CityGMLVersion;
import org.citygml4j.model.core.AbstractFeature;
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

    public void write(AbstractFeature feature) throws CityGMLWriteException {
        if (!isValid)
            throw new CityGMLWriteException("CityGMLWriter cannot be used to write more than one feature.");

        try {
            XMLWriter writer;
            if (transformer != null) {
                writer = factory.createWriter(transformer.getRootHandler());
                transformer.setResult(new SAXResult(this.writer.getContentHandler()));
            } else
                writer = this.writer;

            writer.writeStartDocument();
            writer.writeObject(feature, namespaces);
            writer.writeEndDocument();
        } catch (ObjectSerializeException | XMLWriteException e) {
            throw new CityGMLWriteException("Caused by:", e);
        } finally {
            isValid = false;
        }
    }
}
