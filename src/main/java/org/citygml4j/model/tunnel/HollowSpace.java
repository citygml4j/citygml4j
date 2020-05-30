package org.citygml4j.model.tunnel;

import org.citygml4j.model.common.GeometryInfo;
import org.citygml4j.model.construction.AbstractConstructionSurface;
import org.citygml4j.model.core.AbstractSpaceBoundary;
import org.citygml4j.model.core.AbstractUnoccupiedSpace;
import org.citygml4j.model.core.ClosureSurface;
import org.citygml4j.model.core.StandardObjectClassifier;
import org.citygml4j.model.deprecated.tunnel.DeprecatedPropertiesOfHollowSpace;
import org.citygml4j.model.generics.GenericThematicSurface;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class HollowSpace extends AbstractUnoccupiedSpace implements StandardObjectClassifier {
    private Code classifier;
    private List<Code> functions;
    private List<Code> usages;
    private List<TunnelFurnitureProperty> tunnelFurniture;
    private List<TunnelInstallationProperty> tunnelInstallations;
    private List<ADEOfHollowSpace> adeOfHollowSpace;

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

    public List<TunnelFurnitureProperty> getTunnelFurniture() {
        if (tunnelFurniture == null)
            tunnelFurniture = new ChildList<>(this);

        return tunnelFurniture;
    }

    public void setTunnelFurniture(List<TunnelFurnitureProperty> tunnelFurniture) {
        this.tunnelFurniture = asChild(tunnelFurniture);
    }

    public List<TunnelInstallationProperty> getTunnelInstallations() {
        if (tunnelInstallations == null)
            tunnelInstallations = new ChildList<>(this);

        return tunnelInstallations;
    }

    public void setTunnelInstallations(List<TunnelInstallationProperty> tunnelInstallations) {
        this.tunnelInstallations = asChild(tunnelInstallations);
    }

    @Override
    public DeprecatedPropertiesOfHollowSpace getDeprecatedProperties() {
        return (DeprecatedPropertiesOfHollowSpace) super.getDeprecatedProperties();
    }

    @Override
    protected DeprecatedPropertiesOfHollowSpace createDeprecatedProperties() {
        return new DeprecatedPropertiesOfHollowSpace();
    }

    public List<ADEOfHollowSpace> getADEOfHollowSpace() {
        if (adeOfHollowSpace == null)
            adeOfHollowSpace = new ChildList<>(this);

        return adeOfHollowSpace;
    }

    public void setADEOfHollowSpace(List<ADEOfHollowSpace> adeOfHollowSpace) {
        this.adeOfHollowSpace = asChild(adeOfHollowSpace);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (hasDeprecatedProperties()) {
            DeprecatedPropertiesOfHollowSpace properties = getDeprecatedProperties();

            if (properties.getLod4Solid() != null && properties.getLod4Solid().getObject() != null)
                envelope.include(properties.getLod4Solid().getObject().computeEnvelope());

            if (properties.getLod4MultiSurface() != null && properties.getLod4MultiSurface().getObject() != null)
                envelope.include(properties.getLod4MultiSurface().getObject().computeEnvelope());
        }

        if (adeOfHollowSpace != null) {
            for (ADEOfHollowSpace container : adeOfHollowSpace)
                updateEnvelope(container, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (hasDeprecatedProperties()) {
            DeprecatedPropertiesOfHollowSpace properties = getDeprecatedProperties();

            geometryInfo.addGeometry(4, properties.getLod4Solid());
            geometryInfo.addGeometry(4, properties.getLod4MultiSurface());
        }

        if (adeProperties != null) {
            for (ADEOfHollowSpace<?> property : adeProperties)
                updateGeometryInfo(property, geometryInfo);
        }
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
