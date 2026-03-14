/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.deprecated.cityobjectgroup;

import org.citygml4j.core.model.CityGMLObject;
import org.citygml4j.core.model.core.AbstractCityObject;
import org.xmlobjects.gml.model.common.GenericElement;
import org.xmlobjects.gml.model.feature.AbstractFeatureMember;

public class GroupMember extends AbstractFeatureMember<AbstractCityObject> implements CityGMLObject {
    private String role;

    public GroupMember() {
    }

    public GroupMember(AbstractCityObject object) {
        super(object);
    }

    public GroupMember(AbstractCityObject object, String role) {
        super(object);
        this.role = role;
    }

    public GroupMember(GenericElement element) {
        super(element);
    }

    public GroupMember(GenericElement element, String role) {
        super(element);
        this.role = role;
    }

    @Override
    public Class<AbstractCityObject> getTargetType() {
        return AbstractCityObject.class;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
