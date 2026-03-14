/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.core;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.base.AbstractInlineProperty;

public class ExternalReferenceProperty extends AbstractInlineProperty<ExternalReference> implements CityGMLObject {

    public ExternalReferenceProperty() {
    }

    public ExternalReferenceProperty(ExternalReference object) {
        super(object);
    }

    @Override
    public Class<ExternalReference> getTargetType() {
        return ExternalReference.class;
    }
}
