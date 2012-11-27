/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universitaet Berlin, Germany
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
 */
package org.citygml4j.builder.jaxb.xml.io.writer;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.citygml4j.builder.jaxb.marshal.JAXBNamespacePrefixMapper;
import org.citygml4j.impl.citygml.appearance.AppearanceMemberImpl;
import org.citygml4j.impl.citygml.core.CityModelImpl;
import org.citygml4j.impl.citygml.core.CityObjectMemberImpl;
import org.citygml4j.impl.gml.feature.FeatureArrayPropertyImpl;
import org.citygml4j.impl.gml.feature.FeatureMemberImpl;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.appearance.Appearance;
import org.citygml4j.model.citygml.appearance.AppearanceMember;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.citygml.core.CityObjectMember;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.gml.feature.FeatureArrayProperty;
import org.citygml4j.model.gml.feature.FeatureMember;
import org.citygml4j.model.gml.feature.FeatureProperty;
import org.citygml4j.model.module.ModuleContext;
import org.citygml4j.util.xml.SAXWriter;
import org.citygml4j.xml.io.writer.CityGMLWriteException;
import org.citygml4j.xml.io.writer.CityModelInfo;
import org.citygml4j.xml.io.writer.CityModelWriter;
import org.citygml4j.xml.io.writer.FeatureWriteMode;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.XMLFilterImpl;

public class JAXBModelWriter extends AbstractJAXBWriter implements CityModelWriter {
	private CityModelInfo cityModelInfo;
	private ModuleContext initModuleCtx;

	private DocumentState documentState = DocumentState.INITIAL;
	private SAXFragmentWriter fragmentWriter;

	private enum DocumentState {
		INITIAL,
		START_DOCUMENT,
		END_DOCUMENT,
	}

	public JAXBModelWriter(SAXWriter writer, 
			JAXBOutputFactory factory, 
			ModuleContext moduleContext) throws CityGMLWriteException {
		super(writer, factory, moduleContext);

		fragmentWriter = new SAXFragmentWriter();
		initModuleCtx = new ModuleContext(moduleContext);
	}

	public JAXBModelWriter(SAXWriter writer, 
			JAXBOutputFactory factory, 
			ModuleContext moduleContext, 
			CityModelInfo cityModelInfo) throws CityGMLWriteException {
		this(writer, factory, moduleContext);		
		this.cityModelInfo = cityModelInfo;
	}

	@Override
	public void reset() {		
		documentState = DocumentState.INITIAL;
		cityModelInfo = null;

		super.reset();
	}

	@Override
	public void close() throws CityGMLWriteException {		
		if (documentState == DocumentState.START_DOCUMENT)
			writeEndDocument();

		cityModelInfo = null;
		initModuleCtx = null;
		fragmentWriter = null;

		super.close();
	}

	public CityModelInfo getCityModelInfo() {
		return cityModelInfo;
	}

	public void setCityModelInfo(CityModelInfo cityModelInfo) {
		if (cityModelInfo == null)
			throw new IllegalArgumentException("CityModelInfo may not be null.");

		if (documentState == DocumentState.INITIAL)
			this.cityModelInfo = cityModelInfo;
	}

	public void writeFeatureMember(AbstractFeature feature) throws CityGMLWriteException {
		writeModelMember(feature);		
	}

	public void writeFeatureMember(ADEComponent adeComponent) throws CityGMLWriteException {
		writeModelMember(adeComponent);	
	}

	public void writeStartDocument() throws CityGMLWriteException {
		switch (documentState) {
		case START_DOCUMENT:
			throw new IllegalStateException("CityModel start element can only be written once.");
		case END_DOCUMENT:
			throw new IllegalStateException("CityModel start element cannot be written after CityModel end element.");
		case INITIAL:
			break;
		default:
			throw new IllegalStateException("Unknown document state '" + documentState + "'");
		}

		try {
			CityModel cityModel = null;

			if (cityModelInfo != null) {
				cityModel = cityModelInfo.toCityModel();
				cityModel.unsetGenericApplicationPropertyOfCityModel();
				cityModel.unsetGenericADEComponent();
			} else
				cityModel = new CityModelImpl();

			JAXBElement<?> jaxbElement = jaxbMarshaller.marshalJAXBElement(cityModel);
			if (jaxbElement != null) {
				fragmentWriter.shouldWrite = true;
				createMarshaller(false).marshal(jaxbElement, fragmentWriter);
			}

			documentState = DocumentState.START_DOCUMENT;

		} catch (JAXBException e) {
			throw new CityGMLWriteException("Caused by: ", e);
		}
	}

