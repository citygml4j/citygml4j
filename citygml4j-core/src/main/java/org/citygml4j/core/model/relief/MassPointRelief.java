/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.relief;

import org.citygml4j.core.model.common.GeometryInfo;
import org.citygml4j.core.model.core.AbstractPointCloudProperty;
import org.citygml4j.core.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.model.geometry.aggregates.MultiPointProperty;
import org.xmlobjects.gml.util.EnvelopeOptions;

public class MassPointRelief extends AbstractReliefComponent {
    private MultiPointProperty reliefPoints;
    private AbstractPointCloudProperty pointCloud;

    public MassPointRelief() {
    }

    public MassPointRelief(int lod, MultiPointProperty reliefPoints) {
        super(lod);
        setReliefPoints(reliefPoints);
    }

    public MassPointRelief(int lod, AbstractPointCloudProperty pointCloud) {
        super(lod);
        setPointCloud(pointCloud);
    }

    public MultiPointProperty getReliefPoints() {
        return reliefPoints;
    }

    public void setReliefPoints(MultiPointProperty reliefPoints) {
        this.reliefPoints = asChild(reliefPoints);
    }

    public AbstractPointCloudProperty getPointCloud() {
        return pointCloud;
    }

    public void setPointCloud(AbstractPointCloudProperty pointCloud) {
        this.pointCloud = asChild(pointCloud);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (reliefPoints != null && reliefPoints.getObject() != null)
            envelope.include(reliefPoints.getObject().computeEnvelope());

        if (pointCloud != null && pointCloud.getObject() != null)
            envelope.include(pointCloud.getObject().computeEnvelope(options));
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        geometryInfo.addGeometry(getLod(), reliefPoints);
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
