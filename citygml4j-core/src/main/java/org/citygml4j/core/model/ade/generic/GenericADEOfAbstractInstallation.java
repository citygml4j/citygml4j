/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.construction.ADEOfAbstractInstallation;
import org.w3c.dom.Element;

public class GenericADEOfAbstractInstallation extends ADEOfAbstractInstallation implements ADEGenericProperty {
    private Element value;

    private GenericADEOfAbstractInstallation(Element value) {
        this.value = value;
    }

    public static GenericADEOfAbstractInstallation of(Element value) {
        return new GenericADEOfAbstractInstallation(value);
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
