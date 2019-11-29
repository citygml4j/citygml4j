package org.citygml4j.adapter.xml.dynamizer;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfGenericTimeseries;
import org.citygml4j.model.dynamizer.ADEPropertyOfGenericTimeseries;
import org.citygml4j.model.dynamizer.GenericTimeseries;
import org.citygml4j.model.dynamizer.TimeValuePairProperty;
import org.citygml4j.model.dynamizer.TimeseriesValue;
import org.citygml4j.util.CityGMLConstants;
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

@XMLElement(name = "GenericTimeseries", namespaceURI = CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE)
public class GenericTimeseriesAdapter extends AbstractAtomicTimeseriesAdapter<GenericTimeseries> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "AbstractGenericApplicationPropertyOfGenericTimeseries");

    @Override
    public GenericTimeseries createObject(QName name) throws ObjectBuildException {
        return new GenericTimeseries();
    }

    @Override
    public void buildChildObject(GenericTimeseries object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "valueType":
                    reader.getTextContent().ifPresent(v -> object.setValueType(TimeseriesValue.fromValue(v)));
                    return;
                case "timeValuePair":
                    object.getTimeValuePairs().add(reader.getObjectUsingBuilder(TimeValuePairPropertyAdapter.class));
                    return;
            }
        } else if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            buildADEProperty(object, name, reader);
            return;
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(GenericTimeseries object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!CityGMLBuilderHelper.addADEProperty(name, ADEPropertyOfGenericTimeseries.class, object.getADEPropertiesOfGenericTimeseries(),
                GenericADEPropertyOfGenericTimeseries::of, reader, substitutionGroup))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(GenericTimeseries object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "GenericTimeseries");
    }

    @Override
    public void writeChildElements(GenericTimeseries object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String dynamizerNamespace = CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE;

        if (object.getValueType() != null)
            writer.writeElement(Element.of(dynamizerNamespace, "valueType").addTextContent(object.getValueType().toValue()));

        for (TimeValuePairProperty property : object.getTimeValuePairs())
            writer.writeElementUsingSerializer(Element.of(dynamizerNamespace, "timeValuePair"), property, TimeValuePairPropertyAdapter.class, namespaces);

        for (ADEPropertyOfGenericTimeseries<?> property : object.getADEPropertiesOfGenericTimeseries())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
