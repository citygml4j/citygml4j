package org.citygml4j.adapter.xml.construction;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.adapter.xml.core.AbstractThematicSurfaceAdapter;
import org.citygml4j.adapter.xml.core.ClosureSurfacePropertyAdapter;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfAbstractConstructionSurface;
import org.citygml4j.model.construction.ADEPropertyOfAbstractConstructionSurface;
import org.citygml4j.model.construction.AbstractConstructionSurface;
import org.citygml4j.model.construction.AbstractFillingSurfaceProperty;
import org.citygml4j.model.core.ClosureSurfaceProperty;
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

public abstract class AbstractConstructionSurfaceAdapter<T extends AbstractConstructionSurface> extends AbstractThematicSurfaceAdapter<T> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "AbstractGenericApplicationPropertyOfAbstractConstructionSurface");

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (name.getNamespaceURI().equals(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE)) {
            switch (name.getLocalPart()) {
                case "fillingSurface":
                    object.getFillingSurfaces().add(reader.getObjectUsingBuilder(AbstractFillingSurfacePropertyAdapter.class));
                    return;
                case "closureSurface":
                    object.getClosureSurfaces().add(reader.getObjectUsingBuilder(ClosureSurfacePropertyAdapter.class));
                    return;
            }
        }

        if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            ObjectBuilder<ADEPropertyOfAbstractConstructionSurface> builder = reader.getXMLObjects().getBuilder(name, ADEPropertyOfAbstractConstructionSurface.class);
            if (builder != null)
                object.getADEPropertiesOfAbstractConstructionSurface().add(reader.getObjectUsingBuilder(builder));
            else if (CityGMLBuilderHelper.createAsGenericADEProperty(name, reader, substitutionGroup))
                object.getADEPropertiesOfAbstractConstructionSurface().add(GenericADEPropertyOfAbstractConstructionSurface.of(reader.getDOMElement()));
        } else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        if (namespaces.contains(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE)) {
            for (AbstractFillingSurfaceProperty property : object.getFillingSurfaces())
                writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "fillingSurface"), property, AbstractFillingSurfacePropertyAdapter.class, namespaces);

            for (ClosureSurfaceProperty property : object.getClosureSurfaces())
                writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "closureSurface"), property, ClosureSurfacePropertyAdapter.class, namespaces);

            for (ADEPropertyOfAbstractConstructionSurface property : object.getADEPropertiesOfAbstractConstructionSurface())
                CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
        }
    }
}
