package org.citygml4j.adapter.xml.dynamizer;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfAbstractTimeseries;
import org.citygml4j.model.dynamizer.ADEPropertyOfAbstractTimeseries;
import org.citygml4j.model.dynamizer.AbstractTimeseries;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.feature.AbstractFeatureAdapter;
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
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "AbstractGenericApplicationPropertyOfAbstractTimeseries");

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
            }
        }

        if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            ObjectBuilder<ADEPropertyOfAbstractTimeseries> builder = reader.getXMLObjects().getBuilder(name, ADEPropertyOfAbstractTimeseries.class);
            if (builder != null)
                object.getADEPropertiesOfAbstractTimeseries().add(reader.getObjectUsingBuilder(builder));
            else if (CityGMLBuilderHelper.createAsGenericADEProperty(name, reader, substitutionGroup))
                object.getADEPropertiesOfAbstractTimeseries().add(GenericADEPropertyOfAbstractTimeseries.of(reader.getDOMElement()));
        } else
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

        for (ADEPropertyOfAbstractTimeseries property : object.getADEPropertiesOfAbstractTimeseries())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
