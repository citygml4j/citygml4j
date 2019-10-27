package org.citygml4j.model.waterbody;

import org.xmlobjects.gml.model.common.ChildList;

import java.util.List;

public class WaterClosureSurface extends AbstractWaterBoundarySurface {
    private List<ADEPropertyOfWaterClosureSurface> adeProperties;

    public List<ADEPropertyOfWaterClosureSurface> getADEPropertiesOfWaterClosureSurface() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfWaterClosureSurface(List<ADEPropertyOfWaterClosureSurface> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
