package org.citygml4j.adapter.xml.building;

import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.adapter.xml.core.AbstractCityObjectAdapter;
import org.citygml4j.adapter.xml.core.AbstractSpaceAdapter;
import org.citygml4j.model.building.Building;
import org.citygml4j.model.core.AbstractSpace;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.gml.adapter.geometry.primitives.AbstractSurfaceAdapter;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "Building", namespaceURI = CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE),
        @XMLElement(name = "Building", namespaceURI = CityGMLConstants.CITYGML_2_0_BUILDING_NAMESPACE),
        @XMLElement(name = "Building", namespaceURI = CityGMLConstants.CITYGML_1_0_BUILDING_NAMESPACE)
})
public class BuildingAdapter extends AbstractSpaceAdapter<Building> {

    @Override
    public Building createObject(QName name) {
        return new Building();
    }

    @Override
    public Element createElement(Building object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLSerializerHelper.getBuildingNamespace(namespaces), "Building");
    }
}
