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

package org.citygml4j.model.core;

import org.citygml4j.model.common.GeometryInfo;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractSpaceBoundary extends AbstractCityObject {
    private List<ADEOfAbstractSpaceBoundary> adeOfAbstractSpaceBoundary;

    public List<ADEOfAbstractSpaceBoundary> getADEOfAbstractSpaceBoundary() {
        if (adeOfAbstractSpaceBoundary == null)
            adeOfAbstractSpaceBoundary = new ChildList<>(this);

        return adeOfAbstractSpaceBoundary;
    }

    public void setADEOfAbstractSpaceBoundary(List<ADEOfAbstractSpaceBoundary> adeOfAbstractSpaceBoundary) {
        this.adeOfAbstractSpaceBoundary = asChild(adeOfAbstractSpaceBoundary);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (adeOfAbstractSpaceBoundary != null) {
            for (ADEOfAbstractSpaceBoundary container : adeOfAbstractSpaceBoundary)
                updateEnvelope(container, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (adeOfAbstractSpaceBoundary != null) {
            for (ADEOfAbstractSpaceBoundary container : adeOfAbstractSpaceBoundary)
                updateGeometryInfo(container, geometryInfo);
        }
    }
}
