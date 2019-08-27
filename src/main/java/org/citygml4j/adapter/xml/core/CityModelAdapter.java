package org.citygml4j.adapter.xml.core;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.adapter.xml.appearance.AppearancePropertyAdapter;
import org.citygml4j.adapter.xml.versioning.VersionPropertyAdapter;
import org.citygml4j.adapter.xml.versioning.VersionTransitionPropertyAdapter;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfCityModel;
import org.citygml4j.model.appearance.AppearanceProperty;
import org.citygml4j.model.core.ADEPropertyOfCityModel;
import org.citygml4j.model.core.AbstractCityObjectProperty;
import org.citygml4j.model.core.CityModel;
import org.citygml4j.model.versioning.VersionProperty;
import org.citygml4j.model.versioning.VersionTransitionProperty;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.feature.FeaturePropertyAdapter;
import org.xmlobjects.gml.model.feature.FeatureProperty;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElement(name = "CityModel", namespaceURI = CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE)
public class CityModelAdapter extends AbstractFeatureWithLifespanAdapter<CityModel> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE, "AbstractGenericApplicationPropertyOfCityModel");

    @Override
    public CityModel createObject(QName name) {
        return new CityModel();
    }

    @Override
    public void buildChildObject(CityModel object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "cityObjectMember":
                    object.getCityObjectMembers().add(reader.getObjectUsingBuilder(AbstractCityObjectPropertyAdapter.class));
                    return;
                case "appearanceMember":
                    object.getAppearanceMembers().add(reader.getObjectUsingBuilder(AppearancePropertyAdapter.class));
                    return;
                case "versionMember":
                    object.getVersionMembers().add(reader.getObjectUsingBuilder(VersionPropertyAdapter.class));
                    return;
                case "versionTransitionMember":
                    object.getVersionTransitionMembers().add(reader.getObjectUsingBuilder(VersionTransitionPropertyAdapter.class));
                    return;
                case "featureMember":
                    object.getFeatureMembers().add(reader.getObjectUsingBuilder(FeaturePropertyAdapter.class));
                    return;
            }
        }

        ObjectBuilder<ADEPropertyOfCityModel> builder = reader.getXMLObjects().getBuilder(name, ADEPropertyOfCityModel.class);
        if (builder != null)
            object.getADEPropertiesOfCityModel().add(reader.getObjectUsingBuilder(builder));
        else if (CityGMLBuilderHelper.createAsGenericADEProperty(name, reader, substitutionGroup))
            object.getADEPropertiesOfCityModel().add(GenericADEPropertyOfCityModel.of(reader.getDOMElement()));
        else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(CityModel object, Namespaces namespaces) {
        return Element.of(CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE, "CityModel");
    }

    @Override
    public void writeChildElements(CityModel object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        for (AbstractCityObjectProperty property : object.getCityObjectMembers())
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE, "cityObjectMember"), property, AbstractCityObjectPropertyAdapter.class, namespaces);

        for (AppearanceProperty property : object.getAppearanceMembers())
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE, "appearanceMember"), property, AppearancePropertyAdapter.class, namespaces);

        for (VersionProperty property : object.getVersionMembers())
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE, "versionMember"), property, VersionPropertyAdapter.class, namespaces);

        for (VersionTransitionProperty property : object.getVersionTransitionMembers())
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE, "versionTransitionMember"), property, VersionTransitionPropertyAdapter.class, namespaces);

        for (FeatureProperty property : object.getFeatureMembers())
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE, "featureMember"), property, FeaturePropertyAdapter.class, namespaces);

        for (ADEPropertyOfCityModel property : object.getADEPropertiesOfCityModel())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
