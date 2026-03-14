/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.building;

import org.citygml4j.core.model.ade.ADEProperty;

public abstract class ADEOfAbstractBuilding extends ADEProperty {

    @Override
    public final Class<AbstractBuilding> getTargetType() {
        return AbstractBuilding.class;
    }
}
