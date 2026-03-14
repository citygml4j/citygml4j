/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.cityobjectgroup;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.base.AbstractInlineProperty;

public class RoleProperty extends AbstractInlineProperty<Role> implements CityGMLObject {

    public RoleProperty() {
    }

    public RoleProperty(Role object) {
        super(object);
    }

    @Override
    public Class<Role> getTargetType() {
        return Role.class;
    }
}
