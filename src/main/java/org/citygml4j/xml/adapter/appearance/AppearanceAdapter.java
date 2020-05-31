package org.citygml4j.xml.adapter.appearance;

import org.citygml4j.model.ade.generic.GenericADEOfAppearance;
import org.citygml4j.model.appearance.ADEOfAppearance;
import org.citygml4j.model.appearance.AbstractSurfaceDataProperty;
import org.citygml4j.model.appearance.Appearance;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.citygml4j.xml.adapter.core.AbstractAppearanceAdapter;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
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
public class AppearanceAdapter extends AbstractAppearanceAdapter<Appearance> {
    private final QName[] substitutionGroups = new QName[]{
            new QName(CityGMLConstants.CITYGML_2_0_APPEARANCE_NAMESPACE, "_GenericApplicationPropertyOfAppearance"),
            new QName(CityGMLConstants.CITYGML_1_0_APPEARANCE_NAMESPACE, "_GenericApplicationPropertyOfAppearance")
    };

    @Override
    public Appearance createObject(QName name) throws ObjectBuildException {
        return new Appearance();
    }

    @Override
    public void buildChildObject(Appearance object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isAppearanceNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "theme":
                    reader.getTextContent().ifPresent(object::setTheme);
                    return;
                case "surfaceData":
                case "surfaceDataMember":
                    object.getSurfaceData().add(reader.getObjectUsingBuilder(AbstractSurfaceDataPropertyAdapter.class));
                    return;
                case "adeOfAppearance":
                    ADEBuilderHelper.addADEContainer(ADEOfAppearance.class, object.getADEOfAppearance(), GenericADEOfAppearance::new, reader);
                    return;
            }
        } else if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            buildADEProperty(object, name, reader);
            return;
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(Appearance object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!ADEBuilderHelper.addADEContainer(name, ADEOfAppearance.class, object.getADEOfAppearance(),
                GenericADEOfAppearance::new, reader, substitutionGroups))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(Appearance object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLSerializerHelper.getAppearanceNamespace(namespaces), "Appearance");
    }

    @Override
    public void writeChildElements(Appearance object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String appearanceNamespace = CityGMLSerializerHelper.getAppearanceNamespace(namespaces);
        boolean isCityGML3 = CityGMLConstants.CITYGML_3_0_APPEARANCE_NAMESPACE.equalsIgnoreCase(appearanceNamespace);

        if (object.getTheme() != null)
            writer.writeElement(Element.of(appearanceNamespace, "theme").addTextContent(object.getTheme()));

        for (AbstractSurfaceDataProperty property : object.getSurfaceData())
            writer.writeElementUsingSerializer(
                    Element.of(appearanceNamespace, isCityGML3 ? "surfaceData" : "surfaceDataMember"),
                    property, AbstractSurfaceDataPropertyAdapter.class, namespaces);

        for (ADEOfAppearance container : object.getADEOfAppearance())
            ADESerializerHelper.writeADEContainer(isCityGML3 ? Element.of(appearanceNamespace, "adeOfAppearance") : null, container, namespaces, writer);
    }
}
