package org.citygml4j.adapter.xml.building;

import org.citygml4j.model.building.BuildingUnitProperty;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class BuildingUnitPropertyAdapter extends AbstractFeaturePropertyAdapter<BuildingUnitProperty> {

    @Override
    public BuildingUnitProperty createObject(QName name) {
        return new BuildingUnitProperty();
    }
}
