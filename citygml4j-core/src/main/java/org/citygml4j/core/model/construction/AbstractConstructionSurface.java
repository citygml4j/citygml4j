/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.construction;

import org.citygml4j.core.model.core.AbstractThematicSurface;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractConstructionSurface extends AbstractThematicSurface {
    private List<AbstractFillingSurfaceProperty> fillingSurfaces;

    public List<AbstractFillingSurfaceProperty> getFillingSurfaces() {
        if (fillingSurfaces == null)
            fillingSurfaces = new ChildList<>(this);

        return fillingSurfaces;
    }

    public boolean isSetFillingSurfaces() {
        return fillingSurfaces != null && !fillingSurfaces.isEmpty();
    }

    public void setFillingSurfaces(List<AbstractFillingSurfaceProperty> fillingSurfaces) {
        this.fillingSurfaces = asChild(fillingSurfaces);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (fillingSurfaces != null) {
            for (AbstractFillingSurfaceProperty property : fillingSurfaces) {
                if (property.getObject() != null) {
                    envelope.include(property.getObject().computeEnvelope(options));
                }
            }
        }
    }
}
