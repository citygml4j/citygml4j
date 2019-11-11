package org.citygml4j.adapter.xml.dynamizer;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfCompositeTimeseries;
import org.citygml4j.model.dynamizer.ADEPropertyOfCompositeTimeseries;
import org.citygml4j.model.dynamizer.CompositeTimeseries;
import org.citygml4j.model.dynamizer.TimeseriesComponentProperty;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElement(name = "CompositeTimeseries", namespaceURI = CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE)
public class CompositeTimeseriesAdapter extends AbstractTimeseriesAdapter<CompositeTimeseries> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "AbstractGenericApplicationPropertyOfCompositeTimeseries");

    @Override
    public CompositeTimeseries createObject(QName name) throws ObjectBuildException {
        return new CompositeTimeseries();
    }

    @Override
    public void buildChildObject(CompositeTimeseries object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE.equals(name.getNamespaceURI()) && "component".equals(name.getLocalPart())) {
            object.getComponents().add(reader.getObjectUsingBuilder(TimeseriesComponentPropertyAdapter.class));
            return;
        }

        if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            ObjectBuilder<ADEPropertyOfCompositeTimeseries> builder = reader.getXMLObjects().getBuilder(name, ADEPropertyOfCompositeTimeseries.class);
            if (builder != null)
                object.getADEPropertiesOfCompositeTimeseries().add(reader.getObjectUsingBuilder(builder));
            else if (CityGMLBuilderHelper.createAsGenericADEProperty(name, reader, substitutionGroup))
                object.getADEPropertiesOfCompositeTimeseries().add(GenericADEPropertyOfCompositeTimeseries.of(reader.getDOMElement()));
        } else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(CompositeTimeseries object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "CompositeTimeseries");
    }

    @Override
    public void writeChildElements(CompositeTimeseries object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        for (TimeseriesComponentProperty property : object.getComponents())
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "component"), property, TimeseriesComponentPropertyAdapter.class, namespaces);

        for (ADEPropertyOfCompositeTimeseries property : object.getADEPropertiesOfCompositeTimeseries())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
