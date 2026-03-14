/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.construction;

import org.citygml4j.core.model.ade.ADEProperty;

public abstract class ADEOfWindowSurface extends ADEProperty {

    @Override
    public final Class<WindowSurface> getTargetType() {
        return WindowSurface.class;
    }
}
