/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2023 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.citygml4j.xml.adapter.deprecated.waterbody;

import org.citygml4j.core.model.ade.generic.GenericADEOfAbstractThematicSurface;
import org.citygml4j.core.model.core.ADEOfAbstractThematicSurface;
import org.citygml4j.core.model.core.AbstractThematicSurface;
import org.citygml4j.core.model.waterbody.ADEOfAbstractWaterBoundarySurface;
import org.citygml4j.core.model.waterbody.AbstractWaterBoundarySurface;
import org.citygml4j.core.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.citygml4j.xml.adapter.core.AbstractCityObjectAdapter;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.geometry.primitives.SurfacePropertyAdapter;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSurface;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSurfaceProperty;
import org.xmlobjects.gml.model.geometry.complexes.CompositeSurface;
import org.xmlobjects.gml.model.geometry.primitives.AbstractSurface;
import org.xmlobjects.gml.model.geometry.primitives.SurfaceProperty;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.util.copy.CopyBuilder;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWaterBoundarySurfaceAdapter<T extends AbstractThematicSurface> extends AbstractCityObjectAdapter<T> {
    private final CopyBuilder copyBuilder = new CopyBuilder();
    private final QName[] substitutionGroups = new QName[]{
            new QName(CityGMLConstants.CITYGML_2_0_WATERBODY_NAMESPACE, "_GenericApplicationPropertyOfWaterBoundarySurface"),
            new QName(CityGMLConstants.CITYGML_1_0_WATERBODY_NAMESPACE, "_GenericApplicationPropertyOfWaterBoundarySurface")
    };

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isWaterBodyNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "lod2Surface":
                    object.setLod2MultiSurface(getMultiSurfaceProperty(reader.getObjectUsingBuilder(SurfacePropertyAdapter.class)));
                    return;
                case "lod3Surface":
                    object.setLod3MultiSurface(getMultiSurfaceProperty(reader.getObjectUsingBuilder(SurfacePropertyAdapter.class)));
                    return;
                case "lod4Surface":
                    object.getDeprecatedProperties().setLod4MultiSurface(getMultiSurfaceProperty(reader.getObjectUsingBuilder(SurfacePropertyAdapter.class)));
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
        if (!ADEBuilderHelper.addADEProperty(object, name, GenericADEOfAbstractThematicSurface::of, reader, substitutionGroups))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String waterBodyNamespace = CityGMLSerializerHelper.getWaterBodyNamespace(namespaces);

        if (object.getLod2MultiSurface() != null)
            writer.writeElementUsingSerializer(Element.of(waterBodyNamespace, "lod2Surface"), getSurfaceProperty(object.getLod2MultiSurface()), SurfacePropertyAdapter.class, namespaces);

        if (object.getLod3MultiSurface() != null)
            writer.writeElementUsingSerializer(Element.of(waterBodyNamespace, "lod3Surface"), getSurfaceProperty(object.getLod3MultiSurface()), SurfacePropertyAdapter.class, namespaces);

        if (object.hasDeprecatedProperties() && object.getDeprecatedProperties().getLod4MultiSurface() != null)
            writer.writeElementUsingSerializer(Element.of(waterBodyNamespace, "lod4Surface"), getSurfaceProperty(object.getDeprecatedProperties().getLod4MultiSurface()), SurfacePropertyAdapter.class, namespaces);

        if (object instanceof AbstractWaterBoundarySurface) {
            AbstractWaterBoundarySurface boundarySurface = (AbstractWaterBoundarySurface) object;
            for (ADEOfAbstractWaterBoundarySurface property : boundarySurface.getADEProperties(ADEOfAbstractWaterBoundarySurface.class))
                ADESerializerHelper.writeADEProperty(property, namespaces, writer);
        }

        for (ADEOfAbstractThematicSurface property : object.getADEProperties(ADEOfAbstractThematicSurface.class))
            ADESerializerHelper.writeADEProperty(property, namespaces, writer);
    }

    private MultiSurfaceProperty getMultiSurfaceProperty(SurfaceProperty src) {
        MultiSurface multiSurface = new MultiSurface();
        multiSurface.getSurfaceMember().add(src);
        return new MultiSurfaceProperty(multiSurface);
    }

    private SurfaceProperty getSurfaceProperty(MultiSurfaceProperty src) {
        SurfaceProperty dest;

        if (src.getObject() != null) {
            MultiSurface multiSurface = src.getObject();
            List<SurfaceProperty> properties = new ArrayList<>();

            if (multiSurface.isSetSurfaceMember()) {
                for (SurfaceProperty property : multiSurface.getSurfaceMember())
                    properties.add((SurfaceProperty) property.shallowCopy(copyBuilder));
            }

            if (multiSurface.getSurfaceMembers() != null && multiSurface.getSurfaceMembers().isSetObjects()) {
                for (AbstractSurface surface : multiSurface.getSurfaceMembers().getObjects())
                    properties.add(new SurfaceProperty((AbstractSurface) surface.shallowCopy(copyBuilder)));
            }

            if (properties.size() == 0) {
                dest = new SurfaceProperty();
            } else if (properties.size() == 1) {
                dest = properties.get(0);
            } else {
                dest = new SurfaceProperty(new CompositeSurface(properties));
            }
        } else {
            dest = new SurfaceProperty();
        }

        return dest;
    }
}
