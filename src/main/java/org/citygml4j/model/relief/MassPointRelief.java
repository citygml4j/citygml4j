/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2021 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.citygml4j.model.relief;

import org.citygml4j.model.common.GeometryInfo;
import org.citygml4j.model.core.AbstractPointCloudProperty;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.model.geometry.aggregates.MultiPointProperty;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class MassPointRelief extends AbstractReliefComponent {
    private MultiPointProperty reliefPoints;
    private AbstractPointCloudProperty pointCloud;
    private List<ADEOfMassPointRelief> adeOfMassPointRelief;

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

    public List<ADEOfMassPointRelief> getADEOfMassPointRelief() {
        if (adeOfMassPointRelief == null)
            adeOfMassPointRelief = new ChildList<>(this);

        return adeOfMassPointRelief;
    }

    public void setADEOfMassPointRelief(List<ADEOfMassPointRelief> adeOfMassPointRelief) {
        this.adeOfMassPointRelief = asChild(adeOfMassPointRelief);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (reliefPoints != null && reliefPoints.getObject() != null)
            envelope.include(reliefPoints.getObject().computeEnvelope());

        if (pointCloud != null && pointCloud.getObject() != null)
            envelope.include(pointCloud.getObject().computeEnvelope(options));

        if (adeOfMassPointRelief != null) {
            for (ADEOfMassPointRelief container : adeOfMassPointRelief)
                updateEnvelope(container, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        geometryInfo.addGeometry(getLod(), reliefPoints);

        if (adeOfMassPointRelief != null) {
            for (ADEOfMassPointRelief container : adeOfMassPointRelief)
                updateGeometryInfo(container, geometryInfo);
        }
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
