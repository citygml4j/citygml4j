package org.citygml4j.adapter.xml.building;

import org.citygml4j.model.building.BuildingRoomProperty;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class BuildingRoomPropertyAdapter extends AbstractFeaturePropertyAdapter<BuildingRoomProperty> {

    @Override
    public BuildingRoomProperty createObject(QName name) {
        return new BuildingRoomProperty();
    }
}
