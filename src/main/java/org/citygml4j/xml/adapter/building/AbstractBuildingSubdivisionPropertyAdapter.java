package org.citygml4j.xml.adapter.building;

import org.citygml4j.model.building.AbstractBuildingSubdivisionProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class AbstractBuildingSubdivisionPropertyAdapter extends AbstractFeaturePropertyAdapter<AbstractBuildingSubdivisionProperty> {

    @Override
    public AbstractBuildingSubdivisionProperty createObject(QName name) throws ObjectBuildException {
        return new AbstractBuildingSubdivisionProperty();
    }
}
