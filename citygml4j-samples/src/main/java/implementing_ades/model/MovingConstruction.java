/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package implementing_ades.model;

import org.citygml4j.core.model.ade.ADEObject;
import org.citygml4j.core.model.construction.OtherConstruction;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class MovingConstruction extends OtherConstruction implements ADEObject {
    private String remark;
    private List<SolarRoofSurfaceProperty> coveredBy;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<SolarRoofSurfaceProperty> getCoveredBy() {
        if (coveredBy == null) {
            coveredBy = new ChildList<>(this);
        }

        return coveredBy;
    }

    public boolean isSetCoveredBy() {
        return coveredBy != null && !coveredBy.isEmpty();
    }

    public void setCoveredBy(List<SolarRoofSurfaceProperty> coveredBy) {
        this.coveredBy = asChild(coveredBy);
    }
}
