/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.generics;

import org.citygml4j.core.model.core.AbstractGenericAttribute;

public class StringAttribute extends AbstractGenericAttribute<String> {

    public StringAttribute() {
    }

    public StringAttribute(String name, String value) {
        super(name, value);
    }
}
