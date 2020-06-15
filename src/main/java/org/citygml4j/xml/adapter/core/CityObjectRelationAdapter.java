package org.citygml4j.xml.adapter.core;

import org.citygml4j.model.core.AbstractGenericAttributeProperty;
import org.citygml4j.model.core.CityObjectRelation;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.AbstractGMLAdapter;
import org.xmlobjects.gml.adapter.basictypes.CodeAdapter;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElement(name = "CityObjectRelation", namespaceURI = CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE)
public class CityObjectRelationAdapter extends AbstractGMLAdapter<CityObjectRelation> {

    @Override
    public CityObjectRelation createObject(QName name, Object parent) throws ObjectBuildException {
        return new CityObjectRelation();
    }

    @Override
    public void buildChildObject(CityObjectRelation object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "genericAttribute":
                    object.getGenericAttributes().add(reader.getObjectUsingBuilder(AbstractGenericAttributePropertyAdapter.class));
                    return;
                case "relationType":
                    object.setRelationType(reader.getObjectUsingBuilder(CodeAdapter.class));
                    break;
                case "relatedTo":
                    object.setRelatedTo(reader.getObjectUsingBuilder(AbstractCityObjectPropertyAdapter.class));
                    break;
            }
        } else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(CityObjectRelation object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE, "CityObjectRelation");
    }

    @Override
    public void writeChildElements(CityObjectRelation object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        for (AbstractGenericAttributeProperty property : object.getGenericAttributes())
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE, "genericAttribute"), property, AbstractGenericAttributePropertyAdapter.class, namespaces);

        if (object.getRelationType() != null)
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE, "relationType"), object.getRelationType(), CodeAdapter.class, namespaces);

        if (object.getRelatedTo() != null)
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE, "relatedTo"), object.getRelatedTo(), AbstractCityObjectPropertyAdapter.class, namespaces);
    }
}
