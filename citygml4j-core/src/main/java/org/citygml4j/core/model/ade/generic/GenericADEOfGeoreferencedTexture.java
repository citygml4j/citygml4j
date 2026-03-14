/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.citygml4j.core.model.appearance.ADEOfGeoreferencedTexture;
import org.w3c.dom.Element;

public class GenericADEOfGeoreferencedTexture extends ADEOfGeoreferencedTexture implements ADEGenericProperty {
    private Element value;

    private GenericADEOfGeoreferencedTexture(Element value) {
        this.value = value;
    }

    public static GenericADEOfGeoreferencedTexture of(Element value) {
        return new GenericADEOfGeoreferencedTexture(value);
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
