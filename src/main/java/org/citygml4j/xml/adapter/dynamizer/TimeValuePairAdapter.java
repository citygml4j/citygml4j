package org.citygml4j.xml.adapter.dynamizer;

import org.citygml4j.model.dynamizer.TimeValuePair;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.core.AbstractAppearancePropertyAdapter;
import org.citygml4j.xml.adapter.core.ImplicitGeometryPropertyAdapter;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.geometry.GeometryPropertyAdapter;
import org.xmlobjects.gml.adapter.temporal.TimePositionAdapter;
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

@XMLElement(name = "TimeValuePair", namespaceURI = CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE)
public class TimeValuePairAdapter implements ObjectBuilder<TimeValuePair>, ObjectSerializer<TimeValuePair> {

    @Override
    public TimeValuePair createObject(QName name, Object parent) throws ObjectBuildException {
        return new TimeValuePair();
    }

    @Override
    public void buildChildObject(TimeValuePair object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "timestamp":
                    object.setTimestamp(reader.getObjectUsingBuilder(TimePositionAdapter.class));
                    break;
                case "intValue":
                    reader.getTextContent().ifInteger(object::setIntValue);
                    break;
                case "doubleValue":
                    reader.getTextContent().ifDouble(object::setDoubleValue);
                    break;
                case "stringValue":
                    reader.getTextContent().ifPresent(object::setStringValue);
                    break;
                case "geometryValue":
                    object.setGeometryValue(reader.getObjectUsingBuilder(GeometryPropertyAdapter.class));
                    break;
                case "uriValue":
                    reader.getTextContent().ifPresent(object::setUriValue);
                    break;
                case "boolValue":
                    reader.getTextContent().ifBoolean(object::setBoolValue);
                    break;
                case "implicitGeometryValue":
                    object.setImplicitGeometryValue(reader.getObjectUsingBuilder(ImplicitGeometryPropertyAdapter.class));
                    break;
                case "appearanceValue":
                    object.setAppearanceValue(reader.getObjectUsingBuilder(AbstractAppearancePropertyAdapter.class));
                    break;
            }
        }
    }

    @Override
    public Element createElement(TimeValuePair object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "TimeValuePair");
    }

    @Override
    public void writeChildElements(TimeValuePair object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (object.getTimestamp() != null)
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "timestamp"), object.getTimestamp(), TimePositionAdapter.class, namespaces);

        if (object.isSetIntValue())
            writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "intValue").addTextContent(TextContent.ofInteger(object.getIntValue())));
        else if (object.isSetDoubleValue())
            writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "doubleValue").addTextContent(TextContent.ofDouble(object.getDoubleValue())));
        else if (object.isSetStringValue())
            writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "stringValue").addTextContent(object.getStringValue()));
        else if (object.isSetGeometryValue())
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "geometryValue"), object.getGeometryValue(), GeometryPropertyAdapter.class, namespaces);
        else if (object.isSetUriValue())
            writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "uriValue").addTextContent(object.getUriValue()));
        else if (object.isSetBoolValue())
            writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "boolValue").addTextContent(TextContent.ofBoolean(object.getBoolValue())));
        else if (object.isSetImplicitGeometryValue())
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "implicitGeometryValue"), object.getImplicitGeometryValue(), ImplicitGeometryPropertyAdapter.class, namespaces);
        else if (object.isSetAppearanceValue())
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "appearanceValue"), object.getAppearanceValue(), AbstractAppearancePropertyAdapter.class, namespaces);
    }
}
