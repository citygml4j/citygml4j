package org.citygml4j.xml.adapter.building;

import org.citygml4j.model.building.BuildingFurnitureProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class BuildingFurniturePropertyAdapter extends AbstractFeaturePropertyAdapter<BuildingFurnitureProperty> {

    @Override
    public BuildingFurnitureProperty createObject(QName name, Object parent) throws ObjectBuildException {
        return new BuildingFurnitureProperty();
    }
}
