/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.appearance;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.common.LocalProperties;

public abstract class AbstractTextureParameterization extends GMLObject implements CityGMLObject {
    private LocalProperties localProperties;

    public boolean hasLocalProperties() {
        return localProperties != null;
    }

    public LocalProperties getLocalProperties() {
        if (localProperties == null)
            localProperties = new LocalProperties();

        return localProperties;
    }
}
