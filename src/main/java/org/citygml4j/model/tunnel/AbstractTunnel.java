package org.citygml4j.model.tunnel;

import org.citygml4j.model.construction.AbstractConstruction;
import org.citygml4j.model.core.StandardObjectClassifier;
import org.citygml4j.model.deprecated.tunnel.DeprecatedPropertiesOfAbstractTunnel;
import org.xmlobjects.gml.model.basictypes.Code;
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
    private List<ADEPropertyOfAbstractTunnel<?>> adeProperties;

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

    public List<ADEPropertyOfAbstractTunnel<?>> getADEPropertiesOfAbstractTunnel() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfAbstractTunnel(List<ADEPropertyOfAbstractTunnel<?>> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
