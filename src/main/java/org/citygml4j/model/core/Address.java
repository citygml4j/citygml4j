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

package org.citygml4j.model.core;

import org.citygml4j.model.common.GeometryInfo;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.model.geometry.aggregates.MultiPointProperty;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class Address extends AbstractFeature {
    private XALAddressProperty xalAddress;
    private MultiPointProperty multiPoint;
    private List<ADEOfAddress> adeOfAddress;

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

    public List<ADEOfAddress> getADEOfAddress() {
        if (adeOfAddress == null)
            adeOfAddress = new ChildList<>(this);

        return adeOfAddress;
    }

    public void setADEOfAddress(List<ADEOfAddress> adeOfAddress) {
        this.adeOfAddress = asChild(adeOfAddress);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        if (multiPoint != null && multiPoint.getObject() != null)
            envelope.include(multiPoint.getObject().computeEnvelope());

        if (adeOfAddress != null) {
            for (ADEOfAddress container : adeOfAddress)
                updateEnvelope(container, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        geometryInfo.addGeometry(multiPoint);

        if (adeOfAddress != null) {
            for (ADEOfAddress container : adeOfAddress)
                updateGeometryInfo(container, geometryInfo);
        }
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
