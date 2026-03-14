/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.core;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.base.AbstractInlineProperty;

public class QualifiedAreaProperty extends AbstractInlineProperty<QualifiedArea> implements CityGMLObject {

    public QualifiedAreaProperty() {
    }

    public QualifiedAreaProperty(QualifiedArea object) {
        super(object);
    }

    @Override
    public Class<QualifiedArea> getTargetType() {
        return QualifiedArea.class;
    }
}
