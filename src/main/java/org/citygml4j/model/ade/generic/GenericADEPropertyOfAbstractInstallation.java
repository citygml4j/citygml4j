package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEOfAbstractInstallation;
import org.w3c.dom.Element;

public class GenericADEPropertyOfAbstractInstallation extends ADEOfAbstractInstallation<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfAbstractInstallation(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfAbstractInstallation of(Element value) {
        return new GenericADEPropertyOfAbstractInstallation(value);
    }
}
