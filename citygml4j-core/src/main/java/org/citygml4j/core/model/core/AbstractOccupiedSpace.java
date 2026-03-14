/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.core;

import org.citygml4j.core.model.common.GeometryInfo;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;

public abstract class AbstractOccupiedSpace extends AbstractPhysicalSpace {
    private ImplicitGeometryProperty lod1ImplicitRepresentation;
    private ImplicitGeometryProperty lod2ImplicitRepresentation;
    private ImplicitGeometryProperty lod3ImplicitRepresentation;

    public ImplicitGeometryProperty getLod1ImplicitRepresentation() {
        return lod1ImplicitRepresentation;
    }

    public void setLod1ImplicitRepresentation(ImplicitGeometryProperty lod1ImplicitRepresentation) {
        this.lod1ImplicitRepresentation = asChild(lod1ImplicitRepresentation);
    }

    public ImplicitGeometryProperty getLod2ImplicitRepresentation() {
        return lod2ImplicitRepresentation;
    }

    public void setLod2ImplicitRepresentation(ImplicitGeometryProperty lod2ImplicitRepresentation) {
        this.lod2ImplicitRepresentation = asChild(lod2ImplicitRepresentation);
    }

    public ImplicitGeometryProperty getLod3ImplicitRepresentation() {
        return lod3ImplicitRepresentation;
    }

    public void setLod3ImplicitRepresentation(ImplicitGeometryProperty lod3ImplicitRepresentation) {
        this.lod3ImplicitRepresentation = asChild(lod3ImplicitRepresentation);
    }

    public ImplicitGeometryProperty getImplicitRepresentation(int lod) {
        return switch (lod) {
            case 1 -> getLod1ImplicitRepresentation();
            case 2 -> getLod2ImplicitRepresentation();
            case 3 -> getLod3ImplicitRepresentation();
            default -> null;
        };
    }

    public boolean setImplicitRepresentation(int lod, ImplicitGeometryProperty property) {
        return switch (lod) {
            case 1 -> {
                setLod1ImplicitRepresentation(property);
                yield true;
            }
            case 2 -> {
                setLod2ImplicitRepresentation(property);
                yield true;
            }
            case 3 -> {
                setLod3ImplicitRepresentation(property);
                yield true;
            }
            default -> false;
        };
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        for (int lod = 1; lod < 4; lod++) {
            ImplicitGeometryProperty property = getImplicitRepresentation(lod);
            if (property != null && property.getObject() != null)
                envelope.include(property.getObject().computeEnvelope());
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        for (int lod = 1; lod < 4; lod++)
            geometryInfo.addImplicitGeometry(lod, getImplicitRepresentation(lod));
    }
}
