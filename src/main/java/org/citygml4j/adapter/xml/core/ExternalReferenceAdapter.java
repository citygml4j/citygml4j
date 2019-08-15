package org.citygml4j.adapter.xml.core;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.deprecated.ExternalObjectAdapter;
import org.citygml4j.model.core.ExternalReference;
import org.citygml4j.model.deprecated.ExternalObject;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

@XMLElement(name = "ExternalReference", namespaceURI = CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE)
public class ExternalReferenceAdapter implements ObjectBuilder<ExternalReference> {

    @Override
    public ExternalReference createObject(QName name) {
        return new ExternalReference();
    }

    @Override
    public void buildChildObject(ExternalReference object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isCityGMLCoreNamespace(name.getNamespaceURI())) {
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
                        object.setTargetResource(externalObject.isSetName() ? externalObject.getName() : externalObject.getURI());
                    }
                    break;
            }
        }
    }
}
