package org.citygml4j.xml.adapter.cityobjectgroup;

import org.citygml4j.model.cityobjectgroup.RoleProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.AbstractPropertyAdapter;

import javax.xml.namespace.QName;

public class RolePropertyAdapter extends AbstractPropertyAdapter<RoleProperty> {

    @Override
    public RoleProperty createObject(QName name, Object parent) throws ObjectBuildException {
        return new RoleProperty();
    }
}
