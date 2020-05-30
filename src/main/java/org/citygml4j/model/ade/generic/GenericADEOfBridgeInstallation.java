package org.citygml4j.model.ade.generic;

import org.citygml4j.model.bridge.ADEOfBridgeInstallation;
import org.w3c.dom.Element;

public class GenericADEOfBridgeInstallation extends ADEOfBridgeInstallation implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfBridgeInstallation() {
    }

    public GenericADEOfBridgeInstallation(Element value) {
        this.value = value;
    }

    @Override
    public Element getValue() {
        return value;
    }

    @Override
    public void setValue(Element value) {
        this.value = value;
    }
}
