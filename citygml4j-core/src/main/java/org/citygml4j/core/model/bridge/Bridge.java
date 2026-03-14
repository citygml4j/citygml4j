/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.bridge;

import org.citygml4j.core.model.common.TopLevelFeature;
import org.citygml4j.core.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class Bridge extends AbstractBridge implements TopLevelFeature {
    private List<BridgePartProperty> bridgeParts;

    public List<BridgePartProperty> getBridgeParts() {
        if (bridgeParts == null)
            bridgeParts = new ChildList<>(this);

        return bridgeParts;
    }

    public boolean isSetBridgeParts() {
        return bridgeParts != null && !bridgeParts.isEmpty();
    }

    public void setBridgeParts(List<BridgePartProperty> bridgeParts) {
        this.bridgeParts = asChild(bridgeParts);
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
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
