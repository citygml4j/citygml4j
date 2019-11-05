package org.citygml4j.adapter.xml.relief;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfBreaklineRelief;
import org.citygml4j.model.relief.ADEPropertyOfBreaklineRelief;
import org.citygml4j.model.relief.BreaklineRelief;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.geometry.aggregates.MultiCurvePropertyAdapter;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "BreaklineRelief", namespaceURI = CityGMLConstants.CITYGML_3_0_RELIEF_NAMESPACE),
        @XMLElement(name = "BreaklineRelief", namespaceURI = CityGMLConstants.CITYGML_2_0_RELIEF_NAMESPACE),
        @XMLElement(name = "BreaklineRelief", namespaceURI = CityGMLConstants.CITYGML_1_0_RELIEF_NAMESPACE)
})
public class BreaklineReliefAdapter extends AbstractReliefComponentAdapter<BreaklineRelief> {
    private final QName[] substitutionGroups = new QName[] {
            new QName(CityGMLConstants.CITYGML_3_0_RELIEF_NAMESPACE, "AbstractGenericApplicationPropertyOfBreaklineRelief"),
            new QName(CityGMLConstants.CITYGML_2_0_RELIEF_NAMESPACE, "_GenericApplicationPropertyOfBreaklineRelief"),
            new QName(CityGMLConstants.CITYGML_1_0_RELIEF_NAMESPACE, "_GenericApplicationPropertyOfBreaklineRelief")
    };

    @Override
    public BreaklineRelief createObject(QName name) throws ObjectBuildException {
        return new BreaklineRelief();
    }

    @Override
    public void buildChildObject(BreaklineRelief object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isReliefNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "ridgeOrValleyLines":
                    object.setRidgeOrValleyLines(reader.getObjectUsingBuilder(MultiCurvePropertyAdapter.class));
                    return;
                case "breaklines":
                    object.setBreaklines(reader.getObjectUsingBuilder(MultiCurvePropertyAdapter.class));
                    return;
            }
        }

        if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            ObjectBuilder<ADEPropertyOfBreaklineRelief> builder = reader.getXMLObjects().getBuilder(name, ADEPropertyOfBreaklineRelief.class);
            if (builder != null)
                object.getADEPropertiesOfBreaklineRelief().add(reader.getObjectUsingBuilder(builder));
            else if (CityGMLBuilderHelper.createAsGenericADEProperty(name, reader, substitutionGroups))
                object.getADEPropertiesOfBreaklineRelief().add(GenericADEPropertyOfBreaklineRelief.of(reader.getDOMElement()));
        } else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(BreaklineRelief object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLSerializerHelper.getReliefNamespace(namespaces), "BreaklineRelief");
    }

    @Override
    public void writeChildElements(BreaklineRelief object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String reliefNamespace = CityGMLSerializerHelper.getReliefNamespace(namespaces);

        if (object.getRidgeOrValleyLines() != null)
            writer.writeElementUsingSerializer(Element.of(reliefNamespace, "ridgeOrValleyLines"), object.getRidgeOrValleyLines(), MultiCurvePropertyAdapter.class, namespaces);

        if (object.getBreaklines() != null)
            writer.writeElementUsingSerializer(Element.of(reliefNamespace, "breaklines"), object.getBreaklines(), MultiCurvePropertyAdapter.class, namespaces);

        for (ADEPropertyOfBreaklineRelief property : object.getADEPropertiesOfBreaklineRelief())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
