/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.relief;

import org.citygml4j.core.model.core.AbstractSpaceBoundary;

public abstract class AbstractReliefComponent extends AbstractSpaceBoundary {
    private int lod;
    private ExtentProperty extent;

    public AbstractReliefComponent() {
    }

    public AbstractReliefComponent(int lod) {
        setLod(lod);
    }

    public int getLod() {
        return lod;
    }

    public void setLod(int lod) {
        if (lod >= 0)
            this.lod = lod;
    }

    public ExtentProperty getExtent() {
        return extent;
    }

    public void setExtent(ExtentProperty extent) {
        this.extent = asChild(extent);
    }
}
