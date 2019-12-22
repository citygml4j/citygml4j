package org.citygml4j.xml.reader;

import org.citygml4j.xml.transform.TransformerPipeline;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xmlobjects.util.xml.SAXBuffer;
import org.xmlobjects.util.xml.StAXStream2SAX;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.TransformerException;
import javax.xml.transform.sax.SAXResult;

public class CityGMLChunk {
    private final QName firstElement;
    private SAXBuffer buffer;
    private StAXStream2SAX mapper;

    private QName lastElement;
    private int depth = 0;

    CityGMLChunk(QName firstElement) {
        this.firstElement = lastElement = firstElement;
        buffer = new SAXBuffer().assumeMixedContent(false);
        mapper = new StAXStream2SAX(buffer);
    }

    boolean isComplete() {
        return depth == 0 && !buffer.isEmpty();
    }

    void bufferEvent(XMLStreamReader reader) throws SAXException {
        int eventType = reader.getEventType();

        if (buffer.isEmpty() && eventType != XMLStreamConstants.START_ELEMENT)
            throw new SAXException("A START_ELEMENT is expected as first element.");
        else if (isComplete() && (eventType == XMLStreamConstants.START_ELEMENT || eventType == XMLStreamConstants.END_ELEMENT))
            throw new SAXException("Chunk is complete and cannot buffer more events.");

        mapper.bridgeEvent(reader);
        switch (eventType) {
            case XMLStreamConstants.START_ELEMENT:
                lastElement = reader.getName();
                depth++;
                break;
            case XMLStreamConstants.END_ELEMENT:
                depth--;
                break;
        }
    }

    SAXBuffer getSAXBuffer() {
        return buffer;
    }

    public QName getFirstElement() {
        return firstElement;
    }

    public QName getLastElement() {
        return lastElement;
    }

    void removeTrailingCharacters() {
        buffer.removeTrailingCharacters();
    }

    public XMLStreamReader toXMLStreamReader(boolean release) {
        return buffer.toXMLStreamReader(release);
    }

    public void send(ContentHandler handler, boolean release) throws SAXException {
        buffer.send(handler, release);
    }

    public void transform(TransformerPipeline pipeline) throws TransformerException {
        try {
            SAXBuffer buffer = new TransformerBuffer().assumeMixedContent(false);
            pipeline.setResult(new SAXResult(buffer));

            pipeline.getRootHandler().startDocument();
            send(pipeline.getRootHandler(), true);
            pipeline.getRootHandler().endDocument();

            this.buffer = buffer;
            mapper = new StAXStream2SAX(buffer);
        } catch (SAXException e) {
            throw new TransformerException("Caused by:", e);
        } finally {
            pipeline.reset();
        }
    }

    private static class TransformerBuffer extends SAXBuffer {
        @Override
        public void startDocument() {
        }

        @Override
        public void addEndDocument() {
        }
    }
}
