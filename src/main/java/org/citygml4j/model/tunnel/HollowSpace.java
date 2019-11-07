package org.citygml4j.model.tunnel;

import org.citygml4j.model.construction.AbstractConstructionSurface;
import org.citygml4j.model.core.AbstractThematicSurface;
import org.citygml4j.model.core.AbstractUnoccupiedSpace;
import org.citygml4j.model.core.ClosureSurface;
import org.citygml4j.model.core.StandardObjectClassifier;
import org.citygml4j.model.generics.GenericThematicSurface;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class HollowSpace extends AbstractUnoccupiedSpace implements StandardObjectClassifier {
    private Code classifier;
    private List<Code> functions;
    private List<Code> usages;
    private List<TunnelFurnitureProperty> tunnelFurniture;
    private List<TunnelInstallationProperty> tunnelInstallations;
    private List<ADEPropertyOfHollowSpace> adeProperties;

    @Override
    public boolean isValidBoundarySurface(AbstractThematicSurface boundarySurface) {
        return boundarySurface instanceof AbstractConstructionSurface
                || boundarySurface instanceof ClosureSurface
                || boundarySurface instanceof GenericThematicSurface;
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

    public List<ADEPropertyOfHollowSpace> getADEPropertiesOfHollowSpace() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfHollowSpace(List<ADEPropertyOfHollowSpace> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
