package org.citygml4j.model.bridge;

import org.citygml4j.model.construction.AbstractConstructionSurface;
import org.citygml4j.model.core.AbstractSpaceBoundary;
import org.citygml4j.model.core.AbstractUnoccupiedSpace;
import org.citygml4j.model.core.ClosureSurface;
import org.citygml4j.model.core.StandardObjectClassifier;
import org.citygml4j.model.generics.GenericThematicSurface;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class BridgeRoom extends AbstractUnoccupiedSpace implements StandardObjectClassifier {
    private Code classifier;
    private List<Code> functions;
    private List<Code> usages;
    private List<BridgeFurnitureProperty> bridgeFurniture;
    private List<BridgeInstallationProperty> bridgeInstallations;
    private List<ADEPropertyOfBridgeRoom> adeProperties;

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

    public List<ADEPropertyOfBridgeRoom> getADEPropertiesOfBridgeRoom() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfBridgeRoom(List<ADEPropertyOfBridgeRoom> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
