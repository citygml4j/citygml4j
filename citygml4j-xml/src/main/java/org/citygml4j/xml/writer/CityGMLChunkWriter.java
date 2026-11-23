/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.writer;

import org.citygml4j.core.model.CityGMLVersion;
import org.citygml4j.core.model.core.*;
import org.citygml4j.xml.module.citygml.AppearanceModule;
import org.citygml4j.xml.module.citygml.CoreModule;
import org.citygml4j.xml.module.gml.GMLCoreModule;
import org.citygml4j.xml.reader.FeatureInfo;
import org.xml.sax.ContentHandler;
import org.xmlobjects.copy.Copier;
import org.xmlobjects.copy.CopierBuilder;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.stream.XMLWriterFactory;
import org.xmlobjects.xml.Element;

import javax.xml.transform.TransformerException;
import javax.xml.transform.sax.SAXResult;

public class CityGMLChunkWriter extends AbstractCityGMLWriter<CityGMLChunkWriter> {
    private CityModelInfo cityModelInfo;
    private State state = State.INITIAL;

    private enum State {
        INITIAL,
        DOCUMENT_STARTED,
        CLOSED
    }

    public CityGMLChunkWriter(XMLWriter writer, CityGMLVersion version, XMLWriterFactory factory) {
        super(writer, version, factory);
    }

    public CityModelInfo getCityModelInfo() {
        if (cityModelInfo == null)
            cityModelInfo = new CityModelInfo();

        return cityModelInfo;
    }

    public CityGMLChunkWriter withCityModelInfo(CityModel cityModel) {
        if (cityModel != null)
            cityModelInfo = new CityModelInfo(cityModel);

        return this;
    }

    public CityGMLChunkWriter withCityModelInfo(FeatureInfo featureInfo) {
        if (featureInfo != null) {
            cityModelInfo = new CityModelInfo();
            cityModelInfo.setId(featureInfo.getId());
            cityModelInfo.setDescription(featureInfo.getDescription());
            cityModelInfo.setDescriptionReference(featureInfo.getDescriptionReference());
            cityModelInfo.setIdentifier(featureInfo.getIdentifier());
            cityModelInfo.setBoundedBy(featureInfo.getBoundedBy());
            cityModelInfo.setEngineeringCRS(featureInfo.getEngineeringCRS());

            if (featureInfo.isSetMetaDataProperties()) {
                cityModelInfo.setMetaDataProperties(featureInfo.getMetaDataProperties());
            }

            if (featureInfo.isSetNames()) {
                cityModelInfo.setNames(featureInfo.getNames());
            }
        }

        return this;
    }

    public void writeMember(AbstractFeature feature) throws CityGMLWriteException {
        String coreNamespace = CoreModule.of(version).getNamespaceURI();
        switch (feature) {
            case AbstractCityObject cityObject -> writeMember(feature, coreNamespace, "cityObjectMember");
            case AbstractAppearance appearance -> writeMember(feature, version != CityGMLVersion.v3_0 ?
                    AppearanceModule.of(version).getNamespaceURI() :
                    coreNamespace, "appearanceMember");
            case AbstractVersion object when version == CityGMLVersion.v3_0 ->
                    writeMember(feature, coreNamespace, "versionMember");
            case AbstractVersionTransition transition when version == CityGMLVersion.v3_0 ->
                    writeMember(feature, coreNamespace, "versionTransitionMember");
            case null, default -> writeMember(feature, version == CityGMLVersion.v3_0 ?
                    coreNamespace :
                    GMLCoreModule.v3_1.getNamespaceURI(), "featureMember");
        }
    }

    private void writeMember(AbstractFeature feature, String namespaceURI, String propertyName) throws CityGMLWriteException {
        switch (state) {
            case CLOSED -> throw new CityGMLWriteException("Illegal to write features after writer has been closed.");
            case INITIAL -> writeHeader();
            default -> {
            }
        }

        CityGMLWriteException failure = null;
        try {
            XMLWriter writer = getWriter(this.writer.getContentHandler(true));
            writer.writeStartDocument();
            writer.writeStartElement(Element.of(namespaceURI, propertyName));
            writer.writeObject(feature, namespaces);
            writer.writeEndElement();
            writer.writeEndDocument();
        } catch (XMLWriteException | ObjectSerializeException e) {
            failure = new CityGMLWriteException("Caused by:", e);
            throw failure;
        } finally {
            resetTransformer(failure);
        }
    }

    private void writeHeader() throws CityGMLWriteException {
        if (state != State.INITIAL)
            throw new CityGMLWriteException("The document has already been started.");

        CityGMLWriteException failure = null;
        try {
            CityModel cityModel;
            if (cityModelInfo != null) {
                Copier copier = CopierBuilder.newCopier();
                cityModel = copier.shallowCopy(cityModelInfo.getCityModel());
                cityModel.setADEProperties(null);
            } else
                cityModel = new CityModel();

            SAXFragmentHandler fragmentHandler = new SAXFragmentHandler(
                    writer.getContentHandler(),
                    SAXFragmentHandler.Mode.HEADER);

            XMLWriter writer = getWriter(fragmentHandler);
            writer.writeStartDocument();
            writer.writeObject(cityModel, namespaces);
            writer.writeEndDocument();
        } catch (XMLWriteException | ObjectSerializeException e) {
            failure = new CityGMLWriteException("Caused by:", e);
            throw failure;
        } finally {
            state = State.DOCUMENT_STARTED;
            resetTransformer(failure);
        }
    }

    private void writeFooter() throws CityGMLWriteException {
        if (state == State.INITIAL)
            writeHeader();

        try {
            CityModel cityModel = new CityModel();
            if (cityModelInfo != null) {
                cityModel.setADEProperties(cityModelInfo.getADEProperties());
            }

            SAXFragmentHandler fragmentHandler = new SAXFragmentHandler(
                    writer.getContentHandler(),
                    SAXFragmentHandler.Mode.FOOTER);

            XMLWriter writer = getWriter(fragmentHandler);
            writer.writeStartDocument();
            writer.writeObject(cityModel, namespaces);
            writer.writeEndDocument();
        } catch (XMLWriteException | ObjectSerializeException e) {
            throw new CityGMLWriteException("Caused by:", e);
        }
    }

    private XMLWriter getWriter(ContentHandler handler) {
        if (transformer == null)
            return factory.createWriter(handler);
        else {
            XMLWriter writer = factory.createWriter(transformer.getRootHandler());
            transformer.setResult(new SAXResult(handler));
            return writer;
        }
    }

    private void resetTransformer(CityGMLWriteException failure) throws CityGMLWriteException {
        // also reset after a failed write so that the next write starts from a clean pipeline
        if (transformer != null) {
            try {
                transformer.reset();
            } catch (TransformerException e) {
                CityGMLWriteException exception = new CityGMLWriteException("Failed to reset the transformer.", e);
                if (failure != null) {
                    failure.addSuppressed(exception);
                } else {
                    throw exception;
                }
            }
        }
    }

    @Override
    public void close() throws CityGMLWriteException {
        if (state == State.CLOSED)
            throw new CityGMLWriteException("The writer has already been closed.");

        try {
            writeFooter();
        } catch (CityGMLWriteException | RuntimeException e) {
            // close the underlying writer even if the footer could not be written
            try {
                super.close();
            } catch (CityGMLWriteException suppressed) {
                e.addSuppressed(suppressed);
            }

            throw e;
        } finally {
            state = State.CLOSED;
        }

        super.close();
    }
}
