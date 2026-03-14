/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.adapter.deprecated.tunnel;

import org.citygml4j.core.model.ade.generic.GenericADEOfAbstractFillingSurface;
import org.citygml4j.core.model.construction.ADEOfAbstractFillingSurface;
import org.citygml4j.core.model.construction.AbstractFillingSurface;
import org.citygml4j.core.model.deprecated.construction.DeprecatedPropertiesOfAbstractFillingSurface;
import org.citygml4j.core.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.citygml4j.xml.adapter.core.AbstractCityObjectAdapter;
import org.citygml4j.xml.adapter.core.ImplicitGeometryPropertyAdapter;
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

public abstract class AbstractOpeningAdapter<T extends AbstractFillingSurface> extends AbstractCityObjectAdapter<T> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_2_0_TUNNEL_NAMESPACE, "_GenericApplicationPropertyOfOpening");

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isTunnelNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "lod3MultiSurface":
                    object.setLod3MultiSurface(reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    return;
                case "lod4MultiSurface":
                    object.getDeprecatedProperties().setLod4MultiSurface(reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    return;
                case "lod3ImplicitRepresentation":
                    object.getDeprecatedProperties().setLod3ImplicitRepresentation(reader.getObjectUsingBuilder(ImplicitGeometryPropertyAdapter.class));
                    return;
                case "lod4ImplicitRepresentation":
                    object.getDeprecatedProperties().setLod4ImplicitRepresentation(reader.getObjectUsingBuilder(ImplicitGeometryPropertyAdapter.class));
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
        if (!ADEBuilderHelper.addADEProperty(object, name, GenericADEOfAbstractFillingSurface::of, reader, substitutionGroup))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String tunnelNamespace = CityGMLSerializerHelper.getTunnelNamespace(namespaces);
        DeprecatedPropertiesOfAbstractFillingSurface properties = object.hasDeprecatedProperties() ?
                object.getDeprecatedProperties() :
                null;

        if (object.getLod3MultiSurface() != null)
            writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "lod3MultiSurface"), object.getLod3MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

        if (properties != null && properties.getLod4MultiSurface() != null)
            writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "lod4MultiSurface"), properties.getLod4MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

        if (properties != null && properties.getLod3ImplicitRepresentation() != null)
            writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "lod3ImplicitRepresentation"), properties.getLod3ImplicitRepresentation(), ImplicitGeometryPropertyAdapter.class, namespaces);

        if (properties != null && properties.getLod4ImplicitRepresentation() != null)
            writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "lod4ImplicitRepresentation"), properties.getLod4ImplicitRepresentation(), ImplicitGeometryPropertyAdapter.class, namespaces);

        for (ADEOfAbstractFillingSurface property : object.getADEProperties(ADEOfAbstractFillingSurface.class))
            ADESerializerHelper.writeADEProperty(property, namespaces, writer);
    }
}
