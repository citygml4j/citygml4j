package org.citygml4j.xml.adapter.dynamizer;

import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.ade.ADEPropertyBuilder;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfAbstractTimeseries;
import org.citygml4j.model.dynamizer.ADEPropertyOfAbstractTimeseries;
import org.citygml4j.model.dynamizer.AbstractTimeseries;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.GMLBuilderHelper;
import org.xmlobjects.gml.adapter.feature.AbstractFeatureAdapter;
import org.xmlobjects.gml.adapter.temporal.TimePositionAdapter;
import org.xmlobjects.gml.model.common.GenericElement;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public abstract class AbstractTimeseriesAdapter<T extends AbstractTimeseries> extends AbstractFeatureAdapter<T> implements ADEPropertyBuilder<T> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "AbstractGenericApplicationPropertyOfAbstractTimeseries");

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "firstTimestamp":
                    object.setFirstTimestamp(reader.getObjectUsingBuilder(TimePositionAdapter.class));
                    break;
                case "lastTimestamp":
                    object.setLastTimestamp(reader.getObjectUsingBuilder(TimePositionAdapter.class));
                    break;
            }
        } else if (GMLBuilderHelper.isGMLNamespace(name.getNamespaceURI()))
            super.buildChildObject(object, name, attributes, reader);
        else
            buildADEProperty(object, name, reader);
    }

    @Override
    public void buildADEProperty(T object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!CityGMLBuilderHelper.addADEProperty(name, ADEPropertyOfAbstractTimeseries.class, object.getADEPropertiesOfAbstractTimeseries(),
                GenericADEPropertyOfAbstractTimeseries::of, reader, substitutionGroup))
            object.getGenericProperties().add(GenericElement.of(reader.getDOMElement()));
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String dynamizerNamespace = CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE;

        if (object.getFirstTimestamp() != null)
            writer.writeElementUsingSerializer(Element.of(dynamizerNamespace, "firstTimestamp"), object.getFirstTimestamp(), TimePositionAdapter.class, namespaces);

        if (object.getLastTimestamp() != null)
            writer.writeElementUsingSerializer(Element.of(dynamizerNamespace, "lastTimestamp"), object.getLastTimestamp(), TimePositionAdapter.class, namespaces);

        for (ADEPropertyOfAbstractTimeseries<?> property : object.getADEPropertiesOfAbstractTimeseries())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
