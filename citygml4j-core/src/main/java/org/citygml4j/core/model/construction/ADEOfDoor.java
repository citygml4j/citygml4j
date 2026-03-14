/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.construction;

import org.citygml4j.core.model.ade.ADEProperty;

public abstract class ADEOfDoor extends ADEProperty {

    @Override
    public final Class<Door> getTargetType() {
        return Door.class;
    }
}
