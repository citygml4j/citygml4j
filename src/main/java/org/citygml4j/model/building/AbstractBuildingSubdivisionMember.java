package org.citygml4j.model.building;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.AbstractFeatureMember;

public class AbstractBuildingSubdivisionMember extends AbstractFeatureMember<AbstractBuildingSubdivision> implements CityGMLObject {

    public AbstractBuildingSubdivisionMember() {
    }

    public AbstractBuildingSubdivisionMember(AbstractBuildingSubdivision object) {
        super(object);
    }

    @Override
    public Class<AbstractBuildingSubdivision> getTargetType() {
        return AbstractBuildingSubdivision.class;
    }
}
