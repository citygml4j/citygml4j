/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.appearance;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.base.AbstractInlineProperty;

public class AbstractTextureParameterizationProperty extends AbstractInlineProperty<AbstractTextureParameterization> implements CityGMLObject {

    public AbstractTextureParameterizationProperty() {
    }

    public AbstractTextureParameterizationProperty(AbstractTextureParameterization object) {
        super(object);
    }

    @Override
    public Class<AbstractTextureParameterization> getTargetType() {
        return AbstractTextureParameterization.class;
    }
}
