package org.citygml4j.adapter.xml.building;

import org.citygml4j.model.building.BuildingConstructiveElementProperty;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class BuildingConstructiveElementPropertyAdapter extends AbstractFeaturePropertyAdapter<BuildingConstructiveElementProperty> {

    @Override
    public BuildingConstructiveElementProperty createObject(QName name) {
        return new BuildingConstructiveElementProperty();
    }
}
