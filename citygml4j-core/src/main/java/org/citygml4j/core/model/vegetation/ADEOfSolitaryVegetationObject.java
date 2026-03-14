/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.vegetation;

import org.citygml4j.core.model.ade.ADEProperty;

public abstract class ADEOfSolitaryVegetationObject extends ADEProperty {

    @Override
    public final Class<SolitaryVegetationObject> getTargetType() {
        return SolitaryVegetationObject.class;
    }
}
