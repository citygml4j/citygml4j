package org.citygml4j.xml.adapter.building;

import org.citygml4j.model.building.BuildingUnitProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class BuildingUnitPropertyAdapter extends AbstractFeaturePropertyAdapter<BuildingUnitProperty> {

    @Override
    public BuildingUnitProperty createObject(QName name) throws ObjectBuildException {
        return new BuildingUnitProperty();
    }
}
