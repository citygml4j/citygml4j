/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.deprecated.construction;

import org.citygml4j.core.model.core.ImplicitGeometryProperty;
import org.citygml4j.core.model.deprecated.core.DeprecatedPropertiesOfAbstractThematicSurface;

public class DeprecatedPropertiesOfAbstractFillingSurface extends DeprecatedPropertiesOfAbstractThematicSurface {
    private ImplicitGeometryProperty lod3ImplicitRepresentation;
    private ImplicitGeometryProperty lod4ImplicitRepresentation;

    public ImplicitGeometryProperty getLod3ImplicitRepresentation() {
        return lod3ImplicitRepresentation;
    }

    public void setLod3ImplicitRepresentation(ImplicitGeometryProperty lod3ImplicitRepresentation) {
        this.lod3ImplicitRepresentation = asChild(lod3ImplicitRepresentation);
    }

    public ImplicitGeometryProperty getLod4ImplicitRepresentation() {
        return lod4ImplicitRepresentation;
    }

    public void setLod4ImplicitRepresentation(ImplicitGeometryProperty lod4ImplicitRepresentation) {
        this.lod4ImplicitRepresentation = asChild(lod4ImplicitRepresentation);
    }
}
