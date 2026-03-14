/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.util.reference;

import org.xmlobjects.gml.model.base.AbstractGML;
import org.xmlobjects.gml.model.feature.AbstractFeature;
import org.xmlobjects.gml.model.geometry.AbstractGeometry;

public enum ResolveMode {
    ALL_OBJECTS(AbstractGML.class),
    FEATURES_ONLY(AbstractFeature.class),
    GEOMETRIES_ONLY(AbstractGeometry.class);

    private final Class<? extends AbstractGML> type;

    ResolveMode(Class<? extends AbstractGML> type) {
        this.type = type;
    }

    Class<? extends AbstractGML> getType() {
        return type;
    }
}
