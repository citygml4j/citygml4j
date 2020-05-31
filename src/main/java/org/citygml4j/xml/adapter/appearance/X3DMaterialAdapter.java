package org.citygml4j.xml.adapter.appearance;

import org.citygml4j.model.ade.generic.GenericADEOfX3DMaterial;
import org.citygml4j.model.appearance.ADEOfX3DMaterial;
import org.citygml4j.model.appearance.Color;
import org.citygml4j.model.appearance.GeometryReference;
import org.citygml4j.model.appearance.X3DMaterial;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
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
import org.xmlobjects.xml.TextContent;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "X3DMaterial", namespaceURI = CityGMLConstants.CITYGML_3_0_APPEARANCE_NAMESPACE),
        @XMLElement(name = "X3DMaterial", namespaceURI = CityGMLConstants.CITYGML_2_0_APPEARANCE_NAMESPACE),
        @XMLElement(name = "X3DMaterial", namespaceURI = CityGMLConstants.CITYGML_1_0_APPEARANCE_NAMESPACE)
})
public class X3DMaterialAdapter extends AbstractSurfaceDataAdapter<X3DMaterial> {
    private final QName[] substitutionGroups = new QName[]{
            new QName(CityGMLConstants.CITYGML_2_0_APPEARANCE_NAMESPACE, "_GenericApplicationPropertyOfX3DMaterial"),
            new QName(CityGMLConstants.CITYGML_1_0_APPEARANCE_NAMESPACE, "_GenericApplicationPropertyOfX3DMaterial")
    };

    @Override
    public X3DMaterial createObject(QName name) throws ObjectBuildException {
        return new X3DMaterial();
    }

    @Override
    public void buildChildObject(X3DMaterial object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isAppearanceNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "ambientIntensity":
                    reader.getTextContent().ifDouble(object::setAmbientIntensity);
                    return;
                case "diffuseColor":
                    reader.getTextContent().ifDoubleList(v -> object.setDiffuseColor(Color.fromList(v)));
                    return;
                case "emissiveColor":
                    reader.getTextContent().ifDoubleList(v -> object.setEmissiveColor(Color.fromList(v)));
                    return;
                case "specularColor":
                    reader.getTextContent().ifDoubleList(v -> object.setSpecularColor(Color.fromList(v)));
                    return;
                case "shininess":
                    reader.getTextContent().ifDouble(object::setShininess);
                    return;
                case "transparency":
                    reader.getTextContent().ifDouble(object::setTransparency);
                    return;
                case "isSmooth":
                    reader.getTextContent().ifBoolean(object::setIsSmooth);
                    return;
                case "target":
                    reader.getTextContent().ifPresent(v -> object.getTargets().add(new GeometryReference(v)));
                    return;
                case "adeOfX3DMaterial":
                    ADEBuilderHelper.addADEContainer(ADEOfX3DMaterial.class, object.getADEOfX3DMaterial(), GenericADEOfX3DMaterial::new, reader);
                    return;
            }
        } else if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            buildADEProperty(object, name, reader);
            return;
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(X3DMaterial object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!ADEBuilderHelper.addADEContainer(name, ADEOfX3DMaterial.class, object.getADEOfX3DMaterial(),
                GenericADEOfX3DMaterial::new, reader, substitutionGroups))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(X3DMaterial object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLSerializerHelper.getAppearanceNamespace(namespaces), "X3DMaterial");
    }

    @Override
    public void writeChildElements(X3DMaterial object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String appearanceNamespace = CityGMLSerializerHelper.getAppearanceNamespace(namespaces);
        boolean isCityGML3 = CityGMLConstants.CITYGML_3_0_APPEARANCE_NAMESPACE.equalsIgnoreCase(appearanceNamespace);

        if (object.isSetAmbientIntensity())
            writer.writeElement(Element.of(appearanceNamespace, "ambientIntensity").addTextContent(TextContent.ofDouble(object.getAmbientIntensity())));

        if (object.isSetDiffuseColor())
            writer.writeElement(Element.of(appearanceNamespace, "diffuseColor").addTextContent(TextContent.ofDoubleList(object.getDiffuseColor().toList())));

        if (object.isSetEmissiveColor())
            writer.writeElement(Element.of(appearanceNamespace, "emissiveColor").addTextContent(TextContent.ofDoubleList(object.getEmissiveColor().toList())));

        if (object.isSetSpecularColor())
            writer.writeElement(Element.of(appearanceNamespace, "specularColor").addTextContent(TextContent.ofDoubleList(object.getSpecularColor().toList())));

        if (object.isSetShininess())
            writer.writeElement(Element.of(appearanceNamespace, "shininess").addTextContent(TextContent.ofDouble(object.getShininess())));

        if (object.isSetTransparency())
            writer.writeElement(Element.of(appearanceNamespace, "transparency").addTextContent(TextContent.ofDouble(object.getTransparency())));

        if (object.isSetIsSmooth())
            writer.writeElement(Element.of(appearanceNamespace, "isSmooth").addTextContent(TextContent.ofBoolean(object.getIsSmooth())));

        for (GeometryReference target : object.getTargets()) {
            if (target != null)
                writer.writeElement(Element.of(appearanceNamespace, "target").addTextContent(target.getURI()));
        }

        for (ADEOfX3DMaterial container : object.getADEOfX3DMaterial())
            ADESerializerHelper.writeADEContainer(isCityGML3 ? Element.of(appearanceNamespace, "adeOfX3DMaterial") : null, container, namespaces, writer);
    }
}
