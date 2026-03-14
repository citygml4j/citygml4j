/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.core;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.base.AbstractInlineProperty;

public class QualifiedVolumeProperty extends AbstractInlineProperty<QualifiedVolume> implements CityGMLObject {

    public QualifiedVolumeProperty() {
    }

    public QualifiedVolumeProperty(QualifiedVolume object) {
        super(object);
    }

    @Override
    public Class<QualifiedVolume> getTargetType() {
        return QualifiedVolume.class;
    }
}
