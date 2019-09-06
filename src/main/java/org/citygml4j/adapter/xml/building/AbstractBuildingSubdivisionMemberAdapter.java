package org.citygml4j.adapter.xml.building;

import org.citygml4j.model.building.AbstractBuildingSubdivisionMember;
import org.xmlobjects.gml.adapter.feature.AbstractFeatureMemberAdapter;

import javax.xml.namespace.QName;

public class AbstractBuildingSubdivisionMemberAdapter extends AbstractFeatureMemberAdapter<AbstractBuildingSubdivisionMember> {

    @Override
    public AbstractBuildingSubdivisionMember createObject(QName name) {
        return new AbstractBuildingSubdivisionMember();
    }
}
