package org.citygml4j.model.bridge;

import org.citygml4j.visitor.ObjectVisitor;
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
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
