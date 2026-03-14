/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package implementing_ades.model;

import org.xmlobjects.model.ChildList;

import java.util.List;

public class BuildingUnderground extends AbstractBuildingUnderground {
    private List<BuildingUndergroundPartProperty> consistsOf;

    public List<BuildingUndergroundPartProperty> getConsistsOf() {
        if (consistsOf == null) {
            return new ChildList<>(this);
        }

        return consistsOf;
    }

    public boolean isSetConsistsOf() {
        return consistsOf != null && !consistsOf.isEmpty();
    }

    public void setConsistsOf(List<BuildingUndergroundPartProperty> consistsOf) {
        this.consistsOf = asChild(consistsOf);
    }
}
