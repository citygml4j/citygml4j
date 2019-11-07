package org.citygml4j.adapter.xml.dynamizer;

import org.citygml4j.model.dynamizer.TimeseriesComponent;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.temporal.TimeDurationAdapter;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.serializer.ObjectSerializer;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;
import org.xmlobjects.xml.TextContent;

import javax.xml.namespace.QName;

@XMLElement(name = "TimeseriesComponent", namespaceURI = CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE)
public class TimeseriesComponentAdapter implements ObjectBuilder<TimeseriesComponent>, ObjectSerializer<TimeseriesComponent> {

    @Override
    public TimeseriesComponent createObject(QName name) throws ObjectBuildException {
        return new TimeseriesComponent();
    }

    @Override
    public void buildChildObject(TimeseriesComponent object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "repetitions":
                    reader.getTextContent().ifInteger(object::setRepetitions);
                    break;
                case "additionalGap":
                    object.setAdditionalGap(reader.getObjectUsingBuilder(TimeDurationAdapter.class));
                    break;
                case "timeseries":
                    object.setTimeseries(reader.getObjectUsingBuilder(AbstractTimeseriesPropertyAdapter.class));
                    break;
            }
        }
    }

    @Override
    public Element createElement(TimeseriesComponent object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "TimeseriesComponent");
    }

    @Override
    public void writeChildElements(TimeseriesComponent object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        String dynamizerNamespace = CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE;

        if (object.getRepetitions() != null)
            writer.writeElement(Element.of(dynamizerNamespace, "repetitions").addTextContent(TextContent.ofInteger(object.getRepetitions())));

        if (object.getAdditionalGap() != null)
            writer.writeElementUsingSerializer(Element.of(dynamizerNamespace, "additionalGap"), object.getAdditionalGap(), TimeDurationAdapter.class, namespaces);

        writer.writeElementUsingSerializer(Element.of(dynamizerNamespace, "timeseries"), object.getTimeseries(), AbstractTimeseriesPropertyAdapter.class, namespaces);
    }
}
