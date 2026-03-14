/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package implementing_ades.model;

import org.citygml4j.core.model.ade.ADEObject;
import org.xmlobjects.gml.model.base.AbstractGML;
import org.xmlobjects.gml.model.basictypes.Measure;

public class Facility extends AbstractGML implements ADEObject {
    private Measure electricalPower;

    public Measure getElectricalPower() {
        return electricalPower;
    }

    public void setElectricalPower(Measure electricalPower) {
        this.electricalPower = asChild(electricalPower);
    }
}
