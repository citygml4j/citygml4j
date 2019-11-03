package org.citygml4j.adapter.xml.generics;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.adapter.xml.core.AbstractThematicSurfaceAdapter;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfGenericThematicSurface;
import org.citygml4j.model.generics.ADEPropertyOfGenericThematicSurface;
import org.citygml4j.model.generics.GenericThematicSurface;
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

@XMLElement(name = "GenericThematicSurface", namespaceURI = CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE)
public class GenericThematicSurfaceAdapter extends AbstractThematicSurfaceAdapter<GenericThematicSurface> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE, "AbstractGenericApplicationPropertyOfGenericThematicSurface");

    @Override
    public GenericThematicSurface createObject(QName name) throws ObjectBuildException {
        return new GenericThematicSurface();
    }

    @Override
    public void buildChildObject(GenericThematicSurface object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            ObjectBuilder<ADEPropertyOfGenericThematicSurface> builder = reader.getXMLObjects().getBuilder(name, ADEPropertyOfGenericThematicSurface.class);
            if (builder != null)
                object.getADEPropertiesOfGenericThematicSurface().add(reader.getObjectUsingBuilder(builder));
            else if (CityGMLBuilderHelper.createAsGenericADEProperty(name, reader, substitutionGroup))
                object.getADEPropertiesOfGenericThematicSurface().add(GenericADEPropertyOfGenericThematicSurface.of(reader.getDOMElement()));
        } else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(GenericThematicSurface object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE, "GenericThematicSurface");
    }

    @Override
    public void writeChildElements(GenericThematicSurface object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        for (ADEPropertyOfGenericThematicSurface property : object.getADEPropertiesOfGenericThematicSurface())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
