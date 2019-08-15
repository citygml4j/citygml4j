package org.citygml4j.adapter.xml.core;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfAbstractFeatureWithLifespan;
import org.citygml4j.model.core.ADEPropertyOfAbstractFeatureWithLifespan;
import org.citygml4j.model.core.AbstractFeatureWithLifespan;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.GMLBuilderHelper;
import org.xmlobjects.gml.adapter.feature.AbstractFeatureAdapter;
import org.xmlobjects.gml.model.common.GenericElement;
import org.xmlobjects.stream.BuildResult;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

public abstract class AbstractFeatureWithLifespanAdapter<T extends AbstractFeatureWithLifespan> extends AbstractFeatureAdapter<T> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE, "AbstractGenericApplicationPropertyOfAbstractCityObject");

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isCityGMLCoreNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "creationDate":
                    if (CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE.equals(name.getNamespaceURI()))
                        reader.getTextContent().ifDateTime(object::setCreationDate);
                    else
                        reader.getTextContent().ifDate(object::setCreationDate);
                    break;
                case "terminationDate":
                    if (CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE.equals(name.getNamespaceURI()))
                        reader.getTextContent().ifDateTime(object::setTerminationDate);
                    else
                        reader.getTextContent().ifDate(object::setTerminationDate);
                    break;
                case "validFrom":
                    reader.getTextContent().ifDateTime(object::setValidFrom);
                    break;
                case "validTo":
                    reader.getTextContent().ifDateTime(object::setValidTo);
                    break;
            }
        } else if (GMLBuilderHelper.isGMLNamespace(name.getNamespaceURI())) {
            super.buildChildObject(object, name, attributes, reader);
        } else {
            BuildResult<ADEPropertyOfAbstractFeatureWithLifespan> result = reader.getObjectOrDOMElement(ADEPropertyOfAbstractFeatureWithLifespan.class);
            if (result.isSetObject())
                object.getADEPropertiesOfAbstractFeatureWithLifespan().add(result.getObject());
            else if (result.isSetDOMElement()) {
                if (CityGMLBuilderHelper.createAsGenericADEProperty(name, reader, substitutionGroup))
                    object.getADEPropertiesOfAbstractFeatureWithLifespan().add(GenericADEPropertyOfAbstractFeatureWithLifespan.of(result.getDOMElement()));
                else
                    object.getGenericProperties().add(GenericElement.of(result.getDOMElement()));
            }
        }
    }
}
