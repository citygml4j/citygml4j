package org.citygml4j.xml.adapter.transportation;

import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.core.AbstractThematicSurfaceAdapter;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfMarking;
import org.citygml4j.model.transportation.ADEPropertyOfMarking;
import org.citygml4j.model.transportation.Marking;
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

@XMLElement(name = "Marking", namespaceURI = CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE)
public class MarkingAdapter extends AbstractThematicSurfaceAdapter<Marking> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE, "AbstractGenericApplicationPropertyOfMarking");

    @Override
    public Marking createObject(QName name) throws ObjectBuildException {
        return new Marking();
    }

    @Override
    public void buildChildObject(Marking object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
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
    public void buildADEProperty(Marking object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!CityGMLBuilderHelper.addADEProperty(name, ADEPropertyOfMarking.class, object.getADEPropertiesOfMarking(),
                GenericADEPropertyOfMarking::of, reader, substitutionGroup))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(Marking object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE, "Marking");
    }

    @Override
    public void writeChildElements(Marking object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        if (object.getClassifier() != null)
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE, "class"), object.getClassifier(), CodeAdapter.class, namespaces);

        for (ADEPropertyOfMarking<?> property : object.getADEPropertiesOfMarking())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
