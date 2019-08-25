package org.citygml4j.model.building;

import org.citygml4j.model.core.BoundarySurfaceReference;
import org.xmlobjects.gml.model.base.Reference;
import org.xmlobjects.gml.model.common.ChildList;

import java.util.List;

public class Storey extends AbstractBuildingSubdivision {
    private List<BoundarySurfaceReference> boundarySurfaces;
    private List<Reference> buildingUnits;
    private List<ADEPropertyOfStorey> adeProperties;

    @Override
    public List<BoundarySurfaceReference> getBoundarySurfaces() {
        if (boundarySurfaces == null)
            boundarySurfaces = new ChildList<>(this);

        return boundarySurfaces;
    }

    public void setBoundarySurfaces(List<BoundarySurfaceReference> boundarySurfaces) {
        this.boundarySurfaces = asChild(boundarySurfaces);
    }

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
