package org.citygml4j.model.bridge;

import org.citygml4j.model.construction.AbstractConstruction;
import org.citygml4j.model.core.AddressProperty;
import org.citygml4j.model.core.StandardObjectClassifier;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractBridge extends AbstractConstruction implements StandardObjectClassifier {
    private Code classifier;
    private List<Code> functions;
    private List<Code> usages;
    private Boolean isMovable;
    private List<BridgeConstructiveElementMember> bridgeConstructiveElements;
    private List<BridgeInstallationMember> bridgeInstallations;
    private List<BridgeRoomMember> bridgeRooms;
    private List<BridgeFurnitureMember> bridgeFurniture;
    private List<AddressProperty> addresses;
    private List<ADEPropertyOfAbstractBridge<?>> adeProperties;

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

    public Boolean getIsMovable() {
        return isMovable != null ? isMovable : false;
    }

    public boolean isSetIsMovable() {
        return isMovable != null;
    }

    public void setIsMovable(Boolean isMovable) {
        this.isMovable = isMovable;
    }

    public List<BridgeConstructiveElementMember> getBridgeConstructiveElements() {
        if (bridgeConstructiveElements == null)
            bridgeConstructiveElements = new ChildList<>(this);

        return bridgeConstructiveElements;
    }

    public void setBridgeConstructiveElements(List<BridgeConstructiveElementMember> bridgeConstructiveElements) {
        this.bridgeConstructiveElements = asChild(bridgeConstructiveElements);
    }

    public List<BridgeInstallationMember> getBridgeInstallations() {
        if (bridgeInstallations == null)
            bridgeInstallations = new ChildList<>(this);

        return bridgeInstallations;
    }

    public void setBridgeInstallations(List<BridgeInstallationMember> bridgeInstallations) {
        this.bridgeInstallations = asChild(bridgeInstallations);
    }

    public List<BridgeRoomMember> getBridgeRooms() {
        if (bridgeRooms == null)
            bridgeRooms = new ChildList<>(this);

        return bridgeRooms;
    }

    public void setBridgeRooms(List<BridgeRoomMember> bridgeRooms) {
        this.bridgeRooms = asChild(bridgeRooms);
    }

    public List<BridgeFurnitureMember> getBridgeFurniture() {
        if (bridgeFurniture == null)
            bridgeFurniture = new ChildList<>(this);

        return bridgeFurniture;
    }

    public void setBridgeFurniture(List<BridgeFurnitureMember> bridgeFurniture) {
        this.bridgeFurniture = asChild(bridgeFurniture);
    }

    public List<AddressProperty> getAddresses() {
        if (addresses == null)
            addresses = new ChildList<>(this);

        return addresses;
    }

    public void setAddresses(List<AddressProperty> addresses) {
        this.addresses = asChild(addresses);
    }

    public List<ADEPropertyOfAbstractBridge<?>> getADEPropertiesOfAbstractBridge() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfAbstractBridge(List<ADEPropertyOfAbstractBridge<?>> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
