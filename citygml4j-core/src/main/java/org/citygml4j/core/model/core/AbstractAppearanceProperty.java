/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.core;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class AbstractAppearanceProperty extends FeatureProperty<AbstractAppearance> implements CityGMLObject {

    public AbstractAppearanceProperty() {
    }

    public AbstractAppearanceProperty(AbstractAppearance object) {
        super(object);
    }

    public AbstractAppearanceProperty(String href) {
        super(href);
    }

    @Override
    public Class<AbstractAppearance> getTargetType() {
        return AbstractAppearance.class;
    }
}
