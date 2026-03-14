/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.versioning;

import org.citygml4j.core.model.ade.ADEProperty;

public abstract class ADEOfVersionTransition extends ADEProperty {

    @Override
    public final Class<VersionTransition> getTargetType() {
        return VersionTransition.class;
    }
}
