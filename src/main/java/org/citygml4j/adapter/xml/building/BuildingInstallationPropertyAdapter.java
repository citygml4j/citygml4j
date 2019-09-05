package org.citygml4j.adapter.xml.building;

import org.citygml4j.model.building.BuildingInstallationProperty;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class BuildingInstallationPropertyAdapter extends AbstractFeaturePropertyAdapter<BuildingInstallationProperty> {

    @Override
    public BuildingInstallationProperty createObject(QName name) {
        return new BuildingInstallationProperty();
    }
}