	public void writeEndDocument() throws CityGMLWriteException {
		switch (documentState) {
		case END_DOCUMENT:
			throw new IllegalStateException("CityModel end element can only be written once.");
		case INITIAL:
			writeStartDocument();
		case START_DOCUMENT:
			break;
		default:
			throw new IllegalStateException("Unknown document state '" + documentState + "'");
		}

		try {
			CityModel cityModel = new CityModelImpl();

			if (cityModelInfo != null) {
				if (cityModelInfo.isSetGenericApplicationPropertyOfCityModel())
					cityModel.setGenericApplicationPropertyOfCityModel(
							cityModelInfo.getGenericApplicationPropertyOfCityModel());

				if (cityModelInfo.isSetGenericADEComponent())
					cityModel.setGenericADEComponent(
							cityModelInfo.getGenericADEComponent());
			}		

			ModuleContext tmp = jaxbMarshaller.getModuleContext();
			jaxbMarshaller.setModuleContext(initModuleCtx);

			JAXBElement<?> jaxbElement = jaxbMarshaller.marshalJAXBElement(cityModel);
			if (jaxbElement != null) {
				fragmentWriter.shouldWrite = false;
				createMarshaller(true).marshal(jaxbElement, fragmentWriter);
			}

			jaxbMarshaller.setModuleContext(tmp);
			documentState = DocumentState.END_DOCUMENT;

		} catch (JAXBException e) {
			throw new CityGMLWriteException("Caused by: ", e);
		}
	}

	private void writeModelMember(ModelObject object) throws CityGMLWriteException {
		switch (documentState) {
		case END_DOCUMENT:
			throw new IllegalStateException("model member cannot be written after CityModel end element.");
		case INITIAL:
			writeStartDocument();
			break;
		case START_DOCUMENT:
			break;
		default:
			throw new IllegalStateException("Unknown document state '" + documentState + "'");
		}

		try {
			Marshaller marshaller = createMarshaller(true);

			if (featureWriteMode == FeatureWriteMode.SPLIT_PER_COLLECTION_MEMBER) {
				for (FeatureProperty<? extends AbstractFeature> member : split(object)) {
					JAXBElement<?> jaxbElement = jaxbMarshaller.marshalJAXBElement(member);
					if (jaxbElement != null)
						marshaller.marshal(jaxbElement, writer);
				}					
			} 

			else {
				FeatureProperty<? extends AbstractFeature> member = wrap(object);
				if (member != null) {
					JAXBElement<?> jaxbElement = jaxbMarshaller.marshalJAXBElement(member);
					if (jaxbElement != null)
						marshaller.marshal(jaxbElement, writer);
				}
			}

		} catch (JAXBException e) {
			throw new CityGMLWriteException("Caused by: ", e);
		}
	}

	public void writeFeatureMembers(List<ModelObject> features) throws CityGMLWriteException {
		switch (documentState) {
		case END_DOCUMENT:
			throw new IllegalStateException("CityModel members cannot be written after document end.");
		case INITIAL:
			writeStartDocument();
			break;
		case START_DOCUMENT:
			break;
		default:
			throw new IllegalStateException("Unknown document state '" + documentState + "'");
		}

		FeatureArrayProperty members = new FeatureArrayPropertyImpl();
		List<FeatureProperty<? extends AbstractFeature>> featureArray = new ArrayList<FeatureProperty<? extends AbstractFeature>>();

		for (ModelObject feature : features) {
			if (feature instanceof AbstractFeature || feature instanceof ADEComponent) {
				if (featureWriteMode == FeatureWriteMode.SPLIT_PER_COLLECTION_MEMBER)
					featureArray.addAll(split(feature));				
				else
					featureArray.add(wrap(feature));
			}
		}	

		for (FeatureProperty<? extends AbstractFeature> member : featureArray) {
			if (member != null) {
				if (member.isSetFeature())
					members.addFeature(member.getFeature());
				else if (member.isSetGenericADEComponent())
					members.addGenericADEComponent(member.getGenericADEComponent());
			}
		}

		try {
			JAXBElement<?> jaxbElement = jaxbMarshaller.marshalJAXBElement(members);
			if (jaxbElement != null)
				createMarshaller(true).marshal(jaxbElement, writer);
		} catch (JAXBException e) {
			throw new CityGMLWriteException("Caused by: ", e);
		}
	}

