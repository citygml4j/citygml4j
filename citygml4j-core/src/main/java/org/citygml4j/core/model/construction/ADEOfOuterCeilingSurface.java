/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.construction;

import org.citygml4j.core.model.ade.ADEProperty;

public abstract class ADEOfOuterCeilingSurface extends ADEProperty {

    @Override
    public final Class<OuterCeilingSurface> getTargetType() {
        return OuterCeilingSurface.class;
    }
}
