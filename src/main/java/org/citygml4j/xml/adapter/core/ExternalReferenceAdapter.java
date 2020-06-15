package org.citygml4j.xml.adapter.core;

import org.citygml4j.model.core.ExternalReference;
import org.citygml4j.model.deprecated.core.ExternalObject;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.deprecated.core.ExternalObjectAdapter;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.serializer.ObjectSerializer;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElement(name = "ExternalReference", namespaceURI = CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE)
public class ExternalReferenceAdapter implements ObjectBuilder<ExternalReference>, ObjectSerializer<ExternalReference> {

    @Override
    public ExternalReference createObject(QName name, Object parent) throws ObjectBuildException {
        return new ExternalReference();
    }

    @Override
    public void buildChildObject(ExternalReference object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isCoreNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "targetResource":
                    reader.getTextContent().ifPresent(object::setTargetResource);
                    break;
                case "informationSystem":
                    reader.getTextContent().ifPresent(object::setInformationSystem);
                    break;
                case "relationType":
                    reader.getTextContent().ifPresent(object::setRelationType);
                    break;
                case "externalObject":
                    if (object.getTargetResource() == null) {
                        ExternalObject externalObject = reader.getObjectUsingBuilder(ExternalObjectAdapter.class);
                        if (externalObject.isSetURI())
                            object.setTargetResource(externalObject.getURI());
                        else if (externalObject.isSetName())
                            object.setExternalObjectName(externalObject.getName());
                    }
                    break;
            }
        }
    }

    @Override
    public Element createElement(ExternalReference object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLSerializerHelper.getCoreNamespace(namespaces), "ExternalReference");
    }

    @Override
    public void writeChildElements(ExternalReference object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        String coreNamespace = CityGMLSerializerHelper.getCoreNamespace(namespaces);

        if (CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE.equals(coreNamespace)) {
            String targetResource = object.isSetTargetResource() ? object.getTargetResource() : object.getExternalObjectName();
            if (targetResource != null)
                writer.writeElement(Element.of(coreNamespace, "targetResource").addTextContent(targetResource));

            if (object.getInformationSystem() != null)
                writer.writeElement(Element.of(coreNamespace, "informationSystem").addTextContent(object.getInformationSystem()));

            if (object.getRelationType() != null)
                writer.writeElement(Element.of(coreNamespace, "relationType").addTextContent(object.getRelationType()));
        } else {
            if (object.getInformationSystem() != null)
                writer.writeElement(Element.of(coreNamespace, "informationSystem").addTextContent(object.getInformationSystem()));

            if (object.isSetTargetResource())
                writer.writeElementUsingSerializer(Element.of(coreNamespace, "externalObject"), ExternalObject.ofURI(object.getTargetResource()), ExternalObjectAdapter.class, namespaces);
            else if (object.isSetExternalObjectName())
                writer.writeElementUsingSerializer(Element.of(coreNamespace, "externalObject"), ExternalObject.ofName(object.getExternalObjectName()), ExternalObjectAdapter.class, namespaces);
        }
    }
}
