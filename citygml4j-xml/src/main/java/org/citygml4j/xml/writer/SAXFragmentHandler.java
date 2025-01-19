/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2025 Claus Nagel <claus.nagel@gmail.com>
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
