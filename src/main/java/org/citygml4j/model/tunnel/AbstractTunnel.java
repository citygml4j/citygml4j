package org.citygml4j.model.tunnel;

import org.citygml4j.model.common.GeometryInfo;
import org.citygml4j.model.construction.AbstractConstruction;
import org.citygml4j.model.construction.RelationToConstruction;
import org.citygml4j.model.core.StandardObjectClassifier;
import org.citygml4j.model.deprecated.tunnel.DeprecatedPropertiesOfAbstractTunnel;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractTunnel extends AbstractConstruction implements StandardObjectClassifier {
    private Code classifier;
    private List<Code> functions;
    private List<Code> usages;
    private List<TunnelConstructiveElementMember> tunnelConstructiveElements;
    private List<TunnelInstallationMember> tunnelInstallations;
    private List<HollowSpaceMember> hollowSpaces;
    private List<TunnelFurnitureMember> tunnelFurniture;
    private List<ADEOfAbstractTunnel> adeOfAbstractTunnel;

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

    public List<TunnelConstructiveElementMember> getTunnelConstructiveElements() {
        if (tunnelConstructiveElements == null)
            tunnelConstructiveElements = new ChildList<>(this);

        return tunnelConstructiveElements;
    }

    public void setTunnelConstructiveElements(List<TunnelConstructiveElementMember> tunnelConstructiveElements) {
        this.tunnelConstructiveElements = asChild(tunnelConstructiveElements);
    }

    public List<TunnelInstallationMember> getTunnelInstallations() {
        if (tunnelInstallations == null)
            tunnelInstallations = new ChildList<>(this);

        return tunnelInstallations;
    }

    public void setTunnelInstallations(List<TunnelInstallationMember> tunnelInstallations) {
        this.tunnelInstallations = asChild(tunnelInstallations);
    }

    public List<HollowSpaceMember> getHollowSpaces() {
        if (hollowSpaces == null)
            hollowSpaces = new ChildList<>(this);

        return hollowSpaces;
    }

    public void setHollowSpaces(List<HollowSpaceMember> hollowSpaces) {
        this.hollowSpaces = asChild(hollowSpaces);
    }

    public List<TunnelFurnitureMember> getTunnelFurniture() {
        if (tunnelFurniture == null)
            tunnelFurniture = new ChildList<>(this);

        return tunnelFurniture;
    }

    public void setTunnelFurniture(List<TunnelFurnitureMember> tunnelFurniture) {
        this.tunnelFurniture = asChild(tunnelFurniture);
    }

    @Override
    public DeprecatedPropertiesOfAbstractTunnel getDeprecatedProperties() {
        return (DeprecatedPropertiesOfAbstractTunnel) super.getDeprecatedProperties();
    }

    @Override
    protected DeprecatedPropertiesOfAbstractTunnel createDeprecatedProperties() {
        return new DeprecatedPropertiesOfAbstractTunnel();
    }

    public List<ADEOfAbstractTunnel> getADEOfAbstractTunnel() {
        if (adeOfAbstractTunnel == null)
            adeOfAbstractTunnel = new ChildList<>(this);

        return adeOfAbstractTunnel;
    }

    public void setADEOfAbstractTunnel(List<ADEOfAbstractTunnel> adeOfAbstractTunnel) {
        this.adeOfAbstractTunnel = asChild(adeOfAbstractTunnel);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (tunnelConstructiveElements != null) {
            for (TunnelConstructiveElementMember member : tunnelConstructiveElements) {
                if (member.getObject() != null)
                    envelope.include(member.getObject().computeEnvelope(options));
            }
        }

        if (tunnelInstallations != null) {
            for (TunnelInstallationMember member : tunnelInstallations) {
                if (member.getObject() != null && member.getObject().getRelationToConstruction() != RelationToConstruction.INSIDE)
                    envelope.include(member.getObject().computeEnvelope(options));
            }
        }

        if (hasDeprecatedProperties()) {
            DeprecatedPropertiesOfAbstractTunnel properties = getDeprecatedProperties();

            for (TunnelPartProperty property : properties.getConsistsOfTunnelParts()) {
                if (property.getObject() != null)
                    envelope.include(property.getObject().computeEnvelope(options));
            }

            if (properties.getLod1MultiSurface() != null && properties.getLod1MultiSurface().getObject() != null)
                envelope.include(properties.getLod1MultiSurface().getObject().computeEnvelope());

            if (properties.getLod4MultiCurve() != null && properties.getLod4MultiCurve().getObject() != null)
                envelope.include(properties.getLod4MultiCurve().getObject().computeEnvelope());

            if (properties.getLod4MultiSurface() != null && properties.getLod4MultiSurface().getObject() != null)
                envelope.include(properties.getLod4MultiSurface().getObject().computeEnvelope());

            if (properties.getLod4Solid() != null && properties.getLod4Solid().getObject() != null)
                envelope.include(properties.getLod4Solid().getObject().computeEnvelope());
        }

        if (adeProperties != null) {
            for (ADEOfAbstractTunnel<?> property : adeProperties)
                updateEnvelope(property, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (hasDeprecatedProperties()) {
            DeprecatedPropertiesOfAbstractTunnel properties = getDeprecatedProperties();

            geometryInfo.addGeometry(1, properties.getLod1MultiSurface());
            geometryInfo.addGeometry(4, properties.getLod4MultiCurve());
            geometryInfo.addGeometry(4, properties.getLod4MultiSurface());
            geometryInfo.addGeometry(4, properties.getLod4Solid());
        }

        if (adeProperties != null) {
            for (ADEOfAbstractTunnel<?> property : adeProperties)
                updateGeometryInfo(property, geometryInfo);
        }
    }
}
