package org.citygml4j.xml.adapter.building;

import org.citygml4j.model.building.BuildingConstructiveElementProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class BuildingConstructiveElementPropertyAdapter extends AbstractFeaturePropertyAdapter<BuildingConstructiveElementProperty> {

    @Override
    public BuildingConstructiveElementProperty createObject(QName name, Object parent) throws ObjectBuildException {
        return new BuildingConstructiveElementProperty();
    }
}
