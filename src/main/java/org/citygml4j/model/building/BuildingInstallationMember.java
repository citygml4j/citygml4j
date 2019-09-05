package org.citygml4j.model.building;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.AbstractFeatureMember;

public class BuildingInstallationMember extends AbstractFeatureMember<BuildingInstallation> implements CityGMLObject {

    public BuildingInstallationMember() {
    }

    public BuildingInstallationMember(BuildingInstallation object) {
        super(object);
    }

    @Override
    public Class<BuildingInstallation> getTargetType() {
        return BuildingInstallation.class;
    }
}
