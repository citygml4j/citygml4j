/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.core;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.base.AbstractInlineProperty;
import org.xmlobjects.gml.model.base.OwnershipAttributes;

public class CityObjectRelationProperty extends AbstractInlineProperty<CityObjectRelation> implements CityGMLObject, OwnershipAttributes {
    private Boolean owns;

    public CityObjectRelationProperty() {
    }

    public CityObjectRelationProperty(CityObjectRelation object) {
        super(object);
    }

    @Override
    public Boolean getOwns() {
        return owns;
    }

    @Override
    public void setOwns(Boolean owns) {
        this.owns = owns;
    }

    @Override
    public Class<CityObjectRelation> getTargetType() {
        return CityObjectRelation.class;
    }
}
