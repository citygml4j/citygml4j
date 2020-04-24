package org.citygml4j.model.bridge;

import org.citygml4j.model.core.GeometryInfo;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class Bridge extends AbstractBridge {
    private List<BridgePartProperty> bridgeParts;
    private List<ADEPropertyOfBridge<?>> adeProperties;

    public List<BridgePartProperty> getBridgeParts() {
        if (bridgeParts == null)
            bridgeParts = new ChildList<>(this);

        return bridgeParts;
    }

    public void setBridgeParts(List<BridgePartProperty> bridgeParts) {
        this.bridgeParts = asChild(bridgeParts);
    }

    public List<ADEPropertyOfBridge<?>> getADEPropertiesOfBridge() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfBridge(List<ADEPropertyOfBridge<?>> adeProperties) {
        this.adeProperties = asChild(adeProperties);
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

        if (adeProperties != null) {
            for (ADEPropertyOfBridge<?> property : adeProperties)
                updateEnvelope(property, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (adeProperties != null) {
            for (ADEPropertyOfBridge<?> property : adeProperties)
                updateGeometryInfo(property, geometryInfo);
        }
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
