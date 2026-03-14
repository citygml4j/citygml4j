/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.transportation;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class MarkingProperty extends FeatureProperty<Marking> implements CityGMLObject {

    public MarkingProperty() {
    }

    public MarkingProperty(Marking object) {
        super(object);
    }

    public MarkingProperty(String href) {
        super(href);
    }

    @Override
    public Class<Marking> getTargetType() {
        return Marking.class;
    }
}
