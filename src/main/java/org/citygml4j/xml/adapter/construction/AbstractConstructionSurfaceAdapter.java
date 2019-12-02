package org.citygml4j.xml.adapter.construction;

import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.core.AbstractThematicSurfaceAdapter;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfAbstractConstructionSurface;
import org.citygml4j.model.construction.ADEPropertyOfAbstractConstructionSurface;
import org.citygml4j.model.construction.AbstractConstructionSurface;
import org.citygml4j.model.construction.AbstractFillingSurfaceProperty;
import org.citygml4j.util.CityGMLConstants;
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

public abstract class AbstractConstructionSurfaceAdapter<T extends AbstractConstructionSurface> extends AbstractThematicSurfaceAdapter<T> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "AbstractGenericApplicationPropertyOfAbstractConstructionSurface");

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (name.getNamespaceURI().equals(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE) && "fillingSurface".equals(name.getLocalPart())) {
            object.getFillingSurfaces().add(reader.getObjectUsingBuilder(AbstractFillingSurfacePropertyAdapter.class));
            return;
        } else if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            buildADEProperty(object, name, reader);
            return;
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(T object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!CityGMLBuilderHelper.addADEProperty(name, ADEPropertyOfAbstractConstructionSurface.class, object.getADEPropertiesOfAbstractConstructionSurface(),
                GenericADEPropertyOfAbstractConstructionSurface::of, reader, substitutionGroup))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        if (namespaces.contains(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE)) {
            for (AbstractFillingSurfaceProperty property : object.getFillingSurfaces())
                writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "fillingSurface"), property, AbstractFillingSurfacePropertyAdapter.class, namespaces);

            for (ADEPropertyOfAbstractConstructionSurface<?> property : object.getADEPropertiesOfAbstractConstructionSurface())
                CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
        }
    }
}
