/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.appearance;

import org.citygml4j.core.model.ade.ADEProperty;

public abstract class ADEOfX3DMaterial extends ADEProperty {

    @Override
    public final Class<X3DMaterial> getTargetType() {
        return X3DMaterial.class;
    }
}
