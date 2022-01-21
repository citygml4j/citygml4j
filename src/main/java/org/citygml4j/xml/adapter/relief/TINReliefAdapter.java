/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2021 Claus Nagel <claus.nagel@gmail.com>
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

import org.citygml4j.model.ade.generic.GenericADEOfTINRelief;
import org.citygml4j.model.relief.ADEOfTINRelief;
import org.citygml4j.model.relief.TINRelief;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
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

@XMLElements({
        @XMLElement(name = "TINRelief", namespaceURI = CityGMLConstants.CITYGML_3_0_RELIEF_NAMESPACE),
        @XMLElement(name = "TINRelief", namespaceURI = CityGMLConstants.CITYGML_2_0_RELIEF_NAMESPACE),
        @XMLElement(name = "TINRelief", namespaceURI = CityGMLConstants.CITYGML_1_0_RELIEF_NAMESPACE)
})
public class TINReliefAdapter extends AbstractReliefComponentAdapter<TINRelief> {
    private final QName[] substitutionGroups = new QName[]{
            new QName(CityGMLConstants.CITYGML_2_0_RELIEF_NAMESPACE, "_GenericApplicationPropertyOfTinRelief"),
            new QName(CityGMLConstants.CITYGML_1_0_RELIEF_NAMESPACE, "_GenericApplicationPropertyOfTinRelief")
    };

    @Override
    public TINRelief createObject(QName name, Object parent) throws ObjectBuildException {
        return new TINRelief();
    }

    @Override
    public void buildChildObject(TINRelief object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isReliefNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "tin":
                    object.setTin(reader.getObjectUsingBuilder(TinPropertyAdapter.class));
                    return;
                case "adeOfTINRelief":
                    ADEBuilderHelper.addADEProperty(object, GenericADEOfTINRelief::of, reader);
                    return;
            }
        } else if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            buildADEProperty(object, name, reader);
            return;
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(TINRelief object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!ADEBuilderHelper.addADEProperty(object, name, GenericADEOfTINRelief::of, reader, substitutionGroups))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(TINRelief object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLSerializerHelper.getReliefNamespace(namespaces), "TINRelief");
    }

    @Override
    public void writeChildElements(TINRelief object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String reliefNamespace = CityGMLSerializerHelper.getReliefNamespace(namespaces);
        boolean isCityGML3 = CityGMLConstants.CITYGML_3_0_RELIEF_NAMESPACE.equals(reliefNamespace);

        if (object.getTin() != null)
            writer.writeElementUsingSerializer(Element.of(reliefNamespace, "tin"), object.getTin(), TinPropertyAdapter.class, namespaces);

        for (ADEOfTINRelief property : object.getADEProperties(ADEOfTINRelief.class))
            ADESerializerHelper.writeADEProperty(isCityGML3 ? Element.of(reliefNamespace, "adeOfTINRelief") : null, property, namespaces, writer);
    }
}
