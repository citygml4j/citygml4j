/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.core;

import org.citygml4j.core.model.common.GeometryInfo;
import org.citygml4j.core.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.model.geometry.aggregates.MultiPointProperty;
import org.xmlobjects.gml.util.EnvelopeOptions;

public class Address extends AbstractFeature {
    private XALAddressProperty xalAddress;
    private MultiPointProperty multiPoint;

    public Address() {
    }

    public Address(XALAddressProperty xalAddress) {
        setXALAddress(xalAddress);
    }

    public XALAddressProperty getXALAddress() {
        return xalAddress;
    }

    public void setXALAddress(XALAddressProperty xalAddress) {
        this.xalAddress = asChild(xalAddress);
    }

    public MultiPointProperty getMultiPoint() {
        return multiPoint;
    }

    public void setMultiPoint(MultiPointProperty multiPoint) {
        this.multiPoint = asChild(multiPoint);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (multiPoint != null && multiPoint.getObject() != null)
            envelope.include(multiPoint.getObject().computeEnvelope());
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        geometryInfo.addGeometry(multiPoint);
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
