/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright 2013-2017 Claus Nagel <claus.nagel@gmail.com>
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
package org.citygml4j.builder.jaxb.xml.io.writer;

import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.ade.generic.ADEGenericElement;
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
import org.citygml4j.model.module.citygml.CityGMLModuleType;
import org.citygml4j.util.internal.xml.TransformerChain;
import org.citygml4j.util.xml.SAXFragmentWriter;
import org.citygml4j.util.xml.SAXFragmentWriter.WriteMode;
import org.citygml4j.util.xml.SAXWriter;
import org.citygml4j.xml.io.writer.CityGMLWriteException;
import org.citygml4j.xml.io.writer.CityModelInfo;
import org.citygml4j.xml.io.writer.CityModelWriter;
import org.citygml4j.xml.io.writer.FeatureWriteMode;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXResult;
import java.util.ArrayList;
import java.util.List;

public class JAXBModelWriter extends AbstractJAXBWriter implements CityModelWriter {
	private CityModelInfo cityModelInfo;
	private ModuleContext initModuleCtx;
	private DocumentState documentState = DocumentState.INITIAL;

	private enum DocumentState {
		INITIAL,
		START_DOCUMENT,
		END_DOCUMENT,
	}

	public JAXBModelWriter(SAXWriter writer, 
			JAXBOutputFactory factory, 
			ModuleContext moduleContext) throws CityGMLWriteException {
		super(writer, factory, moduleContext);

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
				cityModel.unsetGenericADEElement();
			} else
				cityModel = new CityModel();

			JAXBElement<?> jaxbElement = jaxbMarshaller.marshalJAXBElement(cityModel);
			if (jaxbElement != null) {
				Marshaller marshaller = createMarshaller(false);
				SAXFragmentWriter fragmentWriter = new SAXFragmentWriter(
						new QName(jaxbMarshaller.getModuleContext().getModule(CityGMLModuleType.CORE).getNamespaceURI(), "CityModel"), writer, WriteMode.HEAD);

				if (transformerChainFactory == null)
					marshaller.marshal(jaxbElement, fragmentWriter);
				else {
					// apply transformation before marshalling
					TransformerChain chain = transformerChainFactory.buildChain();
					chain.tail().setResult(new SAXResult(fragmentWriter));
					marshaller.marshal(jaxbElement, chain.head());
				}
			}

			documentState = DocumentState.START_DOCUMENT;

		} catch (JAXBException | TransformerConfigurationException e) {
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
			CityModel cityModel = new CityModel();

			if (cityModelInfo != null) {
				if (cityModelInfo.isSetGenericApplicationPropertyOfCityModel())
					cityModel.setGenericApplicationPropertyOfCityModel(
							cityModelInfo.getGenericApplicationPropertyOfCityModel());

				if (cityModelInfo.isSetGenericADEElement())
					cityModel.setGenericADEElement(
							cityModelInfo.getGenericADEElement());
			}		

			ModuleContext tmp = jaxbMarshaller.getModuleContext();
			jaxbMarshaller.setModuleContext(initModuleCtx);

			JAXBElement<?> jaxbElement = jaxbMarshaller.marshalJAXBElement(cityModel);
			if (jaxbElement != null) {
				SAXFragmentWriter fragmentWriter = new SAXFragmentWriter(
						new QName(jaxbMarshaller.getModuleContext().getModule(CityGMLModuleType.CORE).getNamespaceURI(), "CityModel"), writer, WriteMode.TAIL);
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
					if (jaxbElement != null) {
						if (transformerChainFactory == null)
							marshaller.marshal(jaxbElement, writer);
						else {
							// apply transformation before marshalling
							TransformerChain chain = transformerChainFactory.buildChain();
							chain.tail().setResult(new SAXResult(writer));
							chain.head().startDocument();
							marshaller.marshal(jaxbElement, chain.head());
							chain.head().endDocument();
						}
					}
				}					
			} 

			else {
				FeatureProperty<? extends AbstractFeature> member = wrap(object);
				if (member != null) {
					JAXBElement<?> jaxbElement = jaxbMarshaller.marshalJAXBElement(member);
					if (jaxbElement != null) {
						if (transformerChainFactory == null)
							marshaller.marshal(jaxbElement, writer);
						else {
							// apply transformation before marshalling
							TransformerChain chain = transformerChainFactory.buildChain();
							chain.tail().setResult(new SAXResult(writer));
							chain.head().startDocument();
							marshaller.marshal(jaxbElement, chain.head());
							chain.head().endDocument();
						}
					}
				}
			}

		} catch (JAXBException | SAXException | TransformerConfigurationException e) {
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

		FeatureArrayProperty members = new FeatureArrayProperty();
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
				else if (member.isSetGenericADEElement())
					members.addGenericADEElement(member.getGenericADEElement());
			}
		}

		try {
			JAXBElement<?> jaxbElement = jaxbMarshaller.marshalJAXBElement(members);
			if (jaxbElement != null) {
				Marshaller marshaller = createMarshaller(true);
				
				if (transformerChainFactory == null)
					marshaller.marshal(jaxbElement, writer);
				else {
					// apply transformation before marshalling
					TransformerChain chain = transformerChainFactory.buildChain();
					chain.tail().setResult(new SAXResult(writer));
					chain.head().startDocument();
					marshaller.marshal(jaxbElement, chain.head());
					chain.head().endDocument();
				}
			}
		} catch (JAXBException | SAXException | TransformerConfigurationException e) {
			throw new CityGMLWriteException("Caused by: ", e);
		}
	}

	private FeatureProperty<? extends AbstractFeature> wrap(ModelObject object) {
		FeatureProperty<? extends AbstractFeature> member = null;

		if (object instanceof AbstractCityObject) {
			member = new CityObjectMember();
			((CityObjectMember)member).setCityObject((AbstractCityObject)object);
		} 

		else if (object instanceof Appearance) {
			member = new AppearanceMember();
			((AppearanceMember)member).setAppearance((Appearance)object);
		} 

		else if (object instanceof AbstractFeature) {
			member = new FeatureMember();
			((FeatureMember)member).setFeature((AbstractFeature)object);
		}

		else if (object instanceof ADEGenericElement) {
			ADEGenericElement ade = (ADEGenericElement)object;

			member = (isCityObject(ade)) ? new CityObjectMember() : new FeatureMember();
			member.setGenericADEElement(ade);
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

}
