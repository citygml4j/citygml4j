package org.citygml4j.adapter.xml.cityobjectgroup;

import org.citygml4j.model.cityobjectgroup.RoleProperty;
import org.xmlobjects.gml.adapter.base.AbstractPropertyAdapter;

import javax.xml.namespace.QName;

public class RolePropertyAdapter extends AbstractPropertyAdapter<RoleProperty> {

    @Override
    public RoleProperty createObject(QName name) {
        return new RoleProperty();
    }
}
