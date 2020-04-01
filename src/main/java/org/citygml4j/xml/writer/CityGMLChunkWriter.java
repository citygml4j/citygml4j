package org.citygml4j.xml.writer;

import org.citygml4j.model.CityGMLVersion;
import org.citygml4j.model.core.ADEPropertyOfCityModel;
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
import org.xmlobjects.gml.model.common.GenericElement;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.stream.XMLWriterFactory;
import org.xmlobjects.util.copy.CopyBuilder;
import org.xmlobjects.xml.Element;

import javax.xml.namespace.QName;
import javax.xml.transform.TransformerException;
import javax.xml.transform.sax.SAXResult;
import java.util.List;

public class CityGMLChunkWriter extends AbstractCityGMLWriter<CityGMLChunkWriter> {
    private SAXFragmentHandler fragmentHandler;
    private CityModel cityModel = new CityModel();
    private List<ADEPropertyOfCityModel<?>> adeProperties;
    private List<GenericElement> genericProperties;
    private State state = State.INITIAL;

    private enum State {
        INITIAL,
        DOCUMENT_STARTED,
        CLOSED
    }

    public CityGMLChunkWriter(XMLWriter writer, CityGMLVersion version, XMLWriterFactory factory) {
        super(writer, version, factory);
    }

    public CityModel getCityModel() {
        return cityModel;
    }

    public CityGMLChunkWriter withCityModel(CityModel cityModel) {
        if (cityModel != null) {
            this.cityModel = (CityModel) cityModel.shallowCopy(new CopyBuilder());
            this.cityModel.setCityObjectMembers(null);
            this.cityModel.setAppearanceMembers(null);
            this.cityModel.setFeatureMembers(null);
            this.cityModel.setVersionMembers(null);
            this.cityModel.setVersionTransitionMembers(null);
            this.adeProperties = cityModel.getADEPropertiesOfCityModel();
            this.cityModel.setADEPropertiesOfCityModel(null);
            this.genericProperties = cityModel.getGenericProperties();
            this.cityModel.setGenericProperties(null);
        }

        return this;
    }

    public CityGMLChunkWriter withCityModel(FeatureInfo featureInfo) {
        if (featureInfo != null) {
            cityModel = new CityModel();
            cityModel.setId(featureInfo.getId());
            cityModel.setMetaDataProperties(featureInfo.getMetaDataProperties());
            cityModel.setDescription(featureInfo.getDescription());
            cityModel.setDescriptionReference(featureInfo.getDescriptionReference());
            cityModel.setIdentifier(featureInfo.getIdentifier());
            cityModel.setNames(featureInfo.getNames());
            cityModel.setBoundedBy(featureInfo.getBoundedBy());
            cityModel.setEngineeringCRS(featureInfo.getEngineeringCRS());
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
            writer.writeStartDocument();

            fragmentHandler = new SAXFragmentHandler(
                    writer.getContentHandler(),
                    new QName(CoreModule.of(version).getNamespaceURI(), "CityModel"),
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
            XMLWriter writer = getWriter(this.writer.getContentHandler());
            if (adeProperties != null) {
                for (ADEPropertyOfCityModel<?> adeProperty : adeProperties) {
                    writer.writeStartDocument();
                    writer.writeObject(adeProperty, namespaces);
                    writer.writeEndDocument();
                    resetTransformer();
                }
            }

            if (genericProperties != null) {
                for (GenericElement genericProperty : genericProperties) {
                    writer.writeStartDocument();
                    writer.writeDOMElement(genericProperty.getContent());
                    writer.writeEndDocument();
                    resetTransformer();
                }
            }

            fragmentHandler.setMode(SAXFragmentHandler.Mode.FOOTER);
            writer = getWriter(fragmentHandler);
            writer.writeStartDocument();
            writer.writeObject(new CityModel(), namespaces);
            writer.writeEndDocument();

            this.writer.writeEndDocument();
        } catch (XMLWriteException | TransformerException | ObjectSerializeException e) {
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
