/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.transportation;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class SectionProperty extends FeatureProperty<Section> implements CityGMLObject {

    public SectionProperty() {
    }

    public SectionProperty(Section object) {
        super(object);
    }

    public SectionProperty(String href) {
        super(href);
    }

    @Override
    public Class<Section> getTargetType() {
        return Section.class;
    }
}
