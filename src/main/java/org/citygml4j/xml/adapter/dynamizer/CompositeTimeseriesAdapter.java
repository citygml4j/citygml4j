package org.citygml4j.xml.adapter.dynamizer;

import org.citygml4j.model.ade.generic.GenericADEOfCompositeTimeseries;
import org.citygml4j.model.dynamizer.ADEOfCompositeTimeseries;
import org.citygml4j.model.dynamizer.CompositeTimeseries;
import org.citygml4j.model.dynamizer.TimeseriesComponentProperty;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
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

@XMLElement(name = "CompositeTimeseries", namespaceURI = CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE)
public class CompositeTimeseriesAdapter extends AbstractTimeseriesAdapter<CompositeTimeseries> {

    @Override
    public CompositeTimeseries createObject(QName name, Object parent) throws ObjectBuildException {
        return new CompositeTimeseries();
    }

    @Override
    public void buildChildObject(CompositeTimeseries object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "component":
                    object.getComponents().add(reader.getObjectUsingBuilder(TimeseriesComponentPropertyAdapter.class));
                    return;
                case "adeOfCompositeTimeseries":
                    ADEBuilderHelper.addADEContainer(ADEOfCompositeTimeseries.class, object.getADEOfCompositeTimeseries(), GenericADEOfCompositeTimeseries::of, reader);
                    return;
            }
        }

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

        for (ADEOfCompositeTimeseries container : object.getADEOfCompositeTimeseries())
            ADESerializerHelper.writeADEContainer(Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "adeOfCompositeTimeseries"), container, namespaces, writer);
    }
}
