package org.citygml4j.model.construction;

import org.citygml4j.model.core.AbstractOccupiedSpace;
import org.citygml4j.model.core.SpaceBoundaryProperty;
import org.xmlobjects.gml.model.common.ChildList;

import java.util.List;

public abstract class AbstractInstallation<T extends SpaceBoundaryProperty> extends AbstractOccupiedSpace<T> {
    private RelationToConstruction relationToConstruction;
    private List<ADEPropertyOfAbstractInstallation> adeProperties;

    public RelationToConstruction getRelationToConstruction() {
        return relationToConstruction;
    }

    public void setRelationToConstruction(RelationToConstruction relationToConstruction) {
        this.relationToConstruction = relationToConstruction;
    }

    public List<ADEPropertyOfAbstractInstallation> getADEPropertyOfAbstractInstallation() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertyOfAbstractInstallation(List<ADEPropertyOfAbstractInstallation> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
