package org.citygml4j.adapter.xml.construction;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.adapter.xml.core.AbstractOccupiedSpaceAdapter;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfAbstractInstallation;
import org.citygml4j.model.construction.ADEPropertyOfAbstractInstallation;
import org.citygml4j.model.construction.AbstractInstallation;
import org.citygml4j.model.construction.RelationToConstruction;
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

public abstract class AbstractInstallationAdapter<T extends AbstractInstallation> extends AbstractOccupiedSpaceAdapter<T> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "AbstractGenericApplicationPropertyOfAbstractInstallation");

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE.equals(name.getNamespaceURI()) && "relationToConstruction".equals(name.getLocalPart())) {
            reader.getTextContent().ifPresent(v -> object.setRelationToConstruction(RelationToConstruction.fromValue(v)));
            return;
        }

        if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            ObjectBuilder<ADEPropertyOfAbstractInstallation> builder = reader.getXMLObjects().getBuilder(name, ADEPropertyOfAbstractInstallation.class);
            if (builder != null)
                object.getADEPropertiesOfAbstractInstallation().add(reader.getObjectUsingBuilder(builder));
            else if (CityGMLBuilderHelper.createAsGenericADEProperty(name, reader, substitutionGroup))
                object.getADEPropertiesOfAbstractInstallation().add(GenericADEPropertyOfAbstractInstallation.of(reader.getDOMElement()));
        } else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        if (namespaces.contains(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE)) {
            if (object.getRelationToConstruction() != null)
                writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "relationToConstruction").addTextContent(object.getRelationToConstruction().toValue()));

            for (ADEPropertyOfAbstractInstallation property : object.getADEPropertiesOfAbstractInstallation())
                CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
        }
    }
}
