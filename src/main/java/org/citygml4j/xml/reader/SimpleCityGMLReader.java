package org.citygml4j.xml.reader;

import org.citygml4j.model.CityGMLObject;
import org.xml.sax.SAXException;
import org.xmlobjects.XMLObjects;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.model.feature.AbstractFeature;
import org.xmlobjects.stream.EventType;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLReaderFactory;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.TransformerException;
import java.util.NoSuchElementException;

public class SimpleCityGMLReader extends CityGMLReader {
    private final XMLReaderFactory factory;

    private volatile boolean hasNext = false;

    public SimpleCityGMLReader(XMLReader reader, XMLReaderFactory factory) {
        super(reader);
        this.factory = factory;
    }

    @Override
    public boolean hasNext() throws CityGMLReadException {
        if (!hasNext) {
            try {
                XMLObjects xmlObjects = reader.getXMLObjects();
                while (reader.hasNext()) {
                    if (reader.nextTag() == EventType.START_ELEMENT) {
                        if (filter == null || filter.accept(reader.getName())) {
                            ObjectBuilder<AbstractFeature> builder = xmlObjects.getBuilder(reader.getName(), AbstractFeature.class);
                            if (builder != null && CityGMLObject.class.isAssignableFrom(xmlObjects.getObjectType(builder))) {
                                hasNext = true;
                                break;
                            }
                        } else {
                            int skipUntil = reader.getDepth() - 1;
                            while (reader.getDepth() != skipUntil)
                                reader.nextTag();
                        }
                    }
                }
            } catch (XMLReadException e) {
                throw new CityGMLReadException("Caused by:", e);
            }
        }

        return hasNext;
    }

    @Override
    public CityGMLObject next() throws CityGMLReadException {
        if (hasNext()) {
            try {
                if (transformer == null)
                    return reader.getObject(CityGMLObject.class);
                else {
                    XMLReader reader = factory.createReader(nextChunk().toXMLStreamReader(true));
                    reader.nextTag();
                    return reader.getObject(CityGMLObject.class);
                }
            } catch (ObjectBuildException | XMLReadException e) {
                throw new CityGMLReadException("Caused by:", e);
            } finally {
                hasNext = false;
            }
        }

        throw new NoSuchElementException();
    }

    @Override
    public CityGMLChunk nextChunk() throws CityGMLReadException {
        if (hasNext()) {
            try {
                CityGMLChunk chunk = new CityGMLChunk();
                XMLStreamReader reader = this.reader.getStreamReader();

                do {
                    chunk.bufferEvent(reader);
                    if (chunk.isComplete())
                        break;
                } while (reader.hasNext() && reader.next() >= 0);

                if (transformer != null)
                    chunk.transform(transformer, true);

                return chunk;
            } catch (XMLStreamException | SAXException | TransformerException e) {
                throw new CityGMLReadException("Caused by:", e);
            } finally {
                hasNext = false;
            }
        }

        throw new NoSuchElementException();
    }
}
