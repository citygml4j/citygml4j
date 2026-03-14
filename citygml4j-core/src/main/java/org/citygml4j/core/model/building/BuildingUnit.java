/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.building;

import org.citygml4j.core.model.ade.ADEObject;
import org.citygml4j.core.model.core.AbstractSpaceBoundary;
import org.citygml4j.core.model.core.AddressProperty;
import org.citygml4j.core.model.core.ClosureSurface;
import org.citygml4j.core.model.generics.GenericThematicSurface;
import org.citygml4j.core.visitor.ObjectVisitor;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class BuildingUnit extends AbstractBuildingSubdivision {
    private List<StoreyProperty> storeys;
    private List<AddressProperty> addresses;

    @Override
    public boolean isValidBoundary(Class<? extends AbstractSpaceBoundary> type) {
        return ClosureSurface.class.isAssignableFrom(type)
                || GenericThematicSurface.class.isAssignableFrom(type)
                || ADEObject.class.isAssignableFrom(type);
    }

    public List<StoreyProperty> getStoreys() {
        if (storeys == null)
            storeys = new ChildList<>(this);

        return storeys;
    }

    public boolean isSetStoreys() {
        return storeys != null && !storeys.isEmpty();
    }

    public void setStoreys(List<StoreyProperty> storeys) {
        this.storeys = asChild(storeys);
    }

    public List<AddressProperty> getAddresses() {
        if (addresses == null)
            addresses = new ChildList<>(this);

        return addresses;
    }

    public boolean isSetAddresses() {
        return addresses != null && !addresses.isEmpty();
    }

    public void setAddresses(List<AddressProperty> addresses) {
        this.addresses = asChild(addresses);
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
