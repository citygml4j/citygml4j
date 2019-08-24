package org.citygml4j.adapter.xml.core;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfAbstractSpace;
import org.citygml4j.model.core.ADEPropertyOfAbstractSpace;
import org.citygml4j.model.core.AbstractSpace;
import org.citygml4j.model.core.QualifiedAreaProperty;
import org.citygml4j.model.core.QualifiedVolumeProperty;
import org.citygml4j.model.core.SpaceType;
import org.citygml4j.util.CityGMLConstants;
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

public abstract class AbstractSpaceAdapter<T extends AbstractSpace<?>> extends AbstractCityObjectAdapter<T> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE, "AbstractGenericApplicationPropertyOfAbstractSpace");

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "spaceType":
                    reader.getTextContent().ifPresent(v -> object.setSpaceType(SpaceType.fromValue(v)));
                    return;
                case "volume":
                    object.getVolumes().add(reader.getObjectUsingBuilder(QualifiedVolumePropertyAdapter.class));
                    return;
                case "area":
                    object.getAreas().add(reader.getObjectUsingBuilder(QualifiedAreaPropertyAdapter.class));
                    return;
            }
        }

        ObjectBuilder<ADEPropertyOfAbstractSpace> builder = reader.getXMLObjects().getBuilder(name, ADEPropertyOfAbstractSpace.class);
        if (builder != null)
            object.getADEPropertiesOfAbstractSpace().add(reader.getObjectUsingBuilder(builder));
        else if (CityGMLBuilderHelper.createAsGenericADEProperty(name, reader, substitutionGroup))
            object.getADEPropertiesOfAbstractSpace().add(GenericADEPropertyOfAbstractSpace.of(reader.getDOMElement()));
        else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        if (object.getSpaceType() != null)
            writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE, "spaceType").addTextContent(object.getSpaceType().toValue()));

        for (QualifiedVolumeProperty property : object.getVolumes())
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE, "volume"), property, QualifiedVolumePropertyAdapter.class, namespaces);

        for (QualifiedAreaProperty property : object.getAreas())
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE, "area"), property, QualifiedAreaPropertyAdapter.class, namespaces);
    }
}
