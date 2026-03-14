/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.vegetation;

import org.citygml4j.core.model.core.AbstractOccupiedSpace;
import org.citygml4j.core.model.core.AbstractSpaceBoundary;

public abstract class AbstractVegetationObject extends AbstractOccupiedSpace {

    @Override
    public boolean isValidBoundary(Class<? extends AbstractSpaceBoundary> type) {
        return false;
    }
}
