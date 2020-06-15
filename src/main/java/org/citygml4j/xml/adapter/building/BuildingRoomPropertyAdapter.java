package org.citygml4j.xml.adapter.building;

import org.citygml4j.model.building.BuildingRoomProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class BuildingRoomPropertyAdapter extends AbstractFeaturePropertyAdapter<BuildingRoomProperty> {

    @Override
    public BuildingRoomProperty createObject(QName name, Object parent) throws ObjectBuildException {
        return new BuildingRoomProperty();
    }
}
