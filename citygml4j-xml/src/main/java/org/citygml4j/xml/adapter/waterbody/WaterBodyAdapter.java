/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.adapter.waterbody;

import org.citygml4j.core.model.ade.generic.GenericADEOfWaterBody;
import org.citygml4j.core.model.waterbody.ADEOfWaterBody;
import org.citygml4j.core.model.waterbody.WaterBody;
import org.citygml4j.core.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.citygml4j.xml.adapter.core.AbstractOccupiedSpaceAdapter;
import org.xmlobjects.annotation.XMLElement;
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

@XMLElement(name = "WaterBody", namespaceURI = CityGMLConstants.CITYGML_3_0_WATERBODY_NAMESPACE)
public class WaterBodyAdapter extends AbstractOccupiedSpaceAdapter<WaterBody> {

    @Override
    public WaterBody createObject(QName name, Object parent) throws ObjectBuildException {
        return new WaterBody();
    }

    @Override
    public void buildChildObject(WaterBody object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_WATERBODY_NAMESPACE.equals(name.getNamespaceURI())) {
            if (CityGMLBuilderHelper.buildStandardObjectClassifier(object, name.getLocalPart(), reader))
                return;
            else if ("adeOfWaterBody".equals(name.getLocalPart())) {
                ADEBuilderHelper.addADEProperty(object, GenericADEOfWaterBody::of, reader);
                return;
            }
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(WaterBody object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_WATERBODY_NAMESPACE, "WaterBody");
    }

    @Override
    public void writeChildElements(WaterBody object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        CityGMLSerializerHelper.writeStandardObjectClassifier(object, CityGMLConstants.CITYGML_3_0_WATERBODY_NAMESPACE, namespaces, writer);

        for (ADEOfWaterBody property : object.getADEProperties(ADEOfWaterBody.class))
            ADESerializerHelper.writeADEProperty(Element.of(CityGMLConstants.CITYGML_3_0_WATERBODY_NAMESPACE, "adeOfWaterBody"), property, namespaces, writer);
    }
}
