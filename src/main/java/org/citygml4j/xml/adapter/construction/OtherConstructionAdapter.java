package org.citygml4j.xml.adapter.construction;

import org.citygml4j.model.ade.generic.GenericADEOfOtherConstruction;
import org.citygml4j.model.construction.ADEOfOtherConstruction;
import org.citygml4j.model.construction.OtherConstruction;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
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

public class OtherConstructionAdapter extends AbstractConstructionAdapter<OtherConstruction> {

    @Override
    public OtherConstruction createObject(QName name) throws ObjectBuildException {
        return new OtherConstruction();
    }

    @Override
    public void buildChildObject(OtherConstruction object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE.equals(name.getNamespaceURI())) {
            if (CityGMLBuilderHelper.buildStandardObjectClassifier(object, name.getLocalPart(), reader))
                return;
            else if ("adeOfOtherConstruction".equals(name.getLocalPart())) {
                ADEBuilderHelper.addADEContainer(ADEOfOtherConstruction.class, object.getADEOfOtherConstruction(), GenericADEOfOtherConstruction::new, reader);
                return;
            }
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(OtherConstruction object, Namespaces namespaces) throws ObjectSerializeException {
        return null;
    }

    @Override
    public void writeChildElements(OtherConstruction object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        CityGMLSerializerHelper.writeStandardObjectClassifier(object, CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, namespaces, writer);

        for (ADEOfOtherConstruction container : object.getADEOfOtherConstruction())
            ADESerializerHelper.writeADEContainer(Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "adeOfOtherConstruction"), container, namespaces, writer);
    }
}
