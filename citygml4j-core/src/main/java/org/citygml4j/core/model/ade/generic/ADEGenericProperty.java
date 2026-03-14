/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade.generic;

import org.w3c.dom.Element;

public interface ADEGenericProperty {
    Element getValue();

    void setValue(Element value);
}
