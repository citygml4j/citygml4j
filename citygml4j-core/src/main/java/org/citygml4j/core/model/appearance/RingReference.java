/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.appearance;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.base.AbstractReference;
import org.xmlobjects.gml.model.geometry.primitives.LinearRing;

public class RingReference extends AbstractReference<LinearRing> implements CityGMLObject {

    public RingReference() {
    }

    public RingReference(String href) {
        super(href);
    }

    public RingReference(LinearRing object) {
        super(object);
    }

    @Override
    public Class<LinearRing> getTargetType() {
        return LinearRing.class;
    }
}
