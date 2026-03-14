/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.generics;

import org.citygml4j.core.model.ade.ADEProperty;

public abstract class ADEOfGenericUnoccupiedSpace extends ADEProperty {

    @Override
    public final Class<GenericUnoccupiedSpace> getTargetType() {
        return GenericUnoccupiedSpace.class;
    }
}
