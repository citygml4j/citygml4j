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
import org.citygml4j.model.core.AbstractSpaceBoundary;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractReliefComponent extends AbstractSpaceBoundary {
    private int lod;
    private ExtentProperty extent;
    private List<ADEOfAbstractReliefComponent> adeOfAbstractReliefComponent;

    public AbstractReliefComponent() {
    }

    public AbstractReliefComponent(int lod) {
        setLod(lod);
    }

    public int getLod() {
        return lod;
    }

    public void setLod(int lod) {
        if (lod >= 0)
            this.lod = lod;
    }

    public ExtentProperty getExtent() {
        return extent;
    }

    public void setExtent(ExtentProperty extent) {
        this.extent = asChild(extent);
    }

    public List<ADEOfAbstractReliefComponent> getADEOfAbstractReliefComponent() {
        if (adeOfAbstractReliefComponent == null)
            adeOfAbstractReliefComponent = new ChildList<>(this);

        return adeOfAbstractReliefComponent;
    }

    public void setADEOfAbstractReliefComponent(List<ADEOfAbstractReliefComponent> adeOfAbstractReliefComponent) {
        this.adeOfAbstractReliefComponent = asChild(adeOfAbstractReliefComponent);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (adeOfAbstractReliefComponent != null) {
            for (ADEOfAbstractReliefComponent container : adeOfAbstractReliefComponent)
                updateEnvelope(container, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (adeOfAbstractReliefComponent != null) {
            for (ADEOfAbstractReliefComponent container : adeOfAbstractReliefComponent)
                updateGeometryInfo(container, geometryInfo);
        }
    }
}
