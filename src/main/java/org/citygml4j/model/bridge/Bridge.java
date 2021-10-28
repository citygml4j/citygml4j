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

package org.citygml4j.model.bridge;

import org.citygml4j.model.common.GeometryInfo;
import org.citygml4j.model.common.TopLevelFeature;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class Bridge extends AbstractBridge implements TopLevelFeature {
    private List<BridgePartProperty> bridgeParts;
    private List<ADEOfBridge> adeOfBridge;

    public List<BridgePartProperty> getBridgeParts() {
        if (bridgeParts == null)
            bridgeParts = new ChildList<>(this);

        return bridgeParts;
    }

    public void setBridgeParts(List<BridgePartProperty> bridgeParts) {
        this.bridgeParts = asChild(bridgeParts);
    }

    public List<ADEOfBridge> getADEOfBridge() {
        if (adeOfBridge == null)
            adeOfBridge = new ChildList<>(this);

        return adeOfBridge;
    }

    public void setADEOfBridge(List<ADEOfBridge> adeOfBridge) {
        this.adeOfBridge = asChild(adeOfBridge);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (bridgeParts != null) {
            for (BridgePartProperty property : bridgeParts) {
                if (property.getObject() != null)
                    envelope.include(property.getObject().computeEnvelope(options));
            }
        }

        if (adeOfBridge != null) {
            for (ADEOfBridge container : adeOfBridge)
                updateEnvelope(container, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (adeOfBridge != null) {
            for (ADEOfBridge container : adeOfBridge)
                updateGeometryInfo(container, geometryInfo);
        }
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
