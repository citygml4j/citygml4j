package org.citygml4j.xml.adapter.dynamizer;

import org.citygml4j.model.ade.generic.GenericADEOfAbstractTimeseries;
import org.citygml4j.model.dynamizer.ADEOfAbstractTimeseries;
import org.citygml4j.model.dynamizer.AbstractTimeseries;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.citygml4j.xml.adapter.core.AbstractFeatureAdapter;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.temporal.TimePositionAdapter;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public abstract class AbstractTimeseriesAdapter<T extends AbstractTimeseries> extends AbstractFeatureAdapter<T> {

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "firstTimestamp":
                    object.setFirstTimestamp(reader.getObjectUsingBuilder(TimePositionAdapter.class));
                    return;
                case "lastTimestamp":
                    object.setLastTimestamp(reader.getObjectUsingBuilder(TimePositionAdapter.class));
                    return;
                case "adeOfAbstractTimeseries":
                    ADEBuilderHelper.addADEContainer(ADEOfAbstractTimeseries.class, object.getADEOfAbstractTimeseries(), GenericADEOfAbstractTimeseries::new, reader);
                    return;
            }
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String dynamizerNamespace = CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE;

        if (object.getFirstTimestamp() != null)
            writer.writeElementUsingSerializer(Element.of(dynamizerNamespace, "firstTimestamp"), object.getFirstTimestamp(), TimePositionAdapter.class, namespaces);

        if (object.getLastTimestamp() != null)
            writer.writeElementUsingSerializer(Element.of(dynamizerNamespace, "lastTimestamp"), object.getLastTimestamp(), TimePositionAdapter.class, namespaces);

        for (ADEOfAbstractTimeseries container : object.getADEOfAbstractTimeseries())
            ADESerializerHelper.writeADEContainer(Element.of(dynamizerNamespace, "adeOfAbstractTimeseries"), container, namespaces, writer);
    }
}
