/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.deprecated.core;

import org.xmlobjects.gml.model.geometry.aggregates.MultiSurfaceProperty;

public class DeprecatedPropertiesOfAbstractThematicSurface extends DeprecatedPropertiesOfAbstractCityObject {
    private MultiSurfaceProperty lod4MultiSurface;

    public MultiSurfaceProperty getLod4MultiSurface() {
        return lod4MultiSurface;
    }

    public void setLod4MultiSurface(MultiSurfaceProperty lod4MultiSurface) {
        this.lod4MultiSurface = asChild(lod4MultiSurface);
    }
}
