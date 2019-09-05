package org.citygml4j.adapter.xml.building;

import org.citygml4j.model.building.BuildingFurnitureMember;
import org.xmlobjects.gml.adapter.feature.AbstractFeatureMemberAdapter;

import javax.xml.namespace.QName;

public class BuildingFurnitureMemberAdapter extends AbstractFeatureMemberAdapter<BuildingFurnitureMember> {

    @Override
    public BuildingFurnitureMember createObject(QName name) {
        return new BuildingFurnitureMember();
    }
}
