package org.citygml4j.adapter.xml.building;

import org.citygml4j.model.building.RoomHeightProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.AbstractInlinePropertyAdapter;

import javax.xml.namespace.QName;

public class RoomHeightPropertyAdapter extends AbstractInlinePropertyAdapter<RoomHeightProperty> {

    @Override
    public RoomHeightProperty createObject(QName name) throws ObjectBuildException {
        return new RoomHeightProperty();
    }
}
