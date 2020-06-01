package org.citygml4j.xml.adapter.deprecated.core;

import org.citygml4j.model.ade.generic.GenericADEOfCityModel;
import org.citygml4j.model.core.ADEOfCityModel;
import org.citygml4j.model.core.AbstractAppearanceProperty;
import org.citygml4j.model.core.AbstractCityObjectProperty;
import org.citygml4j.model.core.AbstractFeature;
import org.citygml4j.model.core.AbstractFeatureProperty;
import org.citygml4j.model.core.CityModel;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.citygml4j.xml.adapter.core.AbstractAppearancePropertyAdapter;
import org.citygml4j.xml.adapter.core.AbstractCityObjectPropertyAdapter;
import org.citygml4j.xml.adapter.core.AbstractFeatureAdapter;
import org.citygml4j.xml.adapter.core.AbstractFeaturePropertyAdapter;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.GMLBuilderHelper;
import org.xmlobjects.gml.adapter.feature.FeatureArrayPropertyAdapter;
import org.xmlobjects.gml.model.common.GenericElement;
import org.xmlobjects.gml.model.feature.FeatureArrayProperty;
import org.xmlobjects.gml.util.GMLConstants;
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
        @XMLElement(name = "CityModel", namespaceURI = CityGMLConstants.CITYGML_2_0_CORE_NAMESPACE),
        @XMLElement(name = "CityModel", namespaceURI = CityGMLConstants.CITYGML_1_0_CORE_NAMESPACE)
})
public class CityModelAdapter extends AbstractFeatureAdapter<CityModel> {
    private final QName[] substitutionGroups = new QName[]{
            new QName(CityGMLConstants.CITYGML_2_0_CORE_NAMESPACE, "_GenericApplicationPropertyOfCityModel"),
            new QName(CityGMLConstants.CITYGML_1_0_CORE_NAMESPACE, "_GenericApplicationPropertyOfCityModel")
    };

    @Override
    public CityModel createObject(QName name) throws ObjectBuildException {
        return new CityModel();
    }

    @Override
    public void buildChildObject(CityModel object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isCoreNamespace(name.getNamespaceURI()) && "cityObjectMember".equals(name.getLocalPart())) {
            object.getCityObjectMembers().add(reader.getObjectUsingBuilder(AbstractCityObjectPropertyAdapter.class));
        } else if (CityGMLBuilderHelper.isAppearanceNamespace(name.getNamespaceURI()) && "appearanceMember".equals(name.getLocalPart())) {
            object.getAppearanceMembers().add(reader.getObjectUsingBuilder(AbstractAppearancePropertyAdapter.class));
        } else if (GMLBuilderHelper.isGMLNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "featureMember":
                    object.getFeatureMembers().add(reader.getObjectUsingBuilder(AbstractFeaturePropertyAdapter.class));
                    break;
                case "featureMembers":
                    FeatureArrayProperty<?> featureMembers = reader.getObjectUsingBuilder(FeatureArrayPropertyAdapter.class);
                    for (org.xmlobjects.gml.model.feature.AbstractFeature feature : featureMembers.getObjects()) {
                        if (feature instanceof AbstractFeature)
                            object.getFeatureMembers().add(new AbstractFeatureProperty((AbstractFeature) feature));
                    }

                    for (GenericElement element : featureMembers.getGenericElements())
                        object.getFeatureMembers().add(new AbstractFeatureProperty(element));
                    break;
                default:
                    super.buildChildObject(object, name, attributes, reader);
                    break;
            }
        } else
            buildADEProperty(object, name, reader);
    }

    @Override
    public void buildADEProperty(CityModel object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!ADEBuilderHelper.addADEContainer(name, ADEOfCityModel.class, object.getADEOfCityModel(),
                GenericADEOfCityModel::of, reader, substitutionGroups))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(CityModel object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLSerializerHelper.getCoreNamespace(namespaces), "CityModel");
    }

    @Override
    public void writeChildElements(CityModel object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String coreNamespace = CityGMLSerializerHelper.getCoreNamespace(namespaces);

        for (AbstractCityObjectProperty property : object.getCityObjectMembers())
            writer.writeElementUsingSerializer(Element.of(coreNamespace, "cityObjectMember"), property, AbstractCityObjectPropertyAdapter.class, namespaces);

        if (!object.getAppearanceMembers().isEmpty()) {
            String appearanceNamespace = CityGMLSerializerHelper.getAppearanceNamespace(namespaces);
            for (AbstractAppearanceProperty property : object.getAppearanceMembers())
                writer.writeElementUsingSerializer(Element.of(appearanceNamespace, "appearanceMember"), property, AbstractAppearancePropertyAdapter.class, namespaces);
        }

        for (AbstractFeatureProperty property : object.getFeatureMembers())
            writer.writeElementUsingSerializer(Element.of(GMLConstants.GML_3_1_NAMESPACE, "featureMember"), property, AbstractFeaturePropertyAdapter.class, namespaces);

        for (ADEOfCityModel container : object.getADEOfCityModel())
            ADESerializerHelper.writeADEProperty(container, namespaces, writer);
    }
}
