/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.generics;

import org.citygml4j.core.model.core.AbstractGenericAttribute;

public class IntAttribute extends AbstractGenericAttribute<Integer> {

    public IntAttribute() {
    }

    public IntAttribute(String name, Integer value) {
        super(name, value);
    }
}
