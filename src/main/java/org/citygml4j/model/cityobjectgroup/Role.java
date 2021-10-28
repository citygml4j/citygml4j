/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2020 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.model.cityobjectgroup;

import org.citygml4j.model.CityGMLObject;
import org.citygml4j.visitor.ObjectVisitor;
import org.citygml4j.visitor.Visitable;
import org.xmlobjects.gml.model.base.AbstractGML;
import org.xmlobjects.gml.model.base.Reference;

public class Role extends AbstractGML implements CityGMLObject, Visitable {
    private String role;
    private Reference groupMember;

    public Role() {
    }

    public Role(String role, Reference groupMember) {
        this.role = role;
        setGroupMember(groupMember);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Reference getGroupMember() {
        return groupMember;
    }

    public void setGroupMember(Reference groupMember) {
        this.groupMember = asChild(groupMember);
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
