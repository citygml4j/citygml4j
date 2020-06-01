package org.citygml4j.xml.adapter.deprecated.bridge;

import org.citygml4j.model.ade.generic.GenericADEOfAbstractThematicSurface;
import org.citygml4j.model.construction.ADEOfAbstractConstructionSurface;
import org.citygml4j.model.construction.AbstractConstructionSurface;
import org.citygml4j.model.construction.AbstractFillingSurfaceProperty;
import org.citygml4j.model.core.ADEOfAbstractThematicSurface;
import org.citygml4j.model.core.AbstractThematicSurface;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.citygml4j.xml.adapter.construction.AbstractFillingSurfacePropertyAdapter;
import org.citygml4j.xml.adapter.core.AbstractCityObjectAdapter;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.geometry.aggregates.MultiSurfacePropertyAdapter;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public abstract class AbstractBoundarySurfaceAdapter<T extends AbstractThematicSurface> extends AbstractCityObjectAdapter<T> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_2_0_BRIDGE_NAMESPACE, "_GenericApplicationPropertyOfBoundarySurface");

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isBridgeNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "lod2MultiSurface":
                    object.setLod2MultiSurface(reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    return;
                case "lod3MultiSurface":
                    object.setLod3MultiSurface(reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    return;
                case "lod4MultiSurface":
                    object.getDeprecatedProperties().setLod4MultiSurface(reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    return;
                case "opening":
                    if (object instanceof AbstractConstructionSurface)
                        ((AbstractConstructionSurface) object).getFillingSurfaces().add(reader.getObjectUsingBuilder(AbstractFillingSurfacePropertyAdapter.class));
                    return;
            }
        } else if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            buildADEProperty(object, name, reader);
            return;
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(T object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!ADEBuilderHelper.addADEContainer(name, ADEOfAbstractThematicSurface.class, object.getADEOfAbstractThematicSurface(),
                GenericADEOfAbstractThematicSurface::of, reader, substitutionGroup))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String bridgeNamespace = CityGMLSerializerHelper.getBridgeNamespace(namespaces);

        if (object.getLod2MultiSurface() != null)
            writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod2MultiSurface"), object.getLod2MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

        if (object.getLod3MultiSurface() != null)
            writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod3MultiSurface"), object.getLod3MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

        if (object.getDeprecatedProperties().getLod4MultiSurface() != null)
            writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod4MultiSurface"), object.getDeprecatedProperties().getLod4MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

        if (object instanceof AbstractConstructionSurface) {
            for (AbstractFillingSurfaceProperty property : ((AbstractConstructionSurface) object).getFillingSurfaces())
                writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "opening"), property, AbstractFillingSurfacePropertyAdapter.class, namespaces);

            for (ADEOfAbstractConstructionSurface container : ((AbstractConstructionSurface) object).getADEOfAbstractConstructionSurface())
                ADESerializerHelper.writeADEProperty(container, namespaces, writer);
        }

        for (ADEOfAbstractThematicSurface container : object.getADEOfAbstractThematicSurface())
            ADESerializerHelper.writeADEProperty(container, namespaces, writer);
    }
}
