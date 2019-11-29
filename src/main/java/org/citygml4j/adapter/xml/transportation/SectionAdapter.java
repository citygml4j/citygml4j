package org.citygml4j.adapter.xml.transportation;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfSection;
import org.citygml4j.model.transportation.ADEPropertyOfSection;
import org.citygml4j.model.transportation.Section;
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

@XMLElement(name = "Section", namespaceURI = CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE)
public class SectionAdapter extends AbstractTransportationSpaceAdapter<Section> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE, "AbstractGenericApplicationPropertyOfSection");

    @Override
    public Section createObject(QName name) throws ObjectBuildException {
        return new Section();
    }

    @Override
    public void buildChildObject(Section object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE.equals(name.getNamespaceURI()) && "class".equals(name.getLocalPart())) {
            object.setClassifier(reader.getObjectUsingBuilder(CodeAdapter.class));
            return;
        } else if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            buildADEProperty(object, name, reader);
            return;
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(Section object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!CityGMLBuilderHelper.addADEProperty(name, ADEPropertyOfSection.class, object.getADEPropertiesOfSection(),
                GenericADEPropertyOfSection::of, reader, substitutionGroup))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(Section object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE, "Section");
    }

    @Override
    public void writeChildElements(Section object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        if (object.getClassifier() != null)
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE, "class"), object.getClassifier(), CodeAdapter.class, namespaces);

        for (ADEPropertyOfSection<?> property : object.getADEPropertiesOfSection())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
