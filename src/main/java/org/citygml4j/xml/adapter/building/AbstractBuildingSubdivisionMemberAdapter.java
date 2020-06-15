package org.citygml4j.xml.adapter.building;

import org.citygml4j.model.building.AbstractBuildingSubdivisionMember;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeatureMemberAdapter;

import javax.xml.namespace.QName;

public class AbstractBuildingSubdivisionMemberAdapter extends AbstractFeatureMemberAdapter<AbstractBuildingSubdivisionMember> {

    @Override
    public AbstractBuildingSubdivisionMember createObject(QName name, Object parent) throws ObjectBuildException {
        return new AbstractBuildingSubdivisionMember();
    }
}
