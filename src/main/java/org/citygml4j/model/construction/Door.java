package org.citygml4j.model.construction;

import org.citygml4j.model.core.AbstractThematicSurface;
import org.citygml4j.model.core.AddressProperty;
import org.citygml4j.model.core.ClosureSurface;
import org.citygml4j.model.generics.GenericThematicSurface;
import org.xmlobjects.gml.model.common.ChildList;

import java.util.List;

public class Door extends AbstractFillingElement {
    private List<AddressProperty> addresses;
    private List<ADEPropertyOfDoor> adeProperties;

    @Override
    public boolean isValidBoundarySurface(AbstractThematicSurface boundarySurface) {
        return boundarySurface instanceof DoorSurface
                || boundarySurface instanceof ClosureSurface
                || boundarySurface instanceof GenericThematicSurface;
    }

    public List<AddressProperty> getAddresses() {
        if (addresses == null)
            addresses = new ChildList<>(this);

        return addresses;
    }

    public void setAddresses(List<AddressProperty> addresses) {
        this.addresses = asChild(addresses);
    }

    public List<ADEPropertyOfDoor> getADEPropertiesOfDoor() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfDoor(List<ADEPropertyOfDoor> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
