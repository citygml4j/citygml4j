/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.transportation;

import org.citygml4j.core.model.core.AbstractThematicSurface;
import org.citygml4j.core.visitor.ObjectVisitor;

public class HoleSurface extends AbstractThematicSurface {

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
