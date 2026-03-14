/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.versioning.ADEOfVersion;
import org.w3c.dom.Element;

public class GenericADEOfVersion extends ADEOfVersion implements ADEGenericProperty {
    private Element value;

    private GenericADEOfVersion(Element value) {
        this.value = value;
    }

    public static GenericADEOfVersion of(Element value) {
        return new GenericADEOfVersion(value);
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
