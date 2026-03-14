/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.relief;

import org.citygml4j.core.model.ade.ADEProperty;

public abstract class ADEOfReliefFeature extends ADEProperty {

    @Override
    public final Class<ReliefFeature> getTargetType() {
        return ReliefFeature.class;
    }
}
