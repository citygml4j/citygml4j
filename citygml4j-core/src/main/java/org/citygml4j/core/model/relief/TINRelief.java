/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.relief;

import org.citygml4j.core.model.common.GeometryInfo;
import org.citygml4j.core.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;

public class TINRelief extends AbstractReliefComponent {
    private TinProperty tin;

    public TINRelief() {
    }

    public TINRelief(int lod, TinProperty tin) {
        super(lod);
        setTin(tin);
    }

    public TinProperty getTin() {
        return tin;
    }

    public void setTin(TinProperty tin) {
        this.tin = asChild(tin);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (tin != null && tin.getObject() != null)
            envelope.include(tin.getObject().computeEnvelope());
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        geometryInfo.addGeometry(getLod(), tin);
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
