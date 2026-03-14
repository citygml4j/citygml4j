/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.deprecated.transportation;

import org.citygml4j.core.model.ade.ADEProperty;

public abstract class ADEOfTransportationComplex extends ADEProperty {

    @Override
    public final Class<TransportationComplex> getTargetType() {
        return TransportationComplex.class;
    }
}
