package org.citygml4j.model.building;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.AbstractFeatureMember;

public class BuildingConstructiveElementMember extends AbstractFeatureMember<BuildingConstructiveElement> implements CityGMLObject {

    public BuildingConstructiveElementMember() {
    }

    public BuildingConstructiveElementMember(BuildingConstructiveElement object) {
        super(object);
    }

    @Override
    public Class<BuildingConstructiveElement> getTargetType() {
        return BuildingConstructiveElement.class;
    }
}
