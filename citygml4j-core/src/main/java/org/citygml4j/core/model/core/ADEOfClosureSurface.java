/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.core;

import org.citygml4j.core.model.ade.ADEProperty;

public abstract class ADEOfClosureSurface extends ADEProperty {

    @Override
    public final Class<ClosureSurface> getTargetType() {
        return ClosureSurface.class;
    }
}
