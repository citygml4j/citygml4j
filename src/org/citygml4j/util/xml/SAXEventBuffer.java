/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2012
 * Institute for Geodesy and Geoinformation Science
 * Technische Universität Berlin, Germany
 * http://www.igg.tu-berlin.de/
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 * 
 * $Id: SAXEventBuffer.java 542 2012-11-29 20:56:44Z nagel $
 */
package org.citygml4j.util.xml;

import org.citygml4j.util.xml.saxevents.Characters;
import org.citygml4j.util.xml.saxevents.EndDocument;
import org.citygml4j.util.xml.saxevents.EndElement;
import org.citygml4j.util.xml.saxevents.EndPrefixMapping;
import org.citygml4j.util.xml.saxevents.Location;
import org.citygml4j.util.xml.saxevents.SAXEvent;
import org.citygml4j.util.xml.saxevents.StartDocument;
import org.citygml4j.util.xml.saxevents.StartElement;
import org.citygml4j.util.xml.saxevents.StartPrefixMapping;
import org.citygml4j.util.xml.saxevents.SAXEvent.EventType;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.LocatorImpl;
import org.xml.sax.helpers.NamespaceSupport;

public class SAXEventBuffer implements ContentHandler {
	private final NamespaceSupport namespaces;
	private final boolean trackLocation;

	private LocatorImpl locator;
	private SAXEvent head;
	private SAXEvent tail;

	private EventType lastElementEvent = EventType.END_ELEMENT;
	private Stack<StartElement> parentStartElements;
	private StartElement lastStartElement;

	public SAXEventBuffer() {
		this(false);
	}

	public SAXEventBuffer(boolean trackLocation) {
		this.trackLocation = trackLocation;
		namespaces = new NamespaceSupport();
		locator = trackLocation ? new LocatorImpl() : null;
		parentStartElements = new Stack<StartElement>();
	}

	public boolean isTrackLocation() {
		return trackLocation;
	}

	public NamespaceSupport getNamespaceSupport() {
		return namespaces;
	}

	public void setDocumentLocator(Locator locator) {
		//
	}

	public void updateLocation(int lineNumber, int columnNumber, String systemId, String publicId) {
		locator.setLineNumber(lineNumber);
		locator.setColumnNumber(columnNumber);
		locator.setSystemId(systemId);
		locator.setPublicId(publicId);
	}

	public void skippedEntity(String name) throws SAXException {
		// we do not record this event
	}

	public void characters(char[] ch, int start, int length) throws SAXException {
		if (lastElementEvent == EventType.START_ELEMENT)
			addEvent(new Characters(ch, start, length, getLocation()));
	}

	public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
		// we do not record this event
	}

	public void processingInstruction(String target, String data) throws SAXException {
		// we do not record this event
	}

	public void startDocument() throws SAXException {
		addEvent(new StartDocument());
	}

	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		StartElement element = new StartElement(uri, localName, qName, atts, getLocation());		
		if (lastElementEvent == EventType.START_ELEMENT) {
			parentStartElements.push(lastStartElement);
			tail = lastStartElement;
		}

		addEvent(element);
		lastStartElement = element;
		lastElementEvent = EventType.START_ELEMENT;
	}

	public void startPrefixMapping(String prefix, String uri) throws SAXException {
		namespaces.pushContext();
		namespaces.declarePrefix(prefix, uri);		
		addEvent(new StartPrefixMapping(prefix, uri));
	}

	public void endDocument() throws SAXException {
		addEvent(new EndDocument());
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (lastElementEvent == EventType.END_ELEMENT)
			parentStartElements.pop();

		addEvent(new EndElement(uri, localName, qName, getLocation()));
		lastElementEvent = EventType.END_ELEMENT;
	}

	public void endPrefixMapping(String prefix) throws SAXException {
		namespaces.popContext();		
		addEvent(new EndPrefixMapping(prefix));
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void clear() {
		head = tail = null;
		namespaces.reset();
		locator = trackLocation ? new LocatorImpl() : null;
		lastElementEvent = EventType.END_ELEMENT;
		parentStartElements = new Stack<StartElement>();
		lastStartElement = null;		
	}

	public void addEvent(SAXEvent event) {
		if (!isEmpty()) {
			tail.setNext(event);
			tail = event;
		} else
			head = tail = event;		
	}

	public void append(SAXEventBuffer other) {
		if (other.isEmpty())
			return;

		if (!isEmpty()) {
			addEvent(other.head);
			tail = other.tail;
		} else {
			head = other.head;
			tail = other.tail;
		}
	}

	public SAXEvent getFirstEvent() {
		return head;
	}

	public SAXEvent getFirstEvent(EventType type) {
		if (!isEmpty()) {
			SAXEvent event = head;			
			do {
				if (event.getType() == type)
					return event;
			} while ((event = event.next()) != null);
		}

		return null;
	}

	public void removeFirstEvent() {
		head = head.next();
	}

	public SAXEvent getLastEvent() {
		return tail;
	}

	public StartElement getFirstStartElement() {
		return (StartElement)getFirstEvent(EventType.START_ELEMENT);
	}

	public StartElement getLastStartElement() {
		return lastStartElement;
	}

	public StartElement getParentStartElement() {
		return parentStartElements.peek();
	}

	private Location getLocation() {
		return trackLocation ? new Location(
				locator.getLineNumber(), 
				locator.getColumnNumber(),
				locator.getSystemId(),
				locator.getPublicId()) : null;
	}

	private static final class StackItem<T> {
		private final T value;
		private StackItem<T> next;

		StackItem(T value) {
			this.value = value;
		}
	}

	private static final class Stack<T> {
		private StackItem<T> head;

		void push(T item) {
			StackItem<T> tmp = new StackItem<T>(item);
			if (!isEmpty()) {
				tmp.next = head;
				head = tmp;
			}
			else
				head = tmp;
		}

		T pop() {
			if (!isEmpty()) {
				StackItem<T> tmp = head;
				head = head.next;			
				return tmp.value;
			}

			return null;
		}

		T peek() {
			return !isEmpty() ? head.value : null;
		}

		boolean isEmpty() {
			return head == null;
		}
	}

}
