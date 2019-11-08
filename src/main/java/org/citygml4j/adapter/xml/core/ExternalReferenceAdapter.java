package org.citygml4j.adapter.xml.core;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.adapter.xml.deprecated.core.ExternalObjectAdapter;
import org.citygml4j.model.core.ExternalReference;
import org.citygml4j.model.deprecated.core.ExternalObject;
import org.citygml4j.util.CityGMLConstants;
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
    public ExternalReference createObject(QName name) throws ObjectBuildException {
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
                        if (externalObject.getURI() != null)
                            object.setTargetResource(externalObject.getURI());
                        else if (externalObject.getName() != null)
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
            String targetResource = object.getTargetResource() != null ? object.getTargetResource() : object.getExternalObjectName();
            if (targetResource != null)
                writer.writeElement(Element.of(coreNamespace, "targetResource").addTextContent(targetResource));

            if (object.getInformationSystem() != null)
                writer.writeElement(Element.of(coreNamespace, "informationSystem").addTextContent(object.getInformationSystem()));

            if (object.getRelationType() != null)
                writer.writeElement(Element.of(coreNamespace, "relationType").addTextContent(object.getRelationType()));
        } else {
            if (object.getInformationSystem() != null)
                writer.writeElement(Element.of(coreNamespace, "informationSystem").addTextContent(object.getInformationSystem()));

            if (object.getTargetResource() != null)
                writer.writeElementUsingSerializer(Element.of(coreNamespace, "externalObject"), ExternalObject.ofURI(object.getTargetResource()), ExternalObjectAdapter.class, namespaces);
            else if (object.getExternalObjectName() != null)
                writer.writeElementUsingSerializer(Element.of(coreNamespace, "externalObject"), ExternalObject.ofName(object.getExternalObjectName()), ExternalObjectAdapter.class, namespaces);
        }
    }
}
