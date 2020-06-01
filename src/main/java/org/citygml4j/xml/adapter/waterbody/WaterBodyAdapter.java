package org.citygml4j.xml.adapter.waterbody;

import org.citygml4j.model.ade.generic.GenericADEOfWaterBody;
import org.citygml4j.model.waterbody.ADEOfWaterBody;
import org.citygml4j.model.waterbody.WaterBody;
import org.citygml4j.util.CityGMLConstants;
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
    public WaterBody createObject(QName name) throws ObjectBuildException {
        return new WaterBody();
    }

    @Override
    public void buildChildObject(WaterBody object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_WATERBODY_NAMESPACE.equals(name.getNamespaceURI())) {
            if (CityGMLBuilderHelper.buildStandardObjectClassifier(object, name.getLocalPart(), reader))
                return;
            else if ("adeOfWaterBody".equals(name.getLocalPart())) {
                ADEBuilderHelper.addADEContainer(ADEOfWaterBody.class, object.getADEOfWaterBody(), GenericADEOfWaterBody::new, reader);
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

        CityGMLSerializerHelper.serializeStandardObjectClassifier(object, CityGMLConstants.CITYGML_3_0_WATERBODY_NAMESPACE, namespaces, writer);

        for (ADEOfWaterBody container : object.getADEOfWaterBody())
            ADESerializerHelper.writeADEContainer(Element.of(CityGMLConstants.CITYGML_3_0_WATERBODY_NAMESPACE, "adeOfWaterBody"), container, namespaces, writer);
    }
}
