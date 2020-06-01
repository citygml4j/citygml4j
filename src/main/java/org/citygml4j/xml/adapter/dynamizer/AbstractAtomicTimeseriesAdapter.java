package org.citygml4j.xml.adapter.dynamizer;

import org.citygml4j.model.ade.generic.GenericADEOfAbstractAtomicTimeseries;
import org.citygml4j.model.dynamizer.ADEOfAbstractAtomicTimeseries;
import org.citygml4j.model.dynamizer.AbstractAtomicTimeseries;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
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

public abstract class AbstractAtomicTimeseriesAdapter<T extends AbstractAtomicTimeseries> extends AbstractTimeseriesAdapter<T> {

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "observationProperty":
                    reader.getTextContent().ifPresent(object::setObservationProperty);
                    return;
                case "uom":
                    reader.getTextContent().ifPresent(object::setUom);
                    return;
                case "adeOfAbstractAtomicTimeseries":
                    ADEBuilderHelper.addADEContainer(ADEOfAbstractAtomicTimeseries.class, object.getADEOfAbstractAtomicTimeseries(), GenericADEOfAbstractAtomicTimeseries::new, reader);
                    return;
            }
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        if (object.getObservationProperty() != null)
            writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "observationProperty").addTextContent(object.getObservationProperty()));

        if (object.getUom() != null)
            writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "uom").addTextContent(object.getUom()));

        for (ADEOfAbstractAtomicTimeseries container : object.getADEOfAbstractAtomicTimeseries())
            ADESerializerHelper.writeADEContainer(Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "adeOfAbstractAtomicTimeseries"), container, namespaces, writer);
    }
}
