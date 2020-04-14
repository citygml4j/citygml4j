package org.citygml4j.xml.writer;

import org.citygml4j.model.CityGMLVersion;
import org.citygml4j.model.core.AbstractAppearance;
import org.citygml4j.model.core.AbstractCityObject;
import org.citygml4j.model.core.AbstractFeature;
import org.citygml4j.model.core.AbstractVersion;
import org.citygml4j.model.core.AbstractVersionTransition;
import org.citygml4j.model.core.CityModel;
import org.citygml4j.xml.module.citygml.AppearanceModule;
import org.citygml4j.xml.module.citygml.CoreModule;
import org.citygml4j.xml.module.gml.GMLCoreModule;
import org.citygml4j.xml.reader.FeatureInfo;
import org.xml.sax.ContentHandler;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.stream.XMLWriterFactory;
import org.xmlobjects.util.copy.CopyBuilder;
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
            cityModelInfo.setMetaDataProperties(featureInfo.getMetaDataProperties());
            cityModelInfo.setDescription(featureInfo.getDescription());
            cityModelInfo.setDescriptionReference(featureInfo.getDescriptionReference());
            cityModelInfo.setIdentifier(featureInfo.getIdentifier());
            cityModelInfo.setNames(featureInfo.getNames());
            cityModelInfo.setBoundedBy(featureInfo.getBoundedBy());
            cityModelInfo.setEngineeringCRS(featureInfo.getEngineeringCRS());
        }

        return this;
    }

    public void writeMember(AbstractFeature feature) throws CityGMLWriteException {
        if (feature instanceof AbstractCityObject)
            writeMember(feature, CoreModule.of(version).getNamespaceURI(), "cityObjectMember");
        else if (feature instanceof AbstractAppearance)
            writeMember(feature, AppearanceModule.of(version).getNamespaceURI(), "appearanceMember");
        else if (version == CityGMLVersion.v3_0) {
            if (feature instanceof AbstractVersion)
                writeMember(feature, CoreModule.v3_0.getNamespaceURI(), "versionMember");
            else if (feature instanceof AbstractVersionTransition)
                writeMember(feature, CoreModule.v3_0.getNamespaceURI(), "versionTransitionMember");
            else
                writeMember(feature, CoreModule.v3_0.getNamespaceURI(), "featureMember");
        } else
            writeMember(feature, GMLCoreModule.v3_1.getNamespaceURI(), "featureMember");
    }

    private void writeMember(AbstractFeature feature, String namespaceURI, String propertyName) throws CityGMLWriteException {
        switch (state) {
            case CLOSED:
                throw new CityGMLWriteException("Illegal to write features after writer has been closed.");
            case INITIAL:
                writeHeader();
        }

        try {
            XMLWriter writer = getWriter(this.writer.getContentHandler());
            writer.writeStartDocument();
            writer.writeStartElement(Element.of(namespaceURI, propertyName));
            writer.writeObject(feature, namespaces);
            writer.writeEndElement();
            writer.writeEndDocument();
            resetTransformer();
        } catch (XMLWriteException | ObjectSerializeException | TransformerException e) {
            throw new CityGMLWriteException("Caused by:", e);
        }
    }

    private void writeHeader() throws CityGMLWriteException {
        if (state != State.INITIAL)
            throw new CityGMLWriteException("The document has already been started.");

        try {
            CityModel cityModel;
            if (cityModelInfo != null) {
                cityModel = (CityModel) cityModelInfo.getCityModel().shallowCopy(new CopyBuilder());
                cityModel.setADEPropertiesOfCityModel(null);
            } else
                cityModel = new CityModel();

            writer.writeStartDocument();

            SAXFragmentHandler fragmentHandler = new SAXFragmentHandler(
                    writer.getContentHandler(),
                    SAXFragmentHandler.Mode.HEADER);

            XMLWriter writer = getWriter(fragmentHandler);
            writer.writeStartDocument();
            writer.writeObject(cityModel, namespaces);
            writer.writeEndDocument();
            resetTransformer();

            state = State.DOCUMENT_STARTED;
        } catch (XMLWriteException | ObjectSerializeException | TransformerException e) {
            throw new CityGMLWriteException("Caused by:", e);
        }
    }

    private void writeFooter() throws CityGMLWriteException {
        if (state == State.INITIAL)
            writeHeader();

        try {
            CityModel cityModel = new CityModel();
            if (cityModelInfo != null)
                cityModel.setADEPropertiesOfCityModel(cityModelInfo.getCityModel().getADEPropertiesOfCityModel());

            SAXFragmentHandler fragmentHandler = new SAXFragmentHandler(
                    writer.getContentHandler(),
                    SAXFragmentHandler.Mode.FOOTER);

            XMLWriter writer = getWriter(fragmentHandler);
            writer.writeStartDocument();
            writer.writeObject(cityModel, namespaces);
            writer.writeEndDocument();

            this.writer.writeEndDocument();
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

    private void resetTransformer() throws TransformerException {
        if (transformer != null)
            transformer.reset();
    }

    @Override
    public void close() throws CityGMLWriteException {
        if (state == State.CLOSED)
            throw new CityGMLWriteException("The writer has already been closed.");

        writeFooter();
        super.close();
        state = State.CLOSED;
    }
}
