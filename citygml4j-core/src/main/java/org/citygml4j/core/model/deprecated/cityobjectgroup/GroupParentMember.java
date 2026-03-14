/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.deprecated.cityobjectgroup;

import org.citygml4j.core.model.CityGMLObject;
import org.citygml4j.core.model.core.AbstractCityObject;
import org.xmlobjects.gml.model.common.GenericElement;
import org.xmlobjects.gml.model.feature.AbstractFeatureMember;

public class GroupParentMember extends AbstractFeatureMember<AbstractCityObject> implements CityGMLObject {

    public GroupParentMember() {
        super();
    }

    public GroupParentMember(AbstractCityObject object) {
        super(object);
    }

    public GroupParentMember(GenericElement element) {
        super(element);
    }

    @Override
    public Class<AbstractCityObject> getTargetType() {
        return AbstractCityObject.class;
    }
}
