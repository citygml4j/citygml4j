/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2025 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.core.model.pointcloud;

import org.citygml4j.core.model.common.GeometryInfo;
import org.citygml4j.core.model.core.AbstractPointCloud;
import org.citygml4j.core.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.model.geometry.aggregates.MultiPointProperty;
import org.xmlobjects.gml.util.EnvelopeOptions;

public class PointCloud extends AbstractPointCloud {
    private Code mimeType;
    private String pointFile;
    private String pointFileSrsName;
    private MultiPointProperty points;

    public PointCloud() {
    }

    public PointCloud(Code mimeType, String pointFile, String pointFileSrsName) {
        this.mimeType = mimeType;
        this.pointFile = pointFile;
        this.pointFileSrsName = pointFileSrsName;
    }

    public PointCloud(MultiPointProperty points) {
        setPoints(points);
    }

    public Code getMimeType() {
        return mimeType;
    }

    public void setMimeType(Code mimeType) {
        this.mimeType = mimeType;
    }

    public String getPointFile() {
        return pointFile;
    }

    public void setPointFile(String pointFile) {
        this.pointFile = pointFile;
    }

    public String getPointFileSrsName() {
        return pointFileSrsName;
    }

    public void setPointFileSrsName(String pointFileSrsName) {
        this.pointFileSrsName = pointFileSrsName;
    }

    public MultiPointProperty getPoints() {
        return points;
    }

    public void setPoints(MultiPointProperty points) {
        this.points = asChild(points);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (points != null && points.getObject() != null)
            envelope.include(points.getObject().computeEnvelope());
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        geometryInfo.addGeometry(points);
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
