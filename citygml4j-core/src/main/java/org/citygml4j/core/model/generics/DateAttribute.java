/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.generics;

import org.citygml4j.core.model.core.AbstractGenericAttribute;

import java.time.LocalDate;

public class DateAttribute extends AbstractGenericAttribute<LocalDate> {

    public DateAttribute() {
    }

    public DateAttribute(String name, LocalDate value) {
        super(name, value);
    }
}
