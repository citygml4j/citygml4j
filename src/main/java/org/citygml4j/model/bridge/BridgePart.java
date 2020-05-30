package org.citygml4j.model.bridge;

import org.citygml4j.model.common.GeometryInfo;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class BridgePart extends AbstractBridge {
    private List<ADEOfBridgePart> adeOfBridgePart;

    public List<ADEOfBridgePart> getADEOfBridgePart() {
        if (adeOfBridgePart == null)
            adeOfBridgePart = new ChildList<>(this);

        return adeOfBridgePart;
    }

    public void setADEOfBridgePart(List<ADEOfBridgePart> adeOfBridgePart) {
        this.adeOfBridgePart = asChild(adeOfBridgePart);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (adeOfBridgePart != null) {
            for (ADEOfBridgePart container : adeOfBridgePart)
                updateEnvelope(container, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (adeOfBridgePart != null) {
            for (ADEOfBridgePart container : adeOfBridgePart)
                updateGeometryInfo(container, geometryInfo);
        }
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
