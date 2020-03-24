package org.citygml4j.xml.adapter.core;

import org.citygml4j.model.ade.generic.GenericADEPropertyOfAbstractFeatureWithLifespan;
import org.citygml4j.model.core.ADEPropertyOfAbstractFeatureWithLifespan;
import org.citygml4j.model.core.AbstractFeatureWithLifespan;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.ade.ADEPropertyBuilder;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.GMLBuilderHelper;
import org.xmlobjects.gml.adapter.feature.AbstractFeatureAdapter;
import org.xmlobjects.gml.model.common.GenericElement;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;
import org.xmlobjects.xml.TextContent;

import javax.xml.namespace.QName;

public abstract class AbstractFeatureWithLifespanAdapter<T extends AbstractFeatureWithLifespan> extends AbstractFeatureAdapter<T> implements ADEPropertyBuilder<T> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE, "AbstractGenericApplicationPropertyOfAbstractFeatureWithLifespan");

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isCoreNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "creationDate":
                    if (CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE.equals(name.getNamespaceURI()))
                        reader.getTextContent().ifDateTime(object::setCreationDate);
                    else
                        reader.getTextContent().ifDate(object::setCreationDate);
                    break;
                case "terminationDate":
                    if (CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE.equals(name.getNamespaceURI()))
                        reader.getTextContent().ifDateTime(object::setTerminationDate);
                    else
                        reader.getTextContent().ifDate(object::setTerminationDate);
                    break;
                case "validFrom":
                    reader.getTextContent().ifDateTime(object::setValidFrom);
                    break;
                case "validTo":
                    reader.getTextContent().ifDateTime(object::setValidTo);
                    break;
            }
        } else if (GMLBuilderHelper.isGMLNamespace(name.getNamespaceURI()))
            super.buildChildObject(object, name, attributes, reader);
        else
            buildADEProperty(object, name, reader);
    }

    @Override
    public void buildADEProperty(T object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!CityGMLBuilderHelper.addADEProperty(name, ADEPropertyOfAbstractFeatureWithLifespan.class, object.getADEPropertiesOfAbstractFeatureWithLifespan(),
                GenericADEPropertyOfAbstractFeatureWithLifespan::of, reader, substitutionGroup))
            object.getGenericProperties().add(GenericElement.of(reader.getDOMElement()));
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String coreNamespace = CityGMLSerializerHelper.getCoreNamespace(namespaces);

        if (object.getCreationDate() != null) {
            TextContent creationDate = CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE.equals(coreNamespace) ?
                    TextContent.ofDateTime(object.getCreationDate()) :
                    TextContent.ofDate(object.getCreationDate());
            writer.writeElement(Element.of(coreNamespace, "creationDate").addTextContent(creationDate));
        }

        if (object.getTerminationDate() != null) {
            TextContent terminationDate = CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE.equals(coreNamespace) ?
                    TextContent.ofDateTime(object.getTerminationDate()) :
                    TextContent.ofDate(object.getTerminationDate());
            writer.writeElement(Element.of(coreNamespace, "terminationDate").addTextContent(terminationDate));
        }

        if (CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE.equals(coreNamespace)) {
            if (object.getValidFrom() != null)
                writer.writeElement(Element.of(coreNamespace, "validFrom").addTextContent(TextContent.ofDateTime(object.getValidFrom())));

            if (object.getValidTo() != null)
                writer.writeElement(Element.of(coreNamespace, "validTo").addTextContent(TextContent.ofDateTime(object.getValidTo())));

            for (ADEPropertyOfAbstractFeatureWithLifespan<?> property : object.getADEPropertiesOfAbstractFeatureWithLifespan())
                CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
        }
    }
}
