package org.citygml4j.xml.adapter.dynamizer;

import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfStandardFileTimeseries;
import org.citygml4j.model.dynamizer.ADEPropertyOfStandardFileTimeseries;
import org.citygml4j.model.dynamizer.StandardFileTimeseries;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.basictypes.CodeAdapter;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElement(name = "StandardFileTimeseries", namespaceURI = CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE)
public class StandardFileTimeseriesAdapter extends AbstractAtomicTimeseriesAdapter<StandardFileTimeseries> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "AbstractGenericApplicationPropertyOfStandardFileTimeseries");

    @Override
    public StandardFileTimeseries createObject(QName name) throws ObjectBuildException {
        return new StandardFileTimeseries();
    }

    @Override
    public void buildChildObject(StandardFileTimeseries object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "fileLocation":
                    reader.getTextContent().ifPresent(object::setFileLocation);
                    return;
                case "fileType":
                    object.setFileType(reader.getObjectUsingBuilder(CodeAdapter.class));
                    return;
                case "mimeType":
                    object.setMimeType(reader.getObjectUsingBuilder(CodeAdapter.class));
                    return;
            }
        } else if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            buildADEProperty(object, name, reader);
            return;
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(StandardFileTimeseries object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!CityGMLBuilderHelper.addADEProperty(name, ADEPropertyOfStandardFileTimeseries.class, object.getADEPropertiesOfStandardFileTimeseries(),
                GenericADEPropertyOfStandardFileTimeseries::of, reader, substitutionGroup))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(StandardFileTimeseries object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "StandardFileTimeseries");
    }

    @Override
    public void writeChildElements(StandardFileTimeseries object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String dynamizerNamespace = CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE;

        if (object.getFileLocation() != null)
            writer.writeElement(Element.of(dynamizerNamespace, "fileLocation").addTextContent(object.getFileLocation()));

        if (object.getFileType() != null)
            writer.writeElementUsingSerializer(Element.of(dynamizerNamespace, "fileType"), object.getFileType(), CodeAdapter.class, namespaces);

        if (object.getMimeType() != null)
            writer.writeElementUsingSerializer(Element.of(dynamizerNamespace, "mimeType"), object.getMimeType(), CodeAdapter.class, namespaces);

        for (ADEPropertyOfStandardFileTimeseries<?> property : object.getADEPropertiesOfStandardFileTimeseries())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
