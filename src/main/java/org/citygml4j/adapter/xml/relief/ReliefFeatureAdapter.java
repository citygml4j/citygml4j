package org.citygml4j.adapter.xml.relief;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.adapter.xml.core.AbstractSpaceBoundaryAdapter;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfReliefFeature;
import org.citygml4j.model.relief.ADEPropertyOfReliefFeature;
import org.citygml4j.model.relief.AbstractReliefComponentProperty;
import org.citygml4j.model.relief.ReliefFeature;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
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

@XMLElements({
        @XMLElement(name = "ReliefFeature", namespaceURI = CityGMLConstants.CITYGML_3_0_RELIEF_NAMESPACE),
        @XMLElement(name = "ReliefFeature", namespaceURI = CityGMLConstants.CITYGML_2_0_RELIEF_NAMESPACE),
        @XMLElement(name = "ReliefFeature", namespaceURI = CityGMLConstants.CITYGML_1_0_RELIEF_NAMESPACE)
})
public class ReliefFeatureAdapter extends AbstractSpaceBoundaryAdapter<ReliefFeature> {
    private final QName[] substitutionGroups = new QName[] {
            new QName(CityGMLConstants.CITYGML_3_0_RELIEF_NAMESPACE, "AbstractGenericApplicationPropertyOfReliefFeature"),
            new QName(CityGMLConstants.CITYGML_2_0_RELIEF_NAMESPACE, "_GenericApplicationPropertyOfReliefFeature"),
            new QName(CityGMLConstants.CITYGML_1_0_RELIEF_NAMESPACE, "_GenericApplicationPropertyOfReliefFeature")
    };

    @Override
    public ReliefFeature createObject(QName name) throws ObjectBuildException {
        return new ReliefFeature();
    }

    @Override
    public void buildChildObject(ReliefFeature object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isReliefNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "lod":
                    reader.getTextContent().ifInteger(object::setLod);
                    return;
                case "reliefComponent":
                    object.getReliefComponents().add(reader.getObjectUsingBuilder(AbstractReliefComponentPropertyAdapter.class));
                    return;
            }
        }

        if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            ObjectBuilder<ADEPropertyOfReliefFeature> builder = reader.getXMLObjects().getBuilder(name, ADEPropertyOfReliefFeature.class);
            if (builder != null)
                object.getADEPropertiesOfReliefFeature().add(reader.getObjectUsingBuilder(builder));
            else if (CityGMLBuilderHelper.createAsGenericADEProperty(name, reader, substitutionGroups))
                object.getADEPropertiesOfReliefFeature().add(GenericADEPropertyOfReliefFeature.of(reader.getDOMElement()));
        } else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(ReliefFeature object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLSerializerHelper.getReliefNamespace(namespaces), "ReliefFeature");
    }

    @Override
    public void writeChildElements(ReliefFeature object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String reliefNamespace = CityGMLSerializerHelper.getReliefNamespace(namespaces);

        writer.writeElement(Element.of(reliefNamespace, "lod").addTextContent(TextContent.ofInteger(object.getLod())));

        for (AbstractReliefComponentProperty property : object.getReliefComponents())
            writer.writeElementUsingSerializer(Element.of(reliefNamespace, "reliefComponent"), property, AbstractReliefComponentPropertyAdapter.class, namespaces);

        for (ADEPropertyOfReliefFeature property : object.getADEPropertiesOfReliefFeature())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
