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
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class TINRelief extends AbstractReliefComponent {
    private TinProperty tin;
    private List<ADEOfTINRelief> adeOfTINRelief;

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

    public List<ADEOfTINRelief> getADEOfTINRelief() {
        if (adeOfTINRelief == null)
            adeOfTINRelief = new ChildList<>(this);

        return adeOfTINRelief;
    }

    public void setADEOfTINRelief(List<ADEOfTINRelief> adeOfTINRelief) {
        this.adeOfTINRelief = asChild(adeOfTINRelief);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (tin != null && tin.getObject() != null)
            envelope.include(tin.getObject().computeEnvelope());

        if (adeOfTINRelief != null) {
            for (ADEOfTINRelief container : adeOfTINRelief)
                updateEnvelope(container, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        geometryInfo.addGeometry(getLod(), tin);

        if (adeOfTINRelief != null) {
            for (ADEOfTINRelief container : adeOfTINRelief)
                updateGeometryInfo(container, geometryInfo);
        }
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
