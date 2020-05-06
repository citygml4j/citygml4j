package org.citygml4j.xml.reader;

import org.citygml4j.model.CityGMLObject;
import org.citygml4j.model.core.AbstractFeature;
import org.xml.sax.SAXException;
import org.xmlobjects.XMLObjects;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.stream.EventType;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLReaderFactory;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.TransformerException;
import java.util.NoSuchElementException;

public class CityGMLSimpleReader extends CityGMLReader {
    private final XMLReaderFactory factory;

    private boolean hasNext = false;

    public CityGMLSimpleReader(XMLReader reader, XMLReaderFactory factory) {
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
    public AbstractFeature next() throws CityGMLReadException {
        if (hasNext()) {
            try {
                AbstractFeature feature;
                if (transformer == null) {
                    feature = reader.getObject(AbstractFeature.class);
                    if (feature != null && resolver != null)
                        resolver.resolveReferences(feature);
                } else
                    feature = nextChunk().build(true);

                return feature;
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
                XMLStreamReader reader = this.reader.getStreamReader();
                CityGMLChunk chunk = new CityGMLChunk(reader.getName(), factory, resolver);

                do {
                    chunk.bufferEvent(reader);
                    if (chunk.isComplete())
                        break;
                } while (reader.hasNext() && reader.next() >= 0);

                if (transformer != null)
                    chunk.transform(transformer);

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
