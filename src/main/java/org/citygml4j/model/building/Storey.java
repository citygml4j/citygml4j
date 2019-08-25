package org.citygml4j.model.building;

import org.citygml4j.model.core.BoundarySurfaceReference;
import org.xmlobjects.gml.model.base.Reference;
import org.xmlobjects.gml.model.common.ChildList;

import java.util.List;

public class Storey extends AbstractBuildingSubdivision<BoundarySurfaceReference> {
    private List<Reference> buildingUnits;
    private List<ADEPropertyOfStorey> adeProperties;

    public List<Reference> getBuildingUnits() {
        if (buildingUnits == null)
            buildingUnits = new ChildList<>(this);

        return buildingUnits;
    }

    public void setBuildingUnits(List<Reference> buildingUnits) {
        this.buildingUnits = asChild(buildingUnits);
    }

    public List<ADEPropertyOfStorey> getADEPropertiesOfStorey() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfStorey(List<ADEPropertyOfStorey> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
