/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2023 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
