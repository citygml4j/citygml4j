package org.citygml4j.model.waterbody;

import org.xmlobjects.model.ChildList;

import java.util.List;

public class WaterGroundSurface extends AbstractWaterBoundarySurface {
    private List<ADEPropertyOfWaterGroundSurface> adeProperties;

    public List<ADEPropertyOfWaterGroundSurface> getADEPropertiesOfWaterGroundSurface() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfWaterGroundSurface(List<ADEPropertyOfWaterGroundSurface> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
