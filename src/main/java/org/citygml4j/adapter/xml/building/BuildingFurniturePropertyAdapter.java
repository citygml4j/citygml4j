package org.citygml4j.adapter.xml.building;

import org.citygml4j.model.building.BuildingFurnitureProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class BuildingFurniturePropertyAdapter extends AbstractFeaturePropertyAdapter<BuildingFurnitureProperty> {

    @Override
    public BuildingFurnitureProperty createObject(QName name) throws ObjectBuildException {
        return new BuildingFurnitureProperty();
    }
}
