package org.citygml4j.adapter.xml.cityobjectgroup;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.adapter.xml.core.AbstractCityObjectPropertyAdapter;
import org.citygml4j.adapter.xml.core.AbstractLogicalSpaceAdapter;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfCityObjectGroup;
import org.citygml4j.model.cityobjectgroup.ADEPropertyOfCityObjectGroup;
import org.citygml4j.model.cityobjectgroup.CityObjectGroup;
import org.citygml4j.model.cityobjectgroup.RoleProperty;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.geometry.GeometryPropertyAdapter;
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
        @XMLElement(name = "CityObjectGroup", namespaceURI = CityGMLConstants.CITYGML_3_0_CITYOBJECTGROUP_NAMESPACE),
        @XMLElement(name = "CityObjectGroup", namespaceURI = CityGMLConstants.CITYGML_2_0_CITYOBJECTGROUP_NAMESPACE),
        @XMLElement(name = "CityObjectGroup", namespaceURI = CityGMLConstants.CITYGML_1_0_CITYOBJECTGROUP_NAMESPACE)
})
public class CityObjectGroupAdapter extends AbstractLogicalSpaceAdapter<CityObjectGroup> {
    private final QName[] substitutionGroups = new QName[]{
            new QName(CityGMLConstants.CITYGML_3_0_CITYOBJECTGROUP_NAMESPACE, "AbstractGenericApplicationPropertyOfCityObjectGroup"),
            new QName(CityGMLConstants.CITYGML_2_0_CITYOBJECTGROUP_NAMESPACE, "_GenericApplicationPropertyOfCityObjectGroup"),
            new QName(CityGMLConstants.CITYGML_1_0_CITYOBJECTGROUP_NAMESPACE, "_GenericApplicationPropertyOfCityObjectGroup")
    };

    @Override
    public CityObjectGroup createObject(QName name) throws ObjectBuildException {
        return new CityObjectGroup();
    }

    @Override
    public void buildChildObject(CityObjectGroup object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isCityObjectGroupNamespace(name.getNamespaceURI())) {
            if (CityGMLBuilderHelper.buildStandardObjectClassifier(object, name.getLocalPart(), reader))
                return;

            switch (name.getLocalPart()) {
                case "groupMember":
                    if (CityGMLConstants.CITYGML_3_0_CITYOBJECTGROUP_NAMESPACE.equals(name.getNamespaceURI()))
                        object.getGroupMembers().add(reader.getObjectUsingBuilder(RolePropertyAdapter.class));
                    else
                        object.getGroupMembers().add(reader.getObjectUsingBuilder(org.citygml4j.adapter.xml.deprecated.cityobjectgroup.RolePropertyAdapter.class));
                    return;
                case "parent":
                    object.setGroupParent(reader.getObjectUsingBuilder(AbstractCityObjectPropertyAdapter.class));
                    return;
                case "geometry":
                    object.getDeprecatedProperties().setGeometry(reader.getObjectUsingBuilder(GeometryPropertyAdapter.class));
                    return;
            }
        } else if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            buildADEProperty(object, name, reader);
            return;
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(CityObjectGroup object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!CityGMLBuilderHelper.addADEProperty(name, ADEPropertyOfCityObjectGroup.class, object.getADEPropertiesOfCityObjectGroup(),
                GenericADEPropertyOfCityObjectGroup::of, reader, substitutionGroups))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(CityObjectGroup object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLSerializerHelper.getCityObjectGroupNamespace(namespaces), "CityObjectGroup");
    }

    @Override
    public void writeChildElements(CityObjectGroup object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String cityObjectGroupNamespace = CityGMLSerializerHelper.getCityObjectGroupNamespace(namespaces);
        boolean isCityGML3 = CityGMLConstants.CITYGML_3_0_CITYOBJECTGROUP_NAMESPACE.equals(cityObjectGroupNamespace);

        CityGMLSerializerHelper.serializeStandardObjectClassifier(object, cityObjectGroupNamespace, namespaces, writer);

        for (RoleProperty property : object.getGroupMembers()) {
            if (isCityGML3)
                writer.writeElementUsingSerializer(Element.of(cityObjectGroupNamespace, "groupMember"), property, RolePropertyAdapter.class, namespaces);
            else
                writer.writeElementUsingSerializer(Element.of(cityObjectGroupNamespace, "groupMember"), property, org.citygml4j.adapter.xml.deprecated.cityobjectgroup.RolePropertyAdapter.class, namespaces);
        }

        if (object.getGroupParent() != null)
            writer.writeElementUsingSerializer(Element.of(cityObjectGroupNamespace, "parent"), object.getGroupParent(), AbstractCityObjectPropertyAdapter.class, namespaces);

        if (!isCityGML3 && object.getDeprecatedProperties().getGeometry() != null)
            writer.writeElementUsingSerializer(Element.of(cityObjectGroupNamespace, "geometry"), object.getDeprecatedProperties().getGeometry(), GeometryPropertyAdapter.class, namespaces);

        for (ADEPropertyOfCityObjectGroup<?> property : object.getADEPropertiesOfCityObjectGroup())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
