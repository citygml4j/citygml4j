/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.core;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.base.AbstractProperty;

public class ImplicitGeometryProperty extends AbstractProperty<ImplicitGeometry> implements CityGMLObject {

    public ImplicitGeometryProperty() {
    }

    public ImplicitGeometryProperty(ImplicitGeometry object) {
        super(object);
    }

    public ImplicitGeometryProperty(String href) {
        super(href);
    }

    @Override
    public Class<ImplicitGeometry> getTargetType() {
        return ImplicitGeometry.class;
    }
}
