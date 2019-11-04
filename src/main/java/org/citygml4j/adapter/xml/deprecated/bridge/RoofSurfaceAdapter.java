package org.citygml4j.adapter.xml.deprecated.bridge;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfRoofSurface;
import org.citygml4j.model.construction.ADEPropertyOfRoofSurface;
import org.citygml4j.model.construction.RoofSurface;
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

@XMLElement(name = "RoofSurface", namespaceURI = CityGMLConstants.CITYGML_2_0_BRIDGE_NAMESPACE)
public class RoofSurfaceAdapter extends AbstractBoundarySurfaceAdapter<RoofSurface> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_2_0_BRIDGE_NAMESPACE, "_GenericApplicationPropertyOfRoofSurface");

    @Override
    public RoofSurface createObject(QName name) throws ObjectBuildException {
        return new RoofSurface();
    }

    @Override
    public void buildChildObject(RoofSurface object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            ObjectBuilder<ADEPropertyOfRoofSurface> builder = reader.getXMLObjects().getBuilder(name, ADEPropertyOfRoofSurface.class);
            if (builder != null)
                object.getADEPropertiesOfRoofSurface().add(reader.getObjectUsingBuilder(builder));
            else if (CityGMLBuilderHelper.createAsGenericADEProperty(name, reader, substitutionGroup))
                object.getADEPropertiesOfRoofSurface().add(GenericADEPropertyOfRoofSurface.of(reader.getDOMElement()));
        } else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(RoofSurface object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLSerializerHelper.getBridgeNamespace(namespaces), "RoofSurface");
    }

    @Override
    public void writeChildElements(RoofSurface object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        for (ADEPropertyOfRoofSurface property : object.getADEPropertiesOfRoofSurface())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
