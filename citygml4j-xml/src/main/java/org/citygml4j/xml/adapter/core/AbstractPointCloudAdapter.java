/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.adapter.core;

import org.citygml4j.core.model.ade.generic.GenericADEOfAbstractPointCloud;
import org.citygml4j.core.model.core.ADEOfAbstractPointCloud;
import org.citygml4j.core.model.core.AbstractPointCloud;
import org.citygml4j.core.util.CityGMLConstants;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
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

public abstract class AbstractPointCloudAdapter<T extends AbstractPointCloud> extends AbstractFeatureAdapter<T> {

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE.equals(name.getNamespaceURI()) && "adeOfAbstractPointCloud".equals(name.getLocalPart()))
            ADEBuilderHelper.addADEProperty(object, GenericADEOfAbstractPointCloud::of, reader);
        else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        for (ADEOfAbstractPointCloud property : object.getADEProperties(ADEOfAbstractPointCloud.class))
            ADESerializerHelper.writeADEProperty(Element.of(CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE, "adeOfAbstractPointCloud"), property, namespaces, writer);
    }
}
