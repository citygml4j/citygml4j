package org.citygml4j.xml.adapter.versioning;

import org.citygml4j.model.ade.generic.GenericADEPropertyOfVersionTransition;
import org.citygml4j.model.versioning.ADEPropertyOfVersionTransition;
import org.citygml4j.model.versioning.TransactionProperty;
import org.citygml4j.model.versioning.TransitionValue;
import org.citygml4j.model.versioning.VersionTransition;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.core.AbstractVersionTransitionAdapter;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.builder.ObjectBuildException;
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

@XMLElement(name = "VersionTransition", namespaceURI = CityGMLConstants.CITYGML_3_0_VERSIONING_NAMESPACE)
public class VersionTransitionAdapter extends AbstractVersionTransitionAdapter<VersionTransition> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_3_0_VERSIONING_NAMESPACE, "AbstractGenericApplicationPropertyOfVersionTransition");

    @Override
    public VersionTransition createObject(QName name) throws ObjectBuildException {
        return new VersionTransition();
    }

    @Override
    public void buildChildObject(VersionTransition object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_VERSIONING_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "reason":
                    reader.getTextContent().ifPresent(object::setReason);
                    return;
                case "clonePredecessor":
                    reader.getTextContent().ifBoolean(object::setClonePredecessor);
                    return;
                case "type":
                    reader.getTextContent().ifPresent(v -> object.setType(TransitionValue.fromValue(v)));
                    return;
                case "from":
                    object.setFrom(reader.getObjectUsingBuilder(VersionPropertyAdapter.class));
                    return;
                case "to":
                    object.setTo(reader.getObjectUsingBuilder(VersionPropertyAdapter.class));
                    return;
                case "transaction":
                    object.getTransactions().add(reader.getObjectUsingBuilder(TransactionPropertyAdapter.class));
                    return;
            }
        } else if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            buildADEProperty(object, name, reader);
            return;
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(VersionTransition object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!CityGMLBuilderHelper.addADEProperty(name, ADEPropertyOfVersionTransition.class, object.getADEPropertiesOfVersionTransition(),
                GenericADEPropertyOfVersionTransition::of, reader, substitutionGroup))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(VersionTransition object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_VERSIONING_NAMESPACE, "VersionTransition");
    }

    @Override
    public void writeChildElements(VersionTransition object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        if (object.getReason() != null)
            writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_VERSIONING_NAMESPACE, "reason").addTextContent(object.getReason()));

        writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_VERSIONING_NAMESPACE, "clonePredecessor").addTextContent(TextContent.ofBoolean(object.isClonePredecessor())));

        if (object.getType() != null)
            writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_VERSIONING_NAMESPACE, "type").addTextContent(object.getType().toValue()));

        if (object.getFrom() != null)
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_VERSIONING_NAMESPACE, "from"), object.getFrom(), VersionPropertyAdapter.class, namespaces);

        if (object.getTo() != null)
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_VERSIONING_NAMESPACE, "to"), object.getTo(), VersionPropertyAdapter.class, namespaces);

        for (TransactionProperty property : object.getTransactions())
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_VERSIONING_NAMESPACE, "transaction"), property, TransactionPropertyAdapter.class, namespaces);

        for (ADEPropertyOfVersionTransition<?> property : object.getADEPropertiesOfVersionTransition())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
