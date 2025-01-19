/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2025 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.xml.adapter.relief;

import org.citygml4j.core.model.ade.generic.GenericADEOfMassPointRelief;
import org.citygml4j.core.model.relief.ADEOfMassPointRelief;
import org.citygml4j.core.model.relief.MassPointRelief;
import org.citygml4j.core.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.citygml4j.xml.adapter.core.AbstractPointCloudPropertyAdapter;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.geometry.aggregates.MultiPointPropertyAdapter;
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
        @XMLElement(name = "MassPointRelief", namespaceURI = CityGMLConstants.CITYGML_3_0_RELIEF_NAMESPACE),
        @XMLElement(name = "MassPointRelief", namespaceURI = CityGMLConstants.CITYGML_2_0_RELIEF_NAMESPACE),
        @XMLElement(name = "MassPointRelief", namespaceURI = CityGMLConstants.CITYGML_1_0_RELIEF_NAMESPACE)
})
public class MassPointReliefAdapter extends AbstractReliefComponentAdapter<MassPointRelief> {
    private final QName[] substitutionGroups = new QName[]{
            new QName(CityGMLConstants.CITYGML_2_0_RELIEF_NAMESPACE, "_GenericApplicationPropertyOfMassPointRelief"),
            new QName(CityGMLConstants.CITYGML_1_0_RELIEF_NAMESPACE, "_GenericApplicationPropertyOfMassPointRelief")
    };

    @Override
    public MassPointRelief createObject(QName name, Object parent) throws ObjectBuildException {
        return new MassPointRelief();
    }

    @Override
    public void buildChildObject(MassPointRelief object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isReliefNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "reliefPoints":
                    object.setReliefPoints(reader.getObjectUsingBuilder(MultiPointPropertyAdapter.class));
                    return;
                case "pointCloud":
                    object.setPointCloud(reader.getObjectUsingBuilder(AbstractPointCloudPropertyAdapter.class));
                    return;
                case "adeOfMassPointRelief":
                    ADEBuilderHelper.addADEProperty(object, GenericADEOfMassPointRelief::of, reader);
                    return;
            }
        } else if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            buildADEProperty(object, name, reader);
            return;
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(MassPointRelief object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!ADEBuilderHelper.addADEProperty(object, name, GenericADEOfMassPointRelief::of, reader, substitutionGroups))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(MassPointRelief object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLSerializerHelper.getReliefNamespace(namespaces), "MassPointRelief");
    }

    @Override
    public void writeChildElements(MassPointRelief object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String reliefNamespace = CityGMLSerializerHelper.getReliefNamespace(namespaces);
        boolean isCityGML3 = CityGMLConstants.CITYGML_3_0_RELIEF_NAMESPACE.equals(reliefNamespace);

        if (object.getReliefPoints() != null)
            writer.writeElementUsingSerializer(Element.of(reliefNamespace, "reliefPoints"), object.getReliefPoints(), MultiPointPropertyAdapter.class, namespaces);

        if (object.getPointCloud() != null && isCityGML3)
            writer.writeElementUsingSerializer(Element.of(reliefNamespace, "pointCloud"), object.getPointCloud(), AbstractPointCloudPropertyAdapter.class, namespaces);

        for (ADEOfMassPointRelief property : object.getADEProperties(ADEOfMassPointRelief.class))
            ADESerializerHelper.writeADEProperty(isCityGML3 ? Element.of(reliefNamespace, "adeOfMassPointRelief") : null, property, namespaces, writer);
    }
}
