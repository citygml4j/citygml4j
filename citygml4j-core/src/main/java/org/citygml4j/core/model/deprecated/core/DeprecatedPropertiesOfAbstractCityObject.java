/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.deprecated.core;

import org.citygml4j.core.model.core.AbstractCityObjectProperty;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class DeprecatedPropertiesOfAbstractCityObject extends DeprecatedPropertiesOfAbstractFeature {
    private List<AbstractCityObjectProperty> generalizesTo;

    public List<AbstractCityObjectProperty> getGeneralizesTo() {
        if (generalizesTo == null)
            generalizesTo = new ChildList<>(this);

        return generalizesTo;
    }

    public boolean isSetGeneralizesTo() {
        return generalizesTo != null && !generalizesTo.isEmpty();
    }

    public void setGeneralizesTo(List<AbstractCityObjectProperty> generalizesTo) {
        this.generalizesTo = asChild(generalizesTo);
    }
}
