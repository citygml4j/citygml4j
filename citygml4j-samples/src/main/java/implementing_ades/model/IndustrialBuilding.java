/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package implementing_ades.model;

import org.citygml4j.core.model.ade.ADEObject;
import org.citygml4j.core.model.building.Building;
import org.citygml4j.core.visitor.ObjectVisitor;

public class IndustrialBuilding extends Building implements ADEObject {
    private String remark;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit((ADEObject) this);
    }
}
