/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.core;

import org.citygml4j.core.model.ade.ADEProperty;

public abstract class ADEOfAbstractThematicSurface extends ADEProperty {

    @Override
    public final Class<AbstractThematicSurface> getTargetType() {
        return AbstractThematicSurface.class;
    }
}
