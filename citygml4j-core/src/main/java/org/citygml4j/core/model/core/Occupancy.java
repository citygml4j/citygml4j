/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.core;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.basictypes.Code;

public class Occupancy extends GMLObject implements CityGMLObject {
    private Integer numberOfOccupants;
    private Code interval;
    private Code occupantType;

    public Occupancy() {
    }

    public Occupancy(Integer numberOfOccupants) {
        this.numberOfOccupants = numberOfOccupants;
    }

    public Integer getNumberOfOccupants() {
        return numberOfOccupants;
    }

    public void setNumberOfOccupants(Integer numberOfOccupants) {
        this.numberOfOccupants = numberOfOccupants;
    }

    public Code getInterval() {
        return interval;
    }

    public void setInterval(Code interval) {
        this.interval = asChild(interval);
    }

    public Code getOccupantType() {
        return occupantType;
    }

    public void setOccupantType(Code occupantType) {
        this.occupantType = asChild(occupantType);
    }
}
