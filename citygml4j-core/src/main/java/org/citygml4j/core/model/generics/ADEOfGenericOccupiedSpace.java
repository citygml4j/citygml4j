/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.generics;

import org.citygml4j.core.model.ade.ADEProperty;

public abstract class ADEOfGenericOccupiedSpace extends ADEProperty {

    @Override
    public final Class<GenericOccupiedSpace> getTargetType() {
        return GenericOccupiedSpace.class;
    }
}
