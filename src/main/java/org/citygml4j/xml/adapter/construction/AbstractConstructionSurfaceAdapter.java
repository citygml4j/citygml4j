package org.citygml4j.xml.adapter.construction;

import org.citygml4j.model.ade.generic.GenericADEOfAbstractConstructionSurface;
import org.citygml4j.model.construction.ADEOfAbstractConstructionSurface;
import org.citygml4j.model.construction.AbstractConstructionSurface;
import org.citygml4j.model.construction.AbstractFillingSurfaceProperty;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.citygml4j.xml.adapter.core.AbstractThematicSurfaceAdapter;
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

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (name.getNamespaceURI().equals(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE)) {
            switch (name.getLocalPart()) {
                case "fillingSurface":
                    object.getFillingSurfaces().add(reader.getObjectUsingBuilder(AbstractFillingSurfacePropertyAdapter.class));
                    return;
                case "adeOfAbstractConstructionSurface":
                    ADEBuilderHelper.addADEContainer(ADEOfAbstractConstructionSurface.class, object.getADEOfAbstractConstructionSurface(), GenericADEOfAbstractConstructionSurface::of, reader);
                    return;
            }
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        if (namespaces.contains(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE)) {
            for (AbstractFillingSurfaceProperty property : object.getFillingSurfaces())
                writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "fillingSurface"), property, AbstractFillingSurfacePropertyAdapter.class, namespaces);

            for (ADEOfAbstractConstructionSurface container : object.getADEOfAbstractConstructionSurface())
                ADESerializerHelper.writeADEContainer(Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "adeOfAbstractConstructionSurface"), container, namespaces, writer);
        }
    }
}
