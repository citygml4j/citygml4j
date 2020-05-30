package org.citygml4j.model.bridge;

import org.citygml4j.model.common.GeometryInfo;
import org.citygml4j.model.construction.AbstractConstructionSurface;
import org.citygml4j.model.core.AbstractSpaceBoundary;
import org.citygml4j.model.core.AbstractUnoccupiedSpace;
import org.citygml4j.model.core.ClosureSurface;
import org.citygml4j.model.core.StandardObjectClassifier;
import org.citygml4j.model.deprecated.bridge.DeprecatedPropertiesOfBridgeRoom;
import org.citygml4j.model.generics.GenericThematicSurface;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class BridgeRoom extends AbstractUnoccupiedSpace implements StandardObjectClassifier {
    private Code classifier;
    private List<Code> functions;
    private List<Code> usages;
    private List<BridgeFurnitureProperty> bridgeFurniture;
    private List<BridgeInstallationProperty> bridgeInstallations;
    private List<ADEOfBridgeRoom> adeOfBridgeRoom;

    @Override
    public boolean isValidBoundary(AbstractSpaceBoundary boundary) {
        return boundary instanceof AbstractConstructionSurface
                || boundary instanceof ClosureSurface
                || boundary instanceof GenericThematicSurface;
    }

    @Override
    public Code getClassifier() {
        return classifier;
    }

    @Override
    public void setClassifier(Code classifier) {
        this.classifier = asChild(classifier);
    }

    @Override
    public List<Code> getFunctions() {
        if (functions == null)
            functions = new ChildList<>(this);

        return functions;
    }

    @Override
    public void setFunctions(List<Code> functions) {
        this.functions = asChild(functions);
    }

    @Override
    public List<Code> getUsages() {
        if (usages == null)
            usages = new ChildList<>(this);

        return usages;
    }

    @Override
    public void setUsages(List<Code> usages) {
        this.usages = asChild(usages);
    }

    public List<BridgeFurnitureProperty> getBridgeFurniture() {
        if (bridgeFurniture == null)
            bridgeFurniture = new ChildList<>(this);

        return bridgeFurniture;
    }

    public void setBridgeFurniture(List<BridgeFurnitureProperty> bridgeFurniture) {
        this.bridgeFurniture = asChild(bridgeFurniture);
    }

    public List<BridgeInstallationProperty> getBridgeInstallations() {
        if (bridgeInstallations == null)
            bridgeInstallations = new ChildList<>(this);

        return bridgeInstallations;
    }

    public void setBridgeInstallations(List<BridgeInstallationProperty> bridgeInstallations) {
        this.bridgeInstallations = asChild(bridgeInstallations);
    }

    @Override
    public DeprecatedPropertiesOfBridgeRoom getDeprecatedProperties() {
        return (DeprecatedPropertiesOfBridgeRoom) super.getDeprecatedProperties();
    }

    @Override
    protected DeprecatedPropertiesOfBridgeRoom createDeprecatedProperties() {
        return new DeprecatedPropertiesOfBridgeRoom();
    }

    public List<ADEOfBridgeRoom> getADEOfBridgeRoom() {
        if (adeOfBridgeRoom == null)
            adeOfBridgeRoom = new ChildList<>(this);

        return adeOfBridgeRoom;
    }

    public void setADEOfBridgeRoom(List<ADEOfBridgeRoom> adeOfBridgeRoom) {
        this.adeOfBridgeRoom = asChild(adeOfBridgeRoom);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (hasDeprecatedProperties()) {
            DeprecatedPropertiesOfBridgeRoom properties = getDeprecatedProperties();

            if (properties.getLod4Solid() != null && properties.getLod4Solid().getObject() != null)
                envelope.include(properties.getLod4Solid().getObject().computeEnvelope());

            if (properties.getLod4MultiSurface() != null && properties.getLod4MultiSurface().getObject() != null)
                envelope.include(properties.getLod4MultiSurface().getObject().computeEnvelope());
        }

        if (adeOfBridgeRoom != null) {
            for (ADEOfBridgeRoom container : adeOfBridgeRoom)
                updateEnvelope(container, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (hasDeprecatedProperties()) {
            DeprecatedPropertiesOfBridgeRoom properties = getDeprecatedProperties();

            geometryInfo.addGeometry(4, properties.getLod4Solid());
            geometryInfo.addGeometry(4, properties.getLod4MultiSurface());
        }

        if (adeOfBridgeRoom != null) {
            for (ADEOfBridgeRoom container : adeOfBridgeRoom)
                updateGeometryInfo(container, geometryInfo);
        }
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
