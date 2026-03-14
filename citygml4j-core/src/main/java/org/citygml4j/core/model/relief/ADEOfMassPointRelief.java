/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.relief;

import org.citygml4j.core.model.ade.ADEProperty;

public abstract class ADEOfMassPointRelief extends ADEProperty {

    @Override
    public final Class<MassPointRelief> getTargetType() {
        return MassPointRelief.class;
    }
}
