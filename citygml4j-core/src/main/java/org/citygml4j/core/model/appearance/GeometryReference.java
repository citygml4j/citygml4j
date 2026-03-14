/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.appearance;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.base.AbstractReference;
import org.xmlobjects.gml.model.geometry.AbstractGeometry;

public class GeometryReference extends AbstractReference<AbstractGeometry> implements CityGMLObject {

    public GeometryReference() {
    }

    public GeometryReference(String href) {
        super(href);
    }

    public GeometryReference(AbstractGeometry object) {
        super(object);
    }

    @Override
    public Class<AbstractGeometry> getTargetType() {
        return AbstractGeometry.class;
    }
}
