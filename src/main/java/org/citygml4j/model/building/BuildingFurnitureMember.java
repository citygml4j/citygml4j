package org.citygml4j.model.building;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.AbstractFeatureMember;

public class BuildingFurnitureMember extends AbstractFeatureMember<BuildingFurniture> implements CityGMLObject {

    public BuildingFurnitureMember() {
    }

    public BuildingFurnitureMember(BuildingFurniture object) {
        super(object);
    }

    @Override
    public Class<BuildingFurniture> getTargetType() {
        return BuildingFurniture.class;
    }
}
