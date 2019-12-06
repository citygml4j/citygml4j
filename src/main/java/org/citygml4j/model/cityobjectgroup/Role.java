package org.citygml4j.model.cityobjectgroup;

import org.citygml4j.model.CityGMLObject;
import org.citygml4j.model.core.AbstractCityObjectProperty;
import org.citygml4j.visitor.ObjectVisitor;
import org.citygml4j.visitor.Visitable;
import org.xmlobjects.gml.model.base.AbstractGML;

public class Role extends AbstractGML implements CityGMLObject, Visitable {
    private String role;
    private AbstractCityObjectProperty groupMember;

    public Role() {
    }

    public Role(String role, AbstractCityObjectProperty groupMember) {
        this.role = role;
        setGroupMember(groupMember);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public AbstractCityObjectProperty getGroupMember() {
        return groupMember;
    }

    public void setGroupMember(AbstractCityObjectProperty groupMember) {
        this.groupMember = asChild(groupMember);
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
