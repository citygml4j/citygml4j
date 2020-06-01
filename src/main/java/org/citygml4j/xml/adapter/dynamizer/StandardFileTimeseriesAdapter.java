package org.citygml4j.xml.adapter.dynamizer;

import org.citygml4j.model.ade.generic.GenericADEOfStandardFileTimeseries;
import org.citygml4j.model.dynamizer.ADEOfStandardFileTimeseries;
import org.citygml4j.model.dynamizer.StandardFileTimeseries;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.basictypes.CodeAdapter;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElement(name = "StandardFileTimeseries", namespaceURI = CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE)
public class StandardFileTimeseriesAdapter extends AbstractAtomicTimeseriesAdapter<StandardFileTimeseries> {

    @Override
    public StandardFileTimeseries createObject(QName name) throws ObjectBuildException {
        return new StandardFileTimeseries();
    }

    @Override
    public void buildChildObject(StandardFileTimeseries object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "fileLocation":
                    reader.getTextContent().ifPresent(object::setFileLocation);
                    return;
                case "fileType":
                    object.setFileType(reader.getObjectUsingBuilder(CodeAdapter.class));
                    return;
                case "mimeType":
                    object.setMimeType(reader.getObjectUsingBuilder(CodeAdapter.class));
                    return;
                case "adeOfStandardFileTimeseries":
                    ADEBuilderHelper.addADEContainer(ADEOfStandardFileTimeseries.class, object.getADEOfStandardFileTimeseries(), GenericADEOfStandardFileTimeseries::new, reader);
                    return;
            }
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(StandardFileTimeseries object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "StandardFileTimeseries");
    }

    @Override
    public void writeChildElements(StandardFileTimeseries object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        if (object.getFileLocation() != null)
            writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "fileLocation").addTextContent(object.getFileLocation()));

        if (object.getFileType() != null)
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "fileType"), object.getFileType(), CodeAdapter.class, namespaces);

        if (object.getMimeType() != null)
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "mimeType"), object.getMimeType(), CodeAdapter.class, namespaces);

        for (ADEOfStandardFileTimeseries container : object.getADEOfStandardFileTimeseries())
            ADESerializerHelper.writeADEContainer(Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "adeOfStandardFileTimeseries"), container, namespaces, writer);
    }
}
