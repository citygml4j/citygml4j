package org.citygml4j.model.construction;

import org.citygml4j.model.common.GeometryInfo;
import org.citygml4j.model.core.AbstractOccupiedSpace;
import org.citygml4j.model.core.AbstractSpaceBoundary;
import org.citygml4j.model.core.ClosureSurface;
import org.citygml4j.model.generics.GenericThematicSurface;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractInstallation extends AbstractOccupiedSpace {
    private RelationToConstruction relationToConstruction;
    private List<ADEOfAbstractInstallation> adeOfAbstractInstallation;

    @Override
    public boolean isValidBoundary(AbstractSpaceBoundary boundary) {
        return boundary instanceof AbstractConstructionSurface
                || boundary instanceof ClosureSurface
                || boundary instanceof GenericThematicSurface;
    }

    public RelationToConstruction getRelationToConstruction() {
        return relationToConstruction;
    }

    public void setRelationToConstruction(RelationToConstruction relationToConstruction) {
        this.relationToConstruction = relationToConstruction;
    }

    public List<ADEOfAbstractInstallation> getADEOfAbstractInstallation() {
        if (adeOfAbstractInstallation == null)
            adeOfAbstractInstallation = new ChildList<>(this);

        return adeOfAbstractInstallation;
    }

    public void setADEOfAbstractInstallation(List<ADEOfAbstractInstallation> adeOfAbstractInstallation) {
        this.adeOfAbstractInstallation = asChild(adeOfAbstractInstallation);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (adeOfAbstractInstallation != null) {
            for (ADEOfAbstractInstallation container : adeOfAbstractInstallation)
                updateEnvelope(container, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (adeProperties != null) {
            for (ADEOfAbstractInstallation<?> property : adeProperties)
                updateGeometryInfo(property, geometryInfo);
        }
    }
}
