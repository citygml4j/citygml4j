package org.citygml4j.adapter.xml.appearance;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.adapter.xml.core.AbstractFeatureWithLifespanAdapter;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfAppearance;
import org.citygml4j.model.appearance.ADEPropertyOfAppearance;
import org.citygml4j.model.appearance.AbstractSurfaceDataProperty;
import org.citygml4j.model.appearance.Appearance;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.feature.AbstractFeatureAdapter;
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
        @XMLElement(name = "Appearance", namespaceURI = CityGMLConstants.CITYGML_3_0_APPEARANCE_NAMESPACE),
        @XMLElement(name = "Appearance", namespaceURI = CityGMLConstants.CITYGML_2_0_APPEARANCE_NAMESPACE),
        @XMLElement(name = "Appearance", namespaceURI = CityGMLConstants.CITYGML_1_0_APPEARANCE_NAMESPACE)
})
public class AppearanceAdapter extends AbstractFeatureWithLifespanAdapter<Appearance> {
    private final QName[] substitutionGroups = new QName[] {
            new QName(CityGMLConstants.CITYGML_3_0_APPEARANCE_NAMESPACE, "AbstractGenericApplicationPropertyOfAppearance"),
            new QName(CityGMLConstants.CITYGML_2_0_APPEARANCE_NAMESPACE, "_GenericApplicationPropertyOfAppearance"),
            new QName(CityGMLConstants.CITYGML_1_0_APPEARANCE_NAMESPACE, "_GenericApplicationPropertyOfAppearance"),
    };

    @Override
    public Appearance createObject(QName name) {
        return new Appearance();
    }

    @Override
    public void buildChildObject(Appearance object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isCityGMLAppearanceNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "theme":
                    reader.getTextContent().ifPresent(object::setTheme);
                    return;
                case "surfaceData":
                case "surfaceDataMember":
                    object.getSurfaceData().add(reader.getObjectUsingBuilder(AbstractSurfaceDataPropertyAdapter.class));
                    return;
            }
        }

        if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            ObjectBuilder<ADEPropertyOfAppearance> builder = reader.getXMLObjects().getBuilder(name, ADEPropertyOfAppearance.class);
            if (builder != null)
                object.getADEPropertiesOfAppearance().add(reader.getObjectUsingBuilder(builder));
            else if (CityGMLBuilderHelper.createAsGenericADEProperty(name, reader, substitutionGroups))
                object.getADEPropertiesOfAppearance().add(GenericADEPropertyOfAppearance.of(reader.getDOMElement()));
        } else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(Appearance object, Namespaces namespaces) {
        return Element.of(CityGMLSerializerHelper.getAppearanceNamespace(namespaces), "Appearance");
    }

    @Override
    public void writeChildElements(Appearance object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String appearanceNamespace = CityGMLSerializerHelper.getAppearanceNamespace(namespaces);

        if (object.getTheme() != null)
            writer.writeElement(Element.of(appearanceNamespace, "theme").addTextContent(object.getTheme()));

        for (AbstractSurfaceDataProperty property : object.getSurfaceData())
            writer.writeElementUsingSerializer(
                    Element.of(appearanceNamespace, CityGMLConstants.CITYGML_3_0_APPEARANCE_NAMESPACE.equals(appearanceNamespace) ? "surfaceData" : "surfaceDataMember"),
                    property, AbstractSurfaceDataPropertyAdapter.class, namespaces);

        for (ADEPropertyOfAppearance property : object.getADEPropertiesOfAppearance())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
