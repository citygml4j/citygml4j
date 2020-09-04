/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2020 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.xml.adapter.landuse;

import org.citygml4j.model.ade.generic.GenericADEOfLandUse;
import org.citygml4j.model.landuse.ADEOfLandUse;
import org.citygml4j.model.landuse.LandUse;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.citygml4j.xml.adapter.core.AbstractThematicSurfaceAdapter;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
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

@XMLElements({
        @XMLElement(name = "LandUse", namespaceURI = CityGMLConstants.CITYGML_3_0_LANDUSE_NAMESPACE),
        @XMLElement(name = "LandUse", namespaceURI = CityGMLConstants.CITYGML_2_0_LANDUSE_NAMESPACE),
        @XMLElement(name = "LandUse", namespaceURI = CityGMLConstants.CITYGML_1_0_LANDUSE_NAMESPACE)
})
public class LandUseAdapter extends AbstractThematicSurfaceAdapter<LandUse> {
    private final QName[] substitutionGroups = new QName[]{
            new QName(CityGMLConstants.CITYGML_2_0_LANDUSE_NAMESPACE, "_GenericApplicationPropertyOfLandUse"),
            new QName(CityGMLConstants.CITYGML_1_0_LANDUSE_NAMESPACE, "_GenericApplicationPropertyOfLandUse")
    };

    @Override
    public LandUse createObject(QName name, Object parent) throws ObjectBuildException {
        return new LandUse();
    }

    @Override
    public void buildChildObject(LandUse object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isLandUseNamespace(name.getNamespaceURI())) {
            if (CityGMLBuilderHelper.buildStandardObjectClassifier(object, name.getLocalPart(), reader))
                return;

            switch (name.getLocalPart()) {
                case "lod0MultiSurface":
                    object.setLod0MultiSurface(reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    return;
                case "lod1MultiSurface":
                    object.setLod1MultiSurface(reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    return;
                case "lod2MultiSurface":
                    object.setLod2MultiSurface(reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    return;
                case "lod3MultiSurface":
                    object.setLod3MultiSurface(reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    return;
                case "lod4MultiSurface":
                    object.getDeprecatedProperties().setLod4MultiSurface(reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    return;
                case "adeOfLandUse":
                    ADEBuilderHelper.addADEContainer(ADEOfLandUse.class, object.getADEOfLandUse(), GenericADEOfLandUse::of, reader);
                    return;
            }
        } else if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            buildADEProperty(object, name, reader);
            return;
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(LandUse object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!ADEBuilderHelper.addADEContainer(name, ADEOfLandUse.class, object.getADEOfLandUse(),
                GenericADEOfLandUse::of, reader, substitutionGroups))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(LandUse object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLSerializerHelper.getLandUseNamespace(namespaces), "LandUse");
    }

    @Override
    public void writeChildElements(LandUse object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String landUseNamespace = CityGMLSerializerHelper.getLandUseNamespace(namespaces);
        boolean isCityGML3 = CityGMLConstants.CITYGML_3_0_LANDUSE_NAMESPACE.equals(landUseNamespace);

        CityGMLSerializerHelper.writeStandardObjectClassifier(object, landUseNamespace, namespaces, writer);

        if (!isCityGML3) {
            if (object.getLod0MultiSurface() != null)
                writer.writeElementUsingSerializer(Element.of(landUseNamespace, "lod0MultiSurface"), object.getLod0MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

            if (object.getLod1MultiSurface() != null)
                writer.writeElementUsingSerializer(Element.of(landUseNamespace, "lod1MultiSurface"), object.getLod1MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

            if (object.getLod2MultiSurface() != null)
                writer.writeElementUsingSerializer(Element.of(landUseNamespace, "lod2MultiSurface"), object.getLod2MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

            if (object.getLod3MultiSurface() != null)
                writer.writeElementUsingSerializer(Element.of(landUseNamespace, "lod3MultiSurface"), object.getLod3MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

            if (object.getDeprecatedProperties().getLod4MultiSurface() != null)
                writer.writeElementUsingSerializer(Element.of(landUseNamespace, "lod4MultiSurface"), object.getDeprecatedProperties().getLod4MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);
        }

        for (ADEOfLandUse container : object.getADEOfLandUse())
            ADESerializerHelper.writeADEContainer(isCityGML3 ? Element.of(landUseNamespace, "adeOfLandUse") : null, container, namespaces, writer);
    }
}
