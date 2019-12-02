package org.citygml4j.xml.adapter.relief;

import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfTINRelief;
import org.citygml4j.model.relief.ADEPropertyOfTINRelief;
import org.citygml4j.model.relief.TINRelief;
import org.citygml4j.util.CityGMLConstants;
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
            new QName(CityGMLConstants.CITYGML_3_0_RELIEF_NAMESPACE, "AbstractGenericApplicationPropertyOfTINRelief"),
            new QName(CityGMLConstants.CITYGML_2_0_RELIEF_NAMESPACE, "_GenericApplicationPropertyOfTinRelief"),
            new QName(CityGMLConstants.CITYGML_1_0_RELIEF_NAMESPACE, "_GenericApplicationPropertyOfTinRelief")
    };

    @Override
    public TINRelief createObject(QName name) throws ObjectBuildException {
        return new TINRelief();
    }

    @Override
    public void buildChildObject(TINRelief object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isReliefNamespace(name.getNamespaceURI()) && "tin".equals(name.getLocalPart())) {
            object.setTin(reader.getObjectUsingBuilder(TinPropertyAdapter.class));
            return;
        } else if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            buildADEProperty(object, name, reader);
            return;
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(TINRelief object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!CityGMLBuilderHelper.addADEProperty(name, ADEPropertyOfTINRelief.class, object.getADEPropertiesOfTINRelief(),
                GenericADEPropertyOfTINRelief::of, reader, substitutionGroups))
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

        if (object.getTin() != null)
            writer.writeElementUsingSerializer(Element.of(reliefNamespace, "tin"), object.getTin(), TinPropertyAdapter.class, namespaces);

        for (ADEPropertyOfTINRelief<?> property : object.getADEPropertiesOfTINRelief())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
