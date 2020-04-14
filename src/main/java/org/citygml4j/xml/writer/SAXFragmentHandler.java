package org.citygml4j.xml.writer;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

import java.util.Objects;

public class SAXFragmentHandler implements ContentHandler {
    private final ContentHandler parent;
    private final Mode mode;
    private boolean shouldHandle;
    private int depth;

    public enum Mode {
        HEADER,
        FOOTER
    }

    public SAXFragmentHandler(ContentHandler parent, Mode mode) {
        this.parent = Objects.requireNonNull(parent, "The parent handler must not be null.");
        this.mode = mode;
        shouldHandle = mode == Mode.HEADER;
    }

    @Override
    public void setDocumentLocator(Locator locator) {
        parent.setDocumentLocator(locator);
    }

    @Override
    public void startDocument() throws SAXException {
        if (shouldHandle)
            parent.startDocument();
    }

    @Override
    public void endDocument() throws SAXException {
        if (shouldHandle)
            parent.endDocument();
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        if (shouldHandle)
            parent.startPrefixMapping(prefix, uri);
    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {
        if (shouldHandle)
            parent.endPrefixMapping(prefix);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        if (shouldHandle)
            parent.startElement(uri, localName, qName, atts);

        if (depth++ == 0 && mode == Mode.FOOTER)
            shouldHandle = true;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (--depth == 0 && mode == Mode.HEADER)
            shouldHandle = false;

        if (shouldHandle)
            parent.endElement(uri, localName, qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (shouldHandle)
            parent.characters(ch, start, length);
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
        if (shouldHandle)
            parent.ignorableWhitespace(ch, start, length);
    }

    @Override
    public void processingInstruction(String target, String data) throws SAXException {
        if (shouldHandle)
            parent.processingInstruction(target, data);
    }

    @Override
    public void skippedEntity(String name) throws SAXException {
        if (shouldHandle)
            parent.skippedEntity(name);
    }
}
