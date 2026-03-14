/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.deprecated.cityobjectgroup;

import org.citygml4j.core.model.deprecated.core.DeprecatedPropertiesOfAbstractCityObject;
import org.xmlobjects.gml.model.geometry.GeometryProperty;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class DeprecatedPropertiesOfCityObjectGroup extends DeprecatedPropertiesOfAbstractCityObject {
    private List<GroupMember> groupMembers;
    private GroupParentMember groupParent;
    private GeometryProperty<?> geometry;

    public List<GroupMember> getGroupMembers() {
        if (groupMembers == null) {
            groupMembers = new ChildList<>(this);
        }

        return groupMembers;
    }

    public boolean isSetGroupMembers() {
        return groupMembers != null && !groupMembers.isEmpty();
    }

    public void setGroupMembers(List<GroupMember> groupMembers) {
        this.groupMembers = asChild(groupMembers);
    }

    public GroupParentMember getGroupParent() {
        return groupParent;
    }

    public void setGroupParent(GroupParentMember groupParent) {
        this.groupParent = asChild(groupParent);
    }

    public GeometryProperty<?> getGeometry() {
        return geometry;
    }

    public void setGeometry(GeometryProperty<?> geometry) {
        this.geometry = asChild(geometry);
    }
}
