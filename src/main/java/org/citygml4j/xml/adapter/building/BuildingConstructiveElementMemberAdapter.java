package org.citygml4j.xml.adapter.building;

import org.citygml4j.model.building.BuildingConstructiveElementMember;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeatureMemberAdapter;

import javax.xml.namespace.QName;

public class BuildingConstructiveElementMemberAdapter extends AbstractFeatureMemberAdapter<BuildingConstructiveElementMember> {

    @Override
    public BuildingConstructiveElementMember createObject(QName name, Object parent) throws ObjectBuildException {
        return new BuildingConstructiveElementMember();
    }
}
