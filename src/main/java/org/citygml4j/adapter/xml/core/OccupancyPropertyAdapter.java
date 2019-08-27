package org.citygml4j.adapter.xml.core;

import org.citygml4j.model.core.OccupancyProperty;
import org.xmlobjects.gml.adapter.base.AbstractPropertyAdapter;

import javax.xml.namespace.QName;

public class OccupancyPropertyAdapter extends AbstractPropertyAdapter<OccupancyProperty> {

    @Override
    public OccupancyProperty createObject(QName name) {
        return new OccupancyProperty();
    }
}
