package org.citygml4j.model.building;

import org.citygml4j.model.core.AbstractThematicSurfaceProperty;
import org.citygml4j.model.core.AddressProperty;
import org.xmlobjects.gml.model.base.Reference;
import org.xmlobjects.gml.model.common.ChildList;

import java.util.List;

public class BuildingUnit extends AbstractBuildingSubdivision<AbstractThematicSurfaceProperty> {
    private List<Reference> storeys;
    private List<AddressProperty> addresses;
    private List<ADEPropertyOfBuildingUnit> adeProperties;

    public List<Reference> getStoreys() {
        if (storeys == null)
            storeys = new ChildList<>(this);

        return storeys;
    }

    public void setStoreys(List<Reference> storeys) {
        this.storeys = asChild(storeys);
    }

    public List<AddressProperty> getAddresses() {
        if (addresses == null)
            addresses = new ChildList<>(this);

        return addresses;
    }

    public void setAddresses(List<AddressProperty> addresses) {
        this.addresses = asChild(addresses);
    }

    public List<ADEPropertyOfBuildingUnit> getADEPropertiesOfBuildingUnit() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfBuildingUnit(List<ADEPropertyOfBuildingUnit> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
