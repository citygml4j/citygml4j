package org.citygml4j.model.waterbody;

import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class WaterSurface extends AbstractWaterBoundarySurface {
    private Code waterLevel;
    private List<ADEPropertyOfWaterSurface<?>> adeProperties;

    public Code getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(Code waterLevel) {
        this.waterLevel = asChild(waterLevel);
    }

    public List<ADEPropertyOfWaterSurface<?>> getADEPropertiesOfWaterSurface() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfWaterSurface(List<ADEPropertyOfWaterSurface<?>> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
