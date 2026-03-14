/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.bridge;

import org.citygml4j.core.model.ade.ADEProperty;

public abstract class ADEOfBridgeInstallation extends ADEProperty {

    @Override
    public final Class<BridgeInstallation> getTargetType() {
        return BridgeInstallation.class;
    }
}
