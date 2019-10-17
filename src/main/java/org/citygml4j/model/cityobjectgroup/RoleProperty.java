package org.citygml4j.model.cityobjectgroup;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.base.AbstractProperty;

public class RoleProperty extends AbstractProperty<Role> implements CityGMLObject {

    public RoleProperty() {
    }

    public RoleProperty(Role object) {
        super(object);
    }

    public RoleProperty(String href) {
        super(href);
    }

    @Override
    public Class<Role> getTargetType() {
        return Role.class;
    }
}
