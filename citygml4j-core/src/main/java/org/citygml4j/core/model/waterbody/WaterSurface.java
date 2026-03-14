/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.waterbody;

import org.citygml4j.core.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.basictypes.Code;

public class WaterSurface extends AbstractWaterBoundarySurface {
    private Code waterLevel;

    public Code getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(Code waterLevel) {
        this.waterLevel = asChild(waterLevel);
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
