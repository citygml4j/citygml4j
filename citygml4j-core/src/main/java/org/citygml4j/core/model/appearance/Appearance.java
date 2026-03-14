/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.appearance;

import org.citygml4j.core.model.core.AbstractAppearance;
import org.citygml4j.core.visitor.ObjectVisitor;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class Appearance extends AbstractAppearance {
    private String theme;
    private List<AbstractSurfaceDataProperty> surfaceData;

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public List<AbstractSurfaceDataProperty> getSurfaceData() {
        if (surfaceData == null)
            surfaceData = new ChildList<>(this);

        return surfaceData;
    }

    public boolean isSetSurfaceData() {
        return surfaceData != null && !surfaceData.isEmpty();
    }

    public void setSurfaceData(List<AbstractSurfaceDataProperty> surfaceData) {
        this.surfaceData = asChild(surfaceData);
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
