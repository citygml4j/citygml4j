/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.cityobjectgroup;

import org.citygml4j.core.model.CityGMLObject;
import org.citygml4j.core.model.core.AbstractCityObjectReference;
import org.citygml4j.core.visitor.ObjectVisitor;
import org.citygml4j.core.visitor.VisitableObject;
import org.xmlobjects.gml.model.base.AbstractGML;

public class Role extends AbstractGML implements CityGMLObject, VisitableObject {
    private String role;
    private AbstractCityObjectReference groupMember;

    public Role() {
    }

    public Role(AbstractCityObjectReference groupMember) {
        setGroupMember(groupMember);
    }

    public Role(String role, AbstractCityObjectReference groupMember) {
        this.role = role;
        setGroupMember(groupMember);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public AbstractCityObjectReference getGroupMember() {
        return groupMember;
    }

    public void setGroupMember(AbstractCityObjectReference groupMember) {
        this.groupMember = asChild(groupMember);
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