	private FeatureProperty<? extends AbstractFeature> wrap(ModelObject object) {
		FeatureProperty<? extends AbstractFeature> member = null;

		if (object instanceof AbstractCityObject) {
			member = new CityObjectMemberImpl();
			((CityObjectMember)member).setCityObject((AbstractCityObject)object);
		} 

		else if (object instanceof Appearance) {
			member = new AppearanceMemberImpl();
			((AppearanceMember)member).setAppearance((Appearance)object);
		} 

		else if (object instanceof AbstractFeature) {
			member = new FeatureMemberImpl();
			((FeatureMember)member).setFeature((AbstractFeature)object);
		}

		else if (object instanceof ADEComponent) {
			ADEComponent ade = (ADEComponent)object;

			member = (isCityObject(ade)) ? new CityObjectMemberImpl() : new FeatureMemberImpl();
			member.setGenericADEComponent(ade);
		}

		return member;
	}

	private List<FeatureProperty<? extends AbstractFeature>> split(ModelObject object) {
		List<FeatureProperty<? extends AbstractFeature>> memberList = new ArrayList<FeatureProperty<? extends AbstractFeature>>();
		List<CityGML> results = featureSplitter.split(object); 

		if (!results.isEmpty()) {
			for (CityGML result : results) {
				FeatureProperty<? extends AbstractFeature> member = wrap(result);
				if (member != null)
					memberList.add(member);
			}
		} else {
			FeatureProperty<? extends AbstractFeature> member = wrap(object);
			if (member != null)
				memberList.add(member);
		}

		return memberList;
	}

	private Marshaller createMarshaller(boolean fragment) throws CityGMLWriteException {
		try {
			Marshaller marshaller = jaxbContext.createMarshaller();

			if (fragment)
				marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);

			// turn validation on
			if (useValidation) {
				marshaller.setSchema(validationSchemaHandler.getSchema());
				marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", new JAXBNamespacePrefixMapper());
				if (validationEventHandler != null)
					marshaller.setEventHandler(validationEventHandler);
			}

			return marshaller;
		} catch (JAXBException e) {
			throw new CityGMLWriteException("Caused by: ", e);
		} catch (SAXException e) {
			throw new CityGMLWriteException("Caused by: ", e);			
		}
	}

	private class SAXFragmentWriter extends XMLFilterImpl {
		private volatile boolean shouldWrite;
		private int depth = 0;

		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			if (shouldWrite)
				writer.characters(ch, start, length);
		}

		@Override
		public void endDocument() throws SAXException {
			if (shouldWrite)
				writer.endDocument();
		}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			depth--;

			if (depth == 0 && documentState == DocumentState.INITIAL) {
				shouldWrite = false;
				return;
			}

			if (shouldWrite)
				writer.endElement(uri, localName, qName);
		}

		@Override
		public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
			if (shouldWrite)
				writer.ignorableWhitespace(ch, start, length);
		}

		@Override
		public void processingInstruction(String target, String data) throws SAXException {
			if (shouldWrite)
				writer.processingInstruction(target, data);
		}

		@Override
		public void startDocument() throws SAXException {
			if (shouldWrite)
				writer.startDocument();
		}

		@Override
		public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
			depth++;

			if (depth == 1 && documentState == DocumentState.START_DOCUMENT) {
				shouldWrite = true;
				return;
			}

			if (shouldWrite)
				writer.startElement(uri, localName, qName, atts);
		}

		@Override
		public void endPrefixMapping(String prefix) throws SAXException {
			writer.endPrefixMapping(prefix);
		}

		@Override
		public void startPrefixMapping(String prefix, String uri) throws SAXException {
			writer.startPrefixMapping(prefix, uri);
		}
	}

}
