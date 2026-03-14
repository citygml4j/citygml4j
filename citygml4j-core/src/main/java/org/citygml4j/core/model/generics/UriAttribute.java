/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.generics;

import org.citygml4j.core.model.core.AbstractGenericAttribute;

public class UriAttribute extends AbstractGenericAttribute<String> {

    public UriAttribute() {
    }

    public UriAttribute(String name, String value) {
        super(name, value);
    }
}
