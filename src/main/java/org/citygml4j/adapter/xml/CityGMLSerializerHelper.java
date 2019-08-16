package org.citygml4j.adapter.xml;

import org.citygml4j.model.ade.ADEProperty;
import org.citygml4j.model.ade.generic.ADEGenericProperty;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Namespaces;

public class CityGMLSerializerHelper {

    public static String getBuildingNamespace(Namespaces namespaces) {
        if (namespaces.contains(CityGMLConstants.CITYGML_1_0_BUILDING_NAMESPACE))
            return CityGMLConstants.CITYGML_1_0_BUILDING_NAMESPACE;
        else if (namespaces.contains(CityGMLConstants.CITYGML_2_0_BUILDING_NAMESPACE))
            return CityGMLConstants.CITYGML_2_0_BUILDING_NAMESPACE;
        else
            return CityGMLConstants.CITYGML_2_0_BUILDING_NAMESPACE;
    }

    public static String getGenericsNamespace(Namespaces namespaces) {
        if (namespaces.contains(CityGMLConstants.CITYGML_1_0_GENERICS_NAMESPACE))
            return CityGMLConstants.CITYGML_1_0_GENERICS_NAMESPACE;
        else if (namespaces.contains(CityGMLConstants.CITYGML_2_0_GENERICS_NAMESPACE))
            return CityGMLConstants.CITYGML_2_0_GENERICS_NAMESPACE;
        else
            return CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE;
    }

    public static String getCoreNamespace(Namespaces namespaces) {
        if (namespaces.contains(CityGMLConstants.CITYGML_1_0_CORE_NAMESPACE))
            return CityGMLConstants.CITYGML_1_0_CORE_NAMESPACE;
        else if (namespaces.contains(CityGMLConstants.CITYGML_2_0_CORE_NAMESPACE))
            return CityGMLConstants.CITYGML_2_0_CORE_NAMESPACE;
        else
            return CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE;
    }

    public static void serializeADEProperty(ADEProperty property, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (property instanceof ADEGenericProperty)
            writer.writeDOMElement(((ADEGenericProperty) property).getValue());
        else
            writer.writeObject(property, namespaces);
    }
}
