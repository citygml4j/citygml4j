package org.citygml4j.adapter.xml.versioning;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.adapter.xml.core.AbstractFeatureWithLifespanPropertyAdapter;
import org.citygml4j.adapter.xml.core.AbstractVersionAdapter;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfVersion;
import org.citygml4j.model.core.AbstractFeatureWithLifespanProperty;
import org.citygml4j.model.versioning.ADEPropertyOfVersion;
import org.citygml4j.model.versioning.Version;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
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

import javax.xml.namespace.QName;

@XMLElement(name = "Version", namespaceURI = CityGMLConstants.CITYGML_3_0_VERSIONING_NAMESPACE)
public class VersionAdapter extends AbstractVersionAdapter<Version> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_3_0_VERSIONING_NAMESPACE, "AbstractGenericApplicationPropertyOfVersion");

    @Override
    public Version createObject(QName name) throws ObjectBuildException {
        return new Version();
    }

    @Override
    public void buildChildObject(Version object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_VERSIONING_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "tag":
                    reader.getTextContent().ifPresent(object.getTags()::add);
                    return;
                case "versionMember":
                    object.getVersionMembers().add(reader.getObjectUsingBuilder(AbstractFeatureWithLifespanPropertyAdapter.class));
                    return;
            }
        }

        if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            ObjectBuilder<ADEPropertyOfVersion> builder = reader.getXMLObjects().getBuilder(name, ADEPropertyOfVersion.class);
            if (builder != null)
                object.getADEPropertiesOfVersion().add(reader.getObjectUsingBuilder(builder));
            else if (CityGMLBuilderHelper.createAsGenericADEProperty(name, reader, substitutionGroup))
                object.getADEPropertiesOfVersion().add(GenericADEPropertyOfVersion.of(reader.getDOMElement()));
        } else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(Version object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_VERSIONING_NAMESPACE, "Version");
    }

    @Override
    public void writeChildElements(Version object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        for (String tag : object.getTags())
            writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_VERSIONING_NAMESPACE, "tag").addTextContent(tag));

        for (AbstractFeatureWithLifespanProperty property : object.getVersionMembers())
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_VERSIONING_NAMESPACE, "versionMember"), property, AbstractFeatureWithLifespanPropertyAdapter.class, namespaces);

        for (ADEPropertyOfVersion property : object.getADEPropertiesOfVersion())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
