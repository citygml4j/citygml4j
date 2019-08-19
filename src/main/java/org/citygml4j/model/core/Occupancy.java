package org.citygml4j.model.core;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.base.AbstractGML;
import org.xmlobjects.gml.model.base.Reference;

public class Occupancy extends AbstractGML implements CityGMLObject {
    private Integer numberOfOccupants;
    private Reference interval;
    private Reference occupantType;

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

    public Reference getInterval() {
        return interval;
    }

    public void setInterval(Reference interval) {
        this.interval = asChild(interval);
    }

    public Reference getOccupantType() {
        return occupantType;
    }

    public void setOccupantType(Reference occupantType) {
        this.occupantType = asChild(occupantType);
    }
}
