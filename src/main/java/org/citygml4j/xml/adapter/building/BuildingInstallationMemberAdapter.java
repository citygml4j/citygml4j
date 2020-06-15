package org.citygml4j.xml.adapter.building;

import org.citygml4j.model.building.BuildingInstallationMember;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeatureMemberAdapter;

import javax.xml.namespace.QName;

public class BuildingInstallationMemberAdapter extends AbstractFeatureMemberAdapter<BuildingInstallationMember> {

    @Override
    public BuildingInstallationMember createObject(QName name, Object parent) throws ObjectBuildException {
        return new BuildingInstallationMember();
    }
}
