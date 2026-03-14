/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.appearance;

import org.citygml4j.core.model.core.AbstractFeature;

public abstract class AbstractSurfaceData extends AbstractFeature {
    private Boolean isFront;

    public Boolean getIsFront() {
        return isFront != null ? isFront : true;
    }

    public boolean isSetIsFront() {
        return isFront != null;
    }

    public void setIsFront(Boolean front) {
        isFront = front;
    }
}
