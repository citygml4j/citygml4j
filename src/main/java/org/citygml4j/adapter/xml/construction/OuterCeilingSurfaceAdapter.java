package org.citygml4j.adapter.xml.construction;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfOuterCeilingSurface;
import org.citygml4j.model.construction.ADEPropertyOfOuterCeilingSurface;
import org.citygml4j.model.construction.OuterCeilingSurface;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
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

@XMLElement(name = "OuterCeilingSurface", namespaceURI = CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE)
public class OuterCeilingSurfaceAdapter extends AbstractConstructionSurfaceAdapter<OuterCeilingSurface> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "AbstractGenericApplicationPropertyOfOuterCeilingSurface");

    @Override
    public OuterCeilingSurface createObject(QName name) throws ObjectBuildException {
        return new OuterCeilingSurface();
    }

    @Override
    public void buildChildObject(OuterCeilingSurface object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI()))
            buildADEProperty(object, name, reader);
        else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(OuterCeilingSurface object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!CityGMLBuilderHelper.addADEProperty(name, ADEPropertyOfOuterCeilingSurface.class, object.getADEPropertiesOfOuterCeilingSurface(),
                GenericADEPropertyOfOuterCeilingSurface::of, reader, substitutionGroup))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(OuterCeilingSurface object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "OuterCeilingSurface");
    }

    @Override
    public void writeChildElements(OuterCeilingSurface object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        for (ADEPropertyOfOuterCeilingSurface property : object.getADEPropertiesOfOuterCeilingSurface())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
