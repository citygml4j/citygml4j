package org.citygml4j.xml.adapter.building;

import org.citygml4j.model.building.BuildingFurnitureMember;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeatureMemberAdapter;

import javax.xml.namespace.QName;

public class BuildingFurnitureMemberAdapter extends AbstractFeatureMemberAdapter<BuildingFurnitureMember> {

    @Override
    public BuildingFurnitureMember createObject(QName name, Object parent) throws ObjectBuildException {
        return new BuildingFurnitureMember();
    }
}
