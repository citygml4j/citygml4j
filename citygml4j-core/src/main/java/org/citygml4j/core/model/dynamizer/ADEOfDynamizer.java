/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.dynamizer;

import org.citygml4j.core.model.ade.ADEProperty;

public abstract class ADEOfDynamizer extends ADEProperty {

    @Override
    public final Class<Dynamizer> getTargetType() {
        return Dynamizer.class;
    }
}
