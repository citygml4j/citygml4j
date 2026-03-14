/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.transportation;

import org.citygml4j.core.model.ade.ADEProperty;

public abstract class ADEOfTrafficSpace extends ADEProperty {

    @Override
    public final Class<TrafficSpace> getTargetType() {
        return TrafficSpace.class;
    }
}
