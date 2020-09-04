/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2020 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.model.building;

import org.citygml4j.model.common.GeometryInfo;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.base.Reference;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class Storey extends AbstractBuildingSubdivision {
    private List<Reference> buildingUnits;
    private List<ADEOfStorey> adeOfStorey;

    public List<Reference> getBuildingUnits() {
        if (buildingUnits == null)
            buildingUnits = new ChildList<>(this);

        return buildingUnits;
    }

    public void setBuildingUnits(List<Reference> buildingUnits) {
        this.buildingUnits = asChild(buildingUnits);
    }

    public List<ADEOfStorey> getADEOfStorey() {
        if (adeOfStorey == null)
            adeOfStorey = new ChildList<>(this);

        return adeOfStorey;
    }

    public void setADEOfStorey(List<ADEOfStorey> adeOfStorey) {
        this.adeOfStorey = asChild(adeOfStorey);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (adeOfStorey != null) {
            for (ADEOfStorey container : adeOfStorey)
                updateEnvelope(container, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (adeOfStorey != null) {
            for (ADEOfStorey container : adeOfStorey)
                updateGeometryInfo(container, geometryInfo);
        }
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
