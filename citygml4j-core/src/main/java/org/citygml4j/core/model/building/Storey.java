/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.building;

import org.citygml4j.core.model.ade.ADEObject;
import org.citygml4j.core.model.construction.AbstractConstructionSurface;
import org.citygml4j.core.model.core.AbstractSpaceBoundary;
import org.citygml4j.core.model.core.ClosureSurface;
import org.citygml4j.core.model.generics.GenericThematicSurface;
import org.citygml4j.core.visitor.ObjectVisitor;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class Storey extends AbstractBuildingSubdivision {
    private List<BuildingUnitProperty> buildingUnits;

    @Override
    public boolean isValidBoundary(Class<? extends AbstractSpaceBoundary> type) {
        return AbstractConstructionSurface.class.isAssignableFrom(type)
                || ClosureSurface.class.isAssignableFrom(type)
                || GenericThematicSurface.class.isAssignableFrom(type)
                || ADEObject.class.isAssignableFrom(type);
    }

    public List<BuildingUnitProperty> getBuildingUnits() {
        if (buildingUnits == null)
            buildingUnits = new ChildList<>(this);

        return buildingUnits;
    }

    public boolean isSetBuildingUnits() {
        return buildingUnits != null && !buildingUnits.isEmpty();
    }

    public void setBuildingUnits(List<BuildingUnitProperty> buildingUnits) {
        this.buildingUnits = asChild(buildingUnits);
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
