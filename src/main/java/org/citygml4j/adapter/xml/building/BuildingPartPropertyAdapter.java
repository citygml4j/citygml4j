package org.citygml4j.adapter.xml.building;

import org.citygml4j.model.building.BuildingPartProperty;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class BuildingPartPropertyAdapter extends AbstractFeaturePropertyAdapter<BuildingPartProperty> {

    @Override
    public BuildingPartProperty createObject(QName name) {
        return new BuildingPartProperty();
    }
}
