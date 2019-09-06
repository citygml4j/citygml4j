package org.citygml4j.adapter.xml.building;

import org.citygml4j.model.building.AbstractBuildingSubdivisionProperty;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class AbstractBuildingSubdivisionPropertyAdapter extends AbstractFeaturePropertyAdapter<AbstractBuildingSubdivisionProperty> {

    @Override
    public AbstractBuildingSubdivisionProperty createObject(QName name) {
        return new AbstractBuildingSubdivisionProperty();
    }
}
